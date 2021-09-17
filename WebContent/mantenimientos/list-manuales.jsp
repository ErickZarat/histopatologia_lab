<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../partials/head.jsp"%>
<%@ include file="../partials/header.jsp"%>


<div class="container-fluid">

    <div>
        <h1 class="main-tittle">Manuales</h1>
        <div class="action-container left-padding-align">
          <br>
        </div>

          <br>
        <table class="table table-striped w-25 left-margin-align" id="manualesTable">
            <thead class="table thead-light">
            <tr style="font-weight: bold;">
                <td> Manual </td>
                <td >Acci&oacute;n</td>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td><p class="font-weight-normal">Manual de Cat&aacute;logos</p></td>
                    <td> 
                    <a href="assets/files/manual_catalogos.pdf" target="_blank">Visualizar</a>
                     <i class="fas fa-file-pdf"></i>
                    </td>                    
                </tr>
                <tr>
                    <td><p class="font-weight-normal">Manual de Consultas o Ex&aacute;menes</p></td>
                    <td><a href="assets/files/manual_proceso_consultas.pdf" target="_blank">Visualizar</a>
                     	 <i class="fas fa-file-pdf"></i>
                    </td>                    
                </tr>
                <tr>
                    <td><p class="font-weight-normal">Manual de Reportes</p></td>
                    <td><a href="assets/files/proceso_consultas.pdf" target="_blank">Visualizar</a>
                        <i class="fas fa-file-pdf"></i>
                    </td>                    
                </tr>                                
            </tbody>
        </table>
    </div>

</div>






<%@include file="../partials/footer.jsp"%>


