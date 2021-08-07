package histopatologialab.receta;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import histopatologialab.core.JsonResponse;
import histopatologialab.core.RequestAction;
import histopatologialab.receta.dto.Receta;
import org.tinylog.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static histopatologialab.core.Controllers.recetaController;
import static histopatologialab.core.ServletHelper.*;


@WebServlet(name = "RecetaServlet")
public class RecetaServlet extends HttpServlet {

    private ObjectMapper jackson = getJackson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        checkSession(request, response);

        RequestAction action = getRequestAction(request);

        if (action == RequestAction.CREAR) {
            handlePostCreateReceta(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkSession(request, response);

        RequestAction action = getRequestAction(request);

        if (action == RequestAction.LISTAR_JSON) {
            handleGetReceta(request, response);
        }
    }

    private void handlePostCreateReceta(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String json = request.getParameter("recetas");
        List<Receta> recetaList = jackson.readValue(json,  new TypeReference<List<Receta>>(){});
        if (recetaList == null) {
            Logger.error("error parsing receta request");
        }

        for (Receta receta : recetaList) {
            receta.setCreadoPor(getIdUsuarioFromSession(request));
        }

        JsonResponse<List<Receta>> guardado =  recetaController.guardarReceta(recetaList);
        returnJson(response, guardado);
    }

    private void handleGetReceta(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String examen = request.getParameter("codExamen");
        int codExamen = 0;
        try {
            codExamen = Integer.parseInt(examen);
        } catch (NumberFormatException e) {

        }
        JsonResponse<List<Receta>> recetas =  recetaController.getRecetaByExamen(codExamen);
        returnJson(response, recetas);
    }
}
