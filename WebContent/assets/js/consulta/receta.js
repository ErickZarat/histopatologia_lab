
$(document).ready(function() {

    window.recetas = [];

    var currentMedicamentos = [];
    var currentPresentaciones = [];

    var recetasTable = $('#recetasTable').DataTable(window.coreTableConfig);
    $('#tipoMedicamentoSearch').change(getListadoMedicamentos);
    $('#medicamentoSelect').change(getListadoPresentaciones);

    function extractReceta() {
        return {
            'codExamen': window.examen,
            'codPresentacionMedicamento':  $('#presentacionSelect').val(),
            'numReceta': 0,
            'notas': $('#notasReceta').val(),
            'nombreMedicamento': $( "#medicamentoSelect option:selected" ).text(),
            'presentacion': $( "#presentacionSelect option:selected" ).text(),
        };
    }

    function redrawRecetasTable(){
        recetasTable.rows().remove().draw(false);
        window.recetas.forEach(function(element, idx){
            var row = [
                '<label class="text-capitalize">' + element.nombreMedicamento + '</label>' ,
                '<label class="text-capitalize">' + element.presentacion + '</label>' ,
                '<label class="text-capitalize">' + element.notas + '</label>' ,
                '<button type="button" class="btn btn-light delete" data-idx="'+idx+'"><i class="fas fa-trash"></i></button>'
            ];
            recetasTable.row.add(row).draw(false);
        });
    }

    $(document).on('click', 'button[data-idx]', function (){
        var idx = $(this).data('idx')
        window.recetas.splice(idx, 1);
        redrawRecetasTable()
    })

    function getListadoMedicamentos() {
        $('#medicamentoSelect').empty();
        var tipoMedicamento = $('#tipoMedicamentoSearch').val()
        $.ajax({
            url: 'MedicamentosServlet.do',
            method: 'get',
            data: {
                accion: 'LISTAR_JSON',
                tipoMedicamento: tipoMedicamento
            },
            success: function (response) {
                $('#medicamentoSelect').append("<option>Selecciona una opcion</option>");
                if(response.success) {
                    response.data.forEach(function (element) {
                        var option = "<option value='"+element.codigoMedicamento+"'>"+element.nombreMedicamento+"</option>";
                        $('#medicamentoSelect').append(option);
                    });
                } else {
                    toastr.error("No se pudo obtener el listado de medicamentos");
                }
            }
        });
    }

    function getListadoPresentaciones() {
        $('#presentacionSelect').empty();
        var codigoMedicamento = $('#medicamentoSelect').val();
        $.ajax({
            url: 'PresentacionMedicamentosServlet.do',
            method: 'get',
            data: {
                accion: 'LISTAR_JSON',
                codigoMedicamento: codigoMedicamento
            },
            success: function(response) {
                $('#presentacionSelect').append("<option>Selecciona una opcion</option>");
                if(response.success) {
                    response.data.forEach(function (element) {
                        var option = "<option value='"+element.codPresentacion+"'>"+element.tipoPresentacion+"</option>";
                        $('#presentacionSelect').append(option);
                    });
                } else {
                    toastr.error("No se pudo obtener el listado de presentacion");
                }
            }
        });
    }

    $('#agregarReceta').click(function(e){
        e.preventDefault();
        var receta = extractReceta();
        receta.numReceta = window.recetas.length + 1
        window.recetas.push(receta);
        $('#recetas-form').trigger("reset");
        redrawRecetasTable();
    });
//TODO: handle guardar button on load
    $('#guardarReceta').click(function(e){
        e.preventDefault();
        $('#recetas-form').prop('disabled', true);
        $('#guardarReceta').prop('disabled', true);
        $.ajax({
            url: 'RecetaServlet.do',
            method: 'post',
            data: {
                accion: 'CREAR',
                recetas: JSON.stringify(window.recetas)
            },
            success: function (response) {
                if(response.success) {
                    toastr.success("se guardo la receta");
                } else {
                    toastr.error("No se pudo guardar la receta");
                }
            }
        });
    })





});