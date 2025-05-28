package org.anderson.manejosesiones.repositorio;

import org.anderson.manejosesiones.models.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//va hacer imolementada por un clase de tipo categoria
public class CategoriaRepositoryJdbsImplement implements Repository<Categoria>{

    //creamos un avariable donde vamos a guardar la conexion de tipo privada
    private Connection conn;
    public CategoriaRepositoryJdbsImplement(Connection conn) {//resive la conexion de la variable
        this.conn = conn;//obtengo la conexion
    }
    @Override
    public List <Categoria> Listar() throws SQLException {
        //generamos un tipo de objeto categoria
        List<Categoria> categorias = new ArrayList<>();
        try(Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM categoria");//me permite ejecutar a base al statement un query
            while (rs.next()) {
                Categoria c = getCategoria(rs);
                categorias.add(c);
            }
        }
        return categorias;
    }

    @Override
    public Categoria porId(int id) throws SQLException {
        //creo un objeto tipo categoria null
        Categoria categoria = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM categoria WHERE id = ?")) {
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                categoria = getCategoria(rs);
            }
        }
        return categoria;
    }

    @Override
    public void guardar(Categoria categoria) throws SQLException {
        //Declaro una variable de tipo String
        String sql;
        if(categoria.getIdCategoria() > 0) {
            sql ="update categoria set nombre = ?, descripcion = ? where idCategoria = ?";
        }else{
            sql="insert into categoria(nombre, descripcion, condision) values (?, ?, 1)";
        }
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNombre());
            stmt.setString(2, categoria.getDescripcion());
            stmt.setInt(3, categoria.getIdCategoria());
        }
    }


    @Override
    public void eliminar(int id) throws SQLException {

    }

    private static Categoria getCategoria(ResultSet rs) throws SQLException {
        Categoria c = new Categoria();
        c.setNombre(rs.getString("nombre"));
        c.setDescripcion(rs.getString("descripcion"));
        c.setCondicion(rs.getInt("condicion"));
        c.setIdCategoria(rs.getInt("idCategoria"));
        return c;
    }

}