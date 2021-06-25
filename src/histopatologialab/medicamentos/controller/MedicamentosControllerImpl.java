package histopatologialab.medicamentos.controller;

import histopatologialab.core.Estado;
import histopatologialab.core.JsonResponse;
import histopatologialab.medicamentos.dao.IMedicamentosDao;
import histopatologialab.medicamentos.dao.IPresentacionMedicamentosDao;
import histopatologialab.medicamentos.dto.Medicamento;
import histopatologialab.medicamentos.dto.PresentacionMedicamento;

import java.time.LocalDate;
import java.util.List;

public class MedicamentosControllerImpl implements IMedicamentosController {

    private final IMedicamentosDao medicamentosDao;
    private final IPresentacionMedicamentosDao presentacionDao;

    public MedicamentosControllerImpl(IMedicamentosDao medicamentosDao, IPresentacionMedicamentosDao presentacionDao) {
        this.medicamentosDao = medicamentosDao;
        this.presentacionDao = presentacionDao;
    }

    @Override
    public JsonResponse<Medicamento> crearMedicamento(String nombre, int tipo, String usuario) {
        try {
            Medicamento medicamento = new Medicamento(0, nombre, Estado.HABILITADO.getSlug(), usuario, LocalDate.now(), null, null, tipo);
            medicamento = medicamentosDao.guardarMedicamento(medicamento);
            return new JsonResponse<Medicamento>(medicamento != null, medicamento);
        } catch (Exception e) {
        	return new JsonResponse<>(false, null, e.getMessage());
        }
    }

    @Override
    public JsonResponse<Medicamento> modificarMedicamento(int codigo, String nombre, String usuario) {
        try {
            Medicamento medicamento = medicamentosDao.getMedicamento(codigo);
            medicamento.setNombreMedicamento(nombre);
            medicamento.setModificadoPor(usuario);
            medicamento.setFechaModificacion(LocalDate.now());
            medicamento = medicamentosDao.modificarMedicamento(medicamento);
            return new JsonResponse(medicamento != null, medicamento);
        } catch (Exception e) {
        	return new JsonResponse<>(false, null, e.getMessage());
        }
    }

    @Override
    public JsonResponse<Boolean> darBajaMedicamento(int codigo, String usuario) {
        Boolean success = medicamentosDao.darDeBaja(codigo, usuario);
        return new JsonResponse<Boolean>(success, success) ;
    }

    @Override
    public JsonResponse<List<Medicamento>> getMedicamentos(Integer tipoMedicamento) {
        List<Medicamento> medicamentos = medicamentosDao.getMedicamentosByTipo(tipoMedicamento);
        return new JsonResponse<List<Medicamento>>(medicamentos != null, medicamentos);
    }

    @Override
    public JsonResponse<List<PresentacionMedicamento>> getPresentaciones(int codigo) {
        try {
            List<PresentacionMedicamento> presentaciones = presentacionDao.getPresentaciones(codigo);
            return new JsonResponse<List<PresentacionMedicamento>>(presentaciones != null, presentaciones);
        } catch (Exception e) {
        	return new JsonResponse<>(false, null, e.getMessage());
        }
    }

    @Override
    public JsonResponse<PresentacionMedicamento> getPresentacion(int codigo, String tipoMedicamento) {
        try {
            PresentacionMedicamento presentacion = presentacionDao.getPresentacion(codigo, tipoMedicamento);
            return new JsonResponse<>(presentacion != null, presentacion);
        } catch (Exception e) {
        	return new JsonResponse<>(false, null, e.getMessage());
        }
    }

    @Override
    public JsonResponse<PresentacionMedicamento> crearPresentacionMedicamento(PresentacionMedicamento presentacionMedicamento) {
        try {
            PresentacionMedicamento presentacion = presentacionDao.guardarPresentacion(presentacionMedicamento);
            return new JsonResponse<>(presentacion != null, presentacion);
        } catch (Exception e) {
        	return new JsonResponse<>(false, null, e.getMessage());
        }
    }

    @Override
    public JsonResponse<PresentacionMedicamento> modificarPresentacionMedicamento(String tipoPresentacion, PresentacionMedicamento presentacionMedicamento) {
        try {
            PresentacionMedicamento presentacion = presentacionDao.modificarPresentacion(presentacionMedicamento.getCodMedicamento(), tipoPresentacion, presentacionMedicamento);
            return new JsonResponse<>(presentacion != null, presentacionDao.modificarPresentacion(presentacionMedicamento.getCodMedicamento(), tipoPresentacion, presentacionMedicamento));
        } catch (Exception e) {
        	return new JsonResponse<>(false, null, e.getMessage());
        }
    }

    @Override
    public JsonResponse<Boolean> darBajaPresentacion(int codigo, String tipoMedicamento, String usuario) {
        try {
            Boolean success = presentacionDao.darBajaPresentacion(codigo, tipoMedicamento, usuario);
            return new JsonResponse<>(success, success);
        } catch (Exception e) {
        	return new JsonResponse<>(false, null, e.getMessage());
        }
    }
}
