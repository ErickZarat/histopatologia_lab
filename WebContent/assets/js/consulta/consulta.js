$(document).ready(function() {

    var consultasTable = $('#consultasTable').DataTable(window.coreTableConfig);

    function getListadoConsultas() {

        consultasTable.rows().remove().draw(false);

        $.ajax({
            url: 'ConsultaServlet.do',
            method: 'get',
            data: {
                accion: 'LISTAR_JSON'
            },
            success: function (response) {
                if(response.success) {
                    response.data.forEach(function (element) {
                        var data = ' data-codigo-consulta="' + element.codExamen +'"';
                        var row = [
                            '<label>' + element.numExamen + '</label>',
                            '<label>' + element.fechaExamen + '</label>',
                            '<label class="text-capitalize">' + element.estado + '</label>',
                            '<label class="text-capitalize">' + element.doctor.nombresDoctor + ' ' + element.doctor.apellidosDoctor + '</label>',
                            '<label class="text-capitalize">' + element.paciente.nombrePaciente + ' ' + element.paciente.apellidosPaciente + '</label>',
                            '<div class="btn-group" >'
                            + '<button type="button" class="btn btn-light" data-modificar="true" ' + data + ' data-toggle="modal" data-target="#"><i class="fas fa-edit"></i></button>'
                            + '<button type="button" class="btn btn-light" data-baja="true" ' + data + ' data-toggle="modal" data-target="#" id=""><i class="fas fa-times"></i></button>'
                            + '</div>'
                        ]
                        consultasTable.row.add(row).draw(false);
                    });
                } else {
                    toastr.error("No se pudo obtener el listado de consultas");
                }
            }
        });
    }

    getListadoConsultas();

});
