<div>
    <table class="table table-striped w-75 left-margin-align" id="seguimientosTable">
        <thead class="table thead-light">
        <tr style="font-weight: bold;">
            <td>Fecha</td>
            <td>Observaciones</td>
            <td>Notas</td>
            <td></td>
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
                        <td><textArea id="observacionesSeguimiento" class="form-control" cols="80" rows="5"></textArea></td>
                    </tr>                    

                    <tr>
                        <td><label class="table-form-label" for="adicionelesSeguimiento">Notas Adicionales:</label></td>
                        <td><textArea id="adicionelesSeguimiento" class="form-control" cols="80" rows="5"></textArea></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td style="float: right">
                            <button id="agregarSeguimiento" class="btn btn-light">Agregar</button>
                        </td>
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