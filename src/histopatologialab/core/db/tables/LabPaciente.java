/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db.tables;


import histopatologialab.core.db.Keys;
import histopatologialab.core.db.Public;
import histopatologialab.core.db.tables.records.LabPacienteRecord;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row16;
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
public class LabPaciente extends TableImpl<LabPacienteRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.lab_paciente</code>
     */
    public static final LabPaciente LAB_PACIENTE = new LabPaciente();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LabPacienteRecord> getRecordType() {
        return LabPacienteRecord.class;
    }

    /**
     * The column <code>public.lab_paciente.cod_paciente</code>.
     */
    public final TableField<LabPacienteRecord, Long> COD_PACIENTE = createField(DSL.name("cod_paciente"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.lab_paciente.nombre</code>.
     */
    public final TableField<LabPacienteRecord, String> NOMBRE = createField(DSL.name("nombre"), SQLDataType.VARCHAR(60).nullable(false), this, "");

    /**
     * The column <code>public.lab_paciente.apellidos</code>.
     */
    public final TableField<LabPacienteRecord, String> APELLIDOS = createField(DSL.name("apellidos"), SQLDataType.VARCHAR(60).nullable(false), this, "");

    /**
     * The column <code>public.lab_paciente.email</code>.
     */
    public final TableField<LabPacienteRecord, String> EMAIL = createField(DSL.name("email"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.lab_paciente.identificacion</code>.
     */
    public final TableField<LabPacienteRecord, String> IDENTIFICACION = createField(DSL.name("identificacion"), SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>public.lab_paciente.direccion</code>.
     */
    public final TableField<LabPacienteRecord, String> DIRECCION = createField(DSL.name("direccion"), SQLDataType.VARCHAR(250), this, "");

    /**
     * The column <code>public.lab_paciente.telefono</code>.
     */
    public final TableField<LabPacienteRecord, String> TELEFONO = createField(DSL.name("telefono"), SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>public.lab_paciente.estadocivil</code>.
     */
    public final TableField<LabPacienteRecord, String> ESTADOCIVIL = createField(DSL.name("estadocivil"), SQLDataType.VARCHAR(15), this, "");

    /**
     * The column <code>public.lab_paciente.fechanacimiento</code>.
     */
    public final TableField<LabPacienteRecord, LocalDate> FECHANACIMIENTO = createField(DSL.name("fechanacimiento"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.lab_paciente.genero</code>.
     */
    public final TableField<LabPacienteRecord, String> GENERO = createField(DSL.name("genero"), SQLDataType.VARCHAR(15), this, "");

    /**
     * The column <code>public.lab_paciente.ocupacion</code>.
     */
    public final TableField<LabPacienteRecord, String> OCUPACION = createField(DSL.name("ocupacion"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.lab_paciente.tipo_identificacion</code>.
     */
    public final TableField<LabPacienteRecord, String> TIPO_IDENTIFICACION = createField(DSL.name("tipo_identificacion"), SQLDataType.VARCHAR(15), this, "");

    /**
     * The column <code>public.lab_paciente.creadopor</code>.
     */
    public final TableField<LabPacienteRecord, String> CREADOPOR = createField(DSL.name("creadopor"), SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>public.lab_paciente.fechacreacion</code>.
     */
    public final TableField<LabPacienteRecord, LocalDate> FECHACREACION = createField(DSL.name("fechacreacion"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.lab_paciente.modificadopor</code>.
     */
    public final TableField<LabPacienteRecord, String> MODIFICADOPOR = createField(DSL.name("modificadopor"), SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>public.lab_paciente.fechamodificacion</code>.
     */
    public final TableField<LabPacienteRecord, LocalDate> FECHAMODIFICACION = createField(DSL.name("fechamodificacion"), SQLDataType.LOCALDATE, this, "");

    private LabPaciente(Name alias, Table<LabPacienteRecord> aliased) {
        this(alias, aliased, null);
    }

    private LabPaciente(Name alias, Table<LabPacienteRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.lab_paciente</code> table reference
     */
    public LabPaciente(String alias) {
        this(DSL.name(alias), LAB_PACIENTE);
    }

    /**
     * Create an aliased <code>public.lab_paciente</code> table reference
     */
    public LabPaciente(Name alias) {
        this(alias, LAB_PACIENTE);
    }

    /**
     * Create a <code>public.lab_paciente</code> table reference
     */
    public LabPaciente() {
        this(DSL.name("lab_paciente"), null);
    }

    public <O extends Record> LabPaciente(Table<O> child, ForeignKey<O, LabPacienteRecord> key) {
        super(child, key, LAB_PACIENTE);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<LabPacienteRecord, Long> getIdentity() {
        return (Identity<LabPacienteRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<LabPacienteRecord> getPrimaryKey() {
        return Keys.LAB_PACIENTE_PK;
    }

    @Override
    public List<UniqueKey<LabPacienteRecord>> getKeys() {
        return Arrays.<UniqueKey<LabPacienteRecord>>asList(Keys.LAB_PACIENTE_PK);
    }

    @Override
    public LabPaciente as(String alias) {
        return new LabPaciente(DSL.name(alias), this);
    }

    @Override
    public LabPaciente as(Name alias) {
        return new LabPaciente(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LabPaciente rename(String name) {
        return new LabPaciente(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LabPaciente rename(Name name) {
        return new LabPaciente(name, null);
    }

    // -------------------------------------------------------------------------
    // Row16 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row16<Long, String, String, String, String, String, String, String, LocalDate, String, String, String, String, LocalDate, String, LocalDate> fieldsRow() {
        return (Row16) super.fieldsRow();
    }
}