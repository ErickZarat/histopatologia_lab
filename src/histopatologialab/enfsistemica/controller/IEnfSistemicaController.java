package histopatologialab.enfsistemica.controller;

import java.util.List;

import histopatologialab.core.JsonResponse;
import histopatologialab.enfsistemica.dto.EnfSistemica;

public interface IEnfSistemicaController {
	
    JsonResponse<EnfSistemica> crearEnfermedad(String nombre, String usuario);
    JsonResponse<EnfSistemica> modificarEnfermedad(int codigo, String nombre, String usuario);
    JsonResponse<Boolean> darBajaEnfermedad(int codigo, String usuario);
    JsonResponse<Boolean> cambiaEstadoEnfermedad(int codigo, String estado, String usuario);
    JsonResponse<List<EnfSistemica>> getEnfermedadesSistemicas();
    
}
