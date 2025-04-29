package org.e2e.labe2e01.driver.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.e2e.labe2e01.coordinate.domain.Coordinate;
import org.e2e.labe2e01.user.domain.User;
import org.e2e.labe2e01.vehicle.domain.Vehicle;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "driver")
public class Driver extends User {
    @Id
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private User user;
//    @Enumerated(EnumType.ORDINAL)
//    @Column(nullable = false)
//    private Category category;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Category category;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false, unique = true)
    private Vehicle vehicle;
    @Transient
    private Coordinate coordinate; // No persistir, sólo para test

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }
}
