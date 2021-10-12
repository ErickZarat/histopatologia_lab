package histopatologialab.medicamentos.dto;

public enum TipoMedicamento {
    ANTIBIOTICO(1, "Antibi�tico"),
    ANALGESICO(2, "Analg�sico"),
    ANTIINFECCIOSO(3, "Antiinfeccioso"),
    ANTIINFLAMATORIO(4, "Antiinflamatorio"),
    ANESTESICO(5,"Anest�sico"),
    ANTIALERGICO(6,"Antial�rgico"),
    ANTIPIRETICO(7,"Antipir�tico");

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
