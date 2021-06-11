package histopatologialab.login;
import static histopatologialab.core.Controllers.usuarioController;

import java.time.LocalDate;

import histopatologialab.core.Estado;
import histopatologialab.password.PasswordUtils;
import histopatologialab.usuario.dto.Usuario;
import histopatologialab.usuario.controller.IUsuarioController;

public class LoginController {

    public Boolean iniciarSession(String usuario, String password) {

    	IUsuarioController controller = usuarioController; 
	    try {// validar que no exista un usuario con ese login
	        Usuario usuarioBD = controller.buscarUsuario(usuario);
	    	if (!(usuarioBD == null))
	    	{	// usuario existe, validando password
	        	 boolean passwordMatch = PasswordUtils.verifyUserPassword(password, usuarioBD.getPasswordUsuario());
	            if(passwordMatch) 
	            { System.out.println("El password ingresado es correcto.");
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
}
