package histopatologialab.usuario.controller;

import java.time.LocalDate;
import java.util.List;
import histopatologialab.core.Estado;
import histopatologialab.core.JsonResponse;
import histopatologialab.usuario.dto.Usuario;
import histopatologialab.usuario.dao.IUsuarioDao;
import histopatologialab.password.PasswordUtils;

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
	    		// String salt = PasswordUtils.getSalt(30);
	    		// String passwordSegura = PasswordUtils.generateSecurePassword(passUser, salt);
	    		 String passwordSegura = PasswordUtils.generateSecurePassword(passUser);
	    		 System.out.println(passwordSegura);   
	    		// System.out.println(salt);
	    		String valor = "";
	    		Usuario usuario = new Usuario(null, loginUsuario, passwordSegura, valor, nombresDoctor, apellidosDoctor , colegiadoDoctor, emailDoctor, tipoUsuario,  Estado.HABILITADO.getSlug(), LocalDate.now(), usuarioCreado, null,null  ) ;
	    		System.out.println("antes de crearlo en la base de datos");
	    		System.out.println(usuario.getLoginUsuario());
	    		usuario = usuariosDao.guardarUsuario(usuario);
	    		return new JsonResponse<>(usuario != null, usuario);
	    	}
	    	else
	    	{ System.out.println("ya existe el usuario");
	    	  return null;	
	    	}	    			
		} catch (Exception e) {
			return null;
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
   		 usuario.setFechaModificacion(LocalDate.now());
   		 usuario = usuariosDao.modificarUsuario(usuario);
   		 return new JsonResponse<>(usuario != null, usuario);
   		 
     } catch (Exception e) {
         return null;
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
	public JsonResponse<Usuario> reinicioPswUsuario(String loginUsuario, String usuarioMod)
	{try {// buscar el usuario con esos datos en la base de datos
		Usuario usuario = usuariosDao.getUsuario(loginUsuario); 
    	if (usuario == null)
    	{	System.out.println("no existe el usuario");
  	  		return null;
    	}
    	else
    	{ System.out.println("si existe el usuario");
  		//generando el psw del login
  		 String passwordSegura = PasswordUtils.generateSecurePassword(loginUsuario);
  		 System.out.println(passwordSegura);   
  		 usuario.setPasswordUsuario(passwordSegura);
   		 usuario.setModificadoPor(usuarioMod);
  		 usuario.setFechaModificacion(LocalDate.now());
  		 usuario = usuariosDao.modificarUsuario(usuario);
   		 return new JsonResponse<>(usuario != null, usuario);
    	}	    			
	} catch (Exception e) {
		return null;
	}		
	}
	
	
}
