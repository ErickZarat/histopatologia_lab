package histopatologialab.enfsistemica.dao;

import histopatologialab.enfsistemica.dto.EnfSistemica;

import java.util.List;

public interface IEnfSistemicaDao {

	    List<EnfSistemica> getEnfermedades();

	    EnfSistemica getEnfermedad(int codEnfermedad);
	    EnfSistemica guardarEnfermedad(EnfSistemica enfermedad);
	    EnfSistemica modificarEnfermedad(EnfSistemica enfermedad);
	    Boolean darDeBaja(int codEnfermedad, String usuario);
	    Boolean cambioEstadoEnfermedad(int codEnfermedad, String estado, String usuario);
	    EnfSistemica getEnfermedadByNombre(String nomEnfermedad);
}
