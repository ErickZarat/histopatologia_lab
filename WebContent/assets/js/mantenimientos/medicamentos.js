
$(document).ready(function() {

    var medicamentosTable = $('#medicamentosTable').DataTable(window.coreTableConfig);
    var presentacionMedicamentosTable = $('#presentacionMedicamentosTable').DataTable(window.coreTableConfig);


	jQuery.validator.setDefaults({
  		debug: true,
  		success: "valid"
	});
	
	$.validator.addMethod("formatoSoloTexto", function(value, element) {
                return this.optional(element) || /^[a-zA-ZÀ-ÿ\s]{1,40}$/i.test(value);
	}, "Solo se permite ingresar letras.");
	

	var validar_formulario = $("#AddMedicamentoFormModal").validate({
 	rules :{
                nombreMedicamento : { required : true, formatoSoloTexto: true,  minlength : 3, maxlength : 50  },
			
            },
            messages : {
                nombreMedicamento : {
                    required : "Debe ingresar el nombre del medicamento ",
 					minlength : "El nombre debe tener un mínimo de 3 caracteres",
					maxlength : "El máximo deben ser 50 caracteres", 
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

	

    $('#btnAgregarMedicamento').click(function(e){
        var nombre = $('#nombreMedicamento').val();
        var tipoMedicamento = $('#tipoMedicamentoSearch').val();

	if (validar_formulario.form()) //asi se comprueba si el form esta validado o no
    	{ 

        $.ajax({
            url: 'MedicamentosServlet.do',
            method: 'post',
            data: {
                accion: 'CREAR',
                nombre: nombre,
                tipoMedicamento: tipoMedicamento
            },
            success: function(data) {
                $('#agregarMedicamentoModal').modal('hide');
                $('#nombreMedicamento').val("");
                if (data.success){
                    toastr.success("Se agregó con exito el medicamento.");
                    getListadoMedicamentos()
                } else {
                    toastr.error("Error al agregar Medicamento")
                }
            }
        })
		} else {
			e.preventDefault();
		}
    });

    $('#tipoMedicamentoSearch').change(getListadoMedicamentos);


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


    function getListadoMedicamentos() {
	
		if ($('#tipoMedicamentoSearch').val()== 0)
		{   $('#agregarMedicamentoModalBtn').prop('disabled', true);
		} else {
			 $('#agregarMedicamentoModalBtn').prop('disabled', false);
		}
	
        medicamentosTable.rows().remove().draw(false);
        presentacionMedicamentosTable.rows().remove().draw(false);

        var tipoMedicamento = $('#tipoMedicamentoSearch').val()
        $.ajax({
            url: 'MedicamentosServlet.do',
            method: 'get',
            data: {
                accion: 'LISTAR_JSON',
                tipoMedicamento: tipoMedicamento,
				tipolista: "A" 
            },
            success: function (response) {
                if(response.success) {
                    response.data.forEach(function (element) {
                        var data = ' data-codigo-medicamento="' + element.codigoMedicamento + '" data-nombre-medicamento="' + element.nombreMedicamento + '" data-estado-medicamento="' + devuelveEstado(element.estado) + '" ';
                        var row = [
                            '<input type="radio" name="medicamento" data-nombre-medicamento="'+element.nombreMedicamento+'" id="medicamento-' + element.codigoMedicamento + '" value="' + element.codigoMedicamento + '"/>',
                            '<label for="medicamento-' + element.codigoMedicamento + '">' + element.codigoMedicamento + '</label>',
                            '<label for="medicamento-' + element.codigoMedicamento + '" class="text-capitalize">' + element.nombreMedicamento + '</label>',
 							'<label for="medicamento-' + element.codigoMedicamento + '" class="text-capitalize">' + devuelveEstado(element.estado)+ '</label>',
                            '<div class="btn-group" >'
                            + '<button type="button" class="btn btn-light" data-modificar-medicamento="true" ' + data + ' data-toggle="modal" data-target="#modificarMedicamentoModal" data-toggle="tooltip" data-placement="right" title="Modificar Medicamento"><i class="fas fa-edit"></i></button>'
                            + '<button type="button" class="btn btn-light" data-baja-medicamento="true" ' + data + ' data-toggle="modal" data-target="#darBajaMedicamentoModal" id="darBajaPresentacionModalBtn" data-toggle="tooltip" data-placement="right" title="Cambio de Estado"><i class="fas fa-toggle-on"></i></button>'
                            + '</div>'
                        ]
                        medicamentosTable.row.add(row).draw(false);
                    });

					medicamentosTable.columns.adjust().draw();

                } else {
                    toastr.error("No se pudo obtener el listado de medicamentos");
                }
            }
        });
    }

    $(document).on('change', 'input[type=radio][name=medicamento]', onMedicamentoItemChange);
    $(document).on('click', '[data-modificar-medicamento]', setMedicamentoDataModificar);
    $(document).on('click', '[data-baja-medicamento]', setMedicamentoDataDarBaja);



    function getListadoPresentaciones(codigoMedicamento, nombre=undefined) {
        $('#codigoMedicamentoPresentacion').val(codigoMedicamento)
        if(nombre != undefined) { $('#nombreMedicamentoPresentacion').val(nombre) }
        $('#agregarPresentacionModalBtn').prop('disabled', false);
        presentacionMedicamentosTable.rows().remove().draw();

        $.ajax({
            url: 'PresentacionMedicamentosServlet.do',
            method: 'get',
            data: {
                accion: 'LISTAR_JSON',
                codigoMedicamento: codigoMedicamento
            },
            success: function(data) {
                if (data.success) {
                    data.data.forEach(function(element){
                        var data = 'data-codigo-medicamento="'+ element.codMedicamento +'" data-tipo-presentacion="'+element.tipoPresentacion+'"'
                        var row = [
                            '',
                            '<label class="text-capitalize">' + element.tipoPresentacion + '</label>' ,
                            '<label class="text-uppercase">' + element.creadoPor + '</label>',
                            '<label>' + element.fechaCreacion + '</label>',
                            '<div class="btn-group" >'
                            + '<button type="button" class="btn btn-light" data-modificar-presentacion="true" ' + data + ' data-toggle="modal" data-target="#modificarPresentacionModal" id="modificarPresentacionModalBtn" data-toggle="tooltip" data-placement="right" title="Modificar Presentación"><i class="fas fa-edit"></i></button>'
                            + '<button type="button" class="btn btn-light" data-baja-presentacion="true" ' + data + ' data-toggle="modal" data-target="#darBajaPresentacionModal" id="darBajaPresentacionModalBtn"><i class="fas fa-times"></i></button>'
                            + '</div>'
                        ];
                        presentacionMedicamentosTable.row.add(row).draw(false);
                    });
					presentacionMedicamentosTable.columns.adjust().draw();
                }
                else {
                    toastr.error("No se pudo obtener el listado de presentaciones");
                }
            }
        });
    }

    $(document).on('click', '[data-modificar-presentacion="true"]', setPresentacionDataModificar)
    $(document).on('click', '[data-baja-presentacion="true"]', setPresentacionDataBaja)

    function onMedicamentoItemChange(){
        getListadoPresentaciones(this.value, $(this).data('nombre-medicamento'));
    }

    $('input[type=radio][name=medicamento]').change(onMedicamentoItemChange);


	var validar_addPresentacion = $("#CrearFormPresentacionModal").validate({
 	rules :{
                tipoPresentacion : { required : true, formatoSoloTexto: true,  minlength : 3, maxlength : 30  },
			
            },
            messages : {
                tipoPresentacion : {
                    required : "Debe ingresar el nombre de la presentación ",
 					minlength : "El nombre debe tener un mínimo de 3 caracteres",
					maxlength : "El máximo deben ser 30 caracteres", 
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


    $('#agregarPresentacionBtn').click(function(e){
        var codigoMedicamento = $('#codigoMedicamentoPresentacion').val()
        var tipoPresentacion = $('#tipoPresentacion').val()

	if (validar_addPresentacion.form()) //asi se comprueba si el form esta validado o no
    	{   
        $.ajax({
            url: 'PresentacionMedicamentosServlet.do',
            method: 'post',
            data: {
                accion: 'CREAR',
                codigoMedicamento: codigoMedicamento,
                tipoPresentacion: tipoPresentacion
            },
            success: function(response) {
                $('#agregarPresentacionModal').modal('hide');
                $('#tipoPresentacion').val("")
                if (response.success){
                    toastr.success("Se agrego la presentacion");
                    getListadoPresentaciones(codigoMedicamento)
                } else {
                    toastr.error("Error al agregar la presentacion");
                }

            }
        });
		} else {
			e.preventDefault();
		}
    });




	var validar_modPresentacion = $("#ModifFormPresentacionModal").validate({
 	rules :{
                tipoPresentacionMod : { required : true, formatoSoloTexto: true,  minlength : 3, maxlength : 30  },
			
            },
            messages : {
                tipoPresentacionMod : {
                    required : "Debe ingresar el nombre de la presentación ",
 					minlength : "El nombre debe tener un mínimo de 3 caracteres",
					maxlength : "El máximo deben ser 30 caracteres", 
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


    $('#modificarPresentacionBtn').click(function(e){
        var codigoMedicamento = $('#codigoMedicamentoPresentacionMod').val()
        var tipoPresentacionCurrent = $('#tipoPresentacionCurrentMod').val()
        var tipoPresentacion = $('#tipoPresentacionMod').val()

	if (validar_modPresentacion.form()) //asi se comprueba si el form esta validado o no
    	{  
        $.ajax({
            url: 'PresentacionMedicamentosServlet.do',
            method: 'post',
            data: {
                accion: 'MODIFICAR',
                codigoMedicamento: codigoMedicamento,
                tipoPresentacion: tipoPresentacion,
                tipoPresentacionCurrent: tipoPresentacionCurrent
            },
            success: function(response) {
                $('#modificarPresentacionModal').modal('hide');
                $('#tipoPresentacionMod').val("")
                if (response.success){
                    toastr.success("Se modifico con éxito la presentación");
                    getListadoPresentaciones(codigoMedicamento);
                } else {
                    toastr.error("Error al modificar la presentación");
                }
            }
        });
		} else {
			e.preventDefault();
		}
    });





    $('#btnDarBajaPresentacion').click(function(){
        var codigoMedicamento = $('#codigoMedicamentoPresentacionBaja').text()
        var tipoPresentacion = $('#tipoPresentacionBaja').text()

        $.ajax({
            url: 'PresentacionMedicamentosServlet.do',
            method: 'post',
            data: {
                accion: 'DAR_BAJA',
                codigoMedicamento: codigoMedicamento,
                tipoPresentacion: tipoPresentacion,
            },
            success: function(response) {
                $('#darBajaPresentacionModal').modal('hide');
                $('#codigoMedicamentoPresentacionBaja').text("")
                $('#tipoPresentacionBaja').text("")
                if (response.success){
                    toastr.success("Se dió de baja la presentación");
                    getListadoPresentaciones(codigoMedicamento);
                } else {
                    toastr.error("Error al dar de baja la presentación");
                }
            }
        });
    });




    function setPresentacionDataModificar() {
        $('#codigoMedicamentoPresentacionMod').val($(this).data('codigo-medicamento'))
        $('#tipoPresentacionCurrentMod').val($(this).data('tipo-presentacion'))
    }

    function setPresentacionDataBaja() {
        $('#codigoMedicamentoPresentacionBaja').text($(this).data('codigo-medicamento'));
        $('#tipoPresentacionBaja').text($(this).data('tipo-presentacion'));
    }

    function setMedicamentoDataDarBaja() {
        $('#codigoMedicamentoBaja').text($(this).data('codigo-medicamento'))
        $('#nombreMedicamentoBaja').text($(this).data('nombre-medicamento'))
		$('#estadoNuevoMedicamento').text($(this).data('estado-medicamento'))
    }

    function setMedicamentoDataModificar(){
        $('#codigoMedicamentoMod').val($(this).data('codigo-medicamento'))
        $('#nombreMedicamentoMod').val($(this).data('nombre-medicamento'))
    }


	var validar_modMedicamento = $("#ModMedicamentoFormModal").validate({
 	rules :{
                nombreMedicamentoMod : { required : true, formatoSoloTexto: true,  minlength : 3, maxlength : 30  },
			
            },
            messages : {
                nombreMedicamentoMod : {
                    required : "Debe ingresar el nombre del medicamento ",
 					minlength : "El nombre debe tener un mínimo de 3 caracteres",
					maxlength : "El máximo deben ser 30 caracteres", 
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

    $('#btnModificarMedicamento').click(function(e){
        var codigoMedicamento = $('#codigoMedicamentoMod').val()
        var nombreMedicamento = $('#nombreMedicamentoMod').val()

	if (validar_modMedicamento.form()) //asi se comprueba si el form esta validado o no
    	{  
        $.ajax({
            url: 'MedicamentosServlet.do',
            method: 'post',
            data: {
                accion: 'MODIFICAR',
                codigoMedicamento: codigoMedicamento,
                nombreMedicamento: nombreMedicamento,
            },
            success: function(response) {
                $('#modificarMedicamentoModal').modal('hide');
                $('#codigoMedicamentoMod').val("")
                $('#nombreMedicamentoMod').val("")
                if (response.success){
                    toastr.success("Se modificó con éxito el medicamento");
                    getListadoMedicamentos();
                } else {
                    toastr.error("Error al modificar medicamento");
                }
            }
        });
		} else {
			e.preventDefault();
		}
    });


    $('#btnDarBajaMedicamento').click(function(){
        var codigoMedicamento = $('#codigoMedicamentoBaja').text();
		var estadoNuevoMedicamento = $('#estadoNuevoMedicamento').text().trim();

        $.ajax({
            url: 'MedicamentosServlet.do',
            method: 'post',
            data: {
                //accion: 'DAR_BAJA',
				accion: 'CAMBIO_ESTADO',
                codMedicamento: codigoMedicamento,
				estadoNuevoMedicamento: estadoNuevoMedicamento                
            },
            success: function(response) {
                $('#darBajaMedicamentoModal').modal('hide');
                $('#codigoMedicamentoBaja').text("")
				$('#estadoNuevoMedicamento').text("");
                if (response.success){
                    toastr.success("Se cambió el estado del medicamento con éxito");
                    getListadoMedicamentos();
                } else {
                    toastr.error("Error al cambiar el estado del medicamento");
                }
            }
        });
    });


	// funcion al cancelar el modal de crear medicamento
    $('#btnCancelAddMedicamento').click(function(){
		 $('#nombreMedicamento').val("")
		 $('#agregarMedicamentoModal label.error').hide();
    });

	// funcion al cerrar el modal de crear medicamento
	 $("#agregarMedicamentoModal").on('hidden.bs.modal', function () {
		$('#agregarMedicamentoModal label.error').hide();
    });
	
	
	// funcion al cancelar el modal de modificar medicamento
    $('#btnCancelModMedicamento').click(function(){
		$('#nombreMedicamentoMod').val("")
		$('#modificarMedicamentoModal label.error').hide();
    });
	
	// funcion al cerrar el modal de modificar medicamento
	 $("#modificarMedicamentoModal").on('hidden.bs.modal', function () {
		$('#modificarMedicamentoModal label.error').hide();
    });
	
	
	/// presentaciones 
		// funcion al cancelar el modal de crear presentacion
    $('#cancelAddPresentacionBtn').click(function(){
		 $('#tipoPresentacion').val("")
		 $('#agregarPresentacionModal label.error').hide();
    });

	// funcion al cerrar el modal de crear presentacion
	 $("#agregarPresentacionModal").on('hidden.bs.modal', function () {
		$('#agregarPresentacionModal label.error').hide();
    });
	
	
	// funcion al cancelar el modal de modificar presentacion
    $('#cancelModPresentacionBtn').click(function(){
		$('#tipoPresentacionMod').val("")
		$('#modificarPresentacionModal label.error').hide();
    });
	
	// funcion al cerrar el modal de modificar presentacion
	 $("#modificarPresentacionModal").on('hidden.bs.modal', function () {
		$('#modificarPresentacionModal label.error').hide();
    });




});