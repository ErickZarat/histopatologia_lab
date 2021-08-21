package histopatologialab.login;

import histopatologialab.core.RequestAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static histopatologialab.core.ServletHelper.*;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    LoginController loginController = new LoginController();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher despachador = null;

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        boolean seInicioSesion = loginController.iniciarSession(usuario, password, request.getSession(true));
        if (seInicioSesion) {
            checkSession(request, response);
            request.setAttribute("username", usuario);
            despachador = request.getRequestDispatcher("principal.jsp");
        } else {
            despachador = request.getRequestDispatcher("index.jsp");
        }
        despachador.forward(request, response);
    }

    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkSession(request, response);
        
        RequestAction action = getRequestAction(request);
    	System.out.println(action);
    	String accion = request.getParameter("parametro");
    	
    	System.out.println(accion);
        
    	RequestDispatcher despachador;
        if (action == RequestAction.SALIR) {
        	System.out.println("opcion de salir de login servlet");
            loginController.cerrarSesion(request.getSession(true));
            despachador = request.getRequestDispatcher("index.jsp");
        } else if (isValidSession(request)) {
            despachador = request.getRequestDispatcher("principal.jsp");
        } else {
            despachador = request.getRequestDispatcher("index.jsp");
        }
        despachador.forward(request, response);
    }

}
