package me.astridcortez.hispatologialab.medicamentos.controller;

import me.astridcortez.hispatologialab.medicamentos.dto.Medicamento;
import me.astridcortez.hispatologialab.medicamentos.dto.PresentacionMedicamento;

import java.util.List;

public interface IMedicamentosController {
    Medicamento crearMedicamento(String nombre, String tipo, String usuario);
    Medicamento modificarMedicamento(int codigo, String nombre, String usuario);

    List<PresentacionMedicamento> obtenerPresentaciones(int codigo);

}
