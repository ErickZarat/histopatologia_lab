package histopatologialab.diagnostico.dao;

import histopatologialab.diagnostico.dto.Diagnostico;

import java.util.List;


public interface IDiagnosticoDao {
	
		List <Diagnostico> getDiagnosticos(); 
		Diagnostico getDiagnostico(Long codigoDiagnostico);
		Diagnostico guardarDiagnostico(Diagnostico diagnostico);
		Diagnostico modificarDiagnostico(Diagnostico diagnostico);
		Boolean darDeBajaDiagnostico(Long codigoDiagnostico, String usuario);
	    Boolean cambioEstadoDiagnostico(Long codigoDiagnostico, String estadoNuevo, String usuario);

}
