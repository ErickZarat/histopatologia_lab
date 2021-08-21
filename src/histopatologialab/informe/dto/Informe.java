package histopatologialab.informe.dto;

import java.time.LocalDate;

import static histopatologialab.core.DateUtils.formatDate;

public class Informe{
    private Integer codInforme;
    private LocalDate fechaInforme;
    private String clinica;
    private String direccion;
    private String solicitante;
    private String datosClinicos;
    private String descMacros;
    private String descMirco;
    private Integer diagnostico;
    private Integer usuarioInforme;
    private Integer codFrote;
    private Integer codBiopsia;
    private String fechaFormateada;
    private String observaciones;

    public Informe() {
    }

    public Informe(Integer codInforme, LocalDate fechaInforme, String clinica, String direccion, String solicitante, String datosClinicos, String descMacros, String descMirco, Integer diagnostico, Integer usuarioInforme, Integer codFrote, Integer codBiopsia, String observacionesInforme) {
        this.codInforme = codInforme;
        this.fechaInforme = fechaInforme;
        this.fechaFormateada = formatDate(this.fechaInforme);
        this.clinica = clinica;
        this.direccion = direccion;
        this.solicitante = solicitante;
        this.datosClinicos = datosClinicos;
        this.descMacros = descMacros;
        this.descMirco = descMirco;
        this.diagnostico = diagnostico;
        this.usuarioInforme = usuarioInforme;
        this.codFrote = codFrote;
        this.codBiopsia = codBiopsia;
        this.observaciones = observacionesInforme;
    }

    public Integer getCodInforme() {
        return codInforme;
    }

    public void setCodInforme(Integer codInforme) {
        this.codInforme = codInforme;
    }

    public LocalDate getFechaInforme() {
        return fechaInforme;
    }

    public void setFechaInforme(LocalDate fechaInforme) {
        this.fechaInforme = fechaInforme;
        this.fechaFormateada = formatDate(this.fechaInforme);
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getDatosClinicos() {
        return datosClinicos;
    }

    public void setDatosClinicos(String datosClinicos) {
        this.datosClinicos = datosClinicos;
    }

    public String getDescMacros() {
        return descMacros;
    }

    public void setDescMacros(String descMacros) {
        this.descMacros = descMacros;
    }

    public String getDescMirco() {
        return descMirco;
    }

    public void setDescMirco(String descMirco) {
        this.descMirco = descMirco;
    }

    public Integer getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Integer diagnostico) {
        this.diagnostico = diagnostico;
    }

    public int getUsuarioInforme() {
        return usuarioInforme;
    }

    public void setUsuarioInforme(int usuarioInforme) {
        this.usuarioInforme = usuarioInforme;
    }

    public Integer getCodFrote() {
        return codFrote;
    }

    public void setCodFrote(Integer codFrote) {
        this.codFrote = codFrote;
    }

    public Integer getCodBiopsia() {
        return codBiopsia;
    }

    public void setCodBiopsia(Integer codBiopsia) {
        this.codBiopsia = codBiopsia;
    }

    public void setUsuarioInforme(Integer usuarioInforme) {
        this.usuarioInforme = usuarioInforme;
    }

    public String getFechaFormateada() {
        return fechaFormateada;
    }

    public void setFechaFormateada(String fechaFormateada) {
        this.fechaFormateada = fechaFormateada;
    }

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observacionesInforme) {
		observaciones = observacionesInforme;
	}
    
    
}
