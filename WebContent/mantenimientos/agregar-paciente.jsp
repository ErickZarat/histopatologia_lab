
<!-- Modal -->
<div class="modal fade" id="agregarPacienteModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Agregar Pacientes</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form role="form" id="CreaPacienteFormModal" name="CreaPacienteFormModal">
                    <table>
                        <tr>
                            <td><label for="nombresPaciente" class="col-sm-4 col-form-label">Nombres:</label></td>
                            <td>
                                <input type="text" class="form-control" id="nombresPaciente" name="nombresPaciente" placeholder="Nombres Paciente" style="width: 322px;" required>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="apellidosPaciente" class="col-sm-4 col-form-label">Apellidos:</label></td>
                            <td>
                                <input type="text" class="form-control" id="apellidosPaciente" name="apellidosPaciente" placeholder="Apellidos Paciente" style="width: 322px; " required>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="direccionPaciente" class="col-sm-4 col-form-label">Direccion:</label></td>
                            <td>
                                <textarea class="form-control" id="direccionPaciente" name="direccionPaciente" placeholder="Direccion Paciente" maxlength="200" style="width: 322px; height: 90px"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="tipoIdPaciente" class="col-sm-4 col-form-label">Tipo Identificaci�n:</label></td>
                            <td>
                                <select id="tipoIdPaciente" name="tipoIdPaciente" class="form-control" style="width: 322px; ">
                                    <option value="DPI">DPI</option>
                                    <option value="PASAPORTE">PASAPORTE</option>
                                    <option value="Otro">Otro</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="numIdPaciente" class="col-sm-4 col-form-label">Numero Identificacion:</label></td>
                            <td>
                                <input type="text" class="form-control" id="numIdPaciente" name="numIdPaciente" placeholder="Identificacion Paciente" style="width: 322px; ">
                            </td>
                        </tr>
                        <tr>
                            <td><label for="telPaciente" class="col-sm-4 col-form-label">Telefono:</label></td>
                            <td>
                                <input type="text" class="form-control" id="telPaciente" name="telPaciente"  placeholder="Telefono" style="width: 322px; ">
                            </td>
                        </tr>
                        <tr>
                            <td><label for="emailPaciente" class="col-sm-4 col-form-label">Email:</label></td>
                            <td>
                                <input type="text" class="form-control" id="emailPaciente" name="emailPaciente"  placeholder="Email Paciente" style="width: 322px; ">
                            </td>
                        </tr>
                        <tr>
                            <td><label for="estadoCivilPaciente" class="col-sm-4 col-form-label">Estado Civil:</label></td>
                            <td>
                                <select id="estadoCivilPacienteSearch" name="estadoCivilPacienteSearch" class="form-control" style="width: 322px; ">
                                    <option value="SOLTERO">SOLTERO</option>
                                    <option value="CASADO">CASADO</option>
                                    <option value="OTRO">OTRO</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="fecNacimientoPaciente" class="col-sm-4 col-form-label">Fecha Nacimiento:</label></td>
                            <td>
                                <div class="form-group">
                                    <div class="input-group date" data-provide="fecha">
                                        <input type="text" id="fecNacimientoPaciente" name="fecNacimientoPaciente" class="form-control fecha" autocomplete="off" placeholder="dd/mm/yyyy" required>
                                        <div><i class='fas fa-calendar-alt' style='font-size:24px'></i> </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="generoPaciente" class="col-sm-4 col-form-label">Genero:</label></td>
                            <td>
                                <select id="generoPaciente"  name="generoPaciente" class="form-control" style="width: 322px; ">
                                    <option value="MASCULINO">MASCULINO</option>
                                    <option value="FEMENINO">FEMENINO</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="ocupacionPaciente" class="col-sm-4 col-form-label">Ocupaci�n:</label></td>
                            <td>
                                <input type="text" class="form-control" id="ocupacionPaciente" name="ocupacionPaciente" placeholder="Ocupaci�n Paciente"  style="width: 322px; ">
                            </td>
                        </tr>
                        <tr>
                            <td><label for="numFichaPaciente" class="col-sm-4 col-form-label">N�mero de Ficha:</label></td>
                            <td>
                                <input type="text" class="form-control" id="numFichaPaciente" name="numFichaPaciente" placeholder="N�mero Ficha Paciente"  style="width: 322px; required ">
                            </td>
                        </tr>                        
                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" id="btnCancelAgregarPaciente" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnAgregarPaciente">Agregar</button>
                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
            </div>
        </div>
    </div>
</div>

<script src="assets/js/mantenimientos/agregar-paciente.js"></script>