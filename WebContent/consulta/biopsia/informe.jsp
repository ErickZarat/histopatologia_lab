<fieldset id="biopsia-informe" <c:if test='${biopsia.estadoBiopsia != "Pendiente Informe Biopsa"}'>disabled</c:if>>
 <form id="informeBiopsia-form">
    <hr>
    <table>
        <tr>
            <td colspan = "2">
                 <h5 class="main-tittle">Informe Histopatol&oacute;gico</h5>
            </td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="clinicaBiopsia">Cl&iacute;nica:</label></td>
            <td><input type="text" id="clinicaBiopsia" name="clinicaBiopsia" class="form-control" value="${informeBiopsia.clinica}"></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="direccionBiopsia">Direcci&oacute;n:</label></td>
            <td><input type="text" id="direccionBiopsia" name="direccionBiopsia" class="form-control" value="${informeBiopsia.direccion}"></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="solicitanteBiopsia">Solicitante:</label></td>
            <td><input type="text" id="solicitanteBiopsia" name="solicitanteBiopsia" class="form-control" value="${informeBiopsia.solicitante}"></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="datosClinicosBiopsia">Datos Cl&iacute;nicos:</label></td>
            <td><textArea id="datosClinicosBiopsia" name="datosClinicosBiopsia" class="form-control" cols="80" rows="5">${informeBiopsia.datosClinicos}</textArea></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="descMicroBiopsia">Descripci&oacute;n Microsc&oacute;pica:</label></td>
            <td><textArea id="descMicroBiopsia" name="descMicroBiopsia" class="form-control" cols="80" rows="5">${informeBiopsia.descMirco}</textArea></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="descMacroBiopsia">Descripci&oacute;n Macrosc&oacute;pica:</label></td>
            <td><textArea id="descMacroBiopsia" name="descMacroBiopsia" class="form-control" cols="80" rows="5">${informeBiopsia.descMacros}</textArea></td>
        </tr>
         <tr>
            <td><label class="table-form-label" for="obsInformeBiopsia">Observaciones Adicionales:</label></td>
            <td><textArea id="obsInformeBiopsia" name ="obsInformeBiopsia" class="form-control" cols="80" rows="5" style="height: 81px; ">${informeBiopsia.observaciones}</textArea></td>
        </tr>       
        
        <tr>
            <td>
                <label class="table-form-label" for="diagnosticoBiopsia">Diagn&oacute;stico:</label>
            </td>
            <td colspan="2">
                <select class="form-control select2" name="diagnosticoBiopsia" id="diagnosticoBiopsia">
                    <option value="">Selecciona una opción</option>
                    <c:forEach items="${diagnosticos}" var="diagnostico">
                        <option value="${diagnostico.codigoDiagnostico}"
                                <c:if test='${diagnosticoBiopsia == diagnostico.codigoDiagnostico}'>selected</c:if>
                        >${diagnostico.nombreDiagnostico}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <button id="guardarInformeBiopsia" class="btn btn-light">Guardar</button>
            </td>
        </tr>
    </table>
    </form>
</fieldset>
<a id="descargarInformeBiopsia" href="ConsultaServlet.do?accion=DESCARGAR_INFORME&tipo=biopsia&codExamen=${codExamen}" class="btn btn-light">Descargar Informe</a>