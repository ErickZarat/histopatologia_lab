window.examen = $('#codExamen').val();
window.biopsia = $('#codBiopsia').val();
window.informeBiopsia = $('#codInformeBiopsia').val();
window.frote = $('#codFrote').val();
window.informeFrote = $('#codInformeFrote').val();


	jQuery.validator.setDefaults({
	debug: true,
	success: "valid"
	});
	
	$.validator.addMethod("formatoTexto", function(value, element) {
                return this.optional(element) || /^[a-zA-ZÀ-ÿ 0-9\. \- s()-*,]{1,200}$/i.test(value);
	}, "Solo se permite ingresar letras.");



	var validarDatosBiopsia = $("#biopsia-form").validate({
 	rules :{
                muestraEstudio : { required : true, formatoTexto: true},
				tipoCirugiaSelect : { required : true},
				tipoProcedimientoSelect : { required : true},
				instrumentoSelect  : { required : true },
            },
            messages : {
                muestraEstudio : {
                    required : "Debe ingresar el número de la muestra ",
 					minlength : "El nombre debe tener un mínimo de 3 caracteres",
                },
 				tipoCirugiaSelect : {
                    required : "El valor no puede ser nulo",
                },
                tipoProcedimientoSelect : {
                    required : "El valor no puede ser nulo",
                },
                instrumentoSelect : {
                    required : "El valor no puede ser nulo",
                },
 		errorElement: "em",
       	errorPlacement: function (error, element) {
          // Add the `help-block` class to the error element
          error.addClass("help-block"); 
       	},
       	highlight: function ( element, errorClass, validClass ) {
          $( element ).parents("form-control").addClass( "has-error" ).removeClass( "has-success" );
       	},
       	unhighlight: function (element, errorClass, validClass) {
          $( element ).parents("form-control").addClass( "has-success" ).removeClass( "has-error" );  
       	} 
	}
  	});


	var validarDatosRecibo = $("#biopsia-form").validate({
	 	rules :{
	                numReciboBiopsia : { required : true, formatoTexto: true, minlength : 3 },
					serieReciboBiopsia : { required : true, formatoTexto: true, minlength : 3 },
					montoReciboBiopsia : { required : true, minlength : 3 },
	            },
	            messages : {
	                numReciboBiopsia : {
	                    required : "Debe ingresar el numero de recibo ",
	 					minlength : "El nombre debe tener un mínimo de 3 caracteres",
	                },
	 				serieReciboBiopsia : {
	                    required : "Debe ingresar la serie del recibo",
	                    minlength : "El apellido debe tener un mínimo de 3 caracteres",
	                    maxlength : "El máximo deben ser 30 caracteres"
	                },
	                montoReciboBiopsia : {
	                    required : "Debe ingresar el monto del recibo",
	                    minlength : "Debe ingresar un valor para la dirección"
	                },
	 		errorElement: "em",
	       	errorPlacement: function (error, element) {
	          // Add the `help-block` class to the error element
	          error.addClass("help-block"); 
	       	},
	       	highlight: function ( element, errorClass, validClass ) {
	          $( element ).parents("form-control").addClass( "has-error" ).removeClass( "has-success" );
	       	},
	       	unhighlight: function (element, errorClass, validClass) {
	          $( element ).parents("form-control").addClass( "has-success" ).removeClass( "has-error" );  
	       	} 
		}
	  	});



function extractReciboBiopsia(){
    var recibo = {
        'codExamen': window.examen,
        'numRecibo': $('#numReciboBiopsia').val(),
        'serieRecibo': $('#serieReciboBiopsia').val(),
        'montoRecibo': $('#montoReciboBiopsia').val()
    }
    return recibo;
}

