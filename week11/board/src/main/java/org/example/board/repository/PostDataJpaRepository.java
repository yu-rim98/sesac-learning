package org.example.board.repository;

import java.util.List;
import org.example.board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
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

    List<Post> findByTitleStartingWith(String keyword); // LIKE keyword%

    List<Post> findByIdGreaterThan(Long id); // > - 특정 Id보다 큰 Id의 행

    List<Post> findAllByOrderByIdDesc(); // ORDER BY id DESC

}
