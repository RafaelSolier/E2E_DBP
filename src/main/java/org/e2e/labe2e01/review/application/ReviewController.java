package org.e2e.labe2e01.review.application;

import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.review.domain.Review;
import org.e2e.labe2e01.review.domain.ReviewService;
import org.e2e.labe2e01.ride.domain.Ride;
import org.e2e.labe2e01.ride.infrastructure.RideRepository;
import org.e2e.labe2e01.user.domain.User;
import org.e2e.labe2e01.user.infrastructure.BaseUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
