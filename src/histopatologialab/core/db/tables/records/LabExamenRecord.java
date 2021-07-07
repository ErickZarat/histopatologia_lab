/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db.tables.records;


import histopatologialab.core.db.tables.LabExamen;

import java.time.LocalDate;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record20;
import org.jooq.Row20;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LabExamenRecord extends UpdatableRecordImpl<LabExamenRecord> implements Record20<Integer, Long, String, LocalDate, String, String, String, String, Integer, Integer, Integer, String, Long, String, String, String, String, String, Boolean, Boolean> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.lab_examen.cod_examen</code>.
     */
    public void setCodExamen(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.lab_examen.cod_examen</code>.
     */
    public Integer getCodExamen() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.lab_examen.cod_paciente</code>.
     */
    public void setCodPaciente(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.lab_examen.cod_paciente</code>.
     */
    public Long getCodPaciente() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.lab_examen.num_examen</code>.
     */
    public void setNumExamen(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.lab_examen.num_examen</code>.
     */
    public String getNumExamen() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.lab_examen.fecha_examen</code>.
     */
    public void setFechaExamen(LocalDate value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.lab_examen.fecha_examen</code>.
     */
    public LocalDate getFechaExamen() {
        return (LocalDate) get(3);
    }

    /**
     * Setter for <code>public.lab_examen.estado_examen</code>.
     */
    public void setEstadoExamen(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.lab_examen.estado_examen</code>.
     */
    public String getEstadoExamen() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.lab_examen.historia_examen_lesion</code>.
     */
    public void setHistoriaExamenLesion(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.lab_examen.historia_examen_lesion</code>.
     */
    public String getHistoriaExamenLesion() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.lab_examen.tamano_lesion</code>.
     */
    public void setTamanoLesion(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.lab_examen.tamano_lesion</code>.
     */
    public String getTamanoLesion() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.lab_examen.dimensional_lesion</code>.
     */
    public void setDimensionalLesion(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.lab_examen.dimensional_lesion</code>.
     */
    public String getDimensionalLesion() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.lab_examen.duracion_lesion_dias</code>.
     */
    public void setDuracionLesionDias(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.lab_examen.duracion_lesion_dias</code>.
     */
    public Integer getDuracionLesionDias() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>public.lab_examen.duracion_lesion_meses</code>.
     */
    public void setDuracionLesionMeses(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.lab_examen.duracion_lesion_meses</code>.
     */
    public Integer getDuracionLesionMeses() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>public.lab_examen.duracion_lesion_anios</code>.
     */
    public void setDuracionLesionAnios(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.lab_examen.duracion_lesion_anios</code>.
     */
    public Integer getDuracionLesionAnios() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>public.lab_examen.datos_importantes_lesion</code>.
     */
    public void setDatosImportantesLesion(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.lab_examen.datos_importantes_lesion</code>.
     */
    public String getDatosImportantesLesion() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.lab_examen.doctor_examen</code>.
     */
    public void setDoctorExamen(Long value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.lab_examen.doctor_examen</code>.
     */
    public Long getDoctorExamen() {
        return (Long) get(12);
    }

    /**
     * Setter for <code>public.lab_examen.doctor_remision</code>.
     */
    public void setDoctorRemision(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.lab_examen.doctor_remision</code>.
     */
    public String getDoctorRemision() {
        return (String) get(13);
    }

    /**
     * Setter for <code>public.lab_examen.direccion_doctor_remision</code>.
     */
    public void setDireccionDoctorRemision(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.lab_examen.direccion_doctor_remision</code>.
     */
    public String getDireccionDoctorRemision() {
        return (String) get(14);
    }

    /**
     * Setter for <code>public.lab_examen.telefono_doctor_remision</code>.
     */
    public void setTelefonoDoctorRemision(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>public.lab_examen.telefono_doctor_remision</code>.
     */
    public String getTelefonoDoctorRemision() {
        return (String) get(15);
    }

    /**
     * Setter for <code>public.lab_examen.email_doctor_remision</code>.
     */
    public void setEmailDoctorRemision(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>public.lab_examen.email_doctor_remision</code>.
     */
    public String getEmailDoctorRemision() {
        return (String) get(16);
    }

    /**
     * Setter for <code>public.lab_examen.dependencia_doctor_remision</code>.
     */
    public void setDependenciaDoctorRemision(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>public.lab_examen.dependencia_doctor_remision</code>.
     */
    public String getDependenciaDoctorRemision() {
        return (String) get(17);
    }

    /**
     * Setter for <code>public.lab_examen.necesita_biopsia</code>.
     */
    public void setNecesitaBiopsia(Boolean value) {
        set(18, value);
    }

    /**
     * Getter for <code>public.lab_examen.necesita_biopsia</code>.
     */
    public Boolean getNecesitaBiopsia() {
        return (Boolean) get(18);
    }

    /**
     * Setter for <code>public.lab_examen.necesita_frote</code>.
     */
    public void setNecesitaFrote(Boolean value) {
        set(19, value);
    }

    /**
     * Getter for <code>public.lab_examen.necesita_frote</code>.
     */
    public Boolean getNecesitaFrote() {
        return (Boolean) get(19);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record20 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row20<Integer, Long, String, LocalDate, String, String, String, String, Integer, Integer, Integer, String, Long, String, String, String, String, String, Boolean, Boolean> fieldsRow() {
        return (Row20) super.fieldsRow();
    }

    @Override
    public Row20<Integer, Long, String, LocalDate, String, String, String, String, Integer, Integer, Integer, String, Long, String, String, String, String, String, Boolean, Boolean> valuesRow() {
        return (Row20) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return LabExamen.LAB_EXAMEN.COD_EXAMEN;
    }

    @Override
    public Field<Long> field2() {
        return LabExamen.LAB_EXAMEN.COD_PACIENTE;
    }

    @Override
    public Field<String> field3() {
        return LabExamen.LAB_EXAMEN.NUM_EXAMEN;
    }

    @Override
    public Field<LocalDate> field4() {
        return LabExamen.LAB_EXAMEN.FECHA_EXAMEN;
    }

    @Override
    public Field<String> field5() {
        return LabExamen.LAB_EXAMEN.ESTADO_EXAMEN;
    }

    @Override
    public Field<String> field6() {
        return LabExamen.LAB_EXAMEN.HISTORIA_EXAMEN_LESION;
    }

    @Override
    public Field<String> field7() {
        return LabExamen.LAB_EXAMEN.TAMANO_LESION;
    }

    @Override
    public Field<String> field8() {
        return LabExamen.LAB_EXAMEN.DIMENSIONAL_LESION;
    }

    @Override
    public Field<Integer> field9() {
        return LabExamen.LAB_EXAMEN.DURACION_LESION_DIAS;
    }

    @Override
    public Field<Integer> field10() {
        return LabExamen.LAB_EXAMEN.DURACION_LESION_MESES;
    }

    @Override
    public Field<Integer> field11() {
        return LabExamen.LAB_EXAMEN.DURACION_LESION_ANIOS;
    }

    @Override
    public Field<String> field12() {
        return LabExamen.LAB_EXAMEN.DATOS_IMPORTANTES_LESION;
    }

    @Override
    public Field<Long> field13() {
        return LabExamen.LAB_EXAMEN.DOCTOR_EXAMEN;
    }

    @Override
    public Field<String> field14() {
        return LabExamen.LAB_EXAMEN.DOCTOR_REMISION;
    }

    @Override
    public Field<String> field15() {
        return LabExamen.LAB_EXAMEN.DIRECCION_DOCTOR_REMISION;
    }

    @Override
    public Field<String> field16() {
        return LabExamen.LAB_EXAMEN.TELEFONO_DOCTOR_REMISION;
    }

    @Override
    public Field<String> field17() {
        return LabExamen.LAB_EXAMEN.EMAIL_DOCTOR_REMISION;
    }

    @Override
    public Field<String> field18() {
        return LabExamen.LAB_EXAMEN.DEPENDENCIA_DOCTOR_REMISION;
    }

    @Override
    public Field<Boolean> field19() {
        return LabExamen.LAB_EXAMEN.NECESITA_BIOPSIA;
    }

    @Override
    public Field<Boolean> field20() {
        return LabExamen.LAB_EXAMEN.NECESITA_FROTE;
    }

    @Override
    public Integer component1() {
        return getCodExamen();
    }

    @Override
    public Long component2() {
        return getCodPaciente();
    }

    @Override
    public String component3() {
        return getNumExamen();
    }

    @Override
    public LocalDate component4() {
        return getFechaExamen();
    }

    @Override
    public String component5() {
        return getEstadoExamen();
    }

    @Override
    public String component6() {
        return getHistoriaExamenLesion();
    }

    @Override
    public String component7() {
        return getTamanoLesion();
    }

    @Override
    public String component8() {
        return getDimensionalLesion();
    }

    @Override
    public Integer component9() {
        return getDuracionLesionDias();
    }

    @Override
    public Integer component10() {
        return getDuracionLesionMeses();
    }

    @Override
    public Integer component11() {
        return getDuracionLesionAnios();
    }

    @Override
    public String component12() {
        return getDatosImportantesLesion();
    }

    @Override
    public Long component13() {
        return getDoctorExamen();
    }

    @Override
    public String component14() {
        return getDoctorRemision();
    }

    @Override
    public String component15() {
        return getDireccionDoctorRemision();
    }

    @Override
    public String component16() {
        return getTelefonoDoctorRemision();
    }

    @Override
    public String component17() {
        return getEmailDoctorRemision();
    }

    @Override
    public String component18() {
        return getDependenciaDoctorRemision();
    }

    @Override
    public Boolean component19() {
        return getNecesitaBiopsia();
    }

    @Override
    public Boolean component20() {
        return getNecesitaFrote();
    }

    @Override
    public Integer value1() {
        return getCodExamen();
    }

    @Override
    public Long value2() {
        return getCodPaciente();
    }

    @Override
    public String value3() {
        return getNumExamen();
    }

    @Override
    public LocalDate value4() {
        return getFechaExamen();
    }

    @Override
    public String value5() {
        return getEstadoExamen();
    }

    @Override
    public String value6() {
        return getHistoriaExamenLesion();
    }

    @Override
    public String value7() {
        return getTamanoLesion();
    }

    @Override
    public String value8() {
        return getDimensionalLesion();
    }

    @Override
    public Integer value9() {
        return getDuracionLesionDias();
    }

    @Override
    public Integer value10() {
        return getDuracionLesionMeses();
    }

    @Override
    public Integer value11() {
        return getDuracionLesionAnios();
    }

    @Override
    public String value12() {
        return getDatosImportantesLesion();
    }

    @Override
    public Long value13() {
        return getDoctorExamen();
    }

    @Override
    public String value14() {
        return getDoctorRemision();
    }

    @Override
    public String value15() {
        return getDireccionDoctorRemision();
    }

    @Override
    public String value16() {
        return getTelefonoDoctorRemision();
    }

    @Override
    public String value17() {
        return getEmailDoctorRemision();
    }

    @Override
    public String value18() {
        return getDependenciaDoctorRemision();
    }

    @Override
    public Boolean value19() {
        return getNecesitaBiopsia();
    }

    @Override
    public Boolean value20() {
        return getNecesitaFrote();
    }

    @Override
    public LabExamenRecord value1(Integer value) {
        setCodExamen(value);
        return this;
    }

    @Override
    public LabExamenRecord value2(Long value) {
        setCodPaciente(value);
        return this;
    }

    @Override
    public LabExamenRecord value3(String value) {
        setNumExamen(value);
        return this;
    }

    @Override
    public LabExamenRecord value4(LocalDate value) {
        setFechaExamen(value);
        return this;
    }

    @Override
    public LabExamenRecord value5(String value) {
        setEstadoExamen(value);
        return this;
    }

    @Override
    public LabExamenRecord value6(String value) {
        setHistoriaExamenLesion(value);
        return this;
    }

    @Override
    public LabExamenRecord value7(String value) {
        setTamanoLesion(value);
        return this;
    }

    @Override
    public LabExamenRecord value8(String value) {
        setDimensionalLesion(value);
        return this;
    }

    @Override
    public LabExamenRecord value9(Integer value) {
        setDuracionLesionDias(value);
        return this;
    }

    @Override
    public LabExamenRecord value10(Integer value) {
        setDuracionLesionMeses(value);
        return this;
    }

    @Override
    public LabExamenRecord value11(Integer value) {
        setDuracionLesionAnios(value);
        return this;
    }

    @Override
    public LabExamenRecord value12(String value) {
        setDatosImportantesLesion(value);
        return this;
    }

    @Override
    public LabExamenRecord value13(Long value) {
        setDoctorExamen(value);
        return this;
    }

    @Override
    public LabExamenRecord value14(String value) {
        setDoctorRemision(value);
        return this;
    }

    @Override
    public LabExamenRecord value15(String value) {
        setDireccionDoctorRemision(value);
        return this;
    }

    @Override
    public LabExamenRecord value16(String value) {
        setTelefonoDoctorRemision(value);
        return this;
    }

    @Override
    public LabExamenRecord value17(String value) {
        setEmailDoctorRemision(value);
        return this;
    }

    @Override
    public LabExamenRecord value18(String value) {
        setDependenciaDoctorRemision(value);
        return this;
    }

    @Override
    public LabExamenRecord value19(Boolean value) {
        setNecesitaBiopsia(value);
        return this;
    }

    @Override
    public LabExamenRecord value20(Boolean value) {
        setNecesitaFrote(value);
        return this;
    }

    @Override
    public LabExamenRecord values(Integer value1, Long value2, String value3, LocalDate value4, String value5, String value6, String value7, String value8, Integer value9, Integer value10, Integer value11, String value12, Long value13, String value14, String value15, String value16, String value17, String value18, Boolean value19, Boolean value20) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        value19(value19);
        value20(value20);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LabExamenRecord
     */
    public LabExamenRecord() {
        super(LabExamen.LAB_EXAMEN);
    }

    /**
     * Create a detached, initialised LabExamenRecord
     */
    public LabExamenRecord(Integer codExamen, Long codPaciente, String numExamen, LocalDate fechaExamen, String estadoExamen, String historiaExamenLesion, String tamanoLesion, String dimensionalLesion, Integer duracionLesionDias, Integer duracionLesionMeses, Integer duracionLesionAnios, String datosImportantesLesion, Long doctorExamen, String doctorRemision, String direccionDoctorRemision, String telefonoDoctorRemision, String emailDoctorRemision, String dependenciaDoctorRemision, Boolean necesitaBiopsia, Boolean necesitaFrote) {
        super(LabExamen.LAB_EXAMEN);

        setCodExamen(codExamen);
        setCodPaciente(codPaciente);
        setNumExamen(numExamen);
        setFechaExamen(fechaExamen);
        setEstadoExamen(estadoExamen);
        setHistoriaExamenLesion(historiaExamenLesion);
        setTamanoLesion(tamanoLesion);
        setDimensionalLesion(dimensionalLesion);
        setDuracionLesionDias(duracionLesionDias);
        setDuracionLesionMeses(duracionLesionMeses);
        setDuracionLesionAnios(duracionLesionAnios);
        setDatosImportantesLesion(datosImportantesLesion);
        setDoctorExamen(doctorExamen);
        setDoctorRemision(doctorRemision);
        setDireccionDoctorRemision(direccionDoctorRemision);
        setTelefonoDoctorRemision(telefonoDoctorRemision);
        setEmailDoctorRemision(emailDoctorRemision);
        setDependenciaDoctorRemision(dependenciaDoctorRemision);
        setNecesitaBiopsia(necesitaBiopsia);
        setNecesitaFrote(necesitaFrote);
    }
}
