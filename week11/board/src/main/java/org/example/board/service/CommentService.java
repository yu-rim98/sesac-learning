package org.example.board.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.board.entity.Comment;
import org.example.board.entity.Post;
import org.example.board.repository.CommentDataJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final PostService postService;
    private final CommentDataJpaRepository commentDataJpaRepository;

    @Transactional
    public void createComment(Long postId, Comment comment) {
        Post post = postService.getPostById(postId);
        comment.registerPost(post);

        commentDataJpaRepository.save(comment);
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentDataJpaRepository.findByPostId(postId);
    }
}
