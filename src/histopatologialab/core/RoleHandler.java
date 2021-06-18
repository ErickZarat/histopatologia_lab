package histopatologialab.core;

import org.tinylog.Logger;

import javax.servlet.http.HttpSession;

public class RoleHandler {
    public static RoleHandler roleHandler;
    private HttpSession session;
    private final String ROLE_KEY = "user_role";

    private RoleHandler(HttpSession session) {
        this.session = session;
    }

    public static RoleHandler getInstance(HttpSession session){
        if (roleHandler == null){
            roleHandler = new RoleHandler(session);
        }
        return roleHandler;
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
