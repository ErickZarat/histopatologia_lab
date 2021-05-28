package histopatologialab.diagnostico.dto;

import java.time.LocalDate;


public class Diagnostico {
	private Long codigoDiagnostico;
	private String nombreDiagnostico; 
//	private String Descripcion;
	private String estado; 
	private LocalDate fechaCreacion;
	private String creadoPor;
	private String modificadoPor;
	private LocalDate fechaModificacion;
	
	public Diagnostico() { }
	
	
	public Diagnostico(Long codigoDiagnostico, String nombreDiagnostico,   String estado,  LocalDate fechaCreacion, String creadoPor, String modificadoPor, LocalDate fechaModificacion) 
	{ this.codigoDiagnostico = codigoDiagnostico; 
	  this.nombreDiagnostico = nombreDiagnostico; 
      this.estado = estado;
      this.creadoPor = creadoPor;
      this.fechaCreacion = fechaCreacion;
      this.modificadoPor = modificadoPor;
      this.fechaModificacion = fechaModificacion;
      }


	public Long getCodigoDiagnostico() {
		return codigoDiagnostico;
	}


	public void setCodigoDiagnostico(Long codigoDiagnostico) {
		this.codigoDiagnostico = codigoDiagnostico;
	}


	public String getNombreDiagnostico() {
		return nombreDiagnostico;
	}


	public void setNombreDiagnostico(String nombreDiagnostico) {
		this.nombreDiagnostico = nombreDiagnostico;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public String getCreadoPor() {
		return creadoPor;
	}


	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}


	public String getModificadoPor() {
		return modificadoPor;
	}


	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}


	public LocalDate getFechaModificacion() {
		return fechaModificacion;
	}


	public void setFechaModificacion(LocalDate fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	
	

}
