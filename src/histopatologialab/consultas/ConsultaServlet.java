package histopatologialab.consultas;

import histopatologialab.consultas.controller.IConsultaController;
import histopatologialab.consultas.dto.Examen;
import histopatologialab.core.RequestAction;
import histopatologialab.pacientes.dto.Paciente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static histopatologialab.core.Controllers.consultaController;
import static histopatologialab.core.Controllers.pacienteController;
import static histopatologialab.core.ServletHelper.checkSession;
import static histopatologialab.core.ServletHelper.getRequestAction;

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

    }

    private void handleGetCreateWithPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codPaciente = request.getParameter("cod_paciente");

        Paciente paciente = null;

        try {
            paciente = pacienteController.getPacienteByCodigo(Long.parseLong(codPaciente)).getData();
        } catch (Exception e) {

        }

        if (paciente == null) {
            paciente = new Paciente();
        }
        request.setAttribute("paciente", paciente);

        String codExamen = request.getParameter("cod_examen");

        Examen examen = null;

        try {
            examen = consultaController.getExamen(Integer.parseInt(codExamen));
        } catch (Exception e) {

        }

        if (examen == null) {
            examen = new Examen();
        }
        request.setAttribute("examen", examen);


        getCreateConsultaPage(request, response);
    }

    private void getCreateConsultaPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tipoOpcion", controller.getOpciones());
        RequestDispatcher despachador = request.getRequestDispatcher("consulta/crear-consulta.jsp");
        despachador.forward(request, response);
    }


    private void getDefaultPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("examenes", controller.getExamenes());
        RequestDispatcher despachador = request.getRequestDispatcher("consulta/consulta.jsp");
        despachador.forward(request, response);
    }

}
