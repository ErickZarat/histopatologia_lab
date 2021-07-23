package histopatologialab.biopsia.dao;

import histopatologialab.biopsia.dto.Biopsia;
import histopatologialab.core.DB;
import histopatologialab.core.db.tables.LabExamenFrote;
import histopatologialab.core.db.tables.records.LabExamenFroteRecord;
import org.jooq.DSLContext;
import org.jooq.Record;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class BiopsiaDaoImpl implements IBiopsiaDao {

    private final DSLContext query = DB.getConexion();
    private final LabExamenFrote tabla = LabExamenFrote.LAB_EXAMEN_FROTE;


    public Biopsia parseItem(Record record) {
        return new Biopsia(
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
                record.getValue(tabla.FECHA_MODIFICACION)
        );
    }

    @Override
    public Biopsia getByCod(int codBiopsia) {
        Record result = query.select(tabla.asterisk())
                .from(tabla)
                .where(tabla.COD_FROTE.eq(codBiopsia))
                .fetchOne();
        return result != null ? parseItem(result): null;
    }

    @Override
    public Biopsia getByNumBiopsia(String numBiopsia) {
        Record result = query.select(tabla.asterisk())
                .from(tabla)
                .where(tabla.NUM_FROTE.eq(numBiopsia))
                .fetchOne();
        return result != null ? parseItem(result): null;
    }

    @Override
    public List<Biopsia> getByExamen(int codExamen) {
        List<Record> result = query.select(tabla.asterisk())
                .from(tabla)
                .where(tabla.COD_EXAMEN.eq(codExamen))
                .fetch();
        return result.stream().map(this::parseItem).collect(Collectors.toList());
    }

    @Override
    public Biopsia guardarBiopsia(Biopsia biopsia) {
        LabExamenFroteRecord record = query.newRecord(tabla);

        record.setCodExamen(biopsia.getCodExamen());
        record.setCodTincion(biopsia.getCodTincion());
        record.setNumFrote(biopsia.getNumBiopsia());
        record.setNumRecibo(biopsia.getNumRecibo());
        record.setMontoRecibo(biopsia.getMontoRecibo());
        record.setSerieRecibo(biopsia.getSerieRecibo());
        record.setEstadoFrote(biopsia.getEstadoBiopsia());
        record.setUsuarioFrote(biopsia.getUsuarioBiopsia());
        record.setModificadoPor("");
        record.setFechaModificacion(LocalDate.now());

        record.store();
        return getByCod(record.getCodFrote());
    }

    @Override
    public Biopsia modificarBiopsia(Biopsia biopsia, String usuario) {
        LabExamenFroteRecord record = query.newRecord(tabla);
        record.setCodFrote(biopsia.getCodBiopsia());
        record.setCodExamen(biopsia.getCodExamen());
        record.setCodTincion(biopsia.getCodTincion());
        record.setNumFrote(biopsia.getNumBiopsia());
        record.setNumRecibo(biopsia.getNumRecibo());
        record.setMontoRecibo(biopsia.getMontoRecibo());
        record.setSerieRecibo(biopsia.getSerieRecibo());
        record.setEstadoFrote(biopsia.getEstadoBiopsia());
        record.setUsuarioFrote(biopsia.getUsuarioBiopsia());
        record.setModificadoPor("");
        record.setFechaModificacion(LocalDate.now());

        record.update();
        return getByCod(record.getCodFrote());
    }
}
