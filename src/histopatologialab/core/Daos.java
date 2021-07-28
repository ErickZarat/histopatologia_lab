package histopatologialab.core;

import histopatologialab.consultas.dao.ExamenDaoImpl;
import histopatologialab.consultas.dao.IExamenDao;
import histopatologialab.diagnostico.dao.DiagnosticoDaoImpl;
import histopatologialab.diagnostico.dao.IDiagnosticoDao;
import histopatologialab.enfsistemica.dao.EnfSistemicaDaoImpl;
import histopatologialab.enfsistemica.dao.IEnfSistemicaDao;
import histopatologialab.biopsia.dao.BiopsiaDaoImpl;
import histopatologialab.biopsia.dao.IBiopsiaDao;
import histopatologialab.frote.dao.FroteDaoImpl;
import histopatologialab.frote.dao.IFroteDao;
import histopatologialab.informe.dao.IInformeDao;
import histopatologialab.informe.dao.InformeDaoImpl;
import histopatologialab.informe.dto.Informe;
import histopatologialab.medicamentos.dao.IMedicamentosDao;
import histopatologialab.medicamentos.dao.IPresentacionMedicamentosDao;
import histopatologialab.medicamentos.dao.MedicamentosDaoImpl;
import histopatologialab.medicamentos.dao.PresentacionMedicamentosDaoImpl;
import histopatologialab.pacientes.dao.IPacienteDao;
import histopatologialab.pacientes.dao.PacienteDaoImpl;
import histopatologialab.tincion.dao.ITincionDao;
import histopatologialab.tincion.dao.TincionDaoImpl;
import histopatologialab.tipopcionlesion.dao.IOpcionLesionDao;
import histopatologialab.tipopcionlesion.dao.OpcionLesionDaoImpl;
import histopatologialab.usuario.dao.IUsuarioDao;
import histopatologialab.usuario.dao.UsuarioDaoImpl;

public class Daos {

    public static IMedicamentosDao medicamentosDao = new MedicamentosDaoImpl();
    public static IPresentacionMedicamentosDao presentacionDao = new PresentacionMedicamentosDaoImpl();
    public static IEnfSistemicaDao enfsistemicaDao = new EnfSistemicaDaoImpl();
    public static IOpcionLesionDao opcionlesionDao = new OpcionLesionDaoImpl();
    public static IPacienteDao pacienteDao = new PacienteDaoImpl();
    public static IUsuarioDao usuarioDao = new UsuarioDaoImpl();
    public static IDiagnosticoDao diagnosticoDao = new DiagnosticoDaoImpl();
    public static IExamenDao examenDao = new ExamenDaoImpl();
    public static IBiopsiaDao biopsiaDao = new BiopsiaDaoImpl();
    public static IFroteDao froteDao = new FroteDaoImpl();
    public static ITincionDao tincionDao = new TincionDaoImpl();
    public static IInformeDao informeDao = new InformeDaoImpl();
}
