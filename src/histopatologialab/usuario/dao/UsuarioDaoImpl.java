package histopatologialab.usuario.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import histopatologialab.core.DB;
import histopatologialab.core.Estado;
import histopatologialab.core.db.tables.LabUsuario;
import histopatologialab.core.db.tables.records.LabUsuarioRecord;
import histopatologialab.usuario.dto.Usuario;
import org.jooq.DSLContext;
import org.jooq.Record;


public class UsuarioDaoImpl implements IUsuarioDao{

    private final DSLContext query = DB.getConexion();
    private final LabUsuario tablaUsuario = LabUsuario.LAB_USUARIO;
	
	
    public Usuario parseItem(Record record) {
    	return new Usuario(
    		record.getValue(tablaUsuario.COD_USUARIO),
    		record.getValue(tablaUsuario.LOGIN_USUARIO),
    		record.getValue(tablaUsuario.PASSWORD),
    		record.getValue(tablaUsuario.NOMBRES_DOCTOR),
    		record.getValue(tablaUsuario.APELLIDOS_DOCTOR) ,
    		record.getValue(tablaUsuario.NUM_COLEGIADO),
    		record.getValue(tablaUsuario.EMAILUSUARIO),
    		record.getValue(tablaUsuario.TIPO_USUARIO),
    		record.getValue(tablaUsuario.ESTADO),
            record.getValue(tablaUsuario.FECHACREACION),
            record.getValue(tablaUsuario.CREADOPOR),
            record.getValue(tablaUsuario.MODIFICADOPOR),
            record.getValue(tablaUsuario.FECHAMODIFICACION)
    	);    			
    }
    
    @Override
	 public List<Usuario> getUsuarios(){
    	List<Record> results = query
                .select(tablaUsuario.asterisk())
                .from(tablaUsuario)
                .fetch();
        return results.stream().map(this::parseItem).collect(Collectors.toList());
		 
	 }
	 
	 
    @Override
     public Usuario getUsuario(String loginUsuario) {
        Record result = query
                .select(tablaUsuario.asterisk())
                .from(tablaUsuario)
                .where(tablaUsuario.LOGIN_USUARIO.equal(loginUsuario))
                .fetchOne();
		System.out.println(loginUsuario);
		System.out.println(result);
        return result != null ? parseItem(result): null;
	 }
	 
    
    @Override
	 public Usuario guardarUsuario(Usuario usuario) {
        //System.out.println("guardando el usuario antes ");
    	LabUsuarioRecord record =  query.newRecord(tablaUsuario);
    	record.setLoginUsuario(usuario.getLoginUsuario());
		record.setNombresDoctor(usuario.getNombresDoctor());
		record.setApellidosDoctor(usuario.getApellidosDoctor());
		record.setNumColegiado(usuario.getNumColegiado());
		record.setPassword(usuario.getPasswordUsuario());
        record.setEstado(usuario.getEstado());
		record.setEmailusuario(usuario.getEmailUsuario());
		record.setTipoUsuario(usuario.getTipoUsuario());
        record.setFechacreacion(LocalDate.now());
        record.setCreadopor(usuario.getCreadoPor());
        record.store();
        //System.out.println("guardando el usuario despues ");
        return getUsuario(record.getLoginUsuario());
	 }
	 
    @Override
	 public Usuario modificarUsuario(Usuario usuario) {
    	query.update(tablaUsuario)
        .set(tablaUsuario.NOMBRES_DOCTOR, usuario.getNombresDoctor())
        .set(tablaUsuario.APELLIDOS_DOCTOR, usuario.getApellidosDoctor())
        .set(tablaUsuario.EMAILUSUARIO, usuario.getEmailUsuario())
        .set(tablaUsuario.TIPO_USUARIO, usuario.getTipoUsuario())
        .set(tablaUsuario.FECHAMODIFICACION, LocalDate.now())
        .set(tablaUsuario.MODIFICADOPOR, usuario.getModificadoPor())
        .set(tablaUsuario.ESTADO, usuario.getEstado())
        .where(tablaUsuario.LOGIN_USUARIO.eq(usuario.getLoginUsuario()))
        .execute();
        return getUsuario(usuario.getLoginUsuario());
	 }
	 
    
	 public Boolean darDeBaja(String loginUsuario, String usuariomod) {
		 Usuario usuario = getUsuario(loginUsuario);
		 
		 usuario.setModificadoPor(usuariomod);
		 usuario.setFechaModificacion(LocalDate.now());
		 usuario.setEstado(Estado.DESHABILITADO.getSlug());
		 Usuario usuariomodificado = modificarUsuario(usuario); 
		 return usuariomodificado != null;
	 }
}
