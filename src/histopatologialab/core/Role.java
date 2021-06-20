package histopatologialab.core;

import java.util.Arrays;

public enum Role {
    ADMIN("ADM"),
    DOCTOR("DTR"),
    NORMAL("USR");

    private String slug;

    Role(String slug) {
        this.slug = slug;
    }

    public String getSlug() {
        return slug;
    }

    public static Role findBySlug(String slug){
        return Arrays.stream(
                values()).filter(p -> p.slug.equals(slug))
                .findFirst()
                .orElse(Role.NORMAL);
    }
}
