package com.rideapp.repository;

import com.rideapp.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Long> {
    List<Viaje> findByUsuarioId(Long usuarioId);
}