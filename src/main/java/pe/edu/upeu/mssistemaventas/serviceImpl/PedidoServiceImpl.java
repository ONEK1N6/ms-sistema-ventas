package pe.edu.upeu.mssistemaventas.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.mssistemaventas.entity.Pedido;
import pe.edu.upeu.mssistemaventas.repository.PedidoRepository;
import pe.edu.upeu.mssistemaventas.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

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
