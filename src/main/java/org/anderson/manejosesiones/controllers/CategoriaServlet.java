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
        //Creamos la conexion
        Connection conn = (Connection)req.getAttribute("conn");
        //Creamos el nuevo objeto de categorias
        CategoriaService service = new CategoriaServiceJdbcImplement(conn);
        List<Categoria> categorias = service.listar();

        //Obtengo el username
        LoginService auth = new LoginServiceSessionImplement();
        Optional<String> userName= auth.getUserName(req);

        //Seteamos los paramatros
        req.setAttribute("categorias", categorias);
        req.setAttribute("userName", userName);
        //redireccionamos a la vista categoria
        getServletContext().getRequestDispatcher("/categoriaListar.jsp").forward(req, resp);
    }
}
