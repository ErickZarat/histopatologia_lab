$(document).ready(function(){

    $('#btnAgregarPaciente').click(function(e){
        var idPaciente = $('#numIdPaciente').val();
        var nomPaciente = $('#nombresPaciente').val();
        var apellidosPaciente = $('#apellidosPaciente').val();
        var dirPaciente = $('#direccionPaciente').val();
        var telPaciente = $('#telPaciente').val();
        var fecNacimiento = $('#fecNacimientoPaciente').val();
        var generoPaciente = $('#generoPaciente').val();
        var ocupacionPaciente = $('#ocupacionPaciente').val();
        var tipoIdPaciente = $('#tipoIdPaciente').val();
        var emailPaciente = $('#emailPaciente').val();
        var estCivilPaciente = $('#estadoCivilPacienteSearch').val();


        if ($('#nombresPaciente').val().trim() == "" || $('#apellidosPaciente').val().trim() == "") {
            toastr.error("Debe ingresar por lo menos un nombre y un apellido del paciente");
            e.preventDefault();
        } else {
            if ($('#direccionPaciente').val().trim().length == 0) {
                toastr.error("Debe ingresar una direccion para el paciente");
                e.preventDefault();
            } else {
                if ($('#fecNacimientoPaciente').val().trim().length == 0) {
                    toastr.error("Debe ingresar una fecha de nacimiento para el paciente");
                    e.preventDefault();
                } else {
                    $.ajax({
                        url: 'PacienteServlet.do',
                        method: 'post',
                        data: {
                            accion: 'CREAR',
                            identificacionPaciente: idPaciente,
                            nomPaciente: nomPaciente,
                            apellidosPaciente: apellidosPaciente,
                            dirPaciente: dirPaciente,
                            telPaciente: telPaciente,
                            fecNacimiento: fecNacimiento,
                            generoPaciente: generoPaciente,
                            ocupacionPaciente: ocupacionPaciente,
                            tipoIdPaciente: tipoIdPaciente,
                            emailPaciente: emailPaciente,
                            estadoCivilPaciente: estCivilPaciente,
                        },
                        success: function(data) {
                            $('#agregarPacienteModal').modal('hide');
                            $("#CreaPacienteFormModal")[0].reset();
                            if (data.success){
                                toastr.success("Se agrego con exito el paciente");
                                getListadoPacientes()
                            } else {
                                toastr.error("Error al agregar Paciente")
                            }
                        }
                    })
                }
            }
        }
        //e.preventDefault();
    });

    $('.fecha').datepicker({
        format : 'dd/mm/yyyy',
        startDate: "01/01/1900",
        endDate: "30/12/2099",
        language : 'es',
        todayBtn : "linked",
        todayHighlight : true,
        autoclose : true,
        startView : 'decade'
    });


    $('#btnCancelAgregarPaciente').click(function(){
        $("#CreaPacienteFormModal")[0].reset();
    });


})