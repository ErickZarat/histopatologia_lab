
$(document).ready(function(e) {

    var pacientesTable = $('#pacientesTable').DataTable(window.coreTableConfig);
    pacientesTable.rows().remove().draw(false);  

	getListadoPacientes(); 

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
				

		if ($('#nombresPaciente').val().trim() == "" || $('#apellidosPaciente').val().trim() == "") {
			 toastr.error("Debe ingresar por lo menos un nombre y un apellido del paciente");
			 e.preventDefault(); 
		} else {
			if ($('#direccionPaciente').val().trim().length == 0) {
				toastr.error("Debe ingresar una dirección para el paciente");
			 	e.preventDefault(); 
			} else {
				if ($('#fecNacimientoPaciente').val().trim().length == 0) {
					toastr.error("Debe ingresar una fecha de nacimiento para el paciente");
			 		e.preventDefault(); 	
				} else {
					if   ( ($('#emailPaciente').val().trim().length != 0) == (!(validarEmail(emailPaciente))))  {
						toastr.error("El formato del correo del paciente no es correcto");
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
								numficha : numficha,				
				            },
				            success: function(data) {
	
				                if (data.success){
					                $('#agregarPacienteModal').modal('hide');
		 							$("#CreaPacienteFormModal")[0].reset();				
				                    toastr.success("Se agregó con exito el paciente");
				                    getListadoPacientes()
				                } else {
				                    toastr.error(data.error)
				                }
				            }
				        })
					}
				}
			}
	  	}
	e.preventDefault();
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
	
	function validarEmail(email) { 
		    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		    return re.test(email);
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
					{   //console.log(respuesta.data); // codigoPacienteMod
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
    });
	
	
    $('#btnCancelModifPaciente').click(function(){
 		 $("#ModFormPacienteModal")[0].reset();
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
		alert(numficha); 
		


		if ($('#nombresPacienteMod').val().trim() == "" || $('#apellidosPacienteMod').val().trim() == "") {
			 toastr.error("Debe ingresar por lo menos un nombre y un apellido del paciente");
			 e.preventDefault(); 
		} else {
			if ($('#direccionPacienteMod').val().trim().length == 0) {
				toastr.error("Debe ingresar una dirección para el paciente");
			 	e.preventDefault(); 
			} else {
				if ($('#fecNacimientoPacienteMod').val().trim().length == 0) {
					toastr.error("Debe ingresar una fecha de nacimiento para el paciente");
			 		e.preventDefault(); 	
				} else {
					if ( ($('#emailPacienteMod').val().trim().length != 0) == (!(validarEmail(emailPaciente))))  {
						toastr.error("El formato del correo del paciente no es correcto");
				 		e.preventDefault(); 						
					} else {	

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
								$('#numFichaPacienteMod').val("");
				                if (respuesta.success){
				                    toastr.success("Se modificó con éxito el Paciente");
				                    getListadoPacientes();
				                } else {
									
				                    toastr.error(respuesta.error);
				                }
				            }
				        });
					}
				}
			}
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
                    toastr.error(response.error);
                }
            }
        });
    });




});