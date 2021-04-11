package histopatologialab.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import org.tinylog.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletHelper {

    public static ServletHelper helper;
    public static ObjectMapper jackson;

    public static String getUsuarioFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null) return null;

        Object usuario = session.getAttribute("usuario");

        if (usuario == null) {
            usuario = "DEFAULT";
        }
        return usuario.toString();
    }

    public static RequestAction getRequestAction(HttpServletRequest request) {
        String action = request.getParameter("accion");
        RequestAction requestAction = RequestAction.DEFAULT;
        if (action != null) requestAction =  RequestAction.valueOf(action);
        Logger.info("action action:" + requestAction + " requestAction:" + requestAction + "requestAction name:" + requestAction.name());
        return requestAction;
    }

    public static <T> void toJsonResponse(HttpServletResponse response, T object) throws IOException {
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter printout = response.getWriter();

        String respuesta = getJackson().writeValueAsString(object);
        printout.print(respuesta);
        printout.flush();
    }

    public static ObjectMapper getJackson(){
        if (jackson == null) {
            jackson = new ObjectMapper();
            jackson.registerModule(new JSR310Module());
            jackson.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        }
        return jackson;
    }
}
