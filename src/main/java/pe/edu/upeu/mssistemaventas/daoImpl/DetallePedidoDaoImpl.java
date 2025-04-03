package pe.edu.upeu.mssistemaventas.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.mssistemaventas.dao.DetallePedidoDao;
import pe.edu.upeu.mssistemaventas.entity.DetallePedido;
import pe.edu.upeu.mssistemaventas.repository.DetallePedidoRepository;

@Component
public class DetallePedidoDaoImpl implements DetallePedidoDao {
    @Autowired
    private DetallePedidoRepository repository;

    @Override
    public DetallePedido create(DetallePedido dp) {
        return repository.save(dp);
    }

    @Override
    public DetallePedido update(DetallePedido dp) {
        return repository.save(dp);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<DetallePedido> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<DetallePedido> readAll() {
        return repository.findAll();
    }
}
