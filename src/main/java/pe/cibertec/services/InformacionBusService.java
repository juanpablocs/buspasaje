package pe.cibertec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cibertec.models.InformacionBus;
import pe.cibertec.repository.InformacionBusRepository;

import java.util.List;

@Service
public class InformacionBusService {

    private final InformacionBusRepository busRepository;

    @Autowired
    public InformacionBusService(InformacionBusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public List<InformacionBus> getAllBuses() {
        return busRepository.findAll();
    }

    public InformacionBus getBusById(Integer id) {
        return busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus no encontrado con ID: " + id));
    }

    public InformacionBus saveBus(InformacionBus bus) {
        return busRepository.save(bus);
    }

    public InformacionBus updateBus(Integer id, InformacionBus busActualizado) {
        InformacionBus bus = getBusById(id);
        bus.setTipoBus(busActualizado.getTipoBus());
        bus.setOrigen(busActualizado.getOrigen());
        bus.setDestino(busActualizado.getDestino());
        bus.setTotalAsientos(busActualizado.getTotalAsientos());
        bus.setAsientosReservados(busActualizado.getAsientosReservados());
        bus.setAsientosDisponibles(busActualizado.getAsientosDisponibles());
        bus.setHoraSalida(busActualizado.getHoraSalida());
        bus.setHoraLlegada(busActualizado.getHoraLlegada());
        bus.setTarifa(busActualizado.getTarifa());
        return busRepository.save(bus);
    }

    public void deleteBus(Integer id) {
        busRepository.deleteById(id);
    }
}
