/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db.tables.records;


import java.time.LocalDate;

import histopatologialab.core.db.tables.LabMedicamento;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LabMedicamentoRecord extends UpdatableRecordImpl<LabMedicamentoRecord> implements Record7<Integer, String, String, LocalDate, String, LocalDate, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.lab_medicamento.cod_medicamento</code>.
     */
    public void setCodMedicamento(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.lab_medicamento.cod_medicamento</code>.
     */
    public Integer getCodMedicamento() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.lab_medicamento.nombre_medicamento</code>.
     */
    public void setNombreMedicamento(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.lab_medicamento.nombre_medicamento</code>.
     */
    public String getNombreMedicamento() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.lab_medicamento.estado_medicamento</code>.
     */
    public void setEstadoMedicamento(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.lab_medicamento.estado_medicamento</code>.
     */
    public String getEstadoMedicamento() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.lab_medicamento.fecha_creacion</code>.
     */
    public void setFechaCreacion(LocalDate value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.lab_medicamento.fecha_creacion</code>.
     */
    public LocalDate getFechaCreacion() {
        return (LocalDate) get(3);
    }

    /**
     * Setter for <code>public.lab_medicamento.creado_por</code>.
     */
    public void setCreadoPor(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.lab_medicamento.creado_por</code>.
     */
    public String getCreadoPor() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.lab_medicamento.fecha_modificacion</code>.
     */
    public void setFechaModificacion(LocalDate value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.lab_medicamento.fecha_modificacion</code>.
     */
    public LocalDate getFechaModificacion() {
        return (LocalDate) get(5);
    }

    /**
     * Setter for <code>public.lab_medicamento.modificado_por</code>.
     */
    public void setModificadoPor(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.lab_medicamento.modificado_por</code>.
     */
    public String getModificadoPor() {
        return (String) get(6);
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
    public Row7<Integer, String, String, LocalDate, String, LocalDate, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Integer, String, String, LocalDate, String, LocalDate, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return LabMedicamento.LAB_MEDICAMENTO.COD_MEDICAMENTO;
    }

    @Override
    public Field<String> field2() {
        return LabMedicamento.LAB_MEDICAMENTO.NOMBRE_MEDICAMENTO;
    }

    @Override
    public Field<String> field3() {
        return LabMedicamento.LAB_MEDICAMENTO.ESTADO_MEDICAMENTO;
    }

    @Override
    public Field<LocalDate> field4() {
        return LabMedicamento.LAB_MEDICAMENTO.FECHA_CREACION;
    }

    @Override
    public Field<String> field5() {
        return LabMedicamento.LAB_MEDICAMENTO.CREADO_POR;
    }

    @Override
    public Field<LocalDate> field6() {
        return LabMedicamento.LAB_MEDICAMENTO.FECHA_MODIFICACION;
    }

    @Override
    public Field<String> field7() {
        return LabMedicamento.LAB_MEDICAMENTO.MODIFICADO_POR;
    }

    @Override
    public Integer component1() {
        return getCodMedicamento();
    }

    @Override
    public String component2() {
        return getNombreMedicamento();
    }

    @Override
    public String component3() {
        return getEstadoMedicamento();
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
    public LocalDate component6() {
        return getFechaModificacion();
    }

    @Override
    public String component7() {
        return getModificadoPor();
    }

    @Override
    public Integer value1() {
        return getCodMedicamento();
    }

    @Override
    public String value2() {
        return getNombreMedicamento();
    }

    @Override
    public String value3() {
        return getEstadoMedicamento();
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
    public LocalDate value6() {
        return getFechaModificacion();
    }

    @Override
    public String value7() {
        return getModificadoPor();
    }

    @Override
    public LabMedicamentoRecord value1(Integer value) {
        setCodMedicamento(value);
        return this;
    }

    @Override
    public LabMedicamentoRecord value2(String value) {
        setNombreMedicamento(value);
        return this;
    }

    @Override
    public LabMedicamentoRecord value3(String value) {
        setEstadoMedicamento(value);
        return this;
    }

    @Override
    public LabMedicamentoRecord value4(LocalDate value) {
        setFechaCreacion(value);
        return this;
    }

    @Override
    public LabMedicamentoRecord value5(String value) {
        setCreadoPor(value);
        return this;
    }

    @Override
    public LabMedicamentoRecord value6(LocalDate value) {
        setFechaModificacion(value);
        return this;
    }

    @Override
    public LabMedicamentoRecord value7(String value) {
        setModificadoPor(value);
        return this;
    }

    @Override
    public LabMedicamentoRecord values(Integer value1, String value2, String value3, LocalDate value4, String value5, LocalDate value6, String value7) {
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
     * Create a detached LabMedicamentoRecord
     */
    public LabMedicamentoRecord() {
        super(LabMedicamento.LAB_MEDICAMENTO);
    }

    /**
     * Create a detached, initialised LabMedicamentoRecord
     */
    public LabMedicamentoRecord(Integer codMedicamento, String nombreMedicamento, String estadoMedicamento, LocalDate fechaCreacion, String creadoPor, LocalDate fechaModificacion, String modificadoPor) {
        super(LabMedicamento.LAB_MEDICAMENTO);

        setCodMedicamento(codMedicamento);
        setNombreMedicamento(nombreMedicamento);
        setEstadoMedicamento(estadoMedicamento);
        setFechaCreacion(fechaCreacion);
        setCreadoPor(creadoPor);
        setFechaModificacion(fechaModificacion);
        setModificadoPor(modificadoPor);
    }
}