package me.astridcortez.hispatologialab.medicamentos.dao;

import me.astridcortez.hispatologialab.core.DB;
import me.astridcortez.hispatologialab.medicamentos.dto.PresentacionMedicamento;
import me.astridcortez.hispatologialab.core.db.tables.LabPresentacionMedicamento;
import me.astridcortez.hispatologialab.core.db.tables.records.LabPresentacionMedicamentoRecord;
import org.jooq.DSLContext;
import org.jooq.Record;

import java.util.List;
import java.util.stream.Collectors;

public class PresentacionMedicamentosDaoImpl implements IPresentacionMedicamentosDao {

    private final DSLContext query = DB.getConexion();
    private final LabPresentacionMedicamento tabla = LabPresentacionMedicamento.LAB_PRESENTACION_MEDICAMENTO;


    public PresentacionMedicamento parseItem(Record record) {
        return new PresentacionMedicamento (
                record.getValue(tabla.COD_MEDICAMENTO),
                record.getValue(tabla.TIPO_PRESENTACION),
                record.getValue(tabla.CREADO_POR),
                record.getValue(tabla.FECHA_CREACION),
                record.getValue(tabla.MODIFICADO_POR)
        );
    }

    @Override
    public List<PresentacionMedicamento> getPresentaciones(int codMedicamento) {
        List<Record> results = query
                .select(tabla.asterisk())
                .from(tabla)
                .fetch();
        return results.stream().map(this::parseItem).collect(Collectors.toList());
    }

    @Override
    public PresentacionMedicamento getPresentacion(int codMedicamento, int tipoPresentacion) {
        Record result = query
                .select(tabla.asterisk())
                .from(tabla)
                .where(tabla.COD_MEDICAMENTO.eq(codMedicamento)
                        .and(tabla.TIPO_PRESENTACION.eq(tipoPresentacion))
                ).fetchOne();
        return result != null ? parseItem(result): null;
    }

    @Override
    public PresentacionMedicamento guardarPresentacion(PresentacionMedicamento presentacionMedicamento) {
        LabPresentacionMedicamentoRecord record =  query.newRecord(tabla);

        record.setCodMedicamento(presentacionMedicamento.getCodMedicamento());
        record.setTipoPresentacion(presentacionMedicamento.getTipoPresentacion());
        record.setCreadoPor(presentacionMedicamento.getCreadoPor());
        record.setEstadoMedicamento("");
        record.setFechaCreacion(presentacionMedicamento.getFechaCreacion());
        record.insert();
        return getPresentacion(presentacionMedicamento.getCodMedicamento(), presentacionMedicamento.getTipoPresentacion());
    }


}
