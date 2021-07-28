<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form>
    <fieldset id="frote-recibo">
        <table style="margin: 2%; margin-left: 0;">
            <tr>
                <td><label class="table-form-label" for="numReciboFrote">Numero Recibo:</label></td>
                <td><input type="text" id="numReciboFrote" class="form-control"></td>

                <td><label class="table-form-label" for="serieReciboFrote">Serie Recibo:</label></td>
                <td><input type="text" id="serieReciboFrote" class="form-control"></td>

                <td><label class="table-form-label" for="montoReciboFrote">Monto Recibo:</label></td>
                <td><input type="text" id="montoReciboFrote" class="form-control"></td>
                <td>
                    <button class="btn btn-light">Validar Recibo</button>
                </td>
            </tr>
        </table>
    </fieldset>
    <fieldset id="frote-datos" disabled="disabled">
        <table>
            <tr>
                <td><label class="table-form-label" for="muestraEstudioFrote">Muestra o Estudio:</label></td>
                <td><input type="text" id="muestraEstudioFrote" class="form-control"></td>
                <td></td>
            </tr>

            <tr>
                <td><label class="table-form-label" for="observacionesFrote">Observaciones:</label></td>
                <td><textArea id="observacionesFrote" class="form-control"  cols="56" rows="5"></textArea></td>

                <td colspan="2">
                    <ul id="froteImageContainerfrote">
                        <c:forEach items="${examen.imagenes}" var="img" varStatus="loop">
                            <%--                                        <li><a href="${img}" target="_blank">image-${loop.index}</a></li>--%>
                        </c:forEach>
                    </ul>
                    <form id="upload-img-form-frote" action="UploadServlet.do" method="post" enctype="multipart/form-data">
                        <input type="file" id="file-frote" name="file1" multiple />
                        <br>
                        <input class="btn btn-light" type="submit" id="upload-button-frote" value="Subir imagenes" />
                    </form>
                </td>
            </tr>

            <tr>
                <td>
                    <button class="btn btn-light">Guardar</button>
                </td>
            </tr>
        </table>
    </fieldset>
</form>