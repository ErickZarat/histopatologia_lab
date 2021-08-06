package histopatologialab.medicamentos;

import histopatologialab.core.Estado;
import histopatologialab.core.JsonResponse;
import histopatologialab.core.RequestAction;
import histopatologialab.medicamentos.controller.IMedicamentosController;
import histopatologialab.medicamentos.dto.PresentacionMedicamento;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static histopatologialab.core.Controllers.medicamentosController;
import static histopatologialab.core.ServletHelper.*;

@WebServlet(name = "PresentacionMedicamentosServlet")
public class PresentacionMedicamentosServlet extends HttpServlet {

    IMedicamentosController controller = medicamentosController;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestAction action = getRequestAction(request);

        if (action == RequestAction.CREAR) {
            crearPresentacion(request, response);
        } else if (action == RequestAction.MODIFICAR) {
            modificarPresentacion(request, response);
        } else if (action == RequestAction.DAR_BAJA) {
            darBajaPresentacion(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestAction action = getRequestAction(request);

        if (action == RequestAction.VER_JSON) {
            getPresentacion(request, response);
        } else if (action == RequestAction.LISTAR_JSON) {
            getPresentaciones(request, response);
        }

    }
    //int codMedicamento, int tipoPresentacion, String creadoPor, LocalDate fechaCreacion, String modificatoPor)
    private void crearPresentacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PresentacionMedicamento presentacionMedicamento = new PresentacionMedicamento(
                null,
                Integer.parseInt(request.getParameter("codigoMedicamento")),
                request.getParameter("tipoPresentacion"),
                getUsuarioFromSession(request),
                LocalDate.now(),
                null,
                null,
                Estado.HABILITADO.getSlug()
        );

        JsonResponse<PresentacionMedicamento> presentacion = controller.crearPresentacionMedicamento(presentacionMedicamento);
        returnJson(response, presentacion);
    }

    private void modificarPresentacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tipoPresentacion = request.getParameter("tipoPresentacionCurrent");
        PresentacionMedicamento presentacionMedicamento = new PresentacionMedicamento(
                null,
                Integer.parseInt(request.getParameter("codigoMedicamento")),
                request.getParameter("tipoPresentacion"),
                getUsuarioFromSession(request),
                LocalDate.now(),
                getUsuarioFromSession(request),
                LocalDate.now(),
                Estado.HABILITADO.getSlug()
        );

        JsonResponse<PresentacionMedicamento> presentacion = controller.modificarPresentacionMedicamento(tipoPresentacion, presentacionMedicamento);
        returnJson(response, presentacion);
    }

    private void darBajaPresentacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tipoPresentacion = request.getParameter("tipoPresentacion");
        int codigoMedicamento = Integer.parseInt(request.getParameter("codigoMedicamento"));

        JsonResponse<Boolean> success = controller.darBajaPresentacion(codigoMedicamento, tipoPresentacion, getUsuarioFromSession(request));
        returnJson(response, success);
    }

    private void getPresentacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigoMedicamento = Integer.parseInt(request.getParameter("codigoMedicamento"));
        String tipoMedicamento = request.getParameter("tipoPresentacion");
        JsonResponse<PresentacionMedicamento> presentacion = controller.getPresentacion(codigoMedicamento, tipoMedicamento);
        returnJson(response, presentacion);
    }

    private void getPresentaciones(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigoMedicamento = Integer.parseInt(request.getParameter("codigoMedicamento"));
        JsonResponse<List<PresentacionMedicamento>> presentaciones = controller.getPresentaciones(codigoMedicamento);
        returnJson(response, presentaciones);
    }
}
