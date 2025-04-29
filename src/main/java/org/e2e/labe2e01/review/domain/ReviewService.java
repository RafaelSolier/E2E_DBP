package org.e2e.labe2e01.review.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final org.e2e.labe2e01.review.infrastructure.ReviewRepository repo;
    public Review create(Review r) {
        return repo.save(r);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
