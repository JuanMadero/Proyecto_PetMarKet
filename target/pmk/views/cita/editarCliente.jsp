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
      <title>Editar Cliente</title>
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
                <li><a href="cliente?action=index">Inicio</a></li>
                <li><a href="semana?accion=consultar">Semana</a></li>
                <li><a href="cita?accion=consultar">Consultar Cita</a></li>
                <li><a href="cliente?action=consultar">Cliente</a></li>
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
                <b>Editar Cliente</b>
              </div>
              <c:forEach var="clienteL" items="${clienteList}">
                <form action="cliente" method="post">
                  <div class="card-body">
                    <div class="container-fluid px-6">
                      <div class="row">
                        <div class="col-sm-6">
                          <label for="">Nombre Cliente</label>
                          <input type="text" class="form-control" placeholder="Nombre" aria-label="First name"
                            name="nombreCliente" value="${clienteL.getNombreCliente()}">
                          <input hidden name="idCliente" type="text" value="${clienteL.getIdCliente()}">
                        </div>
                        <div class="col-sm-6">
                          <label for="">Apellido Cliente</label>
                          <input type="text" class="form-control" placeholder="Apellido" aria-label="First name"
                            name="apellidoCliente" value="${clienteL.getApellidoCliente()}">
                          <input hidden name="idCliente" type="text" value="${clienteL.getIdCliente()}">
                        </div>
                        <div class="col-sm-6">
                          <label class="label">Tipo de Identificacion<span class="text-danger"></span></label>
                          <select name="tipoIdentificacion" id="tipoDoc" class="form-control"
                            value="${clienteL.getTipoIdentificacion()}">
                            <option value="">Seleccione..</option>
                            <option value="CC">CC</option>
                            <option value="TI">TI</option>
                            <option value="CE">CE</option>
                          </select>
                          <input hidden name="idCliente" type="text" value="${clienteL.getIdCliente()}">
                        </div>
                        <div class="col-sm-6">
                          <label for="">Identificacion Cliente</label>
                          <input type="number" class="form-control" placeholder="Numero Identificacion"
                            aria-label="First name" name="identificacionCliente"
                            value="${clienteL.getIdentificacionCliente()}">
                          <input hidden name="idCliente" type="text" value="${clienteL.getIdCliente()}">
                        </div>
                        <div class="col-sm-6">
                          <label for="">Direccion Cliente</label>
                          <input type="text" class="form-control" placeholder="Direccion Cliente"
                            aria-label="First name" name="direccionCliente" value="${clienteL.getDireccionCliente()}">
                          <input hidden name="idCliente" type="text" value="${clienteL.getIdCliente()}">
                        </div>
                        <div class="col-sm-6">
                          <label for="">Correo Cliente</label>
                          <input type="email" class="form-control" placeholder="Correo Cliente" aria-label="First name"
                            name="correoCliente" value="${clienteL.getCorreoCliente()}">
                          <input hidden name="idCliente" type="text" value="${clienteL.getIdCliente()}">
                        </div>
                        <div class="col-sm-6">
                          <label for="">Telefono Cliente</label>
                          <input type="number" class="form-control" placeholder="Telefono Cliente"
                            aria-label="First name" name="telefonoCliente" value="${clienteL.getTelefonoCliente()}">
                          <input hidden name="idCliente" type="text" value="${clienteL.getIdCliente()}">
                        </div>
                      </div>
                      <br>
                    </div>
                  </div>
                  <br>
                  <div style="text-align: center;">
                    <button type="submit" name="accion" value="edit" class="btn btn-info">Editar</button>
                  </div>
            </div>
          </div>
          </form>
          </c:forEach>
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