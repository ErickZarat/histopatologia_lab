package histopatologialab.usuario;

import histopatologialab.core.JsonResponse;
import histopatologialab.core.RequestAction;
import histopatologialab.usuario.controller.IUsuarioController;
import histopatologialab.usuario.dto.TipoUsuario;
import histopatologialab.usuario.dto.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession; 

import org.tinylog.Logger; 
 


import static histopatologialab.core.Controllers.usuarioController;
import static histopatologialab.core.ServletHelper.*;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet(name = "UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUsuarioController controller = usuarioController; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkSession(request, response);
        System.out.println("Hola Servlet get..");
        RequestAction action = getRequestAction(request);

        if (action == RequestAction.LISTAR_JSON) {
            getJsonUsuario(request, response);
        } else {
            getDefaultPage(request, response);
           }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkSession(request, response);
        System.out.println("Hola Servlet post..");
        RequestAction action = getRequestAction(request);

        if (action == RequestAction.CREAR) {
           crearUsuario(request, response);
        } else if (action == RequestAction.MODIFICAR) {
            modificarUsuario(request, response);
        } else if (action == RequestAction.DAR_BAJA) {
            darBajaUsuario(request, response);
        } else if (action == RequestAction.BUSCAR) { 
            buscarUsuario(request, response);
        } else if (action == RequestAction.REINICIO_PSW) { 
        	ReinicioPswUsuario(request, response);
        }  else if (action == RequestAction.CAMBIO_PSW) { 
	    	CambioPswUsuario(request, response);
	    }   else if (action == RequestAction.CAMBIO_ESTADO) { 
	    	CambioEstadoUsuario(request, response);
	    }   else if (action == RequestAction.SALIR) {  
	    	confirmSalir(request, response); 
	    }        
        
    }

	
    private void getJsonUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //int tipoMedicamento = Integer.parseInt(request.getParameter("tipoMedicamento"));
        JsonResponse<List<Usuario>> usuariosList = controller.getUsuarios();
        returnJson(response, usuariosList);
    }

    private void getDefaultPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("TipUsuario", TipoUsuario.values());
    	request.setAttribute("TipUsuarioMod", TipoUsuario.values());
        RequestDispatcher despachador = request.getRequestDispatcher("mantenimientos/usuarios.jsp");
        despachador.forward(request, response);
    }

    private void crearUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String usuarioCrea = getUsuarioFromSession(request);

        String loginUsuario =request.getParameter("loginUser"); 
        String passUser = request.getParameter("pswUser");
        String nombresDoctor = request.getParameter("nombresDoctor");
        String apellidosDoctor = request.getParameter("apellidosDoctor"); 
        String emailDoctor = request.getParameter("emailDoctor"); 
        String colegiadoDoctor = request.getParameter("colegiadoDoctor"); 
        String tipoUsuario = request.getParameter("tipoUsuario");
        
        
        JsonResponse<Usuario> usuario = controller.crearUsuario(loginUsuario, passUser,nombresDoctor,apellidosDoctor,emailDoctor, colegiadoDoctor, tipoUsuario,usuarioCrea  );
        returnJson(response, usuario);
    }

    private void modificarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String loginUsuario =request.getParameter("loginUser"); 
        String nombresDoctor = request.getParameter("nombresDoctor");
        String apellidosDoctor = request.getParameter("apellidosDoctor"); 
        String emailDoctor = request.getParameter("emailDoctor"); 
        String colegiadoDoctor = request.getParameter("colegiadoDoctor"); 
        String tipoUsuario = request.getParameter("tipoUsuario");
        String usuarioMod = getUsuarioFromSession(request);
        JsonResponse<Usuario> usuario = controller.modificarUsuario(loginUsuario, nombresDoctor, apellidosDoctor, emailDoctor, colegiadoDoctor, tipoUsuario, usuarioMod);
        returnJson(response, usuario);
    }

    private void darBajaUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String loginUser = request.getParameter("loginUser");
        String usuarioSesion = getUsuarioFromSession(request);
        JsonResponse<Boolean> success = controller.darBajaUsuario(loginUser, usuarioSesion);
        returnJson(response, success);
    }
    
   
    private void buscarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String loginUser = request.getParameter("loginUser");
        //System.out.println("entra a la funcion buscar");
        //System.out.println(loginUser);
        JsonResponse<Usuario> usuario = controller.buscarUsuario(loginUser);
        returnJson(response, usuario);
    } 
    
    private void ReinicioPswUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String loginUsuario =request.getParameter("loginUser"); 
        String usuarioMod = getUsuarioFromSession(request);
        JsonResponse<Usuario> usuario = controller.reinicioPswUsuario(loginUsuario, usuarioMod);
        System.out.println("DESPUES DE REINICIO EL PSW");
        returnJson(response, usuario);
    }
    
    private void CambioPswUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String usuarioMod = getUsuarioFromSession(request);
        String pswAnterior= request.getParameter("pswAnterior"); 
        String pswActual = request.getParameter("pswActual"); 
        System.out.println("antes de modificar controller");        
        JsonResponse<Usuario> usuario = controller.cambioPswUsuario(usuarioMod, pswAnterior, pswActual);
        System.out.println("DESPUES DE CAMBIO DE PSW");
        returnJson(response, usuario);
    }
    
    private void CambioEstadoUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
        String loginUsuario =request.getParameter("loginUser");        
        String usuariomod = getUsuarioFromSession(request);        
        String estadoNuevo = (request.getParameter("estadoUsuarioBaja"));
        returnJson(response, controller.cambiaEstadoUsuario(loginUsuario, estadoNuevo,usuariomod));        
    }
    
    
    private void confirmSalir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { 
   	 
        HttpSession session = request.getSession(true);  
         
        try { 
        	if (session == null) return; 
            	session.invalidate(); 
 
        } catch (IllegalStateException exception){ 
            Logger.warn("session already invalidated"); 
        } 
         
        RequestDispatcher despachador = request.getRequestDispatcher("index.jsp"); 
        despachador.forward(request, response);   	 
    } 
    
    
    
}
