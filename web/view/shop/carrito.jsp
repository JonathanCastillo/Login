<%-- 
    Document   : carrito
    Created on : 08-15-2020, 03:38:35 PM
    Author     : JonaC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Iterator"%>
<%@page import="model.carrito"%>
<%@page import="java.util.List"%>
<%@page import="modelDAO.productosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <jsp:include page="../components/header.jsp"/>  
    <body>
        <jsp:include page="../components/menu_client.jsp"/>  
       <div class="container mt-4">
         <div class="row">
             <div class="col-8  badge-light">
                 <div class="card-header">Carrito de compras</div>
                    <div class="card-body">
                        <h5 class="card-title">Lista de productos</h5>
                            <table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Item</th>
      <th scope="col">Producto</th>
      <th scope="col">Nombre</th>
      <th scope="col">Descripcion</th>
      <th scope="col">Precio</th>
      <th scope="col">Cantidad</th>
      <th scope="col">Sub total</th>
      <th scope="col">Accion</th>
    </tr>
  </thead>
  <tbody>
      <c:forEach var="car" items="${carrito}">
    <tr>
      
      <td>${car.getItem()}</td>
      <td><img src="${car.getImagen()}" alt="..." class="img-thumbnail"></td>
      <td>${car.getNombre()}</td>
      <td>${car.getDescripcion()}</td>
      <td>${car.getPreciocompra()}</td>
      <td>${car.getCantidad()}</td>
      <td>${car.getSubtotal()}</td>
      <td>
          <button type="submit" class="btn btn-info btn-block">Editar</button>
          <button type="submit" class="btn btn-danger btn-block">Eliminar</button>
      </td>
    </tr>
  </tbody>
   </c:forEach>
</table>
                        
                        
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    </div>
                  
             </div>
           
                          <div class="col-4  badge-light">
                 <div class="card-header">Finalizar compra</div>
                    <div class="card-body">
                        <h5 class="card-title">Facturacion</h5>
                        <span>Sub total: </span>       
                        <input type="text" value="$ ${total}0" readonly class="form-control">
                        <span>Descuento especial: </span>       
                        <input type="text" value="$ 0.00" readonly class="form-control">
                        <span>Total a pagar: </span>       
                        <input type="text" value="$ ${total}0" readonly class="form-control">
                        
                        <p class="card-text">Muchas gracias por tu compra. Glaudem Store, donde tus sueños se vuelven realidad... <br><br>
                        ***Envio gratis en todo El Salvador***
                        
                        </p>
                    </div>
                 <div class="card-footer">
                      <button type="submit" class="btn btn-info btn-block">Realizar pago</button>
                      <button type="submit" class="btn btn-success btn-block">Finalizar compra</button>
                 </div>
                  
             </div>
          
          
 
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
      <jsp:include page="../components/footer.jsp"/>  
</html>

