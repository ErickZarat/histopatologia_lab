/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db.tables.records;


import histopatologialab.core.db.tables.LabExamenBiopsia;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record12;
import org.jooq.Row12;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LabExamenBiopsiaRecord extends UpdatableRecordImpl<LabExamenBiopsiaRecord> implements Record12<Integer, Integer, String, Integer, LocalDate, String, String, String, BigDecimal, String, String, LocalDate> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.lab_examen_biopsia.cod_biopsia</code>.
     */
    public void setCodBiopsia(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.lab_examen_biopsia.cod_biopsia</code>.
     */
    public Integer getCodBiopsia() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.lab_examen_biopsia.cod_examen</code>.
     */
    public void setCodExamen(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.lab_examen_biopsia.cod_examen</code>.
     */
    public Integer getCodExamen() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.lab_examen_biopsia.num_biopsia</code>.
     */
    public void setNumBiopsia(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.lab_examen_biopsia.num_biopsia</code>.
     */
    public String getNumBiopsia() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.lab_examen_biopsia.usuario_biopsia</code>.
     */
    public void setUsuarioBiopsia(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.lab_examen_biopsia.usuario_biopsia</code>.
     */
    public Integer getUsuarioBiopsia() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.lab_examen_biopsia.fecha_planificada</code>.
     */
    public void setFechaPlanificada(LocalDate value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.lab_examen_biopsia.fecha_planificada</code>.
     */
    public LocalDate getFechaPlanificada() {
        return (LocalDate) get(4);
    }

    /**
     * Setter for <code>public.lab_examen_biopsia.tipo_biopsia</code>.
     */
    public void setTipoBiopsia(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.lab_examen_biopsia.tipo_biopsia</code>.
     */
    public String getTipoBiopsia() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.lab_examen_biopsia.num_recibo</code>.
     */
    public void setNumRecibo(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.lab_examen_biopsia.num_recibo</code>.
     */
    public String getNumRecibo() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.lab_examen_biopsia.serie_recibo</code>.
     */
    public void setSerieRecibo(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.lab_examen_biopsia.serie_recibo</code>.
     */
    public String getSerieRecibo() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.lab_examen_biopsia.monto_recibo</code>.
     */
    public void setMontoRecibo(BigDecimal value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.lab_examen_biopsia.monto_recibo</code>.
     */
    public BigDecimal getMontoRecibo() {
        return (BigDecimal) get(8);
    }

    /**
     * Setter for <code>public.lab_examen_biopsia.estado_enfermedad</code>.
     */
    public void setEstadoEnfermedad(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.lab_examen_biopsia.estado_enfermedad</code>.
     */
    public String getEstadoEnfermedad() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.lab_examen_biopsia.modificado_por</code>.
     */
    public void setModificadoPor(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.lab_examen_biopsia.modificado_por</code>.
     */
    public String getModificadoPor() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.lab_examen_biopsia.fecha_modificacion</code>.
     */
    public void setFechaModificacion(LocalDate value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.lab_examen_biopsia.fecha_modificacion</code>.
     */
    public LocalDate getFechaModificacion() {
        return (LocalDate) get(11);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record12 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row12<Integer, Integer, String, Integer, LocalDate, String, String, String, BigDecimal, String, String, LocalDate> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    @Override
    public Row12<Integer, Integer, String, Integer, LocalDate, String, String, String, BigDecimal, String, String, LocalDate> valuesRow() {
        return (Row12) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return LabExamenBiopsia.LAB_EXAMEN_BIOPSIA.COD_BIOPSIA;
    }

    @Override
    public Field<Integer> field2() {
        return LabExamenBiopsia.LAB_EXAMEN_BIOPSIA.COD_EXAMEN;
    }

    @Override
    public Field<String> field3() {
        return LabExamenBiopsia.LAB_EXAMEN_BIOPSIA.NUM_BIOPSIA;
    }

    @Override
    public Field<Integer> field4() {
        return LabExamenBiopsia.LAB_EXAMEN_BIOPSIA.USUARIO_BIOPSIA;
    }

    @Override
    public Field<LocalDate> field5() {
        return LabExamenBiopsia.LAB_EXAMEN_BIOPSIA.FECHA_PLANIFICADA;
    }

    @Override
    public Field<String> field6() {
        return LabExamenBiopsia.LAB_EXAMEN_BIOPSIA.TIPO_BIOPSIA;
    }

    @Override
    public Field<String> field7() {
        return LabExamenBiopsia.LAB_EXAMEN_BIOPSIA.NUM_RECIBO;
    }

    @Override
    public Field<String> field8() {
        return LabExamenBiopsia.LAB_EXAMEN_BIOPSIA.SERIE_RECIBO;
    }

    @Override
    public Field<BigDecimal> field9() {
        return LabExamenBiopsia.LAB_EXAMEN_BIOPSIA.MONTO_RECIBO;
    }

    @Override
    public Field<String> field10() {
        return LabExamenBiopsia.LAB_EXAMEN_BIOPSIA.ESTADO_ENFERMEDAD;
    }

    @Override
    public Field<String> field11() {
        return LabExamenBiopsia.LAB_EXAMEN_BIOPSIA.MODIFICADO_POR;
    }

    @Override
    public Field<LocalDate> field12() {
        return LabExamenBiopsia.LAB_EXAMEN_BIOPSIA.FECHA_MODIFICACION;
    }

    @Override
    public Integer component1() {
        return getCodBiopsia();
    }

    @Override
    public Integer component2() {
        return getCodExamen();
    }

    @Override
    public String component3() {
        return getNumBiopsia();
    }

    @Override
    public Integer component4() {
        return getUsuarioBiopsia();
    }

    @Override
    public LocalDate component5() {
        return getFechaPlanificada();
    }

    @Override
    public String component6() {
        return getTipoBiopsia();
    }

    @Override
    public String component7() {
        return getNumRecibo();
    }

    @Override
    public String component8() {
        return getSerieRecibo();
    }

    @Override
    public BigDecimal component9() {
        return getMontoRecibo();
    }

    @Override
    public String component10() {
        return getEstadoEnfermedad();
    }

    @Override
    public String component11() {
        return getModificadoPor();
    }

    @Override
    public LocalDate component12() {
        return getFechaModificacion();
    }

    @Override
    public Integer value1() {
        return getCodBiopsia();
    }

    @Override
    public Integer value2() {
        return getCodExamen();
    }

    @Override
    public String value3() {
        return getNumBiopsia();
    }

    @Override
    public Integer value4() {
        return getUsuarioBiopsia();
    }

    @Override
    public LocalDate value5() {
        return getFechaPlanificada();
    }

    @Override
    public String value6() {
        return getTipoBiopsia();
    }

    @Override
    public String value7() {
        return getNumRecibo();
    }

    @Override
    public String value8() {
        return getSerieRecibo();
    }

    @Override
    public BigDecimal value9() {
        return getMontoRecibo();
    }

    @Override
    public String value10() {
        return getEstadoEnfermedad();
    }

    @Override
    public String value11() {
        return getModificadoPor();
    }

    @Override
    public LocalDate value12() {
        return getFechaModificacion();
    }

    @Override
    public LabExamenBiopsiaRecord value1(Integer value) {
        setCodBiopsia(value);
        return this;
    }

    @Override
    public LabExamenBiopsiaRecord value2(Integer value) {
        setCodExamen(value);
        return this;
    }

    @Override
    public LabExamenBiopsiaRecord value3(String value) {
        setNumBiopsia(value);
        return this;
    }

    @Override
    public LabExamenBiopsiaRecord value4(Integer value) {
        setUsuarioBiopsia(value);
        return this;
    }

    @Override
    public LabExamenBiopsiaRecord value5(LocalDate value) {
        setFechaPlanificada(value);
        return this;
    }

    @Override
    public LabExamenBiopsiaRecord value6(String value) {
        setTipoBiopsia(value);
        return this;
    }

    @Override
    public LabExamenBiopsiaRecord value7(String value) {
        setNumRecibo(value);
        return this;
    }

    @Override
    public LabExamenBiopsiaRecord value8(String value) {
        setSerieRecibo(value);
        return this;
    }

    @Override
    public LabExamenBiopsiaRecord value9(BigDecimal value) {
        setMontoRecibo(value);
        return this;
    }

    @Override
    public LabExamenBiopsiaRecord value10(String value) {
        setEstadoEnfermedad(value);
        return this;
    }

    @Override
    public LabExamenBiopsiaRecord value11(String value) {
        setModificadoPor(value);
        return this;
    }

    @Override
    public LabExamenBiopsiaRecord value12(LocalDate value) {
        setFechaModificacion(value);
        return this;
    }

    @Override
    public LabExamenBiopsiaRecord values(Integer value1, Integer value2, String value3, Integer value4, LocalDate value5, String value6, String value7, String value8, BigDecimal value9, String value10, String value11, LocalDate value12) {
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
        value12(value12);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LabExamenBiopsiaRecord
     */
    public LabExamenBiopsiaRecord() {
        super(LabExamenBiopsia.LAB_EXAMEN_BIOPSIA);
    }

    /**
     * Create a detached, initialised LabExamenBiopsiaRecord
     */
    public LabExamenBiopsiaRecord(Integer codBiopsia, Integer codExamen, String numBiopsia, Integer usuarioBiopsia, LocalDate fechaPlanificada, String tipoBiopsia, String numRecibo, String serieRecibo, BigDecimal montoRecibo, String estadoEnfermedad, String modificadoPor, LocalDate fechaModificacion) {
        super(LabExamenBiopsia.LAB_EXAMEN_BIOPSIA);

        setCodBiopsia(codBiopsia);
        setCodExamen(codExamen);
        setNumBiopsia(numBiopsia);
        setUsuarioBiopsia(usuarioBiopsia);
        setFechaPlanificada(fechaPlanificada);
        setTipoBiopsia(tipoBiopsia);
        setNumRecibo(numRecibo);
        setSerieRecibo(serieRecibo);
        setMontoRecibo(montoRecibo);
        setEstadoEnfermedad(estadoEnfermedad);
        setModificadoPor(modificadoPor);
        setFechaModificacion(fechaModificacion);
    }
}
