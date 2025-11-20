package org.example.todoapp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.example.todoapp.dto.TodoDto;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {

    private final Map<Long, TodoDto> storage = new ConcurrentHashMap<>();
    private Long nextId = 1L;


    public TodoDto save(TodoDto todo) {

        if (todo.getId() == null) {
            todo.setId(nextId++);
        }

        storage.put(todo.getId(), todo);
        return todo;
    }


    public List<TodoDto> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<TodoDto> findById(Long id) {
//        return storage.get(id);
        // null일 수도 있음을 알림
        return Optional.ofNullable(storage.get(id));
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }

    public TodoDto update(TodoDto todoDto, Long id) {
//        TodoDto todo = findById(id);
        TodoDto todo = findById(id).orElseThrow(
            () -> new IllegalArgumentException("존재하지 않는 todo입니다."));

        todo.setTitle(todoDto.getTitle());
        todo.setContent(todoDto.getContent());
        todo.setCompleted(todoDto.isCompleted());

        return save(todo);
    }

    public List<TodoDto> findByTitleContaining(String keyword) {
        return storage.values().stream()
            .filter((todo) -> todo.getTitle().contains(keyword))
            .toList();
    }

    public List<TodoDto> findByCompleted(boolean completed) {
        return storage.values().stream()
            .filter((todo) -> todo.isCompleted() == completed)
            .toList();
    }
}
