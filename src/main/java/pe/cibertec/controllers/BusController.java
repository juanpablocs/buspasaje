package pe.cibertec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.cibertec.models.InformacionBus;
import pe.cibertec.services.InformacionBusService;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    @Autowired
    private InformacionBusService busService;

    @GetMapping
    public List<InformacionBus> getAllBuses() {
        return busService.getAllBuses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformacionBus> getBusById(@PathVariable Integer id) {
        return ResponseEntity.ok(busService.getBusById(id));
    }

    @PostMapping
    public ResponseEntity<InformacionBus> createBus(@RequestBody InformacionBus bus) {
        return ResponseEntity.ok(busService.saveBus(bus));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InformacionBus> updateBus(@PathVariable Integer id, @RequestBody InformacionBus bus) {
        return ResponseEntity.ok(busService.updateBus(id, bus));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBus(@PathVariable Integer id) {
        busService.deleteBus(id);
        return ResponseEntity.ok("Bus eliminado correctamente");
    }
}
