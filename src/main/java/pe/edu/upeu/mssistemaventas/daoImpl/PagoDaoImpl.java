package pe.edu.upeu.mssistemaventas.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.mssistemaventas.dao.PagoDao;
import pe.edu.upeu.mssistemaventas.entity.Pago;
import pe.edu.upeu.mssistemaventas.repository.PagoRepository;

@Component
public class PagoDaoImpl implements PagoDao {
    @Autowired
    private PagoRepository repository;

    @Override
    public Pago create(Pago p) {
        return repository.save(p);
    }

    @Override
    public Pago update(Pago p) {
        return repository.save(p);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Pago> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Pago> readAll() {
        return repository.findAll();
    }
}
