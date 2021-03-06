/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db.tables;


import histopatologialab.core.db.Keys;
import histopatologialab.core.db.Public;
import histopatologialab.core.db.tables.records.LabTincionRecord;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row7;
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
public class LabTincion extends TableImpl<LabTincionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.lab_tincion</code>
     */
    public static final LabTincion LAB_TINCION = new LabTincion();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LabTincionRecord> getRecordType() {
        return LabTincionRecord.class;
    }

    /**
     * The column <code>public.lab_tincion.cod_tincion</code>.
     */
    public final TableField<LabTincionRecord, Integer> COD_TINCION = createField(DSL.name("cod_tincion"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.lab_tincion.nombre_tincion</code>.
     */
    public final TableField<LabTincionRecord, String> NOMBRE_TINCION = createField(DSL.name("nombre_tincion"), SQLDataType.VARCHAR(35).nullable(false), this, "");

    /**
     * The column <code>public.lab_tincion.estado_tincion</code>.
     */
    public final TableField<LabTincionRecord, String> ESTADO_TINCION = createField(DSL.name("estado_tincion"), SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.lab_tincion.fecha_creacion</code>.
     */
    public final TableField<LabTincionRecord, LocalDate> FECHA_CREACION = createField(DSL.name("fecha_creacion"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.lab_tincion.creado_por</code>.
     */
    public final TableField<LabTincionRecord, String> CREADO_POR = createField(DSL.name("creado_por"), SQLDataType.VARCHAR(35), this, "");

    /**
     * The column <code>public.lab_tincion.modificado_por</code>.
     */
    public final TableField<LabTincionRecord, String> MODIFICADO_POR = createField(DSL.name("modificado_por"), SQLDataType.VARCHAR(35), this, "");

    /**
     * The column <code>public.lab_tincion.fecha_modificacion</code>.
     */
    public final TableField<LabTincionRecord, LocalDate> FECHA_MODIFICACION = createField(DSL.name("fecha_modificacion"), SQLDataType.LOCALDATE, this, "");

    private LabTincion(Name alias, Table<LabTincionRecord> aliased) {
        this(alias, aliased, null);
    }

    private LabTincion(Name alias, Table<LabTincionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.lab_tincion</code> table reference
     */
    public LabTincion(String alias) {
        this(DSL.name(alias), LAB_TINCION);
    }

    /**
     * Create an aliased <code>public.lab_tincion</code> table reference
     */
    public LabTincion(Name alias) {
        this(alias, LAB_TINCION);
    }

    /**
     * Create a <code>public.lab_tincion</code> table reference
     */
    public LabTincion() {
        this(DSL.name("lab_tincion"), null);
    }

    public <O extends Record> LabTincion(Table<O> child, ForeignKey<O, LabTincionRecord> key) {
        super(child, key, LAB_TINCION);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<LabTincionRecord, Integer> getIdentity() {
        return (Identity<LabTincionRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<LabTincionRecord> getPrimaryKey() {
        return Keys.LAB_TINCION_PK;
    }

    @Override
    public List<UniqueKey<LabTincionRecord>> getKeys() {
        return Arrays.<UniqueKey<LabTincionRecord>>asList(Keys.LAB_TINCION_PK);
    }

    @Override
    public LabTincion as(String alias) {
        return new LabTincion(DSL.name(alias), this);
    }

    @Override
    public LabTincion as(Name alias) {
        return new LabTincion(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LabTincion rename(String name) {
        return new LabTincion(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LabTincion rename(Name name) {
        return new LabTincion(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, String, String, LocalDate, String, String, LocalDate> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}
