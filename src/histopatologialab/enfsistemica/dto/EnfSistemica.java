package histopatologialab.enfsistemica.dto;

import java.time.LocalDate;

public class EnfSistemica {
	private int codigoEnfermedad;
	private String nombreEnfermedad;
	private String estado; 
	private LocalDate fechaCreacion;
	private String creadoPor;
	private String modificadoPor;
	private LocalDate fechaModificacion;
			
    public EnfSistemica() { }
    
    public EnfSistemica(int codigoEnfermedad, String nombreEnfermedad, String estado, String creadoPor, LocalDate fechaCreacion, String modificadoPor, LocalDate fechaModificacion) {
        this.codigoEnfermedad = codigoEnfermedad;
        this.nombreEnfermedad = nombreEnfermedad;
        this.estado = estado;
        this.creadoPor = creadoPor;
        this.fechaCreacion = fechaCreacion;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
    }
	
	public int getCodigoEnfermedad() {
		return codigoEnfermedad;
	}
	public void setCodigoEnfermedad(int codigoEnfermedad) {
		this.codigoEnfermedad = codigoEnfermedad;
	}
	public String getNombreEnfermedad() {
		return nombreEnfermedad;
	}
	public void setNombreEnfermedad(String nombreEnfermedad) {
		this.nombreEnfermedad = nombreEnfermedad;
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
