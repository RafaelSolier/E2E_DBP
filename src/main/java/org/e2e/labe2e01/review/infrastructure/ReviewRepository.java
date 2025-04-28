package org.e2e.labe2e01.review.infrastructure;

import org.e2e.labe2e01.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Custom query methods can be defined here if needed
    // For example, findByAuthorId, findByRideId, etc.
    List<Review> findByRating(int rating);
    List<Review> findByAuthorId(Long authorId);
    Long countByAuthorId(Long authorId);
}
