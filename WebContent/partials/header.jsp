<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>

<nav class="navbar navbar-expand-lg navbar-dark custom-navbar">

    <ul class="navbar-nav">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMantenimientos" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Mantenimientos
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdownMantenimientos">
                <a class="dropdown-item" href="MedicamentosServlet.do">Medicamentos</a>
                <a class="dropdown-item" href="EnfSistemicaServlet.do">Enfermedades Sistemicas</a>
                <a class="dropdown-item" href="OpcionLesionServlet.do">Tipos de Opcion Lesion</a>
                <a class="dropdown-item" href="UsuarioServlet.do">Usuarios</a>
                <a class="dropdown-item" href="PacienteServlet.do">Pacientes</a>
            </div>
        </li>

        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownConsultas" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Consultas
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdownConsultas">
                <a class="dropdown-item" href="#">Consulta 1</a>
                <a class="dropdown-item" href="#">Consulta 2</a>
                <a class="dropdown-item" href="#">Consulta 3</a>
            </div>
        </li>

    </ul>
    <a class="navbar-brand" href="#">Sistema Laboratorio Histopatología</a>

    <ul class="navbar-nav">

        <li class="nav-item dropdown">

            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <ul class="user-nav">
                    <li>${username}</li>
                    <li id="currentDate"></li>
                </ul>
                <img src="assets/img/user.png" width="40" height="40" class="rounded-circle">
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                <a class="dropdown-item" href="#">Dashboard</a>
                <a class="dropdown-item" href="#">Edit Profile</a>
                <a class="dropdown-item" href="#">Log Out</a>
            </div>
        </li>
    </ul>
</nav>