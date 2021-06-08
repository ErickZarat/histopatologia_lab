package histopatologialab.tipopcionlesion.dto;

public enum TipOpcion {
  COLOR ("COLOR","Color Lesion"),
  NATURALEZA ("NATURALEZA","Naturaleza de la Lesion"),
  SINTOMA("SINTOMA","Sintomas"),
  FORMA("FORMA","Forma de la Lesion"),
  SUPERFICIE("SUPERFICIE","Superficie de la Lesion"),
  CONSISTENCIA("CONSISTENCIA","Consistencia de la Lesion"),
  INTRA("INTRAOSEO","Es Intraoseo"),
  PIEZA("PIEZA","Asociado a pieza dental"),
  PROCEDIMIENTO("PROCEDIMIENTO","Procedimiento Biopsia");
  
	private final String codigo;
	private final String nombre;

  private TipOpcion(String codigo, String nombre) {
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
