<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/EstilosViews.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/css/bootstrap.min.css"
      integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <title>Gestion de Cita</title>
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
              <b>Crear Semana </b>
            </div>
              <div class="card-body">
                
          </div>
        </div>
      </div>
    </section>
    <section>
      <div class="m-0 row justify-content-center">
        <div class="col-sm-7 p-5">
          <div class="card">
            <div class="card-header" style="background-color:#17A2B8; color: rgb(255, 255, 255);text-align: center;">
              <b>Registrar bloque</b>
            </div>
            <form action="bloque" method="post">
              <div class="card-body">
                <div class="container-fluid px-6">
                  <div class="row">
                    <div class="col-sm-6">
                      <label for="">Dia bloque</label>
                      <input type="text" class="form-control" placeholder="Dia bloque " aria-label="First name"
                        name="diaBloque">
                    </div>
                    <div class="col-sm-6">
                      <label for="">Hora Inicio bloque</label>
                      <input type="time" class="form-control" placeholder="HoraIni" aria-label="First name"
                        name="horaInicioBloque">
                    </div>
                    <div class="col-sm-6">
                      <label class="label">Hora Finaliza el bloque<span class="text-danger"></span></label>
                      <input type="time" class="form-control" placeholder="HoraFin" aria-label="First name"
                        name="horaFinalizacionBloque">
                    </div>
                    <div>
                      <label for="">Estado Bloque</label>
                      <select name="estadoBloque" class="form-control">
                        <option value="">Seleccione...</option>
                        <option value="Disponible">Disponible</option>
                        <option value="No disponible">No disponible</option>
                      </select>
                    </div>
                  </div>
                  <br>
                  <div style="text-align: center;">
                    <button type="submit" name="acccion" value="adda" class="btn btn-info">Registar</button>
                  </div>
                </div>
              </div>
              </form>
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