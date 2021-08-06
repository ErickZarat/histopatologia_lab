package histopatologialab.receta.controller;

import histopatologialab.core.JsonResponse;
import histopatologialab.receta.dto.Receta;

import java.util.List;

public interface IRecetaController {
    JsonResponse<List<Receta>> getRecetaByExamen(Integer codExamen);
    JsonResponse<List<Receta>> guardarReceta(List<Receta> recetas);
}
