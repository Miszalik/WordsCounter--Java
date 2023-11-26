package pl.mmichalik.backend.services.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mmichalik.backend.models.Word;
import pl.mmichalik.backend.repository.WordRepository;
import pl.mmichalik.backend.services.WordService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;

    @Autowired
    public WordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public List<Word> findAll() {
        return wordRepository.findAll();
    }

    @Override
    public Optional<Word> findById(Long id) {
        return wordRepository.findById(id);
    }

    @Override
    public Word save(Word word) {
        return wordRepository.save(word);
    }

    @Override
    public boolean update(Long id, Word word) {
        Optional<Word> existingWord = wordRepository.findById(id);
        if (existingWord.isEmpty())
            return false;

        wordRepository.save(word);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Word> existingWord = wordRepository.findById(id);
        if (existingWord.isEmpty())
            return false;

        wordRepository.deleteById(id);
        return true;
    }
}
