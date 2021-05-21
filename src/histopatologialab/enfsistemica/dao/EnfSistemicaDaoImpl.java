package histopatologialab.enfsistemica.dao;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import histopatologialab.core.DB;
import histopatologialab.core.Estado;
import histopatologialab.core.db.tables.LabEnfermedadSistemica;
import histopatologialab.core.db.tables.records.LabEnfermedadSistemicaRecord;
import histopatologialab.enfsistemica.dto.EnfSistemica;
import org.jooq.DSLContext;
import org.jooq.Record;

public class EnfSistemicaDaoImpl implements IEnfSistemicaDao{
	
    private final DSLContext query = DB.getConexion();
    private final LabEnfermedadSistemica tabla = LabEnfermedadSistemica.LAB_ENFERMEDAD_SISTEMICA;


    public EnfSistemica parseItem(Record record) {
        return new EnfSistemica (
                record.getValue(tabla.COD_ENFERMEDAD_SISTEMICA),
                record.getValue(tabla.NOMBRE_ENFERMEDAD),
                record.getValue(tabla.ESTADO_ENFERMEDAD),
                record.getValue(tabla.CREADO_POR),
                record.getValue(tabla.FECHA_CREACION),
                record.getValue(tabla.MODIFICADO_POR),
                record.getValue(tabla.FECHA_MODIFICACION)
        );
    }
    
    
    @Override
    public List<EnfSistemica> getEnfermedades() {
        List<Record> results = query
                .select(tabla.asterisk())
                .from(tabla)
                .fetch();
        return results.stream().map(this::parseItem).collect(Collectors.toList());
    }

    @Override
    public EnfSistemica getEnfermedad(int codEnfermedad) {
        Record result = query
                .select(tabla.asterisk())
                .from(tabla)
                .where(tabla.COD_ENFERMEDAD_SISTEMICA.eq(codEnfermedad))
                .fetchOne();
        return result != null ? parseItem(result): null;
    }

    @Override
    public EnfSistemica guardarEnfermedad(EnfSistemica enfermedad) {
    	LabEnfermedadSistemicaRecord record =  query.newRecord(tabla);
        record.setNombreEnfermedad(enfermedad.getNombreEnfermedad());
        record.setFechaCreacion(LocalDate.now());
        record.setCreadoPor(enfermedad.getCreadoPor());
        record.setEstadoEnfermedad(enfermedad.getEstado());
        record.store();
        return getEnfermedad(record.getCodEnfermedadSistemica());
    }

    @Override
    public EnfSistemica modificarEnfermedad(EnfSistemica enfermedad) {
        query.update(tabla)
                .set(tabla.NOMBRE_ENFERMEDAD, enfermedad.getNombreEnfermedad())
                .set(tabla.FECHA_MODIFICACION, LocalDate.now())
                .set(tabla.MODIFICADO_POR, enfermedad.getModificadoPor())
                .set(tabla.ESTADO_ENFERMEDAD, enfermedad.getEstado())
                .where(tabla.COD_ENFERMEDAD_SISTEMICA.eq(enfermedad.getCodigoEnfermedad()))
                .execute();
        return getEnfermedad(enfermedad.getCodigoEnfermedad());
    }

    @Override
    public Boolean darDeBaja(int codEnfermedad, String usuario) {
        EnfSistemica enfermedad =   getEnfermedad(codEnfermedad);
        enfermedad.setModificadoPor(usuario);
        enfermedad.setFechaModificacion(LocalDate.now());
        enfermedad.setEstado(Estado.DESHABILITADO.getSlug());

        EnfSistemica enfermedadModificada = modificarEnfermedad(enfermedad);
        return enfermedadModificada != null;
    }

}
