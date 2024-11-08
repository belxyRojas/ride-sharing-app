
// Location.java
package com.rideapp.model;

import lombok.Data;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Location {
    private double latitud;
    private double longitud;
}