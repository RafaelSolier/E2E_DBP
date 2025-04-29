package org.e2e.labe2e01.passenger.application;

import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.coordinate.domain.Coordinate;
import org.e2e.labe2e01.passenger.domain.Passenger;
import org.e2e.labe2e01.passenger.domain.PassengerService;
import org.e2e.labe2e01.userLocations.domain.UserLocation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
@RequiredArgsConstructor
public class PassengerController {
    final private PassengerService passengerService;

    @GetMapping("/{id}")
    ResponseEntity<Passenger> getPassenger(@PathVariable Long id) {
        Passenger newPassenger = passengerService.getPassengerById(id);
        return ResponseEntity.ok(newPassenger);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
        passengerService.deletePassengerById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable Long id, @RequestBody Passenger passengerFromRequest) {
        UserLocation userLocation = passengerFromRequest.getPlaces().get(0);  // Tomamos el primer UserLocation enviado
        Coordinate coordinate = userLocation.getCoordinate();
        String description = userLocation.getDescription();

        Passenger updatedPassenger = passengerService.updatePassenger(id, description, coordinate);
        return ResponseEntity.ok(updatedPassenger);
    }

    @GetMapping("/{id}/places")
    ResponseEntity<List<Coordinate>> listPlaces(@PathVariable Long id) {
        return ResponseEntity.ok(passengerService.getCoordinatesByPassengerId(id));
    }

    @DeleteMapping("/{id}/places/{coordinateId}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id, @PathVariable Long coordinateId) {
        passengerService.deletePassengerByPassengerId(id, coordinateId);
        return ResponseEntity.noContent().build();
    }
//    @PostMapping("/{id}/places")
//    public ResponseEntity<Coordinate> addPlace(@PathVariable Long id, @RequestBody Coordinate coordinate, @RequestParam String description) {
//        Coordinate createdCoordinate = passengerService.addPlace(id, coordinate, description);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdCoordinate);
//    }
}
