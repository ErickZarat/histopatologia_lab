package histopatologialab.consultas.dao;

import histopatologialab.consultas.dto.Examen;
import histopatologialab.core.DB;
import histopatologialab.core.db.tables.LabExamen;
import histopatologialab.core.db.tables.LabExamenCaracteristica;
import histopatologialab.core.db.tables.LabPaciente;
import histopatologialab.core.db.tables.LabUsuario;
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
    private final LabExamenCaracteristica tablaCaract = LabExamenCaracteristica.LAB_EXAMEN_CARACTERISTICA;
    private final LabPaciente tablapaciente = LabPaciente.LAB_PACIENTE;
    private final LabUsuario tablaUsuario = LabUsuario.LAB_USUARIO;

    public Examen parseItem(Record record) {
        return new Examen (
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
                null,
                null
        );
    }

    @Override
    public Examen getExamen(String numExamen) {
        Record result = query.select(tabla.asterisk())
                .from(tabla)
                .where(tabla.NUM_EXAMEN.eq(numExamen))
                .fetchOne();
        return result != null ? parseItem(result): null;
    }

    @Override
    public Examen getExamen(int codExamen) {
        Record result = query.select(tabla.asterisk())
                .from(tabla)
                .where(tabla.COD_EXAMEN.eq(codExamen))
                .fetchOne();
        return result != null ? parseItem(result): null;
    }

    @Override
    public List<Examen> getExamenesByPaciente(Long codPaciente) {
        List<Record> result = query.select(tabla.asterisk())
                .from(tabla)
                .where(tabla.COD_PACIENTE.eq(codPaciente))
                .orderBy(tabla.FECHA_EXAMEN.desc())
                .fetch();
        return result.stream().map(this::parseItem).collect(Collectors.toList());
    }

    @Override
    public Examen guardarExamen(Examen examen) {
        LabExamenRecord record = query.newRecord(tabla);

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
        record.store();

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
        record.update();

        return getExamen(examen.getCodExamen());
    }

    @Override
    public int getNextExamenNumber(LocalDate date) {
        date.withDayOfMonth(1);
        Record result = query.select(tabla.NUM_EXAMEN)
                .where(tabla.FECHA_EXAMEN.greaterOrEqual(date))
                .orderBy(tabla.COD_EXAMEN.desc())
                .fetchOne();

        int newNumber = 1;
        try {
            String examen = result.getValue(tabla.NUM_EXAMEN);
            String[] parts = examen.split("-");
            String number = parts[parts.length - 1];

            newNumber = Integer.parseInt(number) + 1;

        } catch (Exception e) {
        }
        return newNumber;
    }

    @Override
    public List<Integer> getCaracteristicas(int codExamen){
        List<Record> result = query.select(tablaCaract.asterisk())
                .from(tablaCaract)
                .where(tablaCaract.COD_EXAMEN.eq(codExamen))
                .fetch();

        return result.stream().map(x -> x.getValue(tablaCaract.CODIGO_TIPO_OPCION_LESION)).collect(Collectors.toList());

    }

    @Override
    public List<Examen> getExamenes() {
        List<Record> result =  query.select(tabla.asterisk())
                .from(tabla)
                .orderBy(tabla.COD_EXAMEN.desc())
                .fetch();
        return result.stream().map(this::parseItem).collect(Collectors.toList());
    }

    public void setCaracteristicas(){

    }
}
