<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../partials/head.jsp"%>
<%@ include file="../partials/header.jsp"%>


<div class="container-fluid">

    <div>
        <h1 class="main-tittle">Enfermedades Sistemicas</h1>


        <h6 class="sub-tittle left-padding-align">  </h6>

        <div class="action-container left-padding-align">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-light" data-toggle="modal" data-target="#agregarEnfermedadModal" id="agregarEnfermedadModalBtn" >Agregar <i class="fas fa-plus"></i></button>
        </div>

        <table class="table table-striped w-50 left-margin-align" id="enfermedadesTable">
            <thead class="table thead-light">
            <tr style="font-weight: bold;">
                <td></td>
                <td>Codigo Enfermedad</td>
                <td>Nombre Enfermedad</td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${enfermedades}" var="enfermedad">
                <tr>
                    <td><input type="radio" name="enfermedad" id="enfermedad-${enfermedad.codigoEnfermedad}" value="${enfermedad.codigoEnfermedad}"/></td>
                    <td><label for="enfermedad-${enfermedad.codigoEnfermedad}">${enfermedad.codigoEnfermedad}</label></td>
                    <td><label for="enfermedad-${enfermedad.codigoEnfermedad}" class="text-capitalize">${enfermedad.nombreEnfermedad}</label></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>


<!-- Modal -->
<div class="modal fade" id="agregarEnfermedadModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Agregar Enfermedad Sistemica</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table>
                    <tr>
                        <td><label for="nombreEnfermedad" class="col-sm-4 col-form-label">Nombre Enfermedad:</label></td>
                        <td>
                            <input type="text" class="form-control" id="nombreEnfermedad" style="width: 322px; ">
                        </td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" id="btnCancelAgregarEnfermedad" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnAgregarEnfermedad">Agregar</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="modificarEnfermedadModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modificar Enfermedad</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table>
                    <tr>
                        <td><label for="codigoEnfermedadMod" class="col-sm-4 col-form-label">Codigo:</label></td>
                        <td>
                            <input type="text" class="form-control" id="codigoEnfermedadMod" disabled>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="nombreEnfermedadMod" class="col-sm-4 col-form-label">Nombre Enfermedad:</label></td>
                        <td>
                            <input type="text" class="form-control" id="nombreEnfermedadMod">
                        </td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnModificarEnfermedad">Modificar</button>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="darBajaEnfermedadModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Dar de Baja Enfermedad</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Estas seguro en dar de baja la enfermedad: <span id="codigoEnfermedadBaja"></span> - <span id="nombreEnfermedadBaja"></span>?</p>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnDarBajaEnfermedad">Dar Baja</button>
            </div>
        </div>
    </div>
</div>


<%@include file="../partials/footer.jsp"%>
<script src="assets/js/mantenimientos/enfsistemicas.js"></script>
