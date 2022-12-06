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
            <link rel="stylesheet"
                href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
            <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap4.min.css">

            <!---- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> -->
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
                                <li><a href="semana?accion=consultar"class="select">Semana</a></li>
                                <li><a href="cita?accion=consultar">Consultar Cita</a></li>
                                <li><a href="cliente?action=consultar">Cliente</a></li>
                                <li><a href="<%=request.getContextPath()%>/logout">Cerrar Sesion</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </header>

            <div class="col-sm-12" style="text-align: center;">
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                    Agregar bloque
                </button>
            </div>
            <div class="m-0 row justify-content-center">
                <div class="col-sm-10 p-5">
                    <div class="card">
                        <c:forEach var="semanal" items="${semanaListId}">
                            <div class="card-header">
                                ${semanal.getNombreSemana()}
                            </div>
                        </c:forEach>
                        <!-- Modal -->

                        <!-- Button trigger modal -->


                        <!-- Modal -->
                        <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
                            aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">Registrar bloque</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <form >
                                            <div class="card-body">
                                                <div class="container-fluid px-6">
                                                    <div class="row">
                                                        <c:forEach var="semanal" items="${semanaListId}">
                                                            <input type="hidden" id="idSemana" name="idSemana"
                                                                value="${semanal.getIdSemana()}">
                                                        </c:forEach>
                                                        <input type="hidden" name="accion" id="accion" value="add">
                                                        <div class="col-sm-6">
                                                            <label for="">Dia bloque</label>
                                                            <input type="text" class="form-control"
                                                                placeholder="Dia bloque " aria-label="First name"
                                                                name="diaBloque" id="diaBloque">
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label for="">Hora Inicio bloque</label>
                                                            <input type="time" class="form-control"
                                                                placeholder="HoraIni" aria-label="First name"
                                                                name="horaInicioBloque" id="horaInicioBloque">
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label class="label">Hora Finaliza el bloque<span
                                                                    class="text-danger"></span></label>
                                                            <input type="time" class="form-control"
                                                                placeholder="HoraFin" aria-label="First name"
                                                                name="horaFinalizacionBloque" id="horaFinalizacionBloque">
                                                        </div>
                                                        <div>
                                                            <label for="">Estado Bloque</label>
                                                            <select class="form-control" name="estadoBloque" id="estadoBloque">
                                                                <option value="">Seleccione...</option>
                                                                <option value="Disponible">Disponible</option>
                                                                <option value="No disponible">No disponible</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <br>
                                                    <div style="text-align: center;">

                                                        <button type="submit" id="addBloque" class="btn btn-info">Registrar</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class=" modal-footer">
                                                            <button type="button" class="btn btn-secondary"
                                                                data-dismiss="modal">Close</button>
                                                    </div>
                                                </div>
                                            </div>
                                    </div>



                                    <table id="example" class="table table-striped table-bordered" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th scope="col">id Bloque</th>
                                                <th scope="col">Dia bloque</th>
                                                <th scope="col">Hora Inicio Bloque</th>
                                                <th scope="col">Hora Finalizacion Bloque</th>
                                                <th scope="col">Estado Bloque</th>
                                                <th scope="col">Accion</th>
                                        </thead>
                                        <c:forEach var="bloqueL" items="${bloqueList}">
                                            <tr>
                                                <td>
                                                    ${bloqueL.getIdBloque()}
                                                </td>
                                                <td>
                                                    ${bloqueL.getDiaBloque()}
                                                </td>
                                                <td>
                                                    ${bloqueL.getHoraInicioBloque()}
                                                </td>
                                                <td>
                                                    ${bloqueL.getHoraFinalizacionBloque()}
                                                </td>
                                                <td>
                                                    ${bloqueL.getEstadoBloque()}
                                                </td>
                                                <td>
                                                    <a href="semana?accion=consultar"><button class="btn btn-warning"
                                                            type="button">Cambiar estado</button> </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
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