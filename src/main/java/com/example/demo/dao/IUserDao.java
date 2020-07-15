package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface IUserDao {
    User getOne(String login);
    List<User> getAll();
    User save(User user);
    User remove(User user);
}

