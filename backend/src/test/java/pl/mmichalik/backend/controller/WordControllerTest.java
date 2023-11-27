package pl.mmichalik.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.mmichalik.backend.models.Word;
import pl.mmichalik.backend.services.WordService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@WebMvcTest(WordController.class)
public class WordControllerTest {
    // todo fix tests
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private WordService wordService;

    @InjectMocks
    private WordController wordController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllWords() throws Exception {
        List<Word> words = new ArrayList<>();
        // Dodaj przykładowe dane do listy "words"

        when(wordService.findAll()).thenReturn(words);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/word/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());

        verify(wordService, times(1)).findAll();
    }

    @Test
    public void testGetWordById() throws Exception {
        Long wordId = 1L;
        Word word = new Word();
        // Ustaw przykładowe dane dla obiektu "word"

        when(wordService.findById(wordId)).thenReturn(Optional.of(word));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/word/{id}", wordId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(wordId));

        verify(wordService, times(1)).findById(wordId);
    }

    @Test
    public void testCreateWord() throws Exception {
        Word word = new Word();
        // Ustaw przykładowe dane dla obiektu "word"

        when(wordService.save(any(Word.class))).thenReturn(word);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/word")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(word)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        verify(wordService, times(1)).save(any(Word.class));
    }

    @Test
    public void testUpdateWord() throws Exception {
        Long wordId = 1L;
        Word word = new Word();
        // Ustaw przykładowe dane dla obiektu "word"

        when(wordService.update(eq(wordId), any(Word.class))).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/word/{id}", wordId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(word)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(wordService, times(1)).update(eq(wordId), any(Word.class));
    }

    @Test
    public void testDeleteWord() throws Exception {
        Long wordId = 1L;

        when(wordService.delete(wordId)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/word/{id}", wordId))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(wordService, times(1)).delete(wordId);
    }
}