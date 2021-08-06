package histopatologialab.receta.dao;

import histopatologialab.receta.dto.Receta;

import java.util.List;

public interface IRecetaDao {

    List<Receta> getRecetaByExamen(Integer codExamen);
    List<Receta> guardarReceta(List<Receta> recetas);


}
