package histopatologialab.consultas.dao;

import histopatologialab.consultas.dto.Examen;
import histopatologialab.core.DB;
import histopatologialab.core.db.tables.*;
import histopatologialab.core.db.tables.records.*;
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
    private final LabExamenImagen tablaImg = LabExamenImagen.LAB_EXAMEN_IMAGEN;

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
                record.getValue(tabla.DOCTOR_REMISION),
                record.getValue(tabla.DIRECCION_DOCTOR_REMISION),
                record.getValue(tabla.TELEFONO_DOCTOR_REMISION),
                record.getValue(tabla.EMAIL_DOCTOR_REMISION),
                record.getValue(tabla.DEPENDENCIA_DOCTOR_REMISION),
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
                        record.getValue(tablapaciente.FECHAMODIFICACION),
                        record.getValue(tablapaciente.NUM_FICHA)
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

    private List<Integer> getEnfermedadesIds(int codExamen) {
        return query.select(tablaEnfermedad.COD_ENFERMEDAD_SISTEMICA).from(tablaEnfermedad).where(tablaEnfermedad.COD_EXAMEN.eq(codExamen)).fetch(tablaEnfermedad.COD_ENFERMEDAD_SISTEMICA, Integer.class);
    }
    private List<Integer> getDiagnosticosIds(int codExamen) {
        return query.select(tablaDiagnostico.COD_DIAGNOSTICO).from(tablaDiagnostico).where(tablaDiagnostico.COD_EXAMEN.eq(codExamen)).fetch(tablaDiagnostico.COD_DIAGNOSTICO, Integer.class);
    }
    private List<String> getImages(int codExamen) {
        return query.select(tablaImg.RUTA_IMAGEN).from(tablaImg).where(tablaImg.COD_EXAMEN.eq(codExamen)).fetch(tablaImg.RUTA_IMAGEN, String.class);
    }

    @Override
    public Examen getExamen(int codExamen) {
        Record result = query.select(tabla.asterisk(), tablapaciente.asterisk(), tablaUsuario.asterisk())
                .from(tabla)
                .leftJoin(tablapaciente).on(tablapaciente.COD_PACIENTE.eq(tabla.COD_PACIENTE))
                .leftJoin(tablaUsuario).on(tablaUsuario.COD_USUARIO.eq(tabla.DOCTOR_EXAMEN))
                .where(tabla.COD_EXAMEN.eq(codExamen))
                .fetchOne();
        Examen examen = result != null ? parseItem(result): null;
        if (examen != null) {
            examen.setEnfermedades(getEnfermedadesIds(examen.getCodExamen()));
            examen.setDiagnosticos(getDiagnosticosIds(examen.getCodExamen()));
            examen.setImagenes(getImages(examen.getCodExamen()));
            examen.setCaracteristicas(getCaracteristicas(examen.getCodExamen()));
        }
        return examen;
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
        record.setDoctorExamen(examen.getDoctorExamen());
        record.setDireccionDoctorRemision(examen.getDireccionDoctorRemision());
        record.setTelefonoDoctorRemision(examen.getTelefonoDoctorRemision());
        record.setEmailDoctorRemision(examen.getEmailDoctorRemision());
        record.setDependenciaDoctorRemision(examen.getDependenciaDoctorRemision());
        record.setNecesitaBiopsia(examen.isNecesitaBiopsia());
        record.setNecesitaFrote(examen.isNecesitaFrote());
        record.setDoctorRemision(examen.getDoctorRemision());
        examen.setFechaExamen(LocalDate.now());
        record.setFechaExamen(examen.getFechaExamen());

        examen.setNumExamen(getNextExamenNumber(examen.getFechaExamen()));
        record.setNumExamen(examen.getNumExamen());

        record.insert();

        examen.setCodExamen(record.getCodExamen());

        guardarCaracteristicas(examen);
        guardarEnfermedades(examen);
        guardarDiagnostico(examen, true);
        guardarImagenes(examen);

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
        date = date.withDayOfMonth(1);
        int newNumber = query
                .fetchCount(tabla, tabla.FECHA_EXAMEN.greaterOrEqual(date));

        return (newNumber + 1) + "-" + date.getMonthValue() + "-" + date.getYear();
    }

    @Override
    public List<Integer> getCaracteristicas(int codExamen){
        return query.select(tablaCaracteristica.CODIGO_TIPO_OPCION_LESION)
                .from(tablaCaracteristica)
                .where(tablaCaracteristica.COD_EXAMEN.eq(codExamen))
                .fetch(tablaCaracteristica.CODIGO_TIPO_OPCION_LESION);
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

    private void guardarImagenes(Examen examen) {
        if (examen.getImagenes() == null){
            Logger.info("ignore null images");
            return;
        }
        for (String img: examen.getImagenes()){
            LabExamenImagenRecord record = query.newRecord(tablaImg);
            record.setCodExamen(examen.getCodExamen());
            record.setFechaCreacion(LocalDate.now());
            String[] parts = img.split("/");
            record.setNombreImagen(parts[parts.length - 1]);
            record.setNumImagen(examen.getImagenes().indexOf(img));
            record.setRutaImagen(img);

            query.insertInto(tablaImg).set(record).execute();
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
