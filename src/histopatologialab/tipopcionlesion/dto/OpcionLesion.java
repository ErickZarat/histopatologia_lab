package histopatologialab.tipopcionlesion.dto;

import java.time.LocalDate;

public class OpcionLesion {
	
	private int codigoOpcion; 
	private String nombreOpcion; 
	private String valor; 
	private String estado ; 
	private LocalDate fechaCreacion; 
	private String creadoPor; 
	private String modificadoPor; 
	private LocalDate fechaModificacion; 
	
	
    public OpcionLesion() { }

    public OpcionLesion(int codigoOpcion, String nombreOpcion, String valor, String estado, String creadoPor, LocalDate fechaCreacion, String modificadoPor, LocalDate fechaModificacion) {
        this.codigoOpcion = codigoOpcion;
        this.nombreOpcion = nombreOpcion;
        this.valor = valor;
        this.estado = estado;
        this.creadoPor = creadoPor;
        this.fechaCreacion = fechaCreacion;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    
	public int getCodigoOpcion() {
		return codigoOpcion;
	}

	public void setCodigoOpcion(int codigoOpcion) {
		this.codigoOpcion = codigoOpcion;
	}

	public String getNombreOpcion() {
		return nombreOpcion;
	}

	public void setNombreOpcion(String nombreOpcion) {
		this.nombreOpcion = nombreOpcion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
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
