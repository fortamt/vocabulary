package org.example.vocabulary.service;

import org.example.vocabulary.model.Word;
import org.example.vocabulary.repository.WordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordService {

    public final WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }

    public Optional<Word> getWordByID(Long id) {
        return wordRepository.findById(id);
    }

    public Word saveWord(Word word) {
        return wordRepository.save(word);
    }

    public Word updateLevel (Long id, Integer level) {
        Word word = wordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cannot find a word: " + id));
        word.setLevel(level);
        return wordRepository.save(word);
    }

    public void deleteWord(Long id) {
        wordRepository.deleteById(id);
    }

}
