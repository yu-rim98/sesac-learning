package org.example.instagram.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.example.instagram.entity.User;

@Getter
@Builder
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private String bio;
    private String username;
    private String profileImageUrl;

    public static UserResponse from(User user) {
        return UserResponse.builder()
            .id(user.getId())
            .name(user.getName())
            .username(user.getUsername())
            .bio(user.getBio())
            .email(user.getEmail())
            .profileImageUrl(user.getProfileImageUrl())
            .build();
    }
}
