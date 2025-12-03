package org.example.instagram.service;

public interface FollowService {

    void toggleFollow(String username, Long userId);
    boolean isFollowing(Long followerId, Long followingId);

    long countByFollowerId(Long followerId);

    long countByFollowingId(Long followingId);
}
