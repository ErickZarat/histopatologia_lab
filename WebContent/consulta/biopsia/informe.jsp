<fieldset id="biopsia-informe" disabled>
    <table>
        <tr>
            <td><label class="table-form-label" for="clinicaBiopsia">Clinica:</label></td>
            <td><input type="text" id="clinicaBiopsia" class="form-control"></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="direccionBiopsia">Direccion:</label></td>
            <td><input type="text" id="direccionBiopsia" class="form-control"></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="solicitanteBiopsia">Solicitante:</label></td>
            <td><input type="text" id="solicitanteBiopsia" class="form-control"></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="datosClinicosBiopsia">Datos clinicos:</label></td>
            <td><textArea id="datosClinicosBiopsia" class="form-control" cols="56" rows="5"></textArea></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="descMicroBiopsia">Descripcion micoscopica:</label></td>
            <td><textArea id="descMicroBiopsia" class="form-control" cols="56" rows="5"></textArea></td>
        </tr>
        <tr>
            <td><label class="table-form-label" for="descMacroBiopsia">Descripcion macroscopica:</label></td>
            <td><textArea id="descMacroBiopsia" class="form-control" cols="56" rows="5"></textArea></td>
        </tr>
        <tr>
            <td>
                <label class="table-form-label" for="diagnosticoBiopsia">Diagnostico:</label>
            </td>
            <td colspan="2">
                <select multiple class="form-control select2" name="diagnosticoBiopsia" id="diagnosticoBiopsia">
                    <option value="">Selecciona una opcion</option>
                    <c:forEach items="${diagnosticos}" var="diagnostico">
                        <option value="${diagnostico.codigoDiagnostico}"
<%--                                <c:if test='${fn:contains(biopsiaDiagnosticos, diagnostico.codigoDiagnostico)}'>selected</c:if>--%>
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
</fieldset>