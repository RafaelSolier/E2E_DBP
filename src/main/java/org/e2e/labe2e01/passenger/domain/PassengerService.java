package org.e2e.labe2e01.passenger.domain;

import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.coordinate.domain.Coordinate;
import org.e2e.labe2e01.passenger.infrastructure.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerRepository passengerRepository;

    public void deletePassengerById(Long id) {
        passengerRepository.deleteById(id);
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id).get();
    }

    public Passenger updatePassenger(Long id, String description, Coordinate coordinate) {
        Passenger passenger = passengerRepository.findById(id).get();
        passenger.addPlace(coordinate, description);
        return passenger;
    }

    public List<Coordinate> getCoordinatesByPassengerId(Long id) {
        Passenger passenger = passengerRepository.findById(id).get();
        return passenger.getPlacesList();
    }

    public void deletePassengerByPassengerId(Long id, Long coordinateId) {
        Passenger passenger = passengerRepository.findById(id).get();
        passenger.removePlace(coordinateId);
    }
}
