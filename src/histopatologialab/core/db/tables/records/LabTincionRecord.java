/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db.tables.records;


import histopatologialab.core.db.tables.LabTincion;

import java.time.LocalDate;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LabTincionRecord extends UpdatableRecordImpl<LabTincionRecord> implements Record7<Integer, String, String, LocalDate, String, String, LocalDate> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.lab_tincion.cod_tincion</code>.
     */
    public void setCodTincion(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.lab_tincion.cod_tincion</code>.
     */
    public Integer getCodTincion() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.lab_tincion.nombre_tincion</code>.
     */
    public void setNombreTincion(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.lab_tincion.nombre_tincion</code>.
     */
    public String getNombreTincion() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.lab_tincion.estado_tincion</code>.
     */
    public void setEstadoTincion(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.lab_tincion.estado_tincion</code>.
     */
    public String getEstadoTincion() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.lab_tincion.fecha_creacion</code>.
     */
    public void setFechaCreacion(LocalDate value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.lab_tincion.fecha_creacion</code>.
     */
    public LocalDate getFechaCreacion() {
        return (LocalDate) get(3);
    }

    /**
     * Setter for <code>public.lab_tincion.creado_por</code>.
     */
    public void setCreadoPor(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.lab_tincion.creado_por</code>.
     */
    public String getCreadoPor() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.lab_tincion.modificado_por</code>.
     */
    public void setModificadoPor(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.lab_tincion.modificado_por</code>.
     */
    public String getModificadoPor() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.lab_tincion.fecha_modificacion</code>.
     */
    public void setFechaModificacion(LocalDate value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.lab_tincion.fecha_modificacion</code>.
     */
    public LocalDate getFechaModificacion() {
        return (LocalDate) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, String, String, LocalDate, String, String, LocalDate> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Integer, String, String, LocalDate, String, String, LocalDate> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return LabTincion.LAB_TINCION.COD_TINCION;
    }

    @Override
    public Field<String> field2() {
        return LabTincion.LAB_TINCION.NOMBRE_TINCION;
    }

    @Override
    public Field<String> field3() {
        return LabTincion.LAB_TINCION.ESTADO_TINCION;
    }

    @Override
    public Field<LocalDate> field4() {
        return LabTincion.LAB_TINCION.FECHA_CREACION;
    }

    @Override
    public Field<String> field5() {
        return LabTincion.LAB_TINCION.CREADO_POR;
    }

    @Override
    public Field<String> field6() {
        return LabTincion.LAB_TINCION.MODIFICADO_POR;
    }

    @Override
    public Field<LocalDate> field7() {
        return LabTincion.LAB_TINCION.FECHA_MODIFICACION;
    }

    @Override
    public Integer component1() {
        return getCodTincion();
    }

    @Override
    public String component2() {
        return getNombreTincion();
    }

    @Override
    public String component3() {
        return getEstadoTincion();
    }

    @Override
    public LocalDate component4() {
        return getFechaCreacion();
    }

    @Override
    public String component5() {
        return getCreadoPor();
    }

    @Override
    public String component6() {
        return getModificadoPor();
    }

    @Override
    public LocalDate component7() {
        return getFechaModificacion();
    }

    @Override
    public Integer value1() {
        return getCodTincion();
    }

    @Override
    public String value2() {
        return getNombreTincion();
    }

    @Override
    public String value3() {
        return getEstadoTincion();
    }

    @Override
    public LocalDate value4() {
        return getFechaCreacion();
    }

    @Override
    public String value5() {
        return getCreadoPor();
    }

    @Override
    public String value6() {
        return getModificadoPor();
    }

    @Override
    public LocalDate value7() {
        return getFechaModificacion();
    }

    @Override
    public LabTincionRecord value1(Integer value) {
        setCodTincion(value);
        return this;
    }

    @Override
    public LabTincionRecord value2(String value) {
        setNombreTincion(value);
        return this;
    }

    @Override
    public LabTincionRecord value3(String value) {
        setEstadoTincion(value);
        return this;
    }

    @Override
    public LabTincionRecord value4(LocalDate value) {
        setFechaCreacion(value);
        return this;
    }

    @Override
    public LabTincionRecord value5(String value) {
        setCreadoPor(value);
        return this;
    }

    @Override
    public LabTincionRecord value6(String value) {
        setModificadoPor(value);
        return this;
    }

    @Override
    public LabTincionRecord value7(LocalDate value) {
        setFechaModificacion(value);
        return this;
    }

    @Override
    public LabTincionRecord values(Integer value1, String value2, String value3, LocalDate value4, String value5, String value6, LocalDate value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LabTincionRecord
     */
    public LabTincionRecord() {
        super(LabTincion.LAB_TINCION);
    }

    /**
     * Create a detached, initialised LabTincionRecord
     */
    public LabTincionRecord(Integer codTincion, String nombreTincion, String estadoTincion, LocalDate fechaCreacion, String creadoPor, String modificadoPor, LocalDate fechaModificacion) {
        super(LabTincion.LAB_TINCION);

        setCodTincion(codTincion);
        setNombreTincion(nombreTincion);
        setEstadoTincion(estadoTincion);
        setFechaCreacion(fechaCreacion);
        setCreadoPor(creadoPor);
        setModificadoPor(modificadoPor);
        setFechaModificacion(fechaModificacion);
    }
}