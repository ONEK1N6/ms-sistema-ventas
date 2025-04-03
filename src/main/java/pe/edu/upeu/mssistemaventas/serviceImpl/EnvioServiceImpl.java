package pe.edu.upeu.mssistemaventas.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.mssistemaventas.entity.Envio;
import pe.edu.upeu.mssistemaventas.repository.EnvioRepository;
import pe.edu.upeu.mssistemaventas.service.EnvioService;

@Service
public class EnvioServiceImpl implements EnvioService {

    @Autowired
    private EnvioRepository repository;

    @Override
    public Envio create(Envio e) {
        return repository.save(e);
    }

    @Override
    public Envio update(Envio e) {
        return repository.save(e);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Envio> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Envio> readAll() {
        return repository.findAll();
    }
}
