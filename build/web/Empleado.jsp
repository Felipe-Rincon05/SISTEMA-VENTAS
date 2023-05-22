<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleado</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style_empleado.css">
    </head>
    <body>
        <div class="d-flex flex-row mb-3">
            <div style="margin-left: 2px;" class="card col-sm-3 p-1">
                <div class="card-body">
                    <form action="Controlador?menu=Empleado" method="POST">
                        <div class="form-group">
                            <label>Cedula</label>
                            <input type="text" value="${empleado.getId()}" name="txt_id_empleado" autocomplete="off" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="text" value="${empleado.getContrasena()}" name="txt_contrasena_empleado" autocomplete="off" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${empleado.getNombre()}" name="txt_nombre_empleado" autocomplete="off" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Correo</label>
                            <input type="text" value="${empleado.getCorreo()}" name="txt_correo_empleado" autocomplete="off" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Telefono</label>
                            <input type="text" value="${empleado.getTel()}" name="txt_telefono_empleado" autocomplete="off" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="number" value="${empleado.getEstado()}" name="txt_estado_empleado" autocomplete="off" class="form-control" min="0" max="1" onkeypress="return false;">
                        </div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" value="${empleado.getUser()}" name="txt_usuario_empleado" autocomplete="off" class="form-control">
                        </div>
                        <div style="margin-top: 10px; display: flex; justify-content: space-between;">
                            <input style="border-color: #1F618D; --bs-btn-hover-bg: #1F618D; --bs-btn-color: #1F618D;" type="submit" name="btn_enviar" value="Agregar" class="btn btn-outline-info col-5 mx-auto">
                            <input style="border-color: #229954; --bs-btn-hover-bg: #229954; --bs-btn-color: #229954;" type="submit" name="btn_enviar" value="Actualizar" class="btn btn-outline-info col-5 mx-auto">
                        </div>
                        
                    </form>
                </div>
            </div>
            <div class="col-sm-9" style="padding-left: 10px;">
                <table class="table table-dark table-sm align-middle">
                    <thead>
                        <tr class="text-center">
                            <th>CEDULA</th>
                            <th>CONTRASEÑA</th>
                            <th>NOMBRE</th>
                            <th>CORREO</th>
                            <th>TELEFONO</th>
                            <th>ESTADO</th>
                            <th>USUARIO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="em" items="${empleados}">
                            <tr  class="text-center">
                                <td>${em.getId()}</td>
                                <td>${em.getContrasena()}</td>
                                <td>${em.getNombre()}</td>
                                <td>${em.getCorreo()}</td>
                                <td>${em.getTel()}</td>
                                <td>${em.getEstado()}</td>
                                <td>${em.getUser()}</td>
                                <td>
                                    <a style="border-color: transparent;" class="btn btn-outline-warning"  h href="Controlador?menu=Empleado&btn_enviar=Editar&id=${em.getId()}"><i class="fa-solid fa-pen-to-square"></i></a>
                                    <a style="border-color: transparent;" class="btn btn-outline-danger" class="btn btn-danger" href="Controlador?menu=Empleado&btn_enviar=Delete&id=${em.getId()}"><i class="fa-solid fa-trash-can"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div> 
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/4b5617367e.js" crossorigin="anonymous"></script>
    </body>
</html>
