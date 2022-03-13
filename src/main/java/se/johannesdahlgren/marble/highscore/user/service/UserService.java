package se.johannesdahlgren.marble.highscore.user.service;

import org.springframework.stereotype.Service;
import se.johannesdahlgren.marble.highscore.user.model.db.UserDb;
import se.johannesdahlgren.marble.highscore.user.model.domain.User;
import se.johannesdahlgren.marble.highscore.user.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        UserDb userDb = UserDb.fromUser(user);
        return userRepository.createUser(userDb)
                .toUser();
    }

    public List<User> getUsers() {
        return userRepository.getUsers()
                .stream()
                .map(UserDb::toUser)
                .toList();
    }

    public User getUser(String email) {
        return userRepository.getUser(email)
                .toUser();
    }
}
