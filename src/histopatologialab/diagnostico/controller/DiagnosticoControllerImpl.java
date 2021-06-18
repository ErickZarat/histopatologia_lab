package histopatologialab.diagnostico.controller;

import java.time.LocalDate;
import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Bool;
import histopatologialab.core.JsonResponse;
import histopatologialab.diagnostico.dto.Diagnostico;
import histopatologialab.diagnostico.dao.IDiagnosticoDao;
import histopatologialab.core.Estado;
import histopatologialab.diagnostico.dao.DiagnosticoDaoImpl;

public class DiagnosticoControllerImpl implements IDiagnosticoController {

    private final IDiagnosticoDao diagnosticosDao;

    public DiagnosticoControllerImpl(IDiagnosticoDao diagnosticosDao) {
        this.diagnosticosDao = diagnosticosDao;
    }


    @Override
    public JsonResponse<Diagnostico> crearDiagnostico(String nombreDiagnostico, String usuario) {
        try {
            Diagnostico diagnostico = new Diagnostico(null, nombreDiagnostico, Estado.HABILITADO.getSlug(), LocalDate.now(), usuario, null, null);
            diagnostico = diagnosticosDao.guardarDiagnostico(diagnostico);
            return new JsonResponse<Diagnostico>(diagnostico != null, diagnostico);
        } catch (Exception e) {
            return new JsonResponse<Diagnostico>(false, null, e.getMessage());
        }

    }

    @Override
    public JsonResponse<Diagnostico> modificarDiagnostico(Long codigoDiagnostico, String nombreDiagnostico, String usuario) {
        try {
            Diagnostico diagnostico = diagnosticosDao.getDiagnostico(codigoDiagnostico);
            diagnostico.setNombreDiagnostico(nombreDiagnostico);
            diagnostico.setModificadoPor(usuario);
            diagnostico.setFechaModificacion(LocalDate.now());
            diagnostico = diagnosticosDao.modificarDiagnostico(diagnostico);
            return new JsonResponse<Diagnostico>(diagnostico != null, diagnostico);
        } catch (Exception e) {
            return new JsonResponse<Diagnostico>(false, null, e.getMessage());
        }
    }

    @Override
    public JsonResponse<Diagnostico> buscarDiagnostico(Long codigoDiagnostico) {
        Diagnostico diagnostico =  diagnosticosDao.getDiagnostico(codigoDiagnostico);
        return new JsonResponse<Diagnostico>(diagnostico != null, diagnostico);
    }

    @Override
    public JsonResponse<Boolean> darBajaDiagnostico(Long codigoDiagnostico, String usuario) {
        Boolean success = diagnosticosDao.darDeBajaDiagnostico(codigoDiagnostico, usuario);
        return new JsonResponse<Boolean>(success, success);
    }

    @Override
    public JsonResponse<List<Diagnostico>> getDiagnosticos() {
        List<Diagnostico> diagnosticos = diagnosticosDao.getDiagnosticos();
        return new JsonResponse<List<Diagnostico>>(diagnosticos != null, diagnosticos);
    }

    @Override
    public JsonResponse<Boolean> cambiaEstadoDiagnostico(Long codigoDiagnostico, String estadoNuevo, String usuario) {
        Boolean success = diagnosticosDao.cambioEstadoDiagnostico(codigoDiagnostico, estadoNuevo, usuario);
        return new JsonResponse<Boolean>(success, success);
    }
}
