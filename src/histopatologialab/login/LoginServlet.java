package histopatologialab.login;

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

        boolean seInicioSesion = loginController.iniciarSession(usuario, password);
        if (seInicioSesion) {
            crearSesion(request, usuario);
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

    private void crearSesion(HttpServletRequest request, String usuario) {
        HttpSession session = request.getSession(true);
        request.setAttribute("username", usuario);
        session.setAttribute("usuario", usuario);
        session.setAttribute("sesionIniciada", true);
    }

    private void cerrarSesion(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null) return;
        session.removeAttribute("usuario");
        session.removeAttribute("sesionIniciada");
    }
}
