package histopatologialab.tipopcionlesion.controller;

import histopatologialab.core.Estado;
import histopatologialab.core.JsonResponse;
import histopatologialab.enfsistemica.dto.EnfSistemica;
import histopatologialab.tipopcionlesion.dao.IOpcionLesionDao;
import histopatologialab.tipopcionlesion.dto.OpcionLesion;

import java.time.LocalDate;
import java.util.List;

public class OpcionLesionControllerImpl implements IOpcionLesionController {
	
	private final IOpcionLesionDao opcionLesionDao;
	
	
    public OpcionLesionControllerImpl (IOpcionLesionDao opcionLesionDao)
	{  this.opcionLesionDao = opcionLesionDao;	
	
	}
	
	
    @Override
    public JsonResponse<OpcionLesion> crearOpcionLesion(String nombre, String valor, String usuario) {
    	  try {    		  
    		  OpcionLesion tipOpcionLesionExiste = opcionLesionDao.getOpcionByTipoYValor(nombre, valor); 
    		  
    		if (!(tipOpcionLesionExiste == null)) {  
    			System.out.println ("repetido " + valor );
          		return new JsonResponse<>( false, null, "El valor del tipo de opción ingresado, ya existe");
          		}
  	        else {    		  
    		  OpcionLesion tipopcionlesion = new OpcionLesion(0, nombre, valor,  Estado.HABILITADO.getSlug(), usuario, LocalDate.now(), null, null);
    		  tipopcionlesion = opcionLesionDao.guardarOpcionLesion(tipopcionlesion);
    		  return new JsonResponse<>(tipopcionlesion != null, tipopcionlesion);
  	        	}
          } catch (Exception e) {
        	  return new JsonResponse<>(false, null, e.getMessage());
          }
    }
    
    @Override
    public JsonResponse<OpcionLesion> modificarOpcionLesion(int codigo, String nombre, String valor, String usuario) {
    	try {
    		
    		OpcionLesion tipOpcionLesionExiste = opcionLesionDao.getOpcionByTipoYValor(nombre, valor); 
   		  
     		if (tipOpcionLesionExiste == null) {
	     		OpcionLesion tipopcionlesion = opcionLesionDao.getOpcion(codigo);
	    		tipopcionlesion.setNombreOpcion(nombre);
	    		tipopcionlesion.setValor(valor);
	    		tipopcionlesion.setModificadoPor(usuario);
	    		tipopcionlesion.setFechaModificacion(LocalDate.now());
	    		tipopcionlesion = opcionLesionDao.modificarOpcionLesion(tipopcionlesion);
	            return new JsonResponse<>(tipopcionlesion != null, tipopcionlesion);
     		} else  { // si existe, se valida que sea el mismo codigo        		
        		if (codigo != tipOpcionLesionExiste.getCodigoOpcion())
        		{	return new JsonResponse<OpcionLesion>(false, null, "El valor para el tipo de opción ingresado, ya existe");
        		} else {
        			return new JsonResponse<>( false, null, "No ha realizado cambios al valor");
        		}  
     		}     		
        } catch (Exception e) {
        	return new JsonResponse<>(false, null, e.getMessage());
        }
    	
    }
    
    @Override
    public JsonResponse<Boolean> darBajaOpcionLesion(int codigo, String usuario) {
        Boolean success = opcionLesionDao.darDeBaja(codigo, usuario);
    	return new JsonResponse<>(success, success);
    }
    
    @Override
    public JsonResponse<List<OpcionLesion>> getOpciones(String nombreOpcion){
        System.out.println(nombreOpcion);
        List<OpcionLesion> opcion = opcionLesionDao.getOpcionesByTipo(nombreOpcion);

    	return new JsonResponse<List<OpcionLesion>>(opcion != null, opcion);
    }
    
    
    @Override
    public JsonResponse<Boolean> cambiaEstadoOpcion(int codigo, String estado, String usuario){
    	Boolean success = opcionLesionDao.cambioEstadoOpcion(codigo, estado, usuario);
        return new JsonResponse<Boolean>(success, success);
    }
    
	
}
