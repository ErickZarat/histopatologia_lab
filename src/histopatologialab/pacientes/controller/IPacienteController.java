package histopatologialab.pacientes.controller;

import histopatologialab.pacientes.dto.Paciente;

import java.time.LocalDateTime;
import java.util.List;

public interface IPacienteController {
		
	Paciente crearPaciente( String identificacionPaciente, String nombrePaciente, String apellidosPaciente,
							String direccionPaciente, String telefonoPaciente, LocalDateTime fecNacimientoPaciente,
							String generoPaciente, String ocupacionPaciente, String tipoidPaciente, String emailPaciente, String usuario);
	Paciente modificarPaciente(Long codPaciente, String identificacionPaciente, String nombrePaciente, String apellidosPaciente,
    		String direccionPaciente,String tipoidPaciente, String ocupacionPaciente, String emailPaciente,
    		String telefonoPaciente, String usuario);
   // Boolean darBajaPaciente(int codigo, String usuario);
    List<Paciente>getPacientes();
    List<Paciente>getPacientesByNombre(String Nombre);
    List<Paciente> getPacientesByidentificacion( String tipo, String numident);
}
