<%-- 
    Document   : chome
    Created on : 06-03-2020, 04:37:30 PM
    Author     : JonaC
--%>

<%@page import="java.util.Iterator"%>
<%@page import="model.productos"%>
<%@page import="java.util.List"%>
<%@page import="modelDAO.productosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <jsp:include page="view/components/header.jsp"/>  
    <body>
        <jsp:include page="view/components/menu_client.jsp"/>  
       <div class="container">
         <div class="row">
             <div class="col-12 badge badge-light">
                 <span class="badge badge-light"><h4>PRODUCTOS</h4></span>
                  
             </div>
           
          
    <% 
    productosDAO dao=new productosDAO();
    List<productos> listar=dao.listar();
    Iterator<productos>iterator=listar.iterator();
    productos pro= null;
    System.out.println("LLEGANDO A PAGINA PRODUCTOS");
    while (iterator.hasNext()) 
    {
        System.out.println("LLEGANDO A PAGINA PRODUCTOS JSP WHILE");
        pro=iterator.next();
        System.out.println(pro.getNombre());
        
    %>
    <div class="col-4">
    <div class="card managerstock">
        <img src="<%= pro.getImagen()%>" class="card-img-top" height="400" alt="...">
    <div class="card-header text-white bg-dark mb-3">
        <h5 class="card-title"><%= pro.getNombre()%></h5>
    </div>
    <div class="card-body">

    <p class="card-text">Descripcion: <%= pro.getDescripcion()%></p>
    <p class="badge badge-warning managerstocklabels">Categoria: <%= pro.getCategoria()%></p>
    <p class="badge badge-dark managerstocklabels">Marca: <%= pro.getEmpresa()%></p>
    <p class="badge badge-success managerstocklabels">Precio: $<%= pro.getPrecio_venta()%></p>
    <div>
               
        <a href="products?accion=addcarrito&id=<%= pro.getId_producto()%>">
            <svg class="bi bi-plus-circle-fill" width="22px" height="22px" viewBox="0 0 16 16" fill="#1F2324" xmlns="http://www.w3.org/2000/svg" title="Agregar al carrito">
  <path fill-rule="evenodd" d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.5 4a.5.5 0 0 0-1 0v3.5H4a.5.5 0 0 0 0 1h3.5V12a.5.5 0 0 0 1 0V8.5H12a.5.5 0 0 0 0-1H8.5V4z"/>
</svg>
        </a>
        <a  href="user?accion=listar">
            <svg class="bi bi-heart-fill" width="22px" height="22px" viewBox="0 0 16 16" fill="#1F2324" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
</svg>
        </a>
    </div>
    
    </div>
    </div>
    </div>
       
    <% } %>
          
          
 
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
      <jsp:include page="view/components/footer.jsp"/>  
</html>

