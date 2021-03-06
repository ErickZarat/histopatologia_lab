/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db.tables.records;


import histopatologialab.core.db.tables.LabTipoOpcionLesion;

import java.time.LocalDate;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LabTipoOpcionLesionRecord extends UpdatableRecordImpl<LabTipoOpcionLesionRecord> implements Record8<Integer, String, String, String, LocalDate, String, String, LocalDate> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.lab_tipo_opcion_lesion.cod_tipo_opcion_lesion</code>.
     */
    public void setCodTipoOpcionLesion(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.lab_tipo_opcion_lesion.cod_tipo_opcion_lesion</code>.
     */
    public Integer getCodTipoOpcionLesion() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.lab_tipo_opcion_lesion.nombre_tipo_opcion</code>.
     */
    public void setNombreTipoOpcion(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.lab_tipo_opcion_lesion.nombre_tipo_opcion</code>.
     */
    public String getNombreTipoOpcion() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.lab_tipo_opcion_lesion.valor_tipo_opcion</code>.
     */
    public void setValorTipoOpcion(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.lab_tipo_opcion_lesion.valor_tipo_opcion</code>.
     */
    public String getValorTipoOpcion() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.lab_tipo_opcion_lesion.estado_tipo_opcion</code>.
     */
    public void setEstadoTipoOpcion(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.lab_tipo_opcion_lesion.estado_tipo_opcion</code>.
     */
    public String getEstadoTipoOpcion() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.lab_tipo_opcion_lesion.fecha_creacion</code>.
     */
    public void setFechaCreacion(LocalDate value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.lab_tipo_opcion_lesion.fecha_creacion</code>.
     */
    public LocalDate getFechaCreacion() {
        return (LocalDate) get(4);
    }

    /**
     * Setter for <code>public.lab_tipo_opcion_lesion.creado_por</code>.
     */
    public void setCreadoPor(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.lab_tipo_opcion_lesion.creado_por</code>.
     */
    public String getCreadoPor() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.lab_tipo_opcion_lesion.modificado_por</code>.
     */
    public void setModificadoPor(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.lab_tipo_opcion_lesion.modificado_por</code>.
     */
    public String getModificadoPor() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.lab_tipo_opcion_lesion.fecha_modificacion</code>.
     */
    public void setFechaModificacion(LocalDate value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.lab_tipo_opcion_lesion.fecha_modificacion</code>.
     */
    public LocalDate getFechaModificacion() {
        return (LocalDate) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<Integer, String, String, String, LocalDate, String, String, LocalDate> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<Integer, String, String, String, LocalDate, String, String, LocalDate> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return LabTipoOpcionLesion.LAB_TIPO_OPCION_LESION.COD_TIPO_OPCION_LESION;
    }

    @Override
    public Field<String> field2() {
        return LabTipoOpcionLesion.LAB_TIPO_OPCION_LESION.NOMBRE_TIPO_OPCION;
    }

    @Override
    public Field<String> field3() {
        return LabTipoOpcionLesion.LAB_TIPO_OPCION_LESION.VALOR_TIPO_OPCION;
    }

    @Override
    public Field<String> field4() {
        return LabTipoOpcionLesion.LAB_TIPO_OPCION_LESION.ESTADO_TIPO_OPCION;
    }

    @Override
    public Field<LocalDate> field5() {
        return LabTipoOpcionLesion.LAB_TIPO_OPCION_LESION.FECHA_CREACION;
    }

    @Override
    public Field<String> field6() {
        return LabTipoOpcionLesion.LAB_TIPO_OPCION_LESION.CREADO_POR;
    }

    @Override
    public Field<String> field7() {
        return LabTipoOpcionLesion.LAB_TIPO_OPCION_LESION.MODIFICADO_POR;
    }

    @Override
    public Field<LocalDate> field8() {
        return LabTipoOpcionLesion.LAB_TIPO_OPCION_LESION.FECHA_MODIFICACION;
    }

    @Override
    public Integer component1() {
        return getCodTipoOpcionLesion();
    }

    @Override
    public String component2() {
        return getNombreTipoOpcion();
    }

    @Override
    public String component3() {
        return getValorTipoOpcion();
    }

    @Override
    public String component4() {
        return getEstadoTipoOpcion();
    }

    @Override
    public LocalDate component5() {
        return getFechaCreacion();
    }

    @Override
    public String component6() {
        return getCreadoPor();
    }

    @Override
    public String component7() {
        return getModificadoPor();
    }

    @Override
    public LocalDate component8() {
        return getFechaModificacion();
    }

    @Override
    public Integer value1() {
        return getCodTipoOpcionLesion();
    }

    @Override
    public String value2() {
        return getNombreTipoOpcion();
    }

    @Override
    public String value3() {
        return getValorTipoOpcion();
    }

    @Override
    public String value4() {
        return getEstadoTipoOpcion();
    }

    @Override
    public LocalDate value5() {
        return getFechaCreacion();
    }

    @Override
    public String value6() {
        return getCreadoPor();
    }

    @Override
    public String value7() {
        return getModificadoPor();
    }

    @Override
    public LocalDate value8() {
        return getFechaModificacion();
    }

    @Override
    public LabTipoOpcionLesionRecord value1(Integer value) {
        setCodTipoOpcionLesion(value);
        return this;
    }

    @Override
    public LabTipoOpcionLesionRecord value2(String value) {
        setNombreTipoOpcion(value);
        return this;
    }

    @Override
    public LabTipoOpcionLesionRecord value3(String value) {
        setValorTipoOpcion(value);
        return this;
    }

    @Override
    public LabTipoOpcionLesionRecord value4(String value) {
        setEstadoTipoOpcion(value);
        return this;
    }

    @Override
    public LabTipoOpcionLesionRecord value5(LocalDate value) {
        setFechaCreacion(value);
        return this;
    }

    @Override
    public LabTipoOpcionLesionRecord value6(String value) {
        setCreadoPor(value);
        return this;
    }

    @Override
    public LabTipoOpcionLesionRecord value7(String value) {
        setModificadoPor(value);
        return this;
    }

    @Override
    public LabTipoOpcionLesionRecord value8(LocalDate value) {
        setFechaModificacion(value);
        return this;
    }

    @Override
    public LabTipoOpcionLesionRecord values(Integer value1, String value2, String value3, String value4, LocalDate value5, String value6, String value7, LocalDate value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LabTipoOpcionLesionRecord
     */
    public LabTipoOpcionLesionRecord() {
        super(LabTipoOpcionLesion.LAB_TIPO_OPCION_LESION);
    }

    /**
     * Create a detached, initialised LabTipoOpcionLesionRecord
     */
    public LabTipoOpcionLesionRecord(Integer codTipoOpcionLesion, String nombreTipoOpcion, String valorTipoOpcion, String estadoTipoOpcion, LocalDate fechaCreacion, String creadoPor, String modificadoPor, LocalDate fechaModificacion) {
        super(LabTipoOpcionLesion.LAB_TIPO_OPCION_LESION);

        setCodTipoOpcionLesion(codTipoOpcionLesion);
        setNombreTipoOpcion(nombreTipoOpcion);
        setValorTipoOpcion(valorTipoOpcion);
        setEstadoTipoOpcion(estadoTipoOpcion);
        setFechaCreacion(fechaCreacion);
        setCreadoPor(creadoPor);
        setModificadoPor(modificadoPor);
        setFechaModificacion(fechaModificacion);
    }
}
