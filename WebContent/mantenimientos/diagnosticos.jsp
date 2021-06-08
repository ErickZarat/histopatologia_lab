<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../partials/head.jsp"%>
<%@ include file="../partials/header.jsp"%>


<div class="container-fluid">

    <div>
        <h1 class="main-tittle">Diagnósticos</h1>
        <div class="action-container left-padding-align">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-light" data-toggle="modal" data-target="#agregarDiagnosticoModal" id="agregarDiagnosticoModalBtn" >Agregar <i class="fas fa-plus"></i></button>
        </div>

        <table class="table table-striped w-50 left-margin-align" id="diagnosticosTable">
            <thead class="table thead-light">
            <tr style="font-weight: bold;">
                <td></td>
                <td >Código Diagnóstico</td>
                <td >Nombre Diagnóstico</td>
                <td >Estado Diagnóstico</td>                
                <td></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${diagnosticos}" var="diagnostico">
                <tr>
                    <td><input type="radio" name="diagnostico" id="diagnostico-${diagnostico.codigoDiagnostico}" value="${diagnostico.codigoDiagnostico}"/></td>
                    <td><label for="diagnostico-${diagnostico.codigoDiagnostico}">${diagnostico.codigoDiagnostico}</label></td>
                    <td><label for="diagnostico-${diagnostico.codigoDiagnostico}" class="text-capitalize">${diagnostico.nombreDiagnostico}</label></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>


<!-- Modal -->
<div class="modal fade" id="agregarDiagnosticoModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Agregar Diagnóstico</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table style="width: 716px; ">
                    <tr>
                        <td style="width: 132px; "><label for="nombreDiagnostico" class="col-sm-4 col-form-label">Nombre Diagnostico:</label></td>
                        <td style="width: 350px; ">
                            <input type="text" class="form-control" id="nombreDiagnostico" style="width: 320px; " placeholder="Nombre Diagnostico">
                        </td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" id="btnCancelAgregarDiagnostico" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnAgregarDiagnostico">Agregar</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="modificarDiagnosticoModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modificar Diagnostico</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table>
                    <tr>
                        <td><label for="codigoDiagnosticoMod" class="col-sm-4 col-form-label">Codigo:</label></td>
                        <td style="width: 487px; ">
                            <input type="text" class="form-control" id="codigoDiagnosticoMod" disabled>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 161px; "><label for="nombreDiagnosticoMod" class="col-sm-7 col-form-label">Nombre Diagnostico:</label></td>
                        <td>
                            <input type="text" class="form-control" id="nombreDiagnosticoMod" placeholder="Nombre Diagnostico">
                        </td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnModificarDiagnostico">Modificar</button>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="darBajaDiagnosticoModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Cambio de Estado Diagnóstico</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Estas seguro en cambiar el estado del diagnóstico: <span id="codigoDiagnosticoBaja" class = "text-dark"></span> - <span id="nombreDiagnosticoBaja" class = "text-dark"></span>?</p>
                <span id="estadoNuevoDiagnostico" hidden=true></span>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnDarBajaDiagnostico">Cambiar Estado</button>
            </div>
        </div>
    </div>
</div>


<%@include file="../partials/footer.jsp"%>
<script src="assets/js/mantenimientos/diagnosticos.js"></script>

