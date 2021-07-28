package histopatologialab.tincion;

import histopatologialab.core.RequestAction;
import histopatologialab.tincion.controller.ITincionController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static histopatologialab.core.Controllers.tincionController;
import static histopatologialab.core.ServletHelper.*;

@WebServlet( name = "TincionServlet")
public class TincionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ITincionController controller = tincionController;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkSession(request, response);
        RequestAction action = getRequestAction(request);

        if (action == RequestAction.LISTAR_JSON) {
            getTinciones(request, response);
        }
    }

    private void getTinciones(HttpServletRequest request, HttpServletResponse response) throws IOException {
        returnJson(response, controller.getTinciones());
    }

}