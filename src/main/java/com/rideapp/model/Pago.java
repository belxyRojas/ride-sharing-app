// Pago.java
package com.rideapp.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String idViaje;
    private double monto;
    private String metodoPago;
    
    @Enumerated(EnumType.STRING)
    private EstadoPago estado;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    
    public enum EstadoPago {
        PENDIENTE,
        COMPLETADO,
        FALLIDO,
        REEMBOLSADO
    }
}