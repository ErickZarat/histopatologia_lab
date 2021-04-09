package histopatologialab.medicamentos.controller;

import histopatologialab.medicamentos.dto.Medicamento;
import histopatologialab.medicamentos.dto.PresentacionMedicamento;

import java.util.List;

public interface IMedicamentosController {
    Medicamento crearMedicamento(String nombre, String tipo, String usuario);
    Medicamento modificarMedicamento(int codigo, String nombre, String usuario);
    Boolean darBajaMedicamento(int codigo, String usuario);
    List<PresentacionMedicamento> obtenerPresentaciones(int codigo);

}
