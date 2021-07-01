<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../partials/head.jsp"%>
<%@ include file="../partials/header.jsp"%>


<div class="container-fluid">

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
                        <input type="text" id="codigoUsuario" class="form-control" value="${paciente.codigoPaciente}" autocomplete="off">
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
                    <td><input type="number" id="telefonoUsuario" class="form-control" readonly value="${paciente.telefonoPaciente}"></td>
                    <td><button id="resetUserForm" class="btn btn-light">X</button></td>
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

            <table id="lesion-section">
                <tr>
                    <td><label for="numeroExamen">Numero examen:</label></td>
                    <td><input id="numeroExamen" class="form-control" readonly></td>
                    <td><label for="fechaExamen">Fecha examen:</label></td>
                    <td><input id="fechaExamen" class="form-control" readonly></td>
                    <td><label for="estado">Estado:</label></td>
                    <td><input id="estado" class="form-control" readonly></td>
                </tr>
                <tr>
                    <td><label class="table-form-label" for="tamano">Tamaño:</label></td>
                    <td><input type="number" id="tamano" class="form-control"></td>
                    <td><label class="table-form-label">Cm</label></td>
                    <td><label class="table-form-label" for="duracionDias">Duracion:</label></td>

                    <td colspan="4">
                        <table>
                            <tr>
                                <td><label>Dias: </label></td>
                                <td><input type="number" id="duracionDias" class="form-control"></td>

                                <td><label class="table-form-label" for="duracionMeses">Meses: </label></td>
                                <td><input type="number" id="duracionMeses" class="form-control"></td>

                                <td><label class="table-form-label" for="duracionAnios">Años: </label></td>
                                <td><input type="number" id="duracionAnios" class="form-control"></td>
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
                                <option value="${tipo.codigoOpcion}">${tipo.valor}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><label class="table-form-label" for="naturalezaLesionSelect">Naturaleza:</label></td>
                    <td>
                        <select  class="form-control" name="naturalezaLesionSelect" id="naturalezaLesionSelect">
                            <option value="">Selecciona una opcion</option>
                            <c:forEach items="${tipoOpcion.NATURALEZA}" var="tipo">
                                <option value="${tipo.codigoOpcion}">${tipo.valor}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><label class="table-form-label" for="sintomaLesionSelect">Sintomas:</label></td>
                    <td>
                        <select  class="form-control" name="sintomaLesionSelect" id="sintomaLesionSelect">
                            <option value="">Selecciona una opcion</option>
                            <c:forEach items="${tipoOpcion.SINTOMA}" var="tipo">
                                <option value="${tipo.codigoOpcion}">${tipo.valor}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><label class="table-form-label" for="formaLesionSelect">Forma:</label></td>
                    <td>
                        <select  class="form-control" name="formaLesionSelect" id="formaLesionSelect">
                            <option value="">Selecciona una opcion</option>
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
                            <option value="">Selecciona una opcion</option>
                            <c:forEach items="${tipoOpcion.SUPERFICIE}" var="tipo">
                                <option value="${tipo.codigoOpcion}">${tipo.valor}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><label class="table-form-label" for="consistenciaLesionSelect">Consistencia:</label></td>
                    <td>
                        <select  class="form-control" name="consistenciaLesionSelect" id="consistenciaLesionSelect">
                            <option value="">Selecciona una opcion</option>
                            <c:forEach items="${tipoOpcion.CONSISTENCIA}" var="tipo">
                                <option value="${tipo.codigoOpcion}">${tipo.valor}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><label class="table-form-label" for="esIntaoseoLesionSelect">Intraoseo:</label></td>
                    <td>
                        <select  class="form-control" name="esIntaoseoLesionSelect" id="esIntaoseoLesionSelect">
                            <option value="">Selecciona una opcion</option>
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
                            <option value="">Selecciona una opcion</option>
                            <c:forEach items="${tipoOpcion.PIEZA}" var="tipo">
                                <option value="${tipo.codigoOpcion}">${tipo.valor}</option>
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
                        <textarea name="datosImportantes" class="form-control" id="datosImportantes" cols="150" rows="5"></textarea>
                    </td>
                    <td colspan="2">
                        <form id="upload-img-form" action="UploadServlet.do" method="post" enctype="multipart/form-data">
                            <input type="file" id="file" name="file1" />
                            <input type="submit" id="upload-button" value="upload" />
                        </form>
                    </td>
                    <td style="width: 10%;"></td>
                </tr>
                <tr>
                    <td>
                        <input type="checkbox" id="necesitaBiopsia"><label for="necesitaBiopsia"> Necesita biopsia</label>
                    </td>
                    <td>
                        <input type="checkbox" id="necesitaFrote"><label for="necesitaFrote"> Necesita frote</label>
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
                        <select multiple class="form-control" name="enfermedadSistemica" id="enfermedadSistemica">
                            <option value="">Selecciona una opcion</option>
                            <c:forEach items="${enfermedades}" var="enfermedad">
                                <option value="${enfermedad.codigoEnfermedad}">${enfermedad.nombreEnfermedad}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <label class="table-form-label" for="diagnosticoInicial">Diagnostico inicial:</label>
                    </td>
                    <td colspan="2">
                        <select multiple class="form-control" name="diagnosticoInicial" id="diagnosticoInicial">
                            <option value="">Selecciona una opcion</option>
                            <c:forEach items="${diagnosticos}" var="diagnostico">
                                <option value="${diagnostico.codigoDiagnostico}">${diagnostico.nombreDiagnostico}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>

            <hr>

            <table>
                <tr>
                    <td><label class="table-form-label" for="tipoRemision">Tipo Remision:</label></td>
                    <td><input type="text" id="tipoRemision" class="form-control"></td>
                    <td><label class="table-form-label" for="registroDoctorRemision">Registro Remision:</label></td>
                    <td><input type="text" id="registroDoctorRemision" class="form-control"></td>
                </tr>
                <tr>

                    <td><label class="table-form-label" for="doctorRemision">Doctor Remision:</label></td>
                    <td><input type="text" id="doctorRemision" class="form-control"></td>

                    <td><label class="table-form-label" for="direccionDoctorRemision">Direccion Doctor Remision:</label></td>
                    <td colspan="2"><input type="text" id="direccionDoctorRemision" class="form-control"></td>

                </tr>
                <tr>
                    <td><label class="table-form-label" for="telefonoDoctorRemision">Telefono Doctor Remision:</label></td>
                    <td><input type="text" id="telefonoDoctorRemision" class="form-control"></td>

                    <td><label class="table-form-label" for="emailDoctorRemision">Email Doctor Remision:</label></td>
                    <td><input type="text" id="emailDoctorRemision" class="form-control"></td>

                    <td><label class="table-form-label" for="dependenciaDoctorRemision">Dependencia Doctor Remision:</label></td>
                    <td><input type="text" id="dependenciaDoctorRemision" class="form-control"></td>

                </tr>
            </table>

            <hr>

            <button id="guardarExamen" class="btn btn-light">Guardar</button>
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
                <a class="nav-link" data-toggle="tab" href="#tabs-4" role="tab">Informe</a>
            </li>
        </ul><!-- Tab panes -->
        <div class="tab-content">
            <div class="tab-pane active" id="tabs-1" role="tabpanel">

            </div>
            <div class="tab-pane" id="tabs-2" role="tabpanel">

            </div>
            <div class="tab-pane" id="tabs-3" role="tabpanel">

            </div>
            <div class="tab-pane" id="tabs-4" role="tabpanel">

            </div>
        </div>
    </div>


</div>


<%@include file="../partials/footer.jsp"%>
<%@ include file="../mantenimientos/agregar-paciente.jsp"%>
<script src="assets/js/consulta/crear-consulta.js"></script>

