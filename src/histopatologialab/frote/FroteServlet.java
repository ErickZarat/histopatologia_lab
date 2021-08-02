package histopatologialab.frote;

import com.fasterxml.jackson.databind.ObjectMapper;
import histopatologialab.biopsia.dto.Biopsia;
import histopatologialab.consultas.dto.EstadoExamen;
import histopatologialab.core.JsonResponse;
import histopatologialab.core.RequestAction;
import histopatologialab.frote.controller.IFroteController;
import histopatologialab.frote.dto.Frote;
import histopatologialab.informe.dto.Informe;
import org.tinylog.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import static histopatologialab.core.Controllers.*;
import static histopatologialab.core.ServletHelper.*;

@WebServlet(name = "FroteServlet")
public class FroteServlet extends HttpServlet {
    private final IFroteController controller = froteController;
    private final ObjectMapper jackson = getJackson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        checkSession(request, response);

        RequestAction action = getRequestAction(request);

        if (action == RequestAction.CREAR) {
            handlePostCreateFrote(request, response);
        } else if (action == RequestAction.MODIFICAR) {
            handlePostModificarFrote(request, response);
        } else if (action == RequestAction.GUARDAR_INFORME) {
            handlePostGuardarInformeFrote(request, response);
        }
    }

    private void handlePostGuardarInformeFrote(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
            Frote frote = froteController.getFrote(informe.getCodFrote()).getData();
            frote.setEstadoFrote(EstadoExamen.INFORME_FROTE.getSlug());
            froteController.modificarFrote(frote, usuario);
        } catch (Exception e) {
            Logger.info("error cambiando estado");
        }

        JsonResponse<Informe> guardado =  informeController.crearInforme(informe);
        returnJson(response, guardado);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkSession(request, response);

        RequestAction action = getRequestAction(request);

        if (action == RequestAction.LISTAR_JSON) {
            handleGetFrotes(request, response);
        } else {
            handleGetFrote(request, response);
        }
    }

    private void handleGetFrotes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String examen = request.getParameter("cod_examen");
        try {
            Integer codExamen = Integer.parseInt(examen);
            returnJson(response, controller.getFrotesByExamen(codExamen));
        } catch (Exception e) {
            returnJson(response, new JsonResponse<>(false, null, "examen invalido"));
        }
    }

    private void handleGetFrote(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String frote = request.getParameter("cod_frote");
        try {
            Integer codFrote = Integer.parseInt(frote);
            returnJson(response, controller.getFrote(codFrote));
        } catch (Exception e) {
            returnJson(response, new JsonResponse<>(false, null, "frote invalido"));
        }
    }

    private void handlePostCreateFrote(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String json = request.getParameter("frote");
        Frote frote = jackson.readValue(json, Frote.class);
        if (frote == null) {
            Logger.error("error parsing frote request");
        }
        try {
            frote.setUsuarioFrote(Math.toIntExact(getIdUsuarioFromSession(request)));
            frote.setEstadoFrote(EstadoExamen.PENDIENTE_FROTE.getSlug());
        } catch (Exception e){
            Logger.error("cannot cast user id");
        }

        JsonResponse<Frote> guardado =  controller.guardarFrote(frote);
        returnJson(response, guardado);
    }

    private void handlePostModificarFrote(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String examenJson = request.getParameter("frote");
        Frote frote = jackson.readValue(examenJson, Frote.class);
        if (frote == null) {
            Logger.error("error parsing frote request");
        }
        String modificadoPor = getUsuarioFromSession(request);
        try {
            frote.setModificadoPor(modificadoPor);
            frote.setUsuarioFrote(Math.toIntExact(getIdUsuarioFromSession(request)));
            frote.setEstadoFrote(EstadoExamen.PENDIENTE_INFORME_FROTE.getSlug());
        } catch (Exception e){
            Logger.error("cannot cast user id");
        }

        JsonResponse<Frote> guardado =  controller.modificarFrote(frote, modificadoPor);
        returnJson(response, guardado);
    }

}
