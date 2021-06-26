package histopatologialab.tipopcionlesion.dao;

import histopatologialab.tipopcionlesion.dto.OpcionLesion;

import java.util.List;

public interface IOpcionLesionDao {
		
    List<OpcionLesion> getOpcionesByTipo(String tipOpcion);

    OpcionLesion getOpcion(int codigoOpcion);
    OpcionLesion guardarOpcionLesion(OpcionLesion tipopcionlesion);
    OpcionLesion modificarOpcionLesion(OpcionLesion tipopcionlesion);
    Boolean darDeBaja(int codigoOpcion, String usuario);
    List<OpcionLesion> getOpciones();
    Boolean cambioEstadoOpcion(int codigoOpcion, String estado, String usuario);
}
