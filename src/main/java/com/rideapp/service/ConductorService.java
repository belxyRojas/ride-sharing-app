package com.rideapp.service;

import com.rideapp.model.Conductor;
import com.rideapp.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    public List<Conductor> getAllConductores() {
        return conductorRepository.findAll();
    }

    public Conductor createConductor(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    public Conductor getConductorById(Long id) {
        return conductorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conductor no encontrado"));
    }

    public List<Conductor> getConductoresDisponibles() {
        return conductorRepository.findByDisponibleTrue();
    }

    public Conductor updateConductor(Long id, Conductor conductor) {
        Conductor existingConductor = getConductorById(id);
        existingConductor.setNombre(conductor.getNombre());
        existingConductor.setEmail(conductor.getEmail());
        existingConductor.setTelefono(conductor.getTelefono());
        existingConductor.setLicencia(conductor.getLicencia());
        existingConductor.setModeloVehiculo(conductor.getModeloVehiculo());
        existingConductor.setPlacaVehiculo(conductor.getPlacaVehiculo());
        existingConductor.setDisponible(conductor.getDisponible());
        return conductorRepository.save(existingConductor);
    }

    public void deleteConductor(Long id) {
        conductorRepository.deleteById(id);
    }
}