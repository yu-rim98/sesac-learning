package org.example.restapi.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.restapi.dto.request.TodoCreateReq;
import org.example.restapi.dto.request.TodoUpdateReq;
import org.example.restapi.dto.response.ApiResponse;
import org.example.restapi.dto.response.TodoResponse;
import org.example.restapi.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<ApiResponse<TodoResponse>> createTodo(
        @Valid @RequestBody TodoCreateReq req) {
        TodoResponse todoResponse = todoService.create(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(todoResponse));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TodoResponse>>> getAll() {
        List<TodoResponse> responses = todoService.findAll();
        return ResponseEntity.ok(ApiResponse.success(responses));
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<ApiResponse<TodoResponse>> findById(@PathVariable Long todoId) {
        TodoResponse todoResponse = todoService.findById(todoId);

        return ResponseEntity.ok(ApiResponse.success(todoResponse));
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<ApiResponse<Void>> deleteById(@PathVariable Long todoId) {
        todoService.deleteById(todoId);
        return ResponseEntity.ok(ApiResponse.success());
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<ApiResponse<TodoResponse>> update(@PathVariable Long todoId,
        @Valid @RequestBody TodoUpdateReq req) {
        TodoResponse updateTodo = todoService.update(todoId, req);
        return ResponseEntity.ok(ApiResponse.success(updateTodo));
    }
}
