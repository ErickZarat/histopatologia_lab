package histopatologialab.tipopcionlesion.controller;

import histopatologialab.core.Estado;
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
    public OpcionLesion crearOpcionLesion(String nombre, String valor, String usuario) {
    	  try {
    		  OpcionLesion tipopcionlesion = new OpcionLesion(0, nombre, valor,  Estado.HABILITADO.getSlug(), usuario, LocalDate.now(), null, null);
    		  return opcionLesionDao.guardarOpcionLesion(tipopcionlesion);
          } catch (Exception e) {
              return null;
          }
    }
    
    @Override
    public OpcionLesion modificarOpcionLesion(int codigo, String nombre, String valor, String usuario) {
    	try {
    		OpcionLesion tipopcionlesion = opcionLesionDao.getOpcion(codigo);
    		tipopcionlesion.setNombreOpcion(nombre);
    		tipopcionlesion.setValor(valor);
    		tipopcionlesion.setModificadoPor(usuario);
    		tipopcionlesion.setFechaModificacion(LocalDate.now());
            return opcionLesionDao.modificarOpcionLesion(tipopcionlesion);
    		
        } catch (Exception e) {
            return null;
        }
    	
    }
    
    @Override
    public Boolean darBajaOpcionLesion(int codigo, String usuario) {
    	return opcionLesionDao.darDeBaja(codigo, usuario);
    }
    
    @Override
    public List<OpcionLesion> getOpciones(String nombreOpcion){
    	   System.out.println(nombreOpcion);
    	return opcionLesionDao.getOpcionesByTipo(nombreOpcion);
    }
    
	
}
