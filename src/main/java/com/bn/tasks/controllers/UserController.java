package com.bn.tasks.controllers;

import com.bn.tasks.Services.UserService;
import com.bn.tasks.dto.UserDto;
import com.bn.tasks.entities.User;
import com.bn.tasks.mappers.UserMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addNewUser(
            @Valid
            @RequestBody User user) {
        return this.userService.createNewUser(user);
    }

    @GetMapping("/{user_id}")
    public UserDto getUser(@PathVariable UUID user_id) {
        return this.userService.getUser(user_id);
    }
}
