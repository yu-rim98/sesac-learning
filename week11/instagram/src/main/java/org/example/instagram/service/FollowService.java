package org.example.instagram.service;

import org.example.instagram.entity.User;

public interface FollowService {

    void toggleFollow(String username, Long userId);
//    boolean isFollowed(User follower, User following);
}
