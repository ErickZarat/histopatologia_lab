<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../partials/head.jsp"%>
<%@ include file="../partials/header.jsp"%>


<div class="container-fluid">

    <input type="hidden" id="codExamen" value="${codExamen}">
    <input type="hidden" id="codBiopsia" value="${codBiopsia}">
    <input type="hidden" id="codInformeBiopsia" value="${codInformeBiopsia}">
    <input type="hidden" id="codFrote" value="${codFrote}">
    <input type="hidden" id="codInformeFrote" value="${codInformeFrote}">

    <label class="accordion-label" for="paciente-accordion">
        <div class="accordion-title-container">
            <h1 class="main-tittle">Paciente</h1>
        </div>
    </label>
    <input type="checkbox" checked class="accordion" id="paciente-accordion">
    <div class="user-container container-fluid">
        <form id="consultaForm" autocomplete="off" class="align-middle" action="ConsultaServlet.do" method="post">

            <table id="pacienteSection">
                <tr>
                    <td><label class="table-form-label" for="codigoUsuario">Codigo:</label></td>
                    <td class="search">
                        <input type="text" id="codigoUsuario" class="form-control" value="${paciente.codigoPaciente}" autocomplete="off" <c:if test="${action=='VER'}">readonly</c:if>>
                        <ul class="results" >
                        </ul>
                     </td>
                    <td><label class="table-form-label" for="nombreUsuario">Nombre:</label></td>
                    <td colspan="3"><input type="text" id="nombreUsuario" class="form-control" readonly value="${paciente.nombrePaciente} ${paciente.apellidosPaciente}"></td>
                </tr>
                <tr>
                    <td><label class="table-form-label" for="estadoCivilUsuario">Estado civil:</label></td>
                    <td><input type="text" id="estadoCivilUsuario" class="form-control" readonly value="${paciente.estCivilPaciente}"></td>
                    <td><label class="table-form-label" for="ocupacionUsuario">Ocupacion:</label></td>
                    <td><input type="text" id="ocupacionUsuario" class="form-control" readonly value="${paciente.ocupacionPaciente}"></td>
                    <td><label class="table-form-label" for="edadUsuario">Edad:</label></td>
                    <td><input type="number" id="edadUsuario" class="form-control" readonly value="${paciente.calculateAge()}"></td>
                </tr>
                <tr>
                    <td><label class="table-form-label" for="emailUsuario">Email:</label></td>
                    <td><input type="email" id="emailUsuario" class="form-control" readonly value="${paciente.emailPaciente}"></td>
                    <td><label class="table-form-label" for="telefonoUsuario">Telefono:</label></td>
                    <td><input type="text" id="telefonoUsuario" class="form-control" readonly value="${paciente.telefonoPaciente}"></td>
                    <td><label class="table-form-label" for="numeroFicha">Numero Ficha:</label></td>
                    <td><input type="text" id="numeroFicha" class="form-control" readonly value="${paciente.numFicha}"></td>
                    <c:if test="${action=='CREAR'}">
                        <td><button id="resetUserForm" class="btn btn-light">X</button></td>
                    </c:if>
                </tr>
            </table>
        </form>
    </div>

    <label class="accordion-label" for="lesion-accordion">
        <div class="accordion-title-container">
            <h1 class="main-tittle">Lesion</h1>
        </div>
    </label>
    <input type="checkbox" class="accordion" id="lesion-accordion">

    <div class="lesion-container container-fluid">
        <form class="align-middle" action="ConsultaServlet.do" method="post">
            <c:if test="${action=='VER'}">
            <fieldset disabled="disabled">
                </c:if>
                <table id="lesion-section">
                    <tr>
                        <td><label for="numeroExamen">Numero examen:</label></td>
                        <td><input id="numeroExamen" class="form-control" readonly value="${examen.numExamen}"></td>
                        <td><label for="fechaExamen">Fecha examen:</label></td>
                        <td><input id="fechaExamen" class="form-control" readonly value="${fechaExamen}"></td>
                        <td><label for="estado">Estado:</label></td>
                        <td><input id="estado" class="form-control" readonly value="${examen.estado}"></td>
                    </tr>
                    <tr>
                        <td><label class="table-form-label" for="tamano">Tamaño:</label></td>
                        <td><input type="number" id="tamano" class="form-control" value="${examen.tamanoLesion}"></td>
                        <td><label class="table-form-label">Cm</label></td>
                        <td><label class="table-form-label" for="duracionDias">Duracion:</label></td>

                        <td colspan="4">
                            <table>
                                <tr>
                                    <td><label>Dias: </label></td>
                                    <td><input type="number" id="duracionDias" class="form-control" value="${examen.duracionLesionDias}"></td>

                                    <td><label class="table-form-label" for="duracionMeses">Meses: </label></td>
                                    <td><input type="number" id="duracionMeses" class="form-control" value="${examen.duracionLesionMeses}"></td>

                                    <td><label class="table-form-label" for="duracionAnios">Años: </label></td>
                                    <td><input type="number" id="duracionAnios" class="form-control" value="${examen.duracionLesionAnios}"></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><label class="table-form-label" for="colorLesionSelect">Color:</label></td>
                        <td>
                            <select  class="form-control" name="colorLesionSelect" id="colorLesionSelect">
                                <option value="">Selecciona una opcion</option>
                                <c:forEach items="${tipoOpcion.COLOR}" var="tipo">
                                    <option value="${tipo.codigoOpcion}" <c:if test='${fn:contains(examen.caracteristicas, tipo.codigoOpcion)}'>selected</c:if>>${tipo.valor}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><label class="table-form-label" for="naturalezaLesionSelect">Naturaleza:</label></td>
                        <td>
                            <select  class="form-control" name="naturalezaLesionSelect" id="naturalezaLesionSelect">
                                <option value="">Selecciona una opcion</option>
                                <c:forEach items="${tipoOpcion.NATURALEZA}" var="tipo">
                                    <option value="${tipo.codigoOpcion}" <c:if test='${fn:contains(examen.caracteristicas, tipo.codigoOpcion)}'>selected</c:if>>${tipo.valor}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><label class="table-form-label" for="sintomaLesionSelect">Sintomas:</label></td>
                        <td>
                            <select  class="form-control" name="sintomaLesionSelect" id="sintomaLesionSelect">
                                <option value="">Selecciona una opcion</option>
                                <c:forEach items="${tipoOpcion.SINTOMA}" var="tipo">
                                    <option value="${tipo.codigoOpcion}" <c:if test='${fn:contains(examen.caracteristicas, tipo.codigoOpcion)}'>selected</c:if>>${tipo.valor}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><label class="table-form-label" for="formaLesionSelect">Forma:</label></td>
                        <td>
                            <select  class="form-control" name="formaLesionSelect" id="formaLesionSelect">
                                <option value="">Selecciona una opcion</option>
                                <c:forEach items="${tipoOpcion.FORMA}" var="tipo">
                                    <option value="${tipo.codigoOpcion}" <c:if test='${fn:contains(examen.caracteristicas, tipo.codigoOpcion)}'>selected</c:if>>${tipo.valor}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label class="table-form-label" for="superficieLesionSelect">Superficie:</label></td>
                        <td>
                            <select  class="form-control" name="superficieLesionSelect" id="superficieLesionSelect">
                                <option value="">Selecciona una opcion</option>
                                <c:forEach items="${tipoOpcion.SUPERFICIE}" var="tipo">
                                    <option value="${tipo.codigoOpcion}" <c:if test='${fn:contains(examen.caracteristicas, tipo.codigoOpcion)}'>selected</c:if>>${tipo.valor}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><label class="table-form-label" for="consistenciaLesionSelect">Consistencia:</label></td>
                        <td>
                            <select  class="form-control" name="consistenciaLesionSelect" id="consistenciaLesionSelect">
                                <option value="">Selecciona una opcion</option>
                                <c:forEach items="${tipoOpcion.CONSISTENCIA}" var="tipo">
                                    <option value="${tipo.codigoOpcion}" <c:if test='${fn:contains(examen.caracteristicas, tipo.codigoOpcion)}'>selected</c:if>>${tipo.valor}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><label class="table-form-label" for="esIntaoseoLesionSelect">Intraoseo:</label></td>
                        <td>
                            <select  class="form-control" name="esIntaoseoLesionSelect" id="esIntaoseoLesionSelect">
                                <option value="">Selecciona una opcion</option>
                                <c:forEach items="${tipoOpcion.INTRAOSEO}" var="tipo">
                                    <option value="${tipo.codigoOpcion}" <c:if test='${fn:contains(examen.caracteristicas, tipo.codigoOpcion)}'>selected</c:if>>${tipo.valor}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label class="table-form-label" for="piezaLesionSelect">Asocia Pieza:</label></td>
                        <td>
                            <select  class="form-control" name="piezaLesionSelect" id="piezaLesionSelect">
                                <option value="">Selecciona una opcion</option>
                                <c:forEach items="${tipoOpcion.PIEZA}" var="tipo">
                                    <option value="${tipo.codigoOpcion}" <c:if test='${fn:contains(examen.caracteristicas, tipo.codigoOpcion)}'>selected</c:if>>${tipo.valor}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>

                <hr>

                <table>
                    <tr>
                        <td>
                            <label class="table-form-label" for="datosImportantes">Datos Importantes:</label>
                        </td>
                        <td>
                            <textarea name="datosImportantes" class="form-control" id="datosImportantes" cols="150" rows="5">${examen.datosImportantesLesion}</textarea>
                        </td>
                        <td colspan="2">
                            <ul id="imageContainer">
                                <c:forEach items="${examen.imagenes}" var="img" varStatus="loop">
                                    <li><a href="${img}" target="_blank">image-${loop.index}</a></li>
                                </c:forEach>
                            </ul>
                            <form id="upload-img-form" action="UploadServlet.do" method="post" enctype="multipart/form-data">
                                <input type="file" id="file" name="file1" multiple />
                                <input class="btn" type="submit" id="upload-button" value="Subir imagenes" />
                            </form>
                        </td>
                        <td style="width: 10%;"></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="checkbox" id="necesitaBiopsia" <c:if test="${examen.necesitaBiopsia}">checked</c:if> ><label for="necesitaBiopsia"> Necesita biopsia</label>
                        </td>
                        <td>
                            <input type="checkbox" id="necesitaFrote" <c:if test="${examen.necesitaFrote}">checked</c:if> ><label for="necesitaFrote"> Necesita frote</label>
                        </td>
                    </tr>
                </table>

                <hr>

                <table>
                    <tr>
                        <td>
                            <label class="table-form-label" for="enfermedadSistemica">Enfermedad Sistemica:</label>
                        </td>
                        <td>
                            <select multiple class="form-control select2" name="enfermedadSistemica" id="enfermedadSistemica">
                                <option value="">Selecciona una opcion</option>
                                <c:forEach items="${enfermedades}" var="enfermedad">
                                    <option value="${enfermedad.codigoEnfermedad}" <c:if test='${fn:contains(examen.enfermedades, enfermedad.codigoEnfermedad)}'>selected</c:if>>${enfermedad.nombreEnfermedad}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <label class="table-form-label" for="diagnosticoInicial">Diagnostico inicial:</label>
                        </td>
                        <td colspan="2">
                            <select multiple class="form-control select2" name="diagnosticoInicial" id="diagnosticoInicial">
                                <option value="">Selecciona una opcion</option>
                                <c:forEach items="${diagnosticos}" var="diagnostico">
                                    <option value="${diagnostico.codigoDiagnostico}" <c:if test='${fn:contains(examen.diagnosticos, diagnostico.codigoDiagnostico)}'>selected</c:if>>${diagnostico.nombreDiagnostico}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>

                <hr>

                <table>
                    <tr>

                        <td><label class="table-form-label" for="doctorRemision">Remitido por:</label></td>
                        <td colspan="2"><input type="text" id="doctorRemision" class="form-control" value="${examen.doctorRemision}"></td>
                        <td></td>
                        <td><label class="table-form-label" for="direccionDoctorRemision">Direccion Doctor:</label></td>
                        <td colspan="2"><input style="width:200%" type="text" id="direccionDoctorRemision" class="form-control" value="${examen.direccionDoctorRemision}"></td>

                    </tr>
                    <tr>
                        <td><label class="table-form-label" for="telefonoDoctorRemision">Telefono Doctor:</label></td>
                        <td><input type="text" id="telefonoDoctorRemision" class="form-control" value="${examen.telefonoDoctorRemision}"></td>

                        <td><label class="table-form-label" for="emailDoctorRemision">Email Doctor:</label></td>
                        <td><input type="text" id="emailDoctorRemision" class="form-control" value="${examen.emailDoctorRemision}"></td>

                        <td><label class="table-form-label" for="dependenciaDoctorRemision">Dependencia Doctor:</label></td>
                        <td><input style="width:200%" type="text" id="dependenciaDoctorRemision" class="form-control" value="${examen.dependenciaDoctorRemision}"></td>

                    </tr>
                </table>

                <hr>

                <button id="guardarExamen" class="btn btn-light">Guardar</button>
                <c:if test="${action=='VER'}">
            </fieldset>
            </c:if>
        </form>
    </div>



    <label class="accordion-label" for="tab-accordion">
        <div class="accordion-title-container">
        </div>
    </label>
    <input type="checkbox" class="accordion" id="tab-accordion">
    <div class="container-fluid">
        <ul class="nav nav-tabs" role="tablist">
            <li class="nav-item">
                <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">Biopsia</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">Frote</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab">Receta</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#tabs-4" role="tab">Seguimientos</a>
            </li>            
        </ul><!-- Tab panes -->
        <div class="tab-content">
            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                <%@ include file="biopsia/form.jsp"%>
            </div>
            <div class="tab-pane" id="tabs-2" role="tabpanel">
                <%@ include file="frote/form.jsp"%>
            </div>
            <div class="tab-pane" id="tabs-3" role="tabpanel">
                <%@ include file="receta/receta.jsp"%>
            </div>
            <div class="tab-pane" id="tabs-4" role="tabpanel">
                <%@ include file="seguimiento/seguimiento.jsp"%>
            </div>            
        </div>
    </div>


</div>


<%@include file="../partials/footer.jsp"%>
<%@ include file="../mantenimientos/agregar-paciente.jsp"%>
<script src="assets/js/consulta/crear-consulta.js"></script>
<script src="assets/js/consulta/biopsia.js"></script>
<script src="assets/js/consulta/frote.js"></script>
<script src="assets/js/consulta/receta.js"></script>
<script src="assets/js/consulta/seguimiento.js"></script>

