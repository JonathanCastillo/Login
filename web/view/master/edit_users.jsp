<%-- 
    Document   : edit_users
    Created on : 03-30-2020, 05:19:12 PM
    Author     : JonaC
--%>

<%@page import="model.usuario"%>
<%@page import="modelDAO.usuarioDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.tipousuario"%>
<%@page import="modelDAO.tipousuarioDAO"%>
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
          <% 
          usuarioDAO dao1 = new usuarioDAO();
          int id = Integer.parseInt((String)request.getAttribute("id"));
          usuario us= (usuario)dao1.list(id);
          %>
          <h1>Editar usuario</h1> 
          <form action="user" class="col-8">
                <div class="form-group">
                    <label for="idusuario">Id</label>
                    <input type="hidden" class="form-control" id="idusuario" name="idusuario" value="<%=us.getId_usuario() %>">
                   
                </div>
                <div class="form-group">
                    <label for="nombres">Nombres</label>
                    <input type="text" class="form-control" id="nombres" name="nombres" value="<%=us.getNombres()%>">
                   
                </div>
                <div class="form-group">
                    <label for="apellidos">Nombres</label>
                    <input type="text" class="form-control" id="apellidos" name="apellidos" value="<%=us.getApellidos()%>">
                </div>
                <div class="form-group">
                    <label for="username">Nick</label>
                    <input type="text" class="form-control" id="username" name="username" value="<%=us.getUser_name() %>">
                </div>
       
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" value="<%=us.getEmail() %>">
                </div>
              
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" value="<%=us.getPassword()%>">
                </div>
                <div class="form-group">
                    <label for="tipo">Tipo de usuario</label>
                    <select class="form-control" id="tipo" name="tipo">
                         <% 
                        tipousuarioDAO dao2=new tipousuarioDAO();
                        List<tipousuario> list=dao2.listar();
                        Iterator<tipousuario>iter=list.iterator();
                        tipousuario tipo= null;
                        System.out.println("LLEGANDO A PAGINA JSP");
                        while (iter.hasNext()) 
                        {
                            System.out.println("LLEGANDO A PAGINA JSP WHILE");
                            tipo=iter.next();

                        %>
                        <option value="<%=tipo.getId_tipo() %>"><%=tipo.getNombre() %></option>
                      <% } %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="foto">URL foto</label>
                    <input type="text" class="form-control" id="foto" name="foto" value="<%=us.getFoto()%>">
                </div>
                <div class="form-group">
                    <input name="accion" value="Actualizar" type="submit" id="accion" class="btn btn-success btn-block">

                </div>
              
          </form>
          
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

