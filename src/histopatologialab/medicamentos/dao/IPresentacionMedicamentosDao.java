package histopatologialab.medicamentos.dao;

import histopatologialab.medicamentos.dto.PresentacionMedicamento;

import java.util.List;

public interface IPresentacionMedicamentosDao {
    List<PresentacionMedicamento> getPresentaciones(int codMedicamento);
    PresentacionMedicamento guardarPresentacion(PresentacionMedicamento presentacionMedicamento);
    PresentacionMedicamento getPresentacion(int codMedicamento, int tipoPresentacion);
}
