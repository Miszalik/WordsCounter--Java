package pl.mmichalik.backend.services.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mmichalik.backend.models.Word;
import pl.mmichalik.backend.repository.WordRepository;
import pl.mmichalik.backend.services.WordService;

import java.util.List;

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
}
