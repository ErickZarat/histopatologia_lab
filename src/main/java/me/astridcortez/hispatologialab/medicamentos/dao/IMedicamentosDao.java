package me.astridcortez.hispatologialab.medicamentos.dao;

import me.astridcortez.hispatologialab.medicamentos.dto.Medicamento;

import java.util.List;

public interface IMedicamentosDao {
    List<Medicamento> getMedicamentos();

    List<Medicamento> getMedicamentos(int limit);

    List<Medicamento> getMedicamentos(int lastId, int limit);

    Medicamento getMedicamento(int codMedicamento);
    Medicamento guardarMedicamento(Medicamento medicamento);
    Medicamento modificarMedicamento(Medicamento medicamento);
    Boolean darDeBaja(int codMedicamento, String usuario);
}
