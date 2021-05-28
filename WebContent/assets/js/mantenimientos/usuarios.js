
$(document).ready(function() {

    var usuariosTable = $('#usuariosTable').DataTable(window.coreTableConfig);
         usuariosTable.rows().remove().draw(false);  

	getListadoUsuarios(); 


		function validarEmail(email) { 
		    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		    return re.test(email);
		} 
		
		function validarNombreUsuario(cadena) {
		// Validar un nombre de usuario con un mínimo de 4 caracteres y un máximo de 15
		var patron = /^[a-z]{4,15}$/i;
	  	if(!cadena.search(patron))
	    	return true;
	  	else
	    	return false;
		}

    $('#btnAgregarUsuario').click(function(e){
        var loginUser = $('#loginUsuario').val().toUpperCase().trim();
		var nombreUsuario = $('#nombreUsuario').val();
		var apellidosUsuario = $('#apellidosUsuario').val().toUpperCase();
		var colegiadoDoctor = $('#colegiadoDoctor').val().trim();
		var emailDoctor = $('#emailDoctor').val().trim();
		var passUser = $('#pswUsuario').val();
		var tipoUsuario = $('#tipoUsuario').val();
		
		
		if ($('#nombreUsuario').val().trim() == "" || $('#apellidosUsuario').val().trim() == "") {
			 toastr.error("Debe ingresar por lo menos un nombre y un apellido de usuario");
			 e.preventDefault(); 
		} else { 
			if ($('#loginUsuario').val().trim().length == 0) {
				toastr.error("Debe ingresar un login de usuario");
			 	e.preventDefault(); 
			} else {
				if (!validarNombreUsuario(loginUser)){
					toastr.error("El usuario debe tener entre 4 y 15 caracteres sin espacios. Únicamente puede contener letras");
				 	e.preventDefault(); 					
				} else {				
					if ($('#pswUsuario').val().trim().length == 0 || $('#pswConfirm').val().trim().length == 0) {
						toastr.error("Debe ingresar el Password y la Confirmacion de Password");
				 		e.preventDefault(); 
				 	} else {
						if ($('#pswUsuario').val().trim() != $('#pswConfirm').val().trim()) {
								toastr.error("El password y la Confirmación no coinciden");
				 				e.preventDefault(); 
							} else { 	
								if(!(validarEmail(emailDoctor)||emailDoctor.trim()=='')){
									toastr.error("El correo ingresado no es válido");
				 					e.preventDefault();
								} else {															
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
											$("#AgregarFormModal")[0].reset();
							            	if (data.success){
							                	toastr.success("Se agrego con exito el Usuario");
							                	getListadoUsuarios()
							            	} else {
							                	toastr.error("Error al agregar el Usuario")
							            	}								
				        				}
				   					 })
								}
							}
				  		}
					}
				}
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
                            '<label for="usuario-' + element.codUsuario + '" class="text">' + element.loginUsuario + '</label>',
							'<label for="usuario-' + element.codUsuario + '" class="text">' + element.nombresDoctor + '</label>',
							'<label for="usuario-' + element.codUsuario + '" class="text">' + element.apellidosDoctor + '</label>',
							'<label for="usuario-' + element.codUsuario + '" class="text">' + element.emailUsuario + '</label>',
							'<label for="usuario-' + element.codUsuario + '" class="text">' + devuelveEstado(element.estado) + '</label>',
                            '<div class="btn-group" >'
                            + '<button type="button" class="btn btn-light" data-modificar-usuario="true" ' + data + ' data-toggle="modal"  id="modifUsuarioBtn" data-target="#modificarUsuarioModal" ><i class="fas fa-edit"></i></button>'
                            + '<button type="button" class="btn btn-light" data-baja-usuario="true" ' + data + ' data-toggle="modal" data-target="#darBajaUsuarioModal" id="darBajaPresentacionModalBtn"><i class="fas fa-times"></i></button>'
                            + '</div>'
                        ]
                        usuariosTable.row.add(row).draw(false);
                    });
                    $('input[type=radio][name=usuario]').unbind('change');
                    //$('[data-modificar-usuario]').unbind('click');
                    //$('[data-modificar-usuario]').click(setUsuarioDataModificar);
                    //$('[data-baja-usuario]').unbind('click');
                    //$('[data-baja-usuario]').click(setUsuarioDataDarBaja);
                } else {
                    toastr.error("No se pudo obtener el listado de Usuarios");
                }
            }
        });
    }

    $(document).on('click', '[data-modificar-usuario]', setUsuarioDataModificar);
    $(document).on('click', '[data-baja-usuario]', setUsuarioDataDarBaja);


     function setUsuarioDataDarBaja() {
        $('#codigoUsuarioBaja').text($(this).data('codigo-usuario'))
        $('#loginUsuarioBaja').text($(this).data('nombre-usuario'))
    }

    function setUsuarioDataModificar(){	
	 var loginUsuario = $(this).data('nombre-usuario'); 
               var datos = {
					"accion": 'BUSCAR',
					"loginUser": loginUsuario
				};
				$.post('UsuarioServlet.do', datos, callback2, 'json');

				function callback2(respuesta) {
					if(respuesta.data)
					{ //console.log(respuesta.data);
						$('#codigoUsuarioMod').val(respuesta.data.codUsuario);	
						$('#loginUsuarioMod').val(respuesta.data.loginUsuario);	
						$('#nombresUsuarioMod').val(respuesta.data.nombresDoctor); 
						$('#apellidosUsuarioMod').val(respuesta.data.apellidosDoctor);
        				$('#colegiadoUsuarioMod').val(respuesta.data.numColegiado);
        				$('#emailUsuarioMod').val( respuesta.data.emailUsuario);
        				$('#tipUsuarioMod').val(respuesta.data.tipoUsuario);				
			    	}
			 else 
				{
					 toastr.error("No se pudo obtener la información del Usuario");
				}
    }
   }


    $('#btnCancelAgregarUsuario').click(function(){
         getListadoUsuarios();
 		 $("#AgregarFormModal")[0].reset();
    });
	
    $('#btnCancelModifUsuario').click(function(){
       //  getListadoUsuarios();
 		 $("#ModificarFormModal")[0].reset();
    });
	

    $('#btnModificarUsuario').click(function(e){
        var codigoUsuario = $('#codigoUsuarioMod').val();
        var loginUser = $('#loginUsuarioMod').val();
		var nombresDoctor =  $('#nombresUsuarioMod').val();
		var apellidosDoctor = $('#apellidosUsuarioMod').val();
		var emailDoctor = $('#emailUsuarioMod').val();
		var colegiadoDoctor = $('#colegiadoUsuarioMod').val();
		var tipoUsuario = $('#tipUsuarioMod').val();

		if ($('#nombresUsuarioMod').val().trim() == "" || $('#apellidosUsuarioMod').val().trim() == "") {
			 toastr.error("Debe ingresar por lo menos un nombre y un apellido de usuario");
			 e.preventDefault(); 
		} else { 	
			if(!(validarEmail(emailDoctor)||emailDoctor.trim()=='')){
				toastr.error("El correo ingresado no es válido");
				e.preventDefault();
			} else {
		        $.ajax({
		            url: 'UsuarioServlet.do',
		            method: 'post',
		            data: {
		                accion: 'MODIFICAR',
		                loginUser: loginUser,
						nombresDoctor: nombresDoctor,
						apellidosDoctor: apellidosDoctor,
						emailDoctor: emailDoctor,
						colegiadoDoctor: colegiadoDoctor,
						tipoUsuario: tipoUsuario,
		            },
		            success: function(response) {
		                $('#modificarUsuarioModal').modal('hide');
						$("#ModificarFormModal")[0].reset();
		                if (response.success){
		                    toastr.success("Se modifico con exito el Usuario");
		                    getListadoUsuarios();
		                } else {
		                    toastr.error("Error al modificar el Usuario");
		                }
		            }
		        });
			}	
		}
	//e.preventDefault();
    });

		Messenger.options = {
			extraClasses : 'messenger-fixed messenger-on-top',
			theme : 'flat'
		};	


  $('#btnReinicioPswUsuario').click(function(e){
        var loginUser = $('#loginUsuarioMod').val();	

		if ($('#nombresUsuarioMod').val().trim() == "" || $('#apellidosUsuarioMod').val().trim() == "") {
			 toastr.error("Debe ingresar por lo menos un nombre y un apellido de usuario");
			 e.preventDefault(); 
		} else { 

		var mensajito=Messenger().post({
			message:"¿Está seguro que desea restablecer la contraseña del usuario : " + loginUser+"?",
		  	type:'info',
		  	showCloseButton:true,
		  	id:1,
		  	hideAfter:36000,
		  	actions: {
		  		aceptar: {
		 			label: "Aceptar",
		   			action: function(){  //ejecutarComando();
							mensajito.hide();		
					        $.ajax({
				            url: 'UsuarioServlet.do',
				            method: 'post',
				            data: {
				                accion: 'REINICIO_PSW',
				                loginUser: loginUser,
				            },
				            success: function(response) {
				                $('#modificarUsuarioModal').modal('hide');
								$("#ModificarFormModal")[0].reset();
				                if (response.success){
				                    toastr.success("Se reinicio con exito la contraseña Usuario");
				                    getListadoUsuarios();
				                } else {
				                    toastr.error("Error al reiniciar la contraseña del Usuario");
				                }
				            }
				        });	
		
						}
		    	},
		   		cancelar: {
			 		label: "Cancelar",
			   		action: function(){mensajito.hide();}
					}
		  		}
			});			
		
		}
	//e.preventDefault();
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