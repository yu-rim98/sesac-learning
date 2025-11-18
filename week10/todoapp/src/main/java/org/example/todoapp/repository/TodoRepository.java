package org.example.todoapp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    public TodoDto findById(Long id) {
        return storage.get(id);
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }

    public TodoDto update(Long id, String title, String content, Boolean completed) {
        TodoDto todo = findById(id);

        todo.setTitle(title);
        todo.setContent(content);
        todo.setCompleted(completed);

        return save(todo);
    }
}
