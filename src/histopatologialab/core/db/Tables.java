/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db;


import histopatologialab.core.db.tables.LabDiagnostico;
import histopatologialab.core.db.tables.LabEnfermedadSistemica;
import histopatologialab.core.db.tables.LabEnfsistemicaListar;
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
import histopatologialab.core.db.tables.records.LabEnfsistemicaListarRecord;

import org.jooq.Configuration;
import org.jooq.Result;


/**
 * Convenience access to all tables in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.lab_diagnostico</code>.
     */
    public static final LabDiagnostico LAB_DIAGNOSTICO = LabDiagnostico.LAB_DIAGNOSTICO;

    /**
     * The table <code>public.lab_enfermedad_sistemica</code>.
     */
    public static final LabEnfermedadSistemica LAB_ENFERMEDAD_SISTEMICA = LabEnfermedadSistemica.LAB_ENFERMEDAD_SISTEMICA;

    /**
     * The table <code>public.lab_enfsistemica_listar</code>.
     */
    public static final LabEnfsistemicaListar LAB_ENFSISTEMICA_LISTAR = LabEnfsistemicaListar.LAB_ENFSISTEMICA_LISTAR;

    /**
     * Call <code>public.lab_enfsistemica_listar</code>.
     */
    public static Result<LabEnfsistemicaListarRecord> LAB_ENFSISTEMICA_LISTAR(
          Configuration configuration
    ) {
        return configuration.dsl().selectFrom(histopatologialab.core.db.tables.LabEnfsistemicaListar.LAB_ENFSISTEMICA_LISTAR.call(
        )).fetch();
    }

    /**
     * Get <code>public.lab_enfsistemica_listar</code> as a table.
     */
    public static LabEnfsistemicaListar LAB_ENFSISTEMICA_LISTAR() {
        return histopatologialab.core.db.tables.LabEnfsistemicaListar.LAB_ENFSISTEMICA_LISTAR.call(
        );
    }

    /**
     * The table <code>public.lab_examen</code>.
     */
    public static final LabExamen LAB_EXAMEN = LabExamen.LAB_EXAMEN;

    /**
     * The table <code>public.lab_examen_biopsia</code>.
     */
    public static final LabExamenBiopsia LAB_EXAMEN_BIOPSIA = LabExamenBiopsia.LAB_EXAMEN_BIOPSIA;

    /**
     * The table <code>public.lab_examen_caracteristica</code>.
     */
    public static final LabExamenCaracteristica LAB_EXAMEN_CARACTERISTICA = LabExamenCaracteristica.LAB_EXAMEN_CARACTERISTICA;

    /**
     * The table <code>public.lab_examen_enfermedad_sistemica</code>.
     */
    public static final LabExamenEnfermedadSistemica LAB_EXAMEN_ENFERMEDAD_SISTEMICA = LabExamenEnfermedadSistemica.LAB_EXAMEN_ENFERMEDAD_SISTEMICA;

    /**
     * The table <code>public.lab_medicamento</code>.
     */
    public static final LabMedicamento LAB_MEDICAMENTO = LabMedicamento.LAB_MEDICAMENTO;

    /**
     * The table <code>public.lab_paciente</code>.
     */
    public static final LabPaciente LAB_PACIENTE = LabPaciente.LAB_PACIENTE;

    /**
     * The table <code>public.lab_presentacion_medicamento</code>.
     */
    public static final LabPresentacionMedicamento LAB_PRESENTACION_MEDICAMENTO = LabPresentacionMedicamento.LAB_PRESENTACION_MEDICAMENTO;

    /**
     * The table <code>public.lab_tincion</code>.
     */
    public static final LabTincion LAB_TINCION = LabTincion.LAB_TINCION;

    /**
     * The table <code>public.lab_tipo_opcion_lesion</code>.
     */
    public static final LabTipoOpcionLesion LAB_TIPO_OPCION_LESION = LabTipoOpcionLesion.LAB_TIPO_OPCION_LESION;

    /**
     * The table <code>public.lab_usuario</code>.
     */
    public static final LabUsuario LAB_USUARIO = LabUsuario.LAB_USUARIO;
}
