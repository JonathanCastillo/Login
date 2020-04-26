<%-- 
    Document   : add_products.jsp
    Created on : 04-09-2020, 09:21:42 AM
    Author     : JonaC
--%>

<%@page import="model.categorias"%>
<%@page import="modelDAO.categoriasDAO"%>
<%@page import="model.proveedores"%>
<%@page import="java.util.Iterator"%>
<%@page import="interfaces.proveedor"%>
<%@page import="java.util.List"%>
<%@page import="modelDAO.proveedoresDAO"%>
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
   
      <div class="col-8">
          <h1>Agregar un usuario</h1> 
          <form action="products?accion=Guardar" method="POST" class="col-12" enctype="multipart/form-data">
              <div class="card">
                <div class="card-header">
                  <h1>Agregar un producto</h1> 
                </div>
                <div class="card-body">
                    <div class="form-group">
                    <label for="nombre">Nombre de producto</label>
                    <input type="text" class="form-control" id="nombre" name="nombres">
                    </div>
                    <div class="form-group">
                    <label for="nombres">Imagen del producto</label>
                    <input type="file" class="form-control" name="fileImagen">
                    </div>
                    <div class="form-group">
                    <label for="nombres">Descripcion</label>
                    <textarea type="textarea" class="form-control" id="nombres" name="nombres"></textarea>
                    </div>
                     <div class="form-group">
                    <label for="nombres">Precio de compra</label>
                    <input value="" type="number" step="any"  class="form-control" name="pcompra">
                    </div>
                    <div class="form-group">
                    <label for="nombres">Precio de venta</label>
                    <input value="" type="number" step="any" class="form-control" name="pventa">
                    </div>
                    <div class="form-group">
                    <label for="stock">Stock</label>
                    <input value="" type="number" step="any" class="form-control" name="stock">
                    </div>
                    <div class="form-group">
                    <label for="nombres">Disponible</label>
                    <select class="form-control" name="disponible">
                        <option value="Si">Si</option>
                        <option value="No">No</option>
                    </select>
                    </div>
                    <div class="form-group">
                    <label for="proveedor">Proveedor</label>
                    <select class="form-control" name="proveedor">
                         <% 
                        proveedoresDAO dao=new proveedoresDAO();
                        List<proveedores> list=dao.listar();
                        //Asignamos valores del modelo
                        Iterator<proveedores>iter=list.iterator();
                        //Clase proveedores
                        proveedores pro= null;
                        System.out.println("LLEGANDO A PAGINA JSP");
                        while (iter.hasNext()) 
                        {
                            System.out.println("LLEGANDO A PAGINA JSP WHILE");
                            pro=iter.next();

                        %>
                        <option value="<%=pro.getId_proveedor()%>"><%=pro.getEmpresa()%></option>
                      <% } %>
                    </select>
                    </div>
                    <div class="form-group">
                    <label for="categoria">Categoria</label>
                    <select class="form-control" name="categoria">
                          <% 
                        categoriasDAO dao2=new categoriasDAO();
                        List<categorias> list2=dao2.listar();
                        //Asignamos valores del modelo
                        Iterator<categorias>iter2=list2.iterator();
                        //Clase proveedores
                        categorias cat= null;
                        System.out.println("LLEGANDO A PAGINA JSP");
                        while (iter2.hasNext()) 
                        {
                            System.out.println("LLEGANDO A PAGINA JSP WHILE");
                            cat=iter2.next();

                        %>
                        <option value="<%=cat.getId_categoria()%>"><%=cat.getNombre_categoria()%></option>
                      <% } %>
                    </select>
                    </div>
                    
                </div>
                <div class="card-footer">
                   <div class="form-group">
                       <button name="accion" value="Guardar" type="submit" id="accion" class="btn btn-success btn-block">CREAR PRODUCTO</button>
                   </div>
                </div>
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
    <jsp:include page="../../components/footer.jsp"/>  
</html>