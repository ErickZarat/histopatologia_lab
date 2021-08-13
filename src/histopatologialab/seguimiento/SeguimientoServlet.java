package histopatologialab.seguimiento;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import histopatologialab.core.JsonResponse;
import histopatologialab.core.RequestAction;
import histopatologialab.seguimiento.dto.Seguimiento;
import org.tinylog.Logger;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static histopatologialab.core.Controllers.seguimientoController;
import static histopatologialab.core.ServletHelper.*;

/**
 * Servlet implementation class SeguimientoServlet
 */
//@WebServlet("SeguimientoServlet")
@WebServlet(name = "SeguimientoServlet")
public class SeguimientoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ObjectMapper jackson = getJackson();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeguimientoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkSession(request, response);

        RequestAction action = getRequestAction(request);

        if (action == RequestAction.LISTAR_JSON) {
            handleGetSeguimiento(request, response);
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        checkSession(request, response);

        RequestAction action = getRequestAction(request);

        if (action == RequestAction.CREAR) {
            handlePostCreateSeguimiento(request, response);
        }
    }
    
    private void handlePostCreateSeguimiento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String json = request.getParameter("seguimientos");

        List<Seguimiento> seguimientoList = jackson.readValue(json,  new TypeReference<List<Seguimiento>>(){});
        if (seguimientoList == null) {
            Logger.error("error parsing receta request");
        }

        for (Seguimiento seguimiento : seguimientoList) {
        	seguimiento.setCreadoPor(getIdUsuarioFromSession(request));
        }       
        JsonResponse<List<Seguimiento>> guardado = seguimientoController.guardarSeguimiento(seguimientoList);
        returnJson(response, guardado);
    }

    private void handleGetSeguimiento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String examen = request.getParameter("codExamen");
        int codExamen = 0;
        try {
            codExamen = Integer.parseInt(examen);
        } catch (NumberFormatException e) {

        }
        JsonResponse<List<Seguimiento>> seguimientos = seguimientoController.getSeguimientoByExamen(codExamen);
        returnJson(response, seguimientos);
    }    

}
