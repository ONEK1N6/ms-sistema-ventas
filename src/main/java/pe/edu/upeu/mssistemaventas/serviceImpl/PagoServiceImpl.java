package pe.edu.upeu.mssistemaventas.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.mssistemaventas.entity.Pago;
import pe.edu.upeu.mssistemaventas.repository.PagoRepository;
import pe.edu.upeu.mssistemaventas.service.PagoService;

@Service
public class PagoServiceImpl implements PagoService {

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
