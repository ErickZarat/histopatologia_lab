package histopatologialab.frote.controller;

import histopatologialab.core.JsonResponse;
import histopatologialab.frote.dto.Frote;

import java.util.List;

public interface IFroteController {

    JsonResponse<Frote> getFrote(int codFrote);

    JsonResponse<Frote> getFrote(String numFrote);

    JsonResponse<List<Frote>> getFrotesByExamen(int codExamen);

    JsonResponse<Frote> guardarFrote(Frote frote);

    JsonResponse<Frote> modificarFrote(Frote frote, String usuario, Boolean saveImage);

}
