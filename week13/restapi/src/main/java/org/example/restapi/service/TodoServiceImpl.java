package org.example.restapi.service;

import lombok.RequiredArgsConstructor;
import org.example.restapi.dto.request.TodoCreateReq;
import org.example.restapi.dto.response.TodoResponse;
import org.example.restapi.entity.Todo;
import org.example.restapi.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    @Transactional
    public TodoResponse create(TodoCreateReq req) {
        Todo todo = Todo.of(req.getTitle(), req.getContent());

        return TodoResponse.from(todoRepository.save(todo));
    }
}
