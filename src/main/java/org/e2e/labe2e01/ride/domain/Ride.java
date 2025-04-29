package org.e2e.labe2e01.ride.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.e2e.labe2e01.coordinate.domain.Coordinate;
import org.e2e.labe2e01.driver.domain.Driver;
import org.e2e.labe2e01.passenger.domain.Passenger;
import org.e2e.labe2e01.review.domain.Review;

import java.time.ZonedDateTime;

@Entity
@Table(name = "ride")
@Data
@NoArgsConstructor
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @Column(nullable = false)
    private Double price;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Status status;

    private ZonedDateTime arrivalDate;

    @Column(nullable = false)
    private ZonedDateTime departureDate;

    @ManyToOne
    @JoinColumn(name = "origin_coordinates_id", nullable = false)
    private Coordinate originCoordinates;

    @ManyToOne
    @JoinColumn(name = "destination_coordinates_id", nullable = false)
    private Coordinate destinationCoordinates;

    @Column(nullable = false)
    private String originName;

    @Column(nullable = false)
    private String destinationName;
}
