package com.rideapp.controller;

import com.rideapp.model.Conductor;
import com.rideapp.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conductores")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @GetMapping
    public ResponseEntity<List<Conductor>> getAllConductores() {
        List<Conductor> conductores = conductorService.getAllConductores();
        return ResponseEntity.ok(conductores);
    }

    @PostMapping
    public ResponseEntity<Conductor> createConductor(@RequestBody Conductor conductor) {
        Conductor createdConductor = conductorService.createConductor(conductor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdConductor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conductor> getConductorById(@PathVariable Long id) {
        Conductor conductor = conductorService.getConductorById(id);
        return ResponseEntity.ok(conductor);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<Conductor>> getConductoresDisponibles() {
        List<Conductor> conductores = conductorService.getConductoresDisponibles();
        return ResponseEntity.ok(conductores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conductor> updateConductor(@PathVariable Long id, @RequestBody Conductor conductor) {
        Conductor updatedConductor = conductorService.updateConductor(id, conductor);
        return ResponseEntity.ok(updatedConductor);
    }

    @PatchMapping("/{id}/disponibilidad")
    public ResponseEntity<Conductor> updateDisponibilidad(@PathVariable Long id, @RequestParam Boolean disponible) {
        Conductor conductor = conductorService.getConductorById(id);
        conductor.setDisponible(disponible);
        Conductor updatedConductor = conductorService.updateConductor(id, conductor);
        return ResponseEntity.ok(updatedConductor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConductor(@PathVariable Long id) {
        conductorService.deleteConductor(id);
        return ResponseEntity.noContent().build();
    }
}