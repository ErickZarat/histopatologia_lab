package histopatologialab.informe.dao;

import histopatologialab.informe.dto.Informe;

public interface IInformeDao {
    Informe crearInforme(Informe informe);

    Informe getInforme(int codInforme);
    Informe getInformeByBiopsia(int codBiopsia);
    Informe getInformeByFrote(int codFrote);
}
