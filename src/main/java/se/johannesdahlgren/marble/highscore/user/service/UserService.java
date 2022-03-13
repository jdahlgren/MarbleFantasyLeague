package se.johannesdahlgren.marble.highscore.user.service;

import org.springframework.stereotype.Service;
import se.johannesdahlgren.marble.highscore.user.model.db.UserDb;
import se.johannesdahlgren.marble.highscore.user.model.domain.User;
import se.johannesdahlgren.marble.highscore.user.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        UserDb userDbInput = UserDb.fromUser(user);
        return userRepository.save(userDbInput)
                .toUser();
    }
}
