package pe.edu.upeu.mssistemaventas.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.mssistemaventas.entity.DetallePedido;
import pe.edu.upeu.mssistemaventas.repository.DetallePedidoRepository;
import pe.edu.upeu.mssistemaventas.service.DetallePedidoService;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

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
