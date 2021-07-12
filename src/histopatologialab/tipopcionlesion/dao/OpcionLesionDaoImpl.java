package histopatologialab.tipopcionlesion.dao;

import histopatologialab.core.DB;
import histopatologialab.core.Estado;
import histopatologialab.core.db.tables.LabTipoOpcionLesion;
import histopatologialab.core.db.tables.records.LabTipoOpcionLesionRecord;
import histopatologialab.tipopcionlesion.dto.OpcionLesion;
import org.jooq.DSLContext;
import org.jooq.Record;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class OpcionLesionDaoImpl implements IOpcionLesionDao{
	
    private final DSLContext query = DB.getConexion();
    private final LabTipoOpcionLesion tabla = LabTipoOpcionLesion.LAB_TIPO_OPCION_LESION;
    
    public OpcionLesion parseItem(Record record) {
        return new OpcionLesion (
                record.getValue(tabla.COD_TIPO_OPCION_LESION),
                record.getValue(tabla.NOMBRE_TIPO_OPCION),
                record.getValue(tabla.VALOR_TIPO_OPCION),
                record.getValue(tabla.ESTADO_TIPO_OPCION),
                record.getValue(tabla.CREADO_POR),
                record.getValue(tabla.FECHA_CREACION),
                record.getValue(tabla.MODIFICADO_POR),
                record.getValue(tabla.FECHA_MODIFICACION)
        );
    }

    @Override
    public List<OpcionLesion> getOpcionesByTipo(String tipOpcion){
    	 List<Record> results = query
                 .select(tabla.asterisk())
                 .from(tabla)
                 .where(tabla.NOMBRE_TIPO_OPCION.eq(tipOpcion)
                		 //.and(tabla.ESTADO_TIPO_OPCION.notEqualIgnoreCase(Estado.DESHABILITADO.getSlug()))
                         )
                 .orderBy(tabla.COD_TIPO_OPCION_LESION.desc())
                 .fetch();
         return results.stream().map(this::parseItem).collect(Collectors.toList());
    }

    @Override
    public OpcionLesion getOpcion(int codigoOpcion) {
        Record result = query
                .select(tabla.asterisk())
                .from(tabla)
                .where(tabla.COD_TIPO_OPCION_LESION.eq(codigoOpcion))
                .fetchOne();
        return result != null ? parseItem(result): null;    	
    }
    
    @Override    
    public OpcionLesion guardarOpcionLesion(OpcionLesion tipopcionlesion) {
    	LabTipoOpcionLesionRecord record =  query.newRecord(tabla);
    	record.setNombreTipoOpcion(tipopcionlesion.getNombreOpcion());
    	record.setValorTipoOpcion(tipopcionlesion.getValor());
    	record.setFechaCreacion(LocalDate.now());
    	record.setCreadoPor(tipopcionlesion.getCreadoPor());
    	record.setEstadoTipoOpcion(tipopcionlesion.getEstado());
    	record.store();   
    	return getOpcion(record.getCodTipoOpcionLesion());   
    }
    
    
    @Override    
    public OpcionLesion modificarOpcionLesion(OpcionLesion tipopcionlesion) {
        query.update(tabla)
        .set(tabla.VALOR_TIPO_OPCION, tipopcionlesion.getValor())
        .set(tabla.FECHA_MODIFICACION, LocalDate.now())
        .set(tabla.MODIFICADO_POR, tipopcionlesion.getModificadoPor())
        .set(tabla.ESTADO_TIPO_OPCION, tipopcionlesion.getEstado())
        .where(tabla.COD_TIPO_OPCION_LESION.eq(tipopcionlesion.getCodigoOpcion()))
        .execute();
        return getOpcion(tipopcionlesion.getCodigoOpcion());    	
    }
    

    @Override
    public Boolean darDeBaja(int codigoOpcion, String usuario) {
    	OpcionLesion tipopcionlesion = getOpcion(codigoOpcion); 
    	tipopcionlesion.setModificadoPor(usuario);
    	tipopcionlesion.setFechaModificacion(LocalDate.now());
    	tipopcionlesion.setEstado(Estado.DESHABILITADO.getSlug());
    	
    	OpcionLesion tipopcionlesionmodificado = modificarOpcionLesion(tipopcionlesion);
    	return tipopcionlesionmodificado != null;
    	
    }

    @Override
    public List<OpcionLesion> getOpciones(){
        List<Record> results = query
                .select(tabla.asterisk())
                .from(tabla)
                .fetch();

        return results.stream().map(this::parseItem).collect(Collectors.toList());
    }
    
    @Override
    public List<OpcionLesion> getOpcionesByEstado(){
        List<Record> results = query
                .select(tabla.asterisk())
                .from(tabla)
                .where(tabla.ESTADO_TIPO_OPCION.notEqualIgnoreCase(Estado.DESHABILITADO.getSlug()))                
                .fetch();

        return results.stream().map(this::parseItem).collect(Collectors.toList());
    }
    
    
    public Boolean cambioEstadoOpcion(int codigoOpcion,String estado, String usuario) {
    	OpcionLesion tipopcionlesion = getOpcion(codigoOpcion); 
    	tipopcionlesion.setModificadoPor(usuario);
    	
        String valEstado = new String("Alta");
          
        if (estado.equals(valEstado)) {
        	tipopcionlesion.setEstado(Estado.DESHABILITADO.getSlug());
        	} 
        else {
        	tipopcionlesion.setEstado(Estado.HABILITADO.getSlug());
        	}
        tipopcionlesion.setFechaModificacion(LocalDate.now());

    	OpcionLesion tipopcionlesionmodificado = modificarOpcionLesion(tipopcionlesion);
    	return tipopcionlesionmodificado != null;    	
    }
    
    @Override
    public OpcionLesion getOpcionByTipoYValor(String tipOpcion, String valor){
    	Record result = query
                 .select(tabla.asterisk())
                 .from(tabla)
                 .where ( tabla.NOMBRE_TIPO_OPCION.eq(tipOpcion)
                		 .and(tabla.VALOR_TIPO_OPCION.eq(valor)) )             
                 .fetchOne();
    	 return result != null ? parseItem(result): null;
    }
    
}
