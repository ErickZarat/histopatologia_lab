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

    public MedicamentosControllerImpl(IMedicamentosDao medicamentosDao, IPresentacionMedicamentosDao presentacionDao) {
        this.medicamentosDao = medicamentosDao;
        this.presentacionDao = presentacionDao;
    }

    @Override
    public Medicamento crearMedicamento(String nombre, int tipo, String usuario) {
        try {
            Medicamento medicamento = new Medicamento(0, nombre, "H", usuario, LocalDate.now(), null, null, tipo);
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
    public List<Medicamento> getMedicamentos(Integer tipoMedicamento) {
        return medicamentosDao.getMedicamentosByTipo(tipoMedicamento);
    }

    @Override
    public List<PresentacionMedicamento> getPresentaciones(int codigo) {
        try {
            return presentacionDao.getPresentaciones(codigo);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PresentacionMedicamento getPresentacion(int codigo, String tipoMedicamento) {
        try {
            return presentacionDao.getPresentacion(codigo, tipoMedicamento);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PresentacionMedicamento crearPresentacionMedicamento(PresentacionMedicamento presentacionMedicamento) {
        try {
            return presentacionDao.guardarPresentacion(presentacionMedicamento);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PresentacionMedicamento modificarPresentacionMedicamento(String tipoPresentacion, PresentacionMedicamento presentacionMedicamento) {
        try {
            return presentacionDao.modificarPresentacion(presentacionMedicamento.getCodMedicamento(), tipoPresentacion, presentacionMedicamento);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean darBajaPresentacion(int codigo, String tipoMedicamento, String usuario) {
        try {
            return presentacionDao.darBajaPresentacion(codigo, tipoMedicamento, usuario);
        } catch (Exception e) {
            return null;
        }
    }
}
