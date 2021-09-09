package histopatologialab.medicamentos.controller;

import histopatologialab.core.JsonResponse;
import histopatologialab.medicamentos.dto.Medicamento;
import histopatologialab.medicamentos.dto.PresentacionMedicamento;

import java.util.List;

public interface IMedicamentosController {
    JsonResponse<Medicamento> crearMedicamento(String nombre, int tipo, String usuario);
    JsonResponse<Medicamento> modificarMedicamento(int codigo, String nombre, String usuario);
    JsonResponse<Boolean> darBajaMedicamento(int codigo, String usuario);
    JsonResponse<List<Medicamento>> getMedicamentos(Integer tipoMedicamento);
    JsonResponse<List<Medicamento>> getMedicamentosAllState(Integer tipoMedicamento);
    JsonResponse<Boolean> cambiaEstadoMedicamento(int codMedicamento, String estadoNuevo, String usuario);

    JsonResponse<List<PresentacionMedicamento>> getPresentaciones(int codigo);
    JsonResponse<PresentacionMedicamento> getPresentacion(int codigo, String tipoMedicamento);
    JsonResponse<PresentacionMedicamento> crearPresentacionMedicamento(PresentacionMedicamento presentacionMedicamento);
    JsonResponse<PresentacionMedicamento> modificarPresentacionMedicamento(String tipoPresentacion, PresentacionMedicamento presentacionMedicamento);
    JsonResponse<Boolean> darBajaPresentacion(int codigo, String tipoMedicamento, String usuario);

}
