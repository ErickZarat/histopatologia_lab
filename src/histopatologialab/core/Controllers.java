package histopatologialab.core;

import histopatologialab.medicamentos.controller.IMedicamentosController;
import histopatologialab.medicamentos.controller.MedicamentosControllerImpl;

import static histopatologialab.core.Daos.medicamentosDao;
import static histopatologialab.core.Daos.presentacionDao;

public class Controllers {

    public static IMedicamentosController medicamentosController = new MedicamentosControllerImpl(medicamentosDao, presentacionDao);

}
