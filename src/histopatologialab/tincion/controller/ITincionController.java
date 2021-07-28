package histopatologialab.tincion.controller;

import histopatologialab.core.JsonResponse;
import histopatologialab.tincion.Tincion;

import java.util.List;

public interface ITincionController {
    JsonResponse<List<Tincion>> getTinciones();
}
