
$(document).ready(function() {

    window.seguimientos = [];


   var seguimientosTable = $('#seguimientosTable').DataTable({
paging: true,
    info: false,
 	autoWidth : true,
	aaSorting: [],
    bLengthChange: false,
    iDisplayLength: 5,
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
	targets: 0,
	render: $.fn.dataTable.render.moment( 'DD/MM/YYYY' )
	} ]
})

   // var seguimientosTable = $('#seguimientosTable').DataTable(window.coreTableConfig);


	seguimientosTable.rows().remove().draw(false);  
	getSeguimientosTable();



	jQuery.validator.setDefaults({
	debug: true,
	success: "valid"
	});
	
	$.validator.addMethod("formatoSoloTexto", function(value, element) {
                return this.optional(element) || /^[a-zA-ZÀ-ÿ\. s()-*,]{1,200}$/i.test(value);
	}, "Solo se permite ingresar letras.");



	var validar_formulario = $("#seguimientos-form").validate({
 	rules :{
                observacionesSeguimiento : { required : true,  minlength : 3 },			
            },
            messages : {
                observacionesSeguimiento : {
                    required : "Las notas son obligatorias ",
 					minlength : "Valor obligatorio",
                },
 		errorElement: "em",
       	errorPlacement: function (error, element) {
          // Add the `help-block` class to the error element
          error.addClass("help-block"); 
       	},
       	highlight: function ( element, errorClass, validClass ) {
          $( element ).parents("form-control").addClass( "has-error" ).removeClass( "has-success" );
       	},
       	unhighlight: function (element, errorClass, validClass) {
          $( element ).parents("form-control").addClass( "has-success" ).removeClass( "has-error" );  
       	} 
	}
  	});


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
                '<label>' + element.fechaCreacion + '</label>' ,
                '<label class="text-capitalize">' + element.observaciones + '</label>' ,
                '<label class="text-capitalize">' + element.observacionesAdd + '</label>' ,
				'<label class="text-capitalize">' + element.nombresDoctor + '</label>' ,
                '<button type="button" class="btn btn-light delete" data-idx="'+idx+'"><i class="fas fa-trash"></i></button>'
            ];
            seguimientosTable.row.add(row).draw(false);
        });
		getSeguimientosTable.columns.adjust().draw();
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
				                '<label>' + element.fechaCreacion + '</label>' ,
				                '<label class="text">' + element.observaciones + '</label>' ,
				                '<label class="text">' + element.observacionesAdicionales + '</label>' ,
								'<label class="text">' + element.doctorSeguimiento + '</label>' 
								//, '<button type="button" class="btn btn-light delete" ><i class="fas fa-trash"></i></button>'
				                //'<button type="button" class="btn btn-light delete" data-idx="'+idx+'"><i class="fas fa-trash"></i></button>'
				            ];
				            seguimientosTable.row.add(row).draw(false);
				        });
                } else {
                    toastr.error("No se pudo obtener el listado de seguimientos");
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




    $('#guardarSeguimiento').click(function(e){
		if (validar_formulario.form()) //asi se comprueba si el form esta validado o no
    	{       
			var seguimiento = extractSeguimiento();
			window.seguimientos.push(seguimiento);
	        e.preventDefault();
	        $('#seguimientos-form').prop('disabled', true);
	 		$('#seguimientos-form').trigger("reset");
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
	                    toastr.success("Se guardo con éxito el seguimiento");
						getSeguimientosTable();
	                } else {
	                    toastr.error("No se pudo guardar el seguimiento");
	                }
	            }
	        });
		} else {
			e.preventDefault();
		}
    });

    $('a#descargarReceta').click(function(e) {
        e.preventDefault();
        var width = window.innerWidth * 0.8 ;
        var height = width * window.innerHeight / window.innerWidth ;
        window.open(this.href , 'newwindow', 'width=' + width + ', height=' + height + ', top=' + ((window.innerHeight - height) / 2) + ', left=' + ((window.innerWidth - width) / 2));
    });

});