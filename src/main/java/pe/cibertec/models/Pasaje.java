package pe.cibertec.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pasaje")
public class Pasaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pasajeId;

    @ManyToOne
    @JoinColumn(name = "numeroReserva", nullable = false)
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "busId", nullable = false)
    private InformacionBus bus;

    @ManyToOne
    @JoinColumn(name = "clienteId", nullable = false)
    private Cliente cliente;

    private String asiento;
    private LocalDateTime fechaVenta;
    private Integer precio;

    public Pasaje() {
    }

    // Getters y Setters
}
