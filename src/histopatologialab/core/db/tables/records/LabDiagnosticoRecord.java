/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db.tables.records;


import histopatologialab.core.db.tables.LabDiagnostico;

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
public class LabDiagnosticoRecord extends UpdatableRecordImpl<LabDiagnosticoRecord> implements Record8<Long, String, String, String, LocalDate, String, LocalDate, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.lab_diagnostico.cod_diagnostico</code>.
     */
    public void setCodDiagnostico(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.lab_diagnostico.cod_diagnostico</code>.
     */
    public Long getCodDiagnostico() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.lab_diagnostico.nombre_diagnostico</code>.
     */
    public void setNombreDiagnostico(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.lab_diagnostico.nombre_diagnostico</code>.
     */
    public String getNombreDiagnostico() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.lab_diagnostico.tipo_diagnostico</code>.
     */
    public void setTipoDiagnostico(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.lab_diagnostico.tipo_diagnostico</code>.
     */
    public String getTipoDiagnostico() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.lab_diagnostico.estado_diagnostico</code>.
     */
    public void setEstadoDiagnostico(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.lab_diagnostico.estado_diagnostico</code>.
     */
    public String getEstadoDiagnostico() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.lab_diagnostico.fecha_creacion</code>.
     */
    public void setFechaCreacion(LocalDate value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.lab_diagnostico.fecha_creacion</code>.
     */
    public LocalDate getFechaCreacion() {
        return (LocalDate) get(4);
    }

    /**
     * Setter for <code>public.lab_diagnostico.creado_por</code>.
     */
    public void setCreadoPor(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.lab_diagnostico.creado_por</code>.
     */
    public String getCreadoPor() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.lab_diagnostico.fecha_modificacion</code>.
     */
    public void setFechaModificacion(LocalDate value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.lab_diagnostico.fecha_modificacion</code>.
     */
    public LocalDate getFechaModificacion() {
        return (LocalDate) get(6);
    }

    /**
     * Setter for <code>public.lab_diagnostico.modificado_por</code>.
     */
    public void setModificadoPor(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.lab_diagnostico.modificado_por</code>.
     */
    public String getModificadoPor() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, String, String, String, LocalDate, String, LocalDate, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<Long, String, String, String, LocalDate, String, LocalDate, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return LabDiagnostico.LAB_DIAGNOSTICO.COD_DIAGNOSTICO;
    }

    @Override
    public Field<String> field2() {
        return LabDiagnostico.LAB_DIAGNOSTICO.NOMBRE_DIAGNOSTICO;
    }

    @Override
    public Field<String> field3() {
        return LabDiagnostico.LAB_DIAGNOSTICO.TIPO_DIAGNOSTICO;
    }

    @Override
    public Field<String> field4() {
        return LabDiagnostico.LAB_DIAGNOSTICO.ESTADO_DIAGNOSTICO;
    }

    @Override
    public Field<LocalDate> field5() {
        return LabDiagnostico.LAB_DIAGNOSTICO.FECHA_CREACION;
    }

    @Override
    public Field<String> field6() {
        return LabDiagnostico.LAB_DIAGNOSTICO.CREADO_POR;
    }

    @Override
    public Field<LocalDate> field7() {
        return LabDiagnostico.LAB_DIAGNOSTICO.FECHA_MODIFICACION;
    }

    @Override
    public Field<String> field8() {
        return LabDiagnostico.LAB_DIAGNOSTICO.MODIFICADO_POR;
    }

    @Override
    public Long component1() {
        return getCodDiagnostico();
    }

    @Override
    public String component2() {
        return getNombreDiagnostico();
    }

    @Override
    public String component3() {
        return getTipoDiagnostico();
    }

    @Override
    public String component4() {
        return getEstadoDiagnostico();
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
    public LocalDate component7() {
        return getFechaModificacion();
    }

    @Override
    public String component8() {
        return getModificadoPor();
    }

    @Override
    public Long value1() {
        return getCodDiagnostico();
    }

    @Override
    public String value2() {
        return getNombreDiagnostico();
    }

    @Override
    public String value3() {
        return getTipoDiagnostico();
    }

    @Override
    public String value4() {
        return getEstadoDiagnostico();
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
    public LocalDate value7() {
        return getFechaModificacion();
    }

    @Override
    public String value8() {
        return getModificadoPor();
    }

    @Override
    public LabDiagnosticoRecord value1(Long value) {
        setCodDiagnostico(value);
        return this;
    }

    @Override
    public LabDiagnosticoRecord value2(String value) {
        setNombreDiagnostico(value);
        return this;
    }

    @Override
    public LabDiagnosticoRecord value3(String value) {
        setTipoDiagnostico(value);
        return this;
    }

    @Override
    public LabDiagnosticoRecord value4(String value) {
        setEstadoDiagnostico(value);
        return this;
    }

    @Override
    public LabDiagnosticoRecord value5(LocalDate value) {
        setFechaCreacion(value);
        return this;
    }

    @Override
    public LabDiagnosticoRecord value6(String value) {
        setCreadoPor(value);
        return this;
    }

    @Override
    public LabDiagnosticoRecord value7(LocalDate value) {
        setFechaModificacion(value);
        return this;
    }

    @Override
    public LabDiagnosticoRecord value8(String value) {
        setModificadoPor(value);
        return this;
    }

    @Override
    public LabDiagnosticoRecord values(Long value1, String value2, String value3, String value4, LocalDate value5, String value6, LocalDate value7, String value8) {
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
     * Create a detached LabDiagnosticoRecord
     */
    public LabDiagnosticoRecord() {
        super(LabDiagnostico.LAB_DIAGNOSTICO);
    }

    /**
     * Create a detached, initialised LabDiagnosticoRecord
     */
    public LabDiagnosticoRecord(Long codDiagnostico, String nombreDiagnostico, String tipoDiagnostico, String estadoDiagnostico, LocalDate fechaCreacion, String creadoPor, LocalDate fechaModificacion, String modificadoPor) {
        super(LabDiagnostico.LAB_DIAGNOSTICO);

        setCodDiagnostico(codDiagnostico);
        setNombreDiagnostico(nombreDiagnostico);
        setTipoDiagnostico(tipoDiagnostico);
        setEstadoDiagnostico(estadoDiagnostico);
        setFechaCreacion(fechaCreacion);
        setCreadoPor(creadoPor);
        setFechaModificacion(fechaModificacion);
        setModificadoPor(modificadoPor);
    }
}
