<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../partials/head.jsp"%>
<%@ include file="../partials/header.jsp"%>


<div class="container-fluid">

    <div>
        <h1 class="main-tittle">Reportes</h1>


        <div class="search-container">
            <form class="align-middle" target="_blank" action="ReporteServlet.do" method="get">
                <input type="hidden" value="DESCARGAR_INFORME" name="accion">
                <table>
                    <tr>
                        <td><label for="tipo" class="col-sm-4 col-form-label">Tipo Reporte:</label></td>
                        <td>
                            <select  class="form-control" name="tipo" id="tipo">
                                <option value="0">Selecciona una Opci&oacute;n</option>
                                <option value="examen"">Reporte Detallado de Ex&aacute;menes</option>
                                <option value="biopsia">Reporte Detallado de Biopsias</option>
                                <option value="frote">Reporte Detallado de Frotes</option>

                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td><label for="from" class="col-sm-4 col-form-label"> Fecha Desde:</label></td>
                        <td>
                            <input class="form-control" type="date" name="from" id="from">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="to" class="col-sm-4 col-form-label">Fecha Hasta:</label></td>
                        <td>
                            <input class="form-control" type="date" name="to" id="to">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <input class="btn btn-light" type="submit" value="Descargar">
                        </td>
                    </tr>

                </table>
            </form>
        </div>

    </div>
</div>

<%@include file="../partials/footer.jsp"%>

