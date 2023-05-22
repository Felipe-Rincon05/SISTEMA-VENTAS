<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    </head>
    <body>
        <div class="d-flex">
            <div style="margin-left: 2px;" class="card col-sm-3">
                <div class="card-body">
                    <form action="Controlador?menu=Producto" method="POST">
                        <div class="form-group">
                            <label>No. Producto</label>
                            <input type="text" value="${producto.getId_producto()}" name="txt_id_producto" autocomplete="off" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${producto.getNombre()}" name="txt_nombre_producto" autocomplete="off" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Precio</label>
                            <input type="text" value="${producto.getPrecio()}" name="txt_precio_producto" autocomplete="off" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Stock</label>
                            <input type="text" value="${producto.getStock()}" name="txt_stock_producto" autocomplete="off" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="number" value="${producto.getEstado()}" name="txt_estado_producto" autocomplete="off" class="form-control" min="0" max="1" onkeypress="return false;">
                        </div>
                        <div style="margin-top: 10px; display: flex; justify-content: space-between;">
                            <input style="border-color: #1F618D; --bs-btn-hover-bg: #1F618D; --bs-btn-color: #1F618D;" type="submit" name="btn_enviar" value="Agregar" class="btn btn-outline-info col-5 mx-auto">
                            <input style="border-color: #229954; --bs-btn-hover-bg: #229954; --bs-btn-color: #229954;" type="submit" name="btn_enviar" value="Actualizar" class="btn btn-outline-info col-5 mx-auto">
                        </div>
                        
                    </form>
                </div>
            </div>
            <div class="col-sm-9" style="padding-left: 9px;">
                <table class="table table-dark table-sm align-middle">
                    <thead>
                        <tr class="text-center">
                            <th>NO PRODUCTO</th>
                            <th>NOMBRE</th>
                            <th>PRECIO</th>
                            <th>STOCK</th>
                            <th>ESTADO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pr" items="${productos}">
                            <tr>
                                <td class="text-center">${pr.getId_producto()}</td>
                                <td class="text-center">${pr.getNombre()}</td>
                                <td class="text-center">${pr.getPrecio()}</td>
                                <td class="text-center">${pr.getStock()}</td>
                                <td class="text-center">${pr.getEstado()}</td>
                                <td class="text-center">
                                    <a style="border-color: transparent" class="btn btn-outline-warning" href="Controlador?menu=Producto&btn_enviar=Editar&id=${pr.getId_producto()}"><i class="fa-solid fa-pen-to-square"></i></a>
                                    <a style="border-color: transparent" class="btn btn-outline-danger" href="Controlador?menu=Producto&btn_enviar=Delete&id=${pr.getId_producto()}"><i class="fa-solid fa-trash-can"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div> 
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/4b5617367e.js" crossorigin="anonymous"></script>
    </body>
</html>
