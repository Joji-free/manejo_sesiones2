package org.anderson.manejosesiones.services;

import org.anderson.manejosesiones.models.Productos;

import java. util.Arrays;
import java.util.List;

public class ProductoServiceImplement implements ProductoService {

    @Override
    public List<Productos> listar() {
        return Arrays.asList(new Productos(1L,"laptop","computacion", 523.21),
                new Productos( 2L ,"Mouse", "inalambrico", 15.25),
                new Productos(3L, "Impresora", "tinta continua", 256.25));
    }
}