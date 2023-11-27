package pl.mmichalik.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmichalik.backend.models.Word;

import java.util.Optional;

public interface WordRepository extends JpaRepository<Word, Long> {
    Optional<Word> findWordByWordName(String wordName);
}
