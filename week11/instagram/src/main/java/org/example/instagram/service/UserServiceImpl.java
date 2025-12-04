package org.example.instagram.service;

import lombok.RequiredArgsConstructor;
import org.example.instagram.dto.request.ProfileUpdateRequest;
import org.example.instagram.dto.request.SignUpRequest;
import org.example.instagram.dto.response.ProfileResponse;
import org.example.instagram.dto.response.UserResponse;
import org.example.instagram.entity.Role;
import org.example.instagram.entity.User;
import org.example.instagram.repository.FollowRepository;
import org.example.instagram.repository.PostRepository;
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
//    private final PostService postService;
    private final PostRepository postRepository;
//    private final FollowService followService;
    private final FollowRepository followRepository;

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
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
    }

    @Override
    public ProfileResponse getProfile(String username) {
        User user = findByUsername(username);
        long postCount = postRepository
            .countByUserId(user.getId());
        long followerCount = followRepository.countByFollowingId(user.getId());
        long followingCount = followRepository.countByFollowerId(user.getId());

        return ProfileResponse.from(user, postCount, followerCount, followingCount);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
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
    public ProfileUpdateRequest getProfileForUpdate(Long userId) {
        User user = findById(userId);
        ProfileUpdateRequest request = new ProfileUpdateRequest();
        request.setName(user.getName());
        request.setBio(user.getBio());
        return request;
    }

    @Override
    @Transactional
    public void updateProfile(ProfileUpdateRequest request, Long userId) {
        User user = findById(userId);
        user.updateProfile(request.getName(), request.getBio());
    }
}
