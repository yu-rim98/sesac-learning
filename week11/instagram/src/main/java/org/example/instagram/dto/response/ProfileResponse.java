package org.example.instagram.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.example.instagram.entity.User;

@Getter
@Builder
public class ProfileResponse {

    private Long id;
    private String username;
    private String bio;
    private String name;
    private String profileImageUrl;

    private long postCount;
    private long followerCount;
    private long followingCount;

    public static ProfileResponse from(User user) {
        return ProfileResponse.builder()
            .id(user.getId())
            .username(user.getUsername())
            .bio(user.getBio())
            .name(user.getName())
            .profileImageUrl(user.getProfileImageUrl())
            .build();
    }

    public static ProfileResponse from(User user, long postCount, long followerCount, long followingCount) {
        return ProfileResponse.builder()
            .id(user.getId())
            .username(user.getUsername())
            .bio(user.getBio())
            .name(user.getName())
            .postCount(postCount)
            .followerCount(followerCount)
            .followingCount(followingCount)
            .profileImageUrl(user.getProfileImageUrl())
            .build();
    }
}
