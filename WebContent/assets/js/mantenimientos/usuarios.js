
$(document).ready(function() {

    var usuariosTable = $('#usuariosTable').DataTable(window.coreTableConfig);
         usuariosTable.rows().remove().draw(false);  

	getListadoUsuarios(); 



    $('#btnAgregarUsuario').click(function(){
        var loginUser = $('#loginUsuario').val().toUpperCase();
		var nombreUsuario = $('#nombreUsuario').val();
		var apellidosUsuario = $('#apellidosUsuario').val().toUpperCase();
		var colegiadoDoctor = $('#colegiadoDoctor').val().toUpperCase();
		var emailDoctor = $('#emailDoctor').val().toUpperCase();
		var passUser = $('#pswUsuario').val().toUpperCase();
		var tipoUsuario = $('#tipoUsuario').val().toUpperCase();

 		if ($('#nombreUsuario').val().trim().length == 0) {
			 toastr.error("Debe ingresar un nombre de usuario");
			 e.preventDefault();
		}
		else 
		{ 
        $.ajax({
            url: 'UsuarioServlet.do',
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
                $('#agregarUsuarioModal').modal('hide');
                $('#loginUsuario').val("");
                if (data.success){
                    toastr.success("Se agrego con exito la enfermedad");
                    getListadoUsuarios()
                } else {
                    toastr.error("Error al agregar Enfermedad")
                }
            }
        })
	  }
	//e.preventDefault();
    });


    function getListadoUsuarios() {

        usuariosTable.rows().remove().draw(false);  // TEMPORAL

        $.ajax({
            url: 'UsuarioServlet.do',
            method: 'get',
            data: {
                accion: 'LISTAR_JSON'
            },
            success: function (response) {
                if(response.success) {
                    response.data.forEach(function (element) {
                        var data = ' data-codigo-usuario="' + element.codUsuario + '" data-nombre-usuario="' + element.loginUsuario + '" ';
                        var row = [
                            '<input type="radio" name="usuario" data-nombre-usuario="'+element.loginUsuario+'" id="usuario-' + element.codUsuario + '" value="' + element.codUsuario + '"/>',
                            '<label for="usuario-' + element.codUsuario + '">' + element.codUsuario + '</label>',
                            '<label for="usuario-' + element.codUsuario + '" class="text-capitalize">' + element.loginUsuario + '</label>',
							'<label for="usuario-' + element.codUsuario + '" class="text-capitalize">' + element.nombresDoctor + '</label>',
							'<label for="usuario-' + element.codUsuario + '" class="text-capitalize">' + element.apellidosDoctor + '</label>',
							'<label for="usuario-' + element.codUsuario + '" class="text-capitalize">' + element.emailUsuario + '</label>',
                            '<div class="btn-group" >'
                            + '<button type="button" class="btn btn-light" data-modificar-usuario="true" ' + data + ' data-toggle="modal"  id="modifUsuarioBtn" data-target="#modificarUsuarioModal" ><i class="fas fa-edit"></i></button>'
                            + '<button type="button" class="btn btn-light" data-baja-usuario="true" ' + data + ' data-toggle="modal" data-target="#darBajaUsuarioModal" id="darBajaPresentacionModalBtn"><i class="fas fa-times"></i></button>'
                            + '</div>'
                        ]
                        usuariosTable.row.add(row).draw(false);
                    });
                    $('input[type=radio][name=usuario]').unbind('change');
                    $('[data-modificar-usuario]').unbind('click');
                    $('[data-modificar-usuario]').click(setUsuarioDataModificar);
                    $('[data-baja-usuario]').unbind('click');
                    $('[data-baja-usuario]').click(setUsuarioDataDarBaja);
                } else {
                    toastr.error("No se pudo obtener el listado de Usuarios");
                }
            }
        });
    }

    function setUsuarioDataDarBaja() {
        $('#codigoUsuarioBaja').text($(this).data('codigo-usuario'))
        $('#loginUsuarioBaja').text($(this).data('nombre-usuario'))
    }

    function setUsuarioDataModificar(){	
  //$('#modifUsuarioBtn').click(function(){
	 var loginUsuario = $(this).data('nombre-usuario'); 
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
				$.post('UsuarioServlet.do', datos, callback2, 'json');

				function callback2(respuesta) {
					if(respuesta.data)
					{ console.log(respuesta.data);
						alert(respuesta);
					  alert(respuesta.data.loginUsuario);
				$('#nombresUsuarioMod').val(respuesta.data.nombresDoctor); 
				$('#apellidosUsuarioMod').val(respuesta.data.apellidosDoctor);
        		//$('#apellidosUsuarioMod').val(respuesta.data.apellidosDoctor)
        		$('#colegiadoUsuarioMod').val(respuesta.data.numColegiado);
        		$('#emailUsuarioMod').val( respuesta.data.emailUsuario);
        		$('#tipUsuarioMod').val(respuesta.data.tipoUsuario);				
			    	}
			 else 
				{
					 toastr.error("No se pudo obtener la información del Usuario");
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


    $('#btnCancelAgregarUsuario').click(function(){
         getListadoUsuarios();
    });
	

    $('#btnModificarUsuario').click(function(){
        var codigoUsuario = $('#codigoUsuarioMod').val();
        var loginUsuario = $('#loginUsuarioMod').val().toUpperCase();


 		if ($('#nombreEnfermedadMod').val().trim().length == 0) {
			 toastr.error("El nombre de la enfermedad no puede ser nulo");
			 e.preventDefault();
		}
		else 
		{
        $.ajax({
            url: 'UsuarioServlet.do',
            method: 'post',
            data: {
                accion: 'MODIFICAR',
                loginUser: loginUsuario,
                loginUser: loginUsuario,
            },
            success: function(response) {
                $('#modificarUsuarioModal').modal('hide');
                $('#codigoUsuarioMod').val("")
                $('#loginUsuarioMod').val("")
                if (response.success){
                    toastr.success("Se modifico con exito la enfermedad");
                    getListadoUsuarios();
                } else {
                    toastr.error("Error al modificar Enfermedad");
                }
            }
        });
	 }
	e.preventDefault();
    });

    $('#btnDarBajaUsuario').click(function(){
        var codigoUsuario = $('#codigoUsuarioBaja').text();
		var loginUsuario = $('#loginUsuarioBaja').text();

        $.ajax({
            url: 'UsuarioServlet.do',
            method: 'post',
            data: {
                accion: 'DAR_BAJA',
                loginUser: loginUsuario
            },
            success: function(response) {
                $('#darBajaUsuarioModal').modal('hide');
                $('#codigoUsuarioBaja').text("")
                if (response.success){
                    toastr.success("Se dio de baja al usuario");
                    getListadoUsuarios();
                } else {
                    toastr.error("Error al dar baja al usuario");
                }
            }
        });
    });

});