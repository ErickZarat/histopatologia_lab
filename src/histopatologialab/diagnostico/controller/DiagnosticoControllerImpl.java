package histopatologialab.diagnostico.controller;

import java.time.LocalDate;
import java.util.List;
import histopatologialab.diagnostico.dto.Diagnostico;
import histopatologialab.diagnostico.dao.IDiagnosticoDao;
import histopatologialab.core.Estado;
import histopatologialab.diagnostico.dao.DiagnosticoDaoImpl;

public class DiagnosticoControllerImpl implements IDiagnosticoController{
	
	private final IDiagnosticoDao diagnosticosDao;
	
    public DiagnosticoControllerImpl(IDiagnosticoDao diagnosticosDao) {
    	this.diagnosticosDao = diagnosticosDao;
    }
	
	
	 @Override
	public Diagnostico crearDiagnostico(String nombreDiagnostico,  String usuario)
	{   try { Long id = null;
				System.out.println(nombreDiagnostico);
				Diagnostico diagnostico = new Diagnostico(id,nombreDiagnostico,  Estado.HABILITADO.getSlug(),LocalDate.now(), usuario, null, null );
				System.out.println("creado el objeto");
				return diagnosticosDao.guardarDiagnostico(diagnostico);
	
			} catch (Exception e) {
		    	return null;
			}
	
	}
	 	 

	 @Override
	public Diagnostico modificarDiagnostico(Long codigoDiagnostico, String nombreDiagnostico, String usuario)
	{    try {	Diagnostico diagnostico = diagnosticosDao.getDiagnostico(codigoDiagnostico);
				diagnostico.setNombreDiagnostico(nombreDiagnostico);
				diagnostico.setModificadoPor(usuario);
				diagnostico.setFechaModificacion(LocalDate.now());
				return diagnosticosDao.modificarDiagnostico(diagnostico);		
		    } catch (Exception e) {
		        return null;
		    }  		
				 
	}
	
	 @Override
	public Diagnostico buscarDiagnostico(Long codigoDiagnostico)
	{ return diagnosticosDao.getDiagnostico(codigoDiagnostico);
		 
	}
	
	 @Override
	public Boolean DarBajaDiagnostico(Long codigoDiagnostico, String usuario)
	{ return diagnosticosDao.darDeBajaDiagnostico(codigoDiagnostico, usuario);
		 
	}
	
	 @Override
	public List<Diagnostico> getDiagnosticos()
	{  return diagnosticosDao.getDiagnosticos(); 
	}
	 
	@Override
	public Boolean cambiaEstadoDiagnostico(Long codigoDiagnostico, String estadoNuevo, String usuario)
	{
    	return diagnosticosDao.cambioEstadoDiagnostico(codigoDiagnostico, estadoNuevo,usuario);  
	}
	

}
