package org.example.securitydemo.service;

import java.util.Optional;
import org.example.securitydemo.dto.SignupDto;
import org.example.securitydemo.entity.User;

public interface UserService {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String namber);

    User register(SignupDto signupDto);

    boolean existsByEmail(String email);
}
