package org.example.vocabulary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private Long telegramId;

    @NotBlank
    @Column(nullable = false)
    private String name;

    private String surname;

    private String username;

    @NotBlank
    @Column(nullable = false)
    private String avatarUrl;

    @Column(nullable = false)
    private int dayStreak = 0;

//    @OneToMany
//    private Set<Achievement> achievements = new HashSet<>(); todo

    @OneToMany(mappedBy = "user")
    private Set<UserWord> userWords = new HashSet<>();

//    @Column(nullable = false) todo
//    private int xp = 0;

    @Min(5)
    @Max(100)
    private int dailyGoal = 5;

//    remainder todo
//    ref_link todo
//    premium todo

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(telegramId, user.telegramId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(telegramId);
    }
}
