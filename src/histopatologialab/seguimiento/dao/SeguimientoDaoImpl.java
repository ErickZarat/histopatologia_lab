package histopatologialab.seguimiento.dao;


import histopatologialab.core.DB;

import histopatologialab.core.db.tables.LabExamenSeguimiento;
import histopatologialab.core.db.tables.records.LabExamenSeguimientoRecord;
import histopatologialab.seguimiento.dto.Seguimiento;
import org.jooq.DSLContext;
import org.jooq.Record;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class SeguimientoDaoImpl  implements ISeguimientoDao {
	
    private final DSLContext query = DB.getConexion();
    private final LabExamenSeguimiento tabla = LabExamenSeguimiento.LAB_EXAMEN_SEGUIMIENTO;
    
    
    public Seguimiento parseItem(Record record) {
    	return new Seguimiento (
    			record.getValue(tabla.COD_SEGUIMIENTO),
    			record.getValue(tabla.COD_EXAMEN),
    			record.getValue(tabla.FECHA_SEGUIMIENTO),
    			record.getValue(tabla.OBSERVACIONES), 
    			record.getValue(tabla.OBSERVACIONES_ADICIONAL),
    			record.getValue(tabla.USUARIO_SEGUIMIENTO),
    			record.getValue(tabla.MODIFICADO_POR),
    			record.getValue(tabla.FECHA_MODIFICACION)    			
    			);
    }
    
    @Override
    public  List<Seguimiento> getSeguimientoByExamen(Integer codExamen)
    {  
    	 List<Record> result = query
         .select(tabla.asterisk())
         .from(tabla)
         .where(tabla.COD_EXAMEN.eq(codExamen))
         .fetch();    	    	
    	return result.stream().map(this::parseItem).collect(Collectors.toList());
    }
    
    
    @Override
    public  List<Seguimiento> guardarSeguimiento(List<Seguimiento> seguimientos)
    {	if (seguimientos == null && seguimientos.isEmpty())
        return null;
    	Integer codExamen = seguimientos.get(0).getCodExamen();
        System.out.println("despues de buscar el codigo de examen");
        System.out.println(seguimientos.get(0).getObservacionesAdicionales());
        System.out.println(seguimientos.get(0).getCreadoPor());
    	 for (Seguimiento seguimientoInsert : seguimientos) {
             LabExamenSeguimientoRecord record = query.newRecord(tabla);
             record.setCodExamen(seguimientoInsert.getCodExamen());;
             record.setFechaSeguimiento(LocalDate.now());
             record.setObservaciones(seguimientoInsert.getObservaciones());
             record.setObservacionesAdicional(seguimientoInsert.getObservacionesAdicionales());
             record.setUsuarioSeguimiento(seguimientoInsert.getCreadoPor());
             record.store();
         }    
    	return getSeguimientoByExamen(codExamen);
    }

}
