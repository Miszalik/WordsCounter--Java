package pl.mmichalik.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmichalik.backend.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
