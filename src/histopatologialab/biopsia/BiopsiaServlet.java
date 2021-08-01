package histopatologialab.biopsia;

import com.fasterxml.jackson.databind.ObjectMapper;
import histopatologialab.biopsia.controller.IBiopsiaController;
import histopatologialab.biopsia.dto.Biopsia;
import histopatologialab.consultas.dto.EstadoExamen;
import histopatologialab.core.JsonResponse;
import histopatologialab.core.RequestAction;
import histopatologialab.informe.controller.IInformeController;
import histopatologialab.informe.dto.Informe;
import org.tinylog.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static histopatologialab.core.Controllers.biopsiaController;
import static histopatologialab.core.Controllers.informeController;
import static histopatologialab.core.ServletHelper.*;

@WebServlet(name = "BiopsiaServlet")
public class BiopsiaServlet extends HttpServlet {
    private final IBiopsiaController controller = biopsiaController;
    private final IInformeController infController = informeController;
    private final ObjectMapper jackson = getJackson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        checkSession(request, response);

        RequestAction action = getRequestAction(request);

        if (action == RequestAction.CREAR) {
            handlePostCreateBiopsia(request, response);
        } else if (action == RequestAction.MODIFICAR) {
            handlePostModificarBiopsia(request, response);
        } else if (action == RequestAction.GUARDAR_INFORME) {
            handlePostGuardarInformeBiopsia(request, response);
        }
    }

    private void handlePostGuardarInformeBiopsia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String informeJson = request.getParameter("informe");
        Logger.info("inf request " + informeJson);
        Informe informe = jackson.readValue(informeJson, Informe.class);
        if (informe == null) {
            Logger.info("error parsing biopsia request");
        }

        try {
            int usuarioId = Math.toIntExact(getIdUsuarioFromSession(request));
            informe.setUsuarioInforme(usuarioId);
        } catch (Exception e){
            Logger.info("cannot cast user id");
        }

        try {
            String usuario = getUsuarioFromSession(request);
            Biopsia biopsia = biopsiaController.getBiopsia(informe.getCodBiopsia()).getData();
            biopsia.setEstadoBiopsia(EstadoExamen.INFORME_FROTE.getSlug());
            biopsiaController.modificarBiopsia(biopsia, usuario);
        } catch (Exception e) {
            Logger.info("error cambiando estado");
        }

        Logger.info("guardando");
        JsonResponse<Informe> guardado =  infController.crearInforme(informe);
        Logger.info("guardando listo ");
        returnJson(response, guardado);
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
