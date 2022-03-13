package se.johannesdahlgren.marble.highscore.user.model.api;

import se.johannesdahlgren.marble.highscore.user.model.domain.User;

import java.util.UUID;

public record UserResponse(UUID id, String firstName, String lastName, String email) {
    public static UserResponse fromUser(User user) {
        return new UserResponse(user.id(), user.firstName(), user.lastName(), user.email());
    }
}
