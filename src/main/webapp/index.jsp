<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/EstilosViews.css">
    <title>indexPetmarket</title>
</head>

<body style="background-color: #ffffff">

    <header id="header">
        <div class="container__header">
            <div class="logo">
                <img src="assets/img/logo.jpg" alt="">
            </div>
            <div class="container__nav">
                <nav>
                    <ul>
                        <li><a href="cliente?action=index" class="select">Inicio</a></li>
                        <li><a href="semana?accion=consultar">Semana</a></li>
                        <li><a href="cita?accion=consultar">Consultar Cita</a></li>
                        <li><a href="cliente?action=consultar">Cliente</a></li>
                        <li><a href="<%=request.getContextPath()%>/logout">Cerrar Sesion</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </header>

    <div class="container__all">
        <div class="cover">
            <div class="container__cover">
                <div class="container__info">
                    <h1>Bienvenido</h1>
                    <h2>Recepcionista <%= session.getAttribute("userName") %></h2> 
                    <p>Bienvenido a Petmarket Aqui puedes agendar las diferentes citas solicitadas,pidiendole
                        al usuario sus datos,datos de la cita y los diferentes datos de la mascota</p>
                    <a href="semana?accion=consultar"><input type="button" value="Consultar Semana"></a>
                </div>
                <div class="container__vector">
                    <img src="assets/img/vector.jpg" alt="">
                </div> 
            </div>
        </div>
    </div>


    <script src="assets/Js/sweetAlert.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</body>
</html>
