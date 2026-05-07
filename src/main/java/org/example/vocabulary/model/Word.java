package org.example.vocabulary.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "words")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String word;

    @Column(nullable = false)
    private String translation;

    @Column(nullable = false)
    private Integer level = 0;

    public Word(String word, String translation) {
        this.word = word;
        this.translation = translation;
        this.level = 0;
    }
}
