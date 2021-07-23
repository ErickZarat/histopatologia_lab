package histopatologialab.biopsia.controller;

import histopatologialab.biopsia.dto.Biopsia;
import histopatologialab.core.JsonResponse;
import histopatologialab.biopsia.dao.IBiopsiaDao;

import java.util.List;

public class BiopsiaControllerImpl implements IBiopsiaController {
    private IBiopsiaDao froteDao;

    public BiopsiaControllerImpl(IBiopsiaDao froteDao) {
        this.froteDao = froteDao;
    }

    @Override
    public JsonResponse<Biopsia> getBiopsia(int codBiopsia) {
        Biopsia biopsia = froteDao.getByCod(codBiopsia);
        return new JsonResponse<>(biopsia != null, biopsia);
    }

    @Override
    public JsonResponse<Biopsia> getBiopsia(String numBiopsia) {
        Biopsia biopsia = froteDao.getByNumBiopsia(numBiopsia);
        return new JsonResponse<>(biopsia != null, biopsia);
    }

    @Override
    public JsonResponse<List<Biopsia>> getBiopsiasByExamen(int codExamen) {
        List<Biopsia> biopsias = froteDao.getByExamen(codExamen);
        return new JsonResponse<>(biopsias != null, biopsias);
    }

    @Override
    public JsonResponse<Biopsia> guardarBiopsia(Biopsia biopsia) {
        Biopsia saved = froteDao.guardarBiopsia(biopsia);
        return new JsonResponse<>(saved != null, saved);
    }

    @Override
    public JsonResponse<Biopsia> modificarBiopsia(Biopsia biopsia, String usuario) {
        Biopsia saved = froteDao.modificarBiopsia(biopsia, usuario);
        return new JsonResponse<>(saved != null, saved);
    }
}
