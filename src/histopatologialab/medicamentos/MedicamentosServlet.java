package histopatologialab.medicamentos;

import histopatologialab.core.JsonResponse;
import histopatologialab.core.RequestAction;
import histopatologialab.core.ServletHelper;
import histopatologialab.medicamentos.controller.IMedicamentosController;
import histopatologialab.medicamentos.controller.MedicamentosControllerImpl;
import histopatologialab.medicamentos.dao.IMedicamentosDao;
import histopatologialab.medicamentos.dao.IPresentacionMedicamentosDao;
import histopatologialab.medicamentos.dao.MedicamentosDaoImpl;
import histopatologialab.medicamentos.dao.PresentacionMedicamentosDaoImpl;
import histopatologialab.medicamentos.dto.Medicamento;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MedicamentosServlet")
public class MedicamentosServlet extends HttpServlet {
    private final IMedicamentosDao medicamentosDao = new MedicamentosDaoImpl();
    private final IPresentacionMedicamentosDao presentacionDao = new PresentacionMedicamentosDaoImpl();
    private final IMedicamentosController controller = new MedicamentosControllerImpl(medicamentosDao, presentacionDao);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestAction action = ServletHelper.getRequestAction(request);

        if (action == RequestAction.CREAR) {
           crearMedicamento(request, response);
        } else if (action == RequestAction.MODIFICAR) {
            modificarMedicamento(request, response);
        } else if (action == RequestAction.DAR_BAJA) {
            darBajaMedicamento(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestAction action = ServletHelper.getRequestAction(request);

        if (action == RequestAction.LISTAR_JSON) {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            ServletHelper.toJsonResponse(response, controller.obtenerPresentaciones(codigo));
        } else {
            request.setAttribute("medicamentos", medicamentosDao.getMedicamentos(5));
            RequestDispatcher despachador = getDefultDispatcher(request);
            despachador.forward(request, response);
        }
    }

    private RequestDispatcher getDefultDispatcher(HttpServletRequest request) {
        return request.getRequestDispatcher("mantenimientos/medicamentos.jsp");
    }

    private void crearMedicamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String tipoMedicamento = request.getParameter("tipoMedicamento");
        String usuario = ServletHelper.getUsuario(request);

        Medicamento medicamento = controller.crearMedicamento(nombre, tipoMedicamento, usuario);
        ServletHelper.toJsonResponse(response, new JsonResponse<Medicamento>(medicamento != null, medicamento));
    }

    private void modificarMedicamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigoMedicamento"));
        String nombre = request.getParameter("nombre");
        String usuario = ServletHelper.getUsuario(request);

        Medicamento medicamento = controller.modificarMedicamento(codigo, nombre, usuario);
        ServletHelper.toJsonResponse(response, new JsonResponse<>(medicamento != null, medicamento));
    }

    private void darBajaMedicamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigoMedicamento"));
        String usuario = ServletHelper.getUsuario(request);
        controller.darBajaMedicamento(codigo, usuario);

    }
}
