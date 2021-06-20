package histopatologialab.usuario.dao;


import histopatologialab.usuario.dto.Usuario;

import java.util.List;

public interface IUsuarioDao {
 
	 List<Usuario> getUsuarios(); 
	 List<Usuario> getUsuariosAlta();
	 Usuario getUsuario(String loginUsuario);
	 Usuario guardarUsuario(Usuario usuario);
	 Usuario modificarUsuario(Usuario usuario);
	 Boolean darDeBaja(String loginUsuario, String usuario);
	
	
}
