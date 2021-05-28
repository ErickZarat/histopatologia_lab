package histopatologialab.enfsistemica;

import histopatologialab.core.JsonResponse;
import histopatologialab.core.RequestAction;
import histopatologialab.enfsistemica.controller.IEnfSistemicaController;
import histopatologialab.enfsistemica.dto.EnfSistemica;
import org.tinylog.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static histopatologialab.core.ServletHelper.*;
import static histopatologialab.core.Controllers.enfsistemicaController;


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
        List<EnfSistemica> enfermedadesList = controller.getEnfermedadesSistemicas();
        toJsonResponse(response, new JsonResponse<>(enfermedadesList != null, enfermedadesList));
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

        EnfSistemica enfermedad = controller.crearEnfermedad(nombre, usuario);
        toJsonResponse(response, new JsonResponse<>(enfermedad != null, enfermedad));
    }

    private void modificarEnfSistemica(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigoEnfermedad"));
        String nombre = request.getParameter("nombreEnfermedad");
        String usuario = getUsuarioFromSession(request);

        EnfSistemica enfermedad = controller.modificarEnfermedad(codigo, nombre, usuario);
        toJsonResponse(response, new JsonResponse<>(enfermedad != null, enfermedad));
    }

    private void darBajaEnfSistemica(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigoEnfermedad"));
        String usuario = getUsuarioFromSession(request);
        boolean success = controller.darBajaEnfermedad(codigo, usuario);
        toJsonResponse(response, new JsonResponse<>(success, success));
    }
    
    private void cambioEstadoEnfSistemica(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigoEnfermedad"));
        String usuario = getUsuarioFromSession(request);
        String estadoNuevo = (request.getParameter("estadoEnfermedadBaja"));
        System.out.println(estadoNuevo);
        //cambiaEstadoEnfermedad(int codigo, String estado, String usuario)
        boolean success = controller.cambiaEstadoEnfermedad(codigo, estadoNuevo,usuario);
        toJsonResponse(response, new JsonResponse<>(success, success));
    }

}
