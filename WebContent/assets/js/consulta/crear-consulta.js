
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
    return {
        // 'codExamen': $('#'), //generated on backend
        'codPaciente': $('#codigoUsuario').val(),
        // 'numExamen': $('#'), //generated on backend
        // 'fechaExamen': $('#'),
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
    }
}

$('#guardarExamen').click(function(e){
    e.preventDefault();
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
            } else {
                toastr.error("No se pudo agregar el examen, " + response.error);
            }
        }
    });
});


