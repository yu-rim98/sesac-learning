package org.example.restapi.service;

import java.util.List;
import org.example.restapi.dto.request.TodoCreateReq;
import org.example.restapi.dto.response.TodoResponse;

public interface TodoService {

    TodoResponse create(TodoCreateReq req);

    List<TodoResponse> findAll();

    TodoResponse findById(Long todoId);
}
