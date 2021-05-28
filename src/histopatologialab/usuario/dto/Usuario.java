package histopatologialab.usuario.dto;

import java.time.LocalDate;

public class Usuario {
	private Long codUsuario; 
	private String loginUsuario;
	private String passwordUsuario; 
	private String llave; 
	private String nombresDoctor;
	private String apellidosDoctor; 
	private String numColegiado;
	private String emailUsuario;
	private String tipoUsuario;
	private String estado; 
	private LocalDate fechaCreacion;
	private String creadoPor;
	private String modificadoPor;
	private LocalDate fechaModificacion;	

	
	public Usuario() {}
	
	public Usuario(Long codUsuario, String loginUsuario, String passwordUsuario, String llaveUsuario, String nombresDoctor, String apellidosDoctor,
			String numColegiado, String emailUsuario, String tipoUsuario, String estado, LocalDate fechaCreacion, String creadoPor, String modificadoPor, LocalDate fechaModificacion) {
		this.codUsuario = codUsuario; 
		this.loginUsuario = loginUsuario;
		this.passwordUsuario = passwordUsuario; 
		this.llave = llaveUsuario;
		this.nombresDoctor = nombresDoctor;
		this.apellidosDoctor = apellidosDoctor; 
		this.numColegiado =  numColegiado;
		this.emailUsuario = emailUsuario;
		this.tipoUsuario = tipoUsuario;
		this.estado = estado; 
		this.fechaCreacion = fechaCreacion;
		this.creadoPor= creadoPor; 
		this.modificadoPor= modificadoPor;
		this.fechaModificacion = fechaModificacion; 	
	}

	public Long getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(Long codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}
	

	public String getLlave() {
		return llave;
	}

	public void setLlave(String llave) {
		this.llave = llave;
	}

	public String getNombresDoctor() {
		return nombresDoctor;
	}

	public void setNombresDoctor(String nombresDoctor) {
		this.nombresDoctor = nombresDoctor;
	}

	public String getApellidosDoctor() {
		return apellidosDoctor;
	}

	public void setApellidosDoctor(String apellidosDoctor) {
		this.apellidosDoctor = apellidosDoctor;
	}

	public String getNumColegiado() {
		return numColegiado;
	}

	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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
