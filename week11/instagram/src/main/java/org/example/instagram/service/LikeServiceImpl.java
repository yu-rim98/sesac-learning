package org.example.instagram.service;

import lombok.RequiredArgsConstructor;
import org.example.instagram.entity.Like;
import org.example.instagram.entity.Post;
import org.example.instagram.entity.User;
import org.example.instagram.repository.LikeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LikeServiceImpl implements LikeService{

    private final LikeRepository likeRepository;
    private final PostService postService;
    private final UserService userService;

    @Override
    @Transactional
    public void toggleLike(Long postId, Long userId) {

        Post post = postService.findById(postId);
        User user = userService.findById(userId);

        if (isLiked(postId, userId)) {
            likeRepository.deleteByPostIdAndUserId(postId, userId);
            return;
        }

        Like like = Like.builder()
            .post(post)
            .user(user)
            .build();

        likeRepository.save(like);
    }

    @Override
    public boolean isLiked(Long postId, Long userId) {
        return likeRepository.existsByPostIdAndUserId(postId, userId);
    }

    @Override
    public long getLikeCount(Long postId) {
        return likeRepository.countByPostId(postId);
    }
}
