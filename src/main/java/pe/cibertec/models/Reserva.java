package pe.cibertec.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroReserva;

    @ManyToOne
    @JoinColumn(name = "clienteId", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "busId", nullable = false)
    private InformacionBus bus;

    private LocalDateTime fechaReserva;
    private LocalDateTime salida;
    private Integer totalBoletos;
    private Integer tarifaTotal;
    private Boolean estado;

    public Reserva() {
    }

    // Getters y Setters
}
