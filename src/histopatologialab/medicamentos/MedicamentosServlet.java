package histopatologialab.medicamentos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import histopatologialab.core.JsonResponse;
import histopatologialab.core.RequestAction;
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
import java.io.PrintWriter;

@WebServlet(name = "MedicamentosServlet")
public class MedicamentosServlet extends HttpServlet {
    IMedicamentosDao medicamentosDao = new MedicamentosDaoImpl();
    IPresentacionMedicamentosDao presentacionDao = new PresentacionMedicamentosDaoImpl();
    IMedicamentosController controller = new MedicamentosControllerImpl(medicamentosDao, presentacionDao);
    ObjectMapper jackson = new ObjectMapper();


    public MedicamentosServlet() {
        jackson.registerModule(new JSR310Module());
        jackson.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestAction action = RequestAction.valueOf(request.getParameter("accion"));

        if (action == RequestAction.CREAR) {
           crearMedicamento(request, response);
        } else if (action == RequestAction.MODIFICAR) {
            modificarMedicamento(request, response);
        } else if (action == RequestAction.DAR_BAJA) {
            darBajaMedicamento(request, response);
        }
    }

    private <T> void toJsonResponse(HttpServletResponse response, T object) throws IOException {
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter printout = response.getWriter();

        String respuesta = jackson.writeValueAsString(object);
        printout.print(respuesta);
        printout.flush();
    }

    private RequestDispatcher getDefultDispatcher(HttpServletRequest request) {
        return request.getRequestDispatcher("mantenimientos/medicamentos.jsp");
    }

    private void crearMedicamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String tipoMedicamento = request.getParameter("tipoMedicamento");
        String usuario = getUsuario(request);

        Medicamento medicamento = controller.crearMedicamento(nombre, tipoMedicamento, usuario);
        toJsonResponse(response, new JsonResponse<Medicamento>(medicamento != null, medicamento));
    }

    private String getUsuario(HttpServletRequest request) {
        Object usuario = request
                .getSession(true)
                .getAttribute("usuario");

        if (usuario == null) {
            usuario = "DEFAULT";
        }
        return usuario.toString();
    }

    private void modificarMedicamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigoMedicamento"));
        String nombre = request.getParameter("nombre");
        String usuario = getUsuario(request);

        Medicamento medicamento = controller.modificarMedicamento(codigo, nombre, usuario);
        toJsonResponse(response, new JsonResponse<>(medicamento != null, medicamento));
    }

    private void darBajaMedicamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigoMedicamento"));
        String usuario = getUsuario(request);

    }

    private RequestAction getRequestAction(HttpServletRequest request) {
        String action = request.getParameter("accion");
        RequestAction requestAction = RequestAction.DEFAULT;
        if (action != null) requestAction =  RequestAction.valueOf(action);
        return requestAction;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int codigoMedicamento, String nombreMedicamento, String estado, String creadoPor, LocalDate fechaCreacion, String modificadoPor, LocalDate fechaModificacion

        RequestAction action = getRequestAction(request);

        if (action == RequestAction.CREAR) {


        } else if (action == RequestAction.MODIFICAR) {

        } else if (action == RequestAction.LISTAR_JSON) {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            toJsonResponse(response, controller.obtenerPresentaciones(codigo));
        } else {
            request.setAttribute("medicamentos", medicamentosDao.getMedicamentos(5));
            RequestDispatcher despachador = getDefultDispatcher(request);
            despachador.forward(request, response);
        }
    }
}
