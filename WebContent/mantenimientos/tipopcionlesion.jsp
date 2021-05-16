<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../partials/head.jsp"%>
<%@ include file="../partials/header.jsp"%>


<div class="container-fluid">

    <div>
        <h1 class="main-tittle">Tipo Opcion Lesion</h1>


        <div class="search-container">
            <form class="align-middle" action="OpcionLesionServlet.do" method="post">

                <table>
                    <tr>
                        <td><label for="TipOpcionSearch" class="col-sm-4 col-form-label">Tipo Opcion:</label></td>
                        <td>
                            <select  class="form-control" name="tipoOpcionSelect" id="TipoOpcionSearch">
                                <option value="0">Selecciona una opcion</option>
                                <c:forEach items="${tipOpcion}" var="tipo">
                                    <option value="${tipo.codigo}">${tipo.nombre}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>
            </form>
        </div>

        <h6 class="sub-tittle left-padding-align">Valores Opcion</h6>

        <div class="action-container left-padding-align">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-light" data-toggle="modal" data-target="#agregarOpcionLesionModal" id="agregarOpcionLesionModalBtn" >Agregar <i class="fas fa-plus"></i></button>
        </div>

        <table class="table table-striped w-50 left-margin-align" id="opcionlesionTable">
            <thead class="table thead-light">
            <tr style="font-weight: bold;">
                <td></td>
                <td>Codigo Tipo</td>
                <td>Valor Tipo Opcion</td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${opcionlesiones}" var="opcionlesion">
                <tr>
                    <td><input type="radio" name="opcionlesion" id="opcionlesion-${opcionLesion.codigoOpcion}" value="${opcionlesion.codigoOpcion}"/></td>
                    <td><label for="opcionlesion-${opcionlesion.codigoOpcion}">${opcionlesion.codigoOpcion}</label></td>
                    <td><label for="opcionlesion-${opcionlesion.codigoOpcion}" class="text-capitalize">${opcionlesion.nombreOpcion}</label></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>





<!-- Modal -->
<div class="modal fade" id="agregarOpcionLesionModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Agregar Opcion Lesion</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table>
                    <tr>
                        <td><label for="valorOpcion" class="col-sm-4 col-form-label">Valor Opcion:</label></td>
                        <td>
                            <input type="text" class="form-control" id="nombreOpcionLesion">
                        </td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnAgregarOpcionLesion">Agregar</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="modificarOpcionModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modificar Valor Opcion</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table>
                    <tr>
                        <td><label for="codigoOpcionLesionMod" class="col-sm-4 col-form-label">Codigo Opcion:</label></td>
                        <td>
                            <input type="text" class="form-control" id="codigoOpcionLesionMod" disabled>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="valorOpcionLesionMod" class="col-sm-4 col-form-label">Valor Opcion:</label></td>
                        <td>
                            <input type="text" class="form-control" id="valorOpcionLesionMod">
                        </td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnModificarOpcionLesion">Modificar</button>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="darBajaOpcionModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Dar de Baja Opcion Lesion</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Estas seguro en dar de baja a la opcion lesion: <span id="codigoOpcionLesionBaja"></span> - <span id="valorOpcionLesionBaja"></span>?</p>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnDarBajaOpcionLesion">Dar Baja</button>
            </div>
        </div>
    </div>
</div>


<%@include file="../partials/footer.jsp"%>
<script src="assets/js/mantenimientos/opcioneslesion.js"></script>

