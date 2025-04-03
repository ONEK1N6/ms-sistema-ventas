package pe.edu.upeu.mssistemaventas.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.mssistemaventas.entity.Envio;

public interface EnvioDao {
    Envio create(Envio e);
    Envio update(Envio e);
    void delete(Long id);
    Optional<Envio> read(Long id);
    List<Envio> readAll();
}
