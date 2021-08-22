
$(document).ready(function() {

   		var enfermedadesTable = $('#enfermedadesTable').DataTable(window.coreTableConfig);
	
        enfermedadesTable.rows().remove().draw(false);  
		getListadoEnfermedades();
		


	jQuery.validator.setDefaults({
  		debug: true,
  		success: "valid"
	});
	
	$.validator.addMethod("formatoSoloTexto", function(value, element) {
                return this.optional(element) || /^[a-zA-ZÀ-ÿ\s]{1,40}$/i.test(value);
	}, "Solo se permite ingresar letras.");
	
	
	var validar_formulario = $("#CrearFormEnfSistemicaModal").validate({
 	rules :{
                nombreEnfermedad : { required : true, formatoSoloTexto: true,  minlength : 3, maxlength : 50  },
			
            },
            messages : {
                nombreEnfermedad : {
                    required : "Debe ingresar el nombre de la enfermedad ",
 					minlength : "El nombre debe tener un mínimo de 3 caracteres",
					maxlength : "El máximo deben ser 50 caracteres", 
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

		
		 
	/*  llama al servlet para agregar los datos de la enfermedad*/
    $('#btnAgregarEnfermedad').click(function(e){
        var nombre = $('#nombreEnfermedad').val().toUpperCase();

	if (validar_formulario.form()) //asi se comprueba si el form esta validado o no
    	{       
        $.ajax({
            url: 'EnfSistemicaServlet.do',
            method: 'post',
            data: {
                accion: 'CREAR',
                nombre: nombre
            },
            success: function(data) {

                if (data.success){
	                $('#agregarEnfermedadModal').modal('hide');
	                $('#nombreEnfermedad').val("");	
                    toastr.success("Se agrego con exito la enfermedad");
                    getListadoEnfermedades()
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


/* listado de enfermedades */
    function getListadoEnfermedades() {
        enfermedadesTable.rows().remove().draw(false);  // TEMPORAL
        $.ajax({
            url: 'EnfSistemicaServlet.do',
            method: 'get',
            data: {
                accion: 'LISTAR_JSON'
            },
            success: function (response) {
				 if(response.success) {
                    response.data.forEach(function (element) {
                        var data = ' data-codigo-enfermedad="' + element.codigoEnfermedad + '" data-nombre-enfermedad="' + element.nombreEnfermedad + '" data-estado-enfermedad="' + devuelveEstado(element.estado) + '" ';
                        var row = [
                            '<input type="radio" name="enfermedad" data-nombre-enfermedad="'+element.nombreEnfermdad+'" id="enfermedad-' + element.codigoEnfermedad + '" value="' + element.codigoEnfermedad + '"/>',
                            '<label for="enfermedad-' + element.codigoEnfermedad + '">' + element.codigoEnfermedad + '</label>',
                            '<label for="enfermedad-' + element.codigoEnfermedad + '" class="text">' + element.nombreEnfermedad + '</label>',
 							'<label for="enfermedad-' + element.codigoEnfermedad + '" class="text">' + devuelveEstado(element.estado)  + '</label>',
                            '<div class="btn-group" >'
                            + '<button type="button" class="btn btn-light" data-modificar-enfermedad="true" ' + data + ' data-toggle="modal" data-target="#modificarEnfermedadModal"  data-toggle="tooltip" data-placement="right" title="Modificar Enfermedad"><i class="fas fa-edit"></i></button>'
                            + '<button type="button" class="btn btn-light" data-baja-enfermedad="true" ' + data + ' data-toggle="modal" data-target="#darBajaEnfermedadModal" id="darBajaPresentacionModalBtn"  data-toggle="tooltip" data-placement="right" title="Cambio de Estado"><i class="fas fa-toggle-on"></i></button>'
                            + '</div>'
                        ]
                        enfermedadesTable.row.add(row).draw(false);
                    });
                   enfermedadesTable.columns.adjust().draw();
                } else {
                    toastr.error("No se pudo obtener el listado de Enfermedades");
                }
            }
        });
    }
    $(document).on('click', '[data-modificar-enfermedad]', setEnfermedadDataModificar);
    $(document).on('click', '[data-baja-enfermedad]', setEnfermedadDataDarBaja);



	/*  funcion para setear los datos en el modal para la baja del registro seleccionado 	*/
    function setEnfermedadDataDarBaja() {
        $('#codigoEnfermedadBaja').text($(this).data('codigo-enfermedad'))
        $('#nombreEnfermedadBaja').text($(this).data('nombre-enfermedad'))
 		$('#estadoEnfermedadBaja').text($(this).data('estado-enfermedad'))

    }

/*  funcion para setear los datos en el modal para la modificacion del registro seleccionado 	*/
    function setEnfermedadDataModificar(){
        $('#codigoEnfermedadMod').val($(this).data('codigo-enfermedad'))
        $('#nombreEnfermedadMod').val($(this).data('nombre-enfermedad'))
    }



    $('#btnCancelAgregarEnfermedad').click(function(){
        getListadoEnfermedades();
 		$("#CrearFormEnfSistemicaModal")[0].reset();
		$("#nombreEnfermedad").removeClass('has-error');
		//$("#CrearFormEnfSistemicaModal")[0].removeClass('has-error');
		$('#agregarEnfermedadModal label.error').hide();
    });
	
	
    $('#btnCancelModifEnfermedad').click(function(){
 		$("#ModifFormEnfSistemicaModal")[0].reset();
		//$("#ModifFormEnfSistemicaModal")[0].removeClass('has-error');
		$("#nombreEnfermedadMod").removeClass('has-error');
		$('#modificarEnfermedadModal label.error').hide();
    });
	
		
	// funcion al cerrar el modal de crear 
	 $("#agregarEnfermedadModal").on('hidden.bs.modal', function () {
		$('#agregarEnfermedadModal label.error').hide();
		$("#nombreEnfermedad").removeClass('has-error');
		
	//	$(element).closest('.form-group').removeClass('has-error')
    });
	
		// funcion al cerrar el modal de modificar 
	 $("#modificarEnfermedadModal").on('hidden.bs.modal', function () {
		$('#modificarEnfermedadModal label.error').hide();
    });


	var validar_formularioMod = $("#ModifFormEnfSistemicaModal").validate({
 	rules :{
                nombreEnfermedadMod : { required : true, formatoSoloTexto: true,  minlength : 3, maxlength : 50  },
			
            },
            messages : {
                nombreEnfermedadMod : {
                    required : "Debe ingresar el nombre de la enfermedad ",
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
    $('#btnModificarEnfermedad').click(function(e){
        var codigoEnfermedad = $('#codigoEnfermedadMod').val();
        var nombreEnfermedad = $('#nombreEnfermedadMod').val().toUpperCase();

	if (validar_formularioMod.form()) //asi se comprueba si el form esta validado o no
    	{      
	        $.ajax({
	            url: 'EnfSistemicaServlet.do',
	            method: 'post',
	            data: {
	                accion: 'MODIFICAR',
	                codigoEnfermedad: codigoEnfermedad,
	                nombreEnfermedad: nombreEnfermedad,
	            },
	            success: function(response) {
	                if (response.success){
		                $('#modificarEnfermedadModal').modal('hide');
		                $('#codigoEnfermedadMod').val("")
		                $('#nombreEnfermedadMod').val("")	
	                    toastr.success("Se modifico con exito la enfermedad");
	                    getListadoEnfermedades();
	                } else {
	                    toastr.error(response.error);
	                }
	            }
	        });
		} else {
			e.preventDefault();
		}
    });

	
	   $('#btnDarBajaEnfermedad').click(function(e){
        var codigoEnfermedad = $('#codigoEnfermedadBaja').text();
		var estadoEnfermedadBaja = $('#estadoEnfermedadBaja').text().trim();

        $.ajax({
            url: 'EnfSistemicaServlet.do',
            method: 'post',
            data: {
                accion: 'CAMBIO_ESTADO',
                codigoEnfermedad: codigoEnfermedad,
				estadoEnfermedadBaja: estadoEnfermedadBaja			
            },
            success: function(response) {
                $('#darBajaEnfermedadModal').modal('hide');
                $('#codigoEnfermedadBaja').text("")
				$('#estadoEnfermedadBaja').text("");
                if (response.success){
                    toastr.success("Se cambió el estado de la enfermedad con éxito");
                    getListadoEnfermedades();
                } else {
                    toastr.error("Error al dar baja Enfermedad");
                }
            }
        });
    });
	

});