
$(document).ready(function() {

    window.recetas = [];

    var currentMedicamentos = [];
    var currentPresentaciones = [];


	jQuery.validator.setDefaults({
		debug: true,
		success: "valid"
	});
	
	$.validator.addMethod("valueNotEquals", function(value, element, arg){
 	 			return arg !== value;
 	}, "Debe seleccionar el tipo de usuario");

	var validarDatosReceta = $("#recetas-form").validate({
	 	rules :{
	                tipoMedicamentoSelect : { required : true ,valueNotEquals: "0" },
					medicamentoSelect : { required : true },
					presentacionSelect : { required : true},
					notasReceta : { required : true,  minlength : 3 },					
	            },
	            messages : {
	                tipoMedicamentoSelect : {
	                    required : "Valor obligatorio",
	                },
	 				medicamentoSelect : {
	                    required : "Medicamento obligatorio",
	                },
	                presentacionSelect : {
	                    required : "Valor obligatorio",
	                    minlength : "Presentación obligatoria"
	                },
	                notasReceta : {
	                    required : "Debe ingresar las Indicaciones",
	                    minlength : "Indicaciones obligatorias"
	                },
	 		errorElement: "em",
	       	errorPlacement: function (error, element) {
	          // Add the `help-block` class to the error element
	          error.addClass("help-block"); 
	       	},
	       	highlight: function ( element, errorClass, validClass ) {
	          $( element ).parents("form-control").addClass( "has-error" ).removeClass( "has-success" );
	       	},
	       	unhighlight: function (element, errorClass, validClass) {
	          $( element ).parents("form-control").addClass( "has-success" ).removeClass( "has-error" );  
	       	} 
		}
	  	});




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

	if (validarDatosReceta.form()) //asi se comprueba si el form esta validado o no
    {   
	        var receta = extractReceta();
	        receta.numReceta = window.recetas.length + 1
	        window.recetas.push(receta);
	        $('#recetas-form').trigger("reset");
	        redrawRecetasTable();
	} else {
		e.preventDefault();
	}
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
    });

    $('a#descargarReceta').click(function(e) {
        e.preventDefault();
        var width = window.innerWidth * 0.8 ;
        var height = width * window.innerHeight / window.innerWidth ;
        window.open(this.href , 'newwindow', 'width=' + width + ', height=' + height + ', top=' + ((window.innerHeight - height) / 2) + ', left=' + ((window.innerWidth - width) / 2));
    });

});