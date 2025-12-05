package org.example.instagram.repository;

import java.util.List;
import java.util.Optional;
import org.example.instagram.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @EntityGraph(attributePaths = {"user"})
    List<Post> findAllByOrderByCreatedAtDesc();

    @EntityGraph(attributePaths = {"user"})
    List<Post> findByUserIdOrderByCreatedAtDesc(Long userId);

    long countByUserId(Long userId);

    @EntityGraph(attributePaths = {"user"})
    Optional<Post> findById(Long id);

    // 피드
    @Query("select p from Post p join fetch p.user where p.user.id in :userIds order by p.createdAt desc")
    Slice<Post> findFeedPostsByUserIds(@Param("userIds") List<Long> userIds, Pageable pageable);

    // 전체 게시물 (페이징)
    @Query("select p from Post p join fetch p.user order by p.createdAt desc ")
    Slice<Post> findAllWithUserPaging(Pageable pageable);

    @Query("select p from Post p join fetch p.user where p.content like %:keyword% order by p.createdAt desc")
    Slice<Post> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
