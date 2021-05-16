package histopatologialab.usuario.controller;

import java.time.LocalDate;
import java.util.List;
import histopatologialab.core.Estado;
import histopatologialab.usuario.dto.Usuario;
import histopatologialab.usuario.dao.IUsuarioDao;

public class UsuarioControllerImpl implements IUsuarioController{
	
	
	private final IUsuarioDao usuariosDao; 

	
	public UsuarioControllerImpl(IUsuarioDao usuariosDao) {
		this.usuariosDao = usuariosDao;
	}
	
	
	@Override 
	public Usuario crearUsuario(String loginUsuario, String passUser, String nombresDoctor, String apellidosDoctor, String emailDoctor, String colegiadoDoctor, String tipoUsuario, String usuarioCreado) {
	    try {
		Usuario usuario = new Usuario(null, loginUsuario, passUser,nombresDoctor, apellidosDoctor , colegiadoDoctor, emailDoctor, tipoUsuario,  Estado.HABILITADO.getSlug(), LocalDate.now(), usuarioCreado, null,null  ) ;
		System.out.println("antes de crearlo en la base de datos");
		System.out.println(usuario.getLoginUsuario());
		return usuariosDao.guardarUsuario(usuario);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
	@Override 
	public Usuario modificarUsuario(String loginUsuario, String passUser, String nombresDoctor, String apellidosDoctor, String emailDoctor, String colegiadoDoctor, String tipoUsuario, String usuarioMod) {
   	 try {	
   		 Usuario usuario = usuariosDao.getUsuario(loginUsuario); 
   		 usuario.setNombresDoctor(nombresDoctor);
   		 usuario.setApellidosDoctor(apellidosDoctor);
   		 usuario.setPasswordUsuario(passUser);
   		 usuario.setEmailUsuario(emailDoctor);
   		 usuario.setModificadoPor(usuarioMod);
   		 usuario.setFechaModificacion(LocalDate.now());
   		 return usuariosDao.modificarUsuario(usuario);
   		 
     } catch (Exception e) {
         return null;
     }   
	}
	
	
	@Override 
	public Boolean darBajaUsuario( String loginUsuario, String usuarioMod) {
		return usuariosDao.darDeBaja(loginUsuario, usuarioMod);
	}
	
	
	@Override 
	public List<Usuario> getUsuarios(){
		return usuariosDao.getUsuarios();
		
	}
	
	@Override 
	public Usuario buscarUsuario(String loginUsuario) {
		return usuariosDao.getUsuario(loginUsuario);
	}
	
	
}
 