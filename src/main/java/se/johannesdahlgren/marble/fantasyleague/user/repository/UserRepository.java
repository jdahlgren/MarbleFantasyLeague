package se.johannesdahlgren.marble.fantasyleague.user.repository;

import se.johannesdahlgren.marble.fantasyleague.user.model.db.UserDb;

import java.util.List;

public interface UserRepository {
    UserDb createUser(UserDb userDb);

    UserDb getUser(String email);

    List<UserDb> getUsers();
}
