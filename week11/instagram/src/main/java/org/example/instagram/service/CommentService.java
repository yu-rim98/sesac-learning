package org.example.instagram.service;

import java.util.List;
import org.example.instagram.dto.request.CommentRequest;
import org.example.instagram.dto.response.CommentResponse;

public interface CommentService {

    CommentResponse create(Long postId, CommentRequest request, Long userId);

    List<CommentResponse> getCommentsByPostId(Long postId);
}
