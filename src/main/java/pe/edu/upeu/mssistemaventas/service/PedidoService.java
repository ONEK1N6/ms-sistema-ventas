package pe.edu.upeu.mssistemaventas.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.mssistemaventas.entity.Pedido;

public interface PedidoService {
    Pedido create(Pedido p);
    Pedido update(Pedido p);
    void delete(Long id);
    Optional<Pedido> read(Long id);
    List<Pedido> readAll();
}
