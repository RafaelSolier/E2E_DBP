package org.e2e.labe2e01.ride.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.e2e.labe2e01.coordinate.domain.Coordinate;
import org.e2e.labe2e01.driver.domain.Driver;
import org.e2e.labe2e01.passenger.domain.Passenger;
import org.e2e.labe2e01.review.domain.Review;

import java.time.ZonedDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Status status;

    @Column(name = "arrival_date")
    private ZonedDateTime arrivalDate;

    @Column(name = "departure_date")
    private ZonedDateTime departureDate;

    @ManyToOne
    @JoinColumn(name = "destination_coordinates_id")
    @JsonBackReference
    private Coordinate destinationCoordinates;

    @ManyToOne
    @JoinColumn(name = "origin_coordinates_id")
    @JsonBackReference
    private Coordinate originCoordinates;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    @JsonBackReference
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    @JsonBackReference
    private Passenger passenger;

    @Column(nullable = false)
    private String destinationName;

    @Column(nullable = false)
    private String originName;

}
