package histopatologialab.biopsia.controller;

import histopatologialab.biopsia.dto.Biopsia;
import histopatologialab.core.JsonResponse;

import java.util.List;

public interface IBiopsiaController {

    JsonResponse<Biopsia> getBiopsia(int codBiopsia);

    JsonResponse<Biopsia> getBiopsia(String numBiopsia);

    JsonResponse<List<Biopsia>> getBiopsiasByExamen(int codExamen);

    JsonResponse<Biopsia> guardarBiopsia(Biopsia biopsia);

    JsonResponse<Biopsia> modificarBiopsia(Biopsia biopsia, String usuario);

}
