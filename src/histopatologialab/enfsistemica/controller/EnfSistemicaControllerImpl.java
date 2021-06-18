package histopatologialab.enfsistemica.controller;


import java.time.LocalDate;
import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Bool;
import histopatologialab.core.Estado;
import histopatologialab.core.JsonResponse;
import histopatologialab.enfsistemica.dao.IEnfSistemicaDao;
import histopatologialab.enfsistemica.dto.EnfSistemica;


public class EnfSistemicaControllerImpl implements IEnfSistemicaController {


    private final IEnfSistemicaDao enfermedadesDao;

    public EnfSistemicaControllerImpl(IEnfSistemicaDao enfermedadesDao) {
        this.enfermedadesDao = enfermedadesDao;
    }

    @Override
    public JsonResponse<EnfSistemica> crearEnfermedad(String nombre, String usuario) {
        try {
            EnfSistemica enfermedad = new EnfSistemica(0, nombre, Estado.HABILITADO.getSlug(), usuario, LocalDate.now(), null, null);
            enfermedad = enfermedadesDao.guardarEnfermedad(enfermedad);
            return new JsonResponse<EnfSistemica>(enfermedad != null, enfermedad);
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public JsonResponse<EnfSistemica> modificarEnfermedad(int codigo, String nombre, String usuario) {
        try {
            EnfSistemica enfermedad = enfermedadesDao.getEnfermedad(codigo);
            enfermedad.setNombreEnfermedad(nombre);
            enfermedad.setModificadoPor(usuario);
            enfermedad.setFechaModificacion(LocalDate.now());

            enfermedad = enfermedadesDao.modificarEnfermedad(enfermedad);

            return new JsonResponse<EnfSistemica>(enfermedad != null, enfermedad);
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public JsonResponse<Boolean> darBajaEnfermedad(int codigo, String usuario) {
        Boolean success = enfermedadesDao.darDeBaja(codigo, usuario);
        return new JsonResponse<Boolean>(success, success);
    }

    @Override
    public JsonResponse<Boolean> cambiaEstadoEnfermedad(int codigo, String estado, String usuario) {
        Boolean success = enfermedadesDao.cambioEstadoEnfermedad(codigo, estado, usuario);
        return new JsonResponse<Boolean>(success, success);
    }

    @Override
    public JsonResponse<List<EnfSistemica>> getEnfermedadesSistemicas() {
        List<EnfSistemica> enfermedades = enfermedadesDao.getEnfermedades();
        return new JsonResponse<List<EnfSistemica>>(enfermedades != null, enfermedades);

    }

}
