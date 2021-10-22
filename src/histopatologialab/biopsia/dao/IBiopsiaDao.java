package histopatologialab.biopsia.dao;

import histopatologialab.biopsia.dto.Biopsia;

import java.util.List;

public interface IBiopsiaDao {
    Biopsia getByCod(int codBiopsia);
    Biopsia getByNumBiopsia(String numBiopsia);
    List<Biopsia> getByExamen(int codExamen);
    Biopsia guardarBiopsia(Biopsia biopsia);
    Biopsia modificarBiopsia(Biopsia biopsia, String usuario, Boolean saveImage);
}
