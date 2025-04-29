package org.e2e.labe2e01.ride.application;


import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.ride.domain.Ride;
import org.e2e.labe2e01.ride.domain.RideService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ride")
@RequiredArgsConstructor
public class RideController {
    private final RideService service;

    // POST /ride
    @PostMapping
    public ResponseEntity<Ride> book(@RequestBody Ride ride) {
        Ride saved = service.create(ride);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // PATCH /ride/{rideId}/assign/{driverId}
    @PatchMapping("/{rideId}/assign/{driverId}")
    public ResponseEntity<Ride> accept(@PathVariable Long rideId,
                                       @PathVariable Long driverId) {
        Ride updated = service.assignDriver(rideId, driverId);
        return ResponseEntity.ok(updated);
    }

    // DELETE /ride/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // GET /ride/{passengerId}?page=…&size=…
    @GetMapping("/{passengerId}")
    public ResponseEntity<Page<Ride>> listByUser(@PathVariable Long passengerId,
                                                 Pageable pageable) {
        Page<Ride> page = service.listByUser(passengerId, pageable);
        return ResponseEntity.ok(page);
    }


    // PATCH /ride/{id}  (cancel)
    @PatchMapping("/{id}")
    public ResponseEntity<Ride> cancel(@PathVariable Long id) {
        Ride canceled = service.cancel(id);
        return ResponseEntity.ok(canceled);
    }
}
