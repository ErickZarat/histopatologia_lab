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
    $('#medicamentosTable').paging( { limit: 5 } );
});