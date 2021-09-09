package histopatologialab.medicamentos.dto;

public enum TipoMedicamento {
    ANTIBIOTICO(1, "Antibiótico"),
    ANALGESICO(2, "Analgésico"),
    ANTIINFECCIOSO(3, "Antiinfeccioso"),
    ANTIINFLAMATORIO(4, "Antiinflamatorio"),
    ANESTESICO(5,"Anestésico"),
    ANTIALERGICO(6,"Antialérgico"),
    ANTIPIRETICO(7,"Antipirético");

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
