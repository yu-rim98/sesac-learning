package org.example.restapi.service;

import org.example.restapi.dto.response.UserResponse;
import org.example.restapi.entity.User;

public interface UserService {

    UserResponse findByUsername(String username);
    User findById(Long userId);
}
