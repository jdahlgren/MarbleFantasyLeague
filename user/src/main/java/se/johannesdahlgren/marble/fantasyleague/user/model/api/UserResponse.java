package se.johannesdahlgren.marble.fantasyleague.user.model.api;

import se.johannesdahlgren.marble.fantasyleague.user.model.domain.User;

public record UserResponse(String firstName, String lastName, String email) {
    public static UserResponse fromUser(User user) {
        return new UserResponse(user.firstName(), user.lastName(), user.email());
    }
}
