/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db.tables.records;


import histopatologialab.core.db.tables.LabFuncion;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LabFuncionRecord extends UpdatableRecordImpl<LabFuncionRecord> implements Record4<Integer, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.lab_funcion.codigo_funcion</code>.
     */
    public void setCodigoFuncion(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.lab_funcion.codigo_funcion</code>.
     */
    public Integer getCodigoFuncion() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.lab_funcion.funcion_nombre</code>.
     */
    public void setFuncionNombre(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.lab_funcion.funcion_nombre</code>.
     */
    public String getFuncionNombre() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.lab_funcion.rol_descripcion</code>.
     */
    public void setRolDescripcion(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.lab_funcion.rol_descripcion</code>.
     */
    public String getRolDescripcion() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.lab_funcion.funcion_estado</code>.
     */
    public void setFuncionEstado(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.lab_funcion.funcion_estado</code>.
     */
    public String getFuncionEstado() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return LabFuncion.LAB_FUNCION.CODIGO_FUNCION;
    }

    @Override
    public Field<String> field2() {
        return LabFuncion.LAB_FUNCION.FUNCION_NOMBRE;
    }

    @Override
    public Field<String> field3() {
        return LabFuncion.LAB_FUNCION.ROL_DESCRIPCION;
    }

    @Override
    public Field<String> field4() {
        return LabFuncion.LAB_FUNCION.FUNCION_ESTADO;
    }

    @Override
    public Integer component1() {
        return getCodigoFuncion();
    }

    @Override
    public String component2() {
        return getFuncionNombre();
    }

    @Override
    public String component3() {
        return getRolDescripcion();
    }

    @Override
    public String component4() {
        return getFuncionEstado();
    }

    @Override
    public Integer value1() {
        return getCodigoFuncion();
    }

    @Override
    public String value2() {
        return getFuncionNombre();
    }

    @Override
    public String value3() {
        return getRolDescripcion();
    }

    @Override
    public String value4() {
        return getFuncionEstado();
    }

    @Override
    public LabFuncionRecord value1(Integer value) {
        setCodigoFuncion(value);
        return this;
    }

    @Override
    public LabFuncionRecord value2(String value) {
        setFuncionNombre(value);
        return this;
    }

    @Override
    public LabFuncionRecord value3(String value) {
        setRolDescripcion(value);
        return this;
    }

    @Override
    public LabFuncionRecord value4(String value) {
        setFuncionEstado(value);
        return this;
    }

    @Override
    public LabFuncionRecord values(Integer value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LabFuncionRecord
     */
    public LabFuncionRecord() {
        super(LabFuncion.LAB_FUNCION);
    }

    /**
     * Create a detached, initialised LabFuncionRecord
     */
    public LabFuncionRecord(Integer codigoFuncion, String funcionNombre, String rolDescripcion, String funcionEstado) {
        super(LabFuncion.LAB_FUNCION);

        setCodigoFuncion(codigoFuncion);
        setFuncionNombre(funcionNombre);
        setRolDescripcion(rolDescripcion);
        setFuncionEstado(funcionEstado);
    }
}
