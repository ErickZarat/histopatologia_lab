/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db.tables;


import histopatologialab.core.db.Keys;
import histopatologialab.core.db.Public;
import histopatologialab.core.db.tables.records.LabPresentacionMedicamentoRecord;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
public class LabPresentacionMedicamento extends TableImpl<LabPresentacionMedicamentoRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.lab_presentacion_medicamento</code>
     */
    public static final LabPresentacionMedicamento LAB_PRESENTACION_MEDICAMENTO = new LabPresentacionMedicamento();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LabPresentacionMedicamentoRecord> getRecordType() {
        return LabPresentacionMedicamentoRecord.class;
    }

    /**
     * The column <code>public.lab_presentacion_medicamento.cod_medicamento</code>.
     */
    public final TableField<LabPresentacionMedicamentoRecord, Integer> COD_MEDICAMENTO = createField(DSL.name("cod_medicamento"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.lab_presentacion_medicamento.tipo_presentacion</code>.
     */
    public final TableField<LabPresentacionMedicamentoRecord, String> TIPO_PRESENTACION = createField(DSL.name("tipo_presentacion"), SQLDataType.VARCHAR(30).nullable(false), this, "");

    /**
     * The column <code>public.lab_presentacion_medicamento.estado_medicamento</code>.
     */
    public final TableField<LabPresentacionMedicamentoRecord, String> ESTADO_MEDICAMENTO = createField(DSL.name("estado_medicamento"), SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>public.lab_presentacion_medicamento.fecha_creacion</code>.
     */
    public final TableField<LabPresentacionMedicamentoRecord, LocalDate> FECHA_CREACION = createField(DSL.name("fecha_creacion"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.lab_presentacion_medicamento.creado_por</code>.
     */
    public final TableField<LabPresentacionMedicamentoRecord, String> CREADO_POR = createField(DSL.name("creado_por"), SQLDataType.VARCHAR(35), this, "");

    /**
     * The column <code>public.lab_presentacion_medicamento.fecha_modificacion</code>.
     */
    public final TableField<LabPresentacionMedicamentoRecord, LocalDate> FECHA_MODIFICACION = createField(DSL.name("fecha_modificacion"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.lab_presentacion_medicamento.modificado_por</code>.
     */
    public final TableField<LabPresentacionMedicamentoRecord, String> MODIFICADO_POR = createField(DSL.name("modificado_por"), SQLDataType.VARCHAR(35), this, "");

    private LabPresentacionMedicamento(Name alias, Table<LabPresentacionMedicamentoRecord> aliased) {
        this(alias, aliased, null);
    }

    private LabPresentacionMedicamento(Name alias, Table<LabPresentacionMedicamentoRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.lab_presentacion_medicamento</code> table reference
     */
    public LabPresentacionMedicamento(String alias) {
        this(DSL.name(alias), LAB_PRESENTACION_MEDICAMENTO);
    }

    /**
     * Create an aliased <code>public.lab_presentacion_medicamento</code> table reference
     */
    public LabPresentacionMedicamento(Name alias) {
        this(alias, LAB_PRESENTACION_MEDICAMENTO);
    }

    /**
     * Create a <code>public.lab_presentacion_medicamento</code> table reference
     */
    public LabPresentacionMedicamento() {
        this(DSL.name("lab_presentacion_medicamento"), null);
    }

    public <O extends Record> LabPresentacionMedicamento(Table<O> child, ForeignKey<O, LabPresentacionMedicamentoRecord> key) {
        super(child, key, LAB_PRESENTACION_MEDICAMENTO);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<LabPresentacionMedicamentoRecord> getPrimaryKey() {
        return Keys.LAB_PRESENTACION_MEDICAMENTO_PK;
    }

    @Override
    public List<UniqueKey<LabPresentacionMedicamentoRecord>> getKeys() {
        return Arrays.<UniqueKey<LabPresentacionMedicamentoRecord>>asList(Keys.LAB_PRESENTACION_MEDICAMENTO_PK);
    }

    @Override
    public List<ForeignKey<LabPresentacionMedicamentoRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<LabPresentacionMedicamentoRecord, ?>>asList(Keys.LAB_PRESENTACION_MEDICAMENTO__LAB_MEDICAMENTO_FK_COD_MEDICAMENTO);
    }

    private transient LabMedicamento _labMedicamento;

    public LabMedicamento labMedicamento() {
        if (_labMedicamento == null)
            _labMedicamento = new LabMedicamento(this, Keys.LAB_PRESENTACION_MEDICAMENTO__LAB_MEDICAMENTO_FK_COD_MEDICAMENTO);

        return _labMedicamento;
    }

    @Override
    public LabPresentacionMedicamento as(String alias) {
        return new LabPresentacionMedicamento(DSL.name(alias), this);
    }

    @Override
    public LabPresentacionMedicamento as(Name alias) {
        return new LabPresentacionMedicamento(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LabPresentacionMedicamento rename(String name) {
        return new LabPresentacionMedicamento(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LabPresentacionMedicamento rename(Name name) {
        return new LabPresentacionMedicamento(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, String, String, LocalDate, String, LocalDate, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}
