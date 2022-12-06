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
                                <li><a href="semana?accion=consultar" class="select">Semana</a></li>
                                <li><a href="cita?accion=consultar">Consultar Cita</a></li>
                                <li><a href="cliente?action=consultar">Cliente</a></li>
                                <li><a href="<%=request.getContextPath()%>/logout">Cerrar Sesion</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </header>


            <div class="m-0 row justify-content-center">
                            <button type="button" class="btn btn-primary" data-toggle="modal"
                                data-target="#exampleModalCenter">
                                Agregar semana
                            </button>
                        </div>
                        <c:forEach var="semanal" items="${semanaListId}">
                            <div class="card-header">
                                ${semanal.getIdSemana()}
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
                                        <h5 class="modal-title" id="exampleModalLongTitle">Registrar semana</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <form>
                                            <div class="card-body">
                                                <div class="container-fluid px-6">
                                                    <div class="row">
                                                        <input type="hidden" name="accion" id="accion" value="add"
                                                            required>
                                                        <div class="col-sm-6">
                                                            <label class="label">Nombre semana<span
                                                                    class="text-danger"></span></label>
                                                            <input type="text" class="form-control" name="nombreSemana"
                                                                id="nombreSemana" required>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label for="">Fecha de inicio de semana </label>
                                                            <input type="date" class="form-control" name="fechaInicio"
                                                                id="fechaInicio" required>
                                                        </div>
                                                        <div class="col-sm-6 ">
                                                            <label for="">Fecha de finalización de la semana</label>
                                                            <input type="date" class="form-control"
                                                                name="fechaFinalizacion" id="fechaFinalizacion"
                                                                required>
                                                        </div>
                                                        <div>
                                                            <label for="">Estado Semana</label>
                                                            <select name="estadoSemana" class="form-control"
                                                                id="estadoSemana" required>
                                                                <option value="">Seleccione...</option>
                                                                <option value="En curso">En curso</option>
                                                                <option value="Finalizada">Finalizada</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <br>
                                                    <div style="text-align: center;">
                                                        <button type="submit" id="addSemana"
                                                            class="btn btn-info">Registar</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary"
                                            data-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="m-0 row justify-content-center">
                            <div class="col-sm-10 p-5">
                                <div class="card">
                                    <div class="card-header">
                                        Semanas registradas
                                    </div>
                                    <table id="example" class="table table-striped table-bordered" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th scope="col">id Semana</th>
                                                <th scope="col">Nombre Semana</th>
                                                <th scope="col">Fecha Inicio</th>
                                                <th scope="col">Fecha Finalizacion</th>
                                                <th scope="col">Estado</th>
                                                <th scope="col">Accion</th>
                                        </thead>
                                        <c:forEach var="semanaL" items="${semanaList}">
                                            <tr>
                                                <td>
                                                    ${semanaL.getIdSemana()}
                                                </td>
                                                <td>
                                                    ${semanaL.getNombreSemana()}
                                                </td>
                                                <td>
                                                    ${semanaL.getFechaInicio()}
                                                </td>
                                                <td>
                                                    ${semanaL.getFechaFinalizacion()}
                                                </td>
                                                <td>
                                                    ${semanaL.getEstadoSemana()}
                                                </td>
                                                <td>
                                                    <a href="bloque?accion=consultar&idSemana=${semanaL.getIdSemana()}"><button
                                                            class="btn btn-info" type="button">Consultar</button>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>
                        </div>

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