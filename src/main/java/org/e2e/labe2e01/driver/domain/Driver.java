package org.e2e.labe2e01.driver.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.e2e.labe2e01.coordinate.domain.Coordinate;
import org.e2e.labe2e01.user.domain.User;
import org.e2e.labe2e01.vehicle.domain.Vehicle;

@Entity
@Table(name = "driver")
@Data
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Driver extends User {

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)

    private Category category;
    @OneToOne(cascade = CascadeType.ALL)
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
