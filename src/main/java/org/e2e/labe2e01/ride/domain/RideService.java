package org.e2e.labe2e01.ride.domain;

import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.driver.infrastructure.DriverRepository;
import org.e2e.labe2e01.passenger.infrastructure.PassengerRepository;
import org.e2e.labe2e01.ride.infrastructure.RideRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RideService {
    private final RideRepository rideRepository;
    private final DriverRepository driverRepository;
    private final PassengerRepository passengerRepository;

    public Ride save(Ride ride) {
        return rideRepository.save(ride);
    }

    public Ride assignDriver(Long rideId, Long driverId) {
        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride not found with id: " + rideId));
        ride.setDriver(driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + driverId)));
        return rideRepository.save(ride);
    }

    public void delete(Long id) {
        rideRepository.deleteById(id);
    }

    public Page<Ride> findByPassengerId(Long passengerId, Pageable pageable) {
        return rideRepository.findByPassengerId(passengerId, pageable);
    }

    public Ride update(Long id, Ride rideData) {
        Ride ride = rideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ride not found with id: " + id));
        ride.setOriginCoordinates(rideData.getOriginCoordinates());
        ride.setDestinationCoordinates(rideData.getDestinationCoordinates());
        ride.setStatus(rideData.getStatus());
        ride.setDepartureDate(rideData.getDepartureDate());
        return rideRepository.save(ride);
    }

}
