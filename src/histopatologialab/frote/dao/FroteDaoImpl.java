package histopatologialab.frote.dao;

import histopatologialab.core.DB;
import histopatologialab.core.db.tables.LabExamenFrote;
import histopatologialab.core.db.tables.records.LabExamenFroteRecord;
import histopatologialab.frote.dto.Frote;
import org.jooq.DSLContext;
import org.jooq.Record;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FroteDaoImpl implements IFroteDao {

    private final DSLContext query = DB.getConexion();
    private final LabExamenFrote tabla = LabExamenFrote.LAB_EXAMEN_FROTE;


    public Frote parseItem(Record record) {
        return new Frote(
                record.getValue(tabla.COD_FROTE),
                record.getValue(tabla.COD_EXAMEN),
                record.getValue(tabla.NUM_FROTE),
                record.getValue(tabla.NUM_RECIBO),
                record.getValue(tabla.SERIE_RECIBO),
                record.getValue(tabla.MONTO_RECIBO),
                record.getValue(tabla.COD_TINCION),
                record.getValue(tabla.ESTADO_FROTE),
                record.getValue(tabla.USUARIO_FROTE),
                record.getValue(tabla.MODIFICADO_POR),
                record.getValue(tabla.FECHA_MODIFICACION),
                record.getValue(tabla.FECHA)
        );
    }

    @Override
    public Frote getByCod(int codFrote) {
        Record result = query.select(tabla.asterisk())
                .from(tabla)
                .where(tabla.COD_FROTE.eq(codFrote))
                .fetchOne();
        return result != null ? parseItem(result): null;
    }

    @Override
    public Frote getByNumFrote(String numFrote) {
        Record result = query.select(tabla.asterisk())
                .from(tabla)
                .where(tabla.NUM_FROTE.eq(numFrote))
                .fetchOne();
        return result != null ? parseItem(result): null;
    }

    @Override
    public List<Frote> getByExamen(int codExamen) {
        List<Record> result = query.select(tabla.asterisk())
                .from(tabla)
                .where(tabla.COD_EXAMEN.eq(codExamen))
                .fetch();
        return result.stream().map(this::parseItem).collect(Collectors.toList());
    }

    @Override
    public Frote guardarFrote(Frote frote) {
        LabExamenFroteRecord record = query.newRecord(tabla);

        record.setCodExamen(frote.getCodExamen());
        record.setCodTincion(frote.getCodTincion());
        record.setNumFrote(frote.getNumFrote());
        record.setNumRecibo(frote.getNumRecibo());
        record.setMontoRecibo(frote.getMontoRecibo());
        record.setSerieRecibo(frote.getSerieRecibo());
        record.setEstadoFrote(frote.getEstadoFrote());
        record.setUsuarioFrote(frote.getUsuarioFrote());
        record.setModificadoPor("");
        record.setFechaModificacion(LocalDate.now());

        record.store();
        return getByCod(record.getCodFrote());
    }

    @Override
    public Frote modificarFrote(Frote frote, String usuario) {
        LabExamenFroteRecord record = query.newRecord(tabla);
        record.setCodFrote(frote.getCodFrote());
        record.setCodExamen(frote.getCodExamen());
        record.setCodTincion(frote.getCodTincion());
        record.setNumFrote(frote.getNumFrote());
        record.setNumRecibo(frote.getNumRecibo());
        record.setMontoRecibo(frote.getMontoRecibo());
        record.setSerieRecibo(frote.getSerieRecibo());
        record.setEstadoFrote(frote.getEstadoFrote());
        record.setUsuarioFrote(frote.getUsuarioFrote());
        record.setModificadoPor("");
        record.setFechaModificacion(LocalDate.now());

        record.update();
        return getByCod(record.getCodFrote());
    }
}
