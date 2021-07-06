package histopatologialab.pacientes.dto;

import java.time.LocalDate;
import java.time.Period;

public class Paciente {

	private Long codigoPaciente; 
	private String identificacionPaciente;
	private String nombrePaciente ;
	private String apellidosPaciente;
	private String direccionPaciente;
	private String telefonoPaciente ;
	private LocalDate fecNacimientoPaciente;
	private String generoPaciente;
	private String ocupacionPaciente; 
	private String tipoidPaciente;
	private String emailPaciente;
	private String estCivilPaciente;
	private LocalDate fechaCreacion;
	private String creadoPor;
	private String modificadoPor;
	private LocalDate fechaModificacion;
	private int edad;
	private String num_ficha; 
	
   public Paciente () {	   
   }
	
   
	public Paciente(Long codigoPaciente,  String identificacionPaciente, String nombrePaciente, String apellidosPaciente,
			String direccionPaciente, String telefonoPaciente, LocalDate fecNacimientoPaciente,
			String generoPaciente, String ocupacionPaciente, String tipoidPaciente, String emailPaciente, String estCivilPaciente,
			String creadoPor, LocalDate fechaCreacion, String modificadoPor, LocalDate fechaModificacion, String numficha) {
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
		this.estCivilPaciente = estCivilPaciente;
        this.creadoPor = creadoPor;
        this.fechaCreacion = fechaCreacion;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
        this.num_ficha = numficha;

        calculateAge();
        
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


	public LocalDate getFecNacimientoPaciente() {
		return fecNacimientoPaciente;
	}


	public void setFecNacimientoPaciente(LocalDate fecNacimientoPaciente) {
		this.fecNacimientoPaciente = fecNacimientoPaciente;
		calculateAge();
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


	
	
	public String getEstCivilPaciente() {
		return estCivilPaciente;
	}


	public void setEstCivilPaciente(String estCivilPaciente) {
		this.estCivilPaciente = estCivilPaciente;
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

	public int calculateAge(){
   		if (this.fecNacimientoPaciente == null) return 0;
		Period period = Period.between(this.fecNacimientoPaciente, LocalDate.now());
		this.setEdad(period.getYears());
		return this.getEdad();
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getNum_ficha() {
		return num_ficha;
	}


	public void setNum_ficha(String num_ficha) {
		this.num_ficha = num_ficha;
	}
}
