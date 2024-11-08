/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.rideapp.repository;

import com.rideapp.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, String> {
    List<Conductor> findByDisponible(boolean disponible);
    
    @Query("SELECT c FROM Conductor c WHERE c.disponible = true AND " +
           "ST_Distance(ST_MakePoint(c.ubicacionActual.latitud, c.ubicacionActual.longitud), " +
           "ST_MakePoint(?1, ?2)) <= ?3")
    List<Conductor> findConductoresCercanos(double lat, double lon, double radioKm);
}