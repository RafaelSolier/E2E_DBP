package org.e2e.labe2e01.ride.application;


import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.ride.domain.Ride;
import org.e2e.labe2e01.ride.domain.RideService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ride")
@RequiredArgsConstructor
public class RideController {
    private final RideService rideService;

    @PostMapping
    public ResponseEntity<Ride> createRide(@RequestBody Ride ride) {
        Ride createdRide = rideService.save(ride);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRide);
    }

    @PatchMapping("/{rideId}/assign/{driverId}")
    public ResponseEntity<Ride> assignDriver(@PathVariable Long rideId, @PathVariable Long driverId) {
        Ride ride = rideService.assignDriver(rideId, driverId);
        return ResponseEntity.ok(ride);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRide(@PathVariable Long id) {
        rideService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{passengerId}")
    public ResponseEntity<Page<Ride>> getRidesByPassenger(@PathVariable Long passengerId, Pageable pageable) {
        Page<Ride> rides = rideService.findByPassengerId(passengerId, pageable);
        return ResponseEntity.ok(rides);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Ride> updateRide(@PathVariable Long id, @RequestBody Ride rideData) {
        Ride updatedRide = rideService.update(id, rideData);
        return ResponseEntity.ok(updatedRide);
    }

}
