package org.example.instagram.service;

import lombok.RequiredArgsConstructor;
import org.example.instagram.entity.Follow;
import org.example.instagram.entity.User;
import org.example.instagram.repository.FollowRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FollowServiceImpl implements FollowService{
    private final UserService userService;
    private final FollowRepository followRepository;

    @Override
    @Transactional
    public void toggleFollow(String followingUsername, Long followerId) {
        User follower = userService.findById(followerId);
        User following = userService.findByUsername(followingUsername);

        Follow follow = Follow.builder()
            .follower(follower)
            .following(following)
            .build();

        followRepository.save(follow);
    }
//
//    @Override
//    public boolean isFollowed(User follower, User following) {
//        followRepository
//        return false;
//    }
}
