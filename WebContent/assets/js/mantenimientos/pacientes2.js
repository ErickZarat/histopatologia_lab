
$(document).ready(function() {

    var pacientesTable = $('#pacientesTable').DataTable(window.coreTableConfig);
         pacientesTable.rows().remove().draw(false);  

	getListadoPacientes(); 



    $('#btnAgregarPaciente').click(function(){
        var loginUser = $('#loginUsuario').val().toUpperCase();
		var nombreUsuario = $('#nombreUsuario').val();
		var apellidosUsuario = $('#apellidosUsuario').val().toUpperCase();
		var colegiadoDoctor = $('#colegiadoDoctor').val().toUpperCase();
		var emailDoctor = $('#emailDoctor').val().toUpperCase();
		var passUser = $('#pswUsuario').val().toUpperCase();
		var tipoUsuario = $('#tipoUsuario').val().toUpperCase();

 		if ($('#nombreUsuario').val().trim().length == 0) {
			 toastr.error("Debe ingresar un nombre de paciente");
			 e.preventDefault();
		}
		else 
		{ 
        $.ajax({
            url: 'PacienteServlet.do',
            method: 'post',
            data: {
                accion: 'CREAR',
                loginUser: loginUser,
				pswUser: passUser,
				nombresDoctor: nombreUsuario,
				apellidosDoctor: apellidosUsuario,
				colegiadoDoctor: colegiadoDoctor,
				emailDoctor: emailDoctor,
				tipoUsuario: tipoUsuario,								
            },
            success: function(data) {
                $('#agregarPacienteModal').modal('hide');
                $('#loginUsuario').val("");
                if (data.success){
                    toastr.success("Se agrego con exito el paciente");
                    getListadoPacientes()
                } else {
                    toastr.error("Error al agregar Paciente")
                }
            }
        })
	  }
	//e.preventDefault();
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
                            + '<button type="button" class="btn btn-light" data-baja-paciente="true" ' + data + ' data-toggle="modal" data-target="#darBajaPacienteModal" id="darBajaPresentacionModalBtn"><i class="fas fa-times"></i></button>'
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

    function setPacienteDataDarBaja() {
        $('#codigoPacienteBaja').text($(this).data('codigo-paciente'))
        $('#loginPacienteBaja').text($(this).data('nombre-paciente'))
    }

    //function setUsuarioDataModificar(){	
  $('#modifPacienteBtn').click(function(){
	 var loginUsuario =   "LOGINUSER"; //$(this).data('nombre-usuario'); 
      alert(loginUsuario); 
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
					"loginUser": loginUsuario
				};
				$.post('PacienteServlet.do', datos, callback2, 'json');

				function callback2(respuesta) {
					if(respuesta.data)
					{ alert(respuesta);
					  alert(respuesta.data[0].loginUsuario);
	//$('#nombresUsuarioMod').val(response.data.nombresDoctor); 
				//$('#nombresUsuarioMod').val(element.nombresDoctor);
				//$('#apellidosUsuarioMod').val(element.apellidosDoctor);
//        		$('#apellidosUsuarioMod').val($(this).data(element.apellidosDoctor))
  //      		$('#colegiadoUsuarioMod').val($(this).data(element.colegiadoDoctor))
    //    		$('#passwordUsuarioMod').val($(this).data(element.passUser))
      //  		$('#emailUsuarioMod').val($(this).data(element.emailDoctor))
        //		$('#tipUsuarioMod').val($(this).data(element.tipoUsuario))				
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
   });


    $('#btnCancelAgregarPaciente').click(function(){
         getListadoPacientes();
    });
	

    $('#btnModificarPaciente').click(function(){
        var codigoUsuario = $('#codigoUsuarioMod').val();
        var loginUsuario = $('#loginUsuarioMod').val().toUpperCase();


 		if ($('#nombreEnfermedadMod').val().trim().length == 0) {
			 toastr.error("El nombre de la enfermedad no puede ser nulo");
			 e.preventDefault();
		}
		else 
		{
        $.ajax({
            url: 'PacienteServlet.do',
            method: 'post',
            data: {
                accion: 'MODIFICAR',
                loginUser: loginUsuario,
                loginUser: loginUsuario,
            },
            success: function(response) {
                $('#modificarPacienteModal').modal('hide');
                $('#codigoUsuarioMod').val("")
                $('#loginUsuarioMod').val("")
                if (response.success){
                    toastr.success("Se modifico con exito la enfermedad");
                    getListadoPacientes();
                } else {
                    toastr.error("Error al modificar Enfermedad");
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