package pe.edu.upeu.mssistemaventas.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.mssistemaventas.entity.Cliente;
import pe.edu.upeu.mssistemaventas.repository.ClienteRepository;
import pe.edu.upeu.mssistemaventas.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public Cliente create(Cliente c) {
        return repository.save(c);
    }

    @Override
    public Cliente update(Cliente c) {
        return repository.save(c);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Cliente> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Cliente> readAll() {
        return repository.findAll();
    }
}
