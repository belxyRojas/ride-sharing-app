// ViajeService.java
package com.rideapp.service;

import com.rideapp.model.Viaje;
import com.rideapp.repository.ViajeRepository;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class ViajeService {
    private final ViajeRepository viajeRepository;

    public ViajeService(ViajeRepository viajeRepository) {
        this.viajeRepository = viajeRepository;
    }

    public Viaje createViaje(Viaje viaje) {
        return viajeRepository.save(viaje);
    }

    public List<Viaje> getAllViajes() {
        return viajeRepository.findAll();
    }

    public List<Viaje> getViajesForUsuario(Long usuarioId) {
        return viajeRepository.findByUsuarioId(usuarioId);
    }
}