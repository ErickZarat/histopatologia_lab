<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form id="biopsia-form">
    <fieldset id="biopsia-recibo" <c:if test='${not empty codBiopsia}'>disabled</c:if>>
        <table>
            <tr>
                <td><label for="numeroBiopsia">Numero Biopsia:</label></td>
                <td><input id="numeroBiopsia" name="numeroBiopsia" class="form-control" readonly value="${biopsia.numBiopsia}"></td>
                <td><label for="fechaBiopsia">Fecha Biopsia:</label></td>
                <td><input id="fechaBiopsia" name="fechaBiopsia" class="form-control" readonly value="${biopsia.fechaFormateada}"></td>
                <td><label for="estadoBiopsia">Estado:</label></td>
                <td><input id="estadoBiopsia"  name="estadoBiopsia" class="form-control" readonly value="${biopsia.estadoBiopsia}"></td>
            </tr>
            <tr>
                <td><label class="table-form-label" for="numReciboBiopsia">Numero Recibo:</label></td>
                <td><input type="text" id="numReciboBiopsia" name="numReciboBiopsia" class="form-control" value="${biopsia.numRecibo}"></td>

                <td><label class="table-form-label" for="serieReciboBiopsia">Serie Recibo:</label></td>
                <td><input type="text" id="serieReciboBiopsia" name="serieReciboBiopsia" class="form-control" value="${biopsia.serieRecibo}"></td>

                <td><label class="table-form-label" for="montoReciboBiopsia">Monto Recibo:</label></td>
                <td><input type="text" id="montoReciboBiopsia" name="montoReciboBiopsia" class="form-control" value="${biopsia.montoRecibo}"></td>
                <td>
                    <button id="validarReciboBiopsia" class="btn btn-light">Validar Recibo</button>
                </td>
            </tr>
        </table>
    </fieldset>

    <fieldset id="biopsia-datos" disabled="disabled">
        <table>
            <td><label class="table-form-label" for="tipoProcedimientoSelect">Tipo Procedimiento:</label></td>
            <td>
                <select  class="form-control" name="tipoProcedimientoSelect" id="tipoProcedimientoSelect">
                    <option value="">Selecciona una opcion</option>
                    <c:forEach items="${tipoOpcion.PROCEDIMIENTO}" var="tipo">
                        <option value="${tipo.codigoOpcion}" <c:if test='${biopsia.procedimiento == tipo.codigoOpcion}'>selected</c:if>>${tipo.valor}</option>
                    </c:forEach>
                </select>
            </td>
            <td><label class="table-form-label" for="tipoCirugiaSelect">Tipo Cirugia:</label></td>
            <td>
                <select  class="form-control" name="tipoCirugiaSelect" id="tipoCirugiaSelect">
                    <option value="">Selecciona una opcion</option>
                    <c:forEach items="${tipoOpcion.TIPOCIRUGIA}" var="tipo">
                        <option value="${tipo.codigoOpcion}" <c:if test='${biopsia.tipoCirugia == tipo.codigoOpcion}'>selected</c:if>>${tipo.valor}</option>
                    </c:forEach>
                </select>
            </td>
            <td><label class="table-form-label" for="instrumentoSelect">Instrumento:</label></td>
            <td>
                <select  class="form-control" name="instrumentoSelect" id="instrumentoSelect">
                    <option value="">Selecciona una opcion</option>
                    <c:forEach items="${tipoOpcion.INSTRUMENTO}" var="tipo">
                        <option value="${tipo.codigoOpcion}" <c:if test='${biopsia.instrumento == tipo.codigoOpcion}'>selected</c:if>>${tipo.valor}</option>
                    </c:forEach>
                </select>
            </td>
        </table>

        <table>
            <tr>
                <td><label class="table-form-label" for="muestraEstudio">Muestra o Estudio:</label></td>
                <td><input type="text" id="muestraEstudio" name="muestraEstudio" class="form-control" value="${biopsia.muestraEstudio}"></td>
            </tr>

            <tr>
                <td><label class="table-form-label" for="observacionesBiopsia">Observaciones:</label></td>
                <td><textArea id="observacionesBiopsia" name="observacionesBiopsia" class="form-control" cols="56" rows="5">${biopsia.observaciones}</textArea></td>
                <td colspan="2">
                    <ul id="biopsiaImageContainer">
                        <c:forEach items="${examen.imagenes}" var="img" varStatus="loop">
                            <%--                                        <li><a href="${img}" target="_blank">image-${loop.index}</a></li>--%>
                        </c:forEach>
                    </ul>
                    <form id="upload-img-form-biopsia" action="UploadServlet.do" method="post" enctype="multipart/form-data">
                        <input type="file" id="file-biopsia" name="file1" multiple />
                        <br>
                        <input class="btn btn-light" type="submit" id="upload-button-biopsia" value="Subir imagenes" />
                    </form>
                </td>
            </tr>

            <tr>
                <td>
                    <button class="btn btn-light" id="guardarDatosBiopsia">Guardar</button>
                </td>
            </tr>
        </table>
    </fieldset>
    <%@ include file="informe.jsp"%>
</form>