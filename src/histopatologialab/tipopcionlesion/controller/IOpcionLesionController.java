package histopatologialab.tipopcionlesion.controller;

import histopatologialab.core.JsonResponse;
import histopatologialab.tipopcionlesion.dto.OpcionLesion;

import java.util.List;

public interface IOpcionLesionController {
	
    JsonResponse<OpcionLesion> crearOpcionLesion(String nombre, String valor, String usuario);
    JsonResponse<OpcionLesion> modificarOpcionLesion(int codigo, String nombre, String valor, String usuario);
    JsonResponse<Boolean> darBajaOpcionLesion(int codigo, String usuario);
    JsonResponse<List<OpcionLesion>> getOpciones(String nombreOpcion);


}
