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

    public Integer getPasajeId() {
        return pasajeId;
    }

    public void setPasajeId(Integer pasajeId) {
        this.pasajeId = pasajeId;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public InformacionBus getBus() {
        return bus;
    }

    public void setBus(InformacionBus bus) {
        this.bus = bus;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    // Getters y Setters
}
