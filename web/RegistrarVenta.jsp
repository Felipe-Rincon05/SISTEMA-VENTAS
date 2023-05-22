<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VENTAS</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <style>
            @media print {
                .parte01, .btn, .accion {
                    display: none;
                }
                
                /*.parte02 {
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    height: 100%;
                    width: 100%;
                }*/
                
                .parte02 {
                    width: 100%;
                    margin-top: 50%;
                }
            }
        </style>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-5 p-1 parte01">
                <div class="card">
                    <form action="Controlador?menu=RegistrarVenta" method="POST">
                        <div class="card-body">
                            <!-- --------------------------------------------------------- DATOS DEL CLIENTE ------------------------------------------------------------ -->
                            <div class="form-group">
                                <label>Datos del cliente</label>
                            </div>
                            <div class="form-group d-flex justify-content-between">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="txt_id_cliente_v" value="${cliente.getId_c()}" class="form-control" placeholder="Cedula" autocomplete="off">
                                    <button style="border-color: transparent; --bs-btn-hover-bg: #1F618D; --bs-btn-color: #1F618D;" type="submit" name="btn_enviar" value="Buscar Cliente" class="btn btn-outline-light"><i class="fa-solid fa-magnifying-glass"></i></button>
                                </div>
                                <div class="col-sm-5 ms-auto">
                                    <input type="text" name="txt_nombre_cliente_v" value="${cliente.getNombre()}" class="form-control" placeholder="Datos cliente" readonly>
                                </div>  
                            </div>
                            <br>
                            <!-- ----------------------------------------- DATOS DEL PRODUCTO -------------------------------------------------- -->
                            <div class="form-group">
                                <label>Datos producto</label>
                            </div>
                            <div class="form-group d-flex justify-content-between">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="txt_id_producto_v" value="${producto.getId_producto()}" class="form-control" placeholder="Cod producto" autocomplete="off">
                                    <button style="border-color: transparent; --bs-btn-hover-bg: #1F618D;; --bs-btn-color: #1F618D;" type="submit" name="btn_enviar" value="Buscar Producto" class="btn btn-outline-light"><i class="fa-solid fa-magnifying-glass"></i></button>
                                </div>
                                <div class="col-sm-5 ms-auto">
                                    <input type="text" name="txt_nombre_producto_v" value="${producto.getNombre()}" class="form-control" placeholder="Datos producto" readonly>
                                </div>
                            </div>
                            <br>
                            <div class="form-group d-flex justify-content-between">
                                <div class="col-sm-4">
                                    <input type="text" name="txt_precio_v" value="${producto.getPrecio()}" class="form-control" placeholder="&#36;0.00" readonly>
                                </div>
                                <div class="col-sm-2">
                                    <input type="number" name="txt_cantidad_v" value="1" class="form-control" min="1" onkeypress="return false;">
                                </div>
                                <div class="col-sm-5">
                                    <input type="text" name="text_stock_v" value="${producto.getStock()}" class="form-control" placeholder="Stock" readonly>
                                </div>
                            </div>
                            <br>
                            <div class="form-group">
                                <button style="border-color: #1F618D; --bs-btn-hover-bg: #1F618D; --bs-btn-color: #1F618D;" type="submit" name="btn_enviar" value="Agregar" class="btn btn-outline-info">Agregar producto</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7 p-1 parte02">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ms-auto" >
                            <label class="col-sm-4">Número serie: </label>
                            <input type="text" name="txt_num_serie_v" value="${numero_serie}" class="form-control" readonly>
                        </div>
                        <br>
                        <table class="table table-dark table-sm align-middle">
                            <thead>
                                <tr class="text-center">
                                    <th>Número</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                    <th class="accion">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}"  varStatus="loop">
                                    <tr class="text-center align-middle">
                                        <td>${list.getItem()}</td>
                                        <td>${list.getId_producto()}</td>
                                        <td>${list.getDescripcion_p()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td>${list.getCantidad()}</td>
                                        <td>${list.getSubtotal()}</td>
                                        <td>
                                            <a style="border-color: transparent;" class="btn btn-outline-danger" href="Controlador?menu=RegistrarVenta&btn_enviar=Delete&index=${loop.index}"><i class="fa-solid fa-trash-can"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a style="border-color: #306A2C; --bs-btn-hover-bg: #306A2C; --bs-btn-color: #306A2C;" href="Controlador?menu=RegistrarVenta&btn_enviar=GenerarVenta" onclick="print()" class="btn btn-outline-info">Genera venta</a>
                            <a style="border-color: #AF2929; --bs-btn-hover-bg: #AF2929; --bs-btn-color: #AF2929;" href="Controlador?menu=RegistrarVenta&btn_enviar=Cencelar" class="btn btn-outline-info">Cancelar</a>
                        </div>
                        <div class="col-sm-5 ms-auto d-flex">
                            <label class="col-sm-6"><b>Total a pagar:</b></label>
                            <input type="text" name="txt_total_v" value="&#36; ${total_pagar}" class="form-control" readonly>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/4b5617367e.js" crossorigin="anonymous"></script>
    </body>
</html>
