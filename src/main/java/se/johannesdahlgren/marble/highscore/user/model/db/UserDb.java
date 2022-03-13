package se.johannesdahlgren.marble.highscore.user.model.db;

import se.johannesdahlgren.marble.highscore.user.model.domain.User;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
@DynamoDbBean
public class UserDb {
    @Id
    private String email;
    private String firstName;
    private String lastName;

    public UserDb(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UserDb() {

    }

    public static UserDb fromUser(User user) {
        return new UserDb(user.firstName(), user.lastName(), user.email());
    }

    public User toUser() {
        return new User(getFirstName(), getLastName(), getEmail());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @DynamoDbPartitionKey
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
