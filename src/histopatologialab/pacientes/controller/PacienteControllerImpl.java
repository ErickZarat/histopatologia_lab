package histopatologialab.pacientes.controller;

import histopatologialab.core.JsonResponse;
import histopatologialab.pacientes.dao.IPacienteDao;
import histopatologialab.pacientes.dto.Paciente;

import java.time.LocalDate;
import java.util.List;

public class PacienteControllerImpl implements IPacienteController{
	
	private final IPacienteDao pacientesDao;
    
    public PacienteControllerImpl(IPacienteDao pacientesDao) {
    this.pacientesDao = pacientesDao;
    }

    @Override
	public JsonResponse<Paciente> crearPaciente(String identificacionPaciente, String nombrePaciente, String apellidosPaciente,
									  String direccionPaciente, String telefonoPaciente, LocalDate fecNacimientoPaciente,
									  String generoPaciente, String ocupacionPaciente, String tipoidPaciente, String emailPaciente, String estCivilPaciente, String usuario)
	{
		  try { Long id = null;
		        Paciente paciente = new Paciente(id, identificacionPaciente,  nombrePaciente, apellidosPaciente, 
		    			 direccionPaciente,  telefonoPaciente,  fecNacimientoPaciente, generoPaciente,  ocupacionPaciente,  tipoidPaciente,  emailPaciente, estCivilPaciente, 
		    			 usuario, LocalDate.now(), null, null);

		        paciente = pacientesDao.guardarPaciente(paciente);
		        return new JsonResponse<>(paciente != null, paciente);
		    	} catch (Exception e) {
		        	return null;
		    	}
	}
	
	
    @Override
    public JsonResponse<Paciente> modificarPaciente(Long codPaciente, String identificacionPaciente, String nombrePaciente, String apellidosPaciente,
    		String direccionPaciente,String tipoidPaciente, String ocupacionPaciente, String emailPaciente,
    		String telefonoPaciente, String generoPaciente, String estCivilPaciente, String usuario)    {
     	 try {	
    		 Paciente paciente =   pacientesDao.getPaciente(codPaciente) ;
    		 paciente.setNombrePaciente(nombrePaciente);
    		 paciente.setApellidosPaciente(apellidosPaciente);
    		 paciente.setTipoidPaciente(tipoidPaciente);    		 
    		 paciente.setIdentificacionPaciente(identificacionPaciente);
    		 paciente.setDireccionPaciente(direccionPaciente);
    		 paciente.setOcupacionPaciente(ocupacionPaciente);
    		 paciente.setTelefonoPaciente(telefonoPaciente);
    		 paciente.setEmailPaciente(emailPaciente);
    		 paciente.setGeneroPaciente(generoPaciente);
    		 paciente.setEstCivilPaciente(estCivilPaciente);
    		 paciente.setModificadoPor(usuario);
    		 paciente.setFechaModificacion(LocalDate.now());
    		 paciente = pacientesDao.modificarPaciente(paciente);
    		 return new JsonResponse<>(paciente != null, paciente);
         } catch (Exception e) {
             return null;
         }    	
    }
   
    
  //  @Override
  //  Boolean darBajaPaciente(Long codigo, String usuario) {
   // }
    
    @Override
    public JsonResponse<List<Paciente>> getPacientes(){
    	List<Paciente> pacientes = pacientesDao.getPacientes();
    	return new JsonResponse<>(pacientes != null, pacientes);
    }
    
    @Override
    public JsonResponse<List<Paciente>> getPacientesByNombre(String Nombre){
    	List<Paciente> pacientes = pacientesDao.getPacientesByNombre(Nombre);
    	return new JsonResponse<>(pacientes != null, pacientes);

    }
    
    @Override
    public JsonResponse<List<Paciente>> getPacientesByidentificacion( String tipo, String numident){
    	List<Paciente> pacientes = pacientesDao.getPacientesByidentificacion(tipo, numident);
    	return new JsonResponse<>(pacientes != null, pacientes);
    }
    
    @Override
    public JsonResponse<Paciente> buscarPaciente(Long codPaciente) {
    	Paciente paciente = pacientesDao.getPaciente(codPaciente);
    	return new JsonResponse(paciente != null, paciente);
    }
	
}
