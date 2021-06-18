package histopatologialab.login;
import static histopatologialab.core.Controllers.usuarioController;

import java.time.LocalDate;

import histopatologialab.core.Estado;
import histopatologialab.password.PasswordUtils;
import histopatologialab.usuario.dto.Usuario;
import histopatologialab.usuario.controller.IUsuarioController;

import histopatologialab.core.Role;
import histopatologialab.core.RoleHandler;

import javax.servlet.http.HttpSession;

public class LoginController {

    private final String ROLE_KEY = "user_role";

    public Boolean iniciarSession(String usuario, String password) {

    	IUsuarioController controller = usuarioController; 
	    try {// validar que no exista un usuario con ese login
	        Usuario usuarioBD = controller.buscarUsuario(usuario);
	    	if (!(usuarioBD == null))
	    	{	// usuario existe, validando password
	        	 boolean passwordMatch = PasswordUtils.verifyUserPassword(password, usuarioBD.getPasswordUsuario());
	            if(passwordMatch) 
	            { System.out.println("El password ingresado es correcto.");

                    Role role = Role.NORMAL; //TODO: cambiar esto por el rol de la base de datos
                    crearSesion(session, usuario, role);
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

    public void crearSesion(HttpSession session, String usuario, Role role) {
        session.setAttribute(ROLE_KEY, role.getSlug());
        session.setAttribute("usuario", usuario);
        session.setAttribute("sesionIniciada", true);
    }

    public void cerrarSesion(HttpSession session) {
        if (session == null) return;
        session.invalidate();
    }
}
