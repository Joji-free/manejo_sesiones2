package org.anderson.manejosesiones.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.anderson.manejosesiones.models.Productos;
import org.anderson.manejosesiones.services.LoginService;
import org.anderson.manejosesiones.services.LoginServiceSessionImplement;
import org.anderson.manejosesiones.services.ProductoService;
import org.anderson.manejosesiones.services.ProductoServiceImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet("/productos")
public class ProductosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        LoginService auth = new LoginServiceSessionImplement();
        Optional<String> usernameOptional = auth.getUserName(req);
        ProductoService service = new ProductoServiceImplement();
        List<Productos> productos = service.listar();

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.print("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Productos</title>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css'>");
        out.println("</head>");
        out.println("<body>");

        // Contenedor principal con menú lateral
        out.println("<div class='d-flex'>");

        // Sidebar
        out.println("<div class='bg-light p-3' style='min-width: 200px; height: 100vh;'>");
        out.println("<h4 class='text-primary mb-4'>AndyProductos</h4>");
        out.println("<ul class='nav flex-column'>");
        out.println("<li class='nav-item'><a class='nav-link' href='categoria'><i class='bi bi-speedometer2'></i> Escritorio</a></li>");
        out.println("<li class='nav-item'><a class='nav-link' href='logout'><i class='bi bi-box-arrow-in-right'></i> Logout</a></li>");
        out.println("</ul>");
        out.println("</div>");

        // Contenido principal
        out.println("<div class='container-fluid p-5'>");

        // Encabezado
        out.println("<div class='d-flex justify-content-between align-items-center mb-4'>");
        out.println("<h2><i class='bi bi-box-seam'></i> Productos</h2>");
        if (usernameOptional.isPresent()) {
            out.println("<span class='badge text-bg-success'>Bienvenido, " + usernameOptional.get() + "</span>");
        }
        out.println("</div>");

        // Tabla de productos
        out.println("<table class='table table-bordered table-hover'>");
        out.println("<thead class='table-primary'>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Nombre</th>");
        out.println("<th>Categoría</th>");
        out.println("<th>Precio</th>");
        out.println("<th>Opciones</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        for (Productos p : productos) {
            out.println("<tr>");
            out.println("<td>" + p.getIdProducto() + "</td>");
            out.println("<td>" + p.getNombreProducto() + "</td>");
            out.println("<td>" + p.getCategoria() + "</td>");
            out.println("<td>$" + p.getPrecioProducto() + "</td>");
            out.println("<td>");
            out.println("<a href='editarProducto?id=" + p.getIdProducto() + "' class='btn btn-warning btn-sm me-1'><i class='bi bi-pencil'></i> Editar</a>");
            out.println("<a href='cambiarEstado?id=" + p.getIdProducto() + "&estado=0' class='btn btn-secondary btn-sm'>Desactivar</a>");
            out.println("<a href='cambiarEstado?id=" + p.getIdProducto() + "&estado=1' class='btn btn-success btn-sm'>Activar</a>");

            out.println("</td>");
            out.println("</td>");
            out.println("</tr>");
        }

        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>"); // Fin contenido principal
        out.println("</div>"); // Fin flex

        out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'></script>");
        out.println("</body>");
        out.println("</html>");
    }
}