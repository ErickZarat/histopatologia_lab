package histopatologialab.biopsia.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import static histopatologialab.core.DateUtils.formatDate;

public class Biopsia {
    Integer codBiopsia;
    Integer codExamen;
    String numBiopsia;
    String numRecibo;
    String serieRecibo;
    BigDecimal montoRecibo;
    String estadoBiopsia;
    Integer usuarioBiopsia;
    String modificadoPor;
    LocalDate fechaModificacion;
    LocalDate fecha;
    String muestraEstudio;
    String observaciones;
    Integer instrumento;
    Integer tipoCirugia;
    Integer procedimiento;
    String fechaFormateada;


    public Biopsia() {
    }

    public Biopsia(Integer codBiopsia, Integer codExamen, String numBiopsia, String numRecibo, String serieRecibo, BigDecimal montoRecibo, String estadoBiopsia, Integer usuarioBiopsia, String modificadoPor, LocalDate fechaModificacion, LocalDate fecha, String muestraEstudio, String observaciones, Integer instrumento, Integer tipoCirugia, Integer procedimiento) {
        this.codBiopsia = codBiopsia;
        this.codExamen = codExamen;
        this.numBiopsia = numBiopsia;
        this.numRecibo = numRecibo;
        this.serieRecibo = serieRecibo;
        this.montoRecibo = montoRecibo;
        this.estadoBiopsia = estadoBiopsia;
        this.usuarioBiopsia = usuarioBiopsia;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
        this.fecha = fecha;
        this.fechaFormateada = formatDate(this.fecha);
        this.muestraEstudio = muestraEstudio;
        this.observaciones = observaciones;
        this.instrumento = instrumento;
        this.tipoCirugia = tipoCirugia;
        this.procedimiento = procedimiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
        this.fechaFormateada = formatDate(this.fecha);
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

    public BigDecimal getMontoRecibo() {
        return montoRecibo;
    }

    public void setMontoRecibo(BigDecimal montoRecibo) {
        this.montoRecibo = montoRecibo;
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

    public String getMuestraEstudio() {
        return muestraEstudio;
    }

    public void setMuestraEstudio(String muestraEstudio) {
        this.muestraEstudio = muestraEstudio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Integer instrumento) {
        this.instrumento = instrumento;
    }

    public Integer getTipoCirugia() {
        return tipoCirugia;
    }

    public void setTipoCirugia(Integer tipoCirugia) {
        this.tipoCirugia = tipoCirugia;
    }

    public Integer getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(Integer procedimiento) {
        this.procedimiento = procedimiento;
    }

    public String getFechaFormateada() {
        return fechaFormateada;
    }

    public void setFechaFormateada(String fechaFormateada) {
        this.fechaFormateada = fechaFormateada;
    }
}
