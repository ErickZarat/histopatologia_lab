window.examen = $('#codExamen').val();
window.frote = $('#codFrote').val();
window.informeFrote = $('#codInformeFrote').val();
window.frote = $('#codFrote').val();
window.informeFrote = $('#codInformeFrote').val();


	jQuery.validator.setDefaults({
		debug: true,
		success: "valid"
	});
	
	$.validator.addMethod("formatoTexto", function(value, element) {
                return this.optional(element) || /^[a-zA-ZÀ-ÿ 0-9\. \- s()-*,]{1,200}$/i.test(value);
	}, "Solo se permite ingresar letras.");


	var addValidarDatosFrote = {  //$("#biopsia-form").validate({
 	rules :{
                muestraEstudioFrote : { required : true, formatoTexto: true},
				tincionSelect : { required : true  },
            },
            messages : {
                muestraEstudioFrote : {
                    required : "Debe ingresar el número de la muestra ",
 					minlength : "El número de muestra es obligatorio",
                },
 				tincionSelect : {
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

	
	var validarDatosFrote = $("#frote-form").validate({
	 	rules :{
	                numReciboFrote : { required : true, formatoTexto: true, minlength : 3 },
					serieReciboFrote : { required : true, formatoTexto: true, minlength : 3 },
					montoReciboFrote : { required : true, minlength : 2 },
	            },
	            messages : {
	                numReciboFrote : {
	                    required : "Número de recibo obligatorio",
	 					minlength : "Debe ingresar el numero",
	                },
	 				serieReciboFrote : {
	                    required : "Serie de recibo obligatorio",
	                    minlength : "La serie es obligatoria",
	                    maxlength : "Debe ingresar la serie"
	                },
	                montoReciboFrote : {
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


	function extractReciboFrote(){
	    var recibo = {
	        'codExamen': window.examen,
	        'numRecibo': $('#numReciboFrote').val(),
	        'serieRecibo': $('#serieReciboFrote').val(),
	        'montoRecibo': $('#montoReciboFrote').val()
	    }
	    return recibo;
	}
	

	$('#validarReciboFrote').click(function(e){
	    e.preventDefault();

	if (validarDatosFrote.form()) //asi se comprueba si el form esta validado o no
    {   
	    recibo = extractReciboFrote()
	
	    if (recibo.codExamen == null) {
	        toastr.error('Código de exámen inválido');
	        return;
	    }
	    $('#frote-recibo').prop('disabled', true);
	
	    $.ajax({
	        url: 'FroteServlet.do',
	        method: 'post',
	        data: {
	            accion: 'CREAR',
	            frote: JSON.stringify(recibo)
	        },
	        success: function (response) {
	            if(response.success) {
	                console.log(response.data)
	                $('#frote-datos').prop('disabled', false);
	                window.frote = response.data.codFrote;
	                toastr.success('Se guardó con éxito el recibo');
	                $('#numeroFrote').val(response.data.numFrote);
	                $('#fechaFrote').val(response.data.fechaFormateada);
	                $('#estadoFrote').val(response.data.estadoFrote);
	            } else {
	                $('#frote-recibo').prop('disabled', false);
	                toastr.error('Error al registrar el recibo');
	            }
	        }
	    });
		} else {
			e.preventDefault();
		}
	});
	

function extractDatosFrote(){
    var datosFrote = {
        'codFrote': window.frote,
        'codTincion': $('#tincionSelect').val(),
        'muestraEstudio': $('#muestraEstudio').val(),
        'observaciones': $('#observacionesFrote').val(),
        'imgs': []
    }
    return datosFrote;
}



$('#guardarDatosFrote').click(function(e){
    e.preventDefault();

  	var originalSettings = $.extend(true, {}, $("#frote-form").validate().settings);

 	var settings = $("#frote-form").validate().settings;
  	$.extend(settings, addValidarDatosFrote);

  	if ($("#frote-form").valid()) 

    {  
	    var datos = extractDatosFrote();
	
	    if (datos.codFrote == null) {
	        toastr.error('Código de frote inválido');
	        return;
	    }
	
	    $('#frote-datos').prop('disabled', true);
	
	    $.ajax({
	        url: 'FroteServlet.do',
	        method: 'post',
	        data: {
	            accion: 'MODIFICAR',
	            frote: JSON.stringify(datos)
	        },
	        success: function (response) {
	            if(response.success) {
	                console.log(response.data)
	                toastr.success('Se guardó con éxito el frote');
	                $('#frote-informe').prop('disabled', false);
	                $('#estadoFrote').val(response.data.estadoFrote);
	            } else {
	                $('#frote-datos').prop('disabled', false);
	                toastr.error('Error al guardar el frote');
	            }
	        }
	    });

		 $.extend(settings, originalSettings);  //devolver las reglas originales de validacion
	} else {
		e.preventDefault();
	}
});



/*funciones para pagina de informe de frote */


	var validarInformeFrote = $("#informeFrote-form").validate({
	 	rules :{
	                clinicaFrote : { required : true, formatoTexto: true, minlength : 3 },
					direccionFrote : { required : true, formatoTexto: true, minlength : 5 },
					solicitanteFrote : { required : true, formatoTexto: true,minlength : 3 },
					datosClinicosFrote : { required : true, minlength : 2 },
					descMicroFrote : { required : true, minlength : 30 },
					descMacroFrote : { required : true, minlength : 30 },
					diagnosticoFrote : { required : true },
	            },
	            messages : {
	                clinicaFrote : {
	                    required : "Clínica es obligatoria",
	 					minlength : "Debe ingresar la Clinica",
	                },
	 				direccionFrote : {
	                    required : "Dirección obligatoria",
	                    minlength : "Valor incorrecto",
	                },
	                solicitanteFrote : {
	                    required : "Debe ingresar Solicitante",
	                    minlength : "Valor incorrecto"
	                },
					datosClinicosFrote : {
	                    required : "Debe ingresar los datos clínicos",
	                    minlength : "Valor incorrecto "
	                },
					descMicroFrote : {
	                    required : "Descripción microscópica obligatoria",
	                    minlength : "Valor incorrecto"
	                },
					descMacroFrote : {
	                    required : "Descripción macroscópica obligatoria",
	                    minlength : "Valor incorrecto"
	                },
					diagnosticoFrote : {
	                    required : "Diagnóstico obligatorio",
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


function extractInformeFrote(){
    var informe = {
        'clinica': $('#clinicaFrote').val(),
        'direccion': $('#direccionFrote').val(),
        'solicitante': $('#solicitanteFrote').val(),
        'datosClinicos': $('#datosClinicosFrote').val(),
        'descMacros': $('#descMacroFrote').val(),
        'descMirco': $('#descMicroFrote').val(),
        'diagnostico': $('#diagnosticoFrote').val(),
        // 'codFrote': $('#').val(),
        'codFrote': window.frote,
		'observaciones': $('#obsInformeFrote').val()
    }
    return informe;
}

	$('#guardarInformeFrote').click(function(e){
	    e.preventDefault();

	if (validarInformeFrote.form()) //asi se comprueba si el form esta validado o no
    {  
		    var informe = extractInformeFrote();
		
		    $('#frote-informe').prop('disabled', true);
		
		    $.ajax({
		        url: 'FroteServlet.do',
		        method: 'post',
		        data: {
		            accion: 'GUARDAR_INFORME',
		            informe: JSON.stringify(informe)
		        },
		        success: function (response) {
		            if(response.success) {
		                console.log(response.data)
		                toastr.success('Se guardó con éxito el informe del Frote');
		                var url = "ConsultaServlet.do?accion=DESCARGAR_INFORME&tipo=frote&codExamen=" + window.examen;
		                $('a#descargarInformeFrote').attr("href", url);
		            } else {
		                $('#frote-informe').prop('disabled', false);
		                toastr.error('Error al guardar el informe del Frote');
		            }
		        }
		    });
	} else {
		e.preventDefault();
	}

});

$('a#descargarInformeFrote').click(function(e) {
    e.preventDefault();
    var width = window.innerWidth * 0.8 ;
    var height = width * window.innerHeight / window.innerWidth ;
    window.open(this.href , 'newwindow', 'width=' + width + ', height=' + height + ', top=' + ((window.innerHeight - height) / 2) + ', left=' + ((window.innerWidth - width) / 2));
});


$('#upload-button-frote').click(function(e){
    e.preventDefault();
    uploadFroteImage()
})

function uploadFroteImage(){
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
                if (!window.froteImages) window.froteImages = [];
                window.froteImages = window.froteImages.concat(response.data);
                toastr.success("Se subieron " + response.data.length + " imagen(es)");
                response.data.forEach(function(el, idx){
                    $('#froteImageContainer').append('<li><a href="'+el+'">image-'+idx+'</a></li>')
                })

            } else {
                toastr.error("Error " + response.error);
            }
        }
    });
}
