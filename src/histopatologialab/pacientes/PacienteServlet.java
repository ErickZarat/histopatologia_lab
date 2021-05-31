package histopatologialab.pacientes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import histopatologialab.core.JsonResponse;
import histopatologialab.core.RequestAction;

import histopatologialab.pacientes.controller.IPacienteController;
import histopatologialab.pacientes.dto.Paciente;
import org.tinylog.Logger;

import javax.servlet.RequestDispatcher;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static histopatologialab.core.ServletHelper.*;

import static histopatologialab.core.Controllers.pacienteController;

/**
 * Servlet implementation class PacienteServlet
 */
@WebServlet( name = "PacienteServlet")
public class PacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IPacienteController controller = pacienteController; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PacienteServlet() {
        super();
        // TODO Auto-generated constructor stub
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

        if (action == RequestAction.CREAR) {
           crearPaciente(request, response);
        } else if (action == RequestAction.MODIFICAR) {
            modificarPaciente(request, response);
        } else if (action == RequestAction.DAR_BAJA) {
            darBajaPaciente(request, response);
        }
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        checkSession(request, response);
        System.out.println("Hola Servlet get..");
        RequestAction action = getRequestAction(request);

        if (action == RequestAction.LISTAR_JSON) {
            getJsonPaciente(request, response);
        } else {
            getDefaultPage(request, response);
        }
	}
	
	private void getJsonPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException {
	        List<Paciente> pacientesList = controller.getPacientes();
	        toJsonResponse(response, new JsonResponse<>(pacientesList != null, pacientesList));
	    }

	private void getDefaultPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        RequestDispatcher despachador = request.getRequestDispatcher("mantenimientos/pacientes.jsp");
	        despachador.forward(request, response);
	    }

    private void crearPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //int tipoMedicamento = Integer.parseInt(request.getParameter("tipoMedicamento"));
        String usuario = getUsuarioFromSession(request);
        String identificacionPaciente  = request.getParameter("identificacion");
        String nombrePaciente = request.getParameter("nomPaciente");
        String apellidosPaciente =  request.getParameter("apellidosPaciente");
        String direccionPaciente = request.getParameter("dirPaciente");
        String telefonoPaciente= request.getParameter("telPaciente");
        String fecNacimientoPaciente=  request.getParameter("fecNacimiento");  							
        String generoPaciente= request.getParameter("generoPaciente");
        String ocupacionPaciente= request.getParameter("ocupacionPaciente");
        String tipoidPaciente= request.getParameter("tipoPaciente");
        String emailPaciente= request.getParameter("emailPaciente");
        String estadoCivilPaciente= request.getParameter("estadoCivilPaciente");

        
        //LocalDate fecnacimiento = LocalDate.parse(fecNacimientoPaciente);
        LocalDate fecnacimiento =  LocalDateTime.parse(fecNacimientoPaciente).toLocalDate();

        Paciente paciente = controller.crearPaciente(identificacionPaciente, nombrePaciente, apellidosPaciente, direccionPaciente, telefonoPaciente, fecnacimiento, generoPaciente, ocupacionPaciente, tipoidPaciente, emailPaciente, usuario, estadoCivilPaciente);
        toJsonResponse(response, new JsonResponse<>(paciente != null, paciente));
    }

    private void modificarPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String usuario = getUsuarioFromSession(request);
        
        Long codPaciente = Long.parseLong(request.getParameter("codPaciente"));  
        String identificacionPaciente  = request.getParameter("identificacion");
        String nombrePaciente = request.getParameter("nomPaciente");
        String apellidosPaciente = request.getParameter("apellidosPaciente");
        String direccionPaciente = request.getParameter("dirPaciente");
        String telefonoPaciente= request.getParameter("telPaciente");
        String ocupacionPaciente= request.getParameter("ocupacionPaciente");
        String tipoidPaciente= request.getParameter("tiPaciente");
        String emailPaciente= request.getParameter("emailPaciente");

        Paciente paciente = controller.modificarPaciente( codPaciente,  identificacionPaciente,  nombrePaciente, apellidosPaciente, 
        		 direccionPaciente, tipoidPaciente,  ocupacionPaciente,  emailPaciente,
        		 telefonoPaciente, usuario);
        toJsonResponse(response, new JsonResponse<>(paciente != null, paciente));
    }

    private void darBajaPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /* int codigo = Integer.parseInt(request.getParameter("codigoEnfermedad"));
        String usuario = getUsuarioFromSession(request);
        boolean success = controller.darBajaEnfermedad(codigo, usuario);
        toJsonResponse(response, new JsonResponse<>(success, success)); */
    }	
	
	
	
}
