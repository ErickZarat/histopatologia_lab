package histopatologialab.receta.dao;

import histopatologialab.core.DB;
import histopatologialab.core.db.tables.LabExamen;
import histopatologialab.core.db.tables.LabExamenReceta;
import histopatologialab.core.db.tables.LabMedicamento;
import histopatologialab.core.db.tables.LabPresentacionMedicamento;
import histopatologialab.core.db.tables.records.LabExamenRecetaRecord;
import histopatologialab.receta.dto.Receta;
import org.jooq.DSLContext;
import org.jooq.Record;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class RecetaDaoImpl implements IRecetaDao {
    private final DSLContext query = DB.getConexion();
    private final LabExamenReceta tabla = LabExamenReceta.LAB_EXAMEN_RECETA;
    private final LabMedicamento tablaMed = LabMedicamento.LAB_MEDICAMENTO;
    private final LabPresentacionMedicamento tablaPre = LabPresentacionMedicamento.LAB_PRESENTACION_MEDICAMENTO;

    private Receta parseItem(Record record) {
        Receta receta = new Receta(
                record.getValue(tabla.COD_RECETA),
                record.getValue(tabla.COD_EXAMEN),
                record.getValue(tabla.COD_PRESENTACION_MEDICAMENTO),
                record.getValue(tabla.NUM_RECETA),
                record.getValue(tabla.NOTAS),
                record.getValue(tabla.CREADO_POR),
                record.getValue(tabla.MODIFICADO_POR),
                record.getValue(tabla.FECHA_MODIFICACION),
                record.getValue(tabla.FECHA_CREACION)
        );
        receta.setNombreMedicamento(record.getValue(tablaMed.NOMBRE_MEDICAMENTO));
        receta.setPresentacion(record.getValue(tablaPre.TIPO_PRESENTACION));
        return receta;
    }

    @Override
    public List<Receta> getRecetaByExamen(Integer codExamen) {
        List<Record> result = query
                .select(tabla.asterisk())
                .from(tabla)
                .leftJoin(tablaPre).on(tablaPre.COD_PRESENTACION.eq(tabla.COD_PRESENTACION_MEDICAMENTO))
                .leftJoin(tablaMed).on(tablaMed.COD_MEDICAMENTO.eq(tablaPre.COD_MEDICAMENTO))
                .where(tabla.COD_EXAMEN.eq(codExamen))
                .fetch();

        return result.stream().map(this::parseItem).collect(Collectors.toList());
    }

    @Override
    public List<Receta> guardarReceta(List<Receta> recetas) {
        if (recetas == null && recetas.isEmpty())
            return null;
        Integer codExamen = recetas.get(0).getCodExamen();
        for (Receta receta : recetas) {
            LabExamenRecetaRecord record = query.newRecord(tabla);
            record.setCodExamen(receta.getCodExamen());
            record.setNumReceta(receta.getNumReceta());
            record.setCreadoPor(receta.getCreadoPor());
            record.setFechaCreacion(LocalDate.now());
            record.setNotas(receta.getNotas());
            record.setCodPresentacionMedicamento(receta.getCodPresentacionMedicamento());
            record.store();
        }

        return getRecetaByExamen(codExamen);
    }
}
