package org.e2e.labe2e01.driver.application;


import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.coordinate.domain.Coordinate;
import org.e2e.labe2e01.driver.domain.Driver;
import org.e2e.labe2e01.driver.domain.DriverService;
import org.e2e.labe2e01.vehicle.domain.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/driver")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService service;

    /** GET /driver/{id} → 200 OK + Driver */
    @GetMapping("/{id}")
    public ResponseEntity<Driver> get(@PathVariable Long id) {
        Driver d = service.getById(id);
        return ResponseEntity.ok(d);
    }

    /** POST /driver → 201 Created + Driver */
    @PostMapping
    public ResponseEntity<Driver> create(@RequestBody Driver driver) {
        Driver saved = service.create(driver);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /** DELETE /driver/{id} → 204 No Content */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    /** PUT /driver/{id} → 200 OK + Driver */
    @PutMapping("/{id}")
    public ResponseEntity<Driver> update(
            @PathVariable Long id,
            @RequestBody Driver driver
    ) {
        Driver updated = service.update(id, driver);
        return ResponseEntity.ok(updated);
    }

    /**
     * PATCH /driver/{id}/location?latitude=…&longitude=…
     * → 200 OK + Driver
     */
    @PatchMapping("/{id}/location")
    public ResponseEntity<Driver> updateLocation(
            @PathVariable Long id,
            @RequestParam Double latitude,
            @RequestParam Double longitude
    ) {
        Driver updated = service.updateLocation(id, new Coordinate(latitude, longitude));
        return ResponseEntity.ok(updated);
    }

    /**
     * PATCH /driver/{id}/car
     * Body: Vehicle → 200 OK + Driver
     */
    @PatchMapping("/{id}/car")
    public ResponseEntity<Driver> updateCar(
            @PathVariable Long id,
            @RequestBody Vehicle vehicle
    ) {
        Driver updated = service.updateVehicle(id, vehicle);
        return ResponseEntity.ok(updated);
    }
}
