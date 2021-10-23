<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="partials/head.jsp"%>
<%@ include file="partials/header-index.jsp"%>

  <div class="container login-container">
    <form class="align-middle" method="post" action="LoginServlet.do">
      <div class="form-group row">
        <label for="usuario" class="col-sm-4 col-form-label">Usuario</label>
        <div class="col-sm-8">
          <input type="text" class="form-control" id="usuario" name="usuario">
        </div>
      </div>
      <div class="form-group row">
        <label for="password" class="col-sm-4 col-form-label">Password</label>
        <div class="col-sm-8">
          <input type="password" class="form-control" id="password" name="password">
        </div>
      </div>

      <div class="form-group row">
        <div class="col-sm-4"></div>
        <div class="col-sm-8">
          <button type="submit" class="btn btn-light">Ingresar</button>
        </div>
      </div>
    </form>
  </div>


<img src="assets/img/logo.png" class="fondo-logo" >

<%@include file="partials/footer.jsp"%>


