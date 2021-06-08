package histopatologialab.pacientes.controller;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import histopatologialab.core.Estado;
import histopatologialab.pacientes.dto.Paciente;
import histopatologialab.pacientes.dao.IPacienteDao;

public class PacienteControllerImpl implements IPacienteController{
	
	private final IPacienteDao pacientesDao;
    
    public PacienteControllerImpl(IPacienteDao pacientesDao) {
    this.pacientesDao = pacientesDao;
    }

    @Override
	public Paciente crearPaciente( String identificacionPaciente, String nombrePaciente, String apellidosPaciente,
			String direccionPaciente, String telefonoPaciente, LocalDate fecNacimientoPaciente,
			String generoPaciente, String ocupacionPaciente, String tipoidPaciente, String emailPaciente, String usuario, String estadoCivil)
	{
		  try { Long id = null;
		        Paciente paciente = new Paciente(id, identificacionPaciente,  nombrePaciente, apellidosPaciente, 
		    			 direccionPaciente,  telefonoPaciente,  fecNacimientoPaciente,
		    			 generoPaciente,  ocupacionPaciente,  tipoidPaciente,  emailPaciente,usuario, LocalDate.now(), null, null, estadoCivil);
		        return pacientesDao.guardarPaciente(paciente);
		    	} catch (Exception e) {
		        	return null;
		    	}
	}
	
	
    @Override
    public Paciente modificarPaciente(Long codPaciente, String identificacionPaciente, String nombrePaciente, String apellidosPaciente,
    		String direccionPaciente,String tipoidPaciente, String ocupacionPaciente, String emailPaciente,
    		String telefonoPaciente, String usuario)    {
     	 try {	
    		 Paciente paciente =   pacientesDao.getPaciente(codPaciente) ;
    		 paciente.setNombrePaciente(nombrePaciente);
    		 paciente.setApellidosPaciente(apellidosPaciente);
    		 paciente.setIdentificacionPaciente(identificacionPaciente);
    		 paciente.setDireccionPaciente(direccionPaciente);
    		 paciente.setTipoidPaciente(tipoidPaciente);
    		 paciente.setOcupacionPaciente(ocupacionPaciente);
    		 paciente.setTelefonoPaciente(telefonoPaciente);
    		 paciente.setEmailPaciente(emailPaciente);
    		 paciente.setModificadoPor(usuario);
    		 paciente.setFechaModificacion(LocalDate.now());
    		 return pacientesDao.modificarPaciente(paciente);	 
         } catch (Exception e) {
             return null;
         }    	
    }
   
    
  //  @Override
  //  Boolean darBajaPaciente(Long codigo, String usuario) {
   // }
    
    @Override
    public List<Paciente>getPacientes(){
    	return pacientesDao.getPacientes();
    	
    }
    
    @Override
    public List<Paciente>getPacientesByNombre(String Nombre){
    	return pacientesDao.getPacientesByNombre(Nombre);
    	
    }
    
    @Override
    public List<Paciente> getPacientesByidentificacion( String tipo, String numident){
    	return pacientesDao.getPacientesByidentificacion(tipo, numident);
    	
    }

	@Override
	public Paciente getPacienteByCodigo(long codPaciente) {
		return pacientesDao.getPaciente(codPaciente);
	}

	@Override
	public List<Paciente> buscarPaciente(String value) {
		if(value == null) return null;
		if(value.isEmpty()) return null;
		return pacientesDao.buscarPaciente(value);
	}

}
