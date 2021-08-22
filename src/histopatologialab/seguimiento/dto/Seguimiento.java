package histopatologialab.seguimiento.dto;

import java.time.LocalDate; 

public class Seguimiento {
	private Integer codSeguimiento;
	private Integer codExamen;
	private LocalDate fechaCreacion;
	private String observaciones;
	private String observacionesAdicionales;
	private Long creadoPor;
	private Long modificadoPor;
	private LocalDate fechaModificacion ;
	private String doctorSeguimiento;  
	
	
	public Seguimiento(Integer codSeguimiento, Integer codExamen, LocalDate fechaCreacion, String observaciones, String observacionesAdd, Long creadoPor, Long modificadoPor, LocalDate fechaModificacion)  {
		this.codSeguimiento = codSeguimiento; 
		this.codExamen = codExamen;
		this.fechaCreacion = fechaCreacion;
		this.observaciones = observaciones;
		this.observacionesAdicionales = observacionesAdd;
		this.creadoPor = creadoPor;
		this.modificadoPor = modificadoPor ;
		this.fechaModificacion = fechaModificacion ;
	}
	
	public Seguimiento(Integer codSeguimiento, Integer codExamen, LocalDate fechaCreacion, String observaciones, String observacionesAdd, Long creadoPor, Long modificadoPor, LocalDate fechaModificacion, String DoctorRegistro)  {
		this.codSeguimiento = codSeguimiento; 
		this.codExamen = codExamen;
		this.fechaCreacion = fechaCreacion;
		this.observaciones = observaciones;
		this.observacionesAdicionales = observacionesAdd;
		this.creadoPor = creadoPor;
		this.modificadoPor = modificadoPor ;
		this.fechaModificacion = fechaModificacion ;
		this.doctorSeguimiento = DoctorRegistro;
	}
	
	public Seguimiento () 
	{
		
	}


	public Integer getCodSeguimiento() {
		return codSeguimiento;
	}


	public void setCodSeguimiento(Integer codSeguimiento) {
		this.codSeguimiento = codSeguimiento;
	}


	public Integer getCodExamen() {
		return codExamen;
	}


	public void setCodExamen(Integer codExamen) {
		this.codExamen = codExamen;
	}


	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observacion) {
		observaciones = observacion;
	}


	public String getObservacionesAdicionales() {
		return observacionesAdicionales;
	}


	public void setObservacionesAdicionales(String observacionesAdicionales) {
		this.observacionesAdicionales = observacionesAdicionales;
	}


	public Long getCreadoPor() {
		return creadoPor;
	}


	public void setCreadoPor(Long creadoPor) {
		this.creadoPor = creadoPor;
	}


	public Long getModificadoPor() {
		return modificadoPor;
	}


	public void setModificadoPor(Long modificadoPor) {
		this.modificadoPor = modificadoPor;
	}


	public LocalDate getFechaModificacion() {
		return fechaModificacion;
	}


	public void setFechaModificacion(LocalDate fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getDoctorSeguimiento() {
		return doctorSeguimiento;
	}

	public void setDoctorSeguimiento(String doctorSeguimiento) {
		this.doctorSeguimiento = doctorSeguimiento;
	}
	
	
		
}
