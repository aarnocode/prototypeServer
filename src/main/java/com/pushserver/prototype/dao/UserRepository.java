package com.pushserver.prototype.dao;

import com.pushserver.prototype.model.ResponseMessage;
import com.pushserver.prototype.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface UserRepository {
    ResponseMessage registerUser(User user) throws ExecutionException, InterruptedException;
    User userLogin(User user);
    List<User> getAllUser() throws ExecutionException, InterruptedException;
}
