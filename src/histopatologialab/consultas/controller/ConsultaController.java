package histopatologialab.consultas.controller;

import histopatologialab.tipopcionlesion.dao.IOpcionLesionDao;
import histopatologialab.tipopcionlesion.dto.OpcionLesion;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class ConsultaController {
    private final IOpcionLesionDao tipoOpcionLesionDao;

    public ConsultaController(IOpcionLesionDao tipoOpcionLesionDao) {
        this.tipoOpcionLesionDao = tipoOpcionLesionDao;
    }

    public Map<String, List<OpcionLesion>> getOpciones(){
        return tipoOpcionLesionDao.getOpciones()
                .stream()
                .collect(groupingBy(OpcionLesion::getNombreOpcion));
    }
}
