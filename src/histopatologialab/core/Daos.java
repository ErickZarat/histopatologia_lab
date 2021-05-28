package histopatologialab.core;

import histopatologialab.medicamentos.dao.IMedicamentosDao;
import histopatologialab.medicamentos.dao.IPresentacionMedicamentosDao;
import histopatologialab.medicamentos.dao.MedicamentosDaoImpl;
import histopatologialab.medicamentos.dao.PresentacionMedicamentosDaoImpl;

import histopatologialab.enfsistemica.dao.IEnfSistemicaDao;
import histopatologialab.enfsistemica.dao.EnfSistemicaDaoImpl;

import histopatologialab.tipopcionlesion.dao.IOpcionLesionDao;
import histopatologialab.tipopcionlesion.dao.OpcionLesionDaoImpl;

import histopatologialab.pacientes.dao.IPacienteDao;
import histopatologialab.pacientes.dao.PacienteDaoImpl;

import histopatologialab.usuario.dao.IUsuarioDao;
import histopatologialab.usuario.dao.UsuarioDaoImpl;

import histopatologialab.diagnostico.dao.IDiagnosticoDao;
import histopatologialab.diagnostico.dao.DiagnosticoDaoImpl;

public class Daos {

    public static IMedicamentosDao medicamentosDao = new MedicamentosDaoImpl();
    public static IPresentacionMedicamentosDao presentacionDao = new PresentacionMedicamentosDaoImpl();
    public static IEnfSistemicaDao enfsistemicaDao = new EnfSistemicaDaoImpl();
    public static IOpcionLesionDao opcionlesionDao = new OpcionLesionDaoImpl();
    public static IPacienteDao pacienteDao = new PacienteDaoImpl();
    public static IUsuarioDao usuarioDao = new UsuarioDaoImpl();
    public static IDiagnosticoDao diagnosticoDao = new DiagnosticoDaoImpl();
    
}
