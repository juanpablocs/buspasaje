package pe.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.cibertec.models.InformacionBus;

@Repository
public interface InformacionBusRepository extends JpaRepository<InformacionBus, Integer> {
}
