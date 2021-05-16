package histopatologialab.tipopcionlesion.controller;

import histopatologialab.tipopcionlesion.dto.OpcionLesion;
import java.util.List;

public interface IOpcionLesionController {
	
    OpcionLesion crearOpcionLesion(String nombre, String valor, String usuario);
    OpcionLesion modificarOpcionLesion(int codigo, String nombre, String valor, String usuario);
    Boolean darBajaOpcionLesion(int codigo, String usuario);
    List<OpcionLesion> getOpciones(String nombreOpcion);


}
