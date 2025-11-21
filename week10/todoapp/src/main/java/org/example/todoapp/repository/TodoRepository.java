package org.example.todoapp.repository;

import java.util.List;
import org.example.todoapp.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    List<TodoEntity> findByTitleContaining(String keyword);
    
    List<TodoEntity> findByCompleted(boolean completed);

}
