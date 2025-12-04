package org.example.instagram.service;

import org.example.instagram.dto.request.SignUpRequest;
import org.example.instagram.dto.response.UserResponse;
import org.example.instagram.entity.User;

public interface UserService {

    User register(SignUpRequest request);

    boolean existsByUsername(String username);

    User findById(Long userId);

    User findByUsername(String username);

    boolean isOwner(String username, String profileUsername);

    UserResponse getUserById(Long userId);

}
