package histopatologialab.tincion;

import java.time.LocalDate;

public class Tincion {
    Integer codTincion;
    String nombreTincion;
    String estadoTincion;
    LocalDate fechaCreaction;
    String creadoPor;
    String modificadoPor;
    LocalDate fechaModificacion;

    public Tincion(Integer codTincion, String nombreTincion, String estadoTincion, LocalDate fechaCreaction, String creadoPor, String modificadoPor, LocalDate fechaModificacion) {
        this.codTincion = codTincion;
        this.nombreTincion = nombreTincion;
        this.estadoTincion = estadoTincion;
        this.fechaCreaction = fechaCreaction;
        this.creadoPor = creadoPor;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getCodTincion() {
        return codTincion;
    }

    public void setCodTincion(Integer codTincion) {
        this.codTincion = codTincion;
    }

    public String getNombreTincion() {
        return nombreTincion;
    }

    public void setNombreTincion(String nombreTincion) {
        this.nombreTincion = nombreTincion;
    }

    public String getEstadoTincion() {
        return estadoTincion;
    }

    public void setEstadoTincion(String estadoTincion) {
        this.estadoTincion = estadoTincion;
    }

    public LocalDate getFechaCreaction() {
        return fechaCreaction;
    }

    public void setFechaCreaction(LocalDate fechaCreaction) {
        this.fechaCreaction = fechaCreaction;
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
}
