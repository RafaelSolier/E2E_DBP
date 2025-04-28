package org.e2e.labe2e01.review.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.ride.domain.Ride;
import org.e2e.labe2e01.user.domain.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "INT CHECK (rating >= 0 AND rating <= 5)")
    private Integer rating;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ride_id", unique = true, nullable = false)
    private Ride ride;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_id")
    private User target;

    @Column(nullable = false, length = 255)
    private String comment;

}

