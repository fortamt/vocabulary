package org.example.vocabulary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "words")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String ru;

    @NotBlank
    private String en;

    @NotBlank
    private String enTranscription;

    @OneToMany(mappedBy = "word")
    Set<UserWord> userWords = new HashSet<>();

    @ManyToMany(mappedBy = "words")
    Set<ListOfWords> listOfWords = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Word word)) return false;
        return Objects.equals(id, word.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
