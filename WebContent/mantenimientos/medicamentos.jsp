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
                        <td><label for="codigoTipoMedicamentoSearch" class="col-sm-4 col-form-label">Codigo tipo medicamento:</label></td>
                        <td>
                            <input type="text" class="form-control" id="codigoTipoMedicamentoSearch" name="codigoTipoMedicamentoSearch" disabled>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="tipoMedicamentoSearch" class="col-sm-4 col-form-label">Tipo medicamento:</label></td>
                        <td>
                            <select  class="form-control" name="tipoMedicamentoSelect" id="tipoMedicamentoSearch">
                                <option value="0">Selecciona una opcion</option>
                                <option value="1">Antibioticos</option>
                            </select>
                        </td>
                        <td><input type="submit" value="Confirmar" class="btn btn-light"></td>
                        <td><input type="reset" value="Cancelar" class="btn btn-light"></td>
                    </tr>
                </table>
            </form>
        </div>



        <!-- Button trigger modal -->
        <button type="button" class="btn btn-light" data-toggle="modal" data-target="#agregarMedicamentoModal">
            Agregar
        </button>




        <table class="table table-striped w-50">
            <thead class="table thead-light">
            <tr style="font-weight: bold;">
                <td></td>
                <td>Codigo</td>
                <td>Nombre</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${medicamentos}" var="medicamento">
                <tr>
                    <td><input type="radio" name="medicamento" id="medicamento-${medicamento.codigoMedicamento}" value="${medicamento.codigoMedicamento}"/></td>
                    <td><label for="medicamento-${medicamento.codigoMedicamento}">${medicamento.codigoMedicamento}</label></td>
                    <td><label for="medicamento-${medicamento.codigoMedicamento}">${medicamento.nombreMedicamento}</label></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>




    <div>Presentaciones
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-light" data-toggle="modal" data-target="#agregarMedicamento">
            Agregar
        </button>
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-light" data-toggle="modal" data-target="#agregarMedicamento">
            Modificar
        </button>


        <table class="table table-striped w-50">
            <thead class="table thead-light">
            <tr style="font-weight: bold;">
                <td></td>
                <td>Presentación</td>
                <td>Creador Por</td>
                <td>Fecha Creación</td>
            </tr>
            </thead>
            <tbody id="presentacionTableBody">
<%--            <c:forEach items="${medicamentos}" var="medicamento">--%>
<%--                <tr>--%>
<%--                    <td><input type="radio" name="presentacion" id="presentacion-${medicamento.codigoMedicamento}"/></td>--%>
<%--                    <td><label for="medicamento-${medicamento.codigoMedicamento}">${medicamento.codigoMedicamento}</label></td>--%>
<%--                    <td><label for="medicamento-${medicamento.codigoMedicamento}">${medicamento.nombreMedicamento}</label></td>--%>
<%--                    <td><label for="medicamento-${medicamento.codigoMedicamento}">${medicamento.nombreMedicamento}</label></td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
            </tbody>
        </table>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="agregarPresentacion" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" >Agregar Presentación</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="presentacion">Presentacion</label>
                    <input type="text" class="form-control" id="presentacion">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnAgregarPresentacion">Agregar</button>
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
                <div class="form-group">
                    <label for="nombreMedicamento">Nombre Medicamento</label>
                    <input type="text" class="form-control" id="nombreMedicamento">
                </div>
                <div class="form-group">
                    <label for="tipoMedicamento">Tipo Medicamento</label>
                    <select name="tipoMedicamento" id="tipoMedicamento" class="form-control"></select>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnAgregarMedicamento">Agregar</button>
            </div>
        </div>
    </div>
</div>


<%@include file="../partials/footer.jsp"%>
<script src="assets/js/mantenimientos/medicamentos.js"></script>

