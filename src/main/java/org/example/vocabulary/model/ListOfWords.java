package org.example.vocabulary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lists_of_words")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ListOfWords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @PositiveOrZero
    @NotNull
    private int wordCount;

    @NotBlank
    @Column(nullable = false)
    private String icon;

    @NotBlank
    @Column(nullable = false)
    private String background;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "words_lists",
            joinColumns = @JoinColumn(name = "list_id"),
            inverseJoinColumns = @JoinColumn(name = "word_id")
    )
    Set<Word> words = new HashSet<>();

}
