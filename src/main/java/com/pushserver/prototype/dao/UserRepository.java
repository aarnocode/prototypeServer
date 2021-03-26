package com.pushserver.prototype.dao;

import com.pushserver.prototype.model.User;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface UserRepository {
    String registerUser(User user) throws ExecutionException, InterruptedException;

    List<User> getAllUser() throws ExecutionException, InterruptedException;
}
