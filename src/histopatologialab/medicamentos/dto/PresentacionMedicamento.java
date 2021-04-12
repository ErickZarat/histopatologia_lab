package histopatologialab.medicamentos.dto;

import java.time.LocalDate;

public class PresentacionMedicamento {
    private int codMedicamento;
    private String tipoPresentacion;
    private String creadoPor;
    private LocalDate fechaCreacion;
    private String modificatoPor;

    public PresentacionMedicamento() { }

    public PresentacionMedicamento(int codMedicamento, String tipoPresentacion, String creadoPor, LocalDate fechaCreacion, String modificatoPor) {
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
}
