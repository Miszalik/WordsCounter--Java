package pl.mmichalik.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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

    @Size(max = 30)
    @Column(name = "word_name")
    @NotNull
    private String wordName;

    private Date creationDate = new Date(System.currentTimeMillis());

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "word_to_user", joinColumns = @JoinColumn(name = "word_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();

    @Column(name = "word_count")
    @ColumnDefault(value = "0")
    private Long wordCount;
}
