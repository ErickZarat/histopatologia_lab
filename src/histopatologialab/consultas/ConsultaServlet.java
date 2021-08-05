package histopatologialab.consultas;

import histopatologialab.biopsia.controller.IBiopsiaController;
import histopatologialab.biopsia.dto.Biopsia;
import histopatologialab.consultas.controller.IConsultaController;
import histopatologialab.consultas.dto.Examen;
import histopatologialab.core.Controllers;
import histopatologialab.core.JsonResponse;
import histopatologialab.core.RequestAction;
import histopatologialab.diagnostico.controller.IDiagnosticoController;
import histopatologialab.enfsistemica.controller.IEnfSistemicaController;
import histopatologialab.frote.controller.IFroteController;
import histopatologialab.frote.dto.Frote;
import histopatologialab.informe.controller.IInformeController;
import histopatologialab.informe.dto.Informe;
import histopatologialab.pacientes.dto.Paciente;
import org.tinylog.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static histopatologialab.core.Controllers.*;
import static histopatologialab.core.DateUtils.formatDate;
import static histopatologialab.core.ServletHelper.*;

@WebServlet(name = "ConsultaServlet")
public class ConsultaServlet extends HttpServlet {
    private final IConsultaController controller = consultaController;
    private final IEnfSistemicaController enfSistemicaController = enfsistemicaController;
    private final IDiagnosticoController diagnosticoController = Controllers.diagnosticoController;
    private final IBiopsiaController biopsiaController = Controllers.biopsiaController;
    private final IFroteController froteController = Controllers.froteController;
    private final IInformeController informeController = Controllers.informeController;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        checkSession(request, response);

        RequestAction action = getRequestAction(request);

        if (action == RequestAction.CREAR) {
            handlePostCreateExamen(request, response);
        } else if (action == RequestAction.MODIFICAR) {
            handlePostModificarExamen(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkSession(request, response);

        RequestAction action = getRequestAction(request);

        if (action == RequestAction.CREAR || action == RequestAction.VER) {
            handleGetCreateWithPaciente(request, response, action);
        } else if (action == RequestAction.LISTAR_JSON) {
            handleGetConsultas(request, response);
        } else if (action == RequestAction.DESCARGAR_INFORME){
            handleDescargarInforme(request, response);
        } else {
            getDefaultPage(request, response);
        }
    }

    private void handleDescargarInforme(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codExamen = request.getParameter("codExamen");
        String tipo = request.getParameter("tipo");

        Examen examen = consultaController.getExamen(Integer.parseInt(codExamen)).getData();
        String codPaciente = String.valueOf(examen.getCodPaciente());
        Paciente paciente = pacienteController.getPacienteByCodigo(Long.parseLong(codPaciente)).getData();

        request.setAttribute("paciente", paciente);
        request.setAttribute("examen", examen);
        request.setAttribute("fechaExamen", formatDate(examen.getFechaExamen()));

        RequestDispatcher despachador = null;

        if (examen != null) {
            try {
                request.setAttribute("tipoOpcion", controller.getOpciones(false).getData());

                if (tipo.equals("biopsia")) {
                    despachador = request.getRequestDispatcher("consulta/biopsia/informe-pdf.jsp");
                    List<Biopsia> biopsias = biopsiaController.getBiopsiasByExamen(examen.getCodExamen()).getData();
                    Biopsia biopsia = null;
                    if (biopsias != null && biopsias.size() >= 1) biopsia = biopsias.get(0);
                    if (biopsia != null) {
                        request.setAttribute("biopsia", biopsia);
                        Informe infBiopsia = informeController.getInformeByBiopsia(biopsia.getCodBiopsia()).getData();
                        if (infBiopsia != null) {
                            request.setAttribute("informeBiopsia", infBiopsia);
                            request.setAttribute("diagnosticoBiopsia", infBiopsia.getDiagnostico());
                            request.setAttribute("doc", usuarioController.getUsuario((long) infBiopsia.getUsuarioInforme()).getData());
                        }
                    }
                } else if (tipo.equals("frote")) {
                    despachador = request.getRequestDispatcher("consulta/frote/informe-pdf.jsp");
                    List<Frote> frotes = froteController.getFrotesByExamen(examen.getCodExamen()).getData();
                    Frote frote = null;
                    if (frotes != null && frotes.size() >= 1) frote = frotes.get(0);
                    if (frote != null) {
                        request.setAttribute("frote", frote);
                        Informe infFrote = informeController.getInformeByFrote(frote.getCodFrote()).getData();
                        if (infFrote != null) {
                            request.setAttribute("informeFrote", infFrote);
                            request.setAttribute("diagnosticoBiopsia", infFrote.getDiagnostico());
                            request.setAttribute("doc", usuarioController.getUsuario((long) infFrote.getUsuarioInforme()).getData());
                        }
                    }
                } else if (tipo.equals("receta")) {
                    despachador = request.getRequestDispatcher("consulta/frote/informe-pdf.jsp");

                }
            } catch (Exception e) {
                Logger.info("error getting examen childs");
                e.printStackTrace();
            }
        } else
            request.setAttribute("tipoOpcion", controller.getOpciones(true).getData());

        request.setAttribute("enfermedades", enfSistemicaController.getEnfermedadesSistemicas().getData());
        request.setAttribute("diagnosticos", diagnosticoController.getDiagnosticos().getData());

        if (despachador != null)
            despachador.forward(request, response);
    }

    private void handleGetConsultas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        returnJson(response, controller.getExamenes());
    }

