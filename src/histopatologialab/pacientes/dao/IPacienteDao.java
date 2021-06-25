package histopatologialab.pacientes.dao;

import histopatologialab.pacientes.dto.Paciente;

import java.util.List;

public interface IPacienteDao {
	
    List<Paciente> getPacientes();
	List<Paciente> getPacientesByNombre(String Nombre);
	List<Paciente> getPacientesByidentificacion( String tipo, String numident);
	
    Paciente getPaciente(Long codPaciente); 
	Paciente guardarPaciente(Paciente paciente); 
	Paciente modificarPaciente(Paciente paciente);
	List<Paciente> buscarPaciente(String value);
	Paciente modificarPaciente(Paciente paciente); 
	Paciente getPacienteByID(String tipo, String numident); 

}
