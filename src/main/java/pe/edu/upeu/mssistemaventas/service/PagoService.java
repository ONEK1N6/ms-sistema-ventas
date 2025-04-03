package pe.edu.upeu.mssistemaventas.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.mssistemaventas.entity.Pago;

public interface PagoService {
    Pago create(Pago p);
    Pago update(Pago p);
    void delete(Long id);
    Optional<Pago> read(Long id);
    List<Pago> readAll();
}
