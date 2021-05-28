<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../partials/head.jsp"%>
<%@ include file="../partials/header.jsp"%>


<div class="container-fluid">

    <div>
        <h1 class="main-tittle">Pacientes</h1>

        <div class="action-container left-padding-align">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-light" data-toggle="modal" data-target="#agregarPacienteModal" id="agregarPacienteModalBtn" >Agregar <i class="fas fa-plus"></i></button>
        </div>

        <table class="table table-striped w-50 left-margin-align" id="pacientesTable">
            <thead class="table thead-light">
            <tr style="font-weight: bold;">
                <td></td>
                <td>Codigo</td>
                <td>Nombres Paciente</td>
                <td>Apellidos Paciente</td>
                <td>Numero Identificacion</td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pacientes}" var="paciente">
                <tr>
                    <td><input type="radio" name="paciente" id="paciente-${paciente.codigoPaciente}" value="${paciente.codigoPaciente}"/></td>
                    <td><label for="paciente-${paciente.codigoPaciente}">${paciente.codigoPaciente}</label></td>
                    <td><label for="paciente-${paciente.codigoPaciente}" class="text">${paciente.nombrePaciente}</label></td>
                    <td><label for="paciente-${paciente.codigoPaciente}" class="text">${paciente.apellidosPaciente}</label></td>
                  <td> <button type="button" class="btn btn-secondary" id="btnCancelAgregarPaciente" data-dismiss="modal">Cancelar</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>


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
              <form role="form" id="CreaPacienteFormModal">            
                <table>
                    <tr>
                        <td><label for="nombresPaciente" class="col-sm-4 col-form-label">Nombres:</label></td>
                        <td>
                            <input type="text" class="form-control" id="nombresPaciente" placeholder="Nombres Paciente" style="width: 322px;" required>
                        </td>                        
                    </tr>
                    <tr>
                        <td><label for="apellidosPaciente" class="col-sm-4 col-form-label">Apellidos:</label></td>
                        <td>
                            <input type="text" class="form-control" id="apellidosPaciente" placeholder="Apellidos Paciente" style="width: 322px; " required>
                        </td>                    
                    </tr>
                    <tr>
                        <td><label for="direccionPaciente" class="col-sm-4 col-form-label">Direccion:</label></td>
                        <td>
                           <textarea class="form-control" id="direccionPaciente" placeholder="Direccion Paciente" maxlength="200" style="width: 322px; height: 90px"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="tipoIdPaciente" class="col-sm-4 col-form-label">Tipo Identificación:</label></td>
                        <td>
                             <select id="tipoIdPaciente" class="form-control" style="width: 322px; ">
                              <option value="DPI">DPI</option>
                              <option value="PASAPORTE">PASAPORTE</option>
                              <option value="Otro">Otro</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="numIdPaciente" class="col-sm-4 col-form-label">Numero Identificacion:</label></td>
                        <td>
                            <input type="text" class="form-control" id="numIdPaciente" placeholder="Identificacion Paciente" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="telPaciente" class="col-sm-4 col-form-label">Telefono:</label></td>
                        <td>
                            <input type="text" class="form-control" id="telPaciente" placeholder="Telefono" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="emailPaciente" class="col-sm-4 col-form-label">Email:</label></td>
                        <td>
                            <input type="text" class="form-control" id="emailPaciente" placeholder="Email Paciente" style="width: 322px; ">
                        </td>
                    </tr>        
                    <tr>
                        <td><label for="estadoCivilPaciente" class="col-sm-4 col-form-label">Estado Civil:</label></td>
                        <td>
                             <select id="estadoCivilPacienteSearch" class="form-control" style="width: 322px; ">
                              <option value="SOLTERO">SOLTERO</option>
                              <option value="CASADO">CASADO</option>
                            </select>
                        </td>
                    </tr>     
                    <tr>
                        <td><label for="fecNacimientoPaciente" class="col-sm-4 col-form-label">Fecha Nacimiento:</label></td>
                        <td>
							<div class="form-group">
                            	<div class="input-group date" data-provide="fecha">
                               		<input type="text" id="fecNacimientoPaciente" class="form-control fecha" autocomplete="off" placeholder="dd/mm/yyyy" required>
    								<div><i class='fas fa-calendar-alt' style='font-size:24px'></i> </div>
								</div>
                            </div>
                        </td>
                    </tr>  
                    <tr>
                        <td><label for="generoPaciente" class="col-sm-4 col-form-label">Genero:</label></td>
                        <td>
                             <select id="generoPaciente" class="form-control" style="width: 322px; ">
                              <option value="MASCULINO">MASCULINO</option>
                              <option value="FEMENINO">FEMENINO</option>
                            </select>
                        </td>
                    </tr>  
                    <tr>
                        <td><label for="ocupacionPaciente" class="col-sm-4 col-form-label">Ocupación:</label></td>
                        <td>
                            <input type="text" class="form-control" id="ocupacionPaciente" placeholder="Ocupación Paciente"  style="width: 322px; ">
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

