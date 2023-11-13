package pl.mmichalik.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmichalik.backend.models.User;

import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}