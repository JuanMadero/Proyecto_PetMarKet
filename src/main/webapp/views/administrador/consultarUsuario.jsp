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
        <script type="text/javascript">
            function Delete() {
                var respuesta = confirm("Estas seguro de que deseas Cancelar?");
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
                                <li><a href="usuario?accion=consultar" class="select">Consultar usuarios</a></li>
                                <li><a href="cita?accion=consultara">Consultar Cita</a></li>
                                <li><a href="cliente?action=consultara">Consultar Cliente</a></li>
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
                            Usuarios agregados
                        </div>
                        <table id="example" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th scope="col">id Usuario</th>
                                    <th scope="col">Usuario</th>
                                    <th scope="col">Contraseña</th>
                                    <th scope="col">Nombre usuario</th>
                                    <th scope="col">correo</th>
                                    <th scope="col">tipo Rol</th>
                                    <th scope="col">Accion</th>
                            </thead>
                            <c:forEach var="usuarioL" items="${usuarioList}">
                                <tr>
                                    <td>
                                        ${usuarioL.getIdUsuario()}
                                    </td>
                                    <td>
                                        ${usuarioL.getUsuario()}
                                    </td>
                                    <td>
                                        ${usuarioL.getPassword()}
                                    </td>
                                    <td>
                                        ${usuarioL.getNombre()}
                                    </td>
                                    <td>
                                        ${usuarioL.getCorreo()}
                                    </td>
                                    <td>
                                        ${usuarioL.getRol()}
                                    </td>
                                    <td>
                                        <a href="usuario?accion=editar&id=${usuarioL.getIdUsuario()}"><button
                                                class="btn btn-warning" type="button">Editar</button> </a>

                                        <a href="usuario?accion=eliminar&id=${usuarioL.getIdUsuario()}"><button
                                                class="btn btn-danger" type="button"
                                                onclick="return Delete()">Cancelar</button> </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>



            <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
            <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
            <script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
            <script src="assets/Js/Script.js"></script>

        </body>

        </html>