<!-- Modal -->
<div class="modal fade" id="modificarPacienteModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modificar Paciente</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
              <form role="form" id="ModFormPacienteModal">            
                <table>
                    <tr>
                        <td><label for="codigoPacienteMod" class="col-sm-4 col-form-label">Codigo Paciente:</label></td>
                        <td>
                            <input type="text" class="form-control" id="codigoPacienteMod" disabled style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="nombresPacienteMod" class="col-sm-4 col-form-label">Nombres:</label></td>
                        <td>
                            <input type="text" class="form-control" id="nombresPacienteMod"  style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="apellidosPacienteMod" class="col-sm-4 col-form-label">Apellidos:</label></td>
                        <td>
                            <input type="text" class="form-control" id="apellidosPacienteMod"  style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="direccionPacienteMod" class="col-sm-4 col-form-label">Dirección:</label></td>
                        <td>
                            <textarea class="form-control" id="direccionPacienteMod" style="width: 322px; height: 90px"> </textarea> 
                        </td>
                    </tr>
                    <tr>
                        <td><label for="tipoIdPacienteMod" class="col-sm-4 col-form-label">Tipo Identificación:</label></td>
                        <td>
                           <select id="tipoIdPacienteMod" class="form-control" style="width: 322px; ">
                              <option value="DPI">DPI</option>
                              <option value="PASAPORTE">PASAPORTE</option>
                              <option value="Otro">Otro</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="numIdPacienteMod" class="col-sm-4 col-form-label">Número Identificacion:</label></td>
                        <td>
                            <input type="text" class="form-control" id="numIdPacienteMod" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="telefonoPacienteMod" class="col-sm-4 col-form-label">Teléfono:</label></td>
                        <td>
                            <input type="text" class="form-control" id="telefonoPacienteMod" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="emailPacienteMod" class="col-sm-4 col-form-label">Email: </label></td>
                        <td>
                            <input type="text" class="form-control" id="emailPacienteMod" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="estCivilPacienteMod" class="col-sm-4 col-form-label">Estado Civil:</label></td>
                        <td>
                            <select id="estCivilPacienteMod" class="form-control" style="width: 322px; ">
                              <option value="CASADO">Casado</option>
                              <option value="FEMENINO">Soltero</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="fecNacimientoPacienteMod" class="col-sm-4 col-form-label">Fecha Nacimiento:</label></td>
                        <td>
                           <div class="form-group">
                            <div class="input-group date" data-provide="fecha">
                               <input type="text" id="fecNacimientoPacienteMod" class="form-control fecha" autocomplete="off" placeholder="dd/mm/yyyy" required>
                              <span class="input-group-addon"> <i class="far fa-calendar"></i>
                              </span>
                            </div>                        
                        	</div> 
                        </td>
                    </tr>   
                    <tr>
                        <td><label for="generoPacienteMod" class="col-sm-4 col-form-label">Genero:</label></td>
                        <td>
                           <select id="generoPacienteMod" class="form-control" style="width: 322px; ">
                              <option value="MASCULINO">Masculino</option>
                              <option value="FEMENINO">Femenino</option>
                            </select>
                        </td>
                    </tr>   
                    <tr>
                        <td><label for="ocupacionPacienteMod" class="col-sm-4 col-form-label">Ocupación:</label></td>
                        <td>
                            <input type="text" class="form-control" id="ocupacionPacienteMod" style="width: 322px; ">
                        </td>
                    </tr>                                                                                                                                                                                                 
                </table>
			</form>                
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal" id="btnCancelModifPaciente" >Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnModificarPaciente">Modificar</button>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="darBajaPacienteModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Dar de Baja Paciente</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Estas seguro en dar de baja el Paciente   : <span id="codigoPacienteBaja"></span> - <span id="loginUsuarioBaja"></span>?</p>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnDarBajaPaciente">Dar Baja</button>
            </div>
        </div>
    </div>
</div>


<%@include file="../partials/footer.jsp"%>
<script src="assets/js/mantenimientos/pacientes.js"></script>

