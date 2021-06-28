package histopatologialab.consultas;

import histopatologialab.consultas.controller.IConsultaController;
import histopatologialab.consultas.dto.Examen;
import histopatologialab.core.JsonResponse;
import histopatologialab.core.RequestAction;
import histopatologialab.pacientes.dto.Paciente;
import org.tinylog.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static histopatologialab.core.Controllers.consultaController;
import static histopatologialab.core.Controllers.pacienteController;
import static histopatologialab.core.ServletHelper.*;

@WebServlet(name = "ConsultaServlet")
public class ConsultaServlet extends HttpServlet {
    private final IConsultaController controller = consultaController;

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
            handleGetCreateWithPaciente(request, response);
        } else {
            getDefaultPage(request, response);
        }
    }

    private void handlePostModificarExamen(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }

    private void handlePostCreateExamen(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String examenJson = request.getParameter("examen");
        Logger.info(examenJson);
        Examen examen = jackson.readValue(examenJson, Examen.class);
        if (examen == null) {
            Logger.error("error parsing examen request");
        }
        examen.setDoctorExamen(getIdUsuarioFromSession(request));

        JsonResponse<Examen> examenGuardado =  controller.guardarExamen(examen);
        Logger.info(jackson.writeValueAsString(examenGuardado));
        returnJson(response, examenGuardado);
    }

    private void handleGetCreateWithPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codExamen = request.getParameter("cod_examen");
        String codPaciente = request.getParameter("cod_paciente");

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
        getCreateConsultaPage(request, response);
    }

    private void getCreateConsultaPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tipoOpcion", controller.getOpciones().getData());
        RequestDispatcher despachador = request.getRequestDispatcher("consulta/crear-consulta.jsp");
        despachador.forward(request, response);
    }


    private void getDefaultPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("examenes", controller.getExamenes());
        RequestDispatcher despachador = request.getRequestDispatcher("consulta/consulta.jsp");
        despachador.forward(request, response);
    }

}
