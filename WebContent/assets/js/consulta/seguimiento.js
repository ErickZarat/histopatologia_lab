
$(document).ready(function() {

    window.seguimientos = [];

$.fn.dataTable.render.moment = function ( from, to, locale ) {
    // Argument shifting
    if ( arguments.length === 1 ) {
        locale = 'en';
        to = from;
        from = 'YYYY-MM-DD';
    }
    else if ( arguments.length === 2 ) {
        locale = 'en';
    }
 
    return function ( d, type, row ) {
        if (! d) {
            return type === 'sort' || type === 'type' ? 0 : d;
        }
 
        var m = window.moment( d, from, locale, true );
 
        // Order and type get a number value from Moment, everything else
        // sees the rendered value
        return m.format( type === 'sort' || type === 'type' ? 'x' : to );
    };
};


   // var currentMedicamentos = [];
   // var currentPresentaciones = [];

    var seguimientosTable = $('#seguimientosTable').DataTable(window.coreTableConfig);




 	seguimientosTable.rows().remove().draw(false);  
	getSeguimientosTable();


    function extractSeguimiento() {
        return {
            'codExamen': window.examen,
            'observaciones':  $('#observacionesSeguimiento').val(),
            'observacionesAdicionales':  $('#adicionelesSeguimiento').val(),
        };
    }

    function redrawSeguimientosTable(){
        seguimientosTable.rows().remove().draw(false);
        window.seguimientos.forEach(function(element, idx){
            var row = [
                '<label class="text-capitalize">' + element.fechaCreacion + '</label>' ,
                '<label class="text-capitalize">' + element.observaciones + '</label>' ,
                '<label class="text-capitalize">' + element.observacionesAdd + '</label>' ,
                '<button type="button" class="btn btn-light delete" data-idx="'+idx+'"><i class="fas fa-trash"></i></button>'
            ];
            seguimientosTable.row.add(row).draw(false);
        });
    }



    function getSeguimientosTable(){
        seguimientosTable.rows().remove().draw(false);
 		$.ajax({
            url: 'SeguimientoServlet.do',
            method: 'get',
            data: {  codExamen: window.examen,
                accion: 'LISTAR_JSON'
            },
            success: function (response) {
				 if(response.success) {
                    response.data.forEach(function (element) {
						 //var txtfecha = Convert.ToDateTime(row["element.fechaCreacion"]).ToString("dd/MM/yyyy");
				            var row = [
				                '<label class="text-capitalize">' + element.fechaCreacion + '</label>' ,
				                '<label class="text-capitalize">' + element.observaciones + '</label>' ,
				                '<label class="text-capitalize">' + element.observacionesAdicionales + '</label>' ,
								'<button type="button" class="btn btn-light delete" ><i class="fas fa-trash"></i></button>'
				                //'<button type="button" class="btn btn-light delete" data-idx="'+idx+'"><i class="fas fa-trash"></i></button>'
				            ];
				            seguimientosTable.row.add(row).draw(false);
				        });
                } else {
                    toastr.error("No se pudo obtener el listado de Enfermedades");
                }
            }
        });
    }

    $(document).on('click', 'button[data-idx]', function (){
        var idx = $(this).data('idx')
        window.seguimientos.splice(idx, 1);
        redrawSeguimientosTable()
    })


    $('#agregarSeguimiento').click(function(e){
        e.preventDefault();
        var seguimiento = extractSeguimiento();
        //seguimiento.numReceta = window.seguimientos.length + 1
        window.seguimientos.push(seguimiento);
        $('#seguimientos-form').trigger("reset");
        redrawSeguimientosTable();
    });
//TODO: handle guardar button on load
    $('#guardarSeguimiento').click(function(e){
		 var seguimiento = extractSeguimiento();
		window.seguimientos.push(seguimiento);
        e.preventDefault();
        $('#seguimientos-form').prop('disabled', true);
        $('#guardarSeguimiento').prop('disabled', true);
        $.ajax({
            url: 'SeguimientoServlet.do',
            method: 'post',
            data: {
                accion: 'CREAR',
				//seguimientos: JSON.stringify(seguimiento)
                seguimientos: JSON.stringify(window.seguimientos)
            },
            success: function (response) {
                if(response.success) {
                    toastr.success("se guardo con exito el seguiemiento");
					getSeguimientosTable();
                } else {
                    toastr.error("No se pudo guardar el seguimiento");
                }
            }
        });
    });

    $('a#descargarReceta').click(function(e) {
        e.preventDefault();
        var width = window.innerWidth * 0.8 ;
        var height = width * window.innerHeight / window.innerWidth ;
        window.open(this.href , 'newwindow', 'width=' + width + ', height=' + height + ', top=' + ((window.innerHeight - height) / 2) + ', left=' + ((window.innerWidth - width) / 2));
    });

});