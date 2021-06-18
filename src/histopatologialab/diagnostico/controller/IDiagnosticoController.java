package histopatologialab.diagnostico.controller;


import java.util.List;

import histopatologialab.core.JsonResponse;
import histopatologialab.diagnostico.dto.Diagnostico;


public interface IDiagnosticoController {
	
	JsonResponse<Diagnostico> crearDiagnostico(String nombreDiagnostico, String usuario);
	JsonResponse<Diagnostico> modificarDiagnostico(Long codigoDiagnostico, String nombreDiagnostico, String usuario);
	JsonResponse<Diagnostico> buscarDiagnostico(Long codigoDiagnostico);
	JsonResponse<Boolean> darBajaDiagnostico(Long codigoDiagnostico, String usuario);
    JsonResponse<Boolean> cambiaEstadoDiagnostico(Long codigoDiagnostico, String estadoNuevo, String usuario);
	JsonResponse<List<Diagnostico>> getDiagnosticos();
}
