<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../partials/head.jsp"%>
<%@ include file="../partials/header.jsp"%>


<div>
<input type="hidden" id="opcionSelec" name="opcionSelec" value=" ${opcion}">
</div>


 <!-- Modal -->
<div class="modal fade" id="cambioPswUsuarioModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Cambio de contraseña</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
         	<form role="form" id="CambioPswFormModal">            
                <table >
                   <tr>
                        <td ><label for="Usuario" class="col-sm-4 col-form-label">Usuario:</label></td>
                        <td >
                            <h5> ${username} </h5><input type="hidden" name="loginUsuario" value="${username}">
                        </td>
                    </tr>                
                    <tr>
                        <td ><label for="paswordAnterior" class="col-sm-4 col-form-label">Contraseña Anterior:</label></td>
                        <td >
                            <input type="password" class="form-control validate" id="passwordAnterior" style="width: 320px;" placeholder="Contraseña Actual">
                        </td>
                    </tr>
 					<tr>
                        <td ><label for="nuevoPassword" class="col-sm-4 col-form-label">Nueva Contraseña:</label></td>
                        <td >
                            <input type="password" class="form-control validate" id="nuevoPassword" style="width: 320px;" placeholder="Nueva Contraseña">
                        </td>
                    </tr>                    
 					<tr>
                        <td ><label for="confirNuevoPassword" class="col-sm-4 col-form-label">Confirmar Contraseña:</label></td>
                        <td >
                            <input type="password" class="form-control validate" id="confirNuevoPassword" style="width: 320px;" placeholder="Confirmar Nueva Contraseña">
                        </td>
                    </tr>                    
                </table>
               </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" id="btnCancelCambioPsw" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnCambioPsw">Cambiar Password</button>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="logoutUsuarioModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Cerrar Sesion</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body"> ¿Deseas cerrar tu sesión actual? </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" id="btnCancelCerrarSesion" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnCerrarSesion">Cerrar Sesion</button>
            </div>
        </div>
    </div>
</div>

<%@include file="../partials/footer.jsp"%>
<script src="assets/js/mantenimientos/login.js"></script>


