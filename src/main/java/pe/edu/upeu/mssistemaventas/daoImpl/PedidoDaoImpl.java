package pe.edu.upeu.mssistemaventas.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.mssistemaventas.dao.PedidoDao;
import pe.edu.upeu.mssistemaventas.entity.Pedido;
import pe.edu.upeu.mssistemaventas.repository.PedidoRepository;

@Component
public class PedidoDaoImpl implements PedidoDao {
    @Autowired
    private PedidoRepository repository;

    @Override
    public Pedido create(Pedido p) {
        return repository.save(p);
    }

    @Override
    public Pedido update(Pedido p) {
        return repository.save(p);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Pedido> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Pedido> readAll() {
        return repository.findAll();
    }
}
