/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db;


import org.jooq.Sequence;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * Convenience access to all sequences in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.lab_diagnostico_seq</code>
     */
    public static final Sequence<Long> LAB_DIAGNOSTICO_SEQ = Internal.createSequence("lab_diagnostico_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.lab_enfermedad_sistemica_seq</code>
     */
    public static final Sequence<Long> LAB_ENFERMEDAD_SISTEMICA_SEQ = Internal.createSequence("lab_enfermedad_sistemica_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.lab_examen_biopsia_cod_biopsia_seq</code>
     */
    public static final Sequence<Long> LAB_EXAMEN_BIOPSIA_COD_BIOPSIA_SEQ = Internal.createSequence("lab_examen_biopsia_cod_biopsia_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, 2147483647, false, null);

    /**
     * The sequence <code>public.lab_examen_biopsia_cod_biopsia_seq1</code>
     */
    public static final Sequence<Long> LAB_EXAMEN_BIOPSIA_COD_BIOPSIA_SEQ1 = Internal.createSequence("lab_examen_biopsia_cod_biopsia_seq1", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, 2147483647, false, null);

    /**
     * The sequence <code>public.lab_examen_biopsia_cod_biopsia_seq2</code>
     */
    public static final Sequence<Integer> LAB_EXAMEN_BIOPSIA_COD_BIOPSIA_SEQ2 = Internal.createSequence("lab_examen_biopsia_cod_biopsia_seq2", Public.PUBLIC, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.lab_examen_caracteristica_cod_examen_seq</code>
     */
    public static final Sequence<Long> LAB_EXAMEN_CARACTERISTICA_COD_EXAMEN_SEQ = Internal.createSequence("lab_examen_caracteristica_cod_examen_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, 2147483647, false, null);

    /**
     * The sequence <code>public.lab_examen_caracteristica_cod_examen_seq1</code>
     */
    public static final Sequence<Long> LAB_EXAMEN_CARACTERISTICA_COD_EXAMEN_SEQ1 = Internal.createSequence("lab_examen_caracteristica_cod_examen_seq1", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, 2147483647, false, null);

    /**
     * The sequence <code>public.lab_examen_caracteristica_cod_examen_seq2</code>
     */
    public static final Sequence<Integer> LAB_EXAMEN_CARACTERISTICA_COD_EXAMEN_SEQ2 = Internal.createSequence("lab_examen_caracteristica_cod_examen_seq2", Public.PUBLIC, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.lab_examen_cod_examen_seq</code>
     */
    public static final Sequence<Long> LAB_EXAMEN_COD_EXAMEN_SEQ = Internal.createSequence("lab_examen_cod_examen_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, 2147483647, false, null);

    /**
     * The sequence <code>public.lab_examen_cod_examen_seq1</code>
     */
    public static final Sequence<Long> LAB_EXAMEN_COD_EXAMEN_SEQ1 = Internal.createSequence("lab_examen_cod_examen_seq1", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, 2147483647, false, null);

    /**
     * The sequence <code>public.lab_examen_cod_examen_seq2</code>
     */
    public static final Sequence<Integer> LAB_EXAMEN_COD_EXAMEN_SEQ2 = Internal.createSequence("lab_examen_cod_examen_seq2", Public.PUBLIC, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.lab_examen_frote_cod_frote_seq</code>
     */
    public static final Sequence<Integer> LAB_EXAMEN_FROTE_COD_FROTE_SEQ = Internal.createSequence("lab_examen_frote_cod_frote_seq", Public.PUBLIC, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.lab_examen_receta_cod_receta_seq</code>
     */
    public static final Sequence<Integer> LAB_EXAMEN_RECETA_COD_RECETA_SEQ = Internal.createSequence("lab_examen_receta_cod_receta_seq", Public.PUBLIC, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.lab_examen_seguimiento_cod_seguimiento_seq</code>
     */
    public static final Sequence<Integer> LAB_EXAMEN_SEGUIMIENTO_COD_SEGUIMIENTO_SEQ = Internal.createSequence("lab_examen_seguimiento_cod_seguimiento_seq", Public.PUBLIC, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.lab_informe_cod_informe_seq</code>
     */
    public static final Sequence<Integer> LAB_INFORME_COD_INFORME_SEQ = Internal.createSequence("lab_informe_cod_informe_seq", Public.PUBLIC, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.lab_medicamento_seq</code>
     */
    public static final Sequence<Long> LAB_MEDICAMENTO_SEQ = Internal.createSequence("lab_medicamento_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.lab_paciente_seq</code>
     */
    public static final Sequence<Long> LAB_PACIENTE_SEQ = Internal.createSequence("lab_paciente_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.lab_presentacion_medicamento_cod_presentacion_seq</code>
     */
    public static final Sequence<Integer> LAB_PRESENTACION_MEDICAMENTO_COD_PRESENTACION_SEQ = Internal.createSequence("lab_presentacion_medicamento_cod_presentacion_seq", Public.PUBLIC, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.lab_tincion_seq</code>
     */
    public static final Sequence<Long> LAB_TINCION_SEQ = Internal.createSequence("lab_tincion_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.lab_tipo_opcion_lesion_seq</code>
     */
    public static final Sequence<Long> LAB_TIPO_OPCION_LESION_SEQ = Internal.createSequence("lab_tipo_opcion_lesion_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.lab_usuario_seq</code>
     */
    public static final Sequence<Long> LAB_USUARIO_SEQ = Internal.createSequence("lab_usuario_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);
}
