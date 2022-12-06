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
            <link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
            <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap4.min.css">

            <!---- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> -->
        </head>
        <script type="text/javascript">
            function Delete() {
                var respuesta = confirm("Estas seguro de que deseas Eliminar?");
                if (respuesta == true) {
                    return true;
                }
                else {
                    return false;
                }
            }
        </script>
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
            </div>
            <div class="m-0 row justify-content-center">
                <div class="col-sm-10 p-5">
                    <div class="card">
                        <c:forEach var="clienteL" items="${clienteListId}">
                            <div class="card-header">
                                ${clienteL.getNombreCliente()}
                            </div>
                        </c:forEach>
                        <!-- Modal -->

                        <!-- Button trigger modal -->
                        <table id="example" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th scope="col">id mascota</th>
                                    <th scope="col">Nombre mascota</th>
                                    <th scope="col">Tipo mascota</th>
                                    <th scope="col">Raza mascota</th>
                                    <th scope="col">Peso mascota</th>
                                    <th scope="col">Comportamiento mascota</th>
                            </thead>
                            <c:forEach var="mascotaL" items="${mascotaList}">
                                <tr>
                                    <td>
                                        ${mascotaL.getIdMascota()}
                                    </td>
                                    <td>
                                        ${mascotaL.getNombreMascota()}
                                    </td>
                                    <td>
                                        ${mascotaL.getTipoMascota()}
                                    </td>
                                    <td>
                                        ${mascotaL.getRazaMascota()}
                                    </td>
                                    <td>
                                        ${mascotaL.getPesoMascota()}
                                    </td>
                                    <td>
                                        ${mascotaL.getComportamientoMascota()}
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