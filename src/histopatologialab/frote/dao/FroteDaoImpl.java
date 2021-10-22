package histopatologialab.frote.dao;

import histopatologialab.biopsia.dto.Biopsia;
import histopatologialab.core.DB;
import histopatologialab.core.db.tables.LabExamenFrote;
import histopatologialab.core.db.tables.LabExamenImagen;
import histopatologialab.core.db.tables.records.LabExamenFroteRecord;
import histopatologialab.core.db.tables.records.LabExamenImagenRecord;
import histopatologialab.frote.dto.Frote;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.tinylog.Logger;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FroteDaoImpl implements IFroteDao {

    private final DSLContext query = DB.getConexion();
    private final LabExamenFrote tabla = LabExamenFrote.LAB_EXAMEN_FROTE;
    private final LabExamenImagen tablaImg = LabExamenImagen.LAB_EXAMEN_IMAGEN;


    public Frote parseItem(Record record) {
        Frote frote = new Frote(
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
                record.getValue(tabla.FECHA),
                record.getValue(tabla.MUESTRA_ESTUDIO),
                record.getValue(tabla.OBSERVACIONES)
        );
        if (frote != null){
            frote.setImagenes(this.getImages(frote.getCodFrote()));
        }
        return frote;
    }

    private List<String> getImages(int codFrote) {
        return query.select(tablaImg.RUTA_IMAGEN).from(tablaImg).where(tablaImg.COD_FROTE.eq(codFrote)).fetch(tablaImg.RUTA_IMAGEN, String.class);
    }

    private void guardarImagenes(Frote frote) {
        if (frote.getImagenes() == null){
            Logger.info("ignore null images");
            return;
        }
        for (String img: frote.getImagenes()){
            LabExamenImagenRecord record = query.newRecord(tablaImg);
            record.setCodFrote(frote.getCodFrote());
            record.setFechaCreacion(LocalDate.now());
            String[] parts = img.split("/");
            record.setNombreImagen(parts[parts.length - 1]);
            record.setNumImagen(frote.getImagenes().indexOf(img));
            record.setRutaImagen(img);

            query.insertInto(tablaImg).set(record).execute();
        }
    }

    @Override
    public Frote getByCod(int codFrote) {
        Record result = query.select(tabla.asterisk())
                .from(tabla)
                .where(tabla.COD_FROTE.eq(codFrote))
                .fetchOne();
        
        //return result != null ? parseItem(result): null;
        
        Frote frote =result != null ? parseItem(result): null;
        if (frote != null) 
        {   Logger.info("buscando imagenes by cod");
        System.out.println("BUSCAR IMAGENES POR CODIGO");
        frote.setImagenes(getImages( frote.getCodFrote()));
        }
        
        return frote;
        
    }

    @Override
    public Frote getByNumFrote(String numFrote) {
        Record result = query.select(tabla.asterisk())
                .from(tabla)
                .where(tabla.NUM_FROTE.eq(numFrote))
                .fetchOne();
        
        //return result != null ? parseItem(result): null;
        
        Frote frote =result != null ? parseItem(result): null;
        if (frote != null) 
        {   Logger.info("buscando imagenes by cod");
        System.out.println("BUSCAR IMAGENES POR CODIGO");
        frote.setImagenes(getImages( frote.getCodFrote()));
        }
        
        return frote;
                
    }

    @Override
    public List<Frote> getByExamen(int codExamen) {
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
    public Frote guardarFrote(Frote frote) {
        LabExamenFroteRecord record = query.newRecord(tabla);

        record.setCodExamen(frote.getCodExamen());

        record.setNumFrote(getNextNumber(frote.getFecha()));

        record.setNumRecibo(frote.getNumRecibo());
        record.setMontoRecibo(frote.getMontoRecibo());
        record.setSerieRecibo(frote.getSerieRecibo());
        record.setEstadoFrote(frote.getEstadoFrote());
        record.setUsuarioFrote(frote.getUsuarioFrote());
        record.setFecha(LocalDate.now());
        record.setFechaModificacion(LocalDate.now());

        record.store();

        guardarImagenes(frote);

        return getByCod(record.getCodFrote());
    }

    @Override
    public Frote modificarFrote(Frote frote, String usuario,Boolean saveImage) {
        LabExamenFroteRecord record = query.newRecord(tabla);
        record.setCodFrote(frote.getCodFrote());

        record.setCodTincion(frote.getCodTincion());
        record.setEstadoFrote(frote.getEstadoFrote());
        record.setUsuarioFrote(frote.getUsuarioFrote());
        record.setModificadoPor(usuario);
        record.setFechaModificacion(LocalDate.now());
        record.setMuestraEstudio(frote.getMuestraEstudio());
        record.setObservaciones(frote.getObservaciones());
        
        if (saveImage)
        	 { guardarImagenes(frote); }

        record.update();
        return getByCod(record.getCodFrote());
    }
}
