package histopatologialab.consultas.dto;

import histopatologialab.pacientes.dto.Paciente;
import histopatologialab.usuario.dto.Usuario;

import java.time.LocalDate;
import java.util.List;

public class Examen {
    int codExamen;
    Long codPaciente;
    String numExamen;
    LocalDate fechaExamen;
    String estado;
    String historiaExamenLesion;
    String tamanoLesion;
    String dimensionalLesion;
    int duracionLesionDias;
    int duracionLesionMeses;
    int duracionLesionAnios;

    String datosImportantesLesion;
    Long doctorExamen;
    String tipoRemision;

    String doctorRemision;
    String direccionDoctorRemision;
    String telefonoDoctorRemision;
    String emailDoctorRemision;
    String dependenciaDoctorRemision;
    String registroDoctorRemision;

    Paciente paciente;
    Usuario doctor;

    List<Integer> caracteristicas;
    List<Integer> enfermedades;
    List<Integer> diagnosticos;

    boolean necesitaBiopsia;
    boolean necesitaFrote;

    public Examen(int codExamen, Long codPaciente, String numExamen, LocalDate fechaExamen, String estado, String historiaExamenLesion, String tamanoLesion, String dimensionalLesion, int duracionLesionDias, int duracionLesionMeses, int duracionLesionAnios, String datosImportantesLesion, Long doctorExamen, String tipoRemision, String doctorRemision, String direccionDoctorRemision, String telefonoDoctorRemision, String emailDoctorRemision, String dependenciaDoctorRemision, String registroDoctorRemision, Paciente paciente, Usuario doctor, List<Integer> caracteristicas, boolean necesitaBiopsia, boolean necesitaFrote) {
        this.codExamen = codExamen;
        this.codPaciente = codPaciente;
        this.numExamen = numExamen;
        this.fechaExamen = fechaExamen;
        this.estado = estado;
        this.historiaExamenLesion = historiaExamenLesion;
        this.tamanoLesion = tamanoLesion;
        this.dimensionalLesion = dimensionalLesion;
        this.duracionLesionDias = duracionLesionDias;
        this.duracionLesionMeses = duracionLesionMeses;
        this.duracionLesionAnios = duracionLesionAnios;
        this.datosImportantesLesion = datosImportantesLesion;
        this.doctorExamen = doctorExamen;
        this.tipoRemision = tipoRemision;
        this.doctorRemision = doctorRemision;
        this.direccionDoctorRemision = direccionDoctorRemision;
        this.telefonoDoctorRemision = telefonoDoctorRemision;
        this.emailDoctorRemision = emailDoctorRemision;
        this.dependenciaDoctorRemision = dependenciaDoctorRemision;
        this.registroDoctorRemision = registroDoctorRemision;
        this.paciente = paciente;
        this.doctor = doctor;
        this.caracteristicas = caracteristicas;
        this.necesitaBiopsia = necesitaBiopsia;
        this.necesitaFrote = necesitaFrote;
    }

    public Examen() {

    }

    public String getRegistroDoctorRemision() {
        return registroDoctorRemision;
    }

    public void setRegistroDoctorRemision(String registroDoctorRemision) {
        this.registroDoctorRemision = registroDoctorRemision;
    }

    public int getCodExamen() {
        return codExamen;
    }

    public void setCodExamen(int codExamen) {
        this.codExamen = codExamen;
    }

    public Long getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(Long codPaciente) {
        this.codPaciente = codPaciente;
    }

    public String getNumExamen() {
        return numExamen;
    }

    public void setNumExamen(String numExamen) {
        this.numExamen = numExamen;
    }

    public LocalDate getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(LocalDate fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getHistoriaExamenLesion() {
        return historiaExamenLesion;
    }

    public void setHistoriaExamenLesion(String historiaExamenLesion) {
        this.historiaExamenLesion = historiaExamenLesion;
    }

    public String getTamanoLesion() {
        return tamanoLesion;
    }

    public void setTamanoLesion(String tamanoLesion) {
        this.tamanoLesion = tamanoLesion;
    }

    public String getDimensionalLesion() {
        return dimensionalLesion;
    }

    public void setDimensionalLesion(String dimensionalLesion) {
        this.dimensionalLesion = dimensionalLesion;
    }

    public int getDuracionLesionDias() {
        return duracionLesionDias;
    }

    public void setDuracionLesionDias(int duracionLesionDias) {
        this.duracionLesionDias = duracionLesionDias;
    }

    public int getDuracionLesionMeses() {
        return duracionLesionMeses;
    }

    public void setDuracionLesionMeses(int duracionLesionMeses) {
        this.duracionLesionMeses = duracionLesionMeses;
    }

    public int getDuracionLesionAnios() {
        return duracionLesionAnios;
    }

    public void setDuracionLesionAnios(int duracionLesionAnios) {
        this.duracionLesionAnios = duracionLesionAnios;
    }

    public String getDatosImportantesLesion() {
        return datosImportantesLesion;
    }

    public void setDatosImportantesLesion(String datosImportantesLesion) {
        this.datosImportantesLesion = datosImportantesLesion;
    }

    public Long getDoctorExamen() {
        return doctorExamen;
    }

    public void setDoctorExamen(Long doctorExamen) {
        this.doctorExamen = doctorExamen;
    }

    public String getTipoRemision() {
        return tipoRemision;
    }

    public void setTipoRemision(String tipoRemision) {
        this.tipoRemision = tipoRemision;
    }

    public String getDoctorRemision() {
        return doctorRemision;
    }

    public void setDoctorRemision(String doctorRemision) {
        this.doctorRemision = doctorRemision;
    }

    public String getDireccionDoctorRemision() {
        return direccionDoctorRemision;
    }

    public void setDireccionDoctorRemision(String direccionDoctorRemision) {
        this.direccionDoctorRemision = direccionDoctorRemision;
    }

    public String getTelefonoDoctorRemision() {
        return telefonoDoctorRemision;
    }

    public void setTelefonoDoctorRemision(String telefonoDoctorRemision) {
        this.telefonoDoctorRemision = telefonoDoctorRemision;
    }

    public String getEmailDoctorRemision() {
        return emailDoctorRemision;
    }

    public void setEmailDoctorRemision(String emailDoctorRemision) {
        this.emailDoctorRemision = emailDoctorRemision;
    }

    public String getDependenciaDoctorRemision() {
        return dependenciaDoctorRemision;
    }

    public void setDependenciaDoctorRemision(String dependenciaDoctorRemision) {
        this.dependenciaDoctorRemision = dependenciaDoctorRemision;
    }

    public List<Integer> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Integer> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String genNumeroExamen(int nextInt) {
        int day = this.fechaExamen.getDayOfMonth();
        int month = this.fechaExamen.getMonthValue();

        return day + "-" + month + "-" + nextInt;
    }

    public boolean isNecesitaBiopsia() {
        return necesitaBiopsia;
    }

    public void setNecesitaBiopsia(boolean necesitaBiopsia) {
        this.necesitaBiopsia = necesitaBiopsia;
    }

    public boolean isNecesitaFrote() {
        return necesitaFrote;
    }

    public void setNecesitaFrote(boolean necesitaFrote) {
        this.necesitaFrote = necesitaFrote;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Usuario getDoctor() {
        return doctor;
    }

    public void setDoctor(Usuario doctor) {
        this.doctor = doctor;
    }

    public List<Integer> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(List<Integer> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public List<Integer> getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(List<Integer> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }
}
