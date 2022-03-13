package se.johannesdahlgren.marble.highscore.user.model.domain;

import java.util.UUID;

public record User(UUID id, String firstName, String lastName, String email) {
}
