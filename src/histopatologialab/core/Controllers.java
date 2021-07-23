package histopatologialab.core;

import histopatologialab.consultas.controller.ConsultaControllerImpl;
import histopatologialab.consultas.controller.IConsultaController;
import histopatologialab.diagnostico.controller.DiagnosticoControllerImpl;
import histopatologialab.diagnostico.controller.IDiagnosticoController;
import histopatologialab.enfsistemica.controller.EnfSistemicaControllerImpl;
import histopatologialab.enfsistemica.controller.IEnfSistemicaController;
import histopatologialab.biopsia.controller.BiopsiaControllerImpl;
import histopatologialab.biopsia.controller.IBiopsiaController;
import histopatologialab.medicamentos.controller.IMedicamentosController;
import histopatologialab.medicamentos.controller.MedicamentosControllerImpl;
import histopatologialab.pacientes.controller.IPacienteController;
import histopatologialab.pacientes.controller.PacienteControllerImpl;
import histopatologialab.tipopcionlesion.controller.IOpcionLesionController;
import histopatologialab.tipopcionlesion.controller.OpcionLesionControllerImpl;
import histopatologialab.usuario.controller.IUsuarioController;
import histopatologialab.usuario.controller.UsuarioControllerImpl;

import static histopatologialab.core.Daos.*;

public class Controllers {

    public static IMedicamentosController medicamentosController = new MedicamentosControllerImpl(medicamentosDao, presentacionDao);
    public static IEnfSistemicaController enfsistemicaController = new EnfSistemicaControllerImpl(enfsistemicaDao);
    public static IOpcionLesionController opcionlesionController = new OpcionLesionControllerImpl(opcionlesionDao);
    public static IPacienteController pacienteController = new PacienteControllerImpl(pacienteDao);
    public static IUsuarioController usuarioController =  new UsuarioControllerImpl(usuarioDao);
    public static IDiagnosticoController diagnosticoController = new DiagnosticoControllerImpl(diagnosticoDao);
    public static IConsultaController consultaController = new ConsultaControllerImpl(opcionlesionDao);
    public static IBiopsiaController biopsiaController = new BiopsiaControllerImpl(biopsiaDao);

}
