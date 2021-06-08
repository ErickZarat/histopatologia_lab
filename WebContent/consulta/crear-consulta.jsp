<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../partials/head.jsp"%>
<%@ include file="../partials/header.jsp"%>


<div class="container-fluid">

    <div class="user-container container-fluid">
        <form class="align-middle" action="ConsultaServlet.do" method="post">

            <table>
                <tr>
                    <td colspan="2"><h1 class="main-tittle">Paciente</h1></td>
                </tr>
                <tr>
                    <td><label class="table-form-label" for="codigoUsuario">Codigo:</label></td>
                    <td class="search">
                        <input type="text" id="codigoUsuario" class="form-control" value="${paciente.codigoPaciente}">
                        <ul class="results" >
                        </ul>
                    </td>
                    <td><label class="table-form-label" for="nombreUsuario">Nombre:</label></td>
                    <td colspan="3"><input type="text" id="nombreUsuario" class="form-control" value="${paciente.nombrePaciente} ${paciente.apellidosPaciente}"></td>
                </tr>
                <tr>
                    <td><label class="table-form-label" for="estadoCivilUsuario">Estado civil:</label></td>
                    <td><input type="text" id="estadoCivilUsuario" class="form-control" value="${paciente.estadoCivil}"></td>
                    <td><label class="table-form-label" for="ocupacionUsuario">Ocupacion:</label></td>
                    <td><input type="text" id="ocupacionUsuario" class="form-control" value="${paciente.ocupacionPaciente}"></td>
                    <td><label class="table-form-label" for="edadUsuario">Edad:</label></td>
                    <td><input type="number" id="edadUsuario" class="form-control" value="${paciente.calculateAge()}"></td>
                </tr>
                <tr>
                    <td><label class="table-form-label" for="emailUsuario">Email:</label></td>
                    <td><input type="email" id="emailUsuario" class="form-control" value="${paciente.emailPaciente}"></td>
                    <td><label class="table-form-label" for="telefonoUsuario">Telefono:</label></td>
                    <td><input type="number" id="telefonoUsuario" class="form-control" value="${paciente.telefonoPaciente}"></td>
                </tr>
            </table>
            <button id="guardarPaciente">Guardar</button>
        </form>
    </div>

    <div class="action-container left-padding-align">
    </div>

    <div class="lesion-container container-fluid">
        <form class="align-middle" action="ConsultaServlet.do" method="post">

            <table>
                <tr>
                    <td colspan="2"><h1 class="main-tittle">Lesion</h1></td>
                </tr>
                <tr>
                    <td><label class="table-form-label" for="tamano">Tamaño:</label></td>
                    <td><input type="text" id="tamano" class="form-control"></td>
                    <td><label class="table-form-label">Cm</label></td>
                    <td><label class="table-form-label" for="duracionDias">Duracion: Dias: </label></td>
                    <td><input type="text" id="duracionDias" class="form-control"></td>

                    <td><label class="table-form-label" for="duracionMeses">Meses: </label></td>
                    <td><input type="text" id="duracionMeses" class="form-control"></td>

                    <td><label class="table-form-label" for="duracionAnios">Años: </label></td>
                    <td><input type="text" id="duracionAnios" class="form-control"></td>
                </tr>
                <tr>
                    <td><label class="table-form-label" for="colorLesionSelect">Color:</label></td>
                    <td>
                        <select  class="form-control" name="colorLesionSelect" id="colorLesionSelect">
                            <c:forEach items="${tipoOpcion.COLOR}" var="tipo">
                                <option value="${tipo.codigoOpcion}">${tipo.valor}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><label class="table-form-label" for="naturalezaLesionSelect">Naturaleza:</label></td>
                    <td>
                        <select  class="form-control" name="naturalezaLesionSelect" id="naturalezaLesionSelect">
                            <c:forEach items="${tipoOpcion.NATURALEZA}" var="tipo">
                                <option value="${tipo.codigoOpcion}">${tipo.valor}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><label class="table-form-label" for="sintomaLesionSelect">Sintomas:</label></td>
                    <td>
                        <select  class="form-control" name="sintomaLesionSelect" id="sintomaLesionSelect">
                            <c:forEach items="${tipoOpcion.SINTOMA}" var="tipo">
                                <option value="${tipo.codigoOpcion}">${tipo.valor}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><label class="table-form-label" for="formaLesionSelect">Forma:</label></td>
                    <td>
                        <select  class="form-control" name="formaLesionSelect" id="formaLesionSelect">
                            <c:forEach items="${tipoOpcion.FORMA}" var="tipo">
                                <option value="${tipo.codigoOpcion}">${tipo.valor}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label class="table-form-label" for="superficieLesionSelect">Superficie:</label></td>
                    <td>
                        <select  class="form-control" name="superficieLesionSelect" id="superficieLesionSelect">
                            <c:forEach items="${tipoOpcion.SUPERFICIE}" var="tipo">
                                <option value="${tipo.codigoOpcion}">${tipo.valor}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><label class="table-form-label" for="consistenciaLesionSelect">Color:</label></td>
                    <td>
                        <select  class="form-control" name="consistenciaLesionSelect" id="consistenciaLesionSelect">
                            <c:forEach items="${tipoOpcion.CONSISTENCIA}" var="tipo">
                                <option value="${tipo.codigoOpcion}">${tipo.valor}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><label class="table-form-label" for="esIntaoseoLesionSelect">Color:</label></td>
                    <td>
                        <select  class="form-control" name="esIntaoseoLesionSelect" id="esIntaoseoLesionSelect">
                            <c:forEach items="${tipoOpcion.INTRAOSEO}" var="tipo">
                                <option value="${tipo.codigoOpcion}">${tipo.valor}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label class="table-form-label" for="piezaLesionSelect">Asocia Pieza:</label></td>
                    <td>
                        <select  class="form-control" name="piezaLesionSelect" id="piezaLesionSelect">
                            <c:forEach items="${tipoOpcion.PIEZA}" var="tipo">
                                <option value="${tipo.codigoOpcion}">${tipo.valor}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="table-form-label" for="datosImportantes">Datos Importantes:</label>
                    </td>
                    <td colspan="3">
                        <textarea name="datosImportantes" class="form-control" id="datosImportantes" cols="300" rows="5"></textarea>
                    </td>
                    <td>
                        <button class="btn btn-light">Imagenes</button>
                    </td>
                </tr>
            </table>
            <button id="guardarExamen">Guardar</button>
        </form>
    </div>

    <div class="action-container left-padding-align">
    </div>

    <div class="container-fluid">
        <ul class="nav nav-tabs" role="tablist">
            <li class="nav-item">
                <a class="nav-link active main-tittle" data-toggle="tab" href="#tabs-1" role="tab">Biopsis</a>
            </li>
            <li class="nav-item">
                <a class="nav-link main-tittle" data-toggle="tab" href="#tabs-2" role="tab">Frote</a>
            </li>
            <li class="nav-item">
                <a class="nav-link main-tittle" data-toggle="tab" href="#tabs-3" role="tab">Receta</a>
            </li>
        </ul><!-- Tab panes -->
        <div class="tab-content">
            <div class="tab-pane active" id="tabs-1" role="tabpanel">

            </div>
            <div class="tab-pane" id="tabs-2" role="tabpanel">

            </div>
            <div class="tab-pane" id="tabs-3" role="tabpanel">

            </div>
        </div>
    </div>


</div>


<%@include file="../partials/footer.jsp"%>
<script src="assets/js/consulta/crear-consulta.js"></script>

