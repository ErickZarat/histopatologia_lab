package histopatologialab.receta.dto;

import java.time.LocalDate;

public class Receta {
    private Integer codReceta;
    private Integer codExamen;
    private Integer codPresentacionMedicamento;
    private Integer numReceta;
    private String notas;
    private Long creadoPor;
    private Long modificadoPor;
    private LocalDate fechaModificacion;
    private LocalDate fechaCreacion;

    private String nombreMedicamento;
    private String presentacion;

    public Receta() {
    }

    public Receta(Integer codReceta, Integer codExamen, Integer codPresentacionMedicamento, Integer numReceta, String notas, Long creadoPor, Long modificadoPor, LocalDate fechaModificacion, LocalDate fechaCreacion) {
        this.codReceta = codReceta;
        this.codExamen = codExamen;
        this.codPresentacionMedicamento = codPresentacionMedicamento;
        this.numReceta = numReceta;
        this.notas = notas;
        this.creadoPor = creadoPor;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getCodReceta() {
        return codReceta;
    }

    public void setCodReceta(Integer codReceta) {
        this.codReceta = codReceta;
    }

    public Integer getCodExamen() {
        return codExamen;
    }

    public void setCodExamen(Integer codExamen) {
        this.codExamen = codExamen;
    }

    public Integer getCodPresentacionMedicamento() {
        return codPresentacionMedicamento;
    }

    public void setCodPresentacionMedicamento(Integer codPresentacionMedicamento) {
        this.codPresentacionMedicamento = codPresentacionMedicamento;
    }

    public Integer getNumReceta() {
        return numReceta;
    }

    public void setNumReceta(Integer numReceta) {
        this.numReceta = numReceta;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Long getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Long creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Long getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(Long modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }
}
