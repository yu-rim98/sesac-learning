package org.example.instagram.dto.response;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import org.example.instagram.entity.Post;

@Getter
@Builder
public class PostResponse {
    
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private String imageUrl;

    private Long userId;
    private String username;
    private String profileImageUrl;

    private long commentCount;
    private long likeCount;

    public static PostResponse from(Post saved) {
        return PostResponse.builder()
            .id(saved.getId())
            .content(saved.getContent())
            .createdAt(saved.getCreatedAt())
            .userId(saved.getUser().getId())
            .username(saved.getUser().getUsername())
            .imageUrl(saved.getImageUrl())
            .profileImageUrl(saved.getUser().getProfileImageUrl())
            .build();
    }

    public static PostResponse from(Post saved, long commentCount, long likeCount) {
        return PostResponse.builder()
            .id(saved.getId())
            .content(saved.getContent())
            .createdAt(saved.getCreatedAt())
            .userId(saved.getUser().getId())
            .username(saved.getUser().getUsername())
            .commentCount(commentCount)
            .likeCount(likeCount)
            .imageUrl(saved.getImageUrl())
            .profileImageUrl(saved.getUser().getProfileImageUrl())
            .build();
    }
}
