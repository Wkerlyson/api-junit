package com.apiunit.services.impl;

import com.apiunit.domain.User;
import com.apiunit.repositories.UserRepository;
import com.apiunit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
