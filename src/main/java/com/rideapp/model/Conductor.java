package com.rideapp.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conductores")
public class Conductor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String telefono;
    private String licencia;
    private String modelo_vehiculo;
    private String placa_vehiculo;
    private Boolean disponible;
    private Double calificacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getModeloVehiculo() {
        return modelo_vehiculo;
    }

    public void setModeloVehiculo(String modelo_vehiculo) {
        this.modelo_vehiculo = modelo_vehiculo;
    }

    public String getPlacaVehiculo() {
        return placa_vehiculo;
    }

    public void setPlacaVehiculo(String placa_vehiculo) {
        this.placa_vehiculo = placa_vehiculo;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Conductor() {
    }

    public Conductor(String nombre, String email, String telefono, String licencia, 
                    String modelo_vehiculo, String placa_vehiculo) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.licencia = licencia;
        this.modelo_vehiculo = modelo_vehiculo;
        this.placa_vehiculo = placa_vehiculo;
        this.disponible = true;
        this.calificacion = 5.0;
    }
}