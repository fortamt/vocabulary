package org.example.vocabulary.controller;

import org.example.vocabulary.model.Word;
import org.example.vocabulary.service.WordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/words")
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    // Получить все слова
    @GetMapping
    public List<Word> getAllWords() {
        return wordService.getAllWords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Word> getWord(@PathVariable Long id) {
        return wordService.getWordByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/level")
    public ResponseEntity<Word> updateLevel(@PathVariable Long id, @RequestParam Integer level) {
        try {
            Word updated = wordService.updateLevel(id, level);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
