
$(document).ready(function() {

    var opcionlesionTable = $('#opcionlesionTable').DataTable(window.coreTableConfig);


	jQuery.validator.setDefaults({
  		debug: true,
  		success: "valid"
	});

	$.validator.addMethod("formatoSoloTexto", function(value, element) {
                return this.optional(element) || /^[a-zA-ZÀ-ÿ\s]{1,20}$/i.test(value);
	}, "Solo se permite ingresar letras.");
	
	
	var validar_formulario = $("#CrearOpcionFormModal").validate({
 	rules :{
                nombreOpcionLesion : { required : true, formatoSoloTexto: true,  minlength : 3, maxlength : 20  },
				
			
            },
            messages : {
                nombreOpcionLesion : {
                    required : "Debe ingresar el valor de la opción ",
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
	
    
    $('#btnAgregarOpcionLesion').click(function(e){
        var valoropcion = $('#nombreOpcionLesion').val().toUpperCase();
        var tipoOpcion = $('#TipoOpcionSearch').val();

	if (validar_formulario.form()) //asi se comprueba si el form esta validado o no
    	{ 
        	$.ajax({
            	url: 'OpcionLesionServlet.do',
            	method: 'post',
            	data: {
                	accion: 'CREAR',
                	valoropcion: valoropcion,
                	tipoOpcion: tipoOpcion
            	},
            	success: function(data) {
                	$('#agregarOpcionLesionModal').modal('hide');
                	$('#nombreOpcionLesion').val("");
	                	if (data.success){
                    	toastr.success("Se agregó con éxito el valor de la opción");
                    	getListadoOpcionLesion()
                	} else {
                    	toastr.error(data.error)
                	}
            	}
        	});
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


    $('#TipoOpcionSearch').change(getListadoOpcionLesion);

    function getListadoOpcionLesion() {
		if ($('#TipoOpcionSearch').val()== 0)
		{  $('#agregarOpcionLesionModalBtn').prop('disabled', true); 
		   $('#tipOpcionLesionvalue').val("");  
		} else {
			 $('#agregarOpcionLesionModalBtn').prop('disabled', false);
			// $('#tipOpcionLesionvalue').val($('#TipoOpcionSearch').val());  
			$('#tipOpcionLesionvalue').val($('#TipoOpcionSearch option:selected').text());  
			//tipOpcionLesionvalue
		}

        opcionlesionTable.rows().remove().draw(false);
        var tipoOpcion = $('#TipoOpcionSearch').val()
        $.ajax({
            url: 'OpcionLesionServlet.do',
            method: 'get',
            data: {
                accion: 'LISTAR_JSON',
                tipoOpcion: tipoOpcion
            },
            success: function (response) {
                if(response.success) {
                    response.data.forEach(function (element) {
                        var data = ' data-codigo-opcion="' + element.codigoOpcion + '" data-nombre-opcion="' + element.valor + '" '+ '" data-estado-opcion="' + devuelveEstado(element.estado) + '" ';
                        var row = [
                            '<input type="radio" name="opcion" data-nombre-opcion="'+element.valor+'" id="opcion-' + element.codigoOpcion + '" value="' + element.codigoOpcion + '"/>',
                            '<label for="opcion-' + element.codigoOpcion + '">' + element.codigoOpcion + '</label>',
                            '<label for="opcion-' + element.codigoOpcion + '" class="text-capitalize">' + element.valor + '</label>',
                            '<label for="opcion-' + element.codigoOpcion + '" class="text-capitalize">' + devuelveEstado(element.estado) + '</label>',
                            '<div class="btn-group" >'
                            + '<button type="button" class="btn btn-light" data-modificar-opcion="true" ' + data + ' data-toggle="modal" data-target="#modificarOpcionModal"  data-toggle="tooltip" data-placement="right" title="Modificar Valor"><i class="fas fa-edit"></i></button>'
                            + '<button type="button" class="btn btn-light" data-baja-opcion="true" ' + data + ' data-toggle="modal" data-target="#darBajaOpcionModal" id="darBajaPresentacionModalBtn" data-toggle="tooltip" data-placement="right" title="Cambio de Estado" ><i class="fas fa-toggle-on"></i></button>'
                            + '</div>'
                        ]
                        opcionlesionTable.row.add(row).draw(false);
                    });
                    $('input[type=radio][name=opcion]').unbind('change');

                } else {
                    toastr.error("No se pudo obtener el listado de valores Opcion");
                }
            }
        });
    }

  	$(document).on('click', '[data-modificar-opcion]', setOpcionDataModificar);
    $(document).on('click', '[data-baja-opcion]', setOpcionDataDarBaja);

    function onOpcionItemChange(){
      	toastr.error("No hay una funcion");
    }

    $('input[type=radio][name=opcion]').change(onOpcionItemChange);



    function setOpcionDataDarBaja() {
        $('#codigoOpcionLesionBaja').text($(this).data('codigo-opcion'))
        $('#valorOpcionLesionBaja').text($(this).data('nombre-opcion'))
		$('#estadoOpcionLesionBaja').text($(this).data('estado-opcion'))
    }

    function setOpcionDataModificar(){

        $('#codigoOpcionLesionMod').val($(this).data('codigo-opcion'))
        $('#valorOpcionLesionMod').val($(this).data('nombre-opcion'))
    }



    $('#btnCancelAddOpcionLesion').click(function(){
         getListadoOpcionLesion();
		 $('#nombreOpcionLesion').val("")
		 $('#agregarOpcionLesionModal label.error').hide();
    });

	// funcion al cerrar el modal de crear 
	 $("#agregarOpcionLesionModal").on('hidden.bs.modal', function () {
		$('#agregarOpcionLesionModal label.error').hide();
    });
	
	
    $('#btnCancelModifOpcionLesion').click(function(){
		$('#valorOpcionLesionMod').val("")
		$('#modificarOpcionModal label.error').hide();
    });
	
	// funcion al cerrar el modal de modificar 
	 $("#modificarOpcionModal").on('hidden.bs.modal', function () {
		$('#modificarOpcionModal label.error').hide();
    });
	



	var validar_formularioMod = $("#ModifOpcionFormModal").validate({
 	rules :{
                valorOpcionLesionMod : { required : true, formatoSoloTexto: true,  minlength : 3, maxlength : 20  },
			
            },
            messages : {
                valorOpcionLesionMod : {
                    required : "Debe ingresar el valor de la opción ",
 					minlength : "El nombre debe tener un mínimo de 3 caracteres",
					maxlength : "El máximo deben ser 20 caracteres", 
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



    $('#btnModificarOpcionLesion').click(function(e){
        var codigoOpcion = $('#codigoOpcionLesionMod').val();
        var valorOpcion = $('#valorOpcionLesionMod').val().toUpperCase();
		var nombreOpcion = $('#TipoOpcionSearch').val();
		
	if (validar_formularioMod.form()) //asi se comprueba si el form esta validado o no
    	{  
        $.ajax({
            url: 'OpcionLesionServlet.do',
            method: 'post',
            data: {
                accion: 'MODIFICAR',
                codigoOpcion: codigoOpcion,
				nombreOpcion: nombreOpcion, 
                valorOpcion: valorOpcion,
            },
            success: function(response) {
                $('#modificarOpcionModal').modal('hide');
                $('#codigoOpcionLesionMod').val("")
                $('#valorOpcionLesionMod').val("")
                if (response.success){
                    toastr.success("Se modificó con éxito el Valor de la Opción");
                    getListadoOpcionLesion();
	                } else {
	                    toastr.error(response.error);
	                }
            	}
        	});
		} else {
			e.preventDefault();
		}
    });



    $('#btnDarBajaOpcionLesion').click(function(){
        var codigoOpcion = $('#codigoOpcionLesionBaja').text();

        $.ajax({
            url: 'OpcionLesionServlet.do',
            method: 'post',
            data: {
                accion: 'DAR_BAJA',
                codigoOpcion: codigoOpcion
            },
            success: function(response) {
                $('#darBajaOpcionLesionModal').modal('hide');
                $('#codigoOpcionLesionBaja').text("")
                if (response.success){
                    toastr.success("Se dio de baja el valor");
                    getListadoOpcionLesion();
                } else {
                    toastr.error("Error al dar baja al valor: " + response.error);
                }
            }
        });
    });


    $('#btnCambioEstadoOpcionLesion').click(function(){
        var codigoOpcion = $('#codigoOpcionLesionBaja').text();
		var estadoOpcionBaja = $('#estadoOpcionLesionBaja').text().trim();

        $.ajax({
            url: 'OpcionLesionServlet.do',
            method: 'post',
            data: {
                accion: 'CAMBIO_ESTADO',
                codigoOpcion: codigoOpcion,
				estadoOpcionBaja: estadoOpcionBaja			
            },
            success: function(response) {
                $('#darBajaOpcionModal').modal('hide');
                $('#codigoOpcionLesionBaja').text("")
				$('#estadoOpcionLesionBaja').text("");
                if (response.success){
                    toastr.success("Se cambió el estado de la opción con éxito");
                    getListadoOpcionLesion();
                } else {
                    toastr.error("Error al cambiar el estado de la opción");
                }
            }
        });
    });



});