<%-- 
    Document   : Nueva Venta
    Created on : 11-sep-2021, 20:50:51
    Author     : Alejandro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Nueva Venta</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col">
                <div class="card-body" >
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="form-group">
                            <label>Datos del cliente:</label>
                            <div class="input-group mb-3">
                                <input type="text" name="txtCodigoCliente" value="${cliente.getDPICliente()}" class="form-control" placeholder="Codigo" aria-describedby="button-addon2">
                                <button type="submit" name="accion" value="BuscarCliente"  class="btn btn-outline-warning" id="button-addon2">Buscar</button>
                                <input type="text" name="txtNombresCliente" value="${cliente.getNombresCliente()}" class="form-control" placeholder="Cliente" disabled>
                            </div>

                            <label>Datos del producto:</label>
                            <div class="input-group mb-3">
                                <input type="text" name="txtCodigoProducto" value="${producto.getCodigoProducto()}" class="form-control" placeholder="Codigo" aria-describedby="button-addon2">
                                <button type="submit" name="accion" value="BuscarProducto"  class="btn btn-outline-warning" id="button-addon2">Buscar</button>
                                <input type="text" name="txtNombreProducto" value="${producto.getNombreProducto()}" class="form-control" placeholder="Producto">
                            </div>

                            <div class="input-group mb-3">
                                <input type="text" name="txtPrecio" value="${producto.getPrecioProducto()}" class="form-control" placeholder="Q00.00">
                                <input type="text" name="txtCantidad" value="1" class="form-control" placeholder="Cantidad" style="margin-left: 10px">
                                <input type="text" name="txtStock" value="${producto.getStock()}" class="form-control" placeholder="Stock" disabled>
                            </div>
                        </div>
                        <button type="submit" name="accion" value="Agregar" class="btn btn-warning" style="margin-top: 15px">Agregar producto</button>
                    </form>
                </div>
            </div>
            <div class="col-sm-8" style="margin-left: 15px">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ml-auto">
                            <input type="text" name="txtNumeroSerie" class="form-control" placeholder="N°. serie" style="width: 15rem">
                        </div>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Número</th>
                                    <th>Código</th>
                                    <th>Descripción</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>    
                                        <td>${list.getCodigoProducto()}</td>    
                                        <td>${list.getDescripcionProd()}</td>    
                                        <td>${list.getPrecio()}</td>    
                                        <td>${list.getCantidad()}</td>    
                                        <td>${list.getSubTotal()}</td>    
                                        <td>
                                            <a class="btn btn-outline-warning" href="#">Editar</a>
                                            <a class="btn btn-outline-danger" style="margin-left: 10px">Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-8 ml-auto">
                            <input type="submit" name="accion" value="Generar Venta" class="btn btn-success">  
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                        <div class="col-sm-4">
                            <input type="text" name="txtTotal" value="Q.${totalPagar}" class="form-control" placeholder="Subtotal" disabled>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>