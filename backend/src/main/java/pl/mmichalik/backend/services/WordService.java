package pl.mmichalik.backend.services;

import pl.mmichalik.backend.models.Word;

import java.util.List;
import java.util.Optional;

public interface WordService {
    List<Word> findAll();

    Optional<Word> findById(Long id);

    Word save(Word word);

    boolean update(Long id, Word word);

    boolean delete(Long id);
}
