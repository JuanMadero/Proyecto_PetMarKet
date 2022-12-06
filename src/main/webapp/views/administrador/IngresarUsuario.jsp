<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="assets/css/EstilosViews.css">
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/css/bootstrap.min.css"
        integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
      <title>IngresarCita</title>
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
                <li><a href="usuario?accion=index">Inicio</a></li>
                <li><a href="usuario?accion=ingresar" class="select">Registar Usuario</a></li>
                <li><a href="usuario?accion=consultar">Consultar usuarios</a></li>
                <li><a href="cita?accion=consultara">Consultar Cita</a></li>
                <li><a href="cliente?action=consultara">Consultar Cliente</a></li>
                <li><a href="<%=request.getContextPath()%>/logout">Cerrar Sesion</a></li>
            </ul>
            </nav>
          </div>
        </div>
      </header>

      <section>
        <div class="m-0 row justify-content-center">
          <div class="col-sm-7 p-5">
            <div class="card">
              <div class="card-header" style="background-color:#17A2B8; color: rgb(255, 255, 255);text-align: center;">
                <b>Registrar usuario</b>
              </div>
              <form action="usuario" method="post">
                <div class="card-body">
                  <div class="container-fluid px-6">
                    <div class="row">
                      <div class="col-sm-6">
                        <label for="">Usuario</label>
                        <input type="text" class="form-control" placeholder="Nombre" aria-label="First name"
                          name="usuario">
                      </div>
                      <div class="col-sm-6">
                        <label for="">Contraseña Usuario</label>
                        <input type="password" class="form-control" placeholder="Nombre" aria-label="First name"
                          name="password">
                      </div>
                      <div class="col-sm-6">
                        <label for="">vuelve a ingresar Contraseña </label>
                        <input type="password" class="form-control" placeholder="Nombre" aria-label="First name">
                      </div>
                      <div class="col-sm-6">
                        <label for="">Nombre Usuario</label>
                        <input type="text" class="form-control" placeholder="Nombre" aria-label="First name"
                          name="nombre">
                      </div>
                      <div class="col-sm-6">
                        <label for="">Correo Usuario</label>
                        <input type="email" class="form-control" placeholder="Apellido" aria-label="First name"
                          name="correo">
                      </div>
                      <div class="col-sm-6">
                        <label class="label">Rol<span class="text-danger"></span></label>
                        <select name="rol" id="tipoDoc" class="form-control">
                          <option value="">Seleccione..</option>
                          <option value="Admin">Admin</option>
                          <option value="User">User</option>
                          <option value="Aux">auxiliar veterinario</option>
                        </select>
                      </div>
                  <br>
                  <div style="text-align: center;">
                    <button type="submit" name="atcion" value="add" class="btn btn-info">Registar</button>
                  </div>
                </div>
              </div>
              </form>
            </div>
          </div>
        </div>
      </section>

      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.6/dist/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>


    </body>

    </html>