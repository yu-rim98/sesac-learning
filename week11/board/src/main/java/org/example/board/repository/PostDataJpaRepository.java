package org.example.board.repository;

import java.util.List;
import org.example.board.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDataJpaRepository extends JpaRepository<Post, Long> {


    // 기본으로 제공되는 CRUD 메서드들

    // 저장 (INSERT와 UPDATE를 처리)
    // save() - 엔티티를 매개변수로 받고 저장된 엔티티를 반환

    // 조회
    // findById() - Id(pk)를 매개변수로 받고 엔티티를 반환 (Optional)
    // findAll() - 매개변수를 받지 않고 엔티티 전체를 반환 (List)
    // findAll(Sort sort) - 정렬 조회 (List)

    // 삭제
    // deleteById() - Id(pk)를 매개변수로 받고 엔티티(행)를 삭제 (void)
    // delete() - 엔티티를 매개변수로 받고 엔티티(행)를 삭제 (void)

    // 개수 조회
    // count() - long 타입으로 행의 수 반환

    // 존재 여부 확인
    // existsById() - boolean 타입으로 존재 여부 반환
    // ...


    // findBy + 필드명 + 조건 - JPA query method
    List<Post> findByTitleContaining(String keyword); // LIKE %keyword%

    // @Query 방식
    @Query("select p from Post p where p.title like %:keyword%")
    List<Post> searchByTitle(@Param("keyword") String keyword);

    List<Post> findByTitleStartingWith(String keyword); // LIKE keyword%

    List<Post> findByIdGreaterThan(Long id); // > - 특정 Id보다 큰 Id의 행

    List<Post> findAllByOrderByIdDesc(); // ORDER BY id DESC

    // 제목 or 내용으로 검색
    List<Post> findByTitleContainingOrContentContaining(String titleKeyword, String contentKeyword);

    // @Query 방식
    @Query("select p from Post p where p.title like %:keyword% or p.content like %:keyword%")
    List<Post> searchByKeyword(@Param("keyword") String keyword);

    @Query(value = "select * from post where title like %:keyword% order by id desc", nativeQuery = true)
    List<Post> searchByTitleNative(@Param("keyword") String keyword);

    List<Post> findTop3ByOrderByCreatedAtDesc();

    @Query("select p from Post p order by p.createdAt desc")
    List<Post> findRecentPosts(Pageable pageable);

    @Query(value = "select * from post order by created_at desc limit 3", nativeQuery = true)
    List<Post> findRecentPostsNative();

    // List<Post> findAll() -> 기본 구현되어 있는 메서드 존재함
    Page<Post> findAll(Pageable pageable); // 오버로딩
}
