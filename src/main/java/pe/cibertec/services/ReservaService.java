package pe.cibertec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cibertec.models.Reserva;
import pe.cibertec.repository.ReservaRepository;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Reserva getReservaById(Integer id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con ID: " + id));
    }

    public Reserva saveReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva updateReserva(Integer id, Reserva reservaActualizada) {
        Reserva reserva = getReservaById(id);
        reserva.setFechaReserva(reservaActualizada.getFechaReserva());
        reserva.setSalida(reservaActualizada.getSalida());
        reserva.setTotalBoletos(reservaActualizada.getTotalBoletos());
        reserva.setTarifaTotal(reservaActualizada.getTarifaTotal());
        reserva.setEstado(reservaActualizada.getEstado());
        return reservaRepository.save(reserva);
    }

    public void deleteReserva(Integer id) {
        reservaRepository.deleteById(id);
    }
}
