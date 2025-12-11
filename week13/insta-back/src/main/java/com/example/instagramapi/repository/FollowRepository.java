package com.example.instagramapi.repository;

import com.example.instagramapi.entity.Follow;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    // 팔로우 정보 조회
    Optional<Follow> findByFollowerIdAndFollowingId(Long followerId, Long followingId);

    // 팔로우 여부 확인
    boolean existsByFollowerIdAndFollowingId(Long followerId, Long followingId);

    // 팔로워 수
    long countByFollowingId(Long followingId);

    // 팔로잉 수
    long countByFollowerId(Long followerId);

    // 팔로잉 ID 목록
    @Query("select f.following.id from Follow f where f.follower.id = :userId")
    List<Long> findFollowingIdsByFollowerId(@Param("userId") Long userId);

    // 팔로워 목록 (나를 팔로우 하는 사람들)
    @Query("select f from Follow f join fetch f.follower where f.following.id = :userId")
    List<Follow> findFollowersByFollowingId(@Param("userId") Long userId);

    // 팔로잉 목록 (내가 팔로우하는 사람들)
    @Query("select f from Follow f join fetch f.following where f.follower.id = :userId")
    List<Follow> findFollowingsByFollowerId(@Param("userId") Long userId);

}
