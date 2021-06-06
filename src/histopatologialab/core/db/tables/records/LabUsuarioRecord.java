/*
 * This file is generated by jOOQ.
 */
package histopatologialab.core.db.tables.records;


import histopatologialab.core.db.tables.LabUsuario;

import java.time.LocalDate;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record15;
import org.jooq.Row15;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LabUsuarioRecord extends UpdatableRecordImpl<LabUsuarioRecord> implements Record15<Long, String, String, String, String, String, String, String, String, String, String, LocalDate, String, LocalDate, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.lab_usuario.cod_usuario</code>.
     */
    public void setCodUsuario(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.lab_usuario.cod_usuario</code>.
     */
    public Long getCodUsuario() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.lab_usuario.login_usuario</code>.
     */
    public void setLoginUsuario(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.lab_usuario.login_usuario</code>.
     */
    public String getLoginUsuario() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.lab_usuario.nombres_doctor</code>.
     */
    public void setNombresDoctor(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.lab_usuario.nombres_doctor</code>.
     */
    public String getNombresDoctor() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.lab_usuario.apellidos_doctor</code>.
     */
    public void setApellidosDoctor(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.lab_usuario.apellidos_doctor</code>.
     */
    public String getApellidosDoctor() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.lab_usuario.num_colegiado</code>.
     */
    public void setNumColegiado(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.lab_usuario.num_colegiado</code>.
     */
    public String getNumColegiado() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.lab_usuario.password</code>.
     */
    public void setPassword(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.lab_usuario.password</code>.
     */
    public String getPassword() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.lab_usuario.estado</code>.
     */
    public void setEstado(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.lab_usuario.estado</code>.
     */
    public String getEstado() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.lab_usuario.emailusuario</code>.
     */
    public void setEmailusuario(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.lab_usuario.emailusuario</code>.
     */
    public String getEmailusuario() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.lab_usuario.tipo_usuario</code>.
     */
    public void setTipoUsuario(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.lab_usuario.tipo_usuario</code>.
     */
    public String getTipoUsuario() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.lab_usuario.rol_usuario</code>.
     */
    public void setRolUsuario(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.lab_usuario.rol_usuario</code>.
     */
    public String getRolUsuario() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.lab_usuario.creadopor</code>.
     */
    public void setCreadopor(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.lab_usuario.creadopor</code>.
     */
    public String getCreadopor() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.lab_usuario.fechacreacion</code>.
     */
    public void setFechacreacion(LocalDate value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.lab_usuario.fechacreacion</code>.
     */
    public LocalDate getFechacreacion() {
        return (LocalDate) get(11);
    }

    /**
     * Setter for <code>public.lab_usuario.modificadopor</code>.
     */
    public void setModificadopor(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.lab_usuario.modificadopor</code>.
     */
    public String getModificadopor() {
        return (String) get(12);
    }

    /**
     * Setter for <code>public.lab_usuario.fechamodificacion</code>.
     */
    public void setFechamodificacion(LocalDate value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.lab_usuario.fechamodificacion</code>.
     */
    public LocalDate getFechamodificacion() {
        return (LocalDate) get(13);
    }

    /**
     * Setter for <code>public.lab_usuario.llave</code>.
     */
    public void setLlave(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.lab_usuario.llave</code>.
     */
    public String getLlave() {
        return (String) get(14);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record15 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row15<Long, String, String, String, String, String, String, String, String, String, String, LocalDate, String, LocalDate, String> fieldsRow() {
        return (Row15) super.fieldsRow();
    }

    @Override
    public Row15<Long, String, String, String, String, String, String, String, String, String, String, LocalDate, String, LocalDate, String> valuesRow() {
        return (Row15) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return LabUsuario.LAB_USUARIO.COD_USUARIO;
    }

    @Override
    public Field<String> field2() {
        return LabUsuario.LAB_USUARIO.LOGIN_USUARIO;
    }

    @Override
    public Field<String> field3() {
        return LabUsuario.LAB_USUARIO.NOMBRES_DOCTOR;
    }

    @Override
    public Field<String> field4() {
        return LabUsuario.LAB_USUARIO.APELLIDOS_DOCTOR;
    }

    @Override
    public Field<String> field5() {
        return LabUsuario.LAB_USUARIO.NUM_COLEGIADO;
    }

    @Override
    public Field<String> field6() {
        return LabUsuario.LAB_USUARIO.PASSWORD;
    }

    @Override
    public Field<String> field7() {
        return LabUsuario.LAB_USUARIO.ESTADO;
    }

    @Override
    public Field<String> field8() {
        return LabUsuario.LAB_USUARIO.EMAILUSUARIO;
    }

    @Override
    public Field<String> field9() {
        return LabUsuario.LAB_USUARIO.TIPO_USUARIO;
    }

    @Override
    public Field<String> field10() {
        return LabUsuario.LAB_USUARIO.ROL_USUARIO;
    }

    @Override
    public Field<String> field11() {
        return LabUsuario.LAB_USUARIO.CREADOPOR;
    }

    @Override
    public Field<LocalDate> field12() {
        return LabUsuario.LAB_USUARIO.FECHACREACION;
    }

    @Override
    public Field<String> field13() {
        return LabUsuario.LAB_USUARIO.MODIFICADOPOR;
    }

    @Override
    public Field<LocalDate> field14() {
        return LabUsuario.LAB_USUARIO.FECHAMODIFICACION;
    }

    @Override
    public Field<String> field15() {
        return LabUsuario.LAB_USUARIO.LLAVE;
    }

    @Override
    public Long component1() {
        return getCodUsuario();
    }

    @Override
    public String component2() {
        return getLoginUsuario();
    }

    @Override
    public String component3() {
        return getNombresDoctor();
    }

    @Override
    public String component4() {
        return getApellidosDoctor();
    }

    @Override
    public String component5() {
        return getNumColegiado();
    }

    @Override
    public String component6() {
        return getPassword();
    }

    @Override
    public String component7() {
        return getEstado();
    }

    @Override
    public String component8() {
        return getEmailusuario();
    }

    @Override
    public String component9() {
        return getTipoUsuario();
    }

    @Override
    public String component10() {
        return getRolUsuario();
    }

    @Override
    public String component11() {
        return getCreadopor();
    }

    @Override
    public LocalDate component12() {
        return getFechacreacion();
    }

    @Override
    public String component13() {
        return getModificadopor();
    }

    @Override
    public LocalDate component14() {
        return getFechamodificacion();
    }

    @Override
    public String component15() {
        return getLlave();
    }

    @Override
    public Long value1() {
        return getCodUsuario();
    }

    @Override
    public String value2() {
        return getLoginUsuario();
    }

    @Override
    public String value3() {
        return getNombresDoctor();
    }

    @Override
    public String value4() {
        return getApellidosDoctor();
    }

    @Override
    public String value5() {
        return getNumColegiado();
    }

    @Override
    public String value6() {
        return getPassword();
    }

    @Override
    public String value7() {
        return getEstado();
    }

    @Override
    public String value8() {
        return getEmailusuario();
    }

    @Override
    public String value9() {
        return getTipoUsuario();
    }

    @Override
    public String value10() {
        return getRolUsuario();
    }

    @Override
    public String value11() {
        return getCreadopor();
    }

    @Override
    public LocalDate value12() {
        return getFechacreacion();
    }

    @Override
    public String value13() {
        return getModificadopor();
    }

    @Override
    public LocalDate value14() {
        return getFechamodificacion();
    }

    @Override
    public String value15() {
        return getLlave();
    }

    @Override
    public LabUsuarioRecord value1(Long value) {
        setCodUsuario(value);
        return this;
    }

    @Override
    public LabUsuarioRecord value2(String value) {
        setLoginUsuario(value);
        return this;
    }

    @Override
    public LabUsuarioRecord value3(String value) {
        setNombresDoctor(value);
        return this;
    }

    @Override
    public LabUsuarioRecord value4(String value) {
        setApellidosDoctor(value);
        return this;
    }

    @Override
    public LabUsuarioRecord value5(String value) {
        setNumColegiado(value);
        return this;
    }

    @Override
    public LabUsuarioRecord value6(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public LabUsuarioRecord value7(String value) {
        setEstado(value);
        return this;
    }

    @Override
    public LabUsuarioRecord value8(String value) {
        setEmailusuario(value);
        return this;
    }

    @Override
    public LabUsuarioRecord value9(String value) {
        setTipoUsuario(value);
        return this;
    }

    @Override
    public LabUsuarioRecord value10(String value) {
        setRolUsuario(value);
        return this;
    }

    @Override
    public LabUsuarioRecord value11(String value) {
        setCreadopor(value);
        return this;
    }

    @Override
    public LabUsuarioRecord value12(LocalDate value) {
        setFechacreacion(value);
        return this;
    }

    @Override
    public LabUsuarioRecord value13(String value) {
        setModificadopor(value);
        return this;
    }

    @Override
    public LabUsuarioRecord value14(LocalDate value) {
        setFechamodificacion(value);
        return this;
    }

    @Override
    public LabUsuarioRecord value15(String value) {
        setLlave(value);
        return this;
    }

    @Override
    public LabUsuarioRecord values(Long value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10, String value11, LocalDate value12, String value13, LocalDate value14, String value15) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LabUsuarioRecord
     */
    public LabUsuarioRecord() {
        super(LabUsuario.LAB_USUARIO);
    }

    /**
     * Create a detached, initialised LabUsuarioRecord
     */
    public LabUsuarioRecord(Long codUsuario, String loginUsuario, String nombresDoctor, String apellidosDoctor, String numColegiado, String password, String estado, String emailusuario, String tipoUsuario, String rolUsuario, String creadopor, LocalDate fechacreacion, String modificadopor, LocalDate fechamodificacion, String llave) {
        super(LabUsuario.LAB_USUARIO);

        setCodUsuario(codUsuario);
        setLoginUsuario(loginUsuario);
        setNombresDoctor(nombresDoctor);
        setApellidosDoctor(apellidosDoctor);
        setNumColegiado(numColegiado);
        setPassword(password);
        setEstado(estado);
        setEmailusuario(emailusuario);
        setTipoUsuario(tipoUsuario);
        setRolUsuario(rolUsuario);
        setCreadopor(creadopor);
        setFechacreacion(fechacreacion);
        setModificadopor(modificadopor);
        setFechamodificacion(fechamodificacion);
        setLlave(llave);
    }
}
