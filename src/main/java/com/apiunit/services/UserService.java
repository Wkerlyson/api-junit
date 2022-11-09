package com.apiunit.services;

import com.apiunit.domain.User;

public interface UserService {
    User findById(Integer id);
}
