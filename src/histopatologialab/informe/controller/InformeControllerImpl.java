package histopatologialab.informe.controller;

import histopatologialab.core.JsonResponse;
import histopatologialab.informe.dao.IInformeDao;
import histopatologialab.informe.dto.Informe;
import org.tinylog.Logger;

public class InformeControllerImpl implements IInformeController{

    private IInformeDao informeDao;

    public InformeControllerImpl(IInformeDao informeDao) {
        this.informeDao = informeDao;
    }


    @Override
    public JsonResponse<Informe> crearInforme(Informe informe) {
        Informe inf = informeDao.crearInforme(informe);
        Logger.info("supuestamente se guardo esta null" + inf == null);
        return new JsonResponse<>(inf != null, inf);
    }

    @Override
    public JsonResponse<Informe> getInforme(int codInforme) {
        Informe inf = informeDao.getInforme(codInforme);
        return new JsonResponse<>(inf != null, inf);
    }

    @Override
    public JsonResponse<Informe> getInformeByBiopsia(int codBiopsia) {
        Informe inf = informeDao.getInformeByBiopsia(codBiopsia);
        return new JsonResponse<>(inf != null, inf);
    }

    @Override
    public JsonResponse<Informe> getInformeByFrote(int codFrote) {
        Informe inf = informeDao.getInformeByFrote(codFrote);
        return new JsonResponse<>(inf != null, inf);
    }
}
