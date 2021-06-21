
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
                $('.search .results').show();
                currentSearchResults.forEach(function (element, index) {
                    $('.search .results').append('<li><a onClick="onPacienteSelected(this)" data-idx="' + index + '" href="#">' + element['nombrePaciente'] + ' ' + element['apellidosPaciente'] + '<br /><span>' + element['identificacionPaciente'] + '</span></a></li>');
                });
            }
        }
    })
}));

function onPacienteSelected(item){
    $('.search .results').hide();

    idx = $(item).data('idx');
    paciente = currentSearchResults[idx];
    $('#codigoUsuario').prop('readonly', true);
    $('#codigoUsuario').unbind('keyup');
    $('#codigoUsuario').focusout();

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
    var examen = {
        // 'codExamen': $('#'),
        'codPaciente': $('#codigoUsuario').val(),
        // 'numExamen': $('#'),
        // 'fechaExamen': $('#'),
        // 'estado': $('#'),
        // 'historiaExamenLesion': $('#'),
        'tamanoLesion': $('#tamano'),
        'dimensionalLesion': $('#'),
        'duracionLesionDias': $('#duracionDias'),
        'duracionLesionMeses': $('#duracionMeses'),
        'duracionLesionAnios': $('#duracionAnios'),
        'datosImportantesLesion': $('#'),
        // 'doctorExamen': $('#'),
        // 'tipoRemision': $('#'),
        // 'doctorRemision': $('#'),
        // 'direccionDoctorRemision': $('#'),
        // 'telefonoDoctorRemision': $('#'),
        // 'emailDoctorRemision': $('#'),
        // 'dependenciaDoctorRemision': $('#'),
    }

    return examen;
}

$('#guardarExamen').click(function(e){
    e.preventDefault();
});


