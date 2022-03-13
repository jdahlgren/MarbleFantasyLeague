package se.johannesdahlgren.marble.highscore.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.johannesdahlgren.marble.highscore.user.model.api.UserRequest;
import se.johannesdahlgren.marble.highscore.user.model.api.UserResponse;
import se.johannesdahlgren.marble.highscore.user.model.domain.User;
import se.johannesdahlgren.marble.highscore.user.service.UserService;

import javax.validation.Valid;

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
}
