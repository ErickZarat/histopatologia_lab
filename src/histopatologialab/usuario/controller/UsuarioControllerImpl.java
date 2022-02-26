package histopatologialab.usuario.controller;

import histopatologialab.core.Controllers;
import histopatologialab.core.Estado;
import histopatologialab.core.JsonResponse;
import histopatologialab.password.PasswordUtils;
import histopatologialab.usuario.dao.IUsuarioDao;
import histopatologialab.usuario.dto.Usuario;

import java.time.LocalDate;
import java.util.List;

public class UsuarioControllerImpl implements IUsuarioController{
	
	
	private final IUsuarioDao usuariosDao; 

	
	public UsuarioControllerImpl(IUsuarioDao usuariosDao) {
		this.usuariosDao = usuariosDao;
	}
	
	
	@Override 
	public JsonResponse<Usuario> crearUsuario(String loginUsuario, String passUser, String nombresDoctor, String apellidosDoctor, String emailDoctor, String colegiadoDoctor, String tipoUsuario, String usuarioCreado) {
	    try {// validar que no exista un usuario con ese login	    	
	    	if (usuariosDao.getUsuario(loginUsuario) == null)
	    	{	//encriptando el psw
	    		 String passwordSegura = PasswordUtils.generateSecurePassword(passUser);
	    		String valor = "";
	    		Usuario usuario = new Usuario(null, loginUsuario, passwordSegura, valor, nombresDoctor, apellidosDoctor , colegiadoDoctor, emailDoctor, tipoUsuario,  Estado.HABILITADO.getSlug(), LocalDate.now(), usuarioCreado, null,null  ) ;
	    		System.out.println("antes de crearlo en la base de datos");
	    		usuario = usuariosDao.guardarUsuario(usuario);
	    		return new JsonResponse<>(usuario != null, usuario);
	    	}
	    	else
	    	{ System.out.println("ya existe el usuario");
	    		return new JsonResponse<>(false,null , "Ya existe un usuario con ese login");
	    	}	    			
		} catch (Exception e) {
			return new JsonResponse<>(false, null, e.getMessage());
		}
		
	}
	
	
	@Override 
	public JsonResponse<Usuario> modificarUsuario(String loginUsuario, String nombresDoctor, String apellidosDoctor, String emailDoctor, String colegiadoDoctor, String tipoUsuario, String usuarioMod) {
   	 try {	
   		 Usuario usuario = usuariosDao.getUsuario(loginUsuario); 
   		 usuario.setNombresDoctor(nombresDoctor);
   		 usuario.setApellidosDoctor(apellidosDoctor);
   		 usuario.setEmailUsuario(emailDoctor);
   		 usuario.setModificadoPor(usuarioMod);
   		 usuario.setTipoUsuario(tipoUsuario);
   		 usuario.setNumColegiado(colegiadoDoctor);
   		 usuario.setFechaModificacion(LocalDate.now());
   		 usuario = usuariosDao.modificarUsuario(usuario);
   		 return new JsonResponse<>(usuario != null, usuario);
   		 
     } catch (Exception e) {
    	 return new JsonResponse<>(false, null, e.getMessage());
     }   
	}
	
	
	@Override 
	public JsonResponse<Boolean> darBajaUsuario( String loginUsuario, String usuarioMod) {
		Boolean success = usuariosDao.darDeBaja(loginUsuario, usuarioMod);
		return new JsonResponse<>(success, success);
	}
	
	
	@Override 
	public JsonResponse<List<Usuario>> getUsuarios(){
		List<Usuario> usuarios = usuariosDao.getUsuarios();
		return new JsonResponse<>(usuarios != null, usuarios);
	}
	
	@Override 
	public JsonResponse<Usuario> buscarUsuario(String loginUsuario) {
		Usuario usuarios = usuariosDao.getUsuario(loginUsuario);
		return new JsonResponse<>(usuarios != null, usuarios);
	}

	@Override
	public JsonResponse<Usuario> getUsuario(Long codUsuario) {
		Usuario usuarios = usuariosDao.getUsuario(codUsuario);
		return new JsonResponse<>(usuarios != null, usuarios);
	}


	@Override 
	public JsonResponse<Usuario> reinicioPswUsuario(String loginUsuario, String usuarioMod)
	{try {// buscar el usuario con esos datos en la base de datos
		Usuario usuario = usuariosDao.getUsuario(loginUsuario); 
    	if (usuario == null)
    	{	System.out.println("no existe el usuario");
    		return new JsonResponse<>(false, null, "No se pudo obtener la informaci�n del usuario");
    	}
    	else
    	{ System.out.println("si existe el usuario");
  		//generando el psw del login
  		 String passwordSegura = PasswordUtils.generateSecurePassword(loginUsuario);
  		 usuario.setPasswordUsuario(passwordSegura);
   		 usuario.setModificadoPor(usuarioMod);
  		 usuario.setFechaModificacion(LocalDate.now());
  		 usuario = usuariosDao.modificarUsuario(usuario);
   		 return new JsonResponse<>(usuario != null, usuario);
    	}	    			
	} catch (Exception e) {
		return new JsonResponse<>(false, null, e.getMessage());
	}		
	}

	@Override 
	public JsonResponse<Usuario> cambioPswUsuario(String loginUsuario, String pswAnterior, String pswActual)
	{try {// buscar el usuario con esos datos en la base de datos
		Usuario usuario = usuariosDao.getUsuario(loginUsuario); 
    	if (usuario == null)
    	{	System.out.println("no existe el usuario");
    		return new JsonResponse<>(false, null, "No se pudo obtener la informaci�n del usuario");
    	}
    	else
    	{ System.out.println("si existe el usuario");
  			//validaci�n del psw anterior
    		String genPswAnterior = PasswordUtils.generateSecurePassword(pswAnterior);
    		// comparar los dos psw     		
    		if (!( usuario.getPasswordUsuario().equals(genPswAnterior)))
    		{	System.out.println("contrase�a actual no es la correcta");
    			return new JsonResponse<>(false, null, "La contrase�a actual no es la correcta");
    		} else {    			
    			// si se cambia el psw 	    	
		  		 String passwordSegura = PasswordUtils.generateSecurePassword(pswActual);
		  		 if (( usuario.getPasswordUsuario().equals(passwordSegura)))
		  		 {  System.out.println("nueva y la contrase�a actual iguales");
		  			 return new JsonResponse<>(false, null, "La contrase�a nueva y la contrase�a actual no pueden ser iguales");		 
		  		 } else {  // si se actualiza el psw
		  			System.out.println("si se cambio de psw");
			  		 usuario.setPasswordUsuario(passwordSegura);
			   		 usuario.setModificadoPor(loginUsuario);
			  		 usuario.setFechaModificacion(LocalDate.now());
			  		 usuario = usuariosDao.modificarUsuario(usuario);
			   		 return new JsonResponse<>(usuario != null, usuario);
		  		 }
    		}    			   		 
    	}	    			
	} catch (Exception e) {
		return new JsonResponse<>(false, null, e.getMessage());
	}		
	}
	
	@Override 
	public JsonResponse<Boolean> cambiaEstadoUsuario(String loginUsuario, String estado, String usuariomod)
	{	Boolean success = usuariosDao.cambioEstadoUsuario(loginUsuario, estado, usuariomod);
    	return new JsonResponse<Boolean>(success, success);
		
	}
	
}

//class Main {
//	public static void main(String[] args) {
//		Controllers.usuarioController.crearUsuario("admin","admin", "admin", "admin", "doc@admin.com", "0000", "ADM", "" );
//	}
//}
