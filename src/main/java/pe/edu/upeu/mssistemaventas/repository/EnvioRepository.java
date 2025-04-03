package pe.edu.upeu.mssistemaventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.mssistemaventas.entity.Envio;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {
}
