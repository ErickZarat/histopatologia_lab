package histopatologialab.usuario.controller;

import java.util.List;

import histopatologialab.core.JsonResponse;
import histopatologialab.usuario.dto.Usuario;

public interface IUsuarioController {
	JsonResponse<Usuario> crearUsuario(String loginUsuario, String passUser, String nombresDoctor, String apellidosDoctor, String emailDoctor, String colegiadoDoctor, String tipoUsuario, String usuarioCreado);
	JsonResponse<Usuario> modificarUsuario(String loginUsuario, String nombresDoctor, String apellidosDoctor, String emailDoctor, String colegiadoDoctor, String tipoUsuario, String usuarioMod);
	JsonResponse<Boolean> darBajaUsuario(String loginUsuario, String usuarioMod);
	JsonResponse<List<Usuario>> getUsuarios();
	JsonResponse<Usuario> buscarUsuario(String loginUsuario);
	JsonResponse<Usuario> reinicioPswUsuario(String loginUsuario, String usuarioMod);
}
