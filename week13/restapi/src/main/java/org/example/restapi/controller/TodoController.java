package org.example.restapi.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.restapi.dto.request.TodoCreateReq;
import org.example.restapi.dto.response.TodoResponse;
import org.example.restapi.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<TodoResponse> createTodo(@Valid @RequestBody TodoCreateReq req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(req));
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> getAll() {
        return ResponseEntity.ok(todoService.findAll());
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<TodoResponse> findById(@PathVariable Long todoId) {
        return ResponseEntity.ok(todoService.findById(todoId));
    }
}
