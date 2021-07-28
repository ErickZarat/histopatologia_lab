package histopatologialab.informe.controller;

import histopatologialab.core.JsonResponse;
import histopatologialab.informe.dto.Informe;

public interface IInformeController {
    JsonResponse<Informe> crearInforme(Informe informe);
    JsonResponse<Informe> getInforme(int codInforme);
    JsonResponse<Informe> getInformeByBiopsia(int codBiopsia);
    JsonResponse<Informe> getInformeByFrote(int codFrote);
}
