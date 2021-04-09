package me.astridcortez.hispatologialab.medicamentos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import me.astridcortez.hispatologialab.core.RequestAction;
import me.astridcortez.hispatologialab.medicamentos.dao.IPresentacionMedicamentosDao;
import me.astridcortez.hispatologialab.medicamentos.dao.PresentacionMedicamentosDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PresentacionMedicamentosServlet")
public class PresentacionMedicamentosServlet extends HttpServlet {

    IPresentacionMedicamentosDao presentacionDao = new PresentacionMedicamentosDaoImpl();
    ObjectMapper jackson = new ObjectMapper();


    public PresentacionMedicamentosServlet() {
        jackson.registerModule(new JSR310Module());
        jackson.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestAction action = RequestAction.valueOf(request.getParameter("accion"));

        if (action == RequestAction.CREAR) {

        } else if (action == RequestAction.MODIFICAR) {

        } else if (action == RequestAction.DAR_BAJA) {

        }
    }

    private <T> void toJsonResponse(HttpServletResponse response, T object) throws IOException {
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter printout = response.getWriter();

        String respuesta = jackson.writeValueAsString(object);
        printout.print(respuesta);
        printout.flush();
    }


    private RequestAction getRequestAction(HttpServletRequest request) {
        String action = request.getParameter("accion");
        RequestAction requestAction = RequestAction.DEFAULT;
        if (action != null) requestAction =  RequestAction.valueOf(action);
        return requestAction;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestAction action = getRequestAction(request);

        if (action == RequestAction.CREAR) {

        } else if (action == RequestAction.MODIFICAR) {

        } else if (action == RequestAction.LISTAR_JSON) {

        } else {

        }
    }
}
