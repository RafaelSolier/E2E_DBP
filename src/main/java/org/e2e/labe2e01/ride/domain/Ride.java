package org.e2e.labe2e01.ride.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.ZonedDateTime;

@Entity
@NoArgsConstructor
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Status status;

    private ZonedDateTime arrival_date;
    private ZonedDateTime departure_date;

    private Long destination_coordinates_id;
    private Long origin_coordinates_id;

    private Long driver_id;
    private Long passenger_id;

    @Column(nullable = false)
    private String destination_name;

    @Column(nullable = false)
    private String origin_name;
}
