package org.example.vocabulary.repository;

import org.example.vocabulary.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
}
