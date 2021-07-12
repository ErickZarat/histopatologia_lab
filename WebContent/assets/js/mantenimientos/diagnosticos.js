
$(document).ready(function() {

    var diagnosticosTable = $('#diagnosticosTable').DataTable(window.coreTableConfig);

		
        diagnosticosTable.rows().remove().draw(false);  
		getListadoDiagnosticos();


	jQuery.validator.setDefaults({
  		debug: true,
  		success: "valid"
	});
	
	$.validator.addMethod("formatoSoloTexto", function(value, element) {
                return this.optional(element) || /^[a-zA-ZÀ-ÿ\s]{1,40}$/i.test(value);
	}, "Solo se permite ingresar letras.");
	
	
	var validar_formulario = $("#CrearFormDiagnosticoModal").validate({
 	rules :{
                nombreDiagnostico : { required : true, formatoSoloTexto: true,  minlength : 3, maxlength : 50  },
			
            },
            messages : {
                nombreDiagnostico : {
                    required : "Debe ingresar el nombre del diagnóstico ",
 					minlength : "El nombre debe tener un mínimo de 3 caracteres",
					maxlength : "El máximo deben ser 50 caracteres", 
                },
 		errorElement: "em",
       	errorPlacement: function (error, element) {
          // Add the `help-block` class to the error element
          error.addClass("help-block"); 
       	},
       	highlight: function ( element, errorClass, validClass ) {
          $( element ).parents( ".col-sm-10" ).addClass( "has-error" ).removeClass( "has-success" );
       	},
       	unhighlight: function (element, errorClass, validClass) {
          $( element ).parents( ".col-sm-10" ).addClass( "has-success" ).removeClass( "has-error" );  
       	} 
	}
  	});


		
		 
	/*  llama al servlet para agregar los datos del diagnostico*/
    $('#btnAgregarDiagnostico').click(function(e){
        var nombreDiagnostico = $('#nombreDiagnostico').val().toUpperCase();

	if (validar_formulario.form()) //asi se comprueba si el form esta validado o no
    	{  
	        $.ajax({
	            url: 'DiagnosticoServlet.do',
	            method: 'post',
	            data: {
	                accion: 'CREAR',
	                nombreDiagnostico: nombreDiagnostico
	            },
	            success: function(data) {
	                if (data.success){
		                $('#agregarDiagnosticoModal').modal('hide');
		                $('#nombreDiagnostico').val("");	
	                    toastr.success("Se agregó con éxito el diagnóstico");
	                    getListadoDiagnosticos()
	                } else {
	                    toastr.error(data.error)
	                }
	            }
	        })
		} else {
			e.preventDefault();
		}
    });


/*  muestra el valor del estado */
	function devuelveEstado(valorestado)
	{  valor = ""; 
		if (valorestado == 'H') 
	    { valor = 'Alta' ; 
		} else {
			valor = 'Baja';
		}
		return valor;
	}


/* listado de diagnosticos */
    function getListadoDiagnosticos() {
        diagnosticosTable.rows().remove().draw(false);  // TEMPORAL
        $.ajax({
            url: 'DiagnosticoServlet.do',
            method: 'get',
            data: {
                accion: 'LISTAR_JSON'
            },
            success: function (response) {
                if(response.success) {
					   response.data.forEach(function (element) {
                        var data = ' data-codigo-diagnostico="' + element.codigoDiagnostico + '" data-nombre-diagnostico="' + element.nombreDiagnostico + '" data-estado-diagnostico="' + devuelveEstado(element.estado) + '" ';
                        var row = [
                            '<input type="radio" name="diagnostico" data-nombre-diagnostico="'+element.nombreDiagnostico+'" id="diagnostico-' + element.codigoDiagnostico + '" value="' + element.codigoDiagnostico + '"/>',
                            '<label for="diagnostico-' + element.codigoDiagnostico + '">' + element.codigoDiagnostico + '</label>',
                            '<label for="diagnostico-' + element.codigoDiagnostico + '" class="text">' + element.nombreDiagnostico + '</label>',
 							'<label for="diagnostico-' + element.codigoDiagnostico + '" class="text">' + devuelveEstado(element.estado)  + '</label>',

                            '<div class="btn-group" >'
                            + '<button type="button" class="btn btn-light" data-modificar-diagnostico="true" ' + data + ' data-toggle="modal" data-target="#modificarDiagnosticoModal"  data-toggle="tooltip" data-placement="right" title="Modificar Diagnostico"><i class="fas fa-edit"></i></button>'
                            + '<button type="button" class="btn btn-light" data-baja-diagnostico="true" ' + data + ' data-toggle="modal" data-target="#darBajaDiagnosticoModal" id="darBajaPresentacionModalBtn"  data-toggle="tooltip" data-placement="right" title="Cambio de Estado"><i class="fas fa-toggle-on"></i></button>'
                            + '</div>'
                        ]
                        diagnosticosTable.row.add(row).draw(false);
                    });
                   
                } else {
                    toastr.error("No se pudo obtener el listado de Diagnósticos");
                }
            }
        });
    }

    $(document).on('click', '[data-modificar-diagnostico]', setDiagnosticoDataModificar);
    $(document).on('click', '[data-baja-diagnostico]', setDiagnosticoDataDarBaja);



	/*  funcion para setear los datos en el modal para la baja del registro seleccionado 	*/
    function setDiagnosticoDataDarBaja() {
        $('#codigoDiagnosticoBaja').text($(this).data('codigo-diagnostico'))
        $('#nombreDiagnosticoBaja').text($(this).data('nombre-diagnostico'))
 		$('#estadoNuevoDiagnostico').text($(this).data('estado-diagnostico'))

    }

/*  funcion para setear los datos en el modal para la modificacion del registro seleccionado 	*/
    function setDiagnosticoDataModificar(){
        $('#codigoDiagnosticoMod').val($(this).data('codigo-diagnostico'))
        $('#nombreDiagnosticoMod').val($(this).data('nombre-diagnostico'))
    }


    $('#btnCancelAgregarDiagnostico').click(function(){
         getListadoDiagnosticos();
 		 $("#CrearFormDiagnosticoModal")[0].reset();
		$('#agregarDiagnosticoModal label.error').hide();
    });
	
	
    $('#btnCancelModifDiagnostico').click(function(){
 		 $("#ModifFormDiagnosticoModal")[0].reset();
		$('#modificarDiagnosticoModal label.error').hide();
    });
	
		
	// funcion al cerrar el modal de crear 
	 $("#agregarDiagnosticoModal").on('hidden.bs.modal', function () {
		$("#CrearFormDiagnosticoModal")[0].reset();
		$('#agregarDiagnosticoModal label.error').hide();
    });
	
		// funcion al cerrar el modal de modificar 
	 $("#modificarDiagnosticoModal").on('hidden.bs.modal', function () {
		$("#modificarDiagnosticoModal")[0].reset();
		$('#modificarDiagnosticoModal label.error').hide();
    });


	var validar_formularioMod = $("#ModifFormDiagnosticoModal").validate({
 	rules :{
                nombreDiagnosticoMod : { required : true, formatoSoloTexto: true,  minlength : 3, maxlength : 50  },
			
            },
            messages : {
                nombreDiagnosticoMod : {
                    required : "Debe ingresar el nombre del diagnóstico ",
 					minlength : "El nombre debe tener un mínimo de 3 caracteres",
					maxlength : "El máximo deben ser 50 caracteres", 
                },
 		errorElement: "em",
       	errorPlacement: function (error, element) {
          // Add the `help-block` class to the error element
          error.addClass("help-block"); 
       	},
       	highlight: function ( element, errorClass, validClass ) {
          $( element ).parents( ".col-sm-10" ).addClass( "has-error" ).removeClass( "has-success" );
       	},
       	unhighlight: function (element, errorClass, validClass) {
          $( element ).parents( ".col-sm-10" ).addClass( "has-success" ).removeClass( "has-error" );  
       	} 
	}
  	});

	

/*  evento al presionar modificar el registro*/
    $('#btnModificarDiagnostico').click(function(e){
        var codigoDiagnostico = $('#codigoDiagnosticoMod').val();
        var nombreDiagnostico = $('#nombreDiagnosticoMod').val().toUpperCase();

	if (validar_formularioMod.form()) //asi se comprueba si el form esta validado o no
    	{    
	        $.ajax({
	            url: 'DiagnosticoServlet.do',
	            method: 'post',
	            data: {
	                accion: 'MODIFICAR',
	                codigoDiagnostico: codigoDiagnostico,
	                nombreDiagnostico: nombreDiagnostico,
	            },
	            success: function(response) {
	
	                if (response.success){
		                $('#modificarDiagnosticoModal').modal('hide');
		                $('#codigoDiagnosticoMod').val("")
		                $('#nombreDiagnosticoMod').val("")	
	                    toastr.success("Se modificó con éxito el diagnóstico");
	                    getListadoDiagnosticos();
	                } else {
	                    toastr.error(response.error);
	                }
	            }
	        });
		} else {
			e.preventDefault();
		}
    });

	
	   $('#btnDarBajaDiagnostico').click(function(e){
        var codigoDiagnostico = $('#codigoDiagnosticoBaja').text();
		var estadoNuevoDiagnostico = $('#estadoNuevoDiagnostico').text().trim();

        $.ajax({
            url: 'DiagnosticoServlet.do',
            method: 'post',
            data: {
                accion: 'CAMBIO_ESTADO',
                codigoDiagnostico: codigoDiagnostico,
				estadoNuevoDiagnostico: estadoNuevoDiagnostico			
            },
            success: function(response) {
                $('#darBajaDiagnosticoModal').modal('hide');
                $('#codigoDiagnosticoBaja').text("")
				$('#estadoDiagnosticoBaja').text("");
                if (response.success){
                    toastr.success("Se cambió el estado del diagnóstico con éxito");
                    getListadoDiagnosticos();
                } else {
                    toastr.error("Error al cambiar el estado del diagnóstico");
                }
            }
        });
    });
	

});