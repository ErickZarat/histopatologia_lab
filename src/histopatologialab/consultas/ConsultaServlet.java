package histopatologialab.consultas;

import histopatologialab.consultas.controller.ConsultaController;
import histopatologialab.core.RequestAction;
import histopatologialab.medicamentos.dto.TipoMedicamento;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static histopatologialab.core.ServletHelper.checkSession;
import static histopatologialab.core.ServletHelper.getRequestAction;

import static histopatologialab.core.Controllers.consultaController;

@WebServlet(name = "ConsultaServlet")
public class ConsultaServlet extends HttpServlet {
    private final ConsultaController controller = consultaController;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        checkSession(request, response);

        RequestAction action = getRequestAction(request);

        if (action == RequestAction.CREAR) {

        } else if (action == RequestAction.MODIFICAR) {

        } else if (action == RequestAction.DAR_BAJA) {

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkSession(request, response);

        RequestAction action = getRequestAction(request);

        if (action == RequestAction.CREAR) {
            getCreateConsultaPage(request, response);
        } else if (action == RequestAction.LISTAR_JSON) {

        } else {
            getDefaultPage(request, response);
        }
    }

    private void getCreateConsultaPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tipoOpcion", controller.getOpciones());
        RequestDispatcher despachador = request.getRequestDispatcher("consulta/crear-consulta.jsp");
        despachador.forward(request, response);
    }


    private void getDefaultPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher despachador = request.getRequestDispatcher("consulta/consulta.jsp");
        despachador.forward(request, response);
    }

}
