
<%-- 
    Document   : newjsp
    Created on : 04-10-2020, 02:54:29 PM
    Author     : JonaC
--%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

  <a class="navbar-brand" href="user?accion=home">GLAUDEM</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
        <li>
        <a href="user?accion=home">
        <svg id="navicons" class="bi bi-house-fill" width="22px" height="22px" viewBox="0 0 16 16" fill="#1F2324" xmlns="http://www.w3.org/2000/svg">
        <path fill-rule="evenodd" d="M8 3.293l6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6zm5-.793V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
        <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
        </svg>
    </a>
        </li>
      <li class="nav-item active">
        <a class="nav-link" href="user?accion=home">Inicio <span class="sr-only">(current)</span></a>
      </li>
     
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Productos
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="products?accion=view">Ver productos</a>
          <a class="dropdown-item" href="products?accion=agregar">Nuevo producto</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Dar de baja</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Usuarios
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="user?accion=listar">Ver usuarios</a>
          <a class="dropdown-item" href="user?accion=agregar">Crear usuarios</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Eliminar usuarios</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Ventas
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Ver ventas</a>
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
      <span class="navbar-text">
      ${usuario}
    </span>
    <form class="form-inline my-2 my-lg-0" action="products">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="TxtBuscar">
      <input name="accion" value="Search" type="submit" id="accion" class="btn btn-outline-success my-2 my-sm-0">

    </form>
  </div>
</nav>