$('#validarReciboBiopsia').click(function(e){
    e.preventDefault();

	if (validarDatosRecibo.form()) //asi se comprueba si el form esta validado o no
    {      
	    recibo = extractReciboBiopsia()
	
	    if (recibo.codExamen == null) {
	        toastr.error('codigo de examen invalido');
	        return;
	    }
	    $('#biopsia-recibo').prop('disabled', true);
	
	    $.ajax({
	        url: 'BiopsiaServlet.do',
	        method: 'post',
	        data: {
	            accion: 'CREAR',
	            biopsia: JSON.stringify(recibo)
	        },
	        success: function (response) {
	            if(response.success) {
	                console.log(response.data)
	                $('#biopsia-datos').prop('disabled', false);
	                window.biopsia = response.data.codBiopsia;
	                toastr.success('se guardo el recibo');
	                $('#numeroBiopsia').val(response.data.numBiopsia);
	                $('#fechaBiopsia').val(response.data.fecha);
	                $('#estadoBiopsia').val(response.data.estadoBiopsia);
	            } else {
	                $('#biopsia-recibo').prop('disabled', false);
	                toastr.error('error al registrar el recibo');
	            }
	        }
	    });

		} else {
			e.preventDefault();
		}


});

function extractDatosBiopsia(){
    var datosBiopsia = {
        'codBiopsia': window.biopsia,
        'procedimiento': $('#tipoProcedimientoSelect').val(),
        'tipoCirugia': $('#tipoCirugiaSelect').val(),
        'instrumento': $('#instrumentoSelect').val(),
        'muestraEstudio': $('#muestraEstudio').val(),
        'observaciones': $('#observacionesBiopsia').val(),
        'imgs': []
    }
    return datosBiopsia;
}

$('#guardarDatosBiopsia').click(function(e){
    e.preventDefault();

	if (validarDatosBiopsia.form()) //asi se comprueba si el form esta validado o no
    {      
	    var datos = extractDatosBiopsia();
	
	    if (datos.codBiopsia == null) {
	        toastr.error('codigo de biopsia invalido');
	        return;
	    }
	
	    $('#biopsia-datos').prop('disabled', true);
	
	    $.ajax({
	        url: 'BiopsiaServlet.do',
	        method: 'post',
	        data: {
	            accion: 'MODIFICAR',
	            biopsia: JSON.stringify(datos)
	        },
	        success: function (response) {
	            if(response.success) {
	                console.log(response.data)
	                toastr.success('se guardo la biopsia');
	                $('#biopsia-informe').prop('disabled', false);
	                $('#estadoBiopsia').val(response.data.estadoBiopsia);
	            } else {
	                $('#biopsia-datos').prop('disabled', false);
	                toastr.error('error al guardar la biopsia');
	            }
	        }
	    });

		} else {
			e.preventDefault();
		}


});

function extractInformeBiopsia(){
    var informe = {
        'clinica': $('#clinicaBiopsia').val(),
        'direccion': $('#direccionBiopsia').val(),
        'solicitante': $('#solicitanteBiopsia').val(),
        'datosClinicos': $('#datosClinicosBiopsia').val(),
        'descMacros': $('#descMacroBiopsia').val(),
        'descMirco': $('#descMicroBiopsia').val(),
        'diagnostico': $('#diagnosticoBiopsia').val(),
        // 'codFrote': $('#').val(),
        'codBiopsia': window.biopsia
    }
    return informe;
}

$('#guardarInformeBiopsia').click(function(e){
    e.preventDefault();
    var informe = extractInformeBiopsia();

    $('#biopsia-informe').prop('disabled', true);

    $.ajax({
        url: 'BiopsiaServlet.do',
        method: 'post',
        data: {
            accion: 'GUARDAR_INFORME',
            informe: JSON.stringify(informe)
        },
        success: function (response) {
            if(response.success) {
                console.log(response.data)
                toastr.success('se guardo el informe');
                var url = "ConsultaServlet.do?accion=DESCARGAR_INFORME&tipo=biopsia&codExamen=" + window.examen;
                $('a#descargarInformeBiopsia').attr("href", url);
            } else {
                $('#biopsia-informe').prop('disabled', false);
                toastr.error('error al guardar el informe');
            }
        }
    });
});

$('a#descargarInformeBiopsia').click(function(e) {
    e.preventDefault();
    var width = window.innerWidth * 0.8 ;
    var height = width * window.innerHeight / window.innerWidth ;
    window.open(this.href , 'newwindow', 'width=' + width + ', height=' + height + ', top=' + ((window.innerHeight - height) / 2) + ', left=' + ((window.innerWidth - width) / 2));
});
