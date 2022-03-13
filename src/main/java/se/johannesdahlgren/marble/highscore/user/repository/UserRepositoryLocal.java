package se.johannesdahlgren.marble.highscore.user.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.johannesdahlgren.marble.highscore.user.model.db.UserDb;

import java.util.List;

@Profile("local")
@Repository
public interface UserRepositoryLocal extends UserRepository, JpaRepository<UserDb, String> {
    @Override
    default UserDb createUser(UserDb userDb) {
        return save(userDb);
    }

    @Override
    default UserDb getUser(String email) {
        return getById(email);
    }

    @Override
    default List<UserDb> getUsers() {
        return findAll();
    }
}
