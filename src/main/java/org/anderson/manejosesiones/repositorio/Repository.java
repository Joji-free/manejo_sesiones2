package org.anderson.manejosesiones.repositorio;

import java.sql.SQLException;
import java.util.List;

/*la variable T es un parametor generico que puede tomar cualquier estado que permite que la interface sea utilizada
 * como se desee o cualquier objeto entidad que se deseee manejar*/
/*<T> Es un parametro generico que me permite que la interfaz sea utilizada como se desee*/
public interface Repository <T>{
    List<T> listar() throws SQLException;
    T porId(Long id) throws SQLException;
    void guardar(T t) throws SQLException;
    void cambiarEstado(Long id, boolean estado) throws SQLException;
    void eliminar(Long id) throws SQLException;
}
