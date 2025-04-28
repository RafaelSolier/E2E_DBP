package org.e2e.labe2e01.driver.infrastructure;

import org.e2e.labe2e01.driver.domain.Category;
import org.e2e.labe2e01.driver.domain.Driver;
import org.e2e.labe2e01.user.infrastructure.BaseUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends BaseUserRepository<Driver> {
    Optional<Driver> findByVehicleId(Long vehicleId);
    List<Driver> findAllByCategory(Category category);
}
