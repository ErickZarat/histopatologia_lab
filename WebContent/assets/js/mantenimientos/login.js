
$(document).ready(function() {
	
	var opcion = $('#opcionSelec').val();
	if ($('#opcionSelec').val().trim() == "CAMBIO") {
		
		$("#cambioPswUsuarioModal").modal("show");
	}
	else 
	{	
		$("#logoutUsuarioModal").modal("show");
	}


 	$('#btnCambioPsw').click(function(e){
		var loginUser = $('#username').val().toUpperCase().trim();
		alert(loginUser);
		var passUser = $('#pswUsuario').val();
		if ($('#nuevoPassword').val().trim().length == 0 || $('#confirNuevoPassword').val().trim().length == 0) {
			toastr.error("Debe ingresar la contraseña y la Confirmacion de Contraseña");
			e.preventDefault(); 
		} else { 	
			if ($('#nuevoPassword').val().trim() != $('#confirNuevoPassword').val().trim()) {
				toastr.error("La contraseña y la Confirmación no coinciden");
				e.preventDefault();
			}
		}
    });

    $('#btnAgregarUsuario').click(function(e){
        var loginUser = $('#loginUsuario').val().toUpperCase().trim();
		var nombreUsuario = $('#nombreUsuario').val();
		var apellidosUsuario = $('#apellidosUsuario').val().toUpperCase();
		var colegiadoDoctor = $('#colegiadoDoctor').val().trim();
		var emailDoctor = $('#emailDoctor').val().trim();
		var passUser = $('#pswUsuario').val();
		var tipoUsuario = $('#tipoUsuarioSearch').val();
		//var tipoUsuario = $('#tipoUsuario').val();


		
		if ($('#loginUsuario').val().trim().length == 0) {
			 toastr.error("Debe ingresar un login de usuario");
			 e.preventDefault(); 
		} else { 
			if (!validarNombreUsuario(loginUser)){
				toastr.error("El usuario debe tener entre 4 y 15 caracteres sin espacios. Únicamente puede contener letras");
			 	e.preventDefault(); 
			} else {
				if ($('#nombreUsuario').val().trim() == "" || $('#apellidosUsuario').val().trim() == "") {
					toastr.error("Debe ingresar por lo menos un nombre y un apellido de usuario");
				 	e.preventDefault(); 					
				} else {			
					//if (!(validarEmail(emailDoctor)) || (emailDoctor.trim()== "")){	
					if (emailDoctor.trim()== "" || (!(validarEmail(emailDoctor)))) {
						toastr.error("El correo ingresado no es válido");
				 		e.preventDefault(); 
				 	} else {
						if ($('#pswUsuario').val().trim().length == 0 || $('#pswConfirm').val().trim().length == 0) {
								toastr.error("Debe ingresar la contraseña y la Confirmacion de Contraseña");
				 				e.preventDefault(); 
							} else { 	
								if ($('#pswUsuario').val().trim() != $('#pswConfirm').val().trim()) {
									toastr.error("La contraseña y la Confirmación no coinciden");
				 					e.preventDefault();
								} else {	
									if (tipoUsuario == 0) {
										toastr.error("Debe seleccionar un tipo de Usuario");
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
			}
		//e.preventDefault();
    });



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
        				//$('#tipUsuarioMod').val(respuesta.data.tipoUsuario);
						//$("#tipoUsuarioModSearch").val(respuesta.data.tipoUsuario);
						$("#tipoUsuarioModSearch").val(respuesta.data.tipoUsuario);			
			    	}
			 else 
				{
					 toastr.error("No se pudo obtener la información del Usuario");
				}
    }
   }


    $('#btnCancelCerrarSesion').click(function(){
 		 $("#logoutUsuarioModal")[0].reset();
    });
	
    $('#btnCancelCambioPsw').click(function(){
 		 $("#cambioPswUsuarioModal")[0].reset();
    });
	

    $('#btnModificarUsuario').click(function(e){
        var codigoUsuario = $('#codigoUsuarioMod').val();
        var loginUser = $('#loginUsuarioMod').val();
		var nombresDoctor =  $('#nombresUsuarioMod').val();
		var apellidosDoctor = $('#apellidosUsuarioMod').val();
		var emailDoctor = $('#emailUsuarioMod').val();
		var colegiadoDoctor = $('#colegiadoUsuarioMod').val();
		//var tipoUsuario = $('#tipUsuarioMod').val();
		var tipoUsuario = $('#tipoUsuarioModSearch').val();


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



});