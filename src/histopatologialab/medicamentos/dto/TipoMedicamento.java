package histopatologialab.medicamentos.dto;

public enum TipoMedicamento {
    ANTIBIOTICOS(1, "Antibioticos"),
    ANALGESICOS(2, "Analgésicos"),
    ANTIINFECCIOSOS(3, "Antiinfecciosos"),
    ANTIINFLAMATORIOS(4, "Antiinflamatorios")
    ;

    private final int codigo;
    private final String nombre;

    @Override
    public String toString() {
        return codigo + " " + nombre;
    }

    private TipoMedicamento(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
}
