package histopatologialab.seguimiento.dao;

import histopatologialab.seguimiento.dto.Seguimiento;
import java.util.List;


public interface ISeguimientoDao {

    List<Seguimiento> getSeguimientoByExamen(Integer codExamen);
    List<Seguimiento> guardarSeguimiento(List<Seguimiento> seguimiento);
    String getDoctorSeguimiento(Long codusuario); 
    
    }
