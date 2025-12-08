package org.example.restapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.restapi.dto.request.TodoCreateReq;
import org.example.restapi.dto.response.TodoResponse;
import org.example.restapi.service.TodoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public TodoResponse createTodo(@Valid @RequestBody TodoCreateReq req) {
        return todoService.create(req);
    }
}
