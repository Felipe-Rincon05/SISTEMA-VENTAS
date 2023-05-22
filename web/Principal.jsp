<%-- 
    Document   : Principal
    Created on : 29/04/2023, 12:24:22 p. m.
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <link rel="shortcut icon" href="img/Tienda.png">
        <title>Principal</title>
    </head>
    <body>
        <nav style="background-color: #1F618D;" class="navbar navbar-expand-lg">
            <div class="container-fluid">
                <a class="navbar-brand" href="Controlador?menu=Principal_Iframe" target="MyFrame">Inicio</a>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none;" class="btn btn-outline-light" href="Controlador?menu=Producto&btn_enviar=Listar" target="MyFrame">Producto</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none;" class="btn btn-outline-light" href="Controlador?menu=Empleado&btn_enviar=Listar" target="MyFrame">Empleado</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none;" class="btn btn-outline-light" href="Controlador?menu=Cliente&btn_enviar=Listar" target="MyFrame">Cliente</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none;" class="btn btn-outline-light" href="Controlador?menu=RegistrarVenta&btn_enviar=default" target="MyFrame">Nueva Venta</a>
                        </li>
                    </ul>
                </div>
                <div class="btn-group text-center">
                    <button style="background-color: #1F618D; border-color: #1F618D " type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                        <img style="border-radius: 100%" src="img/User.png" width="30" height="30" alt="alt"/>
                    </button>
                    <ul class="dropdown-menu dropdown-menu-end text-center">
                        <li><a class="dropdown-item" href="#">${usuario.getNombre()}</a></li>
                        <li><a class="dropdown-item" href="#">${usuario.getCorreo()}</a></li>
                        <li><div class="dropdown-divider"></div></li>
                        <form action="Validar" method="POST">
                            <li><button name="btn_enviar" value="Salir" class="dropdown-item" href="#">Salir</button></li>
                        </form>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="m-3" style="height: 90vh;">
            <iframe name="MyFrame" style="height: 100%; width: 100%; border: none; border-radius: 10px;" src="Principal_Iframe.jsp"></iframe>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/4b5617367e.js" crossorigin="anonymous"></script>
    </body>
</html>
