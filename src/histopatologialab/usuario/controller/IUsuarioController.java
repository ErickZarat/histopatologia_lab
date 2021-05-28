package histopatologialab.usuario.controller;

import java.util.List;
import histopatologialab.usuario.dto.Usuario;

public interface IUsuarioController {

	Usuario crearUsuario(String loginUsuario, String passUser,  String nombresDoctor, String apellidosDoctor, String emailDoctor, String colegiadoDoctor, String tipoUsuario, String usuarioCreado); 
	Usuario modificarUsuario(String loginUsuario, String nombresDoctor, String apellidosDoctor, String emailDoctor, String colegiadoDoctor, String tipoUsuario, String usuarioMod);
	Boolean darBajaUsuario( String loginUsuario, String usuarioMod);
	List<Usuario> getUsuarios();
	Usuario buscarUsuario(String loginUsuario);
	Usuario reinicioPswUsuario(String loginUsuario, String usuarioMod);
}
