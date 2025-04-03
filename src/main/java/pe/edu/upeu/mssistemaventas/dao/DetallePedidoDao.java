package pe.edu.upeu.mssistemaventas.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.mssistemaventas.entity.DetallePedido;

public interface DetallePedidoDao {
    DetallePedido create(DetallePedido dp);
    DetallePedido update(DetallePedido dp);
    void delete(Long id);
    Optional<DetallePedido> read(Long id);
    List<DetallePedido> readAll();
}
