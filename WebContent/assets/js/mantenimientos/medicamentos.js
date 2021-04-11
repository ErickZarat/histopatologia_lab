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
    var table = $('#medicamentosTable').DataTable({
        searching: false,
        paging: true,
        pagingType: 'simple',
        info: false,
        bFilter: false,
        bLengthChange: false,
        iDisplayLength: 5,
        oLanguage: {
            oPaginate: {
                sPrevious: "Anterior", // This is the link to the previous page
                sNext: "Siguiente", // This is the link to the next page
            }
        }
    });

    // var data = [
    //     ['<input type="radio" name="medicamento" id="medicamento-24" value="24">', '<label for="medicamento-24">24</label>', '<label for="medicamento-24" class="text-capitalize">Medicamento X</label>'],
    //     ['<input type="radio" name="medicamento" id="medicamento-24" value="24">', '<label for="medicamento-24">24</label>', '<label for="medicamento-24" class="text-capitalize">Medicamento X</label>'],
    //     ['<input type="radio" name="medicamento" id="medicamento-24" value="24">', '<label for="medicamento-24">24</label>', '<label for="medicamento-24" class="text-capitalize">Medicamento X</label>'],
    //     ['<input type="radio" name="medicamento" id="medicamento-24" value="24">', '<label for="medicamento-24">24</label>', '<label for="medicamento-24" class="text-capitalize">Medicamento X</label>'],
    //     ['<input type="radio" name="medicamento" id="medicamento-24" value="24">', '<label for="medicamento-24">24</label>', '<label for="medicamento-24" class="text-capitalize">Medicamento X</label>'],
    //     ['<input type="radio" name="medicamento" id="medicamento-24" value="24">', '<label for="medicamento-24">24</label>', '<label for="medicamento-24" class="text-capitalize">Medicamento X</label>'],
    //     ['<input type="radio" name="medicamento" id="medicamento-24" value="24">', '<label for="medicamento-24">24</label>', '<label for="medicamento-24" class="text-capitalize">Medicamento X</label>'],
    //     ['<input type="radio" name="medicamento" id="medicamento-24" value="24">', '<label for="medicamento-24">24</label>', '<label for="medicamento-24" class="text-capitalize">Medicamento X</label>'],
    //     ['<input type="radio" name="medicamento" id="medicamento-24" value="24">', '<label for="medicamento-24">24</label>', '<label for="medicamento-24" class="text-capitalize">Medicamento X</label>'],
    //     ['<input type="radio" name="medicamento" id="medicamento-24" value="24">', '<label for="medicamento-24">24</label>', '<label for="medicamento-24" class="text-capitalize">Medicamento X</label>'],
    //     ['<input type="radio" name="medicamento" id="medicamento-24" value="24">', '<label for="medicamento-24">24</label>', '<label for="medicamento-24" class="text-capitalize">Medicamento X</label>'],
    //     ['<input type="radio" name="medicamento" id="medicamento-24" value="24">', '<label for="medicamento-24">24</label>', '<label for="medicamento-24" class="text-capitalize">Medicamento X</label>'],
    //     ['<input type="radio" name="medicamento" id="medicamento-24" value="24">', '<label for="medicamento-24">24</label>', '<label for="medicamento-24" class="text-capitalize">Medicamento X</label>'],
    // ];
    //
    // data.forEach(function (element) {
    //     table.row.add(element).draw(false);
    // })
});