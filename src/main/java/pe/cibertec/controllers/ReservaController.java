package pe.cibertec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.cibertec.models.Reserva;
import pe.cibertec.services.ReservaService;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.getAllReservas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable Integer id) {
        return ResponseEntity.ok(reservaService.getReservaById(id));
    }

    @PostMapping
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.saveReserva(reserva));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable Integer id, @RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.updateReserva(id, reserva));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReserva(@PathVariable Integer id) {
        reservaService.deleteReserva(id);
        return ResponseEntity.ok("Reserva eliminada correctamente");
    }
}
