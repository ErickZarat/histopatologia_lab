package histopatologialab.pacientes.controller;

import histopatologialab.core.JsonResponse;
import histopatologialab.pacientes.dto.Paciente;

import java.time.LocalDate;
import java.util.List;

public interface IPacienteController {
		
	JsonResponse<Paciente> crearPaciente(String identificacionPaciente, String nombrePaciente, String apellidosPaciente,
							   String direccionPaciente, String telefonoPaciente, LocalDate fecNacimientoPaciente,
							   String generoPaciente, String ocupacionPaciente, String tipoidPaciente, String emailPaciente, String estCivilPaciente, String usuario);
	JsonResponse<Paciente> modificarPaciente(Long codPaciente, String identificacionPaciente, String nombrePaciente, String apellidosPaciente,
    		String direccionPaciente,String tipoidPaciente, String ocupacionPaciente, String emailPaciente, String telefonoPaciente, 
    		String generoPaciente, String estCivilPaciente, String usuario);
   // Boolean darBajaPaciente(int codigo, String usuario);
    JsonResponse<List<Paciente>> getPacientes();
	JsonResponse<List<Paciente>> getPacientesByNombre(String Nombre);
	JsonResponse<List<Paciente>> getPacientesByidentificacion( String tipo, String numident);
	JsonResponse<Paciente> getPacienteByCodigo(Long codPaciente);
	JsonResponse<Paciente> buscarPaciente(Long codPaciente);
}
