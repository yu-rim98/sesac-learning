package org.example.securitydemo.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.securitydemo.dto.SignupDto;
import org.example.securitydemo.entity.User;
import org.example.securitydemo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User register(SignupDto signupDto) {
        User user = User.builder()
            .username(signupDto.getUsername())
            .password(passwordEncoder.encode(signupDto.getPassword()))
            .role("ROLE_USER")
            .email(signupDto.getEmail())
            .build();

        return userRepository.save(user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
