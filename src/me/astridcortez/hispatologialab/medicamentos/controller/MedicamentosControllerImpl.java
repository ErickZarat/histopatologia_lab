package me.astridcortez.hispatologialab.medicamentos.controller;

import me.astridcortez.hispatologialab.medicamentos.dao.IMedicamentosDao;
import me.astridcortez.hispatologialab.medicamentos.dao.IPresentacionMedicamentosDao;
import me.astridcortez.hispatologialab.medicamentos.dto.Medicamento;
import me.astridcortez.hispatologialab.medicamentos.dto.PresentacionMedicamento;

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
    public List<PresentacionMedicamento> obtenerPresentaciones(int codigo) {
        try {
            return presentacionDao.getPresentaciones(codigo);
        } catch (Exception e) {
            return null;
        }
    }
}
