package pe.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.cibertec.models.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
