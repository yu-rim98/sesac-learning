package org.example.instagram.service;

import java.util.List;
import org.example.instagram.dto.request.CommentCreateRequest;
import org.example.instagram.dto.response.CommentResponse;

public interface CommentService {

    CommentResponse create(Long postId, CommentCreateRequest request, Long userId);

    List<CommentResponse> getCommentsByPostId(Long postId);
}
