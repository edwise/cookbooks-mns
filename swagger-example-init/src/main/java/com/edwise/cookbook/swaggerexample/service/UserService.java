package com.edwise.cookbook.swaggerexample.service;

import com.edwise.cookbook.swaggerexample.entity.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

    User save(User user);

    User update(User user);

    void delete(Long id);

    boolean exists(Long id);
}
