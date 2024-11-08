// ConductorRepository.java
package com.rideapp.repository;

import com.rideapp.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConductorRepository extends JpaRepository<Conductor, Long> {
    List<Conductor> findByDisponibleTrue();
}
