package org.e2e.labe2e01.review.domain;

import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.review.infrastructure.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public Review save(Review review) {
        if (review.getRating() < 0 || review.getRating() > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5.");
        }
        return reviewRepository.save(review);
    }

    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}
