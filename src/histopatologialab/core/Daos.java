package histopatologialab.core;

import histopatologialab.consultas.dao.ExamenDaoImpl;
import histopatologialab.consultas.dao.IExamenDao;
import histopatologialab.medicamentos.dao.IMedicamentosDao;
import histopatologialab.medicamentos.dao.IPresentacionMedicamentosDao;
import histopatologialab.medicamentos.dao.MedicamentosDaoImpl;
import histopatologialab.medicamentos.dao.PresentacionMedicamentosDaoImpl;
import histopatologialab.opciones.dao.ITipoOpcionLesionDao;
import histopatologialab.opciones.dao.TipoOpcionLesionDaoImpl;

import histopatologialab.enfsistemica.dao.IEnfSistemicaDao;
import histopatologialab.enfsistemica.dao.EnfSistemicaDaoImpl;

import histopatologialab.tipopcionlesion.dao.IOpcionLesionDao;
import histopatologialab.tipopcionlesion.dao.OpcionLesionDaoImpl;

import histopatologialab.pacientes.dao.IPacienteDao;
import histopatologialab.pacientes.dao.PacienteDaoImpl;

import histopatologialab.usuario.dao.IUsuarioDao;
import histopatologialab.usuario.dao.UsuarioDaoImpl;

public class Daos {

    public static IMedicamentosDao medicamentosDao = new MedicamentosDaoImpl();
    public static IPresentacionMedicamentosDao presentacionDao = new PresentacionMedicamentosDaoImpl();
    public static IEnfSistemicaDao enfsistemicaDao = new EnfSistemicaDaoImpl();
    public static IOpcionLesionDao opcionlesionDao = new OpcionLesionDaoImpl();
    public static IPacienteDao pacienteDao = new PacienteDaoImpl();
    public static IUsuarioDao usuarioDao = new UsuarioDaoImpl();
    public static IExamenDao examenDao = new ExamenDaoImpl();

}
