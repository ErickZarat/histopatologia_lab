package histopatologialab.diagnostico.controller;


import java.util.List;
import histopatologialab.diagnostico.dto.Diagnostico;


public interface IDiagnosticoController {
	
	Diagnostico crearDiagnostico(String nombreDiagnostico,  String usuario);
	Diagnostico modificarDiagnostico(Long codigoDiagnostico, String nombreDiagnostico, String usuario);
	Diagnostico buscarDiagnostico(Long codigoDiagnostico);
	Boolean DarBajaDiagnostico(Long codigoDiagnostico, String usuario);
    Boolean cambiaEstadoDiagnostico(Long codigoDiagnostico, String estadoNuevo, String usuario);
	List<Diagnostico> getDiagnosticos();
}
