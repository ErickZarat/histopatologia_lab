
currentSearchResults = [];
$('#codigoUsuario').focusout(function(){
    setTimeout(function (){
        $('.search .results').hide();
        $('.search .results li').remove();
    }, 900);
});

$('#codigoUsuario').keyup($.debounce(850, function(e) {
    value = $(this).val();
    if (value.length < 3) {
        $('.search .results li').remove();
        $('.search .results').hide();
        return;
    }

    $.ajax({
        url: 'PacienteServlet.do',
        method: 'get',
        data: {
            accion: 'BUSCAR',
            value: $(this).val()
        },
        success: function(response) {
            currentSearchResults = response.data;
            $('.search .results li').remove();

            if (currentSearchResults && currentSearchResults.length >= 1) {
                currentSearchResults.forEach(function (element, index) {
                    $('.search .results').append('<li><a onClick="onPacienteSelected(this)" data-idx="' + index + '" href="#">' + element['nombrePaciente'] + ' ' + element['apellidosPaciente'] + '<br /><span>' + element['identificacionPaciente'] + '</span></a></li>');
                });
            }
            $('.search .results').append('<li><a data-toggle="modal" data-target="#agregarPacienteModal" id="agregarPacienteModalBtn" href="#">Agregar paciente nuevo</a></li>');
            $('.search .results').show();
        }
    })
}));

function onPacienteSelected(item){
    $('.search .results').hide();

    idx = $(item).data('idx');
    paciente = currentSearchResults[idx];
    selectPaciente(paciente);
}

function selectPaciente(paciente) {
    $('#codigoUsuario').prop('readonly', true);
    $('#codigoUsuario').focusout();
    $('#resetUserForm').show();

    $('#codigoUsuario').val(paciente.codigoPaciente);
    $('#nombreUsuario').val(paciente.nombrePaciente + ' ' + paciente.apellidosPaciente);
    $('#estadoCivilUsuario').val(paciente.estCivilPaciente);
    $('#ocupacionUsuario').val(paciente.ocupacionPaciente);
    $('#edadUsuario').val(paciente.edad);
    $('#emailUsuario').val(paciente.emailPaciente);
    $('#telefonoUsuario').val(paciente.telefonoPaciente);

    $('#lesion-accordion').prop("checked", true)
}

function extractExamen(){
    return {
        // 'codExamen': $('#'), //generated on backend
        'codPaciente': $('#codigoUsuario').val(),
        // 'numExamen': $('#'), //generated on backend
        // 'fechaExamen': $('#fechaExamen').val(), // current date
        // 'estado': $('#'),
        // 'historiaExamenLesion': $('#'),
        'tamanoLesion': $('#tamano').val(),
        'dimensionalLesion': "cm",
        'duracionLesionDias': $('#duracionDias').val(),
        'duracionLesionMeses': $('#duracionMeses').val(),
        'duracionLesionAnios': $('#duracionAnios').val(),
        'datosImportantesLesion': $('#datosImportantes').val(),
        // 'doctorExamen': $('#'), //comes from session

        'tipoRemision': $('#tipoRemision').val(),
        'doctorRemision': $('#doctorRemision').val(),
        'direccionDoctorRemision': $('#direccionDoctorRemision').val(),
        'telefonoDoctorRemision': $('#telefonoDoctorRemision').val(),
        'emailDoctorRemision': $('#emailDoctorRemision').val(),
        'dependenciaDoctorRemision': $('#dependenciaDoctorRemision').val(),
        'caracteristicas': $('#lesion-section select')
            .map(function(){
                return $(this).val()
            }).get().filter(function(el){
                return el !== '' && el !== undefined && el !== null;
            }),
        'necesitaBiopsia': $('#necesitaBiopsia').prop('checked'),
        'necesitaFrote': $('#necesitaFrote').prop('checked'),
        'registroDoctorRemision': $('#registroDoctorRemision').val(),
        'enfermedades': $('#enfermedadSistemica').val(),
        'diagnosticos': $('#diagnosticoInicial').val(),
        'imagenes': window.consultaImages
    }
}

$('#resetUserForm').click(function(e){
    e.preventDefault();
    $('#consultaForm')[0].reset();
    $('#codigoUsuario').prop('readonly', false);
    $('#resetUserForm').hide();
})

$('#guardarExamen').click(function(e){
    e.preventDefault();
    $('#guardarExamen').prop('disabled', true);
    var examen = extractExamen();
    $.ajax({
        url: 'ConsultaServlet.do',
        method: 'post',
        data: {
            accion: 'CREAR',
            examen: JSON.stringify(examen)
        },
        success: function (response) {
            if(response.success) {
                toastr.success("se guardo el examen");
                $('#numeroExamen').val(response.data.numExamen)
                $('#fechaExamen').val(response.data.fechaExamen)
                $('#estado').val(response.data.estado)
            } else {
                toastr.error("No se pudo agregar el examen, " + response.error);
            }
        }
    });
});

$('#upload-button').click(function(e){
    e.preventDefault();
    uploadImage()
})

function uploadImage(){
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
                if (!window.consultaImages) window.consultaImages = [];
                window.consultaImages = window.consultaImages.concat(response.data);
                toastr.success("Se subieron " + response.data.length + " imagen(es)");
                response.data.forEach(function(el, idx){
                    $('#imageContainer').append('<li><a href="'+el+'">image-'+idx+'</a></li>')
                })

            } else {
                toastr.error("Error " + response.error);
            }
        }
    });

}
