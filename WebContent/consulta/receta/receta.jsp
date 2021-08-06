<fieldset id="receta-form">
    <hr>
    <table>
        <tr>
            <td><label for="tipoMedicamentoSearch">Tipo medicamento:</label></td>
            <td>
                <select  class="form-control" name="tipoMedicamentoSelect" id="tipoMedicamentoSearch">
                    <option value="0">Selecciona una opcion</option>
                    <c:forEach items="${tiposMedicamento}" var="tipo">
                        <option value="${tipo.codigo}">${tipo.nombre}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <label class="table-form-label" for="medicamentoSelect">Medicamento:</label>
            </td>
            <td colspan="2">
                <select class="form-control select2" name="medicamentoSelect" id="medicamentoSelect">
                    <option value="">Selecciona una opcion</option>
                    <c:forEach items="${medicamentos}" var="medicamento">
                        <option value="${medicamento.codigoMedicamento}">
                                ${medicamento.nombreMedicamento}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td>
                <label class="table-form-label" for="presentacionSelect">Presentacion:</label>
            </td>
            <td colspan="2">
                <select class="form-control select2" name="presentacionSelect" id="presentacionSelect">
                    <option value="">Selecciona una opcion</option>
                    <c:forEach items="${presentaciones}" var="presentacion">
                        <option value="${presentacion.codPresentacion}">
                                ${presentacion.tipoPresentacion}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td><label class="table-form-label" for="notasReceta">Notas:</label></td>
            <td><textArea id="notasReceta" class="form-control" cols="80" rows="5"></textArea></td>
        </tr>

        <tr>
            <td>
                <button id="agregarReceta" class="btn btn-light">agregar</button>
            </td>
        </tr>
        <tr>
            <br>
        </tr>
        <tr>
            <td>
                <button id="guardarReceta" class="btn btn-light">Guardar</button>
                <a id="descargarReceta" href="ConsultaServlet.do?accion=DESCARGAR_INFORME&tipo=receta&codExamen=${codExamen}" class="btn btn-light">Descargar</a>
            </td>
        </tr>
    </table>
</fieldset>