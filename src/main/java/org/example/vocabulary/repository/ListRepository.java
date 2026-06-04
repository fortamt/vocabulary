package org.example.vocabulary.repository;

import org.example.vocabulary.model.ListOfWords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListRepository extends JpaRepository<ListOfWords, Long> {

    List<ListOfWords> findByNameStartingWith(String prefix);

}
