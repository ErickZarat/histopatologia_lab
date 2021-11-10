$(document).ready(function() {
	
    //var consultasTable = $('#consultasTable').DataTable(window.coreTableConfig);

var consultasTable = $('#consultasTable').DataTable({
paging: true,
    info: false,
 	autoWidth : true,
	aaSorting: [],
    bLengthChange: false,
    iDisplayLength: 15,
    oLanguage: {
		sEmptyTable: "No hay filas para mostrar",
		sSearch : "Buscar",
		sInfoEmpty: "",
        oPaginate: {
            sPrevious: "Anterior", // This is the link to the previous page
            sNext: "Siguiente", // This is the link to the next page
        }
    },
	columnDefs: [ {
	targets: 1,
	render: $.fn.dataTable.render.moment( 'DD/MM/YYYY' )
	} ]
})


    function getListadoConsultas() {

		var codPaciente = $('#codPaciente').val().trim();; 
        consultasTable.rows().remove().draw(false);

        $.ajax({
            url: 'ConsultaServlet.do',
            method: 'get',
            data: { codPaciente: codPaciente,
                accion: 'CONSULTA_PACIENTE'
            },
            success: function (response) {
                if(response.success) {
                    response.data.forEach(function (element) {
                        var row = [
                            '<label>' + element.numExamen + '</label>',
                       //     '<label>' + element.fechaFormateada + '</label>',
							
  							'<label>' + element.fechaExamen + '</label>',
                            '<label class="text-capitalize">' + element.estado + '</label>',
                            '<label class="text-capitalize">' + element.doctor.nombresDoctor + ' ' + element.doctor.apellidosDoctor + '</label>',
                            '<label class="text-capitalize">' + element.paciente.nombrePaciente + ' ' + element.paciente.apellidosPaciente + '</label>',

                            '<div class="btn-group" >'
                            + '<a class="btn btn-light" data-toggle="tooltip" data-placement="right" title="Abrir Consulta" href="ConsultaServlet.do?accion=VER&codExamen=' + element.codExamen + '"><i class="fas fa-eye"></i></a>'
                            + '</div>'
                        ]
                        consultasTable.row.add(row).draw(false);
                    });

				consultasTable.columns.adjust().draw();
                } else {
                    toastr.error("No se pudo obtener el listado de consultas");
                }
            }
        });
    }

    getListadoConsultas();

});
