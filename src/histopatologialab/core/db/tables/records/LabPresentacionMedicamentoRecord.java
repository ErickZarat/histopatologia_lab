/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db.tables.records;


import histopatologialab.core.db.tables.LabPresentacionMedicamento;

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
public class LabPresentacionMedicamentoRecord extends UpdatableRecordImpl<LabPresentacionMedicamentoRecord> implements Record7<Integer, String, String, LocalDate, String, LocalDate, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.lab_presentacion_medicamento.cod_medicamento</code>.
     */
    public void setCodMedicamento(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.lab_presentacion_medicamento.cod_medicamento</code>.
     */
    public Integer getCodMedicamento() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.lab_presentacion_medicamento.tipo_presentacion</code>.
     */
    public void setTipoPresentacion(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.lab_presentacion_medicamento.tipo_presentacion</code>.
     */
    public String getTipoPresentacion() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.lab_presentacion_medicamento.estado_medicamento</code>.
     */
    public void setEstadoMedicamento(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.lab_presentacion_medicamento.estado_medicamento</code>.
     */
    public String getEstadoMedicamento() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.lab_presentacion_medicamento.fecha_creacion</code>.
     */
    public void setFechaCreacion(LocalDate value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.lab_presentacion_medicamento.fecha_creacion</code>.
     */
    public LocalDate getFechaCreacion() {
        return (LocalDate) get(3);
    }

    /**
     * Setter for <code>public.lab_presentacion_medicamento.creado_por</code>.
     */
    public void setCreadoPor(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.lab_presentacion_medicamento.creado_por</code>.
     */
    public String getCreadoPor() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.lab_presentacion_medicamento.fecha_modificacion</code>.
     */
    public void setFechaModificacion(LocalDate value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.lab_presentacion_medicamento.fecha_modificacion</code>.
     */
    public LocalDate getFechaModificacion() {
        return (LocalDate) get(5);
    }

    /**
     * Setter for <code>public.lab_presentacion_medicamento.modificado_por</code>.
     */
    public void setModificadoPor(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.lab_presentacion_medicamento.modificado_por</code>.
     */
    public String getModificadoPor() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
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
        return LabPresentacionMedicamento.LAB_PRESENTACION_MEDICAMENTO.COD_MEDICAMENTO;
    }

    @Override
    public Field<String> field2() {
        return LabPresentacionMedicamento.LAB_PRESENTACION_MEDICAMENTO.TIPO_PRESENTACION;
    }

    @Override
    public Field<String> field3() {
        return LabPresentacionMedicamento.LAB_PRESENTACION_MEDICAMENTO.ESTADO_MEDICAMENTO;
    }

    @Override
    public Field<LocalDate> field4() {
        return LabPresentacionMedicamento.LAB_PRESENTACION_MEDICAMENTO.FECHA_CREACION;
    }

    @Override
    public Field<String> field5() {
        return LabPresentacionMedicamento.LAB_PRESENTACION_MEDICAMENTO.CREADO_POR;
    }

    @Override
    public Field<LocalDate> field6() {
        return LabPresentacionMedicamento.LAB_PRESENTACION_MEDICAMENTO.FECHA_MODIFICACION;
    }

    @Override
    public Field<String> field7() {
        return LabPresentacionMedicamento.LAB_PRESENTACION_MEDICAMENTO.MODIFICADO_POR;
    }

    @Override
    public Integer component1() {
        return getCodMedicamento();
    }

    @Override
    public String component2() {
        return getTipoPresentacion();
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
        return getTipoPresentacion();
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
    public LabPresentacionMedicamentoRecord value1(Integer value) {
        setCodMedicamento(value);
        return this;
    }

    @Override
    public LabPresentacionMedicamentoRecord value2(String value) {
        setTipoPresentacion(value);
        return this;
    }

    @Override
    public LabPresentacionMedicamentoRecord value3(String value) {
        setEstadoMedicamento(value);
        return this;
    }

    @Override
    public LabPresentacionMedicamentoRecord value4(LocalDate value) {
        setFechaCreacion(value);
        return this;
    }

    @Override
    public LabPresentacionMedicamentoRecord value5(String value) {
        setCreadoPor(value);
        return this;
    }

    @Override
    public LabPresentacionMedicamentoRecord value6(LocalDate value) {
        setFechaModificacion(value);
        return this;
    }

    @Override
    public LabPresentacionMedicamentoRecord value7(String value) {
        setModificadoPor(value);
        return this;
    }

    @Override
    public LabPresentacionMedicamentoRecord values(Integer value1, String value2, String value3, LocalDate value4, String value5, LocalDate value6, String value7) {
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
     * Create a detached LabPresentacionMedicamentoRecord
     */
    public LabPresentacionMedicamentoRecord() {
        super(LabPresentacionMedicamento.LAB_PRESENTACION_MEDICAMENTO);
    }

    /**
     * Create a detached, initialised LabPresentacionMedicamentoRecord
     */
    public LabPresentacionMedicamentoRecord(Integer codMedicamento, String tipoPresentacion, String estadoMedicamento, LocalDate fechaCreacion, String creadoPor, LocalDate fechaModificacion, String modificadoPor) {
        super(LabPresentacionMedicamento.LAB_PRESENTACION_MEDICAMENTO);

        setCodMedicamento(codMedicamento);
        setTipoPresentacion(tipoPresentacion);
        setEstadoMedicamento(estadoMedicamento);
        setFechaCreacion(fechaCreacion);
        setCreadoPor(creadoPor);
        setFechaModificacion(fechaModificacion);
        setModificadoPor(modificadoPor);
    }
}
