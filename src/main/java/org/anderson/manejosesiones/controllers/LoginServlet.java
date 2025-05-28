package org.anderson.manejosesiones.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.anderson.manejosesiones.services.LoginService;
import org.anderson.manejosesiones.services.LoginServiceSessionImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

// Definición del Servlet que manejará las rutas /login y /login.html
@WebServlet({"/login", "/login.html"})
public class LoginServlet extends HttpServlet {

    final static String USERNAME = "admin";
    final static String PASSWORD = "1234";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        LoginService auth = new LoginServiceSessionImplement();
        Optional<String> usernameOptional = auth.getUserName(req);

        if (usernameOptional.isPresent()) {
            resp.setContentType("text/html;charset=UTF-8");

            try (PrintWriter out = resp.getWriter()) {
                out.print("<!DOCTYPE html>");
                out.println("<html lang='es'>");
                out.println("<head>");
                out.println("<meta charset='UTF-8'>");
                out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
                out.println("<title>Bienvenido " + usernameOptional.get() + "</title>");
                out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
                out.println("</head>");
                out.println("<body>");

                out.println("<div class='container mt-5'>");
                out.println("<div class='alert alert-success text-center'>");
                out.println("<h1 class='mb-3'>¡Hola, " + usernameOptional.get() + "!</h1>");
                out.println("<p>Ya iniciaste sesión anteriormente. </p>");
                out.println("<a href='index.html' class='btn btn-primary mt-3'>Volver al inicio</a>");
                out.println("</div>");
                out.println("</div>");

                out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'></script>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            // Usuario no autenticado, mostrar login.jsp
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("login.html");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos, no tiene acceso.");
        }
    }
}