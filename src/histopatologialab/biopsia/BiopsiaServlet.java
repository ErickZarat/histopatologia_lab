package histopatologialab.biopsia;

import histopatologialab.biopsia.dto.Biopsia;
import histopatologialab.core.JsonResponse;
import histopatologialab.core.RequestAction;
import histopatologialab.biopsia.controller.IBiopsiaController;
import org.tinylog.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static histopatologialab.core.Controllers.*;
import static histopatologialab.core.ServletHelper.*;

@WebServlet(name = "BiopsiaServlet")
public class BiopsiaServlet extends HttpServlet {
    private final IBiopsiaController controller = biopsiaController;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        checkSession(request, response);

        RequestAction action = getRequestAction(request);

        if (action == RequestAction.CREAR) {
            handlePostCreateBiopsia(request, response);
        } else if (action == RequestAction.MODIFICAR) {
            handlePostModificarBiopsia(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkSession(request, response);

        RequestAction action = getRequestAction(request);

        if (action == RequestAction.LISTAR_JSON) {
            handleGetBiopsias(request, response);
        } else {
            handleGetBiopsia(request, response);
        }
    }

    private void handleGetBiopsias(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String examen = request.getParameter("cod_examen");
        try {
            Integer codExamen = Integer.parseInt(examen);
            returnJson(response, controller.getBiopsiasByExamen(codExamen));
        } catch (Exception e) {
            returnJson(response, new JsonResponse<>(false, null, "examen invalido"));
        }
    }

    private void handleGetBiopsia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String biopsia = request.getParameter("cod_biopsia");
        try {
            Integer codBiopsia = Integer.parseInt(biopsia);
            returnJson(response, controller.getBiopsia(codBiopsia));
        } catch (Exception e) {
            returnJson(response, new JsonResponse<>(false, null, "biopsia invalido"));
        }
    }

    private void handlePostCreateBiopsia(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String examenJson = request.getParameter("biopsia");
        Biopsia biopsia = jackson.readValue(examenJson, Biopsia.class);
        if (biopsia == null) {
            Logger.error("error parsing biopsia request");
        }
        try {
            biopsia.setUsuarioBiopsia(Math.toIntExact(getIdUsuarioFromSession(request)));
        } catch (Exception e){
            Logger.error("cannot cast user id");
        }

        JsonResponse<Biopsia> guardado =  controller.guardarBiopsia(biopsia);
        returnJson(response, guardado);
    }

    private void handlePostModificarBiopsia(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String examenJson = request.getParameter("biopsia");
        Biopsia biopsia = jackson.readValue(examenJson, Biopsia.class);
        if (biopsia == null) {
            Logger.error("error parsing biopsia request");
        }
        String modificadoPor = getUsuarioFromSession(request);
        try {
            biopsia.setModificadoPor(modificadoPor);
            biopsia.setUsuarioBiopsia(Math.toIntExact(getIdUsuarioFromSession(request)));
        } catch (Exception e){
            Logger.error("cannot cast user id");
        }

        JsonResponse<Biopsia> guardado =  controller.modificarBiopsia(biopsia, modificadoPor);
        returnJson(response, guardado);
    }

}
