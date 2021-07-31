package histopatologialab.diagnostico.dao;


import histopatologialab.core.DB;
import histopatologialab.core.Estado;
import histopatologialab.core.db.tables.LabDiagnostico;
import histopatologialab.core.db.tables.records.LabDiagnosticoRecord;
import histopatologialab.diagnostico.dto.Diagnostico;
import org.jooq.DSLContext;
import org.jooq.Record;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


public class DiagnosticoDaoImpl implements IDiagnosticoDao {

	 private final DSLContext query = DB.getConexion();
	 private final LabDiagnostico tabla = LabDiagnostico.LAB_DIAGNOSTICO;
	 
	
	 public Diagnostico parseItem(Record record) {
	        return new Diagnostico (
	                record.getValue(tabla.COD_DIAGNOSTICO),
	                record.getValue(tabla.NOMBRE_DIAGNOSTICO),
	                record.getValue(tabla.ESTADO_DIAGNOSTICO),
	                record.getValue(tabla.FECHA_CREACION),
	                record.getValue(tabla.CREADO_POR),
	                record.getValue(tabla.MODIFICADO_POR),
	                record.getValue(tabla.FECHA_MODIFICACION)
	        );
	    }
	    
	
	

	@Override
	public List <Diagnostico> getDiagnosticos()
	// buscar todos los diagnosticos	
	{ 	List<Record> results = query
    	.select(tabla.asterisk())
    	.from(tabla)
    	.fetch();
		return results.stream().map(this::parseItem).collect(Collectors.toList());
	}

	@Override
	public List <Diagnostico> getDiagnosticosHabilitados()
	// buscar todos los diagnosticos
	{ 	List<Record> results = query
			.select(tabla.asterisk())
			.from(tabla)
			.where(tabla.ESTADO_DIAGNOSTICO.eq(Estado.HABILITADO.getSlug()))
			.fetch();
		return results.stream().map(this::parseItem).collect(Collectors.toList());
	}
	
	
	@Override
	public Diagnostico getDiagnostico(Long codigoDiagnostico)
	// regresa los datos del diagnostico, buscados por id de diagnostico
	{ 	Record result = query
    		.select(tabla.asterisk())
    		.from(tabla)
    		.where(tabla.COD_DIAGNOSTICO.eq(codigoDiagnostico))
    		.fetchOne();
		return result != null ? parseItem(result): null;
		
	}
	
	
	@Override
	public Diagnostico guardarDiagnostico(Diagnostico diagnostico)
	{ 	LabDiagnosticoRecord record = query.newRecord(tabla);
		record.setNombreDiagnostico(diagnostico.getNombreDiagnostico());
		record.setEstadoDiagnostico(diagnostico.getEstado());
		record.setFechaCreacion(LocalDate.now());
		record.setCreadoPor(diagnostico.getCreadoPor());
		record.store();

		return getDiagnostico(record.getCodDiagnostico());
	}
	
	
	@Override
	public Diagnostico modificarDiagnostico(Diagnostico diagnostico) {
	// modificar los datos de un diagnostico, ya sea padre, con el idpadre = 0, o un diagnostico hijo
		query.update(tabla)
	        .set(tabla.NOMBRE_DIAGNOSTICO, diagnostico.getNombreDiagnostico())
	        .set(tabla.FECHA_MODIFICACION, LocalDate.now())
	        .set(tabla.MODIFICADO_POR, diagnostico.getModificadoPor())
	        .set(tabla.ESTADO_DIAGNOSTICO, diagnostico.getEstado())
	        .where(tabla.COD_DIAGNOSTICO.eq(diagnostico.getCodigoDiagnostico()))
	        .execute();
		return getDiagnostico(diagnostico.getCodigoDiagnostico());
	}
	
	@Override
	public Boolean darDeBajaDiagnostico(Long codigoDiagnostico, String usuario)
	// dar de baja un diagnostico
	{	Diagnostico diagnostico = getDiagnostico(codigoDiagnostico);
		diagnostico.setEstado(Estado.DESHABILITADO.getSlug());
		diagnostico.setModificadoPor(usuario);
		diagnostico.setFechaModificacion(LocalDate.now());
		
		Diagnostico diagnosticoModificado = modificarDiagnostico(diagnostico);
		return diagnosticoModificado  != null;		
	}
	
	@Override
	public   Boolean cambioEstadoDiagnostico(Long codigoDiagnostico, String estadoNuevo, String usuario)
	{   Diagnostico diagnostico =   getDiagnostico(codigoDiagnostico);
        diagnostico.setModificadoPor(usuario);
        String valEstado = new String("Alta");
        System.out.println("estado validar");
        System.out.println(valEstado);
        System.out.println("nuevo estado");
        System.out.println(estadoNuevo); 
          
        if (estadoNuevo.equals(valEstado)) {
            System.out.println("va a deshabilitar");
        	diagnostico.setEstado(Estado.DESHABILITADO.getSlug());
        	} 
        else {
            System.out.println("va a habilitar ");
        	diagnostico.setEstado(Estado.HABILITADO.getSlug());
        	}
        diagnostico.setFechaModificacion(LocalDate.now());
		
        Diagnostico diagnosticoModificado = modificarDiagnostico(diagnostico);
        return diagnosticoModificado != null;
		
	}
	
	@Override
	public Diagnostico getDiagnosticoByNombre(String nombreDiagnostico)
	{	Record result = query
            .select(tabla.asterisk())
            .from(tabla)
            .where(tabla.NOMBRE_DIAGNOSTICO.eq(nombreDiagnostico))
            .fetchOne();
    	return result != null ? parseItem(result): null;
	}    
	
}
