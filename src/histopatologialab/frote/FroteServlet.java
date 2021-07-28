package histopatologialab.frote;

import histopatologialab.consultas.controller.IConsultaController;
import histopatologialab.consultas.dto.Examen;
import histopatologialab.core.Controllers;
import histopatologialab.core.JsonResponse;
import histopatologialab.core.RequestAction;
import histopatologialab.diagnostico.controller.IDiagnosticoController;
import histopatologialab.enfsistemica.controller.IEnfSistemicaController;
import histopatologialab.frote.controller.IFroteController;
import histopatologialab.frote.dto.Frote;
import histopatologialab.pacientes.dto.Paciente;
import org.tinylog.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static histopatologialab.core.Controllers.*;
import static histopatologialab.core.DateUtils.formatDate;
import static histopatologialab.core.ServletHelper.*;

@WebServlet(name = "FroteServlet")
public class FroteServlet extends HttpServlet {
    private final IFroteController controller = froteController;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        checkSession(request, response);

        RequestAction action = getRequestAction(request);

        if (action == RequestAction.CREAR) {
            handlePostCreateFrote(request, response);
        } else if (action == RequestAction.MODIFICAR) {
            handlePostModificarFrote(request, response);
        }
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
        String examenJson = request.getParameter("frote");
        Frote frote = jackson.readValue(examenJson, Frote.class);
        if (frote == null) {
            Logger.error("error parsing frote request");
        }
        try {
            frote.setUsuarioFrote(Math.toIntExact(getIdUsuarioFromSession(request)));
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
        } catch (Exception e){
            Logger.error("cannot cast user id");
        }

        JsonResponse<Frote> guardado =  controller.modificarFrote(frote, modificadoPor);
        returnJson(response, guardado);
    }

}
