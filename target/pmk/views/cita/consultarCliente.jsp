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
                                <li><a href="cliente?action=index">Inicio</a></li>
                                <li><a href="semana?accion=consultar">Semana</a></li>
                                <li><a href="cita?accion=consultar">Consultar Cita</a></li>
                                <li><a href="cliente?action=consultar" class="select">Cliente</a></li>
                                <li><a href="<%=request.getContextPath()%>/logout">Cerrar Sesion</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </header>
        

            <div class="col-sm-12" style="text-align: center;">
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                    Agregar Mascota
                </button>
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


                        <!-- Modal -->
                        <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
                            aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">Registrar mascota</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <form >
                                            <div class="card-body">
                                                <div class="container-fluid px-6">
                                                    <div class="row">
                                                        <c:forEach var="clientel" items="${clienteListId}">
                                                            <input type="hidden" name="idCliente" id="idCliente" value="${clientel.getIdCliente()}" >                                                   
                                                        </c:forEach>
                                                        <input type="hidden" name="accion" id="accion" value="add">
                                                        <div class="col-sm-6">
                                                            <label for="">Nombre Mascota</label>
                                                            <input type="text" class="form-control"
                                                                placeholder="Nombre Mascota" aria-label="First name"
                                                                name="nombreMascota" id="nombreMascota" required>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label class="label">Tipo de Mascota<span
                                                                    class="text-danger"></span></label>
                                                            <select name="tipoMascota" id="tipoMascota"required
                                                                class="form-control">
                                                                <option value="">Seleccione..</option>
                                                                <option value="perro">Perro</option>
                                                                <option value="gato">Gato</option>
                                                            </select>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label for="">Raza Mascota</label>
                                                            <input type="text" class="form-control"required
                                                                placeholder="Raza Mascota" aria-label="First name"
                                                                name="razaMascota" id="razaMascota">
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label for="">Peso mascota</label>
                                                            <input type="text" class="form-control"required
                                                                placeholder="PesoMascota" aria-label="First name"
                                                                name="pesoMascota" id="pesoMascota">
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label for="">Comportamiento Mascota</label>
                                                            <input type="text" class="form-control"
                                                                placeholder="Comportamientos" aria-label="First name"
                                                                name="comportamientoMascota" id="comportamientoMascota">
                                                        </div>
                                                    </div>
                                                    <br>
                                                </div>
                                            </div>
                                            <br>
                                            <div style="text-align: center;">
                                                <button type="submit" id="addMascota"
                                                    class="btn btn-info">Registar</button>
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



                        <table id="example" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th scope="col">id mascota</th>
                                    <th scope="col">Nombre mascota</th>
                                    <th scope="col">Tipo mascota</th>
                                    <th scope="col">Raza mascota</th>
                                    <th scope="col">Peso mascota</th>
                                    <th scope="col">Comportamiento mascota</th>
                                    <th scope="col">Accion</th>
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
                                    <td>
                                        <a href="mascota?accion=editar&idMascota=${mascotaL.getIdMascota()}"><button
                                            class="btn btn-warning" type="button">Editar</button> </a>
                                            <br>
                                            <a href="mascota?accion=eliminar&id=${mascotaL.getIdMascota()}"><button
                                                        class="btn btn-danger" type="button"
                                                        onclick="return Delete()">Eliminar</button> </a>
                                    </td>

                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
            <center>
                <c:forEach var="clienteL" items="${clienteListId}">
                            
                            <a href="cliente?action=ingresar&idCliente=${clienteL.getIdCliente()}"><button
                                class="btn btn-warning" type="button">Agendar Cita</button> </a>
                        </c:forEach>
            
            </center>
            
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