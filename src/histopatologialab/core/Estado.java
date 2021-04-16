package histopatologialab.core;

public enum Estado {
    HABILITADO("H"),
    DESHABILITADO("D");

    private String slug;

    private Estado(String slug) {
        this.slug = slug;
    }

    public String getSlug() {
        return slug;
    }

    public Estado getEstadoFromSlug(String slug) {
        if (slug.equals(DESHABILITADO.slug)) {
            return DESHABILITADO;
        } else {
            return HABILITADO;
        }
    }
}
