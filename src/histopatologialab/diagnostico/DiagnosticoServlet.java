package histopatologialab.diagnostico;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import histopatologialab.diagnostico.controller.IDiagnosticoController;
import histopatologialab.diagnostico.dto.Diagnostico;

import static histopatologialab.core.ServletHelper.*;
import static histopatologialab.core.Controllers.diagnosticoController;

import histopatologialab.core.JsonResponse;
import histopatologialab.core.RequestAction;
import javax.servlet.RequestDispatcher;
import java.util.List;

/**
 * Servlet implementation class DiagnosticoServlet
 */
@WebServlet(name = "DiagnosticoServlet")
public class DiagnosticoServlet extends HttpServlet {
	IDiagnosticoController controller = diagnosticoController;
	
	private static final long serialVersionUID = 1L;
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public DiagnosticoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	    checkSession(request, response);
        System.out.println("Hola Servlet post..");
        RequestAction action = getRequestAction(request);

        if (action == RequestAction.CREAR) {
           crearDiagnostico(request, response);
        } else if (action == RequestAction.MODIFICAR) {
            modificarDiagnostico(request, response);
        } else if (action == RequestAction.DAR_BAJA) {
            darBajaDiagnostico(request, response);
        } else if (action == RequestAction.BUSCAR) { 
        	buscarDiagnostico(request, response);  
	    } else if (action == RequestAction.CAMBIO_ESTADO) {
	        cambioEstadoDiagnostico(request, response);
	    }
        
	}

    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkSession(request, response);
        System.out.println("Hola Servlet get diagnostico..");
        RequestAction action = getRequestAction(request);

        if (action == RequestAction.LISTAR_JSON) {
        	getJsonDiagnostico(request, response);
        } else {
            getDefaultPage(request, response);
        }
    }
	
		
	private void getJsonDiagnostico(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Diagnostico> diagnosticosList = controller.getDiagnosticos();
        toJsonResponse(response, new JsonResponse<>(diagnosticosList != null, diagnosticosList));
    }

	
	private void getDefaultPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        RequestDispatcher despachador = request.getRequestDispatcher("mantenimientos/diagnosticos.jsp");
	        despachador.forward(request, response);
	}
	
	
	private void crearDiagnostico(HttpServletRequest request, HttpServletResponse response) throws IOException {
		  System.out.println("entra al servlet");
	    String usuario = getUsuarioFromSession(request);
	    String nombreDiagnostico  = request.getParameter("nombreDiagnostico");	    
	    
   
	    Diagnostico  diagnostico = controller.crearDiagnostico(nombreDiagnostico,  usuario);
	    toJsonResponse(response, new JsonResponse<>(diagnostico != null, diagnostico));
	}
	
	
	private void modificarDiagnostico(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    String usuario = getUsuarioFromSession(request);
	    try {
		    Long codDiagnostico = Long.parseLong(request.getParameter("codigoDiagnostico"));  
		    String nombreDiagnostico  = request.getParameter("nombreDiagnostico");
		
		    Diagnostico diagnostico = controller.modificarDiagnostico(codDiagnostico, nombreDiagnostico, usuario);
		    toJsonResponse(response, new JsonResponse<>(diagnostico != null, diagnostico));
        } catch (Exception e) {
            
        }
	}
	
	
	private void darBajaDiagnostico(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    /* int codigo = Integer.parseInt(request.getParameter("codigoEnfermedad"));
	    String usuario = getUsuarioFromSession(request);
	    boolean success = controller.darBajaEnfermedad(codigo, usuario);
	    toJsonResponse(response, new JsonResponse<>(success, success)); */
	}
	
	
	private void buscarDiagnostico(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Long codDiagnostico = Long. parseLong(request.getParameter("codDiagnostico")) ;
	    Diagnostico diagnostico = controller.buscarDiagnostico(codDiagnostico);
	    toJsonResponse(response, new JsonResponse<>(diagnostico != null, diagnostico));
	}
	
	
    private void cambioEstadoDiagnostico(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long codDiagnostico =  Long. parseLong(request.getParameter("codigoDiagnostico")) ;
        String usuario = getUsuarioFromSession(request);
        
       // String estadoNuevo = (request.getParameter("estadoEnfermedadBaja"));
       // System.out.println(estadoNuevo);
        
        String estadoNuevo = new String(request.getParameter("estadoNuevoDiagnostico"));
        System.out.println(estadoNuevo);
        boolean success = controller.cambiaEstadoDiagnostico(codDiagnostico, estadoNuevo,usuario);
        toJsonResponse(response, new JsonResponse<>(success, success));
    }
	
	
	
	
	
}
