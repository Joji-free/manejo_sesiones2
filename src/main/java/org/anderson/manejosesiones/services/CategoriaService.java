package org.anderson.manejosesiones.services;


import org.anderson.manejosesiones.models.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    // Método para obtener la lista de productos
    List<Categoria>listar();
    Optional<Categoria> porId(Long id);
}
