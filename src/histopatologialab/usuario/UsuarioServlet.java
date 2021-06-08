package histopatologialab.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.util.List;


import histopatologialab.core.JsonResponse;
import histopatologialab.core.RequestAction;
import histopatologialab.usuario.dto.TipoUsuario;
import histopatologialab.usuario.controller.IUsuarioController;
import histopatologialab.usuario.dto.Usuario;

import static histopatologialab.core.ServletHelper.*;
import static histopatologialab.core.Controllers.usuarioController;

import org.tinylog.Logger;

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
        }    
    }

	
    private void getJsonUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //int tipoMedicamento = Integer.parseInt(request.getParameter("tipoMedicamento"));
        List<Usuario> usuariosList = controller.getUsuarios();
        toJsonResponse(response, new JsonResponse<>(usuariosList != null, usuariosList));
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
        
        
        Usuario usuario = controller.crearUsuario(loginUsuario, passUser,nombresDoctor,apellidosDoctor,emailDoctor, colegiadoDoctor, tipoUsuario,usuarioCrea  );
        toJsonResponse(response, new JsonResponse<>(usuario != null, usuario));
    }

    private void modificarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String loginUsuario =request.getParameter("loginUser"); 
        String nombresDoctor = request.getParameter("nombresDoctor");
        String apellidosDoctor = request.getParameter("apellidosDoctor"); 
        String emailDoctor = request.getParameter("emailDoctor"); 
        String colegiadoDoctor = request.getParameter("colegiadoDoctor"); 
        String tipoUsuario = request.getParameter("tipoUsuario");
        String usuarioMod = getUsuarioFromSession(request);
        System.out.println("antes de modificar controller");
        Usuario usuario = controller.modificarUsuario(loginUsuario, nombresDoctor, apellidosDoctor, emailDoctor, colegiadoDoctor, tipoUsuario, usuarioMod);
        System.out.println(usuario);
        toJsonResponse(response, new JsonResponse<>(usuario != null, usuario));
    }

    private void darBajaUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String loginUser = request.getParameter("loginUser");
        String usuarioSesion = getUsuarioFromSession(request);
        boolean success = controller.darBajaUsuario(loginUser, usuarioSesion);
        toJsonResponse(response, new JsonResponse<>(success, success));
    }
    
   
    private void buscarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String loginUser = request.getParameter("loginUser");
        //System.out.println("entra a la funcion buscar");
        //System.out.println(loginUser);
        Usuario usuario = controller.buscarUsuario(loginUser);
        toJsonResponse(response, new JsonResponse<>(usuario != null, usuario));
    } 
    
    private void ReinicioPswUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String loginUsuario =request.getParameter("loginUser"); 
        String usuarioMod = getUsuarioFromSession(request);
        System.out.println("antes de modificar controller");
        Usuario usuario = controller.reinicioPswUsuario(loginUsuario, usuarioMod);
        System.out.println("DESPUES DE MODIFICAR EL PSW");
        System.out.println(usuario);
        toJsonResponse(response, new JsonResponse<>(usuario != null, usuario));
    }

}
