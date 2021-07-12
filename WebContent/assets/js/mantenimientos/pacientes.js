
$(document).ready(function(e) {

    var pacientesTable = $('#pacientesTable').DataTable(window.coreTableConfig);
    pacientesTable.rows().remove().draw(false);  

	getListadoPacientes(); 
	
	
	jQuery.validator.setDefaults({
  		debug: true,
  		success: "valid"
	});
	
	$.validator.addMethod("telefonoFormato", function(value, element) {
                return this.optional(element) || /^\d{7,14}$/i.test(value);
	}, "El telefono ingresado es inválido.");
	
	$.validator.addMethod("emailFormato", function(value, element) {
                return this.optional(element) || /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/i.test(value);
	}, "El correo es inválido.");
	
	$.validator.addMethod("formatoFecha", function(value, element) {
                return this.optional(element) || /^(0[1-9]|1\d|2\d|3[01])\/(0[1-9]|1[0-2])\/(19|20)\d{2}$/i.test(value);
	}, "La fecha es inválida.");
	
	var validar_formulario = $("#CreaPacienteFormModal").validate({
 	rules :{
                nombresPaciente : { required : true, minlength : 3, maxlength : 50  },
                apellidosPaciente : { required : true, minlength : 3, maxlength : 30 },
				direccionPaciente: { required : true, minlength : 3, maxlength : 250 }, 
				numIdPaciente:  { required : false},
                telPaciente : { required : false, telefonoFormato :true, minlength : 7, maxlength : 14 },
				emailPaciente : { required : false, emailFormato :true, minlength : 7, maxlength : 50 },
                fecNacimientoPaciente : { required : true, formatoFecha :true },
				numIdPaciente:  { required : false,  maxlength : 14 },
				ocupacionPaciente:  { required : false,  maxlength : 50 },
				numFichaPaciente : { required : true, minlength : 2, maxlength : 25 },							
            },
            messages : {
                nombresPaciente : {
                    required : "Debe ingresar al menos un nombre ",
 					minlength : "El nombre debe tener un mínimo de 3 caracteres",
					maxlength : "El máximo deben ser 50 caracteres"
                },
                apellidosPaciente : {
                    required : "Debe ingresar un apellido",
                    minlength : "El apellido debe tener un mínimo de 3 caracteres",
                    maxlength : "El máximo deben ser 30 caracteres"
                },
                direccionPaciente : {
                    required : "Debe ingresar una dirección",
                    minlength : "Debe ingresar un valor para la dirección"
                },
                telPaciente : {
                    required : "Debe ingresar el teléfono",
                    minlength : "EL telefono debe tener un mínimo de 7 dígitos"
                },
                emailPaciente : {
                    required : "Debe ingresar el email",
                    minlength : "El email es incorrecto"
                },
                fecNacimientoPaciente : {
                    required : "Fecha de nacimiento requerida",
                    minlength : "La fecha de nacimiento debe ser válida"
                },
                numIdPaciente : {
                    required : "Debe ingresar el número de identificación",
                    minlength : "El número de identificación es inválido"
                },
                numFichaPaciente : {
                    required : "Debe ingresar si el paciente posee ficha",
                    minlength : "Debe ingresar un valor"
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
	

    $('#btnAgregarPaciente').click(function(e){
        var idPaciente = $('#numIdPaciente').val().trim().toUpperCase();
		var nomPaciente = $('#nombresPaciente').val().trim();
		var apellidosPaciente = $('#apellidosPaciente').val().trim();
		var dirPaciente = $('#direccionPaciente').val().trim();
		var telPaciente = $('#telPaciente').val().trim();
		var fecNacimiento = $('#fecNacimientoPaciente').val();
		var generoPaciente = $('#generoPaciente').val();
		var ocupacionPaciente = $('#ocupacionPaciente').val().trim();
		var tipoIdPaciente = $('#tipoIdPaciente').val();
		var emailPaciente = $('#emailPaciente').val().trim();
		var estCivilPaciente = $('#estadoCivilPacienteSearch').val();
		var numficha		= $('#numFichaPaciente').val().trim();

 		if (validar_formulario.form()) //asi se comprueba si el form esta validado o no
    	{       
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
				numficha : numficha,				
            },
            success: function(data) {

                if (data.success){
	                $('#agregarPacienteModal').modal('hide');
					$("#CreaPacienteFormModal")[0].reset();				
                    toastr.success("Se agregó con éxito el paciente");
                    getListadoPacientes();
                } else {
                    toastr.error(data.error);
					e.preventDefault();
                }
            }
        })
		} else {
			e.preventDefault();
		}
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
							'<label for="paciente-' + element.codigoPaciente + '" class="text">' + element.tipoidPaciente + '</label>',	
							'<label for="paciente-' + element.codigoPaciente + '" class="text">' + element.identificacionPaciente + '</label>',
							'<label for="paciente-' + element.codigoPaciente + '" class="text-capitalize">' + element.estCivilPaciente + '</label>',
                            '<div class="btn-group" >'
                            + '<button type="button" class="btn btn-light" data-modificar-paciente="true" ' + data + ' data-toggle="modal"  id="modifPacienteBtn" data-target="#modificarPacienteModal" data-toggle="tooltip" data-placement="right" title="Modificar Datos Paciente"><i class="fas fa-edit"></i></button>'
                            + '<button type="button" class="btn btn-light" data-baja-paciente="true" ' + data + ' data-toggle="modal" data-target="#darBajaPacienteModal" id="darBajaPacienteModalBtn"><i class="far fa-calendar"></i></button>'
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


	function convertirfecha(fecha) {
		var strYear = fecha.substr(0,4);
		fecha = fecha.substr(5,fecha.length-5) ; 
		var posicion=fecha.indexOf("-");
		var strMonth = fecha.substr(0,2); 
		var strDay = fecha.substr(posicion+1,2); 
		var StrFecha = strDay +"/"+strMonth +"/"+strYear; 
		return StrFecha;
	} 
	

   function setPacienteDataModificar(){	
	 var codPaciente =  $(this).data('codigo-paciente'); 
       var datos = {
			"accion": 'BUSCAR',
			"codPaciente": codPaciente
		};
		$.post('PacienteServlet.do', datos, callback2, 'json');


		function callback2(respuesta) {
		if(respuesta.data)
			{   
				$('#codigoPacienteMod').val(codPaciente);
				$('#nombresPacienteMod').val(respuesta.data.nombrePaciente);	
				$('#apellidosPacienteMod').val(respuesta.data.apellidosPaciente);	
				$('#direccionPacienteMod').val(respuesta.data.direccionPaciente); 
				$('#telefonoPacienteMod').val(respuesta.data.telefonoPaciente);
				$('#fecNacimientoPacienteMod').val(convertirfecha(respuesta.data.fecNacimientoPaciente));
				$('#generoPacienteMod').val( respuesta.data.generoPaciente);
				$('#ocupacionPacienteMod').val(respuesta.data.ocupacionPaciente);
				$('#tipoIdPacienteMod').val(respuesta.data.tipoidPaciente);
				$('#numIdPacienteMod').val(respuesta.data.identificacionPaciente);
				$('#emailPacienteMod').val(respuesta.data.emailPaciente);
				$('#estCivilPacienteMod').val(respuesta.data.estCivilPaciente);	
				$('#numFichaPacienteMod').val(respuesta.data.num_ficha);
													
	    	}
	 	else 
			{
			 toastr.error(respuesta.error);
			}
         
    }
   }


    $('#btnCancelAgregarPaciente').click(function(){
         getListadoPacientes();
 		 $("#CreaPacienteFormModal")[0].reset();
		 $('#agregarPacienteModal label.error').hide();
    });
	
	
    $('#btnCancelModifPaciente').click(function(){
 		$("#ModFormPacienteModal")[0].reset();
		$('#modificarPacienteModal label.error').hide();
    });
	
		
	// funcion al cerrar el modal de crear 
	 $("#agregarPacienteModal").on('hidden.bs.modal', function () {
		$('#agregarPacienteModal label.error').hide();
    });
	
		// funcion al cerrar el modal de modificar 
	 $("#modificarPacienteModal").on('hidden.bs.modal', function () {
		$('#modificarPacienteModal label.error').hide();
    });
	

	var validar_formularioMod = $("#ModFormPacienteModal").validate({
 	rules :{
                nombresPacienteMod : { required : true, minlength : 3, maxlength : 50  },
                apellidosPacienteMod : { required : true, minlength : 3, maxlength : 30 },
				direccionPacienteMod: { required : true, minlength : 3, maxlength : 250 }, 
				numIdPacienteMod:  { required : false},
                telefonoPacienteMod : { required : false, telefonoFormato :true, minlength : 7, maxlength : 14 },
				emailPacienteMod : { required : false, emailFormato :true, minlength : 7, maxlength : 50 },
                fecNacimientoPacienteMod : { required : true, formatoFecha :true },
				numIdPaciente:  { required : false,  maxlength : 14 },
				ocupacionPacienteMod:  { required : false,  maxlength : 50 },
				numFichaPacienteMod : { required : true, minlength : 2, maxlength : 25 },							
            },
            messages : {
                nombresPacienteMod : {
                    required : "Debe ingresar al menos un nombre ",
 					minlength : "El nombre debe tener un mínimo de 3 caracteres",
					maxlength : "El máximo deben ser 50 caracteres"
                },
                apellidosPacienteMod : {
                    required : "Debe ingresar un apellido",
                    minlength : "El apellido debe tener un mínimo de 3 caracteres",
                    maxlength : "El máximo deben ser 30 caracteres"
                },
                direccionPacienteMod : {
                    required : "Debe ingresar una dirección",
                    minlength : "Debe ingresar un valor para la dirección"
                },
                telefonoPacienteMod : {
                    required : "Debe ingresar el teléfono",
                    minlength : "EL telefono debe tener un mínimo de 7 dígitos"
                },
                emailPacienteMod : {
                    required : "Debe ingresar el email",
                    minlength : "El email es incorrecto"
                },
                fecNacimientoPacienteMod : {
                    required : "Fecha de nacimiento requerida",
                    minlength : "La fecha de nacimiento debe ser válida"
                },
                numIdPacienteMod : {
                    required : "Debe ingresar el número de identificación",
                    minlength : "El número de identificación es inválido"
                },
                numFichaPacienteMod : {
                    required : "Debe ingresar si el paciente posee ficha",
                    minlength : "Debe ingresar un valor"
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
	



    $('#btnModificarPaciente').click(function(e){
        var codPaciente = $('#codigoPacienteMod').val();
		var nomPaciente = $('#nombresPacienteMod').val().trim();
		var apellidosPaciente = $('#apellidosPacienteMod').val().trim();
		var dirPaciente = $('#direccionPacienteMod').val().trim();
		var telPaciente = $('#telefonoPacienteMod').val().trim();
		var fecNacimiento = $('#fecNacimientoPacienteMod').val();
		var generoPaciente = $('#generoPacienteMod').val();
		var ocupacionPaciente = $('#ocupacionPacienteMod').val().trim();
		var tipoIdPaciente = $('#tipoIdPacienteMod').val();
		var emailPaciente = $('#emailPacienteMod').val().trim();
		var estCivilPaciente = $('#estCivilPacienteMod').val();
		var numIdPaciente =  $('#numIdPacienteMod').val();
		var numficha		= $('#numFichaPacienteMod').val().trim();

	if (validar_formularioMod.form()) //asi se comprueba si el form esta validado o no
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
					tipIdPaciente: tipoIdPaciente,
					numIdPaciente: numIdPaciente, 
					telPaciente: telPaciente,
					ocupacionPaciente: ocupacionPaciente,
					emailPaciente: emailPaciente,
					generoPaciente: generoPaciente,
					estCivilPaciente: estCivilPaciente,
					fecNacimiento: fecNacimiento,
					numficha: numficha,
	            },
	            success: function(respuesta) {
	                if (respuesta.success){
		               	$('#modificarPacienteModal').modal('hide');
						$("#ModFormPacienteModal")[0].reset();				
                    	toastr.success("Se modificó con éxito el Paciente");
                    	getListadoPacientes();			
	                } else {
						
	                    toastr.error(respuesta.error);
	                }
	            }
	        });
		} else {
			e.preventDefault();
		}
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
                    toastr.error(response.error);
                }
            }
        });
    });




});