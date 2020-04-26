
<%-- 
    Document   : newjsp
    Created on : 04-10-2020, 02:54:29 PM
    Author     : JonaC
--%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="user?accion=home">JSTORE</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
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
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>