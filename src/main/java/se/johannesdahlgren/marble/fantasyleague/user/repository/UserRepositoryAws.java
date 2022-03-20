package se.johannesdahlgren.marble.fantasyleague.user.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import se.johannesdahlgren.marble.fantasyleague.user.model.db.UserDb;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.util.List;

@Profile("aws")
@Repository
public class UserRepositoryAws implements UserRepository {
    private final DynamoDbTable<UserDb> userTable;

    public UserRepositoryAws(DynamoDbTable<UserDb> userTable) {
        this.userTable = userTable;
    }

    @Override
    public UserDb createUser(UserDb userDb) {
        userTable.putItem(userDb);
        return userDb;
    }

    @Override
    public UserDb getUser(String email) {
        return userTable.getItem(Key.builder().partitionValue(email).build());
    }

    @Override
    public List<UserDb> getUsers() {
        return userTable.scan()
                .items()
                .stream()
                .toList();
    }
}
