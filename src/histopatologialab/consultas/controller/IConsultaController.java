package histopatologialab.consultas.controller;

import histopatologialab.consultas.dto.Examen;
import histopatologialab.tipopcionlesion.dto.OpcionLesion;

import java.util.List;
import java.util.Map;

public interface IConsultaController {

    Map<String, List<OpcionLesion>> getOpciones();

    Examen getExamen(int codExamen);

    List<Examen> getExamenes();

    Examen guardarExamen(Examen examen);

}
