package org.anderson.manejosesiones.controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.anderson.manejosesiones.services.LoginService;
import org.anderson.manejosesiones.services.LoginServiceSessionImplement;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Creamos el objeto de tipo session
        LoginService auth = new LoginServiceSessionImplement();
        Optional<String> userNameOptional = auth.getUserName(req);
        if(userNameOptional.isPresent()){
            HttpSession session = req.getSession();
            //cerramos la session
            session.invalidate();
        }
        resp.sendRedirect(req.getContextPath()+ "/login.html");
    }
}
