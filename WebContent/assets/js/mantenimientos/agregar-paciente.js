$(document).ready(function(){
	
	
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
                success: function(response) {
                    $('#agregarPacienteModal').modal('hide');
                    $("#CreaPacienteFormModal")[0].reset();
                    if (response.success){
                        toastr.success("Se agrego con éxito el paciente");
                        try {
                            selectPaciente(response.data)
                        } catch (e) {
                        }
                        try {
                            getListadoPacientes()
                        } catch(e){
                        }
                    } else {
                        toastr.error("Error al agregar Paciente")
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


    $('#btnCancelAgregarPaciente').click(function(){
        $("#CreaPacienteFormModal")[0].reset();
		$('#agregarPacienteModal label.error').hide();
    });


	// funcion al cerrar el modal de crear 
	 $("#agregarPacienteModal").on('hidden.bs.modal', function () {
		$('#agregarPacienteModal label.error').hide();
    });

})