    private void handlePostModificarExamen(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }

    private void handlePostCreateExamen(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String examenJson = request.getParameter("examen");
        Examen examen = jackson.readValue(examenJson, Examen.class);
        if (examen == null) {
            Logger.error("error parsing examen request");
        }
        examen.setDoctorExamen(getIdUsuarioFromSession(request));

        JsonResponse<Examen> examenGuardado =  controller.guardarExamen(examen);
        returnJson(response, examenGuardado);
    }

    private void handleGetCreateWithPaciente(HttpServletRequest request, HttpServletResponse response, RequestAction requestAction) throws ServletException, IOException {
        String codExamen = request.getParameter("codExamen");
        String codPaciente = request.getParameter("codPaciente");

        Examen examen = null;

        if (codExamen != null) {
            examen = consultaController.getExamen(Integer.parseInt(codExamen)).getData();
            if (examen == null) {
                examen = new Examen();
            } else {
                codPaciente = String.valueOf(examen.getCodPaciente());
            }
        }

        Paciente paciente = null;

        if (codPaciente != null) {
            paciente = pacienteController.getPacienteByCodigo(Long.parseLong(codPaciente)).getData();
            if (paciente == null) {
                paciente = new Paciente();
            }
        }

        request.setAttribute("paciente", paciente != null? paciente : new Paciente());
        request.setAttribute("examen", examen != null? examen: new Examen());
        request.setAttribute("fechaExamen", examen != null? formatDate(examen.getFechaExamen()): "");
        request.setAttribute("action", requestAction.name());

        if (examen != null) {
            try {
                request.setAttribute("tipoOpcion", controller.getOpciones(false).getData());
                request.setAttribute("codExamen", examen.getCodExamen());
                List<Biopsia> biopsias = biopsiaController.getBiopsiasByExamen(examen.getCodExamen()).getData();
                Biopsia biopsia = null;
                if (biopsias != null && biopsias.size() >= 1) biopsia = biopsias.get(0);
                if (biopsia != null) {
                    request.setAttribute("biopsia", biopsia);
                    request.setAttribute("codBiopsia", biopsia.getCodBiopsia());
                    Informe infBiopsia = informeController.getInformeByBiopsia(biopsia.getCodBiopsia()).getData();
                    if (infBiopsia != null) {
                        request.setAttribute("informeBiopsia", infBiopsia);
                        request.setAttribute("codInformeBiopsia", infBiopsia.getCodInforme());
                        request.setAttribute("diagnosticoBiopsia", infBiopsia.getDiagnostico());
                    }
                }

                List<Frote> frotes = froteController.getFrotesByExamen(examen.getCodExamen()).getData();
                Frote frote = null;
                if (frotes != null && frotes.size() >= 1) frote = frotes.get(0);

                if (frote != null) {
                    request.setAttribute("frote", frote);
                    request.setAttribute("codFrote", frote.getCodFrote());
                    Informe infFrote = informeController.getInformeByFrote(frote.getCodFrote()).getData();
                    if(infFrote != null) {
                        request.setAttribute("codInformeFrote", infFrote.getCodInforme());
                        request.setAttribute("informeFrote", infFrote);
                        request.setAttribute("diagnosticoBiopsia", infFrote.getDiagnostico());
                    }
                }
            } catch (Exception e) {
                Logger.info("error getting examen childs");
                e.printStackTrace();
            }
        } else
            request.setAttribute("tipoOpcion", controller.getOpciones(true).getData());
        getCreateConsultaPage(request, response);
    }

    private void getCreateConsultaPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("enfermedades", enfSistemicaController.getEnfermedadesSistemicas().getData());
        request.setAttribute("tinciones", tincionController.getTinciones().getData());
        request.setAttribute("diagnosticos", diagnosticoController.getDiagnosticosHabilitados().getData());
        RequestDispatcher despachador = request.getRequestDispatcher("consulta/crear-consulta.jsp");
        despachador.forward(request, response);
    }


    private void getDefaultPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("examenes", controller.getExamenes());
        RequestDispatcher despachador = request.getRequestDispatcher("consulta/consulta.jsp");
        despachador.forward(request, response);
    }

}
