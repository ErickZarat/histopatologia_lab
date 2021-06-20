package histopatologialab.consultas.dao;


import histopatologialab.consultas.dto.Examen;

import java.time.LocalDate;
import java.util.List;

public interface IExamenDao {

    Examen getExamen(String numExamen);
    Examen getExamen(int codExamen);

    List<Examen> getExamenesByPaciente(int codPaciente);
    Examen guardarExamen(Examen examen);
    Examen modificarExamen(Examen examen);

    int getNextExamenNumber(LocalDate date);

    List<Integer> getCaracteristicas(int codExamen);

    List<Examen> getExamenes();
}
