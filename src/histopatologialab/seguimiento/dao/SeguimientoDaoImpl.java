package histopatologialab.seguimiento.dao;


import histopatologialab.core.DB;

import histopatologialab.core.db.tables.LabExamenSeguimiento;
import histopatologialab.core.db.tables.records.LabExamenSeguimientoRecord;
import histopatologialab.seguimiento.dto.Seguimiento;
import histopatologialab.core.db.tables.LabUsuario;

import org.jooq.DSLContext;
import org.jooq.Record;

import static org.jooq.impl.DSL.*;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class SeguimientoDaoImpl  implements ISeguimientoDao {
	
    private final DSLContext query = DB.getConexion();
    private final LabExamenSeguimiento tabla = LabExamenSeguimiento.LAB_EXAMEN_SEGUIMIENTO;
    private final LabUsuario tablaUsuario = LabUsuario.LAB_USUARIO;
    
    
    public Seguimiento parseItem(Record record) {
    	return new Seguimiento (
    			record.getValue(tabla.COD_SEGUIMIENTO),
    			record.getValue(tabla.COD_EXAMEN),
    			record.getValue(tabla.FECHA_SEGUIMIENTO),
    			record.getValue(tabla.OBSERVACIONES), 
    			record.getValue(tabla.OBSERVACIONES_ADICIONAL),
    			record.getValue(tabla.USUARIO_SEGUIMIENTO),
    			record.getValue(tabla.MODIFICADO_POR),
    			record.getValue(tabla.FECHA_MODIFICACION),
    			getDoctorSeguimiento(record.getValue(tabla.USUARIO_SEGUIMIENTO))
    			);
    }
    
    @Override
    public  List<Seguimiento> getSeguimientoByExamen(Integer codExamen)
    {  
    	 List<Record> result = query
         .select(tabla.asterisk(), concat(tablaUsuario.NOMBRES_DOCTOR.toString(), " ", tablaUsuario.APELLIDOS_DOCTOR.toString()).as("doctorSeguimiento") )         
         .from(tabla)
         .innerJoin(tablaUsuario).on(tablaUsuario.COD_USUARIO.eq(tabla.USUARIO_SEGUIMIENTO))
         .where(tabla.COD_EXAMEN.eq(codExamen))
         .orderBy(tabla.FECHA_SEGUIMIENTO)
         .fetch();    	    	
    	return result.stream().map(this::parseItem).collect(Collectors.toList());
    }
    
    
    @Override
    public  List<Seguimiento> guardarSeguimiento(List<Seguimiento> seguimientos)
    {	if (seguimientos == null && seguimientos.isEmpty())
        return null;
    	Integer codExamen = seguimientos.get(0).getCodExamen();
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
    
    @Override
    public String getDoctorSeguimiento(Long codusuario)
    {
        Record result = query
                .select (tablaUsuario.asterisk()) 
                .from(tablaUsuario)
                .where(tablaUsuario.COD_USUARIO.eq(codusuario))
                .fetchOne();    
      //  System.out.println(result.getValue(tablaUsuario.NOMBRES_DOCTOR).toString());
        return result != null ? result.getValue(tablaUsuario.NOMBRES_DOCTOR).toString()+ " " + result.getValue(tablaUsuario.APELLIDOS_DOCTOR).toString():null;
    }

}
