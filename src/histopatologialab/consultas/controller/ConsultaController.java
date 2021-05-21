package histopatologialab.consultas.controller;

import histopatologialab.opciones.dao.ITipoOpcionLesionDao;
import histopatologialab.opciones.dto.TipoOpcionLesion;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class ConsultaController {
    private final ITipoOpcionLesionDao tipoOpcionLesionDao;

    public ConsultaController(ITipoOpcionLesionDao tipoOpcionLesionDao) {
        this.tipoOpcionLesionDao = tipoOpcionLesionDao;
    }

    public Map<String, List<TipoOpcionLesion>> getOpciones(){
        return tipoOpcionLesionDao.getOpciones().stream()
                .collect(groupingBy(TipoOpcionLesion::getNombre));
    }
}
