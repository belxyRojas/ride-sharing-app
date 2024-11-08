package com.rideapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "pagos")
public class Pago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "viaje_id", nullable = false)
    private Viaje viaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    private Double monto;
    private String metodo_pago;
    private String estado;
    private LocalDateTime fecha_pago;
    private String referencia_transaccion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodo_pago;
    }

    public void setMetodoPago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaPago() {
        return fecha_pago;
    }

    public void setFechaPago(LocalDateTime fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getReferenciaTransaccion() {
        return referencia_transaccion;
    }

    public void setReferenciaTransaccion(String referencia_transaccion) {
        this.referencia_transaccion = referencia_transaccion;
    }

    public Pago() {
    }

    public Pago(Viaje viaje, Usuario usuario, Double monto, String metodo_pago) {
        this.viaje = viaje;
        this.usuario = usuario;
        this.monto = monto;
        this.metodo_pago = metodo_pago;
        this.estado = "PENDIENTE";
        this.fecha_pago = LocalDateTime.now();
    }
}