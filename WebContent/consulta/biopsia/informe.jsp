<fieldset id="biopsia-informe" <c:if test='${biopsia.estadoBiopsia != "Pendiente Informe Biopsa"}'>disabled</c:if>>
    <hr>
    <table>
        <tr>
            <td>
                <h4>Informe</h4>
            </td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="clinicaBiopsia">Clinica:</label></td>
            <td><input type="text" id="clinicaBiopsia" class="form-control" value="${informeBiopsia.clinica}"></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="direccionBiopsia">Direccion:</label></td>
            <td><input type="text" id="direccionBiopsia" class="form-control" value="${informeBiopsia.direccion}"></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="solicitanteBiopsia">Solicitante:</label></td>
            <td><input type="text" id="solicitanteBiopsia" class="form-control" value="${informeBiopsia.solicitante}"></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="datosClinicosBiopsia">Datos clinicos:</label></td>
            <td><textArea id="datosClinicosBiopsia" class="form-control" cols="80" rows="5">${informeBiopsia.datosClinicos}</textArea></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="descMicroBiopsia">Descripcion microscopica:</label></td>
            <td><textArea id="descMicroBiopsia" class="form-control" cols="80" rows="5">${informeBiopsia.descMirco}</textArea></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="descMacroBiopsia">Descripcion macroscopica:</label></td>
            <td><textArea id="descMacroBiopsia" class="form-control" cols="80" rows="5">${informeBiopsia.descMacros}</textArea></td>
        </tr>
        <tr>
            <td>
                <label class="table-form-label" for="diagnosticoBiopsia">Diagnostico:</label>
            </td>
            <td colspan="2">
                <select class="form-control select2" name="diagnosticoBiopsia" id="diagnosticoBiopsia">
                    <option value="">Selecciona una opcion</option>
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
                <a id="descargarInformeBiopsia" href="ConsultaServlet.do?accion=DESCARGAR_INFORME&tipo=biopsia&codExamen=${codExamen}" class="btn btn-light">Descargar</a>
            </td>
        </tr>
    </table>
</fieldset>