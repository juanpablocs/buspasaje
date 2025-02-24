package pe.cibertec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cibertec.enums.EstadoReserva;
import pe.cibertec.models.InformacionBus;
import pe.cibertec.models.Reserva;
import pe.cibertec.repository.InformacionBusRepository;
import pe.cibertec.repository.ReservaRepository;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final InformacionBusRepository busRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository, InformacionBusRepository busRepository) {
        this.reservaRepository = reservaRepository;
        this.busRepository = busRepository;
    }

    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Reserva getReservaById(Integer id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con ID: " + id));
    }

    public Reserva saveReserva(Reserva reserva) {
        InformacionBus bus = busRepository.findById(reserva.getBus().getBusId())
                .orElseThrow(() -> new RuntimeException("Bus no encontrado"));

        // Validar si hay suficientes asientos disponibles
        if (reserva.getTotalBoletos() > bus.getAsientosDisponibles()) {
            throw new RuntimeException("No hay suficientes asientos disponibles para este bus. Asientos disponibles: " 
                + bus.getAsientosDisponibles() + ", Boletos solicitados: " + reserva.getTotalBoletos());
        }

        // Actualizar los asientos reservados y disponibles
        bus.setAsientosReservados(bus.getAsientosReservados() + reserva.getTotalBoletos());
        bus.setAsientosDisponibles(bus.getTotalAsientos() - bus.getAsientosReservados());

        // Guardar cambios en el bus
        busRepository.save(bus);

        // Guardar la reserva
        return reservaRepository.save(reserva);
    }

    public Reserva updateReserva(Integer id, Reserva reservaActualizada) {
        Reserva reserva = getReservaById(id);
        InformacionBus bus = reserva.getBus();

        // Revertir los asientos previamente reservados
        bus.setAsientosReservados(bus.getAsientosReservados() - reserva.getTotalBoletos());
        bus.setAsientosDisponibles(bus.getTotalAsientos() - bus.getAsientosReservados());

        // Validar si la nueva cantidad de boletos es posible
        if (reservaActualizada.getTotalBoletos() > bus.getAsientosDisponibles()) {
            throw new RuntimeException("No hay suficientes asientos disponibles para la nueva cantidad de boletos. Asientos disponibles: " 
                + bus.getAsientosDisponibles() + ", Boletos solicitados: " + reservaActualizada.getTotalBoletos());
        }

        // Actualizar la reserva con los nuevos datos
        reserva.setFechaReserva(reservaActualizada.getFechaReserva());
        reserva.setSalida(reservaActualizada.getSalida());
        reserva.setTotalBoletos(reservaActualizada.getTotalBoletos());
        reserva.setTarifaTotal(reservaActualizada.getTarifaTotal());
        reserva.setEstado(reservaActualizada.getEstado());

        // Aplicar los nuevos cambios de asientos
        bus.setAsientosReservados(bus.getAsientosReservados() + reserva.getTotalBoletos());
        bus.setAsientosDisponibles(bus.getTotalAsientos() - bus.getAsientosReservados());

        // Guardar cambios
        busRepository.save(bus);
        return reservaRepository.save(reserva);
    }

    public void deleteReserva(Integer id) {
        Reserva reserva = getReservaById(id);
        InformacionBus bus = reserva.getBus();

        // Revertir los asientos reservados
        bus.setAsientosReservados(bus.getAsientosReservados() - reserva.getTotalBoletos());
        bus.setAsientosDisponibles(bus.getTotalAsientos() - bus.getAsientosReservados());

        // Guardar cambios en el bus
        busRepository.save(bus);

        // Eliminar la reserva
        reservaRepository.deleteById(id);
    }

    public Reserva actualizarEstado(Integer id, EstadoReserva nuevoEstado) {
        Reserva reserva = getReservaById(id);
        reserva.setEstado(nuevoEstado);
        return reservaRepository.save(reserva);
    }
}
