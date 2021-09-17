<%-- 
    Document   : Principal
    Created on : 11-sep-2021, 20:49:49
    Author     : Alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Principal</title>
    </head>



    <nav class="navbar navbar-expand-lg navbar-light bg-warning">


        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="#">CompuSpace</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Clientes</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=NuevaVenta&accion=default" target="myFrame">Nueva Venta</a>
                </li>
            </ul>

        </div>




        <div class="dropdown" style="padding-left: 60px">
            <button style="border: none" class="btn btn-light dropdown-toggle" type="button" id="dropdownMenuButton1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                ${usuario.getNombresEmpleado()}
            </button>
            <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="#">
                    <img src="img/usuario.png" alt="" width="60"/>  
                </a>
                <a class="dropdown-item" href="#">${usuario.getUsuario()}</a>
                <a class="dropdown-item" href="#">usuario@gmail.com</a>
                <div class="dropdown-divider"></div>
                <form action="Validar" method="POST">
                    <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                </form>


            </div>

        </div>

    </nav>

    <div class="m-4" style="height: 525px;">
        <iframe name="myFrame" style="height: 100%; width: 100%; border: none"></iframe>

    </div>        








    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>
</html>