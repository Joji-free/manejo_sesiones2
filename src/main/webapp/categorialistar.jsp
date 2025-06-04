<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*, org.anderson.manejosesiones.models.*" %>
<%
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
    Optional<String> username = (Optional<String>) request.getAttribute("username");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Listado Categoría</title>
    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <% if(username.isPresent()) { %>
    <div class="alert alert-primary">
        Hola <strong><%= username.get() %></strong>, bienvenido a la aplicación.
    </div>
    <div class="mb-3">
        <a href="<%= request.getContextPath() %>/categoria/form" class="btn btn-success">Ingresar Producto</a>
    </div>
    <% } %>

    <h1 class="mb-4">Listado de Categorías</h1>

    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>Id Categoría</th>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Condición</th>
            <th colspan="2" class="text-center">Acciones</th>
        </tr>
        </thead>
        <tbody>
        <% for (Categoria cat : categorias) { %>
        <tr>
            <td><%= cat.getIdCategoria() %></td>
            <td><%= cat.getNombre() %></td>
            <td><%= cat.getDescripcion() %></td>
            <td><%= cat.isCondicion() ? "Activo" : "Inactivo" %></td>
            <td>
                <a href="<%= request.getContextPath() %>/categoria/form?id=<%= cat.getIdCategoria() %>"
                   class="btn btn-sm btn-primary">Editar</a>
            </td>
            <td>
                <a href="<%= request.getContextPath() %>/categoria/cambiar-estado?id=<%= cat.getIdCategoria() %>&estado=<%= cat.isCondicion() %>"
                   class="btn btn-sm <%= cat.isCondicion() ? "btn-danger" : "btn-success" %>">
                    <%= cat.isCondicion() ? "Desactivar" : "Activar" %>
                </a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS (opcional para interactividad) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
