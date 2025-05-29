package org.anderson.manejosesiones.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.anderson.manejosesiones.models.Categoria;
import org.anderson.manejosesiones.services.CategoriaService;
import org.anderson.manejosesiones.services.CategoriaServiceJdbcImplement;
import org.anderson.manejosesiones.services.LoginService;
import org.anderson.manejosesiones.services.LoginServiceSessionImplement;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;


@WebServlet("/categoria")
public class CategoriaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtenemos la conexión a la base de datos desde el atributo de la solicitud
        Connection conn = (Connection) req.getAttribute("conn");

        // Creamos una instancia del servicio de categorías con la conexión actual
        CategoriaService service = new CategoriaServiceJdbcImplement(conn);

        // Obtenemos la lista de todas las categorías desde la base de datos
        List<Categoria> categorias = service.listar();

        // Creamos una instancia del servicio de autenticación para obtener el nombre del usuario actual
        LoginService auth = new LoginServiceSessionImplement();
        Optional<String> userName = auth.getUserName(req);

        // Establecemos la lista de categorías como atributo de la solicitud para enviarla a la vista
        req.setAttribute("categorias", categorias);

        // Establecemos el nombre del usuario como atributo de la solicitud (si está presente)
        req.setAttribute("username", userName);

        // Redirigimos la solicitud y la respuesta a la vista JSP que mostrará las categorías
        getServletContext().getRequestDispatcher("/categorialistar.jsp").forward(req, resp);
    }
}