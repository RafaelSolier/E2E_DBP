package org.e2e.labe2e01.userLocations.domain;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
//@Getter
//@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerCoordinateId implements Serializable {
    private Long coordinateId;
    private Long passengerId;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        PassengerCoordinateId that = (PassengerCoordinateId) o;

        return Objects.equals(passengerId, that.passengerId) &&
                Objects.equals(coordinateId, that.coordinateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId, coordinateId);
    }
}