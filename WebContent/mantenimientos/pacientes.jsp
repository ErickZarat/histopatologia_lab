<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../partials/head.jsp"%>
<%@ include file="../partials/header.jsp"%>


<div class="container-fluid">

    <div>
        <h1 class="main-tittle">Pacientes</h1>


        <h6 class="sub-tittle left-padding-align">  </h6>

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
                    <td><input type="radio" name="paciente" id="usuario-${usuario.codigoPaciente}" value="${usuario.codUsuario}"/></td>
                    <td><label for="paciente-${paciente.codigoPaciente}">${usuario.codigoPaciente}</label></td>
                    <td><label for="paciente-${paciente.codigoPaciente}" class="text-capitalize">${usuario.nombrePaciente}</label></td>
                    <td><label for="paciente-${paciente.codigoPaciente}" class="text-capitalize">${usuario.apellidosPaciente}</label></td>
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
                <table>
                    <tr>
                        <td><label for="nombresPaciente" class="col-sm-4 col-form-label">Nombres:</label></td>
                        <td>
                            <input type="text" class="form-control" id="nombresPaciente" style="width: 322px; ">
                        </td>                        
                    </tr>
                    <tr>
                        <td><label for="apellidosPaciente" class="col-sm-4 col-form-label">Apellidos Paciente:</label></td>
                        <td>
                            <input type="text" class="form-control" id="apellidosPaciente" style="width: 322px; ">
                        </td>                    
                    </tr>
                    <tr>
                        <td><label for="direccionPaciente" class="col-sm-4 col-form-label">Direccion:</label></td>
                        <td>
                            <input type="text" class="form-control" id="direccionPaciente" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="colegiadoDoctor" class="col-sm-4 col-form-label">Número Colegiado:</label></td>
                        <td>
                            <input type="text" class="form-control" id="colegiadoDoctor" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="emailDoctor" class="col-sm-4 col-form-label">Email:</label></td>
                        <td>
                            <input type="text" class="form-control" id="emailDoctor" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="pswUsuario" class="col-sm-4 col-form-label">Password:</label></td>
                        <td>
                            <input type="password" class="form-control" id="pswUsuario" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="pswConfirm" class="col-sm-4 col-form-label">Confirmar Password:</label></td>
                        <td>
                            <input type="password" class="form-control" id="pswConfirm" style="width: 322px; ">
                        </td>
                    </tr>        
                    <tr>
                        <td><label for="tipoUsuario" class="col-sm-4 col-form-label">Tipo Usuario:</label></td>
                        <td>
                            <input type="text" class="form-control" id="tipoUsuario" style="width: 322px; ">
                        </td>
                    </tr>                                                                                                                 
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" id="btnCancelAgregarPaciente" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnAgregarPaciente">Agregar</button>
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
                        <td><label for="apellidosUsuarioMod" class="col-sm-4 col-form-label">Apellidos Usuario:</label></td>
                        <td>
                            <input type="text" class="form-control" id="apellidosUsuarioMod" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="colegiadoUsuarioMod" class="col-sm-4 col-form-label">Numero Colegiado:</label></td>
                        <td>
                            <input type="text" class="form-control" id="colegiadoUsuarioMod" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="passwordUsuarioMod" class="col-sm-4 col-form-label">Password:</label></td>
                        <td>
                            <input type="text" class="form-control" id="passwordUsuarioMod" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="confPswUsuarioMod" class="col-sm-4 col-form-label">Confirmar Password:</label></td>
                        <td>
                            <input type="text" class="form-control" id="confPswUsuarioMod" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="emailUsuarioMod" class="col-sm-4 col-form-label">email Usuario: </label></td>
                        <td>
                            <input type="text" class="form-control" id="emailUsuarioMod" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="tipUsuarioMod" class="col-sm-4 col-form-label">Tipo de Usuario:</label></td>
                        <td>
                            <input type="text" class="form-control" id="tipUsuarioMod" style="width: 322px; ">
                        </td>
                    </tr>                                                                                                                                            
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
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
<script src="assets/js/mantenimientos/pacientes2.js"></script>

