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
                        <li><a href="usuario?accion=index" class="select">Inicio</a></li>
                        <li><a href="usuario?accion=ingresar">Registar Usuario</a></li>
                        <li><a href="usuario?accion=consultar">Consultar usuarios</a></li>
                        <li><a href="cita?accion=consultara">Consultar Cita</a></li>
                        <li><a href="cliente?action=consultara">Consultar Cliente</a></li>
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
                    <h2>Administrador</h2>
                    <p>Bienvenido a Petmarket Aqui puedes revisar,agregar o eliminar a un usuario o si quieres
                        tambien puedes consultar las citas programadas por la compañia</p>
                    <a href="usuario?action=ingresar"><input type="button" value="Consultar Citas"></a>
                    <a href="usuario?action=ingresar"><input type="button" value="Consultar usuarios"></a>
                </div>
                <div class="container__vector">
                    <img src="assets/img/vector.jpg" alt="">
                </div> 
            </div>
        </div>
    </div>
</body>
</html>
