package histopatologialab.tipopcionlesion.controller;

import histopatologialab.core.Estado;
import histopatologialab.core.JsonResponse;
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
    		  OpcionLesion tipopcionlesion = new OpcionLesion(0, nombre, valor,  Estado.HABILITADO.getSlug(), usuario, LocalDate.now(), null, null);
    		  tipopcionlesion = opcionLesionDao.guardarOpcionLesion(tipopcionlesion);
    		  return new JsonResponse<>(tipopcionlesion != null, tipopcionlesion);
          } catch (Exception e) {
        	  return new JsonResponse<>(false, null, e.getMessage());
          }
    }
    
    @Override
    public JsonResponse<OpcionLesion> modificarOpcionLesion(int codigo, String nombre, String valor, String usuario) {
    	try {
    		OpcionLesion tipopcionlesion = opcionLesionDao.getOpcion(codigo);
    		tipopcionlesion.setNombreOpcion(nombre);
    		tipopcionlesion.setValor(valor);
    		tipopcionlesion.setModificadoPor(usuario);
    		tipopcionlesion.setFechaModificacion(LocalDate.now());
    		tipopcionlesion = opcionLesionDao.modificarOpcionLesion(tipopcionlesion);
            return new JsonResponse<>(tipopcionlesion != null, tipopcionlesion);
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
    
	
}
