<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../partials/head.jsp"%>
<%@ include file="../partials/header.jsp"%>


<div class="container-fluid">

    <div>
        <h1 class="main-tittle">Medicamentos</h1>


        <div class="search-container">
            <form class="align-middle" action="MedicamentosServlet.do" method="post">

                <table>
                    <tr>
                        <td><label for="tipoMedicamentoSearch" class="col-sm-4 col-form-label">Tipo medicamento:</label></td>
                        <td>
                            <select  class="form-control" name="tipoMedicamentoSelect" id="tipoMedicamentoSearch">
                                <option value="0">Selecciona una opcion</option>
                                <c:forEach items="${tiposMedicamento}" var="tipo">
                                    <option value="${tipo.codigo}">${tipo.nombre}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>
            </form>
        </div>

        <h6 class="sub-tittle left-padding-align">Medicamentos</h6>

        <div class="action-container left-padding-align">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-light" data-toggle="modal" data-target="#agregarMedicamentoModal" id="agregarMedicamentoModalBtn" disabled>Agregar <i class="fas fa-plus"></i></button>
        </div>

        <table class="table table-striped w-50 left-margin-align" id="medicamentosTable">
            <thead class="table thead-light">
            <tr style="font-weight: bold;">
                <td></td>
                <td>Codigo Medicamento</td>
                <td>Nombre Medicamento</td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${medicamentos}" var="medicamento">
                <tr>
                    <td><input type="radio" name="medicamento" id="medicamento-${medicamento.codigoMedicamento}" value="${medicamento.codigoMedicamento}"/></td>
                    <td><label for="medicamento-${medicamento.codigoMedicamento}">${medicamento.codigoMedicamento}</label></td>
                    <td><label for="medicamento-${medicamento.codigoMedicamento}" class="text-capitalize">${medicamento.nombreMedicamento}</label></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>



    <div>
        <h6 class="sub-tittle left-padding-align">Presentaciones</h6>

        <div class="action-container left-padding-align">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-light" data-toggle="modal" data-target="#agregarPresentacionModal" id="agregarPresentacionModalBtn" disabled>Agregar <i class="fas fa-plus"></i></button>
<%--            <button type="button" class="btn btn-light" data-toggle="modal" data-target="#modificarPresentacionModal" id="modificarPresentacionModalBtn" disabled>Modificar</button>--%>
        </div>

        <table class="table table-striped w-50 left-margin-align" id="presentacionMedicamentosTable">
            <thead class="table thead-light">
            <tr style="font-weight: bold;">
                <td></td>
                <td>Presentación</td>
                <td>Creador Por</td>
                <td>Fecha Creación</td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="agregarPresentacionModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" >Agregar Presentación</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table>
                    <tr>
                        <td><label for="codigoMedicamentoPresentacion" class="col-sm-4 col-form-label">Codigo tipo medicamento:</label></td>
                        <td>
                            <input type="text" class="form-control" id="codigoMedicamentoPresentacion"  name="codigoMedicamentoPresentacion" disabled>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="tipoPresentacion" class="col-sm-4 col-form-label">Tipo presentacion:</label></td>
                        <td>
                            <input type="text" class="form-control" id="tipoPresentacion"  name="tipoPresentacion">
                        </td>
                    </tr>

                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="agregarPresentacionBtn">Agregar</button>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="modificarPresentacionModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" >Modificar Presentación</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table>
                    <tr>
                        <td><label for="codigoMedicamentoPresentacion" class="col-sm-4 col-form-label">Codigo tipo medicamento:</label></td>
                        <td>
                            <input type="text" class="form-control" id="codigoMedicamentoPresentacionMod"  name="codigoMedicamentoPresentacion" disabled>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="tipoPresentacion" class="col-sm-4 col-form-label">Tipo presentacion:</label></td>
                        <td>
                            <input type="text" class="form-control" id="tipoPresentacionCurrentMod"  name="tipoPresentacionCurrent" disabled>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="tipoPresentacion" class="col-sm-4 col-form-label">Tipo presentacion:</label></td>
                        <td>
                            <input type="text" class="form-control" id="tipoPresentacionMod"  name="tipoPresentacion">
                        </td>
                    </tr>

                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="modificarPresentacionBtn">Modificar</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="agregarMedicamentoModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Agregar Medicamento</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table>
                    <tr>
                        <td><label for="nombreMedicamento" class="col-sm-4 col-form-label">Nombre Medicamento:</label></td>
                        <td>
                            <input type="text" class="form-control" id="nombreMedicamento">
                        </td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnAgregarMedicamento">Agregar</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="modificarMedicamentoModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modificar Medicamento</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table>
                    <tr>
                        <td><label for="codigoMedicamentoMod" class="col-sm-4 col-form-label">Codigo:</label></td>
                        <td>
                            <input type="text" class="form-control" id="codigoMedicamentoMod" disabled>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="nombreMedicamentoMod" class="col-sm-4 col-form-label">Nombre Medicamento:</label></td>
                        <td>
                            <input type="text" class="form-control" id="nombreMedicamentoMod">
                        </td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnModificarMedicamento">Modificar</button>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="darBajaMedicamentoModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Dar de Baja Medicamento</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Estas seguro en dar de baja el medicamento: <span id="codigoMedicamentoBaja"></span> - <span id="nombreMedicamentoBaja"></span>?</p>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnDarBajaMedicamento">Dar Baja</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="darBajaPresentacionModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Dar de Baja Presentacion</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Estas seguro en dar de baja la presentacion: <span id="codigoMedicamentoPresentacionBaja"></span> - <span id="tipoPresentacionBaja"></span>?</p>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnDarBajaPresentacion">Dar Baja</button>
            </div>
        </div>
    </div>
</div>


<%@include file="../partials/footer.jsp"%>
<script src="assets/js/mantenimientos/medicamentos.js"></script>

