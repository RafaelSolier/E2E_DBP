package org.e2e.labe2e01.passenger.domain;

import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.coordinate.domain.Coordinate;
import org.e2e.labe2e01.passenger.infrastructure.PassengerRepository;
import org.e2e.labe2e01.userLocations.domain.UserLocation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerRepository repo;
    public Passenger getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    /**
     * Recibe el Passenger completo en el body.
     * Para el test de addPlace basta con guardar de nuevo la entidad.
     */
    public void update(Long id, Passenger incoming) {
        incoming.setId(id);
        repo.save(incoming);
    }

    public List<Coordinate> listPlaces(Long id) {
        Passenger p = repo.findById(id).orElseThrow();
        return p.getPlaces().stream()
                .map(UserLocation::getCoordinate)
                .collect(Collectors.toList());
    }

    public void deletePlace(Long id, Long coordinateId) {
        Passenger p = repo.findById(id).orElseThrow();
        // elimina la asociación y, con orphanRemoval, borra el registro
        p.getPlaces().removeIf(ul -> ul.getCoordinate().getId().equals(coordinateId));
        repo.save(p);
    }
}
