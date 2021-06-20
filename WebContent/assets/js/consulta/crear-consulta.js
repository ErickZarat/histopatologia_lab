
currentSearchResults = [];

$('#codigoUsuario').keyup($.debounce(850, function(e) {
    value = $(this).val();
    if (value.length < 3) return;

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
            response.data.forEach(function(element, index){
                $('.search .results').append('<li><a onClick="onPacienteSelected()" data-idx="' + index + '" href="#">' + element['nombrePaciente'] + ' ' + element['apellidosPaciente'] + '<br /><span>' + element['identificacionPaciente'] + '</span></a></li>');
            });
        }
    })
}));

function onPacienteSelected(){
    idx = $(this).data(idx);
    paciente = currentSearchResults[idx];
    $('#codigoUsuario').prop('readonly', true);
    $('#codigoUsuario').unbind('keyup');
    $('#codigoUsuario').focusout();

    $('#codigoUsuario').val(paciente.codigoPaciente);
    $('#nombreUsuario').val(paciente.nombrePaciente + ' ' + paciente.apellidosPaciente);
    $('#estadoCivilUsuario').val(paciente.estadoCivil);
    $('#ocupacionUsuario').val(paciente.ocupacionPaciente);
    $('#edadUsuario').val('');
    $('#emailUsuario').val(paciente.emailPaciente);
    $('#telefonoUsuario').val(paciente.telefonoPaciente);

    $('.search .results a').click(onPacienteSelected);
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


