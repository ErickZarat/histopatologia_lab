/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db.tables.records;


import histopatologialab.core.db.tables.LabExamenFrote;

import java.time.LocalDate;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LabExamenFroteRecord extends UpdatableRecordImpl<LabExamenFroteRecord> implements Record11<Integer, Integer, String, String, String, String, Integer, String, Integer, String, LocalDate> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.lab_examen_frote.cod_frote</code>.
     */
    public void setCodFrote(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.lab_examen_frote.cod_frote</code>.
     */
    public Integer getCodFrote() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.lab_examen_frote.cod_examen</code>.
     */
    public void setCodExamen(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.lab_examen_frote.cod_examen</code>.
     */
    public Integer getCodExamen() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.lab_examen_frote.num_frote</code>.
     */
    public void setNumFrote(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.lab_examen_frote.num_frote</code>.
     */
    public String getNumFrote() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.lab_examen_frote.num_recibo</code>.
     */
    public void setNumRecibo(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.lab_examen_frote.num_recibo</code>.
     */
    public String getNumRecibo() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.lab_examen_frote.serie_recibo</code>.
     */
    public void setSerieRecibo(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.lab_examen_frote.serie_recibo</code>.
     */
    public String getSerieRecibo() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.lab_examen_frote.monto_recibo</code>.
     */
    public void setMontoRecibo(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.lab_examen_frote.monto_recibo</code>.
     */
    public String getMontoRecibo() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.lab_examen_frote.cod_tincion</code>.
     */
    public void setCodTincion(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.lab_examen_frote.cod_tincion</code>.
     */
    public Integer getCodTincion() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>public.lab_examen_frote.estado_frote</code>.
     */
    public void setEstadoFrote(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.lab_examen_frote.estado_frote</code>.
     */
    public String getEstadoFrote() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.lab_examen_frote.usuario_frote</code>.
     */
    public void setUsuarioFrote(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.lab_examen_frote.usuario_frote</code>.
     */
    public Integer getUsuarioFrote() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>public.lab_examen_frote.modificado_por</code>.
     */
    public void setModificadoPor(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.lab_examen_frote.modificado_por</code>.
     */
    public String getModificadoPor() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.lab_examen_frote.fecha_modificacion</code>.
     */
    public void setFechaModificacion(LocalDate value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.lab_examen_frote.fecha_modificacion</code>.
     */
    public LocalDate getFechaModificacion() {
        return (LocalDate) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row11<Integer, Integer, String, String, String, String, Integer, String, Integer, String, LocalDate> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<Integer, Integer, String, String, String, String, Integer, String, Integer, String, LocalDate> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return LabExamenFrote.LAB_EXAMEN_FROTE.COD_FROTE;
    }

    @Override
    public Field<Integer> field2() {
        return LabExamenFrote.LAB_EXAMEN_FROTE.COD_EXAMEN;
    }

    @Override
    public Field<String> field3() {
        return LabExamenFrote.LAB_EXAMEN_FROTE.NUM_FROTE;
    }

    @Override
    public Field<String> field4() {
        return LabExamenFrote.LAB_EXAMEN_FROTE.NUM_RECIBO;
    }

    @Override
    public Field<String> field5() {
        return LabExamenFrote.LAB_EXAMEN_FROTE.SERIE_RECIBO;
    }

    @Override
    public Field<String> field6() {
        return LabExamenFrote.LAB_EXAMEN_FROTE.MONTO_RECIBO;
    }

    @Override
    public Field<Integer> field7() {
        return LabExamenFrote.LAB_EXAMEN_FROTE.COD_TINCION;
    }

    @Override
    public Field<String> field8() {
        return LabExamenFrote.LAB_EXAMEN_FROTE.ESTADO_FROTE;
    }

    @Override
    public Field<Integer> field9() {
        return LabExamenFrote.LAB_EXAMEN_FROTE.USUARIO_FROTE;
    }

    @Override
    public Field<String> field10() {
        return LabExamenFrote.LAB_EXAMEN_FROTE.MODIFICADO_POR;
    }

    @Override
    public Field<LocalDate> field11() {
        return LabExamenFrote.LAB_EXAMEN_FROTE.FECHA_MODIFICACION;
    }

    @Override
    public Integer component1() {
        return getCodFrote();
    }

    @Override
    public Integer component2() {
        return getCodExamen();
    }

    @Override
    public String component3() {
        return getNumFrote();
    }

    @Override
    public String component4() {
        return getNumRecibo();
    }

    @Override
    public String component5() {
        return getSerieRecibo();
    }

    @Override
    public String component6() {
        return getMontoRecibo();
    }

    @Override
    public Integer component7() {
        return getCodTincion();
    }

    @Override
    public String component8() {
        return getEstadoFrote();
    }

    @Override
    public Integer component9() {
        return getUsuarioFrote();
    }

    @Override
    public String component10() {
        return getModificadoPor();
    }

    @Override
    public LocalDate component11() {
        return getFechaModificacion();
    }

    @Override
    public Integer value1() {
        return getCodFrote();
    }

    @Override
    public Integer value2() {
        return getCodExamen();
    }

    @Override
    public String value3() {
        return getNumFrote();
    }

    @Override
    public String value4() {
        return getNumRecibo();
    }

    @Override
    public String value5() {
        return getSerieRecibo();
    }

    @Override
    public String value6() {
        return getMontoRecibo();
    }

    @Override
    public Integer value7() {
        return getCodTincion();
    }

    @Override
    public String value8() {
        return getEstadoFrote();
    }

    @Override
    public Integer value9() {
        return getUsuarioFrote();
    }

    @Override
    public String value10() {
        return getModificadoPor();
    }

    @Override
    public LocalDate value11() {
        return getFechaModificacion();
    }

    @Override
    public LabExamenFroteRecord value1(Integer value) {
        setCodFrote(value);
        return this;
    }

    @Override
    public LabExamenFroteRecord value2(Integer value) {
        setCodExamen(value);
        return this;
    }

    @Override
    public LabExamenFroteRecord value3(String value) {
        setNumFrote(value);
        return this;
    }

    @Override
    public LabExamenFroteRecord value4(String value) {
        setNumRecibo(value);
        return this;
    }

    @Override
    public LabExamenFroteRecord value5(String value) {
        setSerieRecibo(value);
        return this;
    }

    @Override
    public LabExamenFroteRecord value6(String value) {
        setMontoRecibo(value);
        return this;
    }

    @Override
    public LabExamenFroteRecord value7(Integer value) {
        setCodTincion(value);
        return this;
    }

    @Override
    public LabExamenFroteRecord value8(String value) {
        setEstadoFrote(value);
        return this;
    }

    @Override
    public LabExamenFroteRecord value9(Integer value) {
        setUsuarioFrote(value);
        return this;
    }

    @Override
    public LabExamenFroteRecord value10(String value) {
        setModificadoPor(value);
        return this;
    }

    @Override
    public LabExamenFroteRecord value11(LocalDate value) {
        setFechaModificacion(value);
        return this;
    }

    @Override
    public LabExamenFroteRecord values(Integer value1, Integer value2, String value3, String value4, String value5, String value6, Integer value7, String value8, Integer value9, String value10, LocalDate value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LabExamenFroteRecord
     */
    public LabExamenFroteRecord() {
        super(LabExamenFrote.LAB_EXAMEN_FROTE);
    }

    /**
     * Create a detached, initialised LabExamenFroteRecord
     */
    public LabExamenFroteRecord(Integer codFrote, Integer codExamen, String numFrote, String numRecibo, String serieRecibo, String montoRecibo, Integer codTincion, String estadoFrote, Integer usuarioFrote, String modificadoPor, LocalDate fechaModificacion) {
        super(LabExamenFrote.LAB_EXAMEN_FROTE);

        setCodFrote(codFrote);
        setCodExamen(codExamen);
        setNumFrote(numFrote);
        setNumRecibo(numRecibo);
        setSerieRecibo(serieRecibo);
        setMontoRecibo(montoRecibo);
        setCodTincion(codTincion);
        setEstadoFrote(estadoFrote);
        setUsuarioFrote(usuarioFrote);
        setModificadoPor(modificadoPor);
        setFechaModificacion(fechaModificacion);
    }
}
