package histopatologialab.medicamentos.dao;

import histopatologialab.core.DB;
import histopatologialab.medicamentos.dto.Medicamento;
import histopatologialab.core.db.tables.LabMedicamento;
import histopatologialab.core.db.tables.records.LabMedicamentoRecord;
import org.jooq.DSLContext;
import org.jooq.Record;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MedicamentosDaoImpl implements IMedicamentosDao {

    private final DSLContext query = DB.getConexion();
    private final LabMedicamento tabla = LabMedicamento.LAB_MEDICAMENTO;


    public Medicamento parseItem(Record record) {
        return new Medicamento (
                record.getValue(tabla.COD_MEDICAMENTO),
                record.getValue(tabla.NOMBRE_MEDICAMENTO),
                record.getValue(tabla.ESTADO_MEDICAMENTO),
                record.getValue(tabla.CREADO_POR),
                record.getValue(tabla.FECHA_CREACION),
                record.getValue(tabla.MODIFICADO_POR),
                record.getValue(tabla.FECHA_MODIFICACION)
        );
    }

    @Override
    public List<Medicamento> getMedicamentos() {
        List<Record> results = query
                .select(tabla.asterisk())
                .from(tabla)
                .fetch();
        return results.stream().map(this::parseItem).collect(Collectors.toList());
    }

    @Override
    public List<Medicamento> getMedicamentos(int limit) {
        List<Record> results = query
                .select(tabla.asterisk())
                .from(tabla)
                .where(tabla.ESTADO_MEDICAMENTO.notEqualIgnoreCase("D"))
                .orderBy(tabla.COD_MEDICAMENTO)
                .limit(limit)
                .fetch();
        return results.stream().map(this::parseItem).collect(Collectors.toList());
    }

    @Override
    public List<Medicamento> getMedicamentos(int lastId, int limit) {
        List<Record> results = query
                .select(tabla.asterisk())
                .from(tabla)
                .where(tabla.ESTADO_MEDICAMENTO.notEqualIgnoreCase("D"))
                .orderBy(tabla.COD_MEDICAMENTO)
                .seek(lastId)
                .limit(limit)
                .fetch();
        return results.stream().map(this::parseItem).collect(Collectors.toList());
    }


    public List<Medicamento> getMedicamentosPaginated() {
        List<Record> results = query
                .select(tabla.asterisk())
                .from(tabla)
                .where(tabla.ESTADO_MEDICAMENTO.notEqualIgnoreCase("D"))
                .fetch();
        return results.stream().map(this::parseItem).collect(Collectors.toList());
    }

    @Override
    public Medicamento getMedicamento(int codMedicamento) {
        Record result = query
                .select(tabla.asterisk())
                .from(tabla)
                .where(tabla.COD_MEDICAMENTO.eq(codMedicamento))
                .fetchOne();
        return result != null ? parseItem(result): null;
    }

    @Override
    public Medicamento guardarMedicamento(Medicamento medicamento) {
        LabMedicamentoRecord record =  query.newRecord(tabla);
        record.setNombreMedicamento(medicamento.getNombreMedicamento());
        record.setFechaCreacion(LocalDate.now());
        record.setCreadoPor("");
        record.setEstadoMedicamento("");
        record.store();
        return getMedicamento(record.getCodMedicamento());
    }

    @Override
    public Medicamento modificarMedicamento(Medicamento medicamento) {
        query.update(tabla)
                .set(tabla.NOMBRE_MEDICAMENTO, medicamento.getNombreMedicamento())
                .set(tabla.FECHA_MODIFICACION, LocalDate.now())
                .set(tabla.MODIFICADO_POR, medicamento.getModificadoPor())
                .set(tabla.ESTADO_MEDICAMENTO, medicamento.getEstado())
                .where(tabla.COD_MEDICAMENTO.eq(medicamento.getCodigoMedicamento()))
                .execute();
        return getMedicamento(medicamento.getCodigoMedicamento());
    }

    @Override
    public Boolean darDeBaja(int codMedicamento, String usuario) {
        Medicamento medicamento = getMedicamento(codMedicamento);
        medicamento.setModificadoPor(usuario);
        medicamento.setFechaModificacion(LocalDate.now());
        medicamento.setEstado("D");

        Medicamento medicamentoModificado = modificarMedicamento(medicamento);
        return medicamentoModificado != null;
    }
}
