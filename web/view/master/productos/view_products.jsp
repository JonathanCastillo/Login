<%-- 
    Document   : view_products
    Created on : 04-10-2020, 11:20:06 AM
    Author     : JonaC
--%>

<%@page import="java.util.Iterator"%>
<%@page import="model.productos"%>
<%@page import="java.util.List"%>
<%@page import="modelDAO.productosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Marvel&display=swap" rel="stylesheet">

        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>JSTORE</title>
    </head>
    <body>
        <jsp:include page="../../components/menu_admin.jsp"/>  
        <div class="container">
         <div class="row">
             <div class="col-12">
                 <center><h1>PRODUCTOS</h1></center>
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
    <div class="card">
        <img src="<%= pro.getImagen()%>" class="card-img-top" height="400" alt="...">
    <div class="card-header text-white bg-dark mb-3">
        <h5 class="card-title"><%= pro.getNombre()%></h5>
    </div>
    <div class="card-body">
    <p class="card-text">Descripcion: <%= pro.getDescripcion()%></p>
    <p class="card-text">Categoria: <%= pro.getCategoria()%></p>
    <p class="card-text">Categoria: <%= pro.getEmpresa()%></p>
    <p class="card-text">Precio: $<%= pro.getPrecio_venta()%></p>
    <a href="#" class="btn btn-primary">COMPRAR</a>
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
            <jsp:include page="../../components/footer.jsp"/>  
</html>

