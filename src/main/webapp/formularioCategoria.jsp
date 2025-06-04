<%@ page contentType="text/html;charset=UTF-8" language="java" import="org.anderson.manejosesiones.models.Categoria" %>
<%
  Categoria categoria = (Categoria) request.getAttribute("categorias");
  if (categoria == null) {
    categoria = new Categoria(); // categoría vacía para creación
  }

  // Obtener errores de validación si existen
  String errorNombre = (String) request.getAttribute("errorNombre");
  String errorDescripcion = (String) request.getAttribute("errorDescripcion");
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title><%= (categoria.getIdCategoria() != null && categoria.getIdCategoria() > 0) ? "Editar Categoría" : "Nueva Categoría" %></title>
  <!-- Bootstrap 5 CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
  <h2 class="mb-4"><%= (categoria.getIdCategoria() != null && categoria.getIdCategoria() > 0) ? "Editar Categoría" : "Nueva Categoría" %></h2>

  <form action="<%= request.getContextPath() %>/categoria/form" method="post">
    <input type="hidden" name="id" value="<%=categoria.getIdCategoria()%>">

    <div class="mb-3">
      <label for="nombre" class="form-label">Nombre:</label>
      <input type="text" class="form-control <%= errorNombre != null ? "is-invalid" : "" %>" id="nombre" name="nombre"
             value="<%= categoria.getNombre() != null ? categoria.getNombre() : "" %>">
      <% if (errorNombre != null) { %>
      <div class="invalid-feedback">
        <%= errorNombre %>
      </div>
      <% } %>
    </div>

    <div class="mb-3">
      <label for="descripcion" class="form-label">Descripción:</label>
      <textarea class="form-control <%= errorDescripcion != null ? "is-invalid" : "" %>" id="descripcion" name="descripcion"><%= categoria.getDescripcion() != null ? categoria.getDescripcion() : "" %></textarea>
      <% if (errorDescripcion != null) { %>
      <div class="invalid-feedback">
        <%= errorDescripcion %>
      </div>
      <% } %>
    </div>

    <div class="d-flex gap-2">
      <button type="submit" class="btn btn-primary">
        <%= (categoria.getIdCategoria() != null && categoria.getIdCategoria() > 0) ? "Editar" : "Crear" %>
      </button>
      <a href="<%= request.getContextPath() %>/categoria" class="btn btn-secondary">Cancelar</a>
    </div>
  </form>
</div>

<!-- Bootstrap JS (opcional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
