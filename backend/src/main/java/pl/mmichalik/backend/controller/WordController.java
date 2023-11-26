package pl.mmichalik.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.mmichalik.backend.models.Word;
import pl.mmichalik.backend.services.WordService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/word")
public class WordController {
    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Word>> getAllWords() {
        List<Word> words = this.wordService.findAll();
        return new ResponseEntity<>(words, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Word> getWordById(@PathVariable("id") Long id) {
        Optional<Word> word = this.wordService.findById(id);
        if (word.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok()
                .body(word.get());
    }

    @PostMapping("")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Word> createWord(@RequestBody Word word) {
        try {
            Word createdWord = this.wordService.save(word);
            return new ResponseEntity<>(createdWord, HttpStatus.CREATED);
        } catch (Exception e) {
            // Zaloguj wyjątek dla debugowania
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Word> updateWord(@PathVariable("id") Long id, Word word) {
        boolean isEmpty = this.wordService.update(id, word);

        if (!isEmpty)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(word, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> deleteWord(@PathVariable("id") Long id) {
        boolean isDeleted = this.wordService.delete(id);

        if (!isDeleted)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
