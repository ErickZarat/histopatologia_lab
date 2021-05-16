
$(document).ready(function() {

    var enfermedadesTable = $('#enfermedadesTable').DataTable(window.coreTableConfig);
         enfermedadesTable.rows().remove().draw(false);  

	getListadoEnfermedades(); 

    $('#btnAgregarEnfermedad').click(function(){
        var nombre = $('#nombreEnfermedad').val().toUpperCase();

 		if ($('#nombreEnfermedad').val().trim().length == 0) {
			 toastr.error("El nombre de la enfermedad no puede ser asdfawsfawerernulo");
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
       // console.log(data);
//alert(data.success);
                if (data.success){
                    toastr.success("Se agrego con exito la enfermedad");
                    getListadoEnfermedades()
                } else {
                    toastr.error("Error al agregar Enfermedad")
                }
            }
        })
	  }
	//e.preventDefault();
    });


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
                        var data = ' data-codigo-enfermedad="' + element.codigoEnfermedad + '" data-nombre-enfermedad="' + element.nombreEnfermedad + '" ';
                        var row = [
                            '<input type="radio" name="enfermedad" data-nombre-enfermedad="'+element.nombreEnfermdad+'" id="enfermedad-' + element.codigoEnfermedad + '" value="' + element.codigoEnfermedad + '"/>',
                            '<label for="enfermedad-' + element.codigoEnfermedad + '">' + element.codigoEnfermedad + '</label>',
                            '<label for="enfermedad-' + element.codigoEnfermedad + '" class="text-capitalize">' + element.nombreEnfermedad + '</label>',
                            '<div class="btn-group" >'
                            + '<button type="button" class="btn btn-light" data-modificar-enfermedad="true" ' + data + ' data-toggle="modal" data-target="#modificarEnfermedadModal"><i class="fas fa-edit"></i></button>'
                            + '<button type="button" class="btn btn-light" data-baja-enfermedad="true" ' + data + ' data-toggle="modal" data-target="#darBajaEnfermedadModal" id="darBajaPresentacionModalBtn"><i class="fas fa-times"></i></button>'
                            + '</div>'
                        ]
                        enfermedadesTable.row.add(row).draw(false);
                    });
                    $('input[type=radio][name=enfermedad]').unbind('change');
                    $('[data-modificar-enfermedad]').unbind('click');
                    $('[data-modificar-enfermedad]').click(setEnfermedadDataModificar);
                    $('[data-baja-enfermedad]').unbind('click');
                    $('[data-baja-enfermedad]').click(setEnfermedadDataDarBaja);
                } else {
                    toastr.error("No se pudo obtener el listado de Enfermedades");
                }
            }
        });
    }

    function setEnfermedadDataDarBaja() {
        $('#codigoEnfermedadBaja').text($(this).data('codigo-enfermedad'))
        $('#nombreEnfermedadBaja').text($(this).data('nombre-enfermedad'))
    }

    function setEnfermedadDataModificar(){
        $('#codigoEnfermedadMod').val($(this).data('codigo-enfermedad'))
        $('#nombreEnfermedadMod').val($(this).data('nombre-enfermedad'))
    }


    $('#btnCancelAgregarEnfermedad').click(function(){
         getListadoEnfermedades();
    });
	

    $('#btnModificarEnfermedad').click(function(){
        var codigoEnfermedad = $('#codigoEnfermedadMod').val();
        var nombreEnfermedad = $('#nombreEnfermedadMod').val().toUpperCase();

 		if ($('#nombreEnfermedadMod').val().trim().length == 0) {
			 toastr.error("El nombre de la enfermedad no puede ser asdfasdfasdfanulo");
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
                    toastr.error("Error al modificar Enfermedad");
                }
            }
        });
	 }
	e.preventDefault();
    });

    $('#btnDarBajaEnfermedad').click(function(){
        var codigoEnfermedad = $('#codigoEnfermedadBaja').text();

        $.ajax({
            url: 'EnfSistemicaServlet.do',
            method: 'post',
            data: {
                accion: 'DAR_BAJA',
                codigoEnfermedad: codigoEnfermedad
            },
            success: function(response) {
                $('#darBajaEnfermedadModal').modal('hide');
                $('#codigoEnfermedadBaja').text("")
                if (response.success){
                    toastr.success("Se dio de baja la enfermedad");
                    getListadoEnfermedades();
                } else {
                    toastr.error("Error al dar baja Enfermedad");
                }
            }
        });
    });

});