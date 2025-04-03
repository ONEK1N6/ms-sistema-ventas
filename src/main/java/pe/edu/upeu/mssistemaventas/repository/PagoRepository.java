package pe.edu.upeu.mssistemaventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.mssistemaventas.entity.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
}
