package histopatologialab.enfsistemica.controller;


import histopatologialab.core.Estado;
import histopatologialab.core.JsonResponse;
import histopatologialab.enfsistemica.dao.IEnfSistemicaDao;
import histopatologialab.enfsistemica.dto.EnfSistemica;

import java.time.LocalDate;
import java.util.List;


public class EnfSistemicaControllerImpl implements IEnfSistemicaController {


    private final IEnfSistemicaDao enfermedadesDao;

    public EnfSistemicaControllerImpl(IEnfSistemicaDao enfermedadesDao) {
        this.enfermedadesDao = enfermedadesDao;
    }

    @Override
    public JsonResponse<EnfSistemica> crearEnfermedad(String nombre, String usuario) {
        try {
        	EnfSistemica enfermedadExiste = enfermedadesDao.getEnfermedadByNombre(nombre);
        	if (!(enfermedadExiste == null)) {  
        		return new JsonResponse<>( false, null, "El nombre de la enfermedad ingresada, ya existe");
        	}
	        else {
	            EnfSistemica enfermedad = new EnfSistemica(0, nombre, Estado.HABILITADO.getSlug(), usuario, LocalDate.now(), null, null);
	            enfermedad = enfermedadesDao.guardarEnfermedad(enfermedad);
	            return new JsonResponse<EnfSistemica>(enfermedad != null, enfermedad);
	        }
        } catch (Exception e) {
        	//System.out.println("ENTRA AL NULL "+e.getMessage() );
        	return new JsonResponse<>( false, null, "Hubo un error al ingresar la enfermedad, Consulte al Administrador");
        }
    }


    @Override
    public JsonResponse<EnfSistemica> modificarEnfermedad(int codigo, String nombre, String usuario) {
        try {        	
        	// buscar nombre que no sea repetido con otra enfermedad
        	EnfSistemica enfermedadExiste = enfermedadesDao.getEnfermedadByNombre(nombre);        	
        	if ((enfermedadExiste == null)) {    // no existe la enfermedad
        		// buscar los datos de la enfermedad que se esta modificando
	            EnfSistemica enfermedad = enfermedadesDao.getEnfermedad(codigo);
	            enfermedad.setNombreEnfermedad(nombre);
	            enfermedad.setModificadoPor(usuario);
	            enfermedad.setFechaModificacion(LocalDate.now());
	            enfermedad = enfermedadesDao.modificarEnfermedad(enfermedad);
	
	            return new JsonResponse<EnfSistemica>(enfermedad != null, enfermedad);
        	} else  { // si existe, se valida que sea el mismo codigo        		
        		if (codigo != enfermedadExiste.getCodigoEnfermedad())
        		{	return new JsonResponse<EnfSistemica>(false, null, "El nombre de la enfermedad ya existe");
        		} else {
        			return new JsonResponse<>( false, null, "No ha realizado cambios a la enfermedad");
        		}        		
        	}
        } catch (Exception e) {
        	return new JsonResponse<>( false, null, "Hubo un error al modificar la enfermedad, Consulte al Administrador");
            //return null;
        }
    }


    @Override
    public JsonResponse<Boolean> darBajaEnfermedad(int codigo, String usuario) {
        Boolean success = enfermedadesDao.darDeBaja(codigo, usuario);
        return new JsonResponse<Boolean>(success, success);
    }

    @Override
    public JsonResponse<Boolean> cambiaEstadoEnfermedad(int codigo, String estado, String usuario) {
        Boolean success = enfermedadesDao.cambioEstadoEnfermedad(codigo, estado, usuario);
        return new JsonResponse<Boolean>(success, success);
    }

    @Override
    public JsonResponse<List<EnfSistemica>> getEnfermedadesSistemicas() {
        List<EnfSistemica> enfermedades = enfermedadesDao.getEnfermedades();
        return new JsonResponse<List<EnfSistemica>>(enfermedades != null, enfermedades);

    }

}
