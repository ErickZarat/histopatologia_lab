
$(document).ready(function() {

    var pacientesTable = $('#pacientesTable').DataTable(window.coreTableConfig);
         pacientesTable.rows().remove().draw(false);  

	getListadoPacientes(); 

    $('#btnAgregarPaciente').click(function(e){
        var idPaciente = $('#numIdPaciente').val();
		var nomPaciente = $('#nombresPaciente').val();
		var apellidosPaciente = $('#apellidosPaciente').val();
		var dirPaciente = $('#direccionPaciente').val();
		var telPaciente = $('#telPaciente').val();
		var fecNacimiento = $('#fecNacimientoPaciente').val();
		var generoPaciente = $('#generoPaciente').val();
		var ocupacionPaciente = $('#ocupacionPaciente').val();
		var tipoIdPaciente = $('#tipoIdPaciente').val();
		var emailPaciente = $('#emailPaciente').val();
		var estCivilPaciente = $('#estadoCivilPacienteSearch').val();
				

		if ($('#nombresPaciente').val().trim() == "" || $('#apellidosPaciente').val().trim() == "") {
			 toastr.error("Debe ingresar por lo menos un nombre y un apellido del paciente");
			 e.preventDefault(); 
		} else {
			if ($('#direccionPaciente').val().trim().length == 0) {
				toastr.error("Debe ingresar una direccion para el paciente");
			 	e.preventDefault(); 
			} else {
				if ($('#fecNacimientoPaciente').val().trim().length == 0) {
					toastr.error("Debe ingresar una fecha de nacimiento para el paciente");
			 		e.preventDefault(); 	
				} else {
					 $.ajax({
			            url: 'PacienteServlet.do',
			            method: 'post',
			            data: {
			                accion: 'CREAR',
			                identificacionPaciente: idPaciente,
							nomPaciente: nomPaciente,
							apellidosPaciente: apellidosPaciente,
							dirPaciente: dirPaciente,
							telPaciente: telPaciente,
							fecNacimiento: fecNacimiento,
							generoPaciente: generoPaciente,	
							ocupacionPaciente: ocupacionPaciente,	
							tipoIdPaciente: tipoIdPaciente,	
							emailPaciente: emailPaciente,		
							estadoCivilPaciente: estCivilPaciente,						
			            },
			            success: function(data) {
			                $('#agregarPacienteModal').modal('hide');
 							$("#CreaPacienteFormModal")[0].reset();
			                if (data.success){
			                    toastr.success("Se agrego con exito el paciente");
			                    getListadoPacientes()
			                } else {
			                    toastr.error("Error al agregar Paciente")
			                }
			            }
			        })
				}
			}
	  	}
	//e.preventDefault();
    });



	$('.fecha').datepicker({
		format : 'dd/mm/yyyy',
		startDate: "01/01/1900",
		endDate: "30/12/2099",
		language : 'es',
		todayBtn : "linked",
		todayHighlight : true,
		autoclose : true,
		startView : 'decade'
	});


    function getListadoPacientes() {

        pacientesTable.rows().remove().draw(false);  // TEMPORAL

        $.ajax({
            url: 'PacienteServlet.do',
            method: 'get',
            data: {
                accion: 'LISTAR_JSON'
            },
            success: function (response) {
                if(response.success) {
                    response.data.forEach(function (element) {
                        var data = ' data-codigo-paciente="' + element.codigoPaciente + '" data-nombre-paciente="' + element.nombrePaciente + '" ';
                        var row = [
                            '<input type="radio" name="paciente" data-nombre-paciente="'+element.nombrePaciente+'" id="paciente-' + element.codigoPaciente + '" value="' + element.codigoPaciente + '"/>',
                            '<label for="paciente-' + element.codigoPaciente + '">' + element.codigoPaciente + '</label>',
                            '<label for="paciente-' + element.codigoPaciente + '" class="text-capitalize">' + element.nombrePaciente + '</label>',
							'<label for="paciente-' + element.codigoPaciente + '" class="text-capitalize">' + element.apellidosPaciente + '</label>',
							'<label for="paciente-' + element.codigoPaciente + '" class="text-capitalize">' + element.identificacionPaciente + '</label>',
                            '<div class="btn-group" >'
                            + '<button type="button" class="btn btn-light" data-modificar-paciente="true" ' + data + ' data-toggle="modal"  id="modifPacienteBtn" data-target="#modificarPacienteModal" ><i class="fas fa-edit"></i></button>'
                            + '<button type="button" class="btn btn-light" data-baja-paciente="true" ' + data + ' data-toggle="modal" data-target="#darBajaPacienteModal" id="darBajaPresentacionModalBtn"><i class="far fa-calendar"></i></button>'
                            + '</div>'
                        ]
                        pacientesTable.row.add(row).draw(false);
                    });
                    $('input[type=radio][name=paciente]').unbind('change');
                    $('[data-modificar-paciente]').unbind('click');
                    //$('[data-modificar-usuario]').click(setUsuarioDataModificar());
                    $('[data-baja-paciente]').unbind('click');
                    $('[data-baja-paciente]').click(setPacienteDataDarBaja);
                } else {
                    toastr.error("No se pudo obtener el listado de Paciente");
                }
            }
        });
    }

    $(document).on('click', '[data-modificar-paciente]', setPacienteDataModificar);
    $(document).on('click', '[data-baja-paciente]', setPacienteDataDarBaja);



    function setPacienteDataDarBaja() {
        $('#codigoPacienteBaja').text($(this).data('codigo-paciente'))
        $('#loginPacienteBaja').text($(this).data('nombre-paciente'))
    }

   function setPacienteDataModificar(){	
	 var codPaciente =  $(this).data('codigo-paciente'); 
      //alert(loginUsuario); 
	  ///$.ajax({
      ///      url: 'UsuarioServlet.do',
      ///      method: 'post',
      ///      data: {
///                accion: 'BUSCAR',
	///			loginUser: loginUsuario,
       ///     },
        ///    success: function (response)

               var datos = {
					"accion": 'BUSCAR',
					"codPaciente": codPaciente
				};
				$.post('PacienteServlet.do', datos, callback2, 'json');

				function callback2(respuesta) {
				if(respuesta.data)
					{ //console.log(respuesta.data);  codigoPacienteMod
						$('#codigoPacienteMod').val(codPaciente);
						$('#nombresPacienteMod').val(respuesta.data.nombrePaciente);	
						$('#apellidosPacienteMod').val(respuesta.data.apellidosPaciente);	
						$('#direccionPacienteMod').val(respuesta.data.direccionPaciente); 
						$('#telefonoPacienteMod').val(respuesta.data.telefonoPaciente);
        				//$('#fecNacimientoPacienteMod').val(respuesta.data.fecNacimientoPaciente);
						$('#fecNacimientoPacienteMod').datepicker('setDate',respuesta.data.fecNacimientoPaciente);
        				$('#generoPacienteMod').val( respuesta.data.generoPaciente);
        				$('#ocupacionPacienteMod').val(respuesta.data.ocupacionPaciente);
						$('#tipoIdPacienteMod').val(respuesta.data.tipoidPaciente);
						$('#numIdPacienteMod').val(respuesta.data.identificacionPaciente);
						$('#emailPacienteMod').val(respuesta.data.emailPaciente);
						$('#estCivilPacienteMod').val(respuesta.data.estCivilPaciente);										
			    	}
			 	else 
					{
					 toastr.error("No se pudo obtener la información del Paciente");
					}
         
        //$('#loginUsuarioMod').val($(this).data('nombre-usuario'))
       //alert($(this).data('codigo-usuario'));

        //$('#nombresUsuarioMod').val($(this).data(element.nombresDoctor))
        //$('#apellidosUsuarioMod').val($(this).data(element.apellidosDoctor))
        //$('#colegiadoUsuarioMod').val($(this).data(element.colegiadoDoctor))

        //$('#passwordUsuarioMod').val($(this).data(element.passUser))
        //$('#emailUsuarioMod').val($(this).data(element.emailDoctor))
        //$('#tipUsuarioMod').val($(this).data(element.tipoUsuario))
    }
   }


    $('#btnCancelAgregarPaciente').click(function(){
         getListadoPacientes();
 		 $("#CreaPacienteFormModal")[0].reset();
    });
	
	
    $('#btnCancelModifPaciente').click(function(){
 		 $("#ModFormPacienteModal")[0].reset();
    });
	

    $('#btnModificarPaciente').click(function(){
        var codPaciente = $('#codigoPacienteMod').val();
        //var loginUsuario = $('#loginUsuarioMod').val().toUpperCase();


 		if ($('#nombresPacienteMod').val().trim().length == 0) {
			 toastr.error("El nombre del Paciente no puede ser nulo");
			 e.preventDefault();
		}
		else 
		{
        $.ajax({
            url: 'PacienteServlet.do',
            method: 'post',
            data: {
                accion: 'MODIFICAR',
                codPaciente: codPaciente,
                nomPaciente: nomPaciente,
				apellidosPaciente: apellidosPaciente,
				dirPaciente: dirPaciente,
				tipIdPaciente: tipIdPaciente,
				numIdPaciente: numIdPaciente, 
				telPaciente: telPaciente,
				ocupacionPaciente: ocupacionPaciente,
				emailPaciente: emailPaciente,
				generoPaciente: generoPaciente,
				estCivilPaciente: estCivilPaciente,
            },
            success: function(response) {
                $('#modificarPacienteModal').modal('hide');
 				$('#nombresPacienteMod').val("");
				$('#apellidosPacienteMod').val("");
				$('#direccionPacienteMod').val("");
				$('#telefonoPacienteMod').val("");
				$('#fecNacimientoPacienteMod').val("");
				$('#generoPacienteMod').val("");
				$('#ocupacionPacienteMod').val("");
				$('#tipoIdPacienteMod').val("");
				$('#numIdPacienteMod').val("");
				$('#emailPacienteMod').val("");
				$('#estCivilPacienteMod').val("");
                if (response.success){
                    toastr.success("Se modifico con exito el Paciente");
                    getListadoPacientes();
                } else {
                    toastr.error("Error al modificar el Paciente");
                }
            }
        });
	 }
	e.preventDefault();
    });

    $('#btnDarBajaPaciente').click(function(){
        var codigoUsuario = $('#codigoUsuarioBaja').text();
		var loginUsuario = $('#loginUsuarioBaja').text();

        $.ajax({
            url: 'PacienteServlet.do',
            method: 'post',
            data: {
                accion: 'DAR_BAJA',
                loginUser: loginUsuario
            },
            success: function(response) {
                $('#darBajaPacienteModal').modal('hide');
                $('#codigoUsuarioBaja').text("")
                if (response.success){
                    toastr.success("Se dio de baja al paciente");
                    getListadoPacientes();
                } else {
                    toastr.error("Error al dar baja al paciente");
                }
            }
        });
    });




});