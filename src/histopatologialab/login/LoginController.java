package histopatologialab.login;
import static histopatologialab.core.Controllers.usuarioController;

import java.time.LocalDate;

import histopatologialab.core.Estado;
import histopatologialab.password.PasswordUtils;
import histopatologialab.usuario.dto.Usuario;
import histopatologialab.usuario.controller.IUsuarioController;

public class LoginController {

    public Boolean iniciarSession(String usuario, String password) {
        //agregar logica del login
    	
    	////return true;
    	IUsuarioController controller = usuarioController; 
	    try {// validar que no exista un usuario con ese login
	    	 System.out.println(usuario);
	        Usuario usuarioBD = controller.buscarUsuario(usuario);
	        System.out.println("usaurio devuelto");
	        System.out.println(usuarioBD);
	    	if (!(usuarioBD == null))
	    	{	// usuario existe, validando password
	    		String salt = "HISTOPATOLOGIA2021" ; //usuarioBD.getLlave(); 
	    		//System.out.println(salt);
	            boolean passwordMatch = PasswordUtils.verifyUserPassword(password, usuarioBD.getPasswordUsuario(), salt);
	            if(passwordMatch) 
	            { System.out.println("Provided  password is correct.");
		    		return true; 
	            } else {
	                System.out.println("Provided password is incorrect");
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
