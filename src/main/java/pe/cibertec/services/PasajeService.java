package pe.cibertec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cibertec.models.Pasaje;
import pe.cibertec.repository.PasajeRepository;

import java.util.List;

@Service
public class PasajeService {

    private final PasajeRepository pasajeRepository;

    @Autowired
    public PasajeService(PasajeRepository pasajeRepository) {
        this.pasajeRepository = pasajeRepository;
    }

    public List<Pasaje> getAllPasajes() {
        return pasajeRepository.findAll();
    }

    public Pasaje getPasajeById(Integer id) {
        return pasajeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pasaje no encontrado con ID: " + id));
    }

    public Pasaje savePasaje(Pasaje pasaje) {
        return pasajeRepository.save(pasaje);
    }

    public Pasaje updatePasaje(Integer id, Pasaje pasajeActualizado) {
        Pasaje pasaje = getPasajeById(id);
        pasaje.setAsiento(pasajeActualizado.getAsiento());
        pasaje.setFechaVenta(pasajeActualizado.getFechaVenta());
        pasaje.setPrecio(pasajeActualizado.getPrecio());
        return pasajeRepository.save(pasaje);
    }

    public void deletePasaje(Integer id) {
        pasajeRepository.deleteById(id);
    }
}
