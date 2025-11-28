package org.example.securitydemo.repository;

import java.util.Optional;
import org.example.securitydemo.entity.User;

public interface UserService {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String namber);

}
