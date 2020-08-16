<%-- 
    Document   : menu_cliente
    Created on : 04-10-2020, 03:23:30 PM
    Author     : JonaC
--%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="user?accion=chome">GLAUDEM</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="user?accion=chome">Inicio <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Categorias
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="user?accion=listar">Categorias</a>
          <a class="dropdown-item" href="user?accion=agregar">Crear usuarios</a>
          <div class="dropdown-divider"></div>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Carrito
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Servicios</a>
          <a class="dropdown-item" href="#">Registrar venta</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Estadisticas</a>
        </div>
    
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Comprar</a>
      </li>
     
       <li class="nav-item">
        <a class="nav-link" href="login?accion=salir" tabindex="-1" aria-disabled="true">Cerrar Sesion</a>
      </li>
     
    </ul>
      <ul class="navbar-text">
           
       </ul>
      
      <span class="navbar-text">
      ${usuario}
    </span>
    <form class="form-inline my-2 my-lg-0" action="products">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="TxtBuscar">
      <input name="accion" value="Search" type="submit" id="accion" class="btn btn-outline-success my-2 my-sm-0">

    </form>
     <li class="nav-link">
          <svg id="navicons" class="bi bi-cart-fill" width="22px" height="22px" viewBox="0 0 16 16" fill="#28a745" xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd" d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm7 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"/>
            </svg>
            <span style="color: white;">( </span><label style="color: #ffc107;">${count}</label><span  style="color: white;"> )</span>
       </li>
       <li class="nav-link" id="cartlbl">
            <a class="nav-link" href="products?accion=carrito" tabindex="-1" aria-disabled="true">Carrito</a>
       </li>
 
  </div>
</nav>