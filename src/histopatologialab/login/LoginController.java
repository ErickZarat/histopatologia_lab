package histopatologialab.login;

import histopatologialab.core.Role;
import histopatologialab.password.PasswordUtils;
import histopatologialab.usuario.controller.IUsuarioController;
import histopatologialab.usuario.dto.Usuario;
import org.tinylog.Logger;

import javax.servlet.http.HttpSession;

import static histopatologialab.core.Controllers.usuarioController;

public class LoginController {

    private final String ROLE_KEY = "user_role";

    public Boolean iniciarFallback(String usuario, HttpSession session){
        String db = "ADM";

        Role role = Role.findBySlug(db);

//		Role role = Role.ADMIN; //TODO: cambiar esto por el rol de la base de datos
		crearSesion(session, usuario, 1, role);
		return true;
	}

    public Boolean iniciarSession(String usuario, String password, HttpSession session) {

    	return iniciarFallback(usuario, session);

//    	IUsuarioController controller = usuarioController;
//	    try {// validar que no exista un usuario con ese login
//	        Usuario usuarioBD = controller.buscarUsuario(usuario).getData();
//	    	if (!(usuarioBD == null))
//	    	{	// usuario existe, validando password
//	        	 boolean passwordMatch = PasswordUtils.verifyUserPassword(password, usuarioBD.getPasswordUsuario());
//	            if(passwordMatch)
//	            { System.out.println("El password ingresado es correcto.");
//
//                    Role role = Role.ADMIN; //TODO: cambiar esto por el rol de la base de datos
//                    crearSesion(session, usuario, role);
//		    		return true;
//	            } else {
//	                System.out.println("El password ingresado no es correcto");
//		    		return false;
//	            }
//	    	}
//	    	else
//	    	{ System.out.println("Usuario no Existe");
//	    	  return false;
//	    	}
//		} catch (Exception e) {
//			return false;
//		}

    }

    public void crearSesion(HttpSession session, String usuario, int userId, Role role) {
        session.setAttribute(ROLE_KEY, role.getSlug());
        session.setAttribute("usuario", usuario);
        session.setAttribute("idUsuario", userId);
        session.setAttribute("sesionIniciada", true);
    }

    public void cerrarSesion(HttpSession session) {
        try {
        	System.out.println("Cerrando sesion"); 
            if (session == null) return;
            session.invalidate();
        } catch (IllegalStateException exception){
            Logger.warn("session already invalidated");
        }
    }
}
