package org.e2e.labe2e01.vehicle.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private int fabrication_year;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false, unique = true)
    private String license_plate;

    @Column(nullable = false)
    private String model;
}
