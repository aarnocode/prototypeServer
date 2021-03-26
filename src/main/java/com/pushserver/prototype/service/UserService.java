package com.pushserver.prototype.service;

import com.pushserver.prototype.dao.UserDao;
import com.pushserver.prototype.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public String registerUser(User user) throws ExecutionException, InterruptedException {
        return userDao.registerUser(user);
    }

    public List<User> getAllUser() throws ExecutionException, InterruptedException {
        return userDao.getAllUser();
    }
}
