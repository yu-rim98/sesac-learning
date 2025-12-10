package com.example.instagramapi.controller;

import com.example.instagramapi.dto.request.CommentCreateRequest;
import com.example.instagramapi.dto.response.ApiResponse;
import com.example.instagramapi.dto.response.CommentResponse;
import com.example.instagramapi.security.CustomUserDetails;
import com.example.instagramapi.service.CommentService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<ApiResponse<CommentResponse>> createdComment(@PathVariable Long postId,
        @AuthenticationPrincipal CustomUserDetails customUserDetails,
        @Valid @RequestBody CommentCreateRequest request) {
        CommentResponse response = commentService.create(postId, customUserDetails.getId(),
            request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(response));
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<CommentResponse>>> getComments(
        @PathVariable Long postId) {
        List<CommentResponse> responses = commentService.findByPostId(postId);
        return ResponseEntity.ok(ApiResponse.success(responses));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<ApiResponse<Void>> deleteComment(@PathVariable Long commentId,
        @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        commentService.delete(commentId, customUserDetails.getId());
        return ResponseEntity.noContent().build();
    }

}
