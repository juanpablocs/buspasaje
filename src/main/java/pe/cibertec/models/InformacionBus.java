package pe.cibertec.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "informacion_bus")
public class InformacionBus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer busId;

    private String tipoBus;
    private String origen;
    private String destino;
    private Integer totalAsientos;
    private Integer asientosReservados;
    private Integer asientosDisponibles;
    private LocalDateTime horaSalida;
    private LocalDateTime horaLlegada;
    private Integer tarifa;

    public InformacionBus() {
    }

    // Getters y Setters
}
