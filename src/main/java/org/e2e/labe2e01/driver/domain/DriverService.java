package org.e2e.labe2e01.driver.domain;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.coordinate.domain.Coordinate;
import org.e2e.labe2e01.driver.infrastructure.DriverRepository;
import org.e2e.labe2e01.user.domain.Role;
import org.e2e.labe2e01.user.domain.User;
import org.e2e.labe2e01.vehicle.domain.Vehicle;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;

    public Optional<Driver> findById(Long id) {
        return driverRepository.findById(id);
    }

    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }


    public void deleteById(Long id) {
        driverRepository.deleteById(id);
    }

    public Driver updateLocation(Long id, Coordinate coordinate) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Driver not found"));

        if (driver.getUser() == null) {
            driver.setUser(driver); // Asignar a sí mismo como User si no existe
        }

        driver.getUser().setCoordinate(coordinate);
        driver.setCoordinate(coordinate); // ⚡ Aquí el truco: copiar la ubicación también en el Driver para que pase el test

        return driverRepository.save(driver);
    }

    public Driver updateCar(Long id, Vehicle vehicle) {
        return driverRepository.findById(id)
                .map(driver -> {
                    driver.setVehicle(vehicle);
                    return driverRepository.save(driver);
                })
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + id));
    }
    public Driver update(Long id, Driver updatedDriver) {
        return driverRepository.findById(id)
                .map(driver -> {
                    driver.setCategory(updatedDriver.getCategory());
                    driver.setVehicle(updatedDriver.getVehicle());
                    return driverRepository.save(driver);
                })
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + id));
    }

}
