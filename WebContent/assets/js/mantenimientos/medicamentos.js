
$(document).ready(function() {

    var medicamentosTable = $('#medicamentosTable').DataTable(window.coreTableConfig);
    var presentacionMedicamentosTable = $('#presentacionMedicamentosTable').DataTable(window.coreTableConfig);

    $('#btnAgregarMedicamento').click(function(){
        var nombre = $('#nombreMedicamento').val();
        var tipoMedicamento = $('#tipoMedicamentoSearch').val();

        $.ajax({
            url: 'MedicamentosServlet.do',
            method: 'post',
            data: {
                accion: 'CREAR',
                nombre: nombre,
                tipoMedicamento: tipoMedicamento
            },
            success: function(data) {
                $('#agregarMedicamentoModal').modal('hide');
                $('#nombreMedicamento').val("");
                if (data.success){
                    getListadoMedicamentos()
                } else {
                    toastr.error("Error al agregar Medicamento")
                }
            }
        })
    });

    $('#tipoMedicamentoSearch').change(getListadoMedicamentos);

    function getListadoMedicamentos() {
        $('#agregarMedicamentoModalBtn').prop('disabled', false);

        medicamentosTable.rows().remove().draw(false);
        presentacionMedicamentosTable.rows().remove().draw(false);

        var tipoMedicamento = $('#tipoMedicamentoSearch').val()
        $.ajax({
            url: 'MedicamentosServlet.do',
            method: 'get',
            data: {
                accion: 'LISTAR_JSON',
                tipoMedicamento: tipoMedicamento
            },
            success: function (response) {
                if(response.success) {
                    response.data.forEach(function (element) {
                        var data = ' data-codigo-medicamento="' + element.codigoMedicamento + '" data-nombre-medicamento="' + element.nombreMedicamento + '" ';
                        var row = [
                            '<input type="radio" name="medicamento" data-nombre-medicamento="'+element.nombreMedicamento+'" id="medicamento-' + element.codigoMedicamento + '" value="' + element.codigoMedicamento + '"/>',
                            '<label for="medicamento-' + element.codigoMedicamento + '">' + element.codigoMedicamento + '</label>',
                            '<label for="medicamento-' + element.codigoMedicamento + '" class="text-capitalize">' + element.nombreMedicamento + '</label>',
                            '<div class="btn-group" >'
                            + '<button type="button" class="btn btn-light" data-modificar-medicamento="true" ' + data + ' data-toggle="modal" data-target="#modificarMedicamentoModal"><i class="fas fa-edit"></i></button>'
                            + '<button type="button" class="btn btn-light" data-baja-medicamento="true" ' + data + ' data-toggle="modal" data-target="#darBajaMedicamentoModal" id="darBajaPresentacionModalBtn"><i class="fas fa-times"></i></button>'
                            + '</div>'
                        ]
                        medicamentosTable.row.add(row).draw(false);
                    });
                    $('input[type=radio][name=medicamento]').unbind('change');
                    $('input[type=radio][name=medicamento]').change(onMedicamentoItemChange);
                    $('[data-modificar-medicamento]').unbind('click');
                    $('[data-modificar-medicamento]').click(setMedicamentoDataModificar);
                    $('[data-baja-medicamento]').unbind('click');
                    $('[data-baja-medicamento]').click(setMedicamentoDataDarBaja);
                } else {
                    toastr.error("No se pudo obtener el listado de medicamentos");
                }
            }
        });
    }

    function getListadoPresentaciones(codigoMedicamento, nombre=undefined) {
        $('#codigoMedicamentoPresentacion').val(codigoMedicamento)
        if(nombre != undefined) { $('#nombreMedicamentoPresentacion').val(nombre) }
        $('#agregarPresentacionModalBtn').prop('disabled', false);
        presentacionMedicamentosTable.rows().remove().draw();

        $.ajax({
            url: 'PresentacionMedicamentosServlet.do',
            method: 'get',
            data: {
                accion: 'LISTAR_JSON',
                codigoMedicamento: codigoMedicamento
            },
            success: function(data) {
                if (data.success) {
                    data.data.forEach(function(element){
                        var data = 'data-codigo-medicamento="'+ element.codMedicamento +'" data-tipo-presentacion="'+element.tipoPresentacion+'"'
                        var row = [
                            '',
                            '<label class="text-capitalize">' + element.tipoPresentacion + '</label>' ,
                            '<label class="text-uppercase">' + element.creadoPor + '</label>',
                            '<label>' + element.fechaCreacion + '</label>',
                            '<div class="btn-group" >'
                            + '<button type="button" class="btn btn-light" data-modificar-presentacion="true" ' + data + ' data-toggle="modal" data-target="#modificarPresentacionModal" id="modificarPresentacionModalBtn"><i class="fas fa-edit"></i></button>'
                            + '<button type="button" class="btn btn-light" data-baja-presentacion="true" ' + data + ' data-toggle="modal" data-target="#darBajaPresentacionModal" id="darBajaPresentacionModalBtn"><i class="fas fa-times"></i></button>'
                            + '</div>'
                        ];
                        presentacionMedicamentosTable.row.add(row).draw(false);
                    });
                    $('[data-modificar-presentacion="true"]').unbind('click')
                    $('[data-modificar-presentacion="true"]').click(setPresentacionDataModificar)
                    $('[data-baja-presentacion="true"]').unbind('click')
                    $('[data-baja-presentacion="true"]').click(setPresentacionDataBaja)
                }
                else {
                    toastr.error("No se pudo obtener el listado de presentaciones");
                }
            }
        });
    }

    function onMedicamentoItemChange(){
        getListadoPresentaciones(this.value, $(this).data('nombre-medicamento'));
    }

    $('input[type=radio][name=medicamento]').change(onMedicamentoItemChange);

    $('#agregarPresentacionBtn').click(function(){
        var codigoMedicamento = $('#codigoMedicamentoPresentacion').val()
        var tipoPresentacion = $('#tipoPresentacion').val()
        $.ajax({
            url: 'PresentacionMedicamentosServlet.do',
            method: 'post',
            data: {
                accion: 'CREAR',
                codigoMedicamento: codigoMedicamento,
                tipoPresentacion: tipoPresentacion
            },
            success: function(response) {
                $('#agregarPresentacionModal').modal('hide');
                $('#tipoPresentacion').val("")
                if (response.success){
                    $('agregarMedicamentoModal').modal('hide');
                    getListadoPresentaciones(codigoMedicamento)
                } else {
                    toastr.error("Error al agregar la presentacion");
                }

            }
        });
    });

    $('#modificarPresentacionBtn').click(function(){
        var codigoMedicamento = $('#codigoMedicamentoPresentacionMod').val()
        var tipoPresentacionCurrent = $('#tipoPresentacionCurrentMod').val()
        var tipoPresentacion = $('#tipoPresentacionMod').val()

        $.ajax({
            url: 'PresentacionMedicamentosServlet.do',
            method: 'post',
            data: {
                accion: 'MODIFICAR',
                codigoMedicamento: codigoMedicamento,
                tipoPresentacion: tipoPresentacion,
                tipoPresentacionCurrent: tipoPresentacionCurrent
            },
            success: function(response) {
                $('#modificarPresentacionModal').modal('hide');
                $('#tipoPresentacionMod').val("")
                if (response.success){
                    getListadoPresentaciones(codigoMedicamento);
                } else {
                    toastr.error("Error al modificar la presentacion");
                }
            }
        });
    });

    $('#btnDarBajaPresentacion').click(function(){
        var codigoMedicamento = $('#codigoMedicamentoPresentacionBaja').text()
        var tipoPresentacion = $('#tipoPresentacionBaja').text()

        $.ajax({
            url: 'PresentacionMedicamentosServlet.do',
            method: 'post',
            data: {
                accion: 'DAR_BAJA',
                codigoMedicamento: codigoMedicamento,
                tipoPresentacion: tipoPresentacion,
            },
            success: function(response) {
                $('#darBajaPresentacionModal').modal('hide');
                $('#codigoMedicamentoPresentacionBaja').text("")
                $('#tipoPresentacionBaja').text("")
                if (response.success){
                    getListadoPresentaciones(codigoMedicamento);
                } else {
                    toastr.error("Error al dar de baja la presentacion");
                }
            }
        });
    });

    function setPresentacionDataModificar() {
        $('#codigoMedicamentoPresentacionMod').val($(this).data('codigo-medicamento'))
        $('#tipoPresentacionCurrentMod').val($(this).data('tipo-presentacion'))
    }

    function setPresentacionDataBaja() {
        $('#codigoMedicamentoPresentacionBaja').text($(this).data('codigo-medicamento'));
        $('#tipoPresentacionBaja').text($(this).data('tipo-presentacion'));
    }

    function setMedicamentoDataDarBaja() {
        $('#codigoMedicamentoBaja').text($(this).data('codigo-medicamento'))
        $('#nombreMedicamentoBaja').text($(this).data('nombre-medicamento'))
    }

    function setMedicamentoDataModificar(){
        $('#codigoMedicamentoMod').val($(this).data('codigo-medicamento'))
        $('#nombreMedicamentoMod').val($(this).data('nombre-medicamento'))
    }

    $('#btnModificarMedicamento').click(function(){
        var codigoMedicamento = $('#codigoMedicamentoMod').val()
        var nombreMedicamento = $('#nombreMedicamentoMod').val()

        $.ajax({
            url: 'MedicamentosServlet.do',
            method: 'post',
            data: {
                accion: 'MODIFICAR',
                codigoMedicamento: codigoMedicamento,
                nombreMedicamento: nombreMedicamento,
            },
            success: function(response) {
                $('#modificarMedicamentoModal').modal('hide');
                $('#codigoMedicamentoMod').val("")
                $('#nombreMedicamentoMod').val("")
                if (response.success){
                    getListadoMedicamentos();
                } else {
                    toastr.error("Error al modificar medicamento");
                }
            }
        });
    });

    $('#btnDarBajaMedicamento').click(function(){
        var codigoMedicamento = $('#codigoMedicamentoBaja').text();

        $.ajax({
            url: 'MedicamentosServlet.do',
            method: 'post',
            data: {
                accion: 'DAR_BAJA',
                codigoMedicamento: codigoMedicamento
            },
            success: function(response) {
                $('#darBajaMedicamentoModal').modal('hide');
                $('#codigoMedicamentoBaja').text("")
                if (response.success){
                    getListadoMedicamentos();
                } else {
                    toastr.error("Error al dar baja medicamento");
                }
            }
        });
    });

});