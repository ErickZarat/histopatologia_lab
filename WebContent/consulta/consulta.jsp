<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../partials/head.jsp"%>
<%@ include file="../partials/header.jsp"%>


<div class="container-fluid">

    <div>
        <h1 class="main-tittle">Consultas</h1>

        <div class="search-container">
            <form class="align-middle" action="ConsultaServlet.do" method="post">

                <table>
                    <tr>
                        <td><label for="numeroConsulta" class="col-sm-4 col-form-label">Numero Consulta:</label></td>
                        <td><input type="text" id="numeroConsulta" name="numeroConsulta" class="form-control"></td>
                    </tr>
                    <tr>
                        <td><label for="fechaConsulta" class="col-sm-4 col-form-label">Fecha Consulta:</label></td>
                        <td><input type="text" id="fechaConsulta" name="fechaConsulta" class="form-control"></td>
                    </tr>
                    <tr>
                        <td><label for="estadoConsulta" class="col-sm-4 col-form-label">Estado Consulta:</label></td>
                        <td><input type="text" id="estadoConsulta" name="estadoConsulta" class="form-control"></td>
                    </tr>
                    <tr>
                        <td><label for="doctor" class="col-sm-4 col-form-label">Doctor:</label></td>
                        <td><input type="text" id="doctor" name="doctor" class="form-control"></td>
                    </tr>
                    <tr>
                        <td><label for="paciente" class="col-sm-4 col-form-label">Paciente:</label></td>
                        <td><input type="text" id="paciente" name="paciente" class="form-control"></td>
                        <td><button class="btn btn-light">Buscar</button></td>
                    </tr>
                </table>
            </form>
        </div>

        <div class="action-container left-padding-align">
            <a href="ConsultaServlet.do?accion=CREAR" class="btn btn-light">Nueva <i class="fas fa-plus"></i></a>
        </div>

        <table class="table table-striped w-75 left-margin-align" id="consultasTable">
            <thead class="table thead-light">
                <tr style="font-weight: bold;">
                    <td>Numero Consulta</td>
                    <td>Fecha Consulta</td>
                    <td>Estado</td>
                    <td>Doctor</td>
                    <td>Paciente</td>
                    <td></td>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>
</div>


<%@include file="../partials/footer.jsp"%>
<script src="assets/js/consulta/consulta.js"></script>

