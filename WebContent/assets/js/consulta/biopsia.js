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


	var addValidarDatosBiopsia = {  //$("#biopsia-form").validate({
 	rules :{
                muestraEstudio : { required : true, formatoTexto: true},
				tipoCirugiaSelect : { required : true  },
				tipoProcedimientoSelect : { required : true  },
				instrumentoSelect  :{ required : true  },
            },
            messages : {
                muestraEstudio : {
                    required : "Debe ingresar el número de la muestra ",
 					minlength : "El número de muestra es obligatorio",
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
}

	
	var validarDatosBiopsia = $("#biopsia-form").validate({
	 	rules :{
	                numReciboBiopsia : { required : true, formatoTexto: true, minlength : 3 },
					serieReciboBiopsia : { required : true, formatoTexto: true, minlength : 3 },
					montoReciboBiopsia : { required : true, minlength : 2 },
	            },
	            messages : {
	                numReciboBiopsia : {
	                    required : "Número de recibo obligatorio",
	 					minlength : "Debe ingresar el numero",
	                },
	 				serieReciboBiopsia : {
	                    required : "Serie de recibo obligatorio",
	                    minlength : "La serie es obligatoria",
	                    maxlength : "Debe ingresar la serie"
	                },
	                montoReciboBiopsia : {
	                    required : "Monto recibo obligatorio",
	                    minlength : "Debe ingresar un monto"
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

	if (validarDatosBiopsia.form()) //asi se comprueba si el form esta validado o no
    {      
	    recibo = extractReciboBiopsia()
	
	    if (recibo.codExamen == null) {
	        toastr.error('codigo de examen inválido');
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
	                toastr.success('Se guardó con éxito el recibo');
	                $('#numeroBiopsia').val(response.data.numBiopsia);
	                $('#fechaBiopsia').val(response.data.fecha);
	                $('#estadoBiopsia').val(response.data.estadoBiopsia);
	            } else {
	                $('#biopsia-recibo').prop('disabled', false);
	                toastr.error('Error al registrar el recibo');
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

  var originalSettings = $.extend(true, {}, $("#biopsia-form").validate().settings);

  var settings = $("#biopsia-form").validate().settings;
  $.extend(settings, addValidarDatosBiopsia);

  if ($("#biopsia-form").valid()) 

    {  
	    var datos = extractDatosBiopsia();
	
	    if (datos.codBiopsia == null) {
	        toastr.error('Código de biopsia inválido');
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
	                toastr.success('Se guardó con éxito la biopsia');
	                $('#biopsia-informe').prop('disabled', false);
	                $('#estadoBiopsia').val(response.data.estadoBiopsia);
	            } else {
	                $('#biopsia-datos').prop('disabled', false);
	                toastr.error('Error al guardar la biopsia');
	            }
	        }
	    });
		$.extend(settings, originalSettings);  //devolver las reglas originales de validacion

	} else {
		e.preventDefault();
	}
	});


//*** Funciones para el Informe de Biopsia */


	var validarInformeBiopsia = $("#informeBiopsia-form").validate({
	 	rules :{
	                clinicaBiopsia : { required : true, formatoTexto: true, minlength : 3 },
					direccionBiopsia : { required : true, formatoTexto: true, minlength : 5 },
					solicitanteBiopsia : { required : true, formatoTexto: true,minlength : 3 },
					datosClinicosBiopsia : { required : true, minlength : 2 },
					descMicroBiopsia : { required : true, minlength : 30 },
					descMacroBiopsia : { required : true, minlength : 30 },
					diagnosticoBiopsia : { required : true },
	            },
	            messages : {
	                clinicaBiopsia : {
	                    required : "Clínica es obligatoria",
	 					minlength : "Debe ingresar la Clinica",
	                },
	 				direccionBiopsia : {
	                    required : "Dirección obligatoria",
	                    minlength : "Valor incorrecto",
	                },
	                solicitanteBiopsia : {
	                    required : "Debe ingresar Solicitante",
	                    minlength : "Valor incorrecto"
	                },
					datosClinicosBiopsia : {
	                    required : "Debe ingresar los datos clínicos",
	                    minlength : "Valor incorrecto "
	                },
					descMicroBiopsia : {
	                    required : "Descripción microscópica obligatoria",
	                    minlength : "Valor incorrecto"
	                },
					descMacroBiopsia : {
	                    required : "Descripción macroscópica obligatoria",
	                    minlength : "Valor incorrecto"
	                },
					diagnosticoBiopsia : {
	                    required : "Valor obligatorio",
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
        'codBiopsia': window.biopsia, 
		'observaciones': $('#obsInformeBiopsia').val()
    }
    return informe;
}

$('#guardarInformeBiopsia').click(function(e){
    e.preventDefault();

	if (validarInformeBiopsia.form()) //asi se comprueba si el form esta validado o no
    {  
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
	                toastr.error('Error al guardar el informe de la Biopsia');
	            }
	        }
	    });
	} else {
		e.preventDefault();
	}
});

$('a#descargarInformeBiopsia').click(function(e) {
    e.preventDefault();
    var width = window.innerWidth * 0.8 ;
    var height = width * window.innerHeight / window.innerWidth ;
    window.open(this.href , 'newwindow', 'width=' + width + ', height=' + height + ', top=' + ((window.innerHeight - height) / 2) + ', left=' + ((window.innerWidth - width) / 2));
});


$('#upload-button-biopsia').click(function(e){
	e.preventDefault();
	uploadBiopsiaImage()
})

function uploadBiopsiaImage(){
	var data = new FormData();
	$.each($('#file')[0].files, function(i, file) {
		data.append('file-'+i, file);
	});

	$.ajax({
		url: 'UploadServlet.do',
		data: data,
		cache: false,
		contentType: false,
		processData: false,
		method: 'POST',
		success: function(response){
			if(response.success) {
				if (!window.biopsiaImages) window.biopsiaImages = [];
				window.biopsiaImages = window.biopsiaImages.concat(response.data);
				toastr.success("Se subieron " + response.data.length + " imagen(es)");
				response.data.forEach(function(el, idx){
					$('#biopsiaImageContainer').append('<li><a href="'+el+'">image-'+idx+'</a></li>')
				})

			} else {
				toastr.error("Error " + response.error);
			}
		}
	});
}
