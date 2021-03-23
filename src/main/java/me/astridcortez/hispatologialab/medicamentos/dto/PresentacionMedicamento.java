package me.astridcortez.hispatologialab.medicamentos.dto;

import java.util.Date;

public class PresentacionMedicamento {
    private int codMedicamento;
    private String tipoPresentacion;
    private String creadoPor;
    private Date fechaCreacion;
    private String modificatoPor;

    public PresentacionMedicamento() { }

    public PresentacionMedicamento(int codMedicamento, String tipoPresentacion, String creadoPor, Date fechaCreacion, String modificatoPor) {
        this.codMedicamento = codMedicamento;
        this.tipoPresentacion = tipoPresentacion;
        this.creadoPor = creadoPor;
        this.fechaCreacion = fechaCreacion;
        this.modificatoPor = modificatoPor;
    }

    public int getCodMedicamento() {
        return codMedicamento;
    }

    public void setCodMedicamento(int codMedicamento) {
        this.codMedicamento = codMedicamento;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getModificatoPor() {
        return modificatoPor;
    }

    public void setModificatoPor(String modificatoPor) {
        this.modificatoPor = modificatoPor;
    }
}
