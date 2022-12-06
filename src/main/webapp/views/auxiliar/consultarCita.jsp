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
                                <li><a href="usuario?action=indexs" class="select">Inicio</a></li>
                                <li><a href="cita?accion=consultarr" >Consultar Cita</a></li>
                                <li><a href="<%=request.getContextPath()%>/logout">Cerrar Sesion</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </header>
        

            <div class="m-0 row justify-content-center">
                <div class="col-sm-10 p-5">
                    <div class="card">
                        <div class="card-header">
                            Citas Agendadas
                        </div>
                        <table id="example" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th scope="col">Tipo Servicio</th>
                                    <th scope="col">Nombre Mascota</th>
                                    <th scope="col">Nombre Cliente</th>
                                    <th scope="col">Apellido Cliente</th>
                                    <th scope="col">Dia Bloque</th>
                                    <th scope="col">Hora inicio bloque</th>
                                    <th scope="col">Hora fin bloque</th>
               
                            </thead>
                            <c:forEach var="citaL" items="${citaList}">
                                <tr>
                                    <td>
                                        ${citaL.getTipoServicio()}
                                    </td>
                                    <td>
                                        ${citaL.getNombreMascota()}
                                    </td>
                                    <td>
                                        ${citaL.getNombreCliente()}
                                    </td>
                                    <td>
                                        ${citaL.getApellidoCliente()}
                                    </td>
                                    <td>
                                        ${citaL.getDiaBloque()}
                                    </td>
                                    <td>
                                        ${citaL.getHoraInicioBloque()}
                                    </td>
                                    <td>
                                        ${citaL.getHoraFinalizacionBloque()}
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

            <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
            <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
            <script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
            <script src="assets/Js/Script.js"></script>

        </body>

        </html>