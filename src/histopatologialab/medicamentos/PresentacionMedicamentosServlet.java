package histopatologialab.medicamentos;

import histopatologialab.core.RequestAction;
import histopatologialab.medicamentos.dao.IPresentacionMedicamentosDao;
import histopatologialab.medicamentos.dao.PresentacionMedicamentosDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static histopatologialab.core.ServletHelper.getRequestAction;

@WebServlet(name = "PresentacionMedicamentosServlet")
public class PresentacionMedicamentosServlet extends HttpServlet {

    IPresentacionMedicamentosDao presentacionDao = new PresentacionMedicamentosDaoImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestAction action = getRequestAction(request);

        if (action == RequestAction.CREAR) {

        } else if (action == RequestAction.MODIFICAR) {

        } else if (action == RequestAction.DAR_BAJA) {

        }
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
