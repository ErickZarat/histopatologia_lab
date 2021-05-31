/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db;


import histopatologialab.core.db.tables.LabDiagnostico;
import histopatologialab.core.db.tables.LabEnfermedadSistemica;
import histopatologialab.core.db.tables.LabExamen;
import histopatologialab.core.db.tables.LabExamenBiopsia;
import histopatologialab.core.db.tables.LabExamenCaracteristica;
import histopatologialab.core.db.tables.LabExamenEnfermedadSistemica;
import histopatologialab.core.db.tables.LabMedicamento;
import histopatologialab.core.db.tables.LabPaciente;
import histopatologialab.core.db.tables.LabPresentacionMedicamento;
import histopatologialab.core.db.tables.LabTincion;
import histopatologialab.core.db.tables.LabTipoOpcionLesion;
import histopatologialab.core.db.tables.LabUsuario;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.lab_diagnostico</code>.
     */
    public final LabDiagnostico LAB_DIAGNOSTICO = LabDiagnostico.LAB_DIAGNOSTICO;

    /**
     * The table <code>public.lab_enfermedad_sistemica</code>.
     */
    public final LabEnfermedadSistemica LAB_ENFERMEDAD_SISTEMICA = LabEnfermedadSistemica.LAB_ENFERMEDAD_SISTEMICA;

    /**
     * The table <code>public.lab_examen</code>.
     */
    public final LabExamen LAB_EXAMEN = LabExamen.LAB_EXAMEN;

    /**
     * The table <code>public.lab_examen_biopsia</code>.
     */
    public final LabExamenBiopsia LAB_EXAMEN_BIOPSIA = LabExamenBiopsia.LAB_EXAMEN_BIOPSIA;

    /**
     * The table <code>public.lab_examen_caracteristica</code>.
     */
    public final LabExamenCaracteristica LAB_EXAMEN_CARACTERISTICA = LabExamenCaracteristica.LAB_EXAMEN_CARACTERISTICA;

    /**
     * The table <code>public.lab_examen_enfermedad_sistemica</code>.
     */
    public final LabExamenEnfermedadSistemica LAB_EXAMEN_ENFERMEDAD_SISTEMICA = LabExamenEnfermedadSistemica.LAB_EXAMEN_ENFERMEDAD_SISTEMICA;

    /**
     * The table <code>public.lab_medicamento</code>.
     */
    public final LabMedicamento LAB_MEDICAMENTO = LabMedicamento.LAB_MEDICAMENTO;

    /**
     * The table <code>public.lab_paciente</code>.
     */
    public final LabPaciente LAB_PACIENTE = LabPaciente.LAB_PACIENTE;

    /**
     * The table <code>public.lab_presentacion_medicamento</code>.
     */
    public final LabPresentacionMedicamento LAB_PRESENTACION_MEDICAMENTO = LabPresentacionMedicamento.LAB_PRESENTACION_MEDICAMENTO;

    /**
     * The table <code>public.lab_tincion</code>.
     */
    public final LabTincion LAB_TINCION = LabTincion.LAB_TINCION;

    /**
     * The table <code>public.lab_tipo_opcion_lesion</code>.
     */
    public final LabTipoOpcionLesion LAB_TIPO_OPCION_LESION = LabTipoOpcionLesion.LAB_TIPO_OPCION_LESION;

    /**
     * The table <code>public.lab_usuario</code>.
     */
    public final LabUsuario LAB_USUARIO = LabUsuario.LAB_USUARIO;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        return Arrays.<Sequence<?>>asList(
            Sequences.LAB_DIAGNOSTICO_SEQ,
            Sequences.LAB_ENFERMEDAD_SISTEMICA_SEQ,
            Sequences.LAB_EXAMEN_BIOPSIA_COD_BIOPSIA_SEQ,
            Sequences.LAB_EXAMEN_BIOPSIA_COD_BIOPSIA_SEQ1,
            Sequences.LAB_EXAMEN_CARACTERISTICA_COD_EXAMEN_SEQ,
            Sequences.LAB_EXAMEN_CARACTERISTICA_COD_EXAMEN_SEQ1,
            Sequences.LAB_EXAMEN_COD_EXAMEN_SEQ,
            Sequences.LAB_EXAMEN_COD_EXAMEN_SEQ1,
            Sequences.LAB_MEDICAMENTO_SEQ,
            Sequences.LAB_PACIENTE_SEQ,
            Sequences.LAB_TINCION_SEQ,
            Sequences.LAB_TIPO_OPCION_LESION_SEQ,
            Sequences.LAB_USUARIO_SEQ);
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            LabDiagnostico.LAB_DIAGNOSTICO,
            LabEnfermedadSistemica.LAB_ENFERMEDAD_SISTEMICA,
            LabExamen.LAB_EXAMEN,
            LabExamenBiopsia.LAB_EXAMEN_BIOPSIA,
            LabExamenCaracteristica.LAB_EXAMEN_CARACTERISTICA,
            LabExamenEnfermedadSistemica.LAB_EXAMEN_ENFERMEDAD_SISTEMICA,
            LabMedicamento.LAB_MEDICAMENTO,
            LabPaciente.LAB_PACIENTE,
            LabPresentacionMedicamento.LAB_PRESENTACION_MEDICAMENTO,
            LabTincion.LAB_TINCION,
            LabTipoOpcionLesion.LAB_TIPO_OPCION_LESION,
            LabUsuario.LAB_USUARIO);
    }
}
