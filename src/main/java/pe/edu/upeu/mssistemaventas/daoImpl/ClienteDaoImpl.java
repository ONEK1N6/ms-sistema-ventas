package pe.edu.upeu.mssistemaventas.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.mssistemaventas.dao.ClienteDao;
import pe.edu.upeu.mssistemaventas.entity.Cliente;
import pe.edu.upeu.mssistemaventas.repository.ClienteRepository;

@Component
public class ClienteDaoImpl implements ClienteDao {
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
