package histopatologialab.enfsistemica.controller;

import java.util.List;
import histopatologialab.enfsistemica.dto.EnfSistemica;

public interface IEnfSistemicaController {
	
    EnfSistemica crearEnfermedad(String nombre, String usuario);
    EnfSistemica modificarEnfermedad(int codigo, String nombre, String usuario);
    Boolean darBajaEnfermedad(int codigo, String usuario);
    List<EnfSistemica> getEnfermedadesSistemicas();

    
    
}
