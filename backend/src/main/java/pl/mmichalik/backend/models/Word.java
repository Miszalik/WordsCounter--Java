package pl.mmichalik.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "words")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wordId;

    @NotBlank
    @Size(max = 30)
    private String wordName;

    @NotBlank
    private Date creationDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "word_to_user", joinColumns = @JoinColumn(name = "word_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();

    @Column
    private Long wordCount;
}
