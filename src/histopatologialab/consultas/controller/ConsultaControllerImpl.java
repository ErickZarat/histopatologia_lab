package histopatologialab.consultas.controller;

import histopatologialab.consultas.dto.Examen;
import histopatologialab.tipopcionlesion.dao.IOpcionLesionDao;
import histopatologialab.tipopcionlesion.dto.OpcionLesion;

import java.util.List;
import java.util.Map;

import static histopatologialab.core.Daos.examenDao;
import static java.util.stream.Collectors.groupingBy;

public class ConsultaControllerImpl implements IConsultaController {
    private final IOpcionLesionDao tipoOpcionLesionDao;

    public ConsultaControllerImpl(IOpcionLesionDao tipoOpcionLesionDao) {
        this.tipoOpcionLesionDao = tipoOpcionLesionDao;
    }

    @Override
    public Map<String, List<OpcionLesion>> getOpciones(){
        return tipoOpcionLesionDao.getOpciones()
                .stream()
                .collect(groupingBy(OpcionLesion::getNombreOpcion));
    }

    private void genConsultaNumber() {

    }

    @Override
    public Examen getExamen(int codExamen) {
        return examenDao.getExamen(codExamen);
    }

    @Override
    public List<Examen> getExamenes() {
        return examenDao.getExamenes();
    }

    public Examen guardarExamen(Examen examen) {
        return examenDao.guardarExamen(examen);
    }
}
