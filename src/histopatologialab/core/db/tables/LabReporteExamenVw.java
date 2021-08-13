/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db.tables;


import histopatologialab.core.db.Public;
import histopatologialab.core.db.tables.records.LabReporteExamenVwRecord;

import java.time.LocalDate;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LabReporteExamenVw extends TableImpl<LabReporteExamenVwRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.lab_reporte_examen_vw</code>
     */
    public static final LabReporteExamenVw LAB_REPORTE_EXAMEN_VW = new LabReporteExamenVw();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LabReporteExamenVwRecord> getRecordType() {
        return LabReporteExamenVwRecord.class;
    }

    /**
     * The column <code>public.lab_reporte_examen_vw.cod_examen</code>.
     */
    public final TableField<LabReporteExamenVwRecord, Integer> COD_EXAMEN = createField(DSL.name("cod_examen"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.num_examen</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> NUM_EXAMEN = createField(DSL.name("num_examen"), SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.fecha_examen</code>.
     */
    public final TableField<LabReporteExamenVwRecord, LocalDate> FECHA_EXAMEN = createField(DSL.name("fecha_examen"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.fec_examen</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> FEC_EXAMEN = createField(DSL.name("fec_examen"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.nombre_paciente</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> NOMBRE_PACIENTE = createField(DSL.name("nombre_paciente"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.tipo_identificacion</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> TIPO_IDENTIFICACION = createField(DSL.name("tipo_identificacion"), SQLDataType.VARCHAR(15), this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.identificacion</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> IDENTIFICACION = createField(DSL.name("identificacion"), SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.ocupacion</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> OCUPACION = createField(DSL.name("ocupacion"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.numero_ficha</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> NUMERO_FICHA = createField(DSL.name("numero_ficha"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.enfermedades</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> ENFERMEDADES = createField(DSL.name("enfermedades"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.diagnosticos_diferenciales</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> DIAGNOSTICOS_DIFERENCIALES = createField(DSL.name("diagnosticos_diferenciales"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.estado_examen</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> ESTADO_EXAMEN = createField(DSL.name("estado_examen"), SQLDataType.VARCHAR(25), this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.doctor_examen</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> DOCTOR_EXAMEN = createField(DSL.name("doctor_examen"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.color_lesion</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> COLOR_LESION = createField(DSL.name("color_lesion"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.naturaleza_lesion</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> NATURALEZA_LESION = createField(DSL.name("naturaleza_lesion"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.sintoma_lesion</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> SINTOMA_LESION = createField(DSL.name("sintoma_lesion"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.forma_lesion</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> FORMA_LESION = createField(DSL.name("forma_lesion"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.superficie_lesion</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> SUPERFICIE_LESION = createField(DSL.name("superficie_lesion"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.consistencia_lesion</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> CONSISTENCIA_LESION = createField(DSL.name("consistencia_lesion"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.intraoseo_lesion</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> INTRAOSEO_LESION = createField(DSL.name("intraoseo_lesion"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.pieza_lesion</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> PIEZA_LESION = createField(DSL.name("pieza_lesion"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.tamano_lesion</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> TAMANO_LESION = createField(DSL.name("tamano_lesion"), SQLDataType.VARCHAR(15), this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.dias_lesion</code>.
     */
    public final TableField<LabReporteExamenVwRecord, Integer> DIAS_LESION = createField(DSL.name("dias_lesion"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.meses_lesion</code>.
     */
    public final TableField<LabReporteExamenVwRecord, Integer> MESES_LESION = createField(DSL.name("meses_lesion"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.anios_lesion</code>.
     */
    public final TableField<LabReporteExamenVwRecord, Integer> ANIOS_LESION = createField(DSL.name("anios_lesion"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.doctor_remision</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> DOCTOR_REMISION = createField(DSL.name("doctor_remision"), SQLDataType.VARCHAR(30), this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.dependencia_doctor_remision</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> DEPENDENCIA_DOCTOR_REMISION = createField(DSL.name("dependencia_doctor_remision"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.req_biopsia</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> REQ_BIOPSIA = createField(DSL.name("req_biopsia"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.numero_biopsia</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> NUMERO_BIOPSIA = createField(DSL.name("numero_biopsia"), SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.fec_biopsia</code>.
     */
    public final TableField<LabReporteExamenVwRecord, LocalDate> FEC_BIOPSIA = createField(DSL.name("fec_biopsia"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.fecha_biopsia</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> FECHA_BIOPSIA = createField(DSL.name("fecha_biopsia"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.muestra_biopsia</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> MUESTRA_BIOPSIA = createField(DSL.name("muestra_biopsia"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.procedimiento</code>.
     */
    public final TableField<LabReporteExamenVwRecord, Integer> PROCEDIMIENTO = createField(DSL.name("procedimiento"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.procedimiento_biopsia</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> PROCEDIMIENTO_BIOPSIA = createField(DSL.name("procedimiento_biopsia"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.tipo_cirugia</code>.
     */
    public final TableField<LabReporteExamenVwRecord, Integer> TIPO_CIRUGIA = createField(DSL.name("tipo_cirugia"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.tipocirugia_biopsia</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> TIPOCIRUGIA_BIOPSIA = createField(DSL.name("tipocirugia_biopsia"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.instrumento</code>.
     */
    public final TableField<LabReporteExamenVwRecord, Integer> INSTRUMENTO = createField(DSL.name("instrumento"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.instrumento_biopsia</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> INSTRUMENTO_BIOPSIA = createField(DSL.name("instrumento_biopsia"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.usuario_biopsia</code>.
     */
    public final TableField<LabReporteExamenVwRecord, Integer> USUARIO_BIOPSIA = createField(DSL.name("usuario_biopsia"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.usuario_realiza_biopsia</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> USUARIO_REALIZA_BIOPSIA = createField(DSL.name("usuario_realiza_biopsia"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.estado_biopsia</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> ESTADO_BIOPSIA = createField(DSL.name("estado_biopsia"), SQLDataType.VARCHAR(30), this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.fecha_informe_biopsia</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> FECHA_INFORME_BIOPSIA = createField(DSL.name("fecha_informe_biopsia"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.diagnostico_biopsia</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> DIAGNOSTICO_BIOPSIA = createField(DSL.name("diagnostico_biopsia"), SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.usuario_informe_biopsia</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> USUARIO_INFORME_BIOPSIA = createField(DSL.name("usuario_informe_biopsia"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.req_frote</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> REQ_FROTE = createField(DSL.name("req_frote"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.num_frote</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> NUM_FROTE = createField(DSL.name("num_frote"), SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.num_muestra_frote</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> NUM_MUESTRA_FROTE = createField(DSL.name("num_muestra_frote"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.fec_frote</code>.
     */
    public final TableField<LabReporteExamenVwRecord, LocalDate> FEC_FROTE = createField(DSL.name("fec_frote"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.fecha_frote</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> FECHA_FROTE = createField(DSL.name("fecha_frote"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.cod_tincion</code>.
     */
    public final TableField<LabReporteExamenVwRecord, Integer> COD_TINCION = createField(DSL.name("cod_tincion"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.tincion</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> TINCION = createField(DSL.name("tincion"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.usuario_frote</code>.
     */
    public final TableField<LabReporteExamenVwRecord, Integer> USUARIO_FROTE = createField(DSL.name("usuario_frote"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.usuario_realiza_frote</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> USUARIO_REALIZA_FROTE = createField(DSL.name("usuario_realiza_frote"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.estado_frote</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> ESTADO_FROTE = createField(DSL.name("estado_frote"), SQLDataType.VARCHAR(30), this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.fecha_informe_frote</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> FECHA_INFORME_FROTE = createField(DSL.name("fecha_informe_frote"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.diagnostico_informe_frote</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> DIAGNOSTICO_INFORME_FROTE = createField(DSL.name("diagnostico_informe_frote"), SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.lab_reporte_examen_vw.usuario_informe_frote</code>.
     */
    public final TableField<LabReporteExamenVwRecord, String> USUARIO_INFORME_FROTE = createField(DSL.name("usuario_informe_frote"), SQLDataType.CLOB, this, "");

    private LabReporteExamenVw(Name alias, Table<LabReporteExamenVwRecord> aliased) {
        this(alias, aliased, null);
    }

    private LabReporteExamenVw(Name alias, Table<LabReporteExamenVwRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.view("create view \"lab_reporte_examen_vw\" as  SELECT le.cod_examen,\n    le.num_examen,\n    le.fecha_examen,\n    to_char((le.fecha_examen)::timestamp with time zone, 'dd/mm/yyyy'::text) AS fec_examen,\n    concat(lp.nombre, ' ', lp.apellidos) AS nombre_paciente,\n    lp.tipo_identificacion,\n    lp.identificacion,\n    lp.ocupacion,\n    COALESCE(lp.num_ficha, ' '::character varying) AS numero_ficha,\n    ( SELECT string_agg((les.nombre_enfermedad)::text, ' ,'::text) AS string_agg\n           FROM lab_examen_enfermedad_sistemica lees,\n            lab_enfermedad_sistemica les\n          WHERE ((lees.cod_examen = le.cod_examen) AND (lees.cod_enfermedad_sistemica = les.cod_enfermedad_sistemica))) AS enfermedades,\n    ( SELECT string_agg((ld.nombre_diagnostico)::text, ' ,'::text) AS string_agg\n           FROM lab_examen_diagnostico led,\n            lab_diagnostico ld\n          WHERE ((led.cod_examen = le.cod_examen) AND (led.cod_diagnostico = ld.cod_diagnostico))) AS diagnosticos_diferenciales,\n    le.estado_examen,\n    concat(lu.nombres_doctor, ' ', lu.apellidos_doctor) AS doctor_examen,\n    ( SELECT string_agg((ltol.valor_tipo_opcion)::text, ' ,'::text) AS string_agg\n           FROM lab_examen_caracteristica lec,\n            lab_tipo_opcion_lesion ltol\n          WHERE ((lec.cod_examen = le.cod_examen) AND (lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion) AND ((ltol.nombre_tipo_opcion)::text = 'COLOR'::text))) AS color_lesion,\n    ( SELECT string_agg((ltol.valor_tipo_opcion)::text, ' ,'::text) AS string_agg\n           FROM lab_examen_caracteristica lec,\n            lab_tipo_opcion_lesion ltol\n          WHERE ((lec.cod_examen = le.cod_examen) AND (lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion) AND ((ltol.nombre_tipo_opcion)::text = 'NATURALEZA'::text))) AS naturaleza_lesion,\n    ( SELECT string_agg((ltol.valor_tipo_opcion)::text, ' ,'::text) AS string_agg\n           FROM lab_examen_caracteristica lec,\n            lab_tipo_opcion_lesion ltol\n          WHERE ((lec.cod_examen = le.cod_examen) AND (lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion) AND ((ltol.nombre_tipo_opcion)::text = 'SINTOMA'::text))) AS sintoma_lesion,\n    ( SELECT string_agg((ltol.valor_tipo_opcion)::text, ' ,'::text) AS string_agg\n           FROM lab_examen_caracteristica lec,\n            lab_tipo_opcion_lesion ltol\n          WHERE ((lec.cod_examen = le.cod_examen) AND (lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion) AND ((ltol.nombre_tipo_opcion)::text = 'FORMA'::text))) AS forma_lesion,\n    ( SELECT string_agg((ltol.valor_tipo_opcion)::text, ' ,'::text) AS string_agg\n           FROM lab_examen_caracteristica lec,\n            lab_tipo_opcion_lesion ltol\n          WHERE ((lec.cod_examen = le.cod_examen) AND (lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion) AND ((ltol.nombre_tipo_opcion)::text = 'SUPERFICIE'::text))) AS superficie_lesion,\n    ( SELECT string_agg((ltol.valor_tipo_opcion)::text, ' ,'::text) AS string_agg\n           FROM lab_examen_caracteristica lec,\n            lab_tipo_opcion_lesion ltol\n          WHERE ((lec.cod_examen = le.cod_examen) AND (lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion) AND ((ltol.nombre_tipo_opcion)::text = 'CONSISTENCIA'::text))) AS consistencia_lesion,\n    ( SELECT string_agg((ltol.valor_tipo_opcion)::text, ' ,'::text) AS string_agg\n           FROM lab_examen_caracteristica lec,\n            lab_tipo_opcion_lesion ltol\n          WHERE ((lec.cod_examen = le.cod_examen) AND (lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion) AND ((ltol.nombre_tipo_opcion)::text = 'INTRAOSEO'::text))) AS intraoseo_lesion,\n    ( SELECT string_agg((ltol.valor_tipo_opcion)::text, ' ,'::text) AS string_agg\n           FROM lab_examen_caracteristica lec,\n            lab_tipo_opcion_lesion ltol\n          WHERE ((lec.cod_examen = le.cod_examen) AND (lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion) AND ((ltol.nombre_tipo_opcion)::text = 'PIEZA'::text))) AS pieza_lesion,\n    le.tamano_lesion,\n    le.duracion_lesion_dias AS dias_lesion,\n    le.duracion_lesion_meses AS meses_lesion,\n    le.duracion_lesion_anios AS anios_lesion,\n    le.doctor_remision,\n    le.dependencia_doctor_remision,\n        CASE\n            WHEN (le.necesita_biopsia = false) THEN 'No'::text\n            ELSE 'Si'::text\n        END AS req_biopsia,\n    leb.num_biopsia AS numero_biopsia,\n    leb.fecha AS fec_biopsia,\n    to_char((leb.fecha)::timestamp with time zone, 'dd/mm/yyyy'::text) AS fecha_biopsia,\n    leb.muestra_estudio AS muestra_biopsia,\n    leb.procedimiento,\n    ( SELECT string_agg((ltol.valor_tipo_opcion)::text, ' ,'::text) AS string_agg\n           FROM lab_tipo_opcion_lesion ltol\n          WHERE ((leb.procedimiento = ltol.cod_tipo_opcion_lesion) AND ((ltol.nombre_tipo_opcion)::text = 'PROCEDIMIENTO'::text))) AS procedimiento_biopsia,\n    leb.tipo_cirugia,\n    ( SELECT string_agg((ltol.valor_tipo_opcion)::text, ' ,'::text) AS string_agg\n           FROM lab_tipo_opcion_lesion ltol\n          WHERE ((leb.tipo_cirugia = ltol.cod_tipo_opcion_lesion) AND ((ltol.nombre_tipo_opcion)::text = 'TIPOCIRUGIA'::text))) AS tipocirugia_biopsia,\n    leb.instrumento,\n    ( SELECT string_agg((ltol.valor_tipo_opcion)::text, ' ,'::text) AS string_agg\n           FROM lab_tipo_opcion_lesion ltol\n          WHERE ((leb.instrumento = ltol.cod_tipo_opcion_lesion) AND ((ltol.nombre_tipo_opcion)::text = 'INSTRUMENTO'::text))) AS instrumento_biopsia,\n    leb.usuario_biopsia,\n    ( SELECT concat(lu4.nombres_doctor, ' ', lu4.apellidos_doctor) AS concat\n           FROM lab_usuario lu4\n          WHERE (lu4.cod_usuario = leb.usuario_biopsia)) AS usuario_realiza_biopsia,\n    leb.estado_biopsia,\n    ( SELECT to_char((li2.fecha_informe)::timestamp with time zone, 'dd/mm/yyyy'::text) AS fec_informe_biopsia\n           FROM lab_informe li2\n          WHERE (li2.cod_biopsia = leb.cod_biopsia)) AS fecha_informe_biopsia,\n    ( SELECT ld2.nombre_diagnostico\n           FROM lab_informe li,\n            lab_diagnostico ld2\n          WHERE ((leb.cod_biopsia = li.cod_biopsia) AND (li.diagnostico = ld2.cod_diagnostico))) AS diagnostico_biopsia,\n    ( SELECT concat(lu3.nombres_doctor, ' ', lu3.apellidos_doctor) AS concat\n           FROM lab_informe li3,\n            lab_usuario lu3\n          WHERE ((li3.cod_biopsia = leb.cod_biopsia) AND (li3.usuario_informe = lu3.cod_usuario))) AS usuario_informe_biopsia,\n        CASE\n            WHEN (le.necesita_frote = false) THEN 'No'::text\n            ELSE 'Si'::text\n        END AS req_frote,\n    lef.num_frote,\n    lef.muestra_estudio AS num_muestra_frote,\n    lef.fecha AS fec_frote,\n    to_char((lef.fecha)::timestamp with time zone, 'dd/mm/yyyy'::text) AS fecha_frote,\n    lef.cod_tincion,\n    ( SELECT string_agg((lt.nombre_tincion)::text, ' ,'::text) AS string_agg\n           FROM lab_tincion lt\n          WHERE (lef.cod_tincion = lt.cod_tincion)) AS tincion,\n    lef.usuario_frote,\n    ( SELECT concat(lu5.nombres_doctor, ' ', lu5.apellidos_doctor) AS concat\n           FROM lab_usuario lu5\n          WHERE (lu5.cod_usuario = lef.usuario_frote)) AS usuario_realiza_frote,\n    lef.estado_frote,\n    ( SELECT to_char((li4.fecha_informe)::timestamp with time zone, 'dd/mm/yyyy'::text) AS fecha_informe_frote\n           FROM lab_informe li4\n          WHERE (li4.cod_frote = lef.cod_frote)) AS fecha_informe_frote,\n    ( SELECT ld3.nombre_diagnostico\n           FROM lab_informe li5,\n            lab_diagnostico ld3\n          WHERE ((lef.cod_frote = li5.cod_frote) AND (li5.diagnostico = ld3.cod_diagnostico))) AS diagnostico_informe_frote,\n    ( SELECT concat(lu2.nombres_doctor, ' ', lu2.apellidos_doctor) AS concat\n           FROM lab_informe li6,\n            lab_usuario lu2\n          WHERE ((lef.cod_frote = li6.cod_frote) AND (li6.usuario_informe = lu2.cod_usuario))) AS usuario_informe_frote\n   FROM ((((lab_examen le\n     JOIN lab_paciente lp ON ((le.cod_paciente = lp.cod_paciente)))\n     JOIN lab_usuario lu ON ((le.doctor_examen = lu.cod_usuario)))\n     LEFT JOIN lab_examen_biopsia leb ON ((le.cod_examen = leb.cod_examen)))\n     LEFT JOIN lab_examen_frote lef ON ((le.cod_examen = lef.cod_examen)))\n  ORDER BY le.cod_examen;"));
    }

    /**
     * Create an aliased <code>public.lab_reporte_examen_vw</code> table reference
     */
    public LabReporteExamenVw(String alias) {
        this(DSL.name(alias), LAB_REPORTE_EXAMEN_VW);
    }

    /**
     * Create an aliased <code>public.lab_reporte_examen_vw</code> table reference
     */
    public LabReporteExamenVw(Name alias) {
        this(alias, LAB_REPORTE_EXAMEN_VW);
    }

    /**
     * Create a <code>public.lab_reporte_examen_vw</code> table reference
     */
    public LabReporteExamenVw() {
        this(DSL.name("lab_reporte_examen_vw"), null);
    }

    public <O extends Record> LabReporteExamenVw(Table<O> child, ForeignKey<O, LabReporteExamenVwRecord> key) {
        super(child, key, LAB_REPORTE_EXAMEN_VW);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public LabReporteExamenVw as(String alias) {
        return new LabReporteExamenVw(DSL.name(alias), this);
    }

    @Override
    public LabReporteExamenVw as(Name alias) {
        return new LabReporteExamenVw(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LabReporteExamenVw rename(String name) {
        return new LabReporteExamenVw(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LabReporteExamenVw rename(Name name) {
        return new LabReporteExamenVw(name, null);
    }
}
