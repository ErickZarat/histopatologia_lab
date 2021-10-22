package histopatologialab.login;

import histopatologialab.core.Role;
import histopatologialab.password.PasswordUtils;
import histopatologialab.usuario.controller.IUsuarioController;
import histopatologialab.usuario.dto.Usuario;
import org.tinylog.Logger;

import javax.servlet.http.HttpSession;

import static histopatologialab.core.Controllers.usuarioController;

import histopatologialab.core.Role;
import histopatologialab.core.RoleHandler;

import javax.servlet.http.HttpSession;

public class LoginController {

private final String ROLE_KEY = "user_role";

    public Boolean iniciarSession(String usuario, String password, HttpSession session) {
//    	return iniciarFallback(usuario, session);

    	IUsuarioController controller = usuarioController;
	    try {// validar que no exista un usuario con ese login
	        Usuario usuarioBD = controller.buscarUsuario(usuario).getData();
	    	if (!(usuarioBD == null))
	    	{	// usuario existe, validando password
	        	 boolean passwordMatch = PasswordUtils.verifyUserPassword(password, usuarioBD.getPasswordUsuario());
	            if(passwordMatch)
	            { System.out.println("El password ingresado es correcto.");

			    	Role role = Role.findBySlug(usuarioBD.getTipoUsuario());
			    	int codigoUsuario = usuarioBD.getCodUsuario().intValue();
			        crearSesion(session, usuario, codigoUsuario, role);
		    		return true;
	            } else {
	                System.out.println("El password ingresado no es correcto");
		    		return false;
	            }
	    	}
	    	else
	    	{ System.out.println("Usuario no Existe");
	    	  return false;	
	    	}	    			
		} catch (Exception e) {
			return false;
		}    	    	   	

    }

    public void crearSesion(HttpSession session, String usuario, int codigoUsuario, Role role) {
        session.setAttribute(ROLE_KEY, role.getSlug());
        session.setAttribute("usuario", usuario);
        session.setAttribute("codigousuario", codigoUsuario);
        session.setAttribute("role", role);
        session.setAttribute("sesionIniciada", true);
    }

    public void cerrarSesion(HttpSession session) {
        try {
        	if (session == null) return;
            	session.invalidate();

        } catch (IllegalStateException exception){
            Logger.warn("session already invalidated");
        }
    }
}
