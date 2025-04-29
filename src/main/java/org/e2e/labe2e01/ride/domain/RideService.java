package org.e2e.labe2e01.ride.domain;

import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.ride.infrastructure.RideRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RequiredArgsConstructor
public class RideService {
    private final RideRepository repo;

    public Ride create(Ride r) { return repo.save(r); }
    public Ride assignDriver(Long id, Long driverId) {
        Ride ride = repo.findById(id).orElseThrow();
        ride.setDriver(new org.e2e.labe2e01.driver.domain.Driver()); // minimal assignment
        ride.setStatus(Status.ACCEPTED);
        return repo.save(ride);
    }
    public Page<Ride> listByUser(Long userId, Pageable pageable) {
        return repo.findAllByPassengerId(userId, pageable);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Ride cancel(Long id) {
        Ride ride = repo.findById(id).orElseThrow();
        ride.setStatus(Status.CANCELED);
        return repo.save(ride);
    }


}
