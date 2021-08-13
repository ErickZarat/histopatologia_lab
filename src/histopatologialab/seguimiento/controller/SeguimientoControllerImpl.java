package histopatologialab.seguimiento.controller;

import java.util.List;

import histopatologialab.core.JsonResponse;
import histopatologialab.seguimiento.dao.ISeguimientoDao;
import histopatologialab.seguimiento.dto.Seguimiento;

public class SeguimientoControllerImpl implements ISeguimientoController{
	
	private final ISeguimientoDao seguimientoDao;
	
	public SeguimientoControllerImpl (ISeguimientoDao seguimientoDao) {
		this.seguimientoDao = seguimientoDao;
	}
	
	
	 @Override
	    public JsonResponse<List<Seguimiento>> getSeguimientoByExamen(Integer codExamen)
	 {	List<Seguimiento> seguimientos = seguimientoDao.getSeguimientoByExamen(codExamen);
	 	return new JsonResponse<>(seguimientos != null, seguimientos);
		 
	 }
	 
	 @Override
	    public JsonResponse<List<Seguimiento>> guardarSeguimiento(List<Seguimiento> seguimientos)	    
	    { System.out.println("Controller para guardar el seguimiento ");  
		 List<Seguimiento> savedSeguimientos = seguimientoDao.guardarSeguimiento(seguimientos);
		 return new JsonResponse<>(seguimientos != null, savedSeguimientos);
		 
	    }

}
