<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body onload="window.print()" style="line-height: 1.8">
<div style="text-align: center; height: 120px;">
    <div style="vertical-align: middle; display: inline-block;text-align: center; height: 100%; font-weight: 800;">
        <div>Laboratorio de Histopatolog&iacute;a Multidisciplinario, USAC, Guatemala</div>
        <div>Dr. C&eacute;sar L&oacute;pez Acevedo</div>
    </div>
    <div style="display: inline-block">
        <img src="assets/img/logo.png" style="width: 120px; height:auto;">
    </div>
</div>
<hr style="height:4px;border-width:0;color:#9b98ee;background-color:#9b98ee">

<div style="display: inline-block; width: 45%">
    <table  style="line-height: 1.8">
        <tr>
            <td style="font-weight: 800;">Estudio: </td>
            <td style="width: 80%; border-bottom: 2px solid;">${biopsia.muestraEstudio}</td>
        </tr>

        <tr>
            <td style="font-weight: 800;">Paciente: </td>
            <td style="width: 80%; border-bottom: 2px solid;">${paciente.nombrePaciente} ${paciente.apellidosPaciente}</td>
        </tr>

        <tr>
            <td style="font-weight: 800;">Sexo: </td>
            <td style="width: 80%; border-bottom: 2px solid;">${paciente.generoPaciente}</td>
        </tr>

        <tr>
            <td style="font-weight: 800;">Telefono: </td>
            <td style="width: 80%; border-bottom: 2px solid;">${paciente.telefonoPaciente}</td>
        </tr>

        <tr>
            <td style="font-weight: 800;">Direccion: </td>
            <td style="width: 80%; border-bottom: 2px solid;">${informeBiopsia.direccion}</td>
        </tr>

    </table>

</div>

<div style="display: inline-block; width: 45%">
    <table  style="line-height: 1.8">
        <tr>
            <td style="font-weight: 800;">Fecha: </td>
            <td style="width: 80%; border-bottom: 2px solid;">${biopsia.fechaFormateada}</td>
        </tr>

        <tr>
            <td style="font-weight: 800;">Edad: </td>
            <td style="width: 80%; border-bottom: 2px solid;">${paciente.edad}</td>
        </tr>

        <tr>
            <td></td>
        </tr>

        <tr>
            <td style="font-weight: 800;">Clinica: </td>
            <td style="width: 80%; border-bottom: 2px solid;">${informeBiopsia.clinica}</td>
        </tr>

        <tr>
            <td style="font-weight: 800;">Solicitante: </td>
            <td style="width: 80%; border-bottom: 2px solid;">${informeBiopsia.solicitante}</td>
        </tr>

    </table>

</div>

<div style="border: 1px solid; padding:15px; margin-top: 25px">
    <h3>Datos Clinicos:</h3>
    <p>${informeBiopsia.datosClinicos}</p>

    <h3>Descripcion Macroscopica:</h3>
    <p>${informeBiopsia.descMacros}</p>

    <h3>Descripcion Microscopica:</h3>
    <p>${informeBiopsia.descMirco}</p>

    <h3>Diagnostico:
        <c:forEach items="${diagnosticos}" var="diagnostico">
            <c:if test='${fn:contains(diagnosticoBiopsia, diagnostico.codigoDiagnostico)}'>
                ${diagnostico.nombreDiagnostico}
            </c:if>
        </c:forEach>
    </h3>
</div>
</body>

</html>