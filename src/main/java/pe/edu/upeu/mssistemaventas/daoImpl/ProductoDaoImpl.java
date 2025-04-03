package pe.edu.upeu.mssistemaventas.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.mssistemaventas.dao.ProductoDao;
import pe.edu.upeu.mssistemaventas.entity.Producto;
import pe.edu.upeu.mssistemaventas.repository.ProductoRepository;

@Component
public class ProductoDaoImpl implements ProductoDao {
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
