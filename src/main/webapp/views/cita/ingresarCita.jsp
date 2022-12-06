<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
      <link rel="stylesheet" href="assets/css/EstilosViews.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
      <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap4.min.css">
      <title>Ingresar Cita</title>
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
                        <li><a href="cita?accion=consultar" class="select">Consultar Cita</a></li>
                        <li><a href="cliente?action=consultar">Cliente</a></li>
                        <li><a href="<%=request.getContextPath()%>/logout">Cerrar Sesion</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </header>

      <section>
        <div class="m-0 row justify-content-center" style="background-image: url(img/fond.jpg) ">
          <div class="col-sm-5 p-5 ">
            <div class="card">
              <div class="card-header" style="background-color:#17A2B8; color: rgb(255, 255, 255);text-align: center;">
                <b>Horario Cita </b>
              </div>
              <div class="card-body">
                <div class="container-fluid px-6">
                  <div class="row">
                    <div class="col-sm-6">
                      <label class="label">Tipo de Servicio<span class="text-danger"></span></label>
                      <select name="tipoServicio" id="tipoServicio" class="form-control">
                        <option value="">Seleccione..</option>
                        <option value="Consulta">Consulta</option>
                        <option value="Baño">Baño</option>
                        <option value="Corte">Corte</option>
                      </select>
                    </div>
                    <div class="col-sm-6">
                      <label class="label">Seleccione mascota<span class="text-danger"></span></label>
                      <select name="idMascota" id="idMascota" class="form-control">
                        <option value="">Seleccione..</option>
                        <c:forEach var="mascotaL" items="${mascotaList}">
                          <option value="${mascotaL.getIdMascota()}">${mascotaL.getNombreMascota()}</option>
                        </c:forEach>
                      </select>
                    </div>
                    <div class="col-sm-6">
                      <label class="label">Seleccione bloque<span class="text-danger"></span></label>
                      <select name="idBloque" id="idBloque" class="form-control">
                        <option value="">Seleccione..</option>
                        <c:forEach var="bloqueL" items="${bloqueListDis}">
                          <option value="${bloqueL.getIdBloque()}">${bloqueL.getDiaBloque()} ${bloqueL.getHoraInicioBloque()} a ${bloqueL.getHoraFinalizacionBloque()} </option>
                        </c:forEach>
                      </select>
                    </div>
                    <input type="hidden" id="idRecepcionista" value="<%= session.getAttribute("idUsuario") %>">
                    <c:forEach var="clientel" items="${clienteListId}">
                      <input type="hidden" id="idCliente" value="${clientel.getIdCliente()}">
                    </c:forEach>

                  </div>
                  <br>
                  <div style="text-align: center;">
                    <button id="btn_add_cita" class="btn btn-info">Registar</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>

      <div>
        <div class="actions">
            <script language="javascript">
                function atras() { history.back(); }
            </script>
            <ul class="ull">
                <li class="lis"><input class="accion" type="button" value="Atrás" name="Boton1"
                        onclick="atras();">
                </li>
            </ul>
        </div>
    </div>
      
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
    integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
    crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
    integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
    crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
    integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>


<script src="assets/Js/jquery-3.6.1.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<!--<script src="https://code.jquery.com/jquery-3.5.1.js"></script>-->
<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
    integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
    crossorigin="anonymous"></script>



<script src="assets/Js/Script.js"></script>

<script src="assets/Js/sweetAlert.js"></script>


    </body>

    </html>