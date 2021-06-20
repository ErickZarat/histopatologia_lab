package histopatologialab.usuario.dao;

import histopatologialab.core.DB;
import histopatologialab.core.Estado;
import histopatologialab.core.db.tables.LabUsuario;
import histopatologialab.core.db.tables.records.LabUsuarioRecord;
import histopatologialab.usuario.dto.Usuario;
import org.jooq.DSLContext;
import org.jooq.Record;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


public class UsuarioDaoImpl implements IUsuarioDao{

    private final DSLContext query = DB.getConexion();
    private final LabUsuario tabla = LabUsuario.LAB_USUARIO; 
	
	
    public Usuario parseItem(Record record) {
    	return new Usuario(
    		record.getValue(tabla.COD_USUARIO),
    		record.getValue(tabla.LOGIN_USUARIO),
    		record.getValue(tabla.PASSWORD),
    		record.getValue(tabla.LLAVE),
    		record.getValue(tabla.NOMBRES_DOCTOR), 
    		record.getValue(tabla.APELLIDOS_DOCTOR) ,
    		record.getValue(tabla.NUM_COLEGIADO),
    		record.getValue(tabla.EMAILUSUARIO), 
    		record.getValue(tabla.TIPO_USUARIO), 
    		record.getValue(tabla.ESTADO), 
            record.getValue(tabla.FECHACREACION),
            record.getValue(tabla.CREADOPOR),
            record.getValue(tabla.MODIFICADOPOR),
            record.getValue(tabla.FECHAMODIFICACION) 	
    	);    			
    }
    
    @Override
	 public List<Usuario> getUsuarios(){
    	List<Record> results = query
                .select(tabla.asterisk())
                .from(tabla)
                .fetch();
        return results.stream().map(this::parseItem).collect(Collectors.toList());
		 
	 }
	
    @Override
    public List<Usuario> getUsuariosAlta(){
    	List<Record> results = query
                .select(tabla.asterisk())
                .from(tabla)
                .where(tabla.ESTADO.notEqualIgnoreCase(Estado.DESHABILITADO.getSlug()))
                .fetch();
        return results.stream().map(this::parseItem).collect(Collectors.toList()); 
	 }
	 
    @Override
     public Usuario getUsuario(String loginUsuario) {
        Record result = query
                .select(tabla.asterisk())
                .from(tabla)
                .where(tabla.LOGIN_USUARIO.equal(loginUsuario))
                .fetchOne();
		//System.out.println(loginUsuario);
		//System.out.println(result);
        return result != null ? parseItem(result): null;
	 }
	 
    
    @Override
	 public Usuario guardarUsuario(Usuario usuario) {
        //System.out.println("guardando el usuario antes ");
    	LabUsuarioRecord record =  query.newRecord(tabla);
    	record.setLoginUsuario(usuario.getLoginUsuario());
		record.setNombresDoctor(usuario.getNombresDoctor());
		record.setApellidosDoctor(usuario.getApellidosDoctor());
		record.setNumColegiado(usuario.getNumColegiado());
		record.setPassword(usuario.getPasswordUsuario());
		record.setLlave(usuario.getLlave());
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
    	query.update(tabla)
        .set(tabla.NOMBRES_DOCTOR, usuario.getNombresDoctor())
        .set(tabla.APELLIDOS_DOCTOR, usuario.getApellidosDoctor())
        .set(tabla.EMAILUSUARIO, usuario.getEmailUsuario())
        .set(tabla.PASSWORD, usuario.getPasswordUsuario())
        .set(tabla.TIPO_USUARIO, usuario.getTipoUsuario())
        .set(tabla.NUM_COLEGIADO, usuario.getNumColegiado())
        .set(tabla.FECHAMODIFICACION, LocalDate.now())
        .set(tabla.MODIFICADOPOR, usuario.getModificadoPor())
        .set(tabla.ESTADO, usuario.getEstado())
        .where(tabla.LOGIN_USUARIO.eq(usuario.getLoginUsuario()))
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
