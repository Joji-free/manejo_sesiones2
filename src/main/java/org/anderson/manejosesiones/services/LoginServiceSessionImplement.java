package org.anderson.manejosesiones.services;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class LoginServiceSessionImplement implements LoginService {
    @Override
    public Optional<String> getUserName(HttpServletRequest request){
        //Obetenemos la session
        HttpSession session = request.getSession();
        //Combierte los datos de la session en un string
        String username = (String)session.getAttribute("username");
        /*Creo una condision en la cual valido si al obtener el nombre usuario
        Es dsitinto de nulo
        Obtengo el username
        Caso contrario devuelvo la session vacia
        * */
        if(username != null){
            return Optional.of(username);
        }
        return Optional.empty();
    }
}
