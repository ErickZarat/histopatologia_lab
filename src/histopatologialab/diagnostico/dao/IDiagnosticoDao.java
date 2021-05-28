package histopatologialab.diagnostico.dao;

import java.util.List;

import histopatologialab.diagnostico.dto.Diagnostico;


public interface IDiagnosticoDao {
	
		List <Diagnostico> getDiagnosticos(); 
		Diagnostico getDiagnostico(Long codigoDiagnostico);
		Diagnostico guardarDiagnostico(Diagnostico diagnostico);
		Diagnostico modificarDiagnostico(Diagnostico diagnostico);
		Boolean darDeBajaDiagnostico(Long codigoDiagnostico, String usuario);
	    Boolean cambioEstadoDiagnostico(Long codigoDiagnostico, String estadoNuevo, String usuario);

}
