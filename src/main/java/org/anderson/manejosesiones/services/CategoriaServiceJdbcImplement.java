package org.anderson.manejosesiones.services;

import org.anderson.manejosesiones.models.Categoria;
import org.anderson.manejosesiones.repositorio.CategoriaRepositoryJdbcImplement;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CategoriaServiceJdbcImplement implements CategoriaService {

    //creamos una variabla de tipo categoria repository jdbs implent
    //creamos una variable de tipo conexion
    private CategoriaRepositoryJdbcImplement repositoryJdbc;
    public CategoriaServiceJdbcImplement(Connection conn) {
        this.repositoryJdbc = new CategoriaRepositoryJdbcImplement(conn);
    }


    @Override
    public List<Categoria> listar() {
        try{
            return repositoryJdbc.listar();
        }catch (SQLException throwables){
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Categoria>porId(Long id) {
        try{
            return Optional.ofNullable(repositoryJdbc.porId(id));
        }catch (SQLException throwables){
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
