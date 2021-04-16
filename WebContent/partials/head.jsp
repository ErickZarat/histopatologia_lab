<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty titulo}" >
    <c:set var="titulo" value="Inicio Laboratorio Histopatologia" />
</c:if>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="assets/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/font-awesome/css/all.min.css">
    <link rel="stylesheet" href="assets/css/custom.css">

    <title>${titulo}</title>
</head>
