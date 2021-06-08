
$(document).ready(function() {

    var opcionlesionTable = $('#opcionlesionTable').DataTable(window.coreTableConfig);
    
    $('#btnAgregarOpcionLesion').click(function(e){
        var valoropcion = $('#nombreOpcionLesion').val().toUpperCase();
        var tipoOpcion = $('#TipoOpcionSearch').val();

 		if ($('#nombreOpcionLesion').val().trim().length == 0) {
			 toastr.error("Debe seleccionar un valor");
			 e.preventDefault();
		}
		else 
		{ // alert (tipoOpcion);
			if (tipoOpcion == 0) {
				toastr.error("Debe seleccionar una Opcion");
				$('#nombreOpcionLesion').val("");
			 	e.preventDefault();
			}
			else 
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
                    	toastr.success("Se agrego el valor de la opcion");
                    	getListadoOpcionLesion()
                	} else {
                    	toastr.error("Error al agregar el valor de la opcion")
                	}
            	}
        	});
		}
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
                        var data = ' data-codigo-opcion="' + element.codigoOpcion + '" data-nombre-opcion="' + element.valor + '" ';
                        var row = [
                            '<input type="radio" name="opcion" data-nombre-opcion="'+element.valor+'" id="opcion-' + element.codigoOpcion + '" value="' + element.codigoOpcion + '"/>',
                            '<label for="opcion-' + element.codigoOpcion + '">' + element.codigoOpcion + '</label>',
                            '<label for="opcion-' + element.codigoOpcion + '" class="text-capitalize">' + element.valor + '</label>',
                            '<label for="opcion-' + element.codigoOpcion + '" class="text-capitalize">' + devuelveEstado(element.estado) + '</label>',
                            '<div class="btn-group" >'
                            + '<button type="button" class="btn btn-light" data-modificar-opcion="true" ' + data + ' data-toggle="modal" data-target="#modificarOpcionModal"  data-toggle="tooltip" data-placement="right" title="Modificar Valor"><i class="fas fa-edit"></i></button>'
                            + '<button type="button" class="btn btn-light" data-baja-opcion="true" ' + data + ' data-toggle="modal" data-target="#darBajaOpcionModal" id="darBajaPresentacionModalBtn" data-toggle="tooltip" data-placement="right" title="Cambio de Estado" ><i class="fas fa-times"></i></button>'
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
    }

    function setOpcionDataModificar(){

        $('#codigoOpcionLesionMod').val($(this).data('codigo-opcion'))
        $('#valorOpcionLesionMod').val($(this).data('nombre-opcion'))
    }

    $('#btnModificarOpcionLesion').click(function(e){
        var codigoOpcion = $('#codigoOpcionLesionMod').val();
        var valorOpcion = $('#valorOpcionLesionMod').val().toUpperCase();
		var nombreOpcion = $('#TipoOpcionSearch').val();
		
 		if ($('#valorOpcionLesionMod').val().trim().length == 0) {
			 toastr.error("El valor de la opcion no puede ser nulo");
			 e.preventDefault();
		}
		else 
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
                    toastr.success("Se modifico el Valor de la Opcion");
                    getListadoOpcionLesion();
                } else {
                    toastr.error("Error al modificar el valor de la Opcion");
                }
            }
        });
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
                    toastr.error("Error al dar baja al valor");
                }
            }
        });
    });

});