package histopatologialab.pacientes.dao;

import histopatologialab.core.DB;
import histopatologialab.core.db.tables.LabPaciente;
import histopatologialab.core.db.tables.records.LabPacienteRecord;
import histopatologialab.pacientes.dto.Paciente;
import org.jooq.DSLContext;
import org.jooq.Record;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PacienteDaoImpl implements IPacienteDao {
	
	 private final DSLContext query = DB.getConexion();
	 private final LabPaciente tablapaciente = LabPaciente.LAB_PACIENTE;
			 
	 
	 public Paciente parseItem(Record record) {
	        return new Paciente (
	        		record.getValue(tablapaciente.COD_PACIENTE), 
	        		record.getValue(tablapaciente.IDENTIFICACION), 
	        		record.getValue(tablapaciente.NOMBRE), 
	        		record.getValue(tablapaciente.APELLIDOS), 
	        		record.getValue(tablapaciente.DIRECCION), 
	        		record.getValue(tablapaciente.TELEFONO), 
	        		record.getValue(tablapaciente.FECHANACIMIENTO), 
	        		record.getValue(tablapaciente.GENERO), 
	        		record.getValue(tablapaciente.OCUPACION), 
	        		record.getValue(tablapaciente.TIPO_IDENTIFICACION), 
	        		record.getValue(tablapaciente.EMAIL),
	        		record.getValue(tablapaciente.ESTADOCIVIL),
	        		record.getValue(tablapaciente.CREADOPOR),
	        		record.getValue(tablapaciente.FECHACREACION),
	        		record.getValue(tablapaciente.MODIFICADOPOR), 
	        		record.getValue(tablapaciente.FECHAMODIFICACION),
	        		record.getValue(tablapaciente.NUM_FICHA)
	        );
	    }
	 
	 @Override
	    public List<Paciente> getPacientes() {
		 List<Record> results = query
				 			.select(tablapaciente.asterisk())
				 	.from (tablapaciente)
				 	.orderBy(tablapaciente.COD_PACIENTE)
         			.fetch();
	        return results.stream().map(this::parseItem).collect(Collectors.toList());
	 }
	    
	 
	 public List<Paciente> getPacientesByNombre(String Nombre){
		 List<Record> results = query
		 			.select(tablapaciente.asterisk())
		 	.from (tablapaciente)
            .where (tablapaciente.NOMBRE.like("%" + Nombre +"%", '!'))
            .orderBy(tablapaciente.NOMBRE.asc())
            .fetch();
		 	return results.stream().map(this::parseItem).collect(Collectors.toList());
		 
	 }
	 
	 @Override
	  public List<Paciente> getPacientesByidentificacion( String tipo, String numident) {
	  		List<Record> results = query
			.select(tablapaciente.asterisk())
			.from (tablapaciente)
			.where (tablapaciente.IDENTIFICACION.like("%" + numident +"%", '!'))
			.orderBy(tablapaciente.NOMBRE.asc())
			.fetch();
	 		return results.stream().map(this::parseItem).collect(Collectors.toList());
}

		
	  @Override
	  public Paciente getPaciente(Long codPaciente) {
	        Record result = query
	    			.select(tablapaciente.asterisk())
	    			.from (tablapaciente)
	    			.where(tablapaciente.COD_PACIENTE.equal(codPaciente))
	                .fetchOne();
	        return result != null ? parseItem(result): null;
	 }

	 
	 @Override
	  public Paciente guardarPaciente(Paciente paciente) {
		 
	        LabPacienteRecord registro2 = query.newRecord(tablapaciente);
	          	registro2.setIdentificacion(paciente.getIdentificacionPaciente());
	          	registro2.setNombre(paciente.getNombrePaciente());
	          	registro2.setApellidos(paciente.getApellidosPaciente());
	        	registro2.setEmail(paciente.getEmailPaciente());
	        	registro2.setDireccion(paciente.getDireccionPaciente());
	        	registro2.setTelefono(paciente.getTelefonoPaciente());
	        	registro2.setFechanacimiento(paciente.getFecNacimientoPaciente());
	        	registro2.setGenero(paciente.getGeneroPaciente());
	        	registro2.setOcupacion(paciente.getOcupacionPaciente());
	        	registro2.setTipoIdentificacion(paciente.getTipoidPaciente());
	        	registro2.setEstadocivil(paciente.getEstCivilPaciente());
	        	registro2.setFechacreacion(LocalDate.now());      	
	        	registro2.setCreadopor(paciente.getCreadoPor());
	        	registro2.setNumFicha(paciente.getNumFicha());
	        	registro2.store();
	        
	        return getPaciente(registro2.getCodPaciente());	 
	 }
	
	 @Override
	  public Paciente modificarPaciente(Paciente paciente) {
	        query.update(tablapaciente)
            .set(tablapaciente.IDENTIFICACION,paciente.getIdentificacionPaciente())
            .set(tablapaciente.NOMBRE, paciente.getNombrePaciente())
            .set(tablapaciente.APELLIDOS, paciente.getApellidosPaciente())
            .set(tablapaciente.DIRECCION,paciente.getDireccionPaciente())
            .set(tablapaciente.EMAIL,paciente.getEmailPaciente()) 
            .set(tablapaciente.ESTADOCIVIL, paciente.getEstCivilPaciente())
            .set(tablapaciente.OCUPACION,paciente.getOcupacionPaciente())
            .set(tablapaciente.GENERO, paciente.getGeneroPaciente())
            .set(tablapaciente.FECHANACIMIENTO, paciente.getFecNacimientoPaciente())
            .set(tablapaciente.FECHAMODIFICACION, LocalDate.now())
            .set(tablapaciente.MODIFICADOPOR, paciente.getModificadoPor())
            .set(tablapaciente.NUM_FICHA, paciente.getNumFicha())
            .where(tablapaciente.COD_PACIENTE.eq(paciente.getCodigoPaciente()))
            .execute();
	        return getPaciente(paciente.getCodigoPaciente());
	 }

	@Override
	public List<Paciente> buscarPaciente(String value) {
		List<Record> results = query.select(tablapaciente.asterisk())
				.from(tablapaciente)
				.where(
						tablapaciente.NOMBRE.containsIgnoreCase(value)
								.or(tablapaciente.APELLIDOS.containsIgnoreCase(value))
								.or(tablapaciente.IDENTIFICACION.containsIgnoreCase(value))
								.or(tablapaciente.TELEFONO.containsIgnoreCase(value))
				).fetch();
		return results.stream().map(this::parseItem).collect(Collectors.toList());
	}


	 
	 @Override
	  public Paciente getPacienteByID(String tipo, String numident)
	  {  if (numident == "") {
		  	return null; 
	  	} else {
			 Record result = query
				.select(tablapaciente.asterisk())
				.from (tablapaciente)
				.where (tablapaciente.IDENTIFICACION.eq(numident)
				.and(tablapaciente.TIPO_IDENTIFICACION.eq(tipo)))
		      .fetchOne();
	  	return result != null ? parseItem(result): null;	  	
	  	}
	  }	 
	 
}
