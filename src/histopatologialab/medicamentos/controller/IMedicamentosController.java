package histopatologialab.medicamentos.controller;

import histopatologialab.medicamentos.dto.Medicamento;
import histopatologialab.medicamentos.dto.PresentacionMedicamento;

import java.util.List;

public interface IMedicamentosController {
    Medicamento crearMedicamento(String nombre, int tipo, String usuario);
    Medicamento modificarMedicamento(int codigo, String nombre, String usuario);
    Boolean darBajaMedicamento(int codigo, String usuario);
    List<Medicamento> getMedicamentos(Integer tipoMedicamento);

    List<PresentacionMedicamento> getPresentaciones(int codigo);
    PresentacionMedicamento getPresentacion(int codigo, String tipoMedicamento);
    PresentacionMedicamento crearPresentacionMedicamento(PresentacionMedicamento presentacionMedicamento);
    PresentacionMedicamento modificarPresentacionMedicamento(String tipoPresentacion, PresentacionMedicamento presentacionMedicamento);
    Boolean darBajaPresentacion(int codigo, String tipoMedicamento, String usuario);

}
