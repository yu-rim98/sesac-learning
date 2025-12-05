package org.example.instagram.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.instagram.dto.request.SignUpRequest;
import org.example.instagram.dto.response.UserResponse;
import org.example.instagram.entity.Role;
import org.example.instagram.entity.User;
import org.example.instagram.exception.BusinessException;
import org.example.instagram.exception.ErrorCode;
import org.example.instagram.repository.UserRepository;
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
    @Transactional
    public User register(SignUpRequest request) {
        User user = User.builder()
            .username(request.getUsername())
            .email(request.getEmail())
            .name(request.getName())
            .role(Role.USER)
            .password(passwordEncoder.encode(request.getPassword()))
            .build();
        return userRepository.save(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId)
            .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
            .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));
    }

    @Override
    public boolean isOwner(String username, String profileUsername) {
        return username.equals(profileUsername);
    }

    @Override
    public UserResponse getUserById(Long userId) {
        return UserResponse.from(findById(userId));
    }

    @Override
    public List<UserResponse> searchUsers(String keyword) {
        List<User> users = userRepository.searchByKeyword(keyword);

        return users.stream().map(UserResponse::from).toList();
    }


}
