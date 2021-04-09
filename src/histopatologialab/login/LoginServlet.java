package histopatologialab.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.tinylog.Logger;

import java.io.IOException;

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
        RequestDispatcher despachador = request.getRequestDispatcher("index.jsp");
        despachador.forward(request, response);
    }

    private void crearSesion(HttpServletRequest request, String usuario) {
        Logger.info("se creo la sesion para el usuario: " + usuario);
        HttpSession session = request.getSession(true);
        session.setAttribute("usuario", usuario);
        session.setAttribute("sesionIniciada", true);
    }

    private void cerrarSesion(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("usuario");
        session.removeAttribute("sesionIniciada");
    }
}
