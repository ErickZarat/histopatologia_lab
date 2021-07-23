package histopatologialab.biopsia.dto;

import java.time.LocalDate;

public class Biopsia {
    Integer codBiopsia;
    Integer codExamen;
    String numBiopsia;
    String numRecibo;
    String serieRecibo;
    String montoRecibo;
    Integer codTincion;
    String estadoBiopsia;
    Integer usuarioBiopsia;
    String modificadoPor;
    LocalDate fechaModificacion;

    public Biopsia() {
    }

    public Biopsia(Integer codBiopsia, Integer codExamen, String numBiopsia, String numRecibo, String serieRecibo, String montoRecibo, Integer codTincion, String estadoBiopsia, Integer usuarioBiopsia, String modificadoPor, LocalDate fechaModificacion) {
        this.codBiopsia = codBiopsia;
        this.codExamen = codExamen;
        this.numBiopsia = numBiopsia;
        this.numRecibo = numRecibo;
        this.serieRecibo = serieRecibo;
        this.montoRecibo = montoRecibo;
        this.codTincion = codTincion;
        this.estadoBiopsia = estadoBiopsia;
        this.usuarioBiopsia = usuarioBiopsia;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getCodBiopsia() {
        return codBiopsia;
    }

    public void setCodBiopsia(Integer codBiopsia) {
        this.codBiopsia = codBiopsia;
    }

    public Integer getCodExamen() {
        return codExamen;
    }

    public void setCodExamen(Integer codExamen) {
        this.codExamen = codExamen;
    }

    public String getNumBiopsia() {
        return numBiopsia;
    }

    public void setNumBiopsia(String numBiopsia) {
        this.numBiopsia = numBiopsia;
    }

    public String getNumRecibo() {
        return numRecibo;
    }

    public void setNumRecibo(String numRecibo) {
        this.numRecibo = numRecibo;
    }

    public String getSerieRecibo() {
        return serieRecibo;
    }

    public void setSerieRecibo(String serieRecibo) {
        this.serieRecibo = serieRecibo;
    }

    public String getMontoRecibo() {
        return montoRecibo;
    }

    public void setMontoRecibo(String montoRecibo) {
        this.montoRecibo = montoRecibo;
    }

    public Integer getCodTincion() {
        return codTincion;
    }

    public void setCodTincion(Integer codTincion) {
        this.codTincion = codTincion;
    }

    public String getEstadoBiopsia() {
        return estadoBiopsia;
    }

    public void setEstadoBiopsia(String estadoBiopsia) {
        this.estadoBiopsia = estadoBiopsia;
    }

    public Integer getUsuarioBiopsia() {
        return usuarioBiopsia;
    }

    public void setUsuarioBiopsia(Integer usuarioBiopsia) {
        this.usuarioBiopsia = usuarioBiopsia;
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
