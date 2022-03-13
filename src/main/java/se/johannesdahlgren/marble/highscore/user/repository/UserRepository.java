package se.johannesdahlgren.marble.highscore.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.johannesdahlgren.marble.highscore.user.model.db.UserDb;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserDb, UUID> {
}
