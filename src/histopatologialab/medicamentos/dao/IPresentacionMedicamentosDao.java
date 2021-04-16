package histopatologialab.medicamentos.dao;

import histopatologialab.medicamentos.dto.PresentacionMedicamento;

import java.util.List;

public interface IPresentacionMedicamentosDao {
    List<PresentacionMedicamento> getPresentaciones(int codMedicamento);
    PresentacionMedicamento guardarPresentacion(PresentacionMedicamento presentacionMedicamento);
    PresentacionMedicamento getPresentacion(int codMedicamento, String tipoPresentacion);
    PresentacionMedicamento modificarPresentacion(int codMedicamento, String tipoPresentacion, PresentacionMedicamento presentacionMedicamento);
    Boolean darBajaPresentacion(int codMedicamento, String tipoPresentacion, String usuario);
}
