package pe.edu.upeu.mssistemaventas.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.mssistemaventas.entity.Producto;
import pe.edu.upeu.mssistemaventas.repository.ProductoRepository;
import pe.edu.upeu.mssistemaventas.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repository;

    @Override
    public Producto create(Producto p) {
        return repository.save(p);
    }

    @Override
    public Producto update(Producto p) {
        return repository.save(p);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Producto> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Producto> readAll() {
        return repository.findAll();
    }
}
