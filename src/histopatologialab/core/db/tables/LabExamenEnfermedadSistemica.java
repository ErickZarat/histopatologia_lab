/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db.tables;


import histopatologialab.core.db.Keys;
import histopatologialab.core.db.Public;
import histopatologialab.core.db.tables.records.LabExamenEnfermedadSistemicaRecord;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LabExamenEnfermedadSistemica extends TableImpl<LabExamenEnfermedadSistemicaRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.lab_examen_enfermedad_sistemica</code>
     */
    public static final LabExamenEnfermedadSistemica LAB_EXAMEN_ENFERMEDAD_SISTEMICA = new LabExamenEnfermedadSistemica();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LabExamenEnfermedadSistemicaRecord> getRecordType() {
        return LabExamenEnfermedadSistemicaRecord.class;
    }

    /**
     * The column <code>public.lab_examen_enfermedad_sistemica.cod_examen</code>.
     */
    public final TableField<LabExamenEnfermedadSistemicaRecord, Integer> COD_EXAMEN = createField(DSL.name("cod_examen"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.lab_examen_enfermedad_sistemica.cod_enfermedad_sistemica</code>.
     */
    public final TableField<LabExamenEnfermedadSistemicaRecord, Integer> COD_ENFERMEDAD_SISTEMICA = createField(DSL.name("cod_enfermedad_sistemica"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.lab_examen_enfermedad_sistemica.fecha_creacion</code>.
     */
    public final TableField<LabExamenEnfermedadSistemicaRecord, LocalDate> FECHA_CREACION = createField(DSL.name("fecha_creacion"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.lab_examen_enfermedad_sistemica.creado_por</code>.
     */
    public final TableField<LabExamenEnfermedadSistemicaRecord, String> CREADO_POR = createField(DSL.name("creado_por"), SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>public.lab_examen_enfermedad_sistemica.fecha_modificacion</code>.
     */
    public final TableField<LabExamenEnfermedadSistemicaRecord, LocalDate> FECHA_MODIFICACION = createField(DSL.name("fecha_modificacion"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.lab_examen_enfermedad_sistemica.modificado_por</code>.
     */
    public final TableField<LabExamenEnfermedadSistemicaRecord, String> MODIFICADO_POR = createField(DSL.name("modificado_por"), SQLDataType.VARCHAR(20), this, "");

    private LabExamenEnfermedadSistemica(Name alias, Table<LabExamenEnfermedadSistemicaRecord> aliased) {
        this(alias, aliased, null);
    }

    private LabExamenEnfermedadSistemica(Name alias, Table<LabExamenEnfermedadSistemicaRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.lab_examen_enfermedad_sistemica</code> table reference
     */
    public LabExamenEnfermedadSistemica(String alias) {
        this(DSL.name(alias), LAB_EXAMEN_ENFERMEDAD_SISTEMICA);
    }

    /**
     * Create an aliased <code>public.lab_examen_enfermedad_sistemica</code> table reference
     */
    public LabExamenEnfermedadSistemica(Name alias) {
        this(alias, LAB_EXAMEN_ENFERMEDAD_SISTEMICA);
    }

    /**
     * Create a <code>public.lab_examen_enfermedad_sistemica</code> table reference
     */
    public LabExamenEnfermedadSistemica() {
        this(DSL.name("lab_examen_enfermedad_sistemica"), null);
    }

    public <O extends Record> LabExamenEnfermedadSistemica(Table<O> child, ForeignKey<O, LabExamenEnfermedadSistemicaRecord> key) {
        super(child, key, LAB_EXAMEN_ENFERMEDAD_SISTEMICA);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<LabExamenEnfermedadSistemicaRecord> getPrimaryKey() {
        return Keys.LAB_EXAMEN_ENFERMEDAD_SISTEMICA_PK;
    }

    @Override
    public List<UniqueKey<LabExamenEnfermedadSistemicaRecord>> getKeys() {
        return Arrays.<UniqueKey<LabExamenEnfermedadSistemicaRecord>>asList(Keys.LAB_EXAMEN_ENFERMEDAD_SISTEMICA_PK);
    }

    @Override
    public List<ForeignKey<LabExamenEnfermedadSistemicaRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<LabExamenEnfermedadSistemicaRecord, ?>>asList(Keys.LAB_EXAMEN_ENFERMEDAD_SISTEMICA__COD_EXAMEN_FK, Keys.LAB_EXAMEN_ENFERMEDAD_SISTEMICA__COD_ENFERMEDAD_SISTEMICA_FK);
    }

    private transient LabExamen _labExamen;
    private transient LabEnfermedadSistemica _labEnfermedadSistemica;

    public LabExamen labExamen() {
        if (_labExamen == null)
            _labExamen = new LabExamen(this, Keys.LAB_EXAMEN_ENFERMEDAD_SISTEMICA__COD_EXAMEN_FK);

        return _labExamen;
    }

    public LabEnfermedadSistemica labEnfermedadSistemica() {
        if (_labEnfermedadSistemica == null)
            _labEnfermedadSistemica = new LabEnfermedadSistemica(this, Keys.LAB_EXAMEN_ENFERMEDAD_SISTEMICA__COD_ENFERMEDAD_SISTEMICA_FK);

        return _labEnfermedadSistemica;
    }

    @Override
    public LabExamenEnfermedadSistemica as(String alias) {
        return new LabExamenEnfermedadSistemica(DSL.name(alias), this);
    }

    @Override
    public LabExamenEnfermedadSistemica as(Name alias) {
        return new LabExamenEnfermedadSistemica(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LabExamenEnfermedadSistemica rename(String name) {
        return new LabExamenEnfermedadSistemica(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LabExamenEnfermedadSistemica rename(Name name) {
        return new LabExamenEnfermedadSistemica(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, Integer, LocalDate, String, LocalDate, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}