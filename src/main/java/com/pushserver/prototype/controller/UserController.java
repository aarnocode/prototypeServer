package com.pushserver.prototype.controller;

import com.pushserver.prototype.model.User;
import com.pushserver.prototype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("api/register")
    public String registerUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        return userService.registerUser(user);
    }
}
