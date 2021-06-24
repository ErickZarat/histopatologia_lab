/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db.tables;


import histopatologialab.core.db.Keys;
import histopatologialab.core.db.Public;
import histopatologialab.core.db.tables.records.LabExamenDiagnosticoRecord;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
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
public class LabExamenDiagnostico extends TableImpl<LabExamenDiagnosticoRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.lab_examen_diagnostico</code>
     */
    public static final LabExamenDiagnostico LAB_EXAMEN_DIAGNOSTICO = new LabExamenDiagnostico();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LabExamenDiagnosticoRecord> getRecordType() {
        return LabExamenDiagnosticoRecord.class;
    }

    /**
     * The column <code>public.lab_examen_diagnostico.cod_examen</code>.
     */
    public final TableField<LabExamenDiagnosticoRecord, Integer> COD_EXAMEN = createField(DSL.name("cod_examen"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.lab_examen_diagnostico.cod_diagnostico</code>.
     */
    public final TableField<LabExamenDiagnosticoRecord, Integer> COD_DIAGNOSTICO = createField(DSL.name("cod_diagnostico"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.lab_examen_diagnostico.indice_diagnostico</code>.
     */
    public final TableField<LabExamenDiagnosticoRecord, Integer> INDICE_DIAGNOSTICO = createField(DSL.name("indice_diagnostico"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.lab_examen_diagnostico.tipo_diagnostico</code>.
     */
    public final TableField<LabExamenDiagnosticoRecord, Integer> TIPO_DIAGNOSTICO = createField(DSL.name("tipo_diagnostico"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.lab_examen_diagnostico.fecha_creacion</code>.
     */
    public final TableField<LabExamenDiagnosticoRecord, LocalDate> FECHA_CREACION = createField(DSL.name("fecha_creacion"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.lab_examen_diagnostico.creado_por</code>.
     */
    public final TableField<LabExamenDiagnosticoRecord, Integer> CREADO_POR = createField(DSL.name("creado_por"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.lab_examen_diagnostico.fecha_modificacion</code>.
     */
    public final TableField<LabExamenDiagnosticoRecord, LocalDate> FECHA_MODIFICACION = createField(DSL.name("fecha_modificacion"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.lab_examen_diagnostico.modificado_por</code>.
     */
    public final TableField<LabExamenDiagnosticoRecord, String> MODIFICADO_POR = createField(DSL.name("modificado_por"), SQLDataType.VARCHAR(30), this, "");

    private LabExamenDiagnostico(Name alias, Table<LabExamenDiagnosticoRecord> aliased) {
        this(alias, aliased, null);
    }

    private LabExamenDiagnostico(Name alias, Table<LabExamenDiagnosticoRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.lab_examen_diagnostico</code> table reference
     */
    public LabExamenDiagnostico(String alias) {
        this(DSL.name(alias), LAB_EXAMEN_DIAGNOSTICO);
    }

    /**
     * Create an aliased <code>public.lab_examen_diagnostico</code> table reference
     */
    public LabExamenDiagnostico(Name alias) {
        this(alias, LAB_EXAMEN_DIAGNOSTICO);
    }

    /**
     * Create a <code>public.lab_examen_diagnostico</code> table reference
     */
    public LabExamenDiagnostico() {
        this(DSL.name("lab_examen_diagnostico"), null);
    }

    public <O extends Record> LabExamenDiagnostico(Table<O> child, ForeignKey<O, LabExamenDiagnosticoRecord> key) {
        super(child, key, LAB_EXAMEN_DIAGNOSTICO);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<LabExamenDiagnosticoRecord> getPrimaryKey() {
        return Keys.EXAMEN_DIAGNOSTICO_PK;
    }

    @Override
    public List<UniqueKey<LabExamenDiagnosticoRecord>> getKeys() {
        return Arrays.<UniqueKey<LabExamenDiagnosticoRecord>>asList(Keys.EXAMEN_DIAGNOSTICO_PK);
    }

    @Override
    public List<ForeignKey<LabExamenDiagnosticoRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<LabExamenDiagnosticoRecord, ?>>asList(Keys.LAB_EXAMEN_DIAGNOSTICO__EXAMEN_DIAGNOSTICO_EXAMEN_FK, Keys.LAB_EXAMEN_DIAGNOSTICO__EXAMEN_DIAGNOSTICO_DIAGNOSTICO_FK, Keys.LAB_EXAMEN_DIAGNOSTICO__EXAMEN_DIAGNOSTICO_USUARIO_FK);
    }

    private transient LabExamen _labExamen;
    private transient LabDiagnostico _labDiagnostico;
    private transient LabUsuario _labUsuario;

    public LabExamen labExamen() {
        if (_labExamen == null)
            _labExamen = new LabExamen(this, Keys.LAB_EXAMEN_DIAGNOSTICO__EXAMEN_DIAGNOSTICO_EXAMEN_FK);

        return _labExamen;
    }

    public LabDiagnostico labDiagnostico() {
        if (_labDiagnostico == null)
            _labDiagnostico = new LabDiagnostico(this, Keys.LAB_EXAMEN_DIAGNOSTICO__EXAMEN_DIAGNOSTICO_DIAGNOSTICO_FK);

        return _labDiagnostico;
    }

    public LabUsuario labUsuario() {
        if (_labUsuario == null)
            _labUsuario = new LabUsuario(this, Keys.LAB_EXAMEN_DIAGNOSTICO__EXAMEN_DIAGNOSTICO_USUARIO_FK);

        return _labUsuario;
    }

    @Override
    public LabExamenDiagnostico as(String alias) {
        return new LabExamenDiagnostico(DSL.name(alias), this);
    }

    @Override
    public LabExamenDiagnostico as(Name alias) {
        return new LabExamenDiagnostico(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LabExamenDiagnostico rename(String name) {
        return new LabExamenDiagnostico(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LabExamenDiagnostico rename(Name name) {
        return new LabExamenDiagnostico(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Integer, Integer, Integer, Integer, LocalDate, Integer, LocalDate, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}