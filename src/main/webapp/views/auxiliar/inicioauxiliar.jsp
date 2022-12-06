<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                        <li><a href="usuario?action=indexs" class="select">Inicio</a></li>
                        <li><a href="cita?accion=consultarr" >Consultar Cita</a></li>
                        <li><a href="<%=request.getContextPath()%>/logout">Cerrar Sesion</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </header>

    <div class="container__all">
        <div class="cover" style="margin-top: 0%;">
            <div class="container__cover" >
                <div class="container__info">
                    <h1>Bienvenido</h1>
                    <h2>Auxiliar <%= session.getAttribute("userName") %></h2> 
                    <p>Bienvenido a Petmarket Aqui puedes revisar las citas programadas por la compañia</p>
                    <a href="cita?accion=consultarr"><input type="button" value="Consultar Citas"></a>
                </div>
                <div class="container__vector">
                    <img src="assets/img/vector.jpg" alt="">
                </div> 
            </div>
        </div>
    </div>
</body>
</html>
