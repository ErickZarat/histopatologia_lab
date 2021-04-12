package histopatologialab.core;

import histopatologialab.medicamentos.dao.IMedicamentosDao;
import histopatologialab.medicamentos.dao.IPresentacionMedicamentosDao;
import histopatologialab.medicamentos.dao.MedicamentosDaoImpl;
import histopatologialab.medicamentos.dao.PresentacionMedicamentosDaoImpl;

public class Daos {

    public static IMedicamentosDao medicamentosDao = new MedicamentosDaoImpl();
    public static IPresentacionMedicamentosDao presentacionDao = new PresentacionMedicamentosDaoImpl();

}
