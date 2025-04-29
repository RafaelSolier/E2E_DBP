package org.e2e.labe2e01.passenger.infrastructure;

import jakarta.transaction.Transactional;
import org.e2e.labe2e01.driver.domain.Category;
import org.e2e.labe2e01.driver.domain.Driver;
import org.e2e.labe2e01.passenger.domain.Passenger;
import org.e2e.labe2e01.user.infrastructure.BaseUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface PassengerRepository extends BaseUserRepository<Passenger> {
}