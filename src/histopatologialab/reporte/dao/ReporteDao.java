package histopatologialab.reporte.dao;

import histopatologialab.core.DB;
import histopatologialab.core.db.tables.LabExamen;
import histopatologialab.core.db.tables.LabReporteBiopsiaVw;
import histopatologialab.core.db.tables.LabReporteExamenVw;
import histopatologialab.core.db.tables.LabReporteFroteVw;
import org.jooq.DSLContext;

import java.time.LocalDate;

public class ReporteDao {
    private final DSLContext query = DB.getConexion();
    private final LabReporteExamenVw repExamen = LabReporteExamenVw.LAB_REPORTE_EXAMEN_VW;
    private final LabReporteBiopsiaVw repBiopsia = LabReporteBiopsiaVw.LAB_REPORTE_BIOPSIA_VW;
    private final LabReporteFroteVw repFrote = LabReporteFroteVw.LAB_REPORTE_FROTE_VW;

    public String getReporteExamen(LocalDate from, LocalDate to){
        return query
                .select(repExamen.asterisk())
                .from(repExamen)
                .where(repExamen.FECHA_EXAMEN.between(from, to))
                .fetch()
                .formatCSV();
    }

    public String getReporteBiopsia(LocalDate from, LocalDate to){
        return query
                .select(repBiopsia.asterisk())
                .from(repBiopsia)
                .where(repBiopsia.FEC_BIOPSIA.between(from, to))
                .fetch()
                .formatCSV();
    }

    public String getReporteFrote(LocalDate from, LocalDate to){
        return query
                .select(repFrote.asterisk())
                .from(repFrote)
                .where(repFrote.FEC_FROTE.between(from, to))
                .fetch()
                .formatCSV();
    }
}
