package histopatologialab.frote.controller;

import histopatologialab.core.JsonResponse;
import histopatologialab.frote.dao.IFroteDao;
import histopatologialab.frote.dto.Frote;

import java.util.List;

public class FroteControllerImpl implements IFroteController{
    private IFroteDao froteDao;

    public FroteControllerImpl(IFroteDao froteDao) {
        this.froteDao = froteDao;
    }

    @Override
    public JsonResponse<Frote> getFrote(int codFrote) {
        Frote frote = froteDao.getByCod(codFrote);
        return new JsonResponse<>(frote != null, frote);
    }

    @Override
    public JsonResponse<Frote> getFrote(String numFrote) {
        Frote frote = froteDao.getByNumFrote(numFrote);
        return new JsonResponse<>(frote != null, frote);
    }

    @Override
    public JsonResponse<List<Frote>> getFrotesByExamen(int codExamen) {
        List<Frote> frotes = froteDao.getByExamen(codExamen);
        return new JsonResponse<>(frotes != null, frotes);
    }

    @Override
    public JsonResponse<Frote> guardarFrote(Frote frote) {
        Frote saved = froteDao.guardarFrote(frote);
        return new JsonResponse<>(saved != null, saved);
    }

    @Override
    public JsonResponse<Frote> modificarFrote(Frote frote, String usuario) {
        Frote saved = froteDao.modificarFrote(frote, usuario);
        return new JsonResponse<>(saved != null, saved);
    }
}
