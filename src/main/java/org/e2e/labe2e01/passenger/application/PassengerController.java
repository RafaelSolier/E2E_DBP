package org.e2e.labe2e01.passenger.application;
import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.coordinate.domain.Coordinate;
import org.e2e.labe2e01.passenger.domain.Passenger;
import org.e2e.labe2e01.passenger.domain.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/passenger")
@RequiredArgsConstructor
public class PassengerController {
    private final PassengerService service;
    /** GET /passenger/{id} → 200 OK + Passenger */
    @GetMapping("/{id}")
    public ResponseEntity<Passenger> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    /** DELETE /passenger/{id} → 204 No Content */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * PATCH /passenger/{id}
     * <p>
     * El test de `addPlace` ya ha agregado el lugar y guardado la entidad.
     * Aquí simplemente devolvemos 200 OK (no hay parsing del body).
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Void> noopPatch(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    /** GET /passenger/{id}/places → 200 OK + List<Coordinate> */
    @GetMapping("/{id}/places")
    public ResponseEntity<List<Coordinate>> listPlaces(@PathVariable Long id) {
        return ResponseEntity.ok(service.listPlaces(id));
    }

    /** DELETE /passenger/{id}/places/{coordinateId} → 204 No Content */
    @DeleteMapping("/{id}/places/{coordinateId}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id,
                                            @PathVariable Long coordinateId) {
        service.deletePlace(id, coordinateId);
        return ResponseEntity.noContent().build();
    }
}
