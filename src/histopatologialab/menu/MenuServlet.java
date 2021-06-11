package histopatologialab.menu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import histopatologialab.core.RequestAction;
import javax.servlet.RequestDispatcher;
import java.util.List;


import static histopatologialab.core.ServletHelper.*;

/**
 * Servlet implementation class MenuServlet
 */

@WebServlet(name = "MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        checkSession(request, response);
        System.out.println("Hola Servlet menu..");
        RequestAction action = getRequestAction(request);

       
        if (action == RequestAction.SALIR) {
        	getCerrarSesion(request, response);
        } else {
            getCambioPsw(request, response);
        }
              
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 checkSession(request, response);
	        System.out.println("Hola Servlet post..");
	        RequestAction action = getRequestAction(request);
	        if (action == RequestAction.CAMBIO_PSW) {
	        	LlamaCambioPswUsuario(request, response);
		    }   			
	}

	private void getCerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("opcion", "SALIR");
        RequestDispatcher despachador = request.getRequestDispatcher("mantenimientos/cambiopsw.jsp?opcion=SALIR");
        despachador.forward(request, response);
	}

	private void getCambioPsw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("myStation", value);
		request.setAttribute("opcion", "CAMBIO");
        RequestDispatcher despachador = request.getRequestDispatcher("mantenimientos/cambiopsw.jsp?opcion=CAMBIO");
        despachador.forward(request, response);
	}
	
	private void LlamaCambioPswUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("myStation", value);
		request.setAttribute("opcion", "CAMBIO");
        RequestDispatcher despachador = request.getRequestDispatcher("mantenimientos/cambiopsw.jsp?opcion=CAMBIO");
        despachador.forward(request, response);
	}
	
}
