
$(document).ready(function() {

    var enfermedadesTable = $('#enfermedadesTable').DataTable(window.coreTableConfig);

		
        enfermedadesTable.rows().remove().draw(false);  
		getListadoEnfermedades();
		
		 
	/*  llama al servlet para agregar los datos de la enfermedad*/
    $('#btnAgregarEnfermedad').click(function(e){
        var nombre = $('#nombreEnfermedad').val().toUpperCase();

 		if ($('#nombreEnfermedad').val().trim().length == 0) {
			 toastr.error("El nombre de la enfermedad no puede ser nulo");
			 e.preventDefault();
		}
		else 
		{ 
        $.ajax({
            url: 'EnfSistemicaServlet.do',
            method: 'post',
            data: {
                accion: 'CREAR',
                nombre: nombre
            },
            success: function(data) {
                $('#agregarEnfermedadModal').modal('hide');
                $('#nombreEnfermedad').val("");
                if (data.success){
                    toastr.success("Se agrego con exito la enfermedad");
                    getListadoEnfermedades()
                } else {
                    toastr.error(data.error)
                }
            }			
        })
	  }
	//e.preventDefault();
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


/*  al cancelar, se manda a refrescar la tabla 	*/
//    $('#btnCancelAgregarEnfermedad').click(function(){
 //        getListadoEnfermedades();
 //   });
	

/*  evento al presionar modificar el registro*/
    $('#btnModificarEnfermedad').click(function(e){
        var codigoEnfermedad = $('#codigoEnfermedadMod').val();
        var nombreEnfermedad = $('#nombreEnfermedadMod').val().toUpperCase();

 		if ($('#nombreEnfermedadMod').val().trim().length == 0) {
			 toastr.error("El nombre de la enfermedad no puede ser nulo");
			 e.preventDefault();
		}
		else 
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
                $('#modificarEnfermedadModal').modal('hide');
                $('#codigoEnfermedadMod').val("")
                $('#nombreEnfermedadMod').val("")
                if (response.success){
                    toastr.success("Se modifico con exito la enfermedad");
                    getListadoEnfermedades();
                } else {
                    toastr.error(response.error);
                }
            }
        });
	 }
	e.preventDefault();
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