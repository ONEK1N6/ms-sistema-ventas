package pe.edu.upeu.mssistemaventas.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.mssistemaventas.entity.Producto;

public interface ProductoService {
    Producto create(Producto p);
    Producto update(Producto p);
    void delete(Long id);
    Optional<Producto> read(Long id);
    List<Producto> readAll();
}
