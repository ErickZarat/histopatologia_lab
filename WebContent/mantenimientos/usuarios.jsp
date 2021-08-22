<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../partials/head.jsp"%>
<%@ include file="../partials/header.jsp"%>


<div class="container-fluid">

    <div>
        <h1 class="main-tittle">Usuarios</h1>

        <div class="action-container left-padding-align">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-light" data-toggle="modal" data-target="#agregarUsuarioModal" id="agregarUsuarioModalBtn" >Agregar <i class="fas fa-plus"></i></button>
        </div>

        <table class="table table-striped w-75 left-margin-align" id="usuariosTable">
            <thead class="table thead-light">
            <tr style="font-weight: bold;">
                <td></td>
                <td>C&oacute;digo </td>
                <td>Login Usuario</td>
                <td>Nombres Usuario</td>
                <td>Apellidos Usuario</td>
                <td>Email Usuario</td>     
                <td>Estado Usuario</td>                                                
                <td></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${usuarios}" var="usuario">
                <tr>
                    <td><input type="radio" name="usuario" id="usuario-${usuario.codUsuario}" value="${usuario.codUsuario}"/></td>
                    <td><label for="usuario-${usuario.codUsuario}">${usuario.codUsuario}</label></td>
                    <td><label for="usuario-${usuario.codUsuario}" class="text-capitalize">${usuario.loginUsuario}</label></td>
                    <td><label for="usuario-${usuario.codUsuario}" class="text">${usuario.nombresDoctor}</label></td>
                    <td><label for="usuario-${usuario.codUsuario}" class="text-capitalize">${usuario.apellidosDoctor}</label></td>
                    <td><label for="usuario-${usuario.codUsuario}" class="text">${usuario.emailUsuario}</label></td>                    
                  <td> <button type="button" class="btn btn-secondary" id="btnCancelAgregarUsuario" data-dismiss="modal">Cancelar</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>


