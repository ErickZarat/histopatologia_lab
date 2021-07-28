package histopatologialab.tincion.controller;

import histopatologialab.core.JsonResponse;
import histopatologialab.tincion.Tincion;
import histopatologialab.tincion.dao.ITincionDao;

import java.util.List;

public class TincionControllerImpl implements ITincionController{

    private final ITincionDao tincionDao;

    public TincionControllerImpl(ITincionDao tincionDao) {
        this.tincionDao = tincionDao;
    }

    @Override
    public JsonResponse<List<Tincion>> getTinciones() {
        List<Tincion> tinciones = tincionDao.getTinciones();

        return new JsonResponse<>(tinciones != null, tinciones);
    }
}
