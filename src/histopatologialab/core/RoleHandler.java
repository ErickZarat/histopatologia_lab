package histopatologialab.core;

import javax.servlet.http.HttpSession;

public class RoleHandler {
    public static RoleHandler roleHandler;
    private HttpSession session;
    private final String ROLE_KEY = "user_role";

    public RoleHandler(HttpSession session) {
        this.session = session;
    }

    public static void invalidte(){
        roleHandler = null;
    }

    private Role getRole() {
        String roleSlug = (String) this.session.getAttribute(ROLE_KEY);
        return Role.findBySlug(roleSlug);
    }

    private void setRole(Role role){
        this.session.getAttribute(role.getSlug());
    }

    public boolean isAdmin(){
        return this.getRole().equals(Role.ADMIN);
    }

    public boolean isDoctor(){
        return this.getRole().equals(Role.DOCTOR);
    }

    public boolean isNormal(){
        return this.getRole().equals(Role.NORMAL);
    }
}
