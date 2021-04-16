package histopatologialab.medicamentos.dao;

import histopatologialab.core.DB;
import histopatologialab.medicamentos.dto.PresentacionMedicamento;
import histopatologialab.core.db.tables.LabPresentacionMedicamento;
import histopatologialab.core.db.tables.records.LabPresentacionMedicamentoRecord;
import org.jooq.DSLContext;
import org.jooq.Record;

import java.time.LocalDate;
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
                record.getValue(tabla.MODIFICADO_POR),
                record.getValue(tabla.FECHA_MODIFICACION),
                record.getValue(tabla.ESTADO_MEDICAMENTO)
        );
    }

    @Override
    public List<PresentacionMedicamento> getPresentaciones(int codMedicamento) {
        List<Record> results = query
                .select(tabla.asterisk())
                .from(tabla)
                .where(tabla.COD_MEDICAMENTO.eq(codMedicamento).and(tabla.ESTADO_MEDICAMENTO.notEqual("D")))
                .fetch();
        return results.stream().map(this::parseItem).collect(Collectors.toList());
    }

    @Override
    public PresentacionMedicamento getPresentacion(int codMedicamento, String tipoPresentacion) {
        Record result = query
                .select(tabla.asterisk())
                .from(tabla)
                .where(tabla.COD_MEDICAMENTO.eq(codMedicamento)
                        .and(tabla.TIPO_PRESENTACION.eq(tipoPresentacion))
                ).fetchOne();
        return result != null ? parseItem(result): null;
    }

    @Override
    public PresentacionMedicamento modificarPresentacion(int codMedicamento, String tipoPresentacion, PresentacionMedicamento presentacionMedicamento) {
        query.update(tabla)
                .set(tabla.FECHA_MODIFICACION, LocalDate.now())
                .set(tabla.MODIFICADO_POR, presentacionMedicamento.getModificatoPor())
                .set(tabla.TIPO_PRESENTACION, presentacionMedicamento.getTipoPresentacion())
                .set(tabla.ESTADO_MEDICAMENTO, presentacionMedicamento.getEstadoMedicamento())
                .where(tabla.TIPO_PRESENTACION.eq(tipoPresentacion).and(tabla.COD_MEDICAMENTO.eq(codMedicamento)))
                .execute();
        return getPresentacion(codMedicamento, presentacionMedicamento.getTipoPresentacion());
    }

    @Override
    public Boolean darBajaPresentacion(int codMedicamento, String tipoPresentacion, String usuario) {
        PresentacionMedicamento presentacionMedicamento = getPresentacion(codMedicamento, tipoPresentacion);
        presentacionMedicamento.setEstadoMedicamento("D");
        presentacionMedicamento.setModificatoPor(usuario);
        presentacionMedicamento.setFechaModificacion(LocalDate.now());
        return modificarPresentacion(codMedicamento, tipoPresentacion, presentacionMedicamento) != null;
    }

    @Override
    public PresentacionMedicamento guardarPresentacion(PresentacionMedicamento presentacionMedicamento) {
        LabPresentacionMedicamentoRecord record =  query.newRecord(tabla);

        record.setCodMedicamento(presentacionMedicamento.getCodMedicamento());
        record.setTipoPresentacion(presentacionMedicamento.getTipoPresentacion());
        record.setCreadoPor(presentacionMedicamento.getCreadoPor());
        record.setEstadoMedicamento(presentacionMedicamento.getEstadoMedicamento());
        record.setFechaCreacion(presentacionMedicamento.getFechaCreacion());
        record.store();
        return getPresentacion(presentacionMedicamento.getCodMedicamento(), presentacionMedicamento.getTipoPresentacion());
    }


}
