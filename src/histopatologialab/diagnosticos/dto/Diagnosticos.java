package histopatologialab.diagnosticos.dto;

import java.time.LocalDate;


public class Diagnosticos {
	private int codigoDiagnostico;
	private String nombreDiagnostico; 
	private int diagnosticoPadreid;	
	private int tipoDiagnostico;
	private String estado; 
	private LocalDate fechaCreacion;
	private String creadoPor;
	private String modificadoPor;
	private LocalDate fechaModificacion;
	
	public Diagnosticos() { }
	
	
	public Diagnosticos(int codigoDiagnostico, String nombreDiagnostico, int diagnosticoPadreid , int tipoDiagnostico, String estado, String creadoPor, LocalDate fechaCreacion, String modificadoPor, LocalDate fechaModificacion) 
	{ this.codigoDiagnostico = codigoDiagnostico; 
	  this.nombreDiagnostico = nombreDiagnostico; 
	  this.diagnosticoPadreid = diagnosticoPadreid;
	  this.tipoDiagnostico = tipoDiagnostico; 
      this.estado = estado;
      this.creadoPor = creadoPor;
      this.fechaCreacion = fechaCreacion;
      this.modificadoPor = modificadoPor;
      this.fechaModificacion = fechaModificacion;
      }


	public int getCodigoDiagnostico() {
		return codigoDiagnostico;
	}


	public void setCodigoDiagnostico(int codigoDiagnostico) {
		this.codigoDiagnostico = codigoDiagnostico;
	}


	public String getNombreDiagnostico() {
		return nombreDiagnostico;
	}


	public void setNombreDiagnostico(String nombreDiagnostico) {
		this.nombreDiagnostico = nombreDiagnostico;
	}


	public int getDiagnosticoPadreid() {
		return diagnosticoPadreid;
	}


	public void setDiagnosticoPadreid(int diagnosticoPadreid) {
		this.diagnosticoPadreid = diagnosticoPadreid;
	}


	public int getTipoDiagnostico() {
		return tipoDiagnostico;
	}


	public void setTipoDiagnostico(int tipoDiagnostico) {
		this.tipoDiagnostico = tipoDiagnostico;
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
