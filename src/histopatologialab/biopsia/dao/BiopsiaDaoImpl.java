package histopatologialab.biopsia.dao;

import histopatologialab.biopsia.dto.Biopsia;
import histopatologialab.consultas.dto.Examen;
import histopatologialab.core.DB;
import histopatologialab.core.db.tables.LabExamenBiopsia;
import histopatologialab.core.db.tables.LabExamenImagen;
import histopatologialab.core.db.tables.records.LabExamenBiopsiaRecord;
import histopatologialab.core.db.tables.records.LabExamenImagenRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.tinylog.Logger;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class BiopsiaDaoImpl implements IBiopsiaDao {

    private final DSLContext query = DB.getConexion();
    private final LabExamenBiopsia tabla = LabExamenBiopsia.LAB_EXAMEN_BIOPSIA;
    private final LabExamenImagen tablaImg = LabExamenImagen.LAB_EXAMEN_IMAGEN;


    public Biopsia parseItem(Record record) {
        Biopsia biopsia = new Biopsia(
                record.getValue(tabla.COD_BIOPSIA),
                record.getValue(tabla.COD_EXAMEN),
                record.getValue(tabla.NUM_BIOPSIA),
                record.getValue(tabla.NUM_RECIBO),
                record.getValue(tabla.SERIE_RECIBO),
                record.getValue(tabla.MONTO_RECIBO),
                record.getValue(tabla.ESTADO_BIOPSIA),
                record.getValue(tabla.USUARIO_BIOPSIA),
                record.getValue(tabla.MODIFICADO_POR),
                record.getValue(tabla.FECHA_MODIFICACION),
                record.getValue(tabla.FECHA),
                record.getValue(tabla.MUESTRA_ESTUDIO),
                record.getValue(tabla.OBSERVACIONES),
                record.getValue(tabla.INSTRUMENTO),
                record.getValue(tabla.TIPO_CIRUGIA),
                record.getValue(tabla.PROCEDIMIENTO)
        );
        if (biopsia != null) {
            biopsia.setImagenes(this.getImages(biopsia.getCodBiopsia()));
        }

        return biopsia;
    }

    private List<String> getImages(int codBiopsia) {
        return query.select(tablaImg.RUTA_IMAGEN).from(tablaImg).where(tablaImg.COD_BIOPSIA.eq(codBiopsia)).fetch(tablaImg.RUTA_IMAGEN, String.class);
    }

    private void guardarImagenes(Biopsia biopsia) {
        if (biopsia.getImagenes() == null){
            Logger.info("ignore null images");
            return;
        }
        for (String img: biopsia.getImagenes()){
            LabExamenImagenRecord record = query.newRecord(tablaImg);
            record.setCodBiopsia(biopsia.getCodBiopsia());
            record.setFechaCreacion(LocalDate.now());
            String[] parts = img.split("/");
            record.setNombreImagen(parts[parts.length - 1]);
            record.setNumImagen(biopsia.getImagenes().indexOf(img));
            record.setRutaImagen(img);
            
            Logger.info("insert images");

            query.insertInto(tablaImg).set(record).execute();
        }
    }

    @Override
    public Biopsia getByCod(int codBiopsia) {
        Record result = query.select(tabla.asterisk())
                .from(tabla)
                .where(tabla.COD_BIOPSIA.eq(codBiopsia))
                .fetchOne();
        return result != null ? parseItem(result): null;
    }

    @Override
    public Biopsia getByNumBiopsia(String numBiopsia) {
        Record result = query.select(tabla.asterisk())
                .from(tabla)
                .where(tabla.NUM_BIOPSIA.eq(numBiopsia))
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

    private String getNextNumber(LocalDate date) {
        if(date == null) date = LocalDate.now();
        date = date.withDayOfMonth(1);
        int newNumber = query
                .fetchCount(tabla, tabla.FECHA.greaterOrEqual(date));

        return (newNumber + 1) + "-" + date.getMonthValue() + "-" + date.getYear();
    }

    @Override
    public Biopsia guardarBiopsia(Biopsia biopsia) {
        LabExamenBiopsiaRecord record = query.newRecord(tabla);

        record.setCodExamen(biopsia.getCodExamen());
        record.setNumBiopsia(getNextNumber(biopsia.getFecha()));
        record.setNumRecibo(biopsia.getNumRecibo());
        record.setMontoRecibo(biopsia.getMontoRecibo());
        record.setSerieRecibo(biopsia.getSerieRecibo());
        record.setEstadoBiopsia(biopsia.getEstadoBiopsia());
        record.setUsuarioBiopsia(biopsia.getUsuarioBiopsia());
        record.setModificadoPor("");
        record.setFechaModificacion(LocalDate.now());
        record.setFecha(LocalDate.now());

        record.store();

        guardarImagenes(biopsia);

        return getByCod(record.getCodBiopsia());
    }

    @Override
    public Biopsia modificarBiopsia(Biopsia biopsia, String usuario, Boolean saveImage) {
        LabExamenBiopsiaRecord record = query.newRecord(tabla);
        record.setCodBiopsia(biopsia.getCodBiopsia());
//        record.setCodExamen(biopsia.getCodExamen());
//        record.setNumBiopsia(biopsia.getNumBiopsia());
//        record.setNumRecibo(biopsia.getNumRecibo());
//        record.setMontoRecibo(biopsia.getMontoRecibo());
//        record.setSerieRecibo(biopsia.getSerieRecibo());
        record.setEstadoBiopsia(biopsia.getEstadoBiopsia());
        record.setUsuarioBiopsia(biopsia.getUsuarioBiopsia());
        record.setModificadoPor(usuario);
        record.setFechaModificacion(LocalDate.now());
        record.setObservaciones(biopsia.getObservaciones());
        record.setMuestraEstudio(biopsia.getMuestraEstudio());
        record.setInstrumento(biopsia.getInstrumento());
        record.setProcedimiento(biopsia.getProcedimiento());
        record.setTipoCirugia(biopsia.getTipoCirugia());

        if (saveImage) {
        	guardarImagenes(biopsia);
        }
        
        record.update();
        return getByCod(record.getCodBiopsia());
    }
}
