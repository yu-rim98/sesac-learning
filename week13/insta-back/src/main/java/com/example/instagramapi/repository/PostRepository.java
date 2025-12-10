package com.example.instagramapi.repository;

import com.example.instagramapi.entity.Post;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // 전체 게시물 조회
    @Query("select p from Post p join fetch p.user order by p.createdAt desc ")
    List<Post> findAllByWithUser();

    // 단일 게시물 조회
    @Query("select p from Post p join fetch p.user where p.id = :id")
    Optional<Post> findByIdWithUser(@Param("id") Long id);

    // 특정 사용자의 게시물 조회
    @Query("select p from Post p join fetch p.user where p.user.id = :userId order by p.createdAt desc")
    List<Post> findByUserIdWithUser(@Param("userId") Long userId);

    // 사용자별 게시물 수
    long countByUserId(Long userId);
}
