package histopatologialab.tincion.dao;

import histopatologialab.core.DB;
import histopatologialab.core.db.tables.LabPaciente;
import histopatologialab.core.db.tables.LabTincion;
import histopatologialab.tincion.Tincion;
import org.jooq.DSLContext;
import org.jooq.Record;

import java.util.List;
import java.util.stream.Collectors;

public class TincionDaoImpl implements ITincionDao{


    private final DSLContext query = DB.getConexion();
    private final LabTincion tabla = LabTincion.LAB_TINCION;

    private Tincion pasrseItem(Record record) {
        return new Tincion(
                record.getValue(tabla.COD_TINCION),
                record.getValue(tabla.NOMBRE_TINCION),
                record.getValue(tabla.ESTADO_TINCION),
                record.getValue(tabla.FECHA_CREACION),
                record.getValue(tabla.CREADO_POR),
                record.getValue(tabla.MODIFICADO_POR),
                record.getValue(tabla.FECHA_MODIFICACION)
        );
    }

    @Override
    public List<Tincion> getTinciones() {
        List<Record> result = query
                .select(tabla.asterisk())
                .from(tabla)
                .fetch();

        return result.stream().map(this::pasrseItem).collect(Collectors.toList());
    }
}
