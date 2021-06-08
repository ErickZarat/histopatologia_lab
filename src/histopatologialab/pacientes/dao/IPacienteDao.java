package histopatologialab.pacientes.dao;

import java.util.List;
import histopatologialab.pacientes.dto.Paciente;

public interface IPacienteDao {
	
    List<Paciente> getPacientes();
	List<Paciente> getPacientesByNombre(String Nombre);
	List<Paciente> getPacientesByidentificacion( String tipo, String numident);
	
    Paciente getPaciente(long codPaciente); 
	Paciente guardarPaciente(Paciente paciente); 
	Paciente modificarPaciente(Paciente paciente);

    List<Paciente> buscarPaciente(String value);
}
