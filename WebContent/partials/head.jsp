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
    <link rel="stylesheet" href="assets/css/toastr.min.css">
    <link rel="stylesheet" href="assets/css/custom.css">
    <link rel="stylesheet" href="assets/css/cdnjs/bootstrap-datepicker3.min.css">
    <link rel="stylesheet" href="assets/css/messenger/messenger.css">
	<link rel="stylesheet" href="assets/css/messenger/messenger-theme-air.css" >
	<link rel="stylesheet" href="assets/css/messenger/messenger-theme-flat.css" >
	<link rel="stylesheet" href="assets/css/messenger/messenger-theme-future.css" >
	<link rel="stylesheet" href="assets/css/select2.min.css" >

    <style>
    @media screen and (min-width: 676px) {
        .modal-dialog {
          max-width: 550px; /* New width for default modal */
        }
    }
</style>
    

    <title>${titulo}</title>
</head>
