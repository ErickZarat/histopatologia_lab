/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db.tables.records;


import histopatologialab.core.db.tables.LabExamenCaracteristica;

import java.time.LocalDate;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LabExamenCaracteristicaRecord extends UpdatableRecordImpl<LabExamenCaracteristicaRecord> implements Record6<Integer, Integer, LocalDate, String, LocalDate, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.lab_examen_caracteristica.cod_examen</code>.
     */
    public void setCodExamen(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.lab_examen_caracteristica.cod_examen</code>.
     */
    public Integer getCodExamen() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.lab_examen_caracteristica.codigo_tipo_opcion_lesion</code>.
     */
    public void setCodigoTipoOpcionLesion(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.lab_examen_caracteristica.codigo_tipo_opcion_lesion</code>.
     */
    public Integer getCodigoTipoOpcionLesion() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.lab_examen_caracteristica.fecha_creacion</code>.
     */
    public void setFechaCreacion(LocalDate value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.lab_examen_caracteristica.fecha_creacion</code>.
     */
    public LocalDate getFechaCreacion() {
        return (LocalDate) get(2);
    }

    /**
     * Setter for <code>public.lab_examen_caracteristica.creado_por</code>.
     */
    public void setCreadoPor(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.lab_examen_caracteristica.creado_por</code>.
     */
    public String getCreadoPor() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.lab_examen_caracteristica.fecha_modificacion</code>.
     */
    public void setFechaModificacion(LocalDate value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.lab_examen_caracteristica.fecha_modificacion</code>.
     */
    public LocalDate getFechaModificacion() {
        return (LocalDate) get(4);
    }

    /**
     * Setter for <code>public.lab_examen_caracteristica.modificado_por</code>.
     */
    public void setModificadoPor(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.lab_examen_caracteristica.modificado_por</code>.
     */
    public String getModificadoPor() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, Integer, LocalDate, String, LocalDate, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Integer, Integer, LocalDate, String, LocalDate, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return LabExamenCaracteristica.LAB_EXAMEN_CARACTERISTICA.COD_EXAMEN;
    }

    @Override
    public Field<Integer> field2() {
        return LabExamenCaracteristica.LAB_EXAMEN_CARACTERISTICA.CODIGO_TIPO_OPCION_LESION;
    }

    @Override
    public Field<LocalDate> field3() {
        return LabExamenCaracteristica.LAB_EXAMEN_CARACTERISTICA.FECHA_CREACION;
    }

    @Override
    public Field<String> field4() {
        return LabExamenCaracteristica.LAB_EXAMEN_CARACTERISTICA.CREADO_POR;
    }

    @Override
    public Field<LocalDate> field5() {
        return LabExamenCaracteristica.LAB_EXAMEN_CARACTERISTICA.FECHA_MODIFICACION;
    }

    @Override
    public Field<String> field6() {
        return LabExamenCaracteristica.LAB_EXAMEN_CARACTERISTICA.MODIFICADO_POR;
    }

    @Override
    public Integer component1() {
        return getCodExamen();
    }

    @Override
    public Integer component2() {
        return getCodigoTipoOpcionLesion();
    }

    @Override
    public LocalDate component3() {
        return getFechaCreacion();
    }

    @Override
    public String component4() {
        return getCreadoPor();
    }

    @Override
    public LocalDate component5() {
        return getFechaModificacion();
    }

    @Override
    public String component6() {
        return getModificadoPor();
    }

    @Override
    public Integer value1() {
        return getCodExamen();
    }

    @Override
    public Integer value2() {
        return getCodigoTipoOpcionLesion();
    }

    @Override
    public LocalDate value3() {
        return getFechaCreacion();
    }

    @Override
    public String value4() {
        return getCreadoPor();
    }

    @Override
    public LocalDate value5() {
        return getFechaModificacion();
    }

    @Override
    public String value6() {
        return getModificadoPor();
    }

    @Override
    public LabExamenCaracteristicaRecord value1(Integer value) {
        setCodExamen(value);
        return this;
    }

    @Override
    public LabExamenCaracteristicaRecord value2(Integer value) {
        setCodigoTipoOpcionLesion(value);
        return this;
    }

    @Override
    public LabExamenCaracteristicaRecord value3(LocalDate value) {
        setFechaCreacion(value);
        return this;
    }

    @Override
    public LabExamenCaracteristicaRecord value4(String value) {
        setCreadoPor(value);
        return this;
    }

    @Override
    public LabExamenCaracteristicaRecord value5(LocalDate value) {
        setFechaModificacion(value);
        return this;
    }

    @Override
    public LabExamenCaracteristicaRecord value6(String value) {
        setModificadoPor(value);
        return this;
    }

    @Override
    public LabExamenCaracteristicaRecord values(Integer value1, Integer value2, LocalDate value3, String value4, LocalDate value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LabExamenCaracteristicaRecord
     */
    public LabExamenCaracteristicaRecord() {
        super(LabExamenCaracteristica.LAB_EXAMEN_CARACTERISTICA);
    }

    /**
     * Create a detached, initialised LabExamenCaracteristicaRecord
     */
    public LabExamenCaracteristicaRecord(Integer codExamen, Integer codigoTipoOpcionLesion, LocalDate fechaCreacion, String creadoPor, LocalDate fechaModificacion, String modificadoPor) {
        super(LabExamenCaracteristica.LAB_EXAMEN_CARACTERISTICA);

        setCodExamen(codExamen);
        setCodigoTipoOpcionLesion(codigoTipoOpcionLesion);
        setFechaCreacion(fechaCreacion);
        setCreadoPor(creadoPor);
        setFechaModificacion(fechaModificacion);
        setModificadoPor(modificadoPor);
    }
}
