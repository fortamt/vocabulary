package org.example.vocabulary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "users_words")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserWord {

    @EmbeddedId
    private UserWordKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("wordId")
    @JoinColumn(name = "word_id")
    private Word word;

    @Positive
    @Column(nullable = false)
    private int repetitionCount = 0;

    @DecimalMin("1.3")
    @Column(precision = 3, scale = 2, nullable = false)
    private BigDecimal easyFactor = new BigDecimal("2.5");

    @Min(0)
    @Column(nullable = false)
    private int intervalDays = 0;

    @Column(nullable = false)
    private LocalDate nextReviewDate = LocalDate.now();
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
class UserWordKey implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "word_id")
    private Long wordId;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserWordKey that)) return false;
        return Objects.equals(userId, that.userId) && Objects.equals(wordId, that.wordId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, wordId);
    }
}