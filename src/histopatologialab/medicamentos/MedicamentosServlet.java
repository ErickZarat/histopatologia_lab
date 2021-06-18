package histopatologialab.medicamentos;

import histopatologialab.core.JsonResponse;
import histopatologialab.core.RequestAction;
import histopatologialab.medicamentos.controller.IMedicamentosController;
import histopatologialab.medicamentos.dto.Medicamento;
import histopatologialab.medicamentos.dto.TipoMedicamento;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static histopatologialab.core.ServletHelper.*;
import static histopatologialab.core.Controllers.medicamentosController;

@WebServlet(name = "MedicamentosServlet")
public class MedicamentosServlet extends HttpServlet {
    IMedicamentosController controller = medicamentosController;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        checkSession(request, response);

        RequestAction action = getRequestAction(request);

        if (action == RequestAction.CREAR) {
           crearMedicamento(request, response);
        } else if (action == RequestAction.MODIFICAR) {
            modificarMedicamento(request, response);
        } else if (action == RequestAction.DAR_BAJA) {
            darBajaMedicamento(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkSession(request, response);

        RequestAction action = getRequestAction(request);
        if (action == RequestAction.LISTAR_JSON) {
            getJsonMedicamentos(request, response);
        } else {
            getDefaultPage(request, response);
        }
    }

    private void getJsonMedicamentos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int tipoMedicamento = Integer.parseInt(request.getParameter("tipoMedicamento"));
        JsonResponse<List<Medicamento>> medicamentoList = controller.getMedicamentos(tipoMedicamento);
        returnJson(response, medicamentoList);
    }

    private void getDefaultPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tiposMedicamento", TipoMedicamento.values());
        RequestDispatcher despachador = request.getRequestDispatcher("mantenimientos/medicamentos.jsp");
        despachador.forward(request, response);
    }

    private void crearMedicamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("nombre");
        int tipoMedicamento = Integer.parseInt(request.getParameter("tipoMedicamento"));
        String usuario = getUsuarioFromSession(request);

        JsonResponse<Medicamento> medicamento = controller.crearMedicamento(nombre, tipoMedicamento, usuario);
        returnJson(response, medicamento);
    }

    private void modificarMedicamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigoMedicamento"));
        String nombre = request.getParameter("nombreMedicamento");
        String usuario = getUsuarioFromSession(request);

        JsonResponse<Medicamento> medicamento = controller.modificarMedicamento(codigo, nombre, usuario);
        returnJson(response, medicamento);
    }

    private void darBajaMedicamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigoMedicamento"));
        String usuario = getUsuarioFromSession(request);
        JsonResponse<Boolean> success = controller.darBajaMedicamento(codigo, usuario);
        returnJson(response, success);
    }
}
