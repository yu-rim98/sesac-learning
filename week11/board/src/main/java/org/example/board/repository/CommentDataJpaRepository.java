package org.example.board.repository;

import org.example.board.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDataJpaRepository extends JpaRepository<Comment, Long> {

}
