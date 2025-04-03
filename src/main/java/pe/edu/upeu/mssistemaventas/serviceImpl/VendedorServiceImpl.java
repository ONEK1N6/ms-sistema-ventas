package pe.edu.upeu.mssistemaventas.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.mssistemaventas.entity.Vendedor;
import pe.edu.upeu.mssistemaventas.repository.VendedorRepository;
import pe.edu.upeu.mssistemaventas.service.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService {

    @Autowired
    private VendedorRepository repository;

    @Override
    public Vendedor create(Vendedor v) {
        return repository.save(v);
    }

    @Override
    public Vendedor update(Vendedor v) {
        return repository.save(v);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Vendedor> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Vendedor> readAll() {
        return repository.findAll();
    }
}
