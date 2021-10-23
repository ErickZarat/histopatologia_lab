package histopatologialab.consultas.controller;

import histopatologialab.consultas.dto.EstadoExamen;
import histopatologialab.consultas.dto.Examen;
import histopatologialab.core.JsonResponse;
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
    public JsonResponse<Map<String, List<OpcionLesion>>> getOpciones(Boolean loadEnabled){
        List<OpcionLesion> opciones;

        if (loadEnabled) {
            opciones = tipoOpcionLesionDao.getOpcionesByEstado();
        } else {
            opciones = tipoOpcionLesionDao.getOpciones();
        }


        Map<String, List<OpcionLesion>> opcionesMap = opciones
                .stream()
                .collect(groupingBy(OpcionLesion::getNombreOpcion));
        return new JsonResponse<>(opcionesMap != null, opcionesMap);
    }

    @Override
    public JsonResponse<Examen> getExamen(int codExamen) {
        Examen examen = examenDao.getExamen(codExamen);
        return new JsonResponse<>(examen != null, examen);
    }

    @Override
    public JsonResponse<List<Examen>> getExamenes() {
        List<Examen> examenes = examenDao.getExamenes();
        return new JsonResponse<>(examenes != null, examenes);
    }

    @Override
    public JsonResponse<Examen> guardarExamen(Examen examen) {
        EstadoExamen estado;
        if (examen.isNecesitaBiopsia()){
            estado = EstadoExamen.PENDIENTE_BIOPSIA;
        } else if (examen.isNecesitaFrote()){
            estado = EstadoExamen.PENDIENTE_FROTE;
        } else {
            estado = EstadoExamen.INGRESADA;
        }

        examen.setEstado(estado.getSlug());

        Examen examen1 = examenDao.guardarExamen(examen);
        return new JsonResponse<Examen>(examen1 != null, examen1);
    }
    
    @Override
    public JsonResponse<List<Examen>> getExamenesByPaciente(Long codPaciente) {   
    	List<Examen> examenes = examenDao.getExamenesByPaciente(codPaciente);
    	return new JsonResponse<>(examenes != null, examenes);
    }
    
    
    
}
