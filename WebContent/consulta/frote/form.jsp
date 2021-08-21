<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form id="frote-form">
    <fieldset id="frote-recibo" <c:if test='${not empty codFrote}'>disabled</c:if>>
        <table>
            <tr>
                <td><label for="numeroFrote">N&uacute;mero Frote:</label></td>
                <td><input id="numeroFrote" name="numeroFrote"  class="form-control" readonly value="${frote.numFrote}"></td>
                <td><label for="fechaFrote">Fecha Frote:</label></td>
                <td><input id="fechaFrote" name="fechaFrote" class="form-control" readonly value="${frote.fechaFormateada}"></td>
                <td><label for="estadoFrote">Estado:</label></td>
                <td><input id="estadoFrote" name="estadoFrote" class="form-control" readonly value="${frote.estadoFrote}"></td>
            </tr>
            <tr>
                <td><label class="table-form-label" for="numReciboFrote">N&uacute;mero Recibo:</label></td>
                <td><input type="number" id="numReciboFrote" name="numReciboFrote" class="form-control" value="${frote.numRecibo}"></td>

                <td><label class="table-form-label" for="serieReciboFrote">Serie Recibo:</label></td>
                <td><input type="text" id="serieReciboFrote" name="serieReciboFrote" class="form-control" value="${frote.serieRecibo}"></td>

                <td><label class="table-form-label" for="montoReciboFrote">Monto Recibo:</label></td>
                <td><input type="text" id="montoReciboFrote" name="montoReciboFrote" class="form-control" value="${frote.montoRecibo}"></td>
                <td>
                    <button id="validarReciboFrote" class="btn btn-light">Validar Recibo</button>
                </td>
            </tr>
        </table>
    </fieldset>

    <fieldset id="frote-datos" disabled="disabled">
        <table>
            <td><label class="table-form-label" for="tincionSelect">Tinci&oacute;n:</label></td>
            <td>
                <select  class="form-control" name="tincionSelect" id="tincionSelect">
                    <option value="">Selecciona una opci&oacute;n</option>
                    <c:forEach items="${tinciones}" var="tincion">
                        <option value="${tincion.codTincion}" <c:if test='${frote.codTincion == tincion.codTincion}'>selected</c:if>>${tincion.nombreTincion}</option>
                    </c:forEach>
                </select>
            </td>
        </table>

        <table>
            <tr>
                <td><label class="table-form-label" for="muestraEstudioFrote">Muestra o Estudio:</label></td>
                <td><input type="text" id="muestraEstudioFrote" name="muestraEstudioFrote" class="form-control" value="${frote.muestraEstudio}"></td>
            </tr>

            <tr>
                <td><label class="table-form-label" for="observacionesFrote">Observaciones:</label></td>
                <td><textArea id="observacionesFrote" name="observacionesFrote" class="form-control" cols="80" rows="5" style="height: 93px; ">${frote.observaciones}</textArea></td>
                <td colspan="2">
                    <ul id="froteImageContainer">
                        <c:forEach items="${examen.imagenes}" var="img" varStatus="loop">
                            <%--                                        <li><a href="${img}" target="_blank">image-${loop.index}</a></li>--%>
                        </c:forEach>
                    </ul>
                    <form id="upload-img-form-frote" action="UploadServlet.do" method="post" enctype="multipart/form-data">
                        <input type="file" id="file-frote" name="file1" multiple />
                        <br>
                        <input class="btn btn-light" type="submit" id="upload-button-frote" value="Subir Im&aacute;genes" />
                    </form>
                </td>
            </tr>

            <tr>
                <td>
                    <button class="btn btn-light" id="guardarDatosFrote">Guardar</button>
                </td>
            </tr>
        </table>
    </fieldset>
    <%@ include file="informe.jsp"%>
</form>