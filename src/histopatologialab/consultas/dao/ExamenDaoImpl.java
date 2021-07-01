package histopatologialab.consultas.dao;

import histopatologialab.consultas.dto.Examen;
import histopatologialab.core.DB;
import histopatologialab.core.db.tables.*;
import histopatologialab.core.db.tables.records.LabExamenCaracteristicaRecord;
import histopatologialab.core.db.tables.records.LabExamenDiagnosticoRecord;
import histopatologialab.core.db.tables.records.LabExamenEnfermedadSistemicaRecord;
import histopatologialab.core.db.tables.records.LabExamenRecord;
import histopatologialab.pacientes.dto.Paciente;
import histopatologialab.usuario.dto.Usuario;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.tinylog.Logger;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ExamenDaoImpl implements IExamenDao {
    private final DSLContext query = DB.getConexion();
    private final LabExamen tabla = LabExamen.LAB_EXAMEN;
    private final LabExamenCaracteristica tablaCaracteristica = LabExamenCaracteristica.LAB_EXAMEN_CARACTERISTICA;
    private final LabPaciente tablapaciente = LabPaciente.LAB_PACIENTE;
    private final LabUsuario tablaUsuario = LabUsuario.LAB_USUARIO;
    private final LabExamenEnfermedadSistemica tablaEnfermedad = LabExamenEnfermedadSistemica.LAB_EXAMEN_ENFERMEDAD_SISTEMICA;
    private final LabExamenDiagnostico tablaDiagnostico = LabExamenDiagnostico.LAB_EXAMEN_DIAGNOSTICO;

    public Examen parseItem(Record record) {
        return new Examen(
                record.getValue(tabla.COD_EXAMEN),
                record.getValue(tabla.COD_PACIENTE),
                record.getValue(tabla.NUM_EXAMEN),
                record.getValue(tabla.FECHA_EXAMEN),
                record.getValue(tabla.ESTADO_EXAMEN),
                record.getValue(tabla.HISTORIA_EXAMEN_LESION),
                record.getValue(tabla.TAMANO_LESION),
                record.getValue(tabla.DIMENSIONAL_LESION),
                record.getValue(tabla.DURACION_LESION_DIAS),
                record.getValue(tabla.DURACION_LESION_MESES),
                record.getValue(tabla.DURACION_LESION_ANIOS),
                record.getValue(tabla.DATOS_IMPORTANTES_LESION),
                record.getValue(tabla.DOCTOR_EXAMEN),
                record.getValue(tabla.TIPO_REMISION),
                record.getValue(tabla.DOCTOR_REMISION),
                record.getValue(tabla.DIRECCION_DOCTOR_REMISION),
                record.getValue(tabla.TELEFONO_DOCTOR_REMISION),
                record.getValue(tabla.EMAIL_DOCTOR_REMISION),
                record.getValue(tabla.DEPENDENCIA_DOCTOR_REMISION),
                record.getValue(tabla.REGISTRO_DOCTOR_REMISION),
                new Paciente(
                        record.getValue(tablapaciente.COD_PACIENTE),
                        record.getValue(tablapaciente.IDENTIFICACION),
                        record.getValue(tablapaciente.NOMBRE),
                        record.getValue(tablapaciente.APELLIDOS),
                        record.getValue(tablapaciente.DIRECCION),
                        record.getValue(tablapaciente.TELEFONO),
                        record.getValue(tablapaciente.FECHANACIMIENTO),
                        record.getValue(tablapaciente.GENERO),
                        record.getValue(tablapaciente.OCUPACION),
                        record.getValue(tablapaciente.TIPO_IDENTIFICACION),
                        record.getValue(tablapaciente.EMAIL),
                        record.getValue(tablapaciente.ESTADOCIVIL),
                        record.getValue(tablapaciente.CREADOPOR),
                        record.getValue(tablapaciente.FECHACREACION),
                        record.getValue(tablapaciente.MODIFICADOPOR),
                        record.getValue(tablapaciente.FECHAMODIFICACION)
                ),
                new Usuario(
                        record.getValue(tablaUsuario.COD_USUARIO),
                        record.getValue(tablaUsuario.LOGIN_USUARIO),
                        record.getValue(tablaUsuario.PASSWORD),
                        record.getValue(tablaUsuario.LLAVE),
                        record.getValue(tablaUsuario.NOMBRES_DOCTOR),
                        record.getValue(tablaUsuario.APELLIDOS_DOCTOR),
                        record.getValue(tablaUsuario.NUM_COLEGIADO),
                        record.getValue(tablaUsuario.EMAILUSUARIO),
                        record.getValue(tablaUsuario.TIPO_USUARIO),
                        record.getValue(tablaUsuario.ESTADO),
                        record.getValue(tablaUsuario.FECHACREACION),
                        record.getValue(tablaUsuario.CREADOPOR),
                        record.getValue(tablaUsuario.MODIFICADOPOR),
                        record.getValue(tablaUsuario.FECHAMODIFICACION)
                ),
                getCaracteristicas(record.getValue(tabla.COD_EXAMEN)),
                record.getValue(tabla.NECESITA_BIOPSIA) != null ? record.getValue(tabla.NECESITA_BIOPSIA) : false,
                record.getValue(tabla.NECESITA_FROTE) != null ? record.getValue(tabla.NECESITA_FROTE) : false
        );
    }

    @Override
    public Examen getExamen(String numExamen) {
        Record result = query.select(tabla.asterisk(), tablapaciente.asterisk(), tablaUsuario.asterisk())
                .from(tabla)
                .leftJoin(tablapaciente).on(tablapaciente.COD_PACIENTE.eq(tabla.COD_PACIENTE))
                .leftJoin(tablaUsuario).on(tablaUsuario.COD_USUARIO.eq(tabla.DOCTOR_EXAMEN))
                .where(tabla.NUM_EXAMEN.eq(numExamen))
                .fetchOne();
        return result != null ? parseItem(result): null;
    }

    @Override
    public Examen getExamen(int codExamen) {
        Record result = query.select(tabla.asterisk(), tablapaciente.asterisk(), tablaUsuario.asterisk())
                .from(tabla)
                .leftJoin(tablapaciente).on(tablapaciente.COD_PACIENTE.eq(tabla.COD_PACIENTE))
                .leftJoin(tablaUsuario).on(tablaUsuario.COD_USUARIO.eq(tabla.DOCTOR_EXAMEN))
                .where(tabla.COD_EXAMEN.eq(codExamen))
                .fetchOne();
        return result != null ? parseItem(result): null;
    }

    @Override
    public List<Examen> getExamenesByPaciente(Long codPaciente) {
        List<Record> result = query.select(tabla.asterisk(), tablapaciente.asterisk(), tablaUsuario.asterisk())
                .from(tabla)
                .leftJoin(tablapaciente).on(tablapaciente.COD_PACIENTE.eq(tabla.COD_PACIENTE))
                .leftJoin(tablaUsuario).on(tablaUsuario.COD_USUARIO.eq(tabla.DOCTOR_EXAMEN))
                .where(tabla.COD_PACIENTE.eq(codPaciente))
                .orderBy(tabla.FECHA_EXAMEN.desc())
                .fetch();
        return result.stream().map(this::parseItem).collect(Collectors.toList());
    }

    @Override
    public Examen guardarExamen(Examen examen) {
        LabExamenRecord record = query.newRecord(tabla);

        record.setCodPaciente(examen.getCodPaciente());
        record.setFechaExamen(examen.getFechaExamen());
        record.setEstadoExamen(examen.getEstado());
        record.setHistoriaExamenLesion(examen.getHistoriaExamenLesion());
        record.setTamanoLesion(examen.getTamanoLesion());
        record.setDimensionalLesion(examen.getDimensionalLesion());
        record.setDuracionLesionDias(examen.getDuracionLesionDias());
        record.setDuracionLesionMeses(examen.getDuracionLesionMeses());
        record.setDuracionLesionAnios(examen.getDuracionLesionAnios());
        record.setDatosImportantesLesion(examen.getDatosImportantesLesion());
        record.setDoctorExamen(examen.getDoctorExamen());
        record.setTipoRemision(examen.getTipoRemision());
        record.setDoctorExamen(examen.getDoctorExamen());
        record.setDireccionDoctorRemision(examen.getDireccionDoctorRemision());
        record.setTelefonoDoctorRemision(examen.getTelefonoDoctorRemision());
        record.setEmailDoctorRemision(examen.getEmailDoctorRemision());
        record.setDependenciaDoctorRemision(examen.getDependenciaDoctorRemision());
        record.setNecesitaBiopsia(examen.isNecesitaBiopsia());
        record.setNecesitaFrote(examen.isNecesitaFrote());
        examen.setFechaExamen(LocalDate.now());
        record.setFechaExamen(examen.getFechaExamen());

        examen.setNumExamen(getNextExamenNumber(examen.getFechaExamen()));
        record.setNumExamen(examen.getNumExamen());

        record.insert();

        examen.setCodExamen(record.getCodExamen());

        guardarCaracteristicas(examen);
        guardarEnfermedades(examen);
        guardarDiagnostico(examen, true);

        return getExamen(record.getCodExamen());
    }

    @Override
    public Examen modificarExamen(Examen examen) {
        LabExamenRecord record = query.newRecord(tabla);

        record.setCodExamen(examen.getCodExamen());
        record.setCodPaciente(examen.getCodPaciente());
        record.setNumExamen(examen.getNumExamen());
        record.setFechaExamen(examen.getFechaExamen());
        record.setEstadoExamen(examen.getEstado());
        record.setHistoriaExamenLesion(examen.getHistoriaExamenLesion());
        record.setTamanoLesion(examen.getTamanoLesion());
        record.setDimensionalLesion(examen.getDimensionalLesion());
        record.setDuracionLesionDias(examen.getDuracionLesionDias());
        record.setDuracionLesionMeses(examen.getDuracionLesionMeses());
        record.setDuracionLesionAnios(examen.getDuracionLesionAnios());
        record.setDatosImportantesLesion(examen.getDatosImportantesLesion());
        record.setDoctorExamen(examen.getDoctorExamen());
        record.setTipoRemision(examen.getTipoRemision());
        record.setDoctorExamen(examen.getDoctorExamen());
        record.setDireccionDoctorRemision(examen.getDireccionDoctorRemision());
        record.setTelefonoDoctorRemision(examen.getTelefonoDoctorRemision());
        record.setEmailDoctorRemision(examen.getEmailDoctorRemision());
        record.setDependenciaDoctorRemision(examen.getDependenciaDoctorRemision());
        record.setNecesitaBiopsia(examen.isNecesitaBiopsia());
        record.setNecesitaFrote(examen.isNecesitaFrote());
        record.update();

        return getExamen(examen.getCodExamen());
    }

    @Override
    public String getNextExamenNumber(LocalDate date) {
        date.withDayOfMonth(1);
        int newNumber = query
                .fetchCount(tabla, tabla.FECHA_EXAMEN.greaterOrEqual(date));

        return (newNumber + 1) + "-" + date.getMonthValue() + "-" + date.getYear();
    }

    @Override
    public List<Integer> getCaracteristicas(int codExamen){
        List<Record> result = query.select(tablaCaracteristica.asterisk())
                .from(tablaCaracteristica)
                .where(tablaCaracteristica.COD_EXAMEN.eq(codExamen))
                .fetch();

        return result.stream().map(x -> x.getValue(tablaCaracteristica.CODIGO_TIPO_OPCION_LESION)).collect(Collectors.toList());
    }

    private void guardarCaracteristicas(Examen examen){
        List<Integer> caracteristicas = examen.getCaracteristicas();
        if (caracteristicas == null)  {
            Logger.info("ignoring null caracteristicas");
            return;
        }
        for (Integer opcionLesionCod: caracteristicas) {
            Logger.info("guardando caracteristicas");
            LabExamenCaracteristicaRecord record = query.newRecord(tablaCaracteristica);
            record.setCodExamen(examen.getCodExamen());
            record.setCodigoTipoOpcionLesion(opcionLesionCod);
            record.setCreadoPor("");
            record.setFechaCreacion(LocalDate.now());

            query.insertInto(tablaCaracteristica).set(record).execute();
        }
    }

    private void guardarEnfermedades(Examen examen){
        List<Integer> enfermedades = examen.getEnfermedades();
        if(enfermedades == null) {
            Logger.info("ignoring null enfermedades");
            return;
        }
        for (Integer enfermedad: enfermedades) {
            Logger.info("guardando enfermedad");
            LabExamenEnfermedadSistemicaRecord record = query.newRecord(tablaEnfermedad);
            record.setCodExamen(examen.getCodExamen());
            record.setCodEnfermedadSistemica(enfermedad);
            record.setFechaCreacion(LocalDate.now());
            query.insertInto(tablaEnfermedad).set(record).execute();
        }
    }

    private void guardarDiagnostico(Examen examen, boolean esInicial){
        List<Integer> diagnosticos = examen.getDiagnosticos();
        if(diagnosticos == null) {
            Logger.info("ignoring null diagnosticos");
            return;
        }

        for(Integer diagnostico: diagnosticos) {
            Logger.info("guardando diagnostico");
            LabExamenDiagnosticoRecord record = query.newRecord(tablaDiagnostico);
            record.setCodExamen(examen.getCodExamen());
            record.setCodDiagnostico(diagnostico);
            record.setTipoDiagnostico(esInicial ? 0 : 1);
            record.setFechaCreacion(LocalDate.now());

            query.insertInto(tablaDiagnostico).set(record).execute();
        }



    }

    @Override
    public List<Examen> getExamenes() {
        List<Record> result = query.select(tabla.asterisk(), tablapaciente.asterisk(), tablaUsuario.asterisk())
                .from(tabla)
                .leftJoin(tablapaciente).on(tablapaciente.COD_PACIENTE.eq(tabla.COD_PACIENTE))
                .leftJoin(tablaUsuario).on(tablaUsuario.COD_USUARIO.eq(tabla.DOCTOR_EXAMEN))
                .orderBy(tabla.COD_EXAMEN.desc())
                .fetch();
        return result.stream().map(this::parseItem).collect(Collectors.toList());
    }

}
