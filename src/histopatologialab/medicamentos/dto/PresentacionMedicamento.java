package histopatologialab.medicamentos.dto;

import java.time.LocalDate;

public class PresentacionMedicamento {
    private Integer codPresentacion;
    private Integer codMedicamento;
    private String tipoPresentacion;
    private String creadoPor;
    private LocalDate fechaCreacion;
    private String modificatoPor;
    private LocalDate fechaModificacion;
    private String estadoMedicamento;

    public PresentacionMedicamento() { }

    public PresentacionMedicamento(Integer codPresentacion, Integer codMedicamento, String tipoPresentacion, String creadoPor, LocalDate fechaCreacion, String modificatoPor, LocalDate fechaModificacion, String estadoMedicamento) {
        this.codPresentacion = codPresentacion;
        this.codMedicamento = codMedicamento;
        this.tipoPresentacion = tipoPresentacion;
        this.creadoPor = creadoPor;
        this.fechaCreacion = fechaCreacion;
        this.modificatoPor = modificatoPor;
        this.fechaModificacion = fechaModificacion;
        this.estadoMedicamento = estadoMedicamento;
    }

    public Integer getCodPresentacion() {
        return codPresentacion;
    }

    public void setCodPresentacion(Integer codPresentacion) {
        this.codPresentacion = codPresentacion;
    }

    public void setCodMedicamento(Integer codMedicamento) {
        this.codMedicamento = codMedicamento;
    }

    public Integer getCodMedicamento() {
        return codMedicamento;
    }

    public String getTipoPresentacion() {
        return tipoPresentacion;
    }

    public void setTipoPresentacion(String tipoPresentacion) {
        this.tipoPresentacion = tipoPresentacion;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getModificatoPor() {
        return modificatoPor;
    }

    public void setModificatoPor(String modificatoPor) {
        this.modificatoPor = modificatoPor;
    }

    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getEstadoMedicamento() {
        return estadoMedicamento;
    }

    public void setEstadoMedicamento(String estadoMedicamento) {
        this.estadoMedicamento = estadoMedicamento;
    }
}
