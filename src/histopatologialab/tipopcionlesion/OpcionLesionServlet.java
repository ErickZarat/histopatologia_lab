package histopatologialab.tipopcionlesion;


import histopatologialab.core.JsonResponse;
import histopatologialab.core.RequestAction;
import histopatologialab.tipopcionlesion.controller.IOpcionLesionController;
import histopatologialab.tipopcionlesion.dto.OpcionLesion;
import histopatologialab.tipopcionlesion.dto.TipOpcion;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static histopatologialab.core.Controllers.opcionlesionController;
import static histopatologialab.core.ServletHelper.*;


@WebServlet(name ="OpcionLesionServlet")

public class OpcionLesionServlet extends HttpServlet {
	IOpcionLesionController controller = opcionlesionController;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpcionLesionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
        if (!isValidSession(request, response)) return;

        RequestAction action = getRequestAction(request);
		System.out.println(action);
		
        if (action == RequestAction.CREAR) {
        	crearOpcionLesion(request, response);
        } else if (action == RequestAction.MODIFICAR) {
        	modificarOpcionLesion(request, response);
        } else if (action == RequestAction.DAR_BAJA) {
        	darBajaOpcionLesion(request, response);
        } else if (action == RequestAction.CAMBIO_ESTADO) {
        	cambiaEstadoOpcionLesion(request, response);
        }
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isValidSession(request, response)) return;

        RequestAction action = getRequestAction(request);
        if (action == RequestAction.LISTAR_JSON) {
        	getJsonOpcionLesion(request, response);
        } else {
            getDefaultPage(request, response);
        }
	}
	
	
    private void getJsonOpcionLesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tipoOpcion = request.getParameter("tipoOpcion");

        JsonResponse<List<OpcionLesion>> opcionlesionList = controller.getOpciones(tipoOpcion);
        returnJson(response, opcionlesionList);
    }

    private void getDefaultPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tipOpcion", TipOpcion.values());
        RequestDispatcher despachador = request.getRequestDispatcher("mantenimientos/tipopcionlesion.jsp");
        despachador.forward(request, response);
    }

    private void crearOpcionLesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("tipoOpcion");
        String valor = request.getParameter("valoropcion");
        String usuario = getUsuarioFromSession(request);
        
        JsonResponse<OpcionLesion> opcionlesion = controller.crearOpcionLesion(nombre, valor, usuario) ;
        returnJson(response, opcionlesion);
    }

    private void modificarOpcionLesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigoOpcion"));
        String nombre = request.getParameter("nombreOpcion");
        String valor = request.getParameter("valorOpcion"); 
        
        String usuario = getUsuarioFromSession(request);

        JsonResponse<OpcionLesion> opcionlesion = controller.modificarOpcionLesion(codigo, nombre, valor, usuario);
        returnJson(response, opcionlesion);
    }

    private void darBajaOpcionLesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigoOpcion"));
        String usuario = getUsuarioFromSession(request);
        JsonResponse<Boolean> success = controller.darBajaOpcionLesion(codigo, usuario);
        returnJson(response, success);
    }
    
    
    private void cambiaEstadoOpcionLesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigoOpcion"));
        String usuario = getUsuarioFromSession(request);
        String estadoNuevo = request.getParameter("estadoOpcionBaja");
        JsonResponse<Boolean> success = controller.cambiaEstadoOpcion(codigo, estadoNuevo, usuario);
        returnJson(response, success);
    }

}
