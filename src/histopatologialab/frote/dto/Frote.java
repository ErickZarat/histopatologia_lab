package histopatologialab.frote.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import static histopatologialab.core.DateUtils.formatDate;

public class Frote {
    Integer codFrote;
    Integer codExamen;
    String numFrote;
    String numRecibo;
    String serieRecibo;
    BigDecimal montoRecibo;
    Integer codTincion;
    String estadoFrote;
    Integer usuarioFrote;
    String modificadoPor;
    LocalDate fechaModificacion;
    LocalDate fecha;
    String muestraEstudio;
    String fechaFormateada;


    public Frote() {
    }

    public Frote(Integer codFrote, Integer codExamen, String numFrote, String numRecibo, String serieRecibo, BigDecimal montoRecibo, Integer codTincion, String estadoFrote, Integer usuarioFrote, String modificadoPor, LocalDate fechaModificacion, LocalDate fecha, String muestraEstudio) {
        this.codFrote = codFrote;
        this.codExamen = codExamen;
        this.numFrote = numFrote;
        this.numRecibo = numRecibo;
        this.serieRecibo = serieRecibo;
        this.montoRecibo = montoRecibo;
        this.codTincion = codTincion;
        this.estadoFrote = estadoFrote;
        this.usuarioFrote = usuarioFrote;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
        this.fecha = fecha;
        this.fechaFormateada = formatDate(this.fecha);
        this.muestraEstudio = muestraEstudio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
        this.fechaFormateada = formatDate(this.fecha);
    }

    public Integer getCodFrote() {
        return codFrote;
    }

    public void setCodFrote(Integer codFrote) {
        this.codFrote = codFrote;
    }

    public Integer getCodExamen() {
        return codExamen;
    }

    public void setCodExamen(Integer codExamen) {
        this.codExamen = codExamen;
    }

    public String getNumFrote() {
        return numFrote;
    }

    public void setNumFrote(String numFrote) {
        this.numFrote = numFrote;
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

    public Integer getCodTincion() {
        return codTincion;
    }

    public void setCodTincion(Integer codTincion) {
        this.codTincion = codTincion;
    }

    public String getEstadoFrote() {
        return estadoFrote;
    }

    public void setEstadoFrote(String estadoFrote) {
        this.estadoFrote = estadoFrote;
    }

    public Integer getUsuarioFrote() {
        return usuarioFrote;
    }

    public void setUsuarioFrote(Integer usuarioFrote) {
        this.usuarioFrote = usuarioFrote;
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

    public String getFechaFormateada() {
        return fechaFormateada;
    }

    public void setFechaFormateada(String fechaFormateada) {
        this.fechaFormateada = fechaFormateada;
    }
}
