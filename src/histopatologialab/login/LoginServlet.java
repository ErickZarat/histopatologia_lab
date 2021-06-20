package histopatologialab.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static histopatologialab.core.ServletHelper.checkSession;
import static histopatologialab.core.ServletHelper.isValidSession;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    LoginController loginController = new LoginController();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher despachador = null;

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        boolean seInicioSesion = loginController.iniciarSession(usuario, password, request.getSession(true));
        if (seInicioSesion) {
            request.setAttribute("username", usuario);
            despachador = request.getRequestDispatcher("principal.jsp");
        } else {
            despachador = request.getRequestDispatcher("index.jsp");
        }
        despachador.forward(request, response);
    }

    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkSession(request, response);
        RequestDispatcher despachador;
        if (isValidSession(request)) {
            despachador = request.getRequestDispatcher("principal.jsp");
        } else {
            despachador = request.getRequestDispatcher("index.jsp");
        }
        despachador.forward(request, response);
    }

}
