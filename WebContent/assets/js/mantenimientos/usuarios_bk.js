
$(document).ready(function() {

	//$("#AgregarFormModal").validate();

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
		
	jQuery.validator.setDefaults({
  		debug: true,
  		success: "valid"
	});
	

	$.validator.addMethod("loginFormato", function(value, element) {
                return this.optional(element) || /^[a-zA-Z0-9\_\-]{7,20}$/i.test(value);
	}, "El login ingresado es inválido.");	
	
	$.validator.addMethod("textoFormato", function(value, element) {
                return this.optional(element) || /^[a-zA-ZÀ-ÿ\s]{1,40}$/i.test(value);
	}, "El nombre ingresado es incorrecto.");
	
	$.validator.addMethod("emailFormato", function(value, element) {
                return this.optional(element) || /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/i.test(value);
	}, "El email es inválido.");
	
	
	var validar_formulario = $("#AgregarFormModal").validate({
 	rules :{
                loginUsuario : { required : true, loginFormato: true, minlength : 7, maxlength : 20  },
                nombreUsuario : { required : true, textoFormato: true, minlength : 3, maxlength : 50 },
				apellidosUsuario: { required : true, minlength : 3, maxlength : 50 }, 
				colegiadoDoctor:  { required : false},
                emailDoctor : { required : false, emailFormato :true, minlength : 7, maxlength : 50 },
				pswUsuario : { required : true, emailFormato :true, minlength : 7, maxlength : 50 },
				pswConfirm : { required : true, emailFormato :true, minlength : 7, maxlength : 50 },
				tipoUsuarioSelect:  { required : false,  maxlength : 14 },						
            },
            messages : {
                loginUsuario : {
                    required : "Debe ingresar el login ",
 					minlength : "El login debe tener un mínimo de 7 caracteres",
					maxlength : "El máximo deben ser 20 caracteres"
                },
                nombreUsuario : {
                    required : "Debe ingresar un apellido",
                    minlength : "El apellido debe tener un mínimo de 3 caracteres",
                    maxlength : "El máximo deben ser 30 caracteres"
                },
                apellidosUsuario : {
                    required : "Debe ingresar una dirección",
                    minlength : "Debe ingresar un valor para la dirección"
                },
                emailPaciente : {
                    required : "Debe ingresar el email",
                    minlength : "El email es incorrecto"
                },
                tipoUsuarioSelect : {
                    required : "Debe seleccionar el tipo de usuario",
                    minlength : "El número de identificación es inválido"
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
								            	if (data.success){
													$('#agregarUsuarioModal').modal('hide');
													$("#AgregarFormModal")[0].reset();
								                	toastr.success("Se agregó con éxito el Usuario");
								                	getListadoUsuarios()
								            	} else {
								                	toastr.error(data.error);
													e.preventDefault();
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
                        var data = ' data-codigo-usuario="' + element.codUsuario + '" data-nombre-usuario="' + element.loginUsuario + '" '+ '" data-estado-usuario="' + devuelveEstado(element.estado) + '" ';
                        var row = [
                            '<input type="radio" name="usuario" data-nombre-usuario="'+element.loginUsuario+'" id="usuario-' + element.codUsuario + '" value="' + element.codUsuario + '"/>',
                            '<label for="usuario-' + element.codUsuario + '">' + element.codUsuario + '</label>',
                            '<label for="usuario-' + element.codUsuario + '" class="text">' + element.loginUsuario + '</label>',
							'<label for="usuario-' + element.codUsuario + '" class="text">' + element.nombresDoctor + '</label>',
							'<label for="usuario-' + element.codUsuario + '" class="text">' + element.apellidosDoctor + '</label>',
							'<label for="usuario-' + element.codUsuario + '" class="text">' + element.emailUsuario + '</label>',
							'<label for="usuario-' + element.codUsuario + '" class="text">' + devuelveEstado(element.estado) + '</label>',
                            '<div class="btn-group" >'
                            + '<button type="button" class="btn btn-light" data-modificar-usuario="true" ' + data + ' data-toggle="modal"  id="modifUsuarioBtn" data-target="#modificarUsuarioModal" data-toggle="tooltip" data-placement="right" title="Modificar Usuario"><i class="fas fa-edit"></i></button>'
                            + '<button type="button" class="btn btn-light" data-baja-usuario="true" ' + data + ' data-toggle="modal" data-target="#darBajaUsuarioModal" id="darBajaUsuarioModalBtn" data-toggle="tooltip" data-placement="right" title="Cambio de Estado"><i class="fas fa-toggle-on"></i></button>'
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
 		$('#estadoUsuarioBaja').text($(this).data('estado-usuario'))
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

		                if (response.success){
					    	$('#modificarUsuarioModal').modal('hide');
							$("#ModificarFormModal")[0].reset();
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


	   $('#btnCambioEstadoUsuario').click(function(e){
        var loginUser = $('#loginUsuarioBaja').text();
		var estadoUsuarioBaja = $('#estadoUsuarioBaja').text().trim();

        $.ajax({
            url: 'UsuarioServlet.do',
            method: 'post',
            data: {
                accion: 'CAMBIO_ESTADO',
                loginUser: loginUser,
				estadoUsuarioBaja: estadoUsuarioBaja			
            },
            success: function(response) {
                $('#darBajaUsuarioModal').modal('hide');
                $('#loginUsuarioBaja').text("")
				$('#estadoUsuarioBaja').text("");
                if (response.success){
                    toastr.success("Se cambió el estado del usuario con éxito");
                    getListadoUsuarios();
                } else {
                    toastr.error(response.error);
                }
            }
        });
    });




});