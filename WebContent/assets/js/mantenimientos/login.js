
$(document).ready(function() {
	
	var opcion = $('#opcionSelec').val();
	if ($('#opcionSelec').val().trim() == "CAMBIO") {
		
		$("#cambioPswUsuarioModal").modal("show");
	}
	else 
	{	
		$("#logoutUsuarioModal").modal("show");
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


  $('#btnCambioPsw').click(function(e){
        var loginUser = $('#loginUsuario').val();	
		var pswAnterior = $('#passwordAnterior').val();
		var pswActual = $('#nuevoPassword').val();
		
	if ($('#passwordAnterior').val().trim().length == 0) {
				toastr.error("Debe ingresar la contraseña actual");
					e.preventDefault(); 
			} else { 		
				if ($('#nuevoPassword').val().trim().length == 0 || $('#confirNuevoPassword').val().trim().length == 0) {
						toastr.error("Debe ingresar la nueva contraseña y la ConfirmaciÓ de Contraseña");
						e.preventDefault(); 
				} else { 	
					if ($('#nuevoPassword').val().trim() != $('#confirNuevoPassword').val().trim()) {
						toastr.error("La nueva contraseña y la Confirmación no coinciden");
						e.preventDefault();		
					} else {
						var mensajito=Messenger().post({
							message:"¿Está seguro que desea cambiar su contraseña?",
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
								                accion: 'CAMBIO_PSW',
								                loginUser: loginUser,
												pswAnterior: pswAnterior,
												pswActual :pswActual,
								            },
								            success: function(response) {
								                if (response.success){
									                $('#cambioPswUsuarioModal').modal('hide');
													$("#CambioPswFormModal")[0].reset();									
								                    toastr.success("Se cambio con éxito la contraseña");
								                } else {
								                    toastr.error(response.error);
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
							});		// mensajito
					}				 	
				}	 	
			} // else de condiciones 
		e.preventDefault();
    });



});