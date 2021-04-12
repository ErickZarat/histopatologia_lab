package histopatologialab.medicamentos.controller;

import histopatologialab.medicamentos.dao.IMedicamentosDao;
import histopatologialab.medicamentos.dao.IPresentacionMedicamentosDao;
import histopatologialab.medicamentos.dto.Medicamento;
import histopatologialab.medicamentos.dto.PresentacionMedicamento;

import java.time.LocalDate;
import java.util.List;

public class MedicamentosControllerImpl implements IMedicamentosController {

    private final IMedicamentosDao medicamentosDao;
    private final IPresentacionMedicamentosDao presentacionDao;
    private final int paginationSize = 10;

    public MedicamentosControllerImpl(IMedicamentosDao medicamentosDao, IPresentacionMedicamentosDao presentacionDao) {
        this.medicamentosDao = medicamentosDao;
        this.presentacionDao = presentacionDao;
    }

    @Override
    public Medicamento crearMedicamento(String nombre, String tipo, String usuario) {
        try {
            Medicamento medicamento = new Medicamento(0, nombre, "habilitado", usuario, LocalDate.now(), null, null);
            return medicamentosDao.guardarMedicamento(medicamento);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Medicamento modificarMedicamento(int codigo, String nombre, String usuario) {
        try {
            Medicamento medicamento = medicamentosDao.getMedicamento(codigo);
            medicamento.setNombreMedicamento(nombre);
            medicamento.setModificadoPor(usuario);
            medicamento.setFechaModificacion(LocalDate.now());
            return medicamentosDao.modificarMedicamento(medicamento);

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean darBajaMedicamento(int codigo, String usuario) {
        return medicamentosDao.darDeBaja(codigo, usuario);
    }

    @Override
    public List<Medicamento> getMedicamentos(Integer lastCodigo) {
        if (lastCodigo == null) {
            return medicamentosDao.getMedicamentos(paginationSize);
        } else {
            return medicamentosDao.getMedicamentos(lastCodigo, paginationSize);
        }
    }

    @Override
    public List<PresentacionMedicamento> obtenerPresentaciones(int codigo) {
        try {
            return presentacionDao.getPresentaciones(codigo);
        } catch (Exception e) {
            return null;
        }
    }
}
