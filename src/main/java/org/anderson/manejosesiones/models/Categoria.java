package org.anderson.manejosesiones.models;


// Clase que representa una categoría con sus atributos básicos
public class Categoria {
    //Implementamos e inicializamos las variables de objet
    //encapsulamos
    private Integer idCategoria;
    private String nombre;
    private String descripcion;
    private int condicion;
    public Categoria(){

    }
    public Categoria(Integer idCategoria, String nombre, String descripcion, int condicion) {
        this.idCategoria = idCategoria;
        this.nombre= nombre;
        this.descripcion = descripcion;
        this.condicion = condicion;
    }
    //Implementamos los metodos get and set

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCondicion() {
        return condicion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }
}
