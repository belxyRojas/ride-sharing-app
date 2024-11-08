
// NotificacionService.java
package com.rideapp.service;

import com.rideapp.model.Conductor;
import com.rideapp.model.Viaje;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificacionService {
    
  /*  public void notificarConductores(List<Conductor> conductores, Viaje viaje) {
        // Aquí iría la lógica de notificación (por ejemplo, usando Firebase Cloud Messaging)
        conductores.forEach(conductor -> {
            System.out.println("Notificando al conductor " + conductor.getId() + 
                             " sobre el viaje " + viaje.getId());
        });
    }
    */
    public void notificarUsuario(String idUsuario, String mensaje) {
        // Aquí iría la lógica de notificación al usuario
        System.out.println("Notificando al usuario " + idUsuario + ": " + mensaje);
    }
}