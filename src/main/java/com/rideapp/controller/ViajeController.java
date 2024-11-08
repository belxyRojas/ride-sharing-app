
// ViajeController.java
package com.rideapp.controller;

import com.rideapp.model.Viaje;
import com.rideapp.service.ViajeService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/viajes")
public class ViajeController {
    private final ViajeService viajeService;

    public ViajeController(ViajeService viajeService) {
        this.viajeService = viajeService;
    }

    @PostMapping
    public ResponseEntity<Viaje> createViaje(@RequestBody Viaje viaje) {
        Viaje createdViaje = viajeService.createViaje(viaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdViaje);
         }

    @GetMapping
    public ResponseEntity<List<Viaje>> getAllViajes() {
        List<Viaje> viajes = viajeService.getAllViajes();
        return ResponseEntity.ok(viajes);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Viaje>> getViajesForUsuario(@PathVariable Long usuarioId) {
        List<Viaje> viajes = viajeService.getViajesForUsuario(usuarioId);
        return ResponseEntity.ok(viajes);
    }
}