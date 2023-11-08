package pl.mmichalik.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmichalik.backend.models.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
}
