package org.example.instagram.service;

import lombok.RequiredArgsConstructor;
import org.example.instagram.dto.request.CommentCreateRequest;
import org.example.instagram.dto.response.CommentResponse;
import org.example.instagram.entity.Comment;
import org.example.instagram.entity.Post;
import org.example.instagram.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {

    private final PostService postService;
    private final UserService userService;
    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public CommentResponse create(Long postId, CommentCreateRequest request, Long userId) {
        Post post = postService.findById(postId);
        User user = userService.findById(userId);

        Comment comment = Comment.builder()
            .content(request.getContent())
            .user(user)
            .post(post)
            .build();

        return CommentResponse.from(commentRepository.save(comment));
    }
}
