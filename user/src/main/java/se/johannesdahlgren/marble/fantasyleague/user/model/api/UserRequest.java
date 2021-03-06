package se.johannesdahlgren.marble.fantasyleague.user.model.api;

import se.johannesdahlgren.marble.fantasyleague.user.model.domain.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public record UserRequest(@NotNull String firstName, @NotNull String lastName, @NotNull @Email String email) {
    public User toUser() {
        return new User(firstName, lastName, email);
    }
}
