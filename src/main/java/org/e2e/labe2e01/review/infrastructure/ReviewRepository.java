package org.e2e.labe2e01.review.infrastructure;

import org.e2e.labe2e01.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    Optional<Review> findByRideId(Long rideId);
    List<Review> findByRating(int rating);
    List<Review> findByAuthorId(Long authorId);
    Long countByAuthorId(Long authorId);
}
