<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/EstilosViews.css">
    <title>PetmarketLogin</title>
</head>
<body>
    <div class="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-5 mx-auto">
        <div class="card card0 border-0">
            <div class="row d-flex">
                <div class="col-lg-6">
                    <div class="card1 pb-5">
                        <div class="row">
                            <img src="assets/img/logo.jpg" class="logo" style="height: 50px; width: 90px;">
                        </div>
                        <div class="row px-3 justify-content-center mt-4 mb-5 border-line">
                            <img src="assets/img/login.png" class="image">
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div style="margin-top: 30px" class="card2 card border-0 px-4 py-5">
                        <div class="row mb-4 px-3">
                            <div class="line"></div>
                        </div>
                        <form action="login" method="post">
                        <div class="row px-3">
                            <label class="mb-1"><h6 class="mb-0 text-sm">Usuario</h6></label>
                            <input class="mb-4" type="text" name="username" id="username" placeholder="Ingrese su Usuario" required>
                        </div>
                        <div class="row px-3">
                            <label class="mb-1"><h6 class="mb-0 text-sm">Constraseña</h6></label>
                            <input type="password" name="password" id="password" placeholder="Ingrese su Constraseña" required>
                        </div>
                        <div class="row px-3 mb-4">
                            <a href="https://api.whatsapp.com/send?phone=3223369601" class="ml-auto mb-0 text-sm">Olvido su contraseña?</a>
                        </div>
                        <div class="row mb-3 px-3">
                           <a><button type="submit" style="background-color: #17A2B8; color: black;" class="btn btn-blue text-center">Ingresar</button></a>
                        </div>
                    </div>
                </div>
            </div>
        </form>
            <div style="background-color: #17A2B8; color: black;" class="bg-blue py-4">
                <div class="row px-3">
                   <small class="ml-4 ml-sm-5 mb-2">COMPAÑIA PETMARKET</small>
                    <div class="social-contact ml-4 ml-sm-auto">
                        <a href="https://www.facebook.com/petmarketveterinaria"><span class="fa fa-facebook mr-4 text-sm"></span></a>
                        <a href="https://twitter.com/onepetmascotas"><span class="fa fa-twitter mr-4 mr-sm-5 text-sm"></span></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

