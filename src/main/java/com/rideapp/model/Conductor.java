// Conductor.java
package com.rideapp.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "conductores")
public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nombre;
    private String email;
    private String telefono;
    private String numeroLicencia;
    private String placaVehiculo;
    private boolean disponible;
    
    @Embedded
    private Location ubicacionActual;

    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}