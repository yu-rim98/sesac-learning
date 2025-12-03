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

        validateNotSelfFollow(follower.getId(), following.getId());

        if (isFollowing(follower.getId(), following.getId())) {
            followRepository.deleteByFollowerIdAndFollowingId(follower.getId(), following.getId());
            return;
        }

        Follow follow = Follow.builder()
            .follower(follower)
            .following(following)
            .build();

        followRepository.save(follow);
    }

    @Override
    public boolean isFollowing(Long followerId, Long followingId) {
        return followRepository.existsByFollowerIdAndFollowingId(followerId, followingId);
    }

    @Override
    public long countByFollowerId(Long followerId) {
        return followRepository.countByFollowerId(followerId);
    }

    @Override
    public long countByFollowingId(Long followingId) {
        return followRepository.countByFollowingId(followingId);
    }

    private void validateNotSelfFollow(Long followerId, Long followingId) {
        if ( followerId.equals(followingId)) {
            throw new RuntimeException("자기 자신은 팔로우 할 수 없습니다.");
        }
    }

}
