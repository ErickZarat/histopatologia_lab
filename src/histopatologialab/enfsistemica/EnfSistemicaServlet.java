package histopatologialab.enfsistemica;

import histopatologialab.core.RequestAction;
import histopatologialab.enfsistemica.controller.IEnfSistemicaController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static histopatologialab.core.Controllers.enfsistemicaController;
import static histopatologialab.core.ServletHelper.*;


@WebServlet(name = "EnfSistemicaServlet")

public class EnfSistemicaServlet extends HttpServlet {
	IEnfSistemicaController controller = enfsistemicaController; 
	
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        checkSession(request, response);
        System.out.println("Hola Servlet post..");
        RequestAction action = getRequestAction(request);

        if (action == RequestAction.CREAR) {
           crearEnfSistemica(request, response);
        } else if (action == RequestAction.MODIFICAR) {
            modificarEnfSistemica(request, response);
        } else if (action == RequestAction.DAR_BAJA) {
            darBajaEnfSistemica(request, response);
        } else if (action == RequestAction.CAMBIO_ESTADO) {
            cambioEstadoEnfSistemica(request, response);
        }
          
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkSession(request, response);
        System.out.println("Hola Servlet get enfermedad..");
        RequestAction action = getRequestAction(request);

        if (action == RequestAction.LISTAR_JSON) {
            getJsonEnfsistemica(request, response);
        } else {
            getDefaultPage(request, response);
        }
    }

    private void getJsonEnfsistemica(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //int tipoMedicamento = Integer.parseInt(request.getParameter("tipoMedicamento"));
        returnJson(response, controller.getEnfermedadesSistemicas());
    }

    private void getDefaultPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // request.setAttribute("tiposMedicamento", TipoMedicamento.values());
        RequestDispatcher despachador = request.getRequestDispatcher("mantenimientos/enfsistemicas.jsp");
        despachador.forward(request, response);
    }

    private void crearEnfSistemica(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("nombre");
        //int tipoMedicamento = Integer.parseInt(request.getParameter("tipoMedicamento"));
        String usuario = getUsuarioFromSession(request);
        returnJson(response, controller.crearEnfermedad(nombre, usuario));
    }

    private void modificarEnfSistemica(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigoEnfermedad"));
        String nombre = request.getParameter("nombreEnfermedad");
        String usuario = getUsuarioFromSession(request);

        returnJson(response, controller.modificarEnfermedad(codigo, nombre, usuario));
    }

    private void darBajaEnfSistemica(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigoEnfermedad"));
        String usuario = getUsuarioFromSession(request);
        returnJson(response, controller.darBajaEnfermedad(codigo, usuario));
    }
    
    private void cambioEstadoEnfSistemica(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigoEnfermedad"));
        String usuario = getUsuarioFromSession(request);
        String estadoNuevo = (request.getParameter("estadoEnfermedadBaja"));
        System.out.println(estadoNuevo);
        //cambiaEstadoEnfermedad(int codigo, String estado, String usuario)
        returnJson(response, controller.cambiaEstadoEnfermedad(codigo, estadoNuevo,usuario));
    }

}
