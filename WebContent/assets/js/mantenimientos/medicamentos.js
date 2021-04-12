$('#btnAgregarMedicamento').click(function(){
    var nombre = $('#nombreMedicamento').val();
    var tipo = $('#tipoMedicamento').val();

    $.ajax({
        url: 'MedicamentosServlet.do',
        method: 'post',
        data: {
            accion: 'CREAR',
            nombre: nombre,
            tipo: tipo
        },
        success: function(data) {
            console.log(data)
            $('agregarMedicamentoModal').modal('hide');
            alert("El medicamento se agrego exitosamente.")
        }
    })
});

$('input[type=radio][name=medicamento]').change(function() {
    var codigoMedicamento = this.value;

    $.ajax({
        url: 'MedicamentosServlet.do',
        method: 'get',
        data: {
            accion: 'OBTENER_PRESENTACIONES',
            codigo: codigoMedicamento
        },
        success: function(data) {
            data.data.forEach(function(element){
                var id = 'presentacion-' + element.presentacion + '-' + element.codigoMedicamento;
                var row = '<tr>' +
                    '<td><input type="radio" name="presentacion" id="' + id + '"/></td>' +
                    '<td><label for="' + id + '">' + element.presentacion + '</label></td>' +
                    '<td><label for="' + id + '">' + element.creadoPor + '</label></td>' +
                    '<td><label for="' + id + '">' + element.fechaCreacion + '</label></td>' +
                    '</tr>';
                $('#presentacionTableBody').append(row);
            });
        }
    })

});

$(document).ready(function() {
    var medicamentosTable = $('#medicamentosTable').DataTable(window.coreTableConfig);

    function handleNextButtonPagination(){
        var lastItem = $('#lastMedicamento').val()
        if (lastItem === '0') {
            return;
        }
        $.ajax({
            url: 'MedicamentosServlet.do',
            method: 'get',
            data: {
                accion: 'LISTAR_JSON',
                lastMedicamento: lastItem
            },
            success: function(response) {
                if (response.data.length === 0) {
                    lastItem = 0;
                } else {
                    lastItem = response.data[response.data.length - 1].codigoMedicamento;
                }

                $('#lastMedicamento').val(lastItem)
                response.data.forEach(function(element){
                    var row = [
                        '<input type="radio" name="medicamento" id="medicamento-'+element.codigoMedicamento+'" value="'+element.codigoMedicamento+'"/>',
                        '<label for="medicamento-'+element.codigoMedicamento+'">'+element.codigoMedicamento+'</label>',
                        '<label for="medicamento-'+element.codigoMedicamento+'" class="text-capitalize">'+element.nombreMedicamento+'</label>'
                    ]
                    medicamentosTable.row.add(row).draw(false);
                });
                $('#medicamentosTable_next').click(handleNextButtonPagination);
            }
        })
    }

    $('#medicamentosTable_next').click(handleNextButtonPagination);
});