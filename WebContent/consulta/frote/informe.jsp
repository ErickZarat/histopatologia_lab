<fieldset id="frote-informe" <c:if test='${frote.estadoFrote != "Pendiente Informe Frote"}'>disabled</c:if>>
 <form id="informeFrote-form">
    <hr>
    <table>
        <tr>
            <td colspan = "2">
                <h5 class="main-tittle">Informe Histopatol&oacute;gico</h5>
            </td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="clinicaFrote">Cl&iacute;nica:</label></td>
            <td><input type="text" id="clinicaFrote" name="clinicaFrote" class="form-control" value="${informeFrote.clinica}"></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="direccionFrote">Direcci&oacute;n:</label></td>
            <td><input type="text" id="direccionFrote" name="direccionFrote" class="form-control" value="${informeFrote.direccion}"></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="solicitanteFrote">Solicitante:</label></td>
            <td><input type="text" id="solicitanteFrote" name="solicitanteFrote" class="form-control" value="${informeFrote.solicitante}"></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="datosClinicosFrote">Datos Cl&iacute;nicos:</label></td>
            <td><textArea id="datosClinicosFrote" name="datosClinicosFrote" class="form-control" cols="80" rows="5">${informeFrote.datosClinicos}</textArea></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="descMicroFrote">Descripci&oacute;n Microsc&oacute;pica:</label></td>
            <td><textArea id="descMicroFrote" name="descMicroFrote" class="form-control" cols="80" rows="5">${informeFrote.descMirco}</textArea></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="descMacroFrote">Descripci&oacute;n Macrosc&oacute;pica:</label></td>
            <td><textArea id="descMacroFrote" name="descMacroFrote" class="form-control" cols="80" rows="5">${informeFrote.descMacros}</textArea></td>
        </tr>
 		<tr>
            <td><label class="table-form-label" for="obsInformeBiopsia">Observaciones Adicionales:</label></td>
            <td><textArea id="obsInformeFrote" name ="obsInformeFrote" class="form-control" cols="80" rows="5" style="height: 81px; ">${informeFrote.observaciones}</textArea></td>
        </tr>               
        
        <tr>
            <td>
                <label class="table-form-label" for="diagnosticoFrote">Diagn&oacute;stico:</label>
            </td>
            <td colspan="2">
                <select class="form-control select2" name="diagnosticoFrote" id="diagnosticoFrote">
                    <option value="">Selecciona una opción</option>
                    <c:forEach items="${diagnosticos}" var="diagnostico">
                        <option value="${diagnostico.codigoDiagnostico}"
                                <c:if test='${diagnosticoFrote == diagnostico.codigoDiagnostico}'>selected</c:if>
                        >${diagnostico.nombreDiagnostico}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <button id="guardarInformeFrote" class="btn btn-light">Guardar</button>
            </td>
        </tr>
    </table>
</form>    
</fieldset>
<a id="descargarInformeFrote" href="ConsultaServlet.do?accion=DESCARGAR_INFORME&tipo=frote&codExamen=${codExamen}" class="btn btn-light">Descargar Informe</a>