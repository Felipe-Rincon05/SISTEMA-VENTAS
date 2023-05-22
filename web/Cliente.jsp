<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    </head>
    <body>
        <div class="d-flex">
            <div style="margin-left: 2px;" class="card col-sm-3">
                <div class="card-body">
                    <form action="Controlador?menu=Cliente" method="POST">
                        <div class="form-group">
                            <label>Cedula</label>
                            <input type="text" value="${cliente.getId_c()}" name="txt_id_cliente" autocomplete="off" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${cliente.getNombre()}" name="txt_nombre_cliente" autocomplete="off" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Correo</label>
                            <input type="text" value="${cliente.getCorreo()}" name="txt_correo_cliente" autocomplete="off" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Direccion</label>
                            <input type="text" value="${cliente.getDireccion()}" name="txt_direccion_cliente" autocomplete="off" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="number" value="${cliente.getEstado()}" name="txt_estado_cliente" autocomplete="off" class="form-control" min="0" max="1" onkeypress="return false;">
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
                            <th>NOMBRE</th>
                            <th>CORREO</th>
                            <th>DIRECCION</th>
                            <th>ESTADO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cl" items="${clientes}">
                            <tr>
                                <td class="text-center">${cl.getId_c()}</td>
                                <td class="text-center">${cl.getNombre()}</td>
                                <td class="text-center">${cl.getCorreo()}</td>
                                <td class="text-center">${cl.getDireccion()}</td>
                                <td class="text-center">${cl.getEstado()}</td>
                                <td class="text-center">
                                    <a class="btn btn-outline-warning" style="border-color: transparent;" href="Controlador?menu=Cliente&btn_enviar=Editar&id=${cl.getId_c()}"><i class="fa-solid fa-pen-to-square"></i></a>
                                    <a class="btn btn-outline-danger" style="border-color: transparent;" href="Controlador?menu=Cliente&btn_enviar=Delete&id=${cl.getId_c()}"><i class="fa-solid fa-trash-can"></i></a>
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
