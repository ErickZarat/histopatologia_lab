<div>
    <table class="table table-striped w-50 left-margin-align" id="seguimientosTable">
        <thead class="table thead-light">
        <tr style="font-weight: bold;">
            <td style="width: 40px;">Fecha</td>
            <td style="width: 300px;">Observaciones</td>
            <td style="width: 200px;">Notas</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${seguimientos}" var="seguimiento">
            <tr>
                <td><label class="text-capitalize">${seguimiento.fechaCreacion}</label></td>
                <td><label class="text-capitalize">${seguimiento.Observaciones}</label></td>
                <td><label class="text-capitalize">${seguimiento.observacionesAdicionales}</label></td>
                <td></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div>
        <form id="seguimientos-form">
            <fieldset id="seguimiento-form">
                <hr>
                <table>                   
                    <tr>
                        <td><label class="table-form-label" for="observacionesSeguimiento">Observaciones:</label></td>
                        <td><textArea id="observacionesSeguimiento"   name="observacionesSeguimiento" class="form-control" cols="80" rows="5"></textArea></td>
                    </tr>                    

                    <tr>
                        <td><label class="table-form-label" for="adicionelesSeguimiento">Notas Adicionales:</label></td>
                        <td><textArea id="adicionelesSeguimiento" name="adicionelesSeguimiento" class="form-control" cols="80" rows="5"></textArea></td>
                    </tr>
                    <tr>
                        <br>
                    </tr>
                </table>
            </fieldset>
            <div>
                <button id="guardarSeguimiento" class="btn btn-light">Guardar</button>
                <a id="descargarSeguimiento" href="ConsultaServlet.do?accion=DESCARGAR_INFORME&tipo=receta&codExamen=${codExamen}" class="btn btn-light">Descargar</a>
            </div>
        </form>
    </div>
    <div>

    </div>
</div>