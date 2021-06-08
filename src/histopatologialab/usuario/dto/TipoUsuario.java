package histopatologialab.usuario.dto;

public enum TipoUsuario {
	 ADMINISTRADOR("ADM","Administrador"),
	 DOCTOR("DTR","Doctor"),
	 ADMINISTRATIVO("USR","Administrativo");

	private final String codigo;
	private final String nombre;
	
	private TipoUsuario(String codigo, String nombre) {
			this.codigo = codigo;
			this.nombre = nombre;
	}
	
	 
	public String getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}

	
}
