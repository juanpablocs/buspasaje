package pe.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.cibertec.models.Pasaje;

@Repository
public interface PasajeRepository extends JpaRepository<Pasaje, Integer> {
}
