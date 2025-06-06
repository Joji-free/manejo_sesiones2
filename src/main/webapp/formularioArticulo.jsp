<%@ page contentType="text/html;charset=UTF-8" language="java" import="org.anderson.manejosesiones.models.Articulo, org.anderson.manejosesiones.models.Categoria, java.util.List" %>
<%
  Articulo articulo = (Articulo) request.getAttribute("articulo");
  if (articulo == null) {
    articulo = new Articulo();
  }

  List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");

  String errorNombre = (String) request.getAttribute("errorNombre");
  String errorCodigo = (String) request.getAttribute("errorCodigo");
  String errorStock = (String) request.getAttribute("errorStock");
  String errorCategoria = (String) request.getAttribute("errorCategoria");
  String errorDescripcion = (String) request.getAttribute("errorDescripcion");
  String errorImagen = (String) request.getAttribute("errorImagen");
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title><%= (articulo.getIdArticulo() != null && articulo.getIdArticulo() > 0) ? "Editar Artículo" : "Nuevo Artículo" %></title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h2 class="mb-4"><%= (articulo.getIdArticulo() != null && articulo.getIdArticulo() > 0) ? "Editar Artículo" : "Nuevo Artículo" %></h2>

<form action="<%= request.getContextPath() %>/articulo/form" method="post" class="needs-validation" novalidate>
  <input type="hidden" name="idArticulo" value="<%=articulo.getIdArticulo()%>">

  <!-- Categoría -->
  <div class="mb-3">
    <label for="idCategoria" class="form-label">Categoría:</label>
    <select id="idCategoria" name="idCategoria" class="form-select <%= (errorCategoria != null) ? "is-invalid" : "" %>">
      <option value="">-- Seleccione --</option>
      <% for (Categoria cat : categorias) { %>
      <option value="<%=cat.getIdCategoria()%>"
              <%= articulo.getIdCategoria() != null && articulo.getIdCategoria().equals(cat.getIdCategoria()) ? "selected" : "" %>>
        <%=cat.getNombre()%>
      </option>
      <% } %>
    </select>
    <% if (errorCategoria != null) { %>
    <div class="invalid-feedback d-block"><%= errorCategoria %></div>
    <% } %>
  </div>

  <!-- Código -->
  <div class="mb-3">
    <label for="codigo" class="form-label">Código:</label>
    <input type="text" id="codigo" name="codigo" class="form-control <%= (errorCodigo != null) ? "is-invalid" : "" %>" value="<%= articulo.getCodigo() != null ? articulo.getCodigo() : "" %>">
    <% if (errorCodigo != null) { %>
    <div class="invalid-feedback d-block"><%= errorCodigo %></div>
    <% } %>
  </div>

  <!-- Nombre -->
  <div class="mb-3">
    <label for="nombre" class="form-label">Nombre:</label>
    <input type="text" id="nombre" name="nombre" class="form-control <%= (errorNombre != null) ? "is-invalid" : "" %>" value="<%= articulo.getNombre() != null ? articulo.getNombre() : "" %>">
    <% if (errorNombre != null) { %>
    <div class="invalid-feedback d-block"><%= errorNombre %></div>
    <% } %>
  </div>

  <!-- Stock -->
  <div class="mb-3">
    <label for="stock" class="form-label">Stock:</label>
    <input type="number" id="stock" name="stock" class="form-control <%= (errorStock != null) ? "is-invalid" : "" %>" value="<%= articulo.getStock() != null ? articulo.getStock() : 0 %>" min="0">
    <% if (errorStock != null) { %>
    <div class="invalid-feedback d-block"><%= errorStock %></div>
    <% } %>
  </div>

  <!-- Descripción -->
  <div class="mb-3">
    <label for="descripcion" class="form-label">Descripción:</label>
    <textarea id="descripcion" name="descripcion" class="form-control <%= (errorDescripcion != null) ? "is-invalid" : "" %>"><%= articulo.getDescripcion() != null ? articulo.getDescripcion() : "" %></textarea>
    <% if (errorDescripcion != null) { %>
    <div class="invalid-feedback d-block"><%= errorDescripcion %></div>
    <% } %>
  </div>

  <!-- Imagen -->
  <div class="mb-3">
    <label for="imagen" class="form-label">Imagen (URL):</label>
    <input type="text" id="imagen" name="imagen" class="form-control <%= (errorImagen != null) ? "is-invalid" : "" %>" value="<%= articulo.getImagen() != null ? articulo.getImagen() : "" %>">
    <% if (errorImagen != null) { %>
    <div class="invalid-feedback d-block"><%= errorImagen %></div>
    <% } %>
  </div>

  <!-- Estado -->
  <div class="mb-4">
    <label class="form-label d-block">Estado:</label>
    <div class="form-check form-check-inline">
      <input class="form-check-input" type="radio" id="activo" name="condicion" value="1" <%= articulo.isCondicion() ? "checked" : "" %>>
      <label class="form-check-label" for="activo">Activo</label>
    </div>
    <div class="form-check form-check-inline">
      <input class="form-check-input" type="radio" id="inactivo" name="condicion" value="0" <%= !articulo.isCondicion() ? "checked" : "" %>>
      <label class="form-check-label" for="inactivo">Inactivo</label>
    </div>
  </div>

  <!-- Botones -->
  <div class="d-flex gap-2">
    <button type="submit" class="btn btn-primary">
      <%= (articulo.getIdArticulo()!=null && articulo.getIdArticulo()>0) ? "Editar" : "Crear" %>
    </button>
    <a href="<%= request.getContextPath() %>/articulo" class="btn btn-secondary">Cancelar</a>
  </div>
</form>

</body>
</html>
