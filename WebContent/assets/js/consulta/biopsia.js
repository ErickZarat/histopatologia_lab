window.examen = $('#codExamen').val();
window.biopsia = $('#codBiopsia').val();
window.informeBiopsia = $('#codInformeBiopsia').val();
window.frote = $('#codFrote').val();
window.informeFrote = $('#codInformeFrote').val();

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
});

function extractInformeBiopsia(){
    var informe = {
        'clinica': $('#clinicaBiopsia').val(),
        'direccion': $('#direccionBiopsia').val(),
        'solicitante': $('#solicitanteBiopsia').val(),
        'datosClinicos': $('#datosClinicosBiopsia').val(),
        'descMacros': $('#descMacroBiopsia').val(),
        'descMirco': $('#descMicroBiopsia').val(),
        'diagnostico': $('#diagnosticoBiopsia').val().join(),
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
