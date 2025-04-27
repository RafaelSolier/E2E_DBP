package org.e2e.labe2e01.ride.infrastructure;

import org.e2e.labe2e01.ride.domain.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
}
