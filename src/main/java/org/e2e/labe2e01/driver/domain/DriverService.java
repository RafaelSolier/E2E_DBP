package org.e2e.labe2e01.driver.domain;

import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.coordinate.domain.Coordinate;
import org.e2e.labe2e01.driver.infrastructure.DriverRepository;
import org.e2e.labe2e01.vehicle.domain.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository repo;

    public Driver create(Driver d) { return repo.save(d); }
    public List<Driver> list() { return repo.findAll(); }
    public Driver getById(Long id) { return repo.findById(id).orElseThrow(); }

    public void delete(Long id) { repo.deleteById(id); }

    public Driver update(Long id, Driver driver) {
        driver.setId(id);
        return repo.save(driver);
    }

    public Driver updateLocation(Long id, Coordinate coord) {
        Driver d = repo.findById(id).orElseThrow();
        // si quieres persistir a tabla coordinate, usa coordinateRepo.save(coord);
        d.setCoordinate(coord);
        return repo.save(d);
    }

    public Driver updateVehicle(Long id, Vehicle v) {
        Driver d = repo.findById(id).orElseThrow();
        d.setVehicle(v);
        return repo.save(d);
    }
}
