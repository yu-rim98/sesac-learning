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

    public TodoDto getTodoById(Long id) {
        return todoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 todo입니다."));
    }

    public void createTodo(TodoDto todo) {
        todoRepository.save(todo);
    }

    public void deleteById(Long id) {
        getTodoById(id);
        todoRepository.deleteById(id);
    }

    public void updateTodoById(TodoDto newTodo, Long id) {
        TodoDto originTodo = getTodoById(id);

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
}
