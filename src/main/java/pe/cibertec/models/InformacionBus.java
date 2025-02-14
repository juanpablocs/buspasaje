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

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public String getTipoBus() {
        return tipoBus;
    }

    public void setTipoBus(String tipoBus) {
        this.tipoBus = tipoBus;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Integer getTotalAsientos() {
        return totalAsientos;
    }

    public void setTotalAsientos(Integer totalAsientos) {
        this.totalAsientos = totalAsientos;
    }

    public Integer getAsientosReservados() {
        return asientosReservados;
    }

    public void setAsientosReservados(Integer asientosReservados) {
        this.asientosReservados = asientosReservados;
    }

    public Integer getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(Integer asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalDateTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalDateTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Integer getTarifa() {
        return tarifa;
    }

    public void setTarifa(Integer tarifa) {
        this.tarifa = tarifa;
    }

    // Getters y Setters
}
