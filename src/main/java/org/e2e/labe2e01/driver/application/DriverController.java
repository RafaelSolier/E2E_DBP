package org.e2e.labe2e01.driver.application;


import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.coordinate.domain.Coordinate;
import org.e2e.labe2e01.driver.domain.Driver;
import org.e2e.labe2e01.driver.domain.DriverService;
import org.e2e.labe2e01.vehicle.domain.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/driver")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
        return driverService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        Driver createdDriver = driverService.save(driver);
        return new ResponseEntity<>(createdDriver, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        driverService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody Driver driver) {
        Driver updatedDriver = driverService.update(id, driver);
        return ResponseEntity.ok(updatedDriver);
    }

    @PatchMapping("/{id}/location")
    public ResponseEntity<Driver> updateDriverLocation(
            @PathVariable Long id,
            @RequestParam Double latitude,
            @RequestParam Double longitude
    ) {
        Coordinate coordinate = new Coordinate(latitude, longitude);
        Driver updatedDriver = driverService.updateLocation(id, coordinate);
        return ResponseEntity.ok(updatedDriver);
    }

    @PatchMapping("/{id}/car")
    public ResponseEntity<Driver> updateDriverCar(
            @PathVariable Long id,
            @RequestBody Vehicle vehicle
    ) {
        Driver updatedDriver = driverService.updateCar(id, vehicle);
        return ResponseEntity.ok(updatedDriver);
    }
}
