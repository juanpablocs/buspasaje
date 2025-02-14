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

    public Integer getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(Integer numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public InformacionBus getBus() {
        return bus;
    }

    public void setBus(InformacionBus bus) {
        this.bus = bus;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public LocalDateTime getSalida() {
        return salida;
    }

    public void setSalida(LocalDateTime salida) {
        this.salida = salida;
    }

    public Integer getTotalBoletos() {
        return totalBoletos;
    }

    public void setTotalBoletos(Integer totalBoletos) {
        this.totalBoletos = totalBoletos;
    }

    public Integer getTarifaTotal() {
        return tarifaTotal;
    }

    public void setTarifaTotal(Integer tarifaTotal) {
        this.tarifaTotal = tarifaTotal;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    // Getters y Setters
}
