package histopatologialab.biopsia.controller;

import histopatologialab.biopsia.dto.Biopsia;
import histopatologialab.consultas.dto.EstadoExamen;
import histopatologialab.core.JsonResponse;
import histopatologialab.biopsia.dao.IBiopsiaDao;

import java.util.List;

public class BiopsiaControllerImpl implements IBiopsiaController {
    private final IBiopsiaDao biopsiaDao;

    public BiopsiaControllerImpl(IBiopsiaDao biopsiaDao) {
        this.biopsiaDao = biopsiaDao;
    }

    @Override
    public JsonResponse<Biopsia> getBiopsia(int codBiopsia) {
        Biopsia biopsia = biopsiaDao.getByCod(codBiopsia);
        return new JsonResponse<>(biopsia != null, biopsia);
    }

    @Override
    public JsonResponse<Biopsia> getBiopsia(String numBiopsia) {
        Biopsia biopsia = biopsiaDao.getByNumBiopsia(numBiopsia);
        return new JsonResponse<>(biopsia != null, biopsia);
    }

    @Override
    public JsonResponse<List<Biopsia>> getBiopsiasByExamen(int codExamen) {
        List<Biopsia> biopsias = biopsiaDao.getByExamen(codExamen);
        return new JsonResponse<>(biopsias != null, biopsias);
    }

    @Override
    public JsonResponse<Biopsia> guardarBiopsia(Biopsia biopsia) {
        biopsia.setEstadoBiopsia(EstadoExamen.PENDIENTE_BIOPSIA.getSlug());
        Biopsia saved = biopsiaDao.guardarBiopsia(biopsia);
        return new JsonResponse<>(saved != null, saved);
    }

    @Override
    public JsonResponse<Biopsia> modificarBiopsia(Biopsia biopsia, String usuario) {
        Biopsia saved = biopsiaDao.modificarBiopsia(biopsia, usuario);
        return new JsonResponse<>(saved != null, saved);
    }
}
