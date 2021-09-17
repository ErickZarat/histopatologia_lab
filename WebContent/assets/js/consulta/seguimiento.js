
$(document).ready(function() {

    window.seguimientos = [];



jQuery.extend( jQuery.fn.dataTableExt.oSort, {
    "date-eu-pre": function ( date ) {
        date = date.replace(" ", "");
         
        if ( ! date ) {
            return 0;
        }
 
        var year;
        var eu_date = date.split(/[\.\-\/]/);
 
        /*year (optional)*/
        if ( eu_date[2] ) {
            year = eu_date[2];
        }
        else {
            year = 0;
        }
 
        /*month*/
        var month = eu_date[1];
        if ( month.length == 1 ) {
            month = 0+month;
        }
 
        /*day*/
        var day = eu_date[0];
        if ( day.length == 1 ) {
            day = 0+day;
        }
 
        return (year + month + day) * 1;
    },
 
    "date-eu-asc": function ( a, b ) {
        return ((a < b) ? -1 : ((a > b) ? 1 : 0));
    },
 
    "date-eu-desc": function ( a, b ) {
        return ((a < b) ? 1 : ((a > b) ? -1 : 0));
    }
} );

/*$.fn.dataTable.moment = function ( format, locale ) {
    var types = $.fn.dataTable.ext.type;

    // Add type detection
    types.detect.unshift( function ( d ) {
        return moment( d, format, locale, true ).isValid() ?
            'moment-'+format :
            null;
    } );

    // Add sorting method - use an integer for the sorting
    types.order[ 'moment-'+format+'-pre' ] = function ( d ) {
        return moment( d, format, locale, true ).unix();
    };
};
*/


jQuery.extend(jQuery.fn.dataTableExt.oSort, {
    "extract-date-pre": function(value) {
        var date = $(value, 'span')[0].innerHTML;
        date = date.split('/');
        return Date.parse(date[1] + '/' + date[0] + '/' + date[2])
    },
    "extract-date-asc": function(a, b) {
        return ((a < b) ? -1 : ((a > b) ? 1 : 0));
    },
    "extract-date-desc": function(a, b) {
        return ((a < b) ? 1 : ((a > b) ? -1 : 0));
    }
});

   var seguimientosTable = $('#seguimientosTable').DataTable({
	paging: true,
    // pagingType: 'simple',
    info: false,
 	autoWidth : true,
    // bFilter: false,
    bLengthChange: false,
    iDisplayLength: 5,
    oLanguage: {
        oPaginate: {
            sPrevious: "Anterior", // This is the link to the previous page
            sNext: "Siguiente", // This is the link to the next page
        }
    },
        columnDefs: [{
	type: 'extract-date',
	//render: $.fn.dataTable.render.moment('YYYY-MM-DD', 'DD/MM/YYYY'),
	//"render": function(data) { return moment(data).format('DD/MM/YYYY');},
	 // render: $.fn.dataTable.render.moment('YYYY-MM-DD', 'DD/MM/YYYY','en'),
      targets: 0
        }]
    });


  //      $.fn.dataTable.moment('DD/MM/YYYY');


/*        responsive: true,
        fixedHeader: true,*/
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
                '<label class="text-capitalize">' + element.fechaCreacion + '</label>' ,
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
							 var txtFecha= element.fechaCreacion.toString();
				            var row = [
				                '<label class="text">' + element.fechaCreacion + '</label>' ,
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