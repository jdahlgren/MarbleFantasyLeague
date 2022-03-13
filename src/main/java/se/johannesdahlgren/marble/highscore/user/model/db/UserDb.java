package se.johannesdahlgren.marble.highscore.user.model.db;

import se.johannesdahlgren.marble.highscore.user.model.domain.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "USERS")
public class UserDb {
    @Id
    protected UUID id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;

    private UserDb(String firstName, String lastName, String email) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    protected UserDb() {
        this.id = UUID.randomUUID();
    }

    public static UserDb fromUser(User user) {
        return new UserDb(user.firstName(), user.lastName(), user.email());
    }

    public User toUser() {
        return new User(getId(), getFirstName(), getLastName(), getEmail());
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

}
