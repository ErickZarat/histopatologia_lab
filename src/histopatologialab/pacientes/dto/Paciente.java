package histopatologialab.pacientes.dto;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Paciente {

	private Long codigoPaciente; 
	private String identificacionPaciente;
	private String nombrePaciente ;
	private String apellidosPaciente;
	private String direccionPaciente;
	private String telefonoPaciente ;
	private LocalDateTime fecNacimientoPaciente;
	private String generoPaciente;
	private String ocupacionPaciente; 
	private String tipoidPaciente;
	private String emailPaciente;
	private LocalDate fechaCreacion;
	private String creadoPor;
	private String modificadoPor;
	private LocalDate fechaModificacion;
	
   public Paciente () {	   
   }
	
   
	public Paciente(Long codigoPaciente,  String identificacionPaciente, String nombrePaciente, String apellidosPaciente,
			String direccionPaciente, String telefonoPaciente, LocalDateTime fecNacimientoPaciente,
			String generoPaciente, String ocupacionPaciente, String tipoidPaciente, String emailPaciente,
			String creadoPor, LocalDate fechaCreacion, String modificadoPor, LocalDate fechaModificacion) {
		super();
		this.codigoPaciente = codigoPaciente;
		this.identificacionPaciente = identificacionPaciente;
		this.nombrePaciente = nombrePaciente;
		this.apellidosPaciente = apellidosPaciente;
		this.direccionPaciente = direccionPaciente;
		this.telefonoPaciente = telefonoPaciente;
		this.fecNacimientoPaciente = fecNacimientoPaciente;
		this.generoPaciente = generoPaciente;
		this.ocupacionPaciente = ocupacionPaciente;
		this.tipoidPaciente = tipoidPaciente;
		this.emailPaciente = emailPaciente;
        this.creadoPor = creadoPor;
        this.fechaCreacion = fechaCreacion;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
	}



	public Long getCodigoPaciente() {
		return codigoPaciente;
	}


	public void setCodigoPaciente(Long codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}


	public String getIdentificacionPaciente() {
		return identificacionPaciente;
	}


	public void setIdentificacionPaciente(String identificacionPaciente) {
		this.identificacionPaciente = identificacionPaciente;
	}


	public String getNombrePaciente() {
		return nombrePaciente;
	}


	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	

	public String getApellidosPaciente() {
		return apellidosPaciente;
	}


	public void setApellidosPaciente(String apellidosPaciente) {
		this.apellidosPaciente = apellidosPaciente;
	}


	public String getDireccionPaciente() {
		return direccionPaciente;
	}


	public void setDireccionPaciente(String direccionPaciente) {
		this.direccionPaciente = direccionPaciente;
	}


	public String getTelefonoPaciente() {
		return telefonoPaciente;
	}


	public void setTelefonoPaciente(String telefonoPaciente) {
		this.telefonoPaciente = telefonoPaciente;
	}


	public LocalDateTime getFecNacimientoPaciente() {
		return fecNacimientoPaciente;
	}


	public void setFecNacimientoPaciente(LocalDateTime fecNacimientoPaciente) {
		this.fecNacimientoPaciente = fecNacimientoPaciente;
	}


	public String getGeneroPaciente() {
		return generoPaciente;
	}


	public void setGeneroPaciente(String generoPaciente) {
		this.generoPaciente = generoPaciente;
	}


	public String getOcupacionPaciente() {
		return ocupacionPaciente;
	}


	public void setOcupacionPaciente(String ocupacionPaciente) {
		this.ocupacionPaciente = ocupacionPaciente;
	}


	public String getTipoidPaciente() {
		return tipoidPaciente;
	}


	public void setTipoidPaciente(String tipoidPaciente) {
		this.tipoidPaciente = tipoidPaciente;
	}


	public String getEmailPaciente() {
		return emailPaciente;
	}


	public void setEmailPaciente(String emailPaciente) {
		this.emailPaciente = emailPaciente;
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
