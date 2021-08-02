window.examen = $('#codExamen').val();
window.frote = $('#codFrote').val();
window.informeFrote = $('#codInformeFrote').val();
window.frote = $('#codFrote').val();
window.informeFrote = $('#codInformeFrote').val();

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
    recibo = extractReciboFrote()

    if (recibo.codExamen == null) {
        toastr.error('codigo de examen invalido');
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
                toastr.success('se guardo el recibo');
                $('#numeroFrote').val(response.data.numFrote);
                $('#fechaFrote').val(response.data.fechaFormateada);
                $('#estadoFrote').val(response.data.estadoFrote);
            } else {
                $('#frote-recibo').prop('disabled', false);
                toastr.error('error al registrar el recibo');
            }
        }
    });
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
    var datos = extractDatosFrote();

    if (datos.codFrote == null) {
        toastr.error('codigo de frote invalido');
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
                toastr.success('se guardo la frote');
                $('#frote-informe').prop('disabled', false);
                $('#estadoFrote').val(response.data.estadoFrote);
            } else {
                $('#frote-datos').prop('disabled', false);
                toastr.error('error al guardar la frote');
            }
        }
    });
});

function extractInformeFrote(){
    var informe = {
        'clinica': $('#clinicaFrote').val(),
        'direccion': $('#direccionFrote').val(),
        'solicitante': $('#solicitanteFrote').val(),
        'datosClinicos': $('#datosClinicosFrote').val(),
        'descMacros': $('#descMacroFrote').val(),
        'descMirco': $('#descMicroFrote').val(),
        'diagnostico': $('#diagnosticoFrote').val().join(),
        // 'codFrote': $('#').val(),
        'codFrote': window.frote
    }
    return informe;
}

$('#guardarInformeFrote').click(function(e){
    e.preventDefault();
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
                toastr.success('se guardo el informe');
                var url = "ConsultaServlet.do?accion=DESCARGAR_INFORME&tipo=frote&codExamen=" + window.examen;
                $('a#descargarInformeFrote').attr("href", url);
            } else {
                $('#frote-informe').prop('disabled', false);
                toastr.error('error al guardar el informe');
            }
        }
    });
});

$('a#descargarInformeFrote').click(function(e) {
    e.preventDefault();
    var width = window.innerWidth * 0.8 ;
    var height = width * window.innerHeight / window.innerWidth ;
    window.open(this.href , 'newwindow', 'width=' + width + ', height=' + height + ', top=' + ((window.innerHeight - height) / 2) + ', left=' + ((window.innerWidth - width) / 2));
});
