<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body onload="window.print()" style="line-height: 1.8">
    <div>
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
            <table  style="line-height: 1.2">
                <tr>
                    <td style="font-weight: 800;">Paciente: </td>
                    <td style="width: 80%; border-bottom: 2px solid;">${paciente.nombrePaciente} ${paciente.apellidosPaciente}</td>
                </tr>

                <tr>
                    <td style="font-weight: 800;">Telefono: </td>
                    <td style="width: 80%; border-bottom: 2px solid;">${paciente.telefonoPaciente}</td>
                </tr>

            </table>
        </div>

        <div style="display: inline-block; width: 45%"></div>
        <style>#items div:last-child hr{display: none;}</style>
        <div id="items" style="border: 1px solid; padding:15px; margin-top: 25px">
            <c:forEach items="${recetas}" var="receta">
                <div>
                    <label><strong>Farmaco:</strong></label>
                    ${receta.nombreMedicamento} - ${receta.presentacion}

                    <label><strong>Indicaciones:</strong></label>
                    ${receta.notas}
                    <hr>
                </div>
            </c:forEach>
        </div>
        <div style="text-align: center;">
            <div style="height: 125px; width: 1px;"></div>
            <div style="vertical-align: bottom; display: inline-block;text-align: center; font-weight: 800;">
                <div>Dr. ${doc.nombresDoctor} ${doc.apellidosDoctor}</div>
                <div>Colegiado. ${doc.numColegiado}</div>
            </div>
        </div>

    </div>
</body>

</html>