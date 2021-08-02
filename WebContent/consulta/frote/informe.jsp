<fieldset id="frote-informe" <c:if test='${frote.estadoFrote != "Pendiente Informe Frote"}'>disabled</c:if>>
    <hr>
    <table>
        <tr>
            <td>
                <h4>Informe</h4>
            </td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="clinicaFrote">Clinica:</label></td>
            <td><input type="text" id="clinicaFrote" class="form-control" value="${informeFrote.clinica}"></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="direccionFrote">Direccion:</label></td>
            <td><input type="text" id="direccionFrote" class="form-control" value="${informeFrote.direccion}"></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="solicitanteFrote">Solicitante:</label></td>
            <td><input type="text" id="solicitanteFrote" class="form-control" value="${informeFrote.solicitante}"></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="datosClinicosFrote">Datos clinicos:</label></td>
            <td><textArea id="datosClinicosFrote" class="form-control" cols="80" rows="5">${informeFrote.datosClinicos}</textArea></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="descMicroFrote">Descripcion microscopica:</label></td>
            <td><textArea id="descMicroFrote" class="form-control" cols="80" rows="5">${informeFrote.descMirco}</textArea></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="descMacroFrote">Descripcion macroscopica:</label></td>
            <td><textArea id="descMacroFrote" class="form-control" cols="80" rows="5">${informeFrote.descMacros}</textArea></td>
        </tr>
        <tr>
            <td>
                <label class="table-form-label" for="diagnosticoFrote">Diagnostico:</label>
            </td>
            <td colspan="2">
                <select multiple class="form-control select2" name="diagnosticoFrote" id="diagnosticoFrote">
                    <option value="">Selecciona una opcion</option>
                    <c:forEach items="${diagnosticos}" var="diagnostico">
                        <option value="${diagnostico.codigoDiagnostico}"
                                <c:if test='${fn:contains(diagnosticoFrote, diagnostico.codigoDiagnostico)}'>selected</c:if>
                        >${diagnostico.nombreDiagnostico}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <button id="guardarInformeFrote" class="btn btn-light">Guardar</button>
                <a id="descargarInformeFrote" href="ConsultaServlet.do?accion=DESCARGAR_INFORME&tipo=frote&codExamen=${codExamen}" class="btn btn-light">Descargar</a>
            </td>
        </tr>
    </table>
</fieldset>