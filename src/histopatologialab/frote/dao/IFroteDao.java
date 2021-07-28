package histopatologialab.frote.dao;

import histopatologialab.frote.dto.Frote;

import java.util.List;

public interface IFroteDao {
    Frote getByCod(int codFrote);
    Frote getByNumFrote(String numFrote);
    List<Frote> getByExamen(int codExamen);
    Frote guardarFrote(Frote frote);
    Frote modificarFrote(Frote frote, String usuario);
}
