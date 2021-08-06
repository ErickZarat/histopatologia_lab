package histopatologialab.receta.controller;

import histopatologialab.core.JsonResponse;
import histopatologialab.receta.dao.IRecetaDao;
import histopatologialab.receta.dto.Receta;

import java.util.List;

public class RecetaControllerImpl implements IRecetaController {

    private final IRecetaDao recetaDao;

    public RecetaControllerImpl(IRecetaDao recetaDao) {
        this.recetaDao = recetaDao;
    }


    @Override
    public JsonResponse<List<Receta>> getRecetaByExamen(Integer codExamen) {
        List<Receta> recetas = recetaDao.getRecetaByExamen(codExamen);
        return new JsonResponse<>(recetas != null, recetas);
    }

    @Override
    public JsonResponse<List<Receta>> guardarReceta(List<Receta> recetas) {
        List<Receta> savedRecetas = recetaDao.guardarReceta(recetas);
        return new JsonResponse<>(recetas != null, savedRecetas);
    }
}
