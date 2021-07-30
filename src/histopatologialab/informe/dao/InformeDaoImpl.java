package histopatologialab.informe.dao;

import histopatologialab.core.DB;
import histopatologialab.core.db.tables.LabInforme;
import histopatologialab.core.db.tables.records.LabExamenBiopsiaRecord;
import histopatologialab.core.db.tables.records.LabInformeRecord;
import histopatologialab.informe.dto.Informe;
import org.jooq.DSLContext;
import org.jooq.Record;

import java.time.LocalDate;

public class InformeDaoImpl implements IInformeDao{
    private final DSLContext query = DB.getConexion();
    private final LabInforme tabla = LabInforme.LAB_INFORME;


    public Informe parseItem(Record record) {
        return new Informe(
                record.getValue(tabla.COD_INFORME),
                record.getValue(tabla.FECHA_INFORME),
                record.getValue(tabla.CLINICA),
                record.getValue(tabla.DIRECCION),
                record.getValue(tabla.SOLICITANTE),
                record.getValue(tabla.DATOS_CLINICOS),
                record.getValue(tabla.DESC_MACROS),
                record.getValue(tabla.DESC_MIRCO),
                record.getValue(tabla.DIAGNOSTICO),
                record.getValue(tabla.USUARIO_INFORME),
                record.getValue(tabla.COD_FROTE),
                record.getValue(tabla.COD_BIOPSIA)
        );
    }

    @Override
    public Informe crearInforme(Informe informe) {
        LabInformeRecord record = query.newRecord(tabla);
        record.setClinica(informe.getClinica());
        record.setFechaInforme(LocalDate.now());
        record.setDireccion(informe.getDireccion());
        record.setSolicitante(informe.getSolicitante());
        record.setDescMacros(informe.getDescMacros());
        record.setDescMirco(informe.getDescMirco());
        record.setDatosClinicos(informe.getDatosClinicos());
        record.setDiagnostico(informe.getDiagnostico());
        record.setUsuarioInforme(informe.getUsuarioInforme());

        if (informe.getCodBiopsia() != null && informe.getCodBiopsia() > 0)
            record.setCodBiopsia(informe.getCodBiopsia());
        if (informe.getCodFrote() != null && informe.getCodFrote() > 0)
            record.setCodFrote(informe.getCodFrote());
        record.store();

        return getInforme(record.getCodInforme());
    }

    @Override
    public Informe getInforme(int codInforme) {
        Record result = query.select(tabla.asterisk())
                .from(tabla)
                .where(tabla.COD_INFORME.eq(codInforme))
                .fetchOne();
        return parseItem(result);
    }

    @Override
    public Informe getInformeByBiopsia(int codBiopsia) {
        Record result = query.select(tabla.asterisk())
                .from(tabla)
                .where(tabla.COD_BIOPSIA.eq(codBiopsia))
                .fetchOne();
        return result != null ? parseItem(result) : null;
    }

    @Override
    public Informe getInformeByFrote(int codFrote) {
        Record result = query.select(tabla.asterisk())
                .from(tabla)
                .where(tabla.COD_FROTE.eq(codFrote))
                .fetchOne();
        return result != null ? parseItem(result) : null;
    }
}
