<%-- 
    Document   : listarusuarios
    Created on : 03-30-2020, 05:12:38 PM
    Author     : JonaC
--%>


<%@page import="interfaces.usuarios"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.usuario"%>
<%@page import="modelDAO.usuarioDAO"%>
<%-- 
    Document   : home
    Created on : 03-24-2020, 03:22:23 PM
    Author     : JonaC
--%>


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
        <jsp:include page="../components/menu_admin.jsp"/>  

        <div class="container">
  <div class="row">
      <div class="col-8">
          <h1>Lista de usuarios</h1> 
          <table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Nombres</th>
      <th scope="col">Apellidos</th>
      <th scope="col">Email</th>
      <th scope="col">Opciones</th>
    </tr>
  </thead>
  <tbody>
    <% 
    usuarioDAO dao=new usuarioDAO();
    List<usuario> listar=dao.listar();
    Iterator<usuario>iterator=listar.iterator();
    usuario user1= null;
    System.out.println("LLEGANDO A PAGINA JSP");
    while (iterator.hasNext()) 
    {
        System.out.println("LLEGANDO A PAGINA JSP WHILE");
        user1=iterator.next();
        System.out.println(user1.getNombres());
        
    %>
    <tr>
        <td><%= user1.getId_usuario() %></td>
        <td><%= user1.getNombres()%></td>
        <td><%= user1.getApellidos()%></td>
        <td><%= user1.getEmail()%></td>
        <td>
            <a  class="btn btn-outline-success" href="user?accion=edit&id=<%= user1.getId_usuario() %>">Editar</a>
            <a  class="btn btn-outline-danger" href="user?accion=delete&id=<%= user1.getId_usuario() %>">Eliminar</a>
        </td>
    </tr>
    <% } %>
  </tbody>
</table>
          
          
      </div>
    <div class="col-4">
        <h1>NOTICIAS</h1>
       <div class="card text-center">
  <div class="card-header">
    TENDENCIAS
  </div>
  <div class="card-body">
    <h5 class="card-title">Special title treatment</h5>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
  <div class="card-footer text-muted">
    2 days ago
  </div>
</div>
        
        
        <div class="toast" role="alert" aria-live="assertive" aria-atomic="true">
  <div class="toast-header">
    <img src="..." class="rounded mr-2" alt="...">
    <strong class="mr-auto">Bootstrap</strong>
    <small class="text-muted">11 mins ago</small>
    <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
  </div>
  <div class="toast-body">
    Hello, world! This is a toast message.
  </div>
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

