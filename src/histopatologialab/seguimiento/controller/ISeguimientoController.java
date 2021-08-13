package histopatologialab.seguimiento.controller;

import histopatologialab.core.JsonResponse;
import histopatologialab.seguimiento.dto.Seguimiento;


import java.util.List;


public interface ISeguimientoController {

	 JsonResponse<List<Seguimiento>> getSeguimientoByExamen(Integer codExamen);
	 JsonResponse<List<Seguimiento>> guardarSeguimiento(List<Seguimiento> seguimientos);
	
}
