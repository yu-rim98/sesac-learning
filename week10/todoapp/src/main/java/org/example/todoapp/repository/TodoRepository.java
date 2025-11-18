package org.example.todoapp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.example.todoapp.dto.TodoDto;

public class TodoRepository {

    private final Map<Long, TodoDto> storage = new ConcurrentHashMap<>();
    private Long nextId = 1L;

    
    public TodoDto save(TodoDto todo) {
        todo.setId(nextId++);
        storage.put(todo.getId(), todo);
        return todo;
    }


    public List<TodoDto> findAll() {
        return new ArrayList<>(storage.values());
    }
}
