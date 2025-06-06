<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*, org.anderson.manejosesiones.models.*" %>
<%
  List<Articulo> articulos = (List<Articulo>) request.getAttribute("articulos");
  Optional<String> username = (Optional<String>) request.getAttribute("username");
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Listado Artículos</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<% if (username.isPresent()) { %>
<div class="alert alert-primary">
  Hola <strong><%= username.get() %></strong>, bienvenido a la aplicación.
</div>
<div class="mb-3">
  <a href="<%= request.getContextPath() %>/articulo/form" class="btn btn-success">Crear nuevo artículo</a>
</div>
<% } %>

<h2 class="mb-4">Listado de Artículos</h2>

<table class="table table-bordered table-striped align-middle">
  <thead class="table-dark">
  <tr>
    <th>ID</th>
    <th>Código</th>
    <th>Nombre</th>
    <th>Categoría</th>
    <th>Stock</th>
    <th>Estado</th>
    <th>Acciones</th>
  </tr>
  </thead>
  <tbody>
  <% for (Articulo art : articulos) { %>
  <tr>
    <td><%= art.getIdArticulo() %></td>
    <td><%= art.getCodigo() %></td>
    <td><%= art.getNombre() %></td>
    <td><%= art.getIdCategoria() %></td>
    <td><%= art.getStock() %></td>
    <td>
          <span class="badge <%= art.isCondicion() ? "bg-success" : "bg-secondary" %>">
            <%= art.isCondicion() ? "Activo" : "Inactivo" %>
          </span>
    </td>
    <td>
      <a href="<%=request.getContextPath()%>/articulo/form?id=<%=art.getIdArticulo()%>" class="btn btn-sm btn-warning">Editar</a>
      <a href="<%=request.getContextPath()%>/articulo/cambiar-estado?id=<%=art.getIdArticulo()%>&estado=<%=art.isCondicion()%>"
         class="btn btn-sm <%= art.isCondicion() ? "btn-danger" : "btn-success" %>">
        <%= art.isCondicion() ? "Desactivar" : "Activar" %>
      </a>
    </td>
  </tr>
  <% } %>
  </tbody>
</table>

</body>
</html>
