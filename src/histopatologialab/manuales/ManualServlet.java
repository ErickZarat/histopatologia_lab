package histopatologialab.manuales;

import static histopatologialab.core.ServletHelper.checkSession;
import static histopatologialab.core.ServletHelper.getRequestAction;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import histopatologialab.core.RequestAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/**
 * Servlet implementation class ManualServlet
 */

@WebServlet(name = "ManualServlet")

public class ManualServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManualServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		checkSession(request, response);
        System.out.println("Hola Servlet manuales..");
      //  RequestAction action = getRequestAction(request);        
        getDefaultPage(request, response);			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
    private void getDefaultPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         RequestDispatcher despachador = request.getRequestDispatcher("mantenimientos/list-manuales.jsp");
         despachador.forward(request, response);
     }
	

}
