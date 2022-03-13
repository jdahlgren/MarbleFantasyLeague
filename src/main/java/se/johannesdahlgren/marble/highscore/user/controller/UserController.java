package se.johannesdahlgren.marble.highscore.user.controller;

import org.springframework.web.bind.annotation.*;
import se.johannesdahlgren.marble.highscore.user.model.api.UserRequest;
import se.johannesdahlgren.marble.highscore.user.model.api.UserResponse;
import se.johannesdahlgren.marble.highscore.user.model.domain.User;
import se.johannesdahlgren.marble.highscore.user.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody @Valid UserRequest userRequest) {
        User user = userService.createUser(userRequest.toUser());
        return UserResponse.fromUser(user);
    }

    @GetMapping
    public List<UserResponse> getUsers() {
        List<User> users = userService.getUsers();
        return users.stream()
                .map(UserResponse::fromUser)
                .toList();
    }

    @GetMapping("/{email}")
    public UserResponse getUser(@PathVariable String email) {
        User user = userService.getUser(email);
        return UserResponse.fromUser(user);
    }
}
