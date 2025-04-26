package org.e2e.labe2e01.ride.domain;

import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.passenger.infrastructure.PassengerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideService {
    private final PassengerRepository passengerRepository;

}
