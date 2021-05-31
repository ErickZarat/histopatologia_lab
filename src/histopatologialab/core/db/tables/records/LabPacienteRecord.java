/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db.tables.records;


import histopatologialab.core.db.tables.LabPaciente;

import java.time.LocalDate;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record16;
import org.jooq.Row16;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LabPacienteRecord extends UpdatableRecordImpl<LabPacienteRecord> implements Record16<Long, String, String, String, String, String, String, String, LocalDate, String, String, String, String, LocalDate, String, LocalDate> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.lab_paciente.cod_paciente</code>.
     */
    public void setCodPaciente(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.lab_paciente.cod_paciente</code>.
     */
    public Long getCodPaciente() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.lab_paciente.nombre</code>.
     */
    public void setNombre(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.lab_paciente.nombre</code>.
     */
    public String getNombre() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.lab_paciente.apellidos</code>.
     */
    public void setApellidos(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.lab_paciente.apellidos</code>.
     */
    public String getApellidos() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.lab_paciente.email</code>.
     */
    public void setEmail(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.lab_paciente.email</code>.
     */
    public String getEmail() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.lab_paciente.identificacion</code>.
     */
    public void setIdentificacion(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.lab_paciente.identificacion</code>.
     */
    public String getIdentificacion() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.lab_paciente.direccion</code>.
     */
    public void setDireccion(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.lab_paciente.direccion</code>.
     */
    public String getDireccion() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.lab_paciente.telefono</code>.
     */
    public void setTelefono(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.lab_paciente.telefono</code>.
     */
    public String getTelefono() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.lab_paciente.estadocivil</code>.
     */
    public void setEstadocivil(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.lab_paciente.estadocivil</code>.
     */
    public String getEstadocivil() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.lab_paciente.fechanacimiento</code>.
     */
    public void setFechanacimiento(LocalDate value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.lab_paciente.fechanacimiento</code>.
     */
    public LocalDate getFechanacimiento() {
        return (LocalDate) get(8);
    }

    /**
     * Setter for <code>public.lab_paciente.genero</code>.
     */
    public void setGenero(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.lab_paciente.genero</code>.
     */
    public String getGenero() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.lab_paciente.ocupacion</code>.
     */
    public void setOcupacion(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.lab_paciente.ocupacion</code>.
     */
    public String getOcupacion() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.lab_paciente.tipo_identificacion</code>.
     */
    public void setTipoIdentificacion(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.lab_paciente.tipo_identificacion</code>.
     */
    public String getTipoIdentificacion() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.lab_paciente.creadopor</code>.
     */
    public void setCreadopor(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.lab_paciente.creadopor</code>.
     */
    public String getCreadopor() {
        return (String) get(12);
    }

    /**
     * Setter for <code>public.lab_paciente.fechacreacion</code>.
     */
    public void setFechacreacion(LocalDate value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.lab_paciente.fechacreacion</code>.
     */
    public LocalDate getFechacreacion() {
        return (LocalDate) get(13);
    }

    /**
     * Setter for <code>public.lab_paciente.modificadopor</code>.
     */
    public void setModificadopor(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.lab_paciente.modificadopor</code>.
     */
    public String getModificadopor() {
        return (String) get(14);
    }

    /**
     * Setter for <code>public.lab_paciente.fechamodificacion</code>.
     */
    public void setFechamodificacion(LocalDate value) {
        set(15, value);
    }

    /**
     * Getter for <code>public.lab_paciente.fechamodificacion</code>.
     */
    public LocalDate getFechamodificacion() {
        return (LocalDate) get(15);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record16 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row16<Long, String, String, String, String, String, String, String, LocalDate, String, String, String, String, LocalDate, String, LocalDate> fieldsRow() {
        return (Row16) super.fieldsRow();
    }

    @Override
    public Row16<Long, String, String, String, String, String, String, String, LocalDate, String, String, String, String, LocalDate, String, LocalDate> valuesRow() {
        return (Row16) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return LabPaciente.LAB_PACIENTE.COD_PACIENTE;
    }

    @Override
    public Field<String> field2() {
        return LabPaciente.LAB_PACIENTE.NOMBRE;
    }

    @Override
    public Field<String> field3() {
        return LabPaciente.LAB_PACIENTE.APELLIDOS;
    }

    @Override
    public Field<String> field4() {
        return LabPaciente.LAB_PACIENTE.EMAIL;
    }

    @Override
    public Field<String> field5() {
        return LabPaciente.LAB_PACIENTE.IDENTIFICACION;
    }

    @Override
    public Field<String> field6() {
        return LabPaciente.LAB_PACIENTE.DIRECCION;
    }

    @Override
    public Field<String> field7() {
        return LabPaciente.LAB_PACIENTE.TELEFONO;
    }

    @Override
    public Field<String> field8() {
        return LabPaciente.LAB_PACIENTE.ESTADOCIVIL;
    }

    @Override
    public Field<LocalDate> field9() {
        return LabPaciente.LAB_PACIENTE.FECHANACIMIENTO;
    }

    @Override
    public Field<String> field10() {
        return LabPaciente.LAB_PACIENTE.GENERO;
    }

    @Override
    public Field<String> field11() {
        return LabPaciente.LAB_PACIENTE.OCUPACION;
    }

    @Override
    public Field<String> field12() {
        return LabPaciente.LAB_PACIENTE.TIPO_IDENTIFICACION;
    }

    @Override
    public Field<String> field13() {
        return LabPaciente.LAB_PACIENTE.CREADOPOR;
    }

    @Override
    public Field<LocalDate> field14() {
        return LabPaciente.LAB_PACIENTE.FECHACREACION;
    }

    @Override
    public Field<String> field15() {
        return LabPaciente.LAB_PACIENTE.MODIFICADOPOR;
    }

    @Override
    public Field<LocalDate> field16() {
        return LabPaciente.LAB_PACIENTE.FECHAMODIFICACION;
    }

    @Override
    public Long component1() {
        return getCodPaciente();
    }

    @Override
    public String component2() {
        return getNombre();
    }

    @Override
    public String component3() {
        return getApellidos();
    }

    @Override
    public String component4() {
        return getEmail();
    }

    @Override
    public String component5() {
        return getIdentificacion();
    }

    @Override
    public String component6() {
        return getDireccion();
    }

    @Override
    public String component7() {
        return getTelefono();
    }

    @Override
    public String component8() {
        return getEstadocivil();
    }

    @Override
    public LocalDate component9() {
        return getFechanacimiento();
    }

    @Override
    public String component10() {
        return getGenero();
    }

    @Override
    public String component11() {
        return getOcupacion();
    }

    @Override
    public String component12() {
        return getTipoIdentificacion();
    }

    @Override
    public String component13() {
        return getCreadopor();
    }

    @Override
    public LocalDate component14() {
        return getFechacreacion();
    }

    @Override
    public String component15() {
        return getModificadopor();
    }

    @Override
    public LocalDate component16() {
        return getFechamodificacion();
    }

    @Override
    public Long value1() {
        return getCodPaciente();
    }

    @Override
    public String value2() {
        return getNombre();
    }

    @Override
    public String value3() {
        return getApellidos();
    }

    @Override
    public String value4() {
        return getEmail();
    }

    @Override
    public String value5() {
        return getIdentificacion();
    }

    @Override
    public String value6() {
        return getDireccion();
    }

    @Override
    public String value7() {
        return getTelefono();
    }

    @Override
    public String value8() {
        return getEstadocivil();
    }

    @Override
    public LocalDate value9() {
        return getFechanacimiento();
    }

    @Override
    public String value10() {
        return getGenero();
    }

    @Override
    public String value11() {
        return getOcupacion();
    }

    @Override
    public String value12() {
        return getTipoIdentificacion();
    }

    @Override
    public String value13() {
        return getCreadopor();
    }

    @Override
    public LocalDate value14() {
        return getFechacreacion();
    }

    @Override
    public String value15() {
        return getModificadopor();
    }

    @Override
    public LocalDate value16() {
        return getFechamodificacion();
    }

    @Override
    public LabPacienteRecord value1(Long value) {
        setCodPaciente(value);
        return this;
    }

    @Override
    public LabPacienteRecord value2(String value) {
        setNombre(value);
        return this;
    }

    @Override
    public LabPacienteRecord value3(String value) {
        setApellidos(value);
        return this;
    }

    @Override
    public LabPacienteRecord value4(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public LabPacienteRecord value5(String value) {
        setIdentificacion(value);
        return this;
    }

    @Override
    public LabPacienteRecord value6(String value) {
        setDireccion(value);
        return this;
    }

    @Override
    public LabPacienteRecord value7(String value) {
        setTelefono(value);
        return this;
    }

    @Override
    public LabPacienteRecord value8(String value) {
        setEstadocivil(value);
        return this;
    }

    @Override
    public LabPacienteRecord value9(LocalDate value) {
        setFechanacimiento(value);
        return this;
    }

    @Override
    public LabPacienteRecord value10(String value) {
        setGenero(value);
        return this;
    }

    @Override
    public LabPacienteRecord value11(String value) {
        setOcupacion(value);
        return this;
    }

    @Override
    public LabPacienteRecord value12(String value) {
        setTipoIdentificacion(value);
        return this;
    }

    @Override
    public LabPacienteRecord value13(String value) {
        setCreadopor(value);
        return this;
    }

    @Override
    public LabPacienteRecord value14(LocalDate value) {
        setFechacreacion(value);
        return this;
    }

    @Override
    public LabPacienteRecord value15(String value) {
        setModificadopor(value);
        return this;
    }

    @Override
    public LabPacienteRecord value16(LocalDate value) {
        setFechamodificacion(value);
        return this;
    }

    @Override
    public LabPacienteRecord values(Long value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, LocalDate value9, String value10, String value11, String value12, String value13, LocalDate value14, String value15, LocalDate value16) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LabPacienteRecord
     */
    public LabPacienteRecord() {
        super(LabPaciente.LAB_PACIENTE);
    }

    /**
     * Create a detached, initialised LabPacienteRecord
     */
    public LabPacienteRecord(Long codPaciente, String nombre, String apellidos, String email, String identificacion, String direccion, String telefono, String estadocivil, LocalDate fechanacimiento, String genero, String ocupacion, String tipoIdentificacion, String creadopor, LocalDate fechacreacion, String modificadopor, LocalDate fechamodificacion) {
        super(LabPaciente.LAB_PACIENTE);

        setCodPaciente(codPaciente);
        setNombre(nombre);
        setApellidos(apellidos);
        setEmail(email);
        setIdentificacion(identificacion);
        setDireccion(direccion);
        setTelefono(telefono);
        setEstadocivil(estadocivil);
        setFechanacimiento(fechanacimiento);
        setGenero(genero);
        setOcupacion(ocupacion);
        setTipoIdentificacion(tipoIdentificacion);
        setCreadopor(creadopor);
        setFechacreacion(fechacreacion);
        setModificadopor(modificadopor);
        setFechamodificacion(fechamodificacion);
    }
}
