
$(document).ready(function() {
	
	var opcion = $('#opcionSelec').val();
	if ($('#opcionSelec').val().trim() == "CAMBIO") {
		
		$("#cambioPswUsuarioModal").modal("show");
	}
	else 
	{	
		$("#logoutUsuarioModal").modal("show");
	}



	Messenger.options = {
		extraClasses : 'messenger-fixed messenger-on-top',
		theme: 'future'
	};	

	jQuery.validator.setDefaults({
  		debug: true,
  		success: "valid"
	});
	

  
    $('#btnCancelCerrarSesion').click(function(){
 		 $("#logoutUsuarioModal")[0].reset();
    });
	
    $('#btnCancelCambioPsw').click(function(){
 		$("#CambioPswFormModal")[0].reset();
		$('#cambioPswUsuarioModal label.error').hide();
		
    });
	
	$.validator.addMethod("loginFormato", function(value, element) {
                return this.optional(element) || /^[a-zA-Z0-9\_\-]{7,20}$/i.test(value);
	}, "El login ingresado es inválido.");	

	var validar_formularioMod = $("#CambioPswFormModal").validate({
 	rules :{
 			passwordAnterior : { required : true, loginFormato :true,  minlength : 6, maxlength : 50 },							
            nuevoPassword : { required : true, loginFormato :true,  minlength : 6, maxlength : 50 },
			confirNuevoPassword : { required : true, loginFormato :true, equalTo: '#nuevoPassword', minlength : 6, maxlength : 50 },               
            },
            messages : {
                nuevoPassword : {
                    required : "Debe ingresar el nuevo Password",
                    minlength : "El Password es incorrecto",
                    maxlength : "El máximo deben ser 50 caracteres"
                },
                confirNuevoPassword : {
                    required : "Debe ingresar la confirmación del password",
					equalTo: "El password y la Confirmación no coinciden", 
                    minlength : "El password es incorrecto"
                },
                passwordAnterior : {
                    required : "Debe ingresar el Password anterior",
                    minlength : "El Password ingresado es incorrecto"
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
		


  $('#btnCambioPsw').click(function(e){
        var loginUser = $('#loginUsuario').val();	
		var pswAnterior = $('#passwordAnterior').val();
		var pswActual = $('#nuevoPassword').val();
		
	 	if (validar_formularioMod.form()) //asi se comprueba si el form esta validado o no
    	{ 	
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
		} else {
			e.preventDefault();
		}
    });


/* $('#btnCerrarSesion').click(function(e){
		//$('#logoutUsuarioModal').modal('hide');
         var loginUser = $('#loginUsuario').val();	
		        $.ajax({
	            url: 'UsuarioServlet.do',
	            method: 'post',
	            data: {
	                accion: 'CONFIRM_SALIR',
	                loginUser: loginUser
	            },
	            success: function(response) {
	                if (response.success){

						$("#CambioPswFormModal")[0].reset();									
	                    toastr.success("Se cambio con éxito la contraseña");
	                } else {
	                    toastr.error(response.error);
	                }
	            }
	        });
    });*/
});