package org.e2e.labe2e01.user.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.e2e.labe2e01.coordinate.domain.Coordinate;
import java.time.ZonedDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "avg_rating", nullable = false)
    private Double avg_rating = 0.0;

    //@Enumerated(EnumType.ORDINAL)
    @Column(name = "role", nullable = false)
    private Role role;

    @Column(nullable = false)
    private Integer trips = 0;

    @Column(name = "created_at", nullable = false)
    private ZonedDateTime created_at;

    @Column(name = "updated_at")
    private ZonedDateTime updated_at;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "first_name", nullable = false, length = 255)
    private String first_name;

    @Column(name = "last_name", nullable = false, length = 255)
    private String last_name;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(name = "phone_number", nullable = false, unique = true, length = 255)
    private String phone_number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coordinate_id")
    private Coordinate coordinate;
}