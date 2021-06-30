package histopatologialab.consultas.controller;

import histopatologialab.consultas.dto.Examen;
import histopatologialab.core.JsonResponse;
import histopatologialab.tipopcionlesion.dto.OpcionLesion;

import java.util.List;
import java.util.Map;

public interface IConsultaController {

    JsonResponse<Map<String, List<OpcionLesion>>> getOpciones();

    JsonResponse<Examen> getExamen(int codExamen);

    JsonResponse<List<Examen>> getExamenes();

    JsonResponse<Examen> guardarExamen(Examen examen);

}
