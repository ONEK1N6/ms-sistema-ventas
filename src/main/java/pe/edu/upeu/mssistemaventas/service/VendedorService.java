package pe.edu.upeu.mssistemaventas.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.mssistemaventas.entity.Vendedor;

public interface VendedorService {
    Vendedor create(Vendedor v);
    Vendedor update(Vendedor v);
    void delete(Long id);
    Optional<Vendedor> read(Long id);
    List<Vendedor> readAll();
}
