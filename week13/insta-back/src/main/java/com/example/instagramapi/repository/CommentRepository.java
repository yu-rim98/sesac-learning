package com.example.instagramapi.repository;

import com.example.instagramapi.entity.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 특정 게시물의 댓글 목록
    @Query("select c from Comment c join fetch c.user where c.post.id = :postId")
    List<Comment> findByPostIdWithUser(@Param("postId") Long postId);

    // 게시물의 댓글 수
    long countByPostId(Long postId);
}
