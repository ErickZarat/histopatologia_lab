package histopatologialab.login;

import histopatologialab.core.Controllers;
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

    LoginController loginController = Controllers.loginController;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher despachador = null;

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        boolean seInicioSesion = loginController.iniciarSession(usuario, password, request);
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

        if (action == RequestAction.SALIR) {
        	System.out.println("opcion de salir de login servlet");
            logout(request, response);
            response.sendRedirect("/");
        } else if (isValidSession(request)) {
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        } else {
            response.sendRedirect("/");
        }

    }

}
