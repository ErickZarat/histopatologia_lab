package histopatologialab.medicamentos;

import histopatologialab.core.JsonResponse;
import histopatologialab.core.RequestAction;
import histopatologialab.medicamentos.controller.IMedicamentosController;
import histopatologialab.medicamentos.dto.Medicamento;
import org.tinylog.Logger;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        RequestAction action = getRequestAction(request);

        if (action == RequestAction.LISTAR_JSON) {
            getJsonMedicamentos(request, response);
        } else {
            getDefaultPage(request, response);
        }
    }

    private void getJsonMedicamentos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int lastMedicamentoItem = Integer.parseInt(request.getParameter("lastMedicamento"));
        List<Medicamento> medicamentoList = controller.getMedicamentos(lastMedicamentoItem);
        toJsonResponse(response, new JsonResponse<List<Medicamento>>(medicamentoList != null, medicamentoList));
    }

    private void getDefaultPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Medicamento> medicamentoList = controller.getMedicamentos(null);
        request.setAttribute("medicamentos",medicamentoList);
        request.setAttribute("lastMedicamentoItem", medicamentoList.get(medicamentoList.size() - 1).getCodigoMedicamento());
        Logger.info("medicamentos " + medicamentoList.size() + " " + medicamentoList);
        Logger.info("set medicamento to session" + medicamentoList.get(medicamentoList.size() - 1).getCodigoMedicamento());
        RequestDispatcher despachador = request.getRequestDispatcher("mantenimientos/medicamentos.jsp");
        despachador.forward(request, response);
    }

    private void crearMedicamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("nombre");
        String tipoMedicamento = request.getParameter("tipoMedicamento");
        String usuario = getUsuarioFromSession(request);

        Medicamento medicamento = controller.crearMedicamento(nombre, tipoMedicamento, usuario);
        toJsonResponse(response, new JsonResponse<Medicamento>(medicamento != null, medicamento));
    }

    private void modificarMedicamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigoMedicamento"));
        String nombre = request.getParameter("nombre");
        String usuario = getUsuarioFromSession(request);

        Medicamento medicamento = controller.modificarMedicamento(codigo, nombre, usuario);
        toJsonResponse(response, new JsonResponse<>(medicamento != null, medicamento));
    }

    private void darBajaMedicamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigoMedicamento"));
        String usuario = getUsuarioFromSession(request);
        boolean success = controller.darBajaMedicamento(codigo, usuario);
        toJsonResponse(response, new JsonResponse<Boolean>(success, success));
    }
}
