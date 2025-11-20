package org.example.todoapp.service;

import java.util.List;
import org.example.todoapp.dto.TodoDto;
import org.example.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoDto> getAllTodos() {
        return todoRepository.findAll();
    }

    public long getCompletedCount() {
        return todoRepository.findAll().stream().filter(TodoDto::isCompleted).count();
    }

    public long getPendingCount() {
        List<TodoDto> todos = todoRepository.findAll();
        return todos.size() - getCompletedCount();
    }

    public TodoDto getTodoById(Long id) {
        return todoRepository.findById(id)
            .orElseThrow(() -> new NullPointerException("존재하지 않는 todo입니다."));
    }

    public void createTodo(TodoDto todo) {
        validateTitle(todo.getTitle());

        todoRepository.save(todo);
    }

    public void deleteById(Long id) {
        getTodoById(id);
        todoRepository.deleteById(id);
    }

    public void updateTodoById(TodoDto newTodo, Long id) {
        TodoDto originTodo = getTodoById(id);

        validateTitle(newTodo.getTitle());

        originTodo.setTitle(newTodo.getTitle());
        originTodo.setContent(newTodo.getContent());
        originTodo.setCompleted(newTodo.isCompleted());

        todoRepository.save(originTodo);
    }

    public List<TodoDto> searchTodos(String keyword) {
        return todoRepository.findByTitleContaining(keyword);
    }

    public List<TodoDto> getTodosByCompleted(boolean completed) {
        return todoRepository.findByCompleted(completed);
    }

    public void toggleCompleted(Long id) {
        TodoDto todo = getTodoById(id);
        todo.setCompleted(!todo.isCompleted());
        todoRepository.save(todo);
    }

    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("제목은 필수입니다.");
        }

        if (title.length() > 50) {
            throw new IllegalArgumentException("제목은 50자를 초과할 수 없습니다.");
        }
    }

    public void deleteCompletedTodos() {
        List<TodoDto> todos = todoRepository.findAll();
        todos.stream()
            .filter(TodoDto::isCompleted)
            .forEach(todo -> todoRepository.deleteById(todo.getId()));
    }
}
