

function extractPaciente(){
    var paciente = {
        'codigoPaciente ': $('#codigoUsuario').val(),
        // 'identificacionPaciente': $('#').val(),
        'nombrePaciente ': $('#nombreUsuario').val(),
        // 'apellidosPaciente': $('#').val(),
        // 'direccionPaciente': $('#').val(),
        // 'telefonoPaciente ': $('#').val(),
        // 'fecNacimientoPaciente': $('#').val(),
        // 'generoPaciente': $('#').val(),
        'ocupacionPaciente ': $('#ocupacionUsuario').val(),
        // 'tipoidPaciente': $('#').val(),
        'emailPaciente': $('#emailUsuario').val(),
        // 'fechaCreacion': $('#').val(),
        // 'creadoPor': $('#').val(),
        // 'modificadoPor': $('#').val(),
        // 'fechaModificacion': $('#').val(),
        'estadoCivil': $('#estadoCivilUsuario').val(),
    }

    return paciente;
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

$('#guardarPaciente').click(function(e){
    e.preventDefault();

    var action = '';
    if ($('#codigoUsuario').val() === '') {
        action = 'CREAR';
    } else {
        action = 'MODIFICAR';
    }

    $.ajax({
        url: 'ConsultaServlet.do',
        method: 'post',
        data: {
            accion: 'CREAR',
            paciente: extractPaciente()
        },
        success: function(data) {
            $('#agregarMedicamentoModal').modal('hide');
            $('#nombreMedicamento').val("");
            if (data.success){
                toastr.success("Se agrego el medicamento");
                getListadoMedicamentos()
            } else {
                toastr.error("Error al agregar Medicamento")
            }
        }
    })
})

