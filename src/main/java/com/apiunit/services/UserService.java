package com.apiunit.services;

import com.apiunit.domain.User;

import java.util.List;

public interface UserService {
    User findById(Integer id);

    List<User> findAll();
}
