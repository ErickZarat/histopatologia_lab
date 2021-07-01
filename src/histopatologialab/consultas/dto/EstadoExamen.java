package histopatologialab.consultas.dto;

import histopatologialab.core.Role;

import java.util.Arrays;

public enum EstadoExamen {
    INGRESADA("Ingresada"),
    PENDIENTE_BIOPSIA("Pendiente Biopsia"),
    PENDIENTE_INFORME_BIOPSIA("Pendiente Informe Biopsa"),
    PENDIENTE_FROTE("Pendiente Frote"),
    PENDIENTE_INFORME_FROTE("Pendiente Informe Frote"),
    INFORME_BIOPSIA("Informe Biopsia"),
    INFORME_FROTE("Informe Frote"),
    FINALIZADA("Finalizada");

    private final String slug;

    EstadoExamen(String slug) {
        this.slug = slug;
    }

    public String getSlug() {
        return slug;
    }

    public static EstadoExamen findBySlug(String slug){
        return Arrays.stream(
                values()).filter(p -> p.slug.equals(slug))
                .findFirst()
                .orElse(EstadoExamen.INGRESADA);
    }
}
