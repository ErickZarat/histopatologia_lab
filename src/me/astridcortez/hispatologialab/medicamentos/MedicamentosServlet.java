package me.astridcortez.hispatologialab.medicamentos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import me.astridcortez.hispatologialab.core.JsonResponse;
import me.astridcortez.hispatologialab.core.RequestAction;
import me.astridcortez.hispatologialab.medicamentos.controller.IMedicamentosController;
import me.astridcortez.hispatologialab.medicamentos.controller.MedicamentosControllerImpl;
import me.astridcortez.hispatologialab.medicamentos.dao.IMedicamentosDao;
import me.astridcortez.hispatologialab.medicamentos.dao.IPresentacionMedicamentosDao;
import me.astridcortez.hispatologialab.medicamentos.dao.MedicamentosDaoImpl;
import me.astridcortez.hispatologialab.medicamentos.dao.PresentacionMedicamentosDaoImpl;
import me.astridcortez.hispatologialab.medicamentos.dto.Medicamento;
import me.astridcortez.hispatologialab.medicamentos.dto.PresentacionMedicamento;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

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

        } else {

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
        Object usuario = request
                .getSession(true)
                .getAttribute("usuario");

        if (usuario == null) {
            usuario = "un usuario";
        }
        Medicamento medicamento = controller.crearMedicamento(nombre, tipoMedicamento, usuario.toString());
        toJsonResponse(response, new JsonResponse<Medicamento>(medicamento != null, medicamento));
    }

    private void modificarMedicamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigoMedicamento"));
        String nombre = request.getParameter("nombre");
        Object usuario = request
                .getSession(true)
                .getAttribute("usuario");

        if (usuario == null) {
            usuario = "un usuario";
        }
        Medicamento medicamento = controller.modificarMedicamento(codigo, nombre, usuario.toString());
        toJsonResponse(response, new JsonResponse<Medicamento>(medicamento != null, medicamento));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int codigoMedicamento, String nombreMedicamento, String estado, String creadoPor, LocalDate fechaCreacion, String modificadoPor, LocalDate fechaModificacion

        //System.out.println(request.getParameter("accion"));
        RequestAction action = RequestAction.DEFAULT;//RequestAction.valueOf(request.getParameter("accion"));

        if (action == RequestAction.CREAR) {


        } else if (action == RequestAction.MODIFICAR) {

        } else if (action == RequestAction.DAR_BAJA) {

        } else if (action == RequestAction.OBTENER_PRESENTACIONES) {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            toJsonResponse(response, controller.obtenerPresentaciones(codigo));
        } else {
            RequestDispatcher despachador = null;
            request.setAttribute("medicamentos", medicamentosDao.getMedicamentos(5));
            despachador = request.getRequestDispatcher("mantenimientos/medicamentos.jsp");
            despachador.forward(request, response);
        }
    }
}
