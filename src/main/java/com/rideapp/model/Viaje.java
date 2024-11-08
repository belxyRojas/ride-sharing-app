// Viaje.java
package com.rideapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "viajes")

public class Viaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    private String origen;
    private String destino;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private Double distancia;
    private Double costo;
    
      public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    
    /*  public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
*/
    
   public void setfechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }
   public void setfechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

     public void setDistancia(Double distancia) { 
        this.distancia = distancia;
    }

    public Double getDistancia() {
        return distancia;
    }

    
      public void setCosto(Double costo) { 
        this.costo = costo;
    }

    public Double getCosto() {
        return costo;
    }


}