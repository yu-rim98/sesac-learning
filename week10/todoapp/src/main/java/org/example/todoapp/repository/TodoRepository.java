package org.example.todoapp.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.example.todoapp.dto.TodoDto;

public class TodoRepository {

    private final Map<Long, TodoDto> storage = new ConcurrentHashMap<>();
    private Long nextId = 1L;




}
