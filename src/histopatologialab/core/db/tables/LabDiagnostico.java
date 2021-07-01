/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db.tables;


import histopatologialab.core.db.Keys;
import histopatologialab.core.db.Public;
import histopatologialab.core.db.tables.records.LabDiagnosticoRecord;

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
public class LabDiagnostico extends TableImpl<LabDiagnosticoRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.lab_diagnostico</code>
     */
    public static final LabDiagnostico LAB_DIAGNOSTICO = new LabDiagnostico();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LabDiagnosticoRecord> getRecordType() {
        return LabDiagnosticoRecord.class;
    }

    /**
     * The column <code>public.lab_diagnostico.cod_diagnostico</code>.
     */
    public final TableField<LabDiagnosticoRecord, Long> COD_DIAGNOSTICO = createField(DSL.name("cod_diagnostico"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.lab_diagnostico.nombre_diagnostico</code>.
     */
    public final TableField<LabDiagnosticoRecord, String> NOMBRE_DIAGNOSTICO = createField(DSL.name("nombre_diagnostico"), SQLDataType.VARCHAR(35).nullable(false), this, "");

    /**
     * The column <code>public.lab_diagnostico.estado_diagnostico</code>.
     */
    public final TableField<LabDiagnosticoRecord, String> ESTADO_DIAGNOSTICO = createField(DSL.name("estado_diagnostico"), SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>public.lab_diagnostico.fecha_creacion</code>.
     */
    public final TableField<LabDiagnosticoRecord, LocalDate> FECHA_CREACION = createField(DSL.name("fecha_creacion"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.lab_diagnostico.creado_por</code>.
     */
    public final TableField<LabDiagnosticoRecord, String> CREADO_POR = createField(DSL.name("creado_por"), SQLDataType.VARCHAR(35), this, "");

    /**
     * The column <code>public.lab_diagnostico.fecha_modificacion</code>.
     */
    public final TableField<LabDiagnosticoRecord, LocalDate> FECHA_MODIFICACION = createField(DSL.name("fecha_modificacion"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.lab_diagnostico.modificado_por</code>.
     */
    public final TableField<LabDiagnosticoRecord, String> MODIFICADO_POR = createField(DSL.name("modificado_por"), SQLDataType.VARCHAR(35), this, "");

    private LabDiagnostico(Name alias, Table<LabDiagnosticoRecord> aliased) {
        this(alias, aliased, null);
    }

    private LabDiagnostico(Name alias, Table<LabDiagnosticoRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.lab_diagnostico</code> table reference
     */
    public LabDiagnostico(String alias) {
        this(DSL.name(alias), LAB_DIAGNOSTICO);
    }

    /**
     * Create an aliased <code>public.lab_diagnostico</code> table reference
     */
    public LabDiagnostico(Name alias) {
        this(alias, LAB_DIAGNOSTICO);
    }

    /**
     * Create a <code>public.lab_diagnostico</code> table reference
     */
    public LabDiagnostico() {
        this(DSL.name("lab_diagnostico"), null);
    }

    public <O extends Record> LabDiagnostico(Table<O> child, ForeignKey<O, LabDiagnosticoRecord> key) {
        super(child, key, LAB_DIAGNOSTICO);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<LabDiagnosticoRecord, Long> getIdentity() {
        return (Identity<LabDiagnosticoRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<LabDiagnosticoRecord> getPrimaryKey() {
        return Keys.LAB_DIAGNOSTICO_PK;
    }

    @Override
    public List<UniqueKey<LabDiagnosticoRecord>> getKeys() {
        return Arrays.<UniqueKey<LabDiagnosticoRecord>>asList(Keys.LAB_DIAGNOSTICO_PK);
    }

    @Override
    public LabDiagnostico as(String alias) {
        return new LabDiagnostico(DSL.name(alias), this);
    }

    @Override
    public LabDiagnostico as(Name alias) {
        return new LabDiagnostico(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LabDiagnostico rename(String name) {
        return new LabDiagnostico(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LabDiagnostico rename(Name name) {
        return new LabDiagnostico(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Long, String, String, LocalDate, String, LocalDate, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}
