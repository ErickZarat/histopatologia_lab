package me.astridcortez.hispatologialab.medicamentos.dao;

import me.astridcortez.hispatologialab.medicamentos.dto.Medicamento;

import java.util.List;

public interface IMedicamentosDao {
    List<Medicamento> getMedicamentos();
    Medicamento getMedicamento(int codMedicamento);
    Medicamento guardarMedicamento(Medicamento medicamento);
    Medicamento modificarMedicamento(Medicamento medicamento);
    Boolean darDeBaja(int codMedicamento);
}
