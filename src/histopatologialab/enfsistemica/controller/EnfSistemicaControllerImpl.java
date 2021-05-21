package histopatologialab.enfsistemica.controller;


import java.time.LocalDate;
import java.util.List;
import histopatologialab.core.Estado;
import histopatologialab.enfsistemica.dao.IEnfSistemicaDao;
import histopatologialab.enfsistemica.dto.EnfSistemica;


public class EnfSistemicaControllerImpl implements IEnfSistemicaController{
	
	
    private final IEnfSistemicaDao enfermedadesDao;
   
        public EnfSistemicaControllerImpl(IEnfSistemicaDao enfermedadesDao) {
        this.enfermedadesDao = enfermedadesDao;
    }
	
    @Override    
    public EnfSistemica crearEnfermedad(String nombre,  String usuario) {
    try {
        EnfSistemica enfermedad = new EnfSistemica(0, nombre, Estado.HABILITADO.getSlug(), usuario, LocalDate.now(), null, null);
        return enfermedadesDao.guardarEnfermedad(enfermedad);
    	} catch (Exception e) {
        	return null;
    	}
    }
    
    
    @Override  
    public EnfSistemica modificarEnfermedad(int codigo, String nombre, String usuario) {
    	 try {	
    		 EnfSistemica enfermedad = enfermedadesDao.getEnfermedad(codigo);
    		 enfermedad.setNombreEnfermedad(nombre);
    		 enfermedad.setModificadoPor(usuario);
    		 enfermedad.setFechaModificacion(LocalDate.now());
    		 return enfermedadesDao.modificarEnfermedad(enfermedad);	 
         } catch (Exception e) {
             return null;
         }    	
    }
            
    
    @Override  
    public Boolean darBajaEnfermedad(int codigo, String usuario) {
    	return enfermedadesDao.darDeBaja(codigo, usuario);     	
    }
    
    
    @Override  
    public List<EnfSistemica> getEnfermedadesSistemicas() {
    	return enfermedadesDao.getEnfermedades();
    	
    }
    
}