<!-- Modal -->
<div class="modal fade" id="agregarUsuarioModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:2500px;">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Agregar Usuarios</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
 			<form role="form" id="AgregarFormModal" class="needs-validation"  autocomplete="off" novalidate>
                <table>
                    <tr>                  
                        <td>
                        	<div class="input-group has-validation">
                        		<label for="loginUsuario" class="col-sm-4 col-form-label">Login:</label>
                        	</div>
                        </td>
                        <td>
                            <input type="text" class="form-control" id="loginUsuario"  name="loginUsuario" style="width: 322px; "  placeholder="Login Usuario" required="required">

                        </td>                        
                    </tr>
                    <tr>
                        <td><label for="nombreUsuario" class="col-sm-4 col-form-label">Nombres Usuario:</label></td>
                        <td>
                            <input type="text" class="form-control" id="nombreUsuario" name="nombreUsuario" placeholder="Nombres Doctor/Usuario"  style="width: 322px; " required>
                        </td>                    
                    </tr>
                    <tr>
                        <td><label for="apellidosUsuario" class="col-sm-4 col-form-label">Apellidos Usuario:</label></td>
                        <td>
                            <input type="text" class="form-control" id="apellidosUsuario" name="apellidosUsuario"  placeholder="Apellidos Doctor/Usuario" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="colegiadoDoctor" class="col-sm-4 col-form-label">Número Colegiado:</label></td>
                        <td>
                            <input type="text" class="form-control" id="colegiadoDoctor" name="colegiadoDoctor" placeholder="Numero Colegiado" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="emailDoctor" class="col-sm-4 col-form-label">Email:</label></td>
                        <td>
                            <input type="text" class="form-control" id="emailDoctor" name="emailDoctor" placeholder="Email Doctor/Usuario" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="pswUsuario" class="col-sm-4 col-form-label">Contraseña:</label></td>
                        <td>
                            <input type="password" class="form-control validate" id="pswUsuario"  name="pswUsuario" autocomplete="off" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="pswConfirm" class="col-sm-4 col-form-label">Confirmar Contraseña:</label></td>
                        <td>
                            <input type="password" class="form-control" id="pswConfirm" name="pswConfirm" autocomplete="off" style="width: 322px; ">
                        </td>
                    </tr>        
                    <tr>
                        <td><label for="tipoUsuario" class="col-sm-4 col-form-label">Tipo Usuario:</label></td>
                        <td>
                             <select  class="form-control" name="tipoUsuarioSelect" id="tipoUsuarioSearch">
                                <option value="0">Selecciona una opcion</option>
                                <c:forEach items="${TipUsuario}" var="tipousuario">
                                    <option value="${tipousuario.codigo}">${tipousuario.nombre}</option>
                                </c:forEach>
                            </select>
                            
                        </td>
                    </tr>                                                                                                                 
                </table>
			</form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" id="btnCancelAgregarUsuario" data-dismiss="modal" >Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnAgregarUsuario">Agregar</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="modificarUsuarioModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modificar Usuario</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
              <form role="form" id="ModificarFormModal">
                <table>
                    <tr>
                        <td><label for="codigoUsuarioMod" class="col-sm-4 col-form-label">Codigo:</label></td>
                        <td>
                            <input type="text" class="form-control" id="codigoUsuarioMod" name="codigoUsuarioMod" disabled style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="loginUsuarioMod" class="col-sm-4 col-form-label">Usuario:</label></td>
                        <td>
                            <input type="text" class="form-control" id="loginUsuarioMod" name="loginUsuarioMod" disabled style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="nombresUsuarioMod" class="col-sm-4 col-form-label">Nombres Usuario:</label></td>
                        <td>
                            <input type="text" class="form-control" id="nombresUsuarioMod" name="nombresUsuarioMod"  placeholder="Nombres Doctor/Usuario" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="apellidosUsuarioMod" class="col-sm-4 col-form-label">Apellidos Usuario:</label></td>
                        <td>
                            <input type="text" class="form-control" id="apellidosUsuarioMod" name="apellidosUsuarioMod" placeholder="Apellidos Doctor/Usuario" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="colegiadoUsuarioMod" class="col-sm-4 col-form-label">Numero Colegiado:</label></td>
                        <td>
                            <input type="text" class="form-control" id="colegiadoUsuarioMod"  name="colegiadoUsuarioMod"  placeholder="Colegiado Doctor/Usuario" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="emailUsuarioMod" class="col-sm-4 col-form-label">email Usuario: </label></td>
                        <td>
                            <input type="text" class="form-control" id="emailUsuarioMod" name="emailUsuarioMod" placeholder="Email Doctor/Usuario" style="width: 322px; ">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="tipUsuarioMod" class="col-sm-4 col-form-label">Tipo Usuario:</label></td>
                        <td>
                        	<select class="form-control" name="tipoUsuarioModSelect" id="tipoUsuarioModSearch">
                                <option value="0">Selecciona una opcion</option>
                                <c:forEach items="${TipUsuarioMod}" var="tipousuariomod">
                                    <option value="${tipousuariomod.codigo}">${tipousuariomod.nombre}</option>
                                </c:forEach>
                            </select>
                            
                        </td>
                    </tr>                                                                                                                                            
                </table>
             </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal" id="btnCancelModifUsuario">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnModificarUsuario">Modificar</button>
                <button type="button" class="btn btn-info" id="btnReinicioPswUsuario">Reinicio Contraseña</button>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="darBajaUsuarioModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Cambio de Estado Usuario</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Estas seguro de cambiar el estado del Usuario   : <span id="codigoUsuarioBaja"></span> - <span id="loginUsuarioBaja"></span>?</p>
                 <span id="estadoUsuarioBaja" hidden=true></span>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnCambioEstadoUsuario">Cambiar Estado</button>
            </div>
        </div>
    </div>
</div>




<%@include file="../partials/footer.jsp"%>
<script src="assets/js/mantenimientos/usuarios.js"></script>

