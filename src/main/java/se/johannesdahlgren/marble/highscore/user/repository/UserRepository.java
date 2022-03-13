package se.johannesdahlgren.marble.highscore.user.repository;

import se.johannesdahlgren.marble.highscore.user.model.db.UserDb;

import java.util.List;

public interface UserRepository {
    UserDb createUser(UserDb userDb);

    UserDb getUser(String email);

    List<UserDb> getUsers();
}
