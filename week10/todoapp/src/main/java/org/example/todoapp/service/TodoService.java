package org.example.todoapp.service;

import java.util.List;
import org.example.todoapp.dto.TodoDto;
import org.example.todoapp.entity.TodoEntity;
import org.example.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void createTodo(TodoDto dto) {
        validateTitle(dto.getTitle());

        TodoEntity entity = new TodoEntity(null, dto.getTitle(), dto.getContent(),
            dto.isCompleted());

        todoRepository.save(entity);
    }

    public List<TodoDto> getAllTodos() {
        return todoRepository.findAll().stream()
            .map(this::toDto)
            .toList();
    }

    public TodoDto getTodoById(Long id) {
        return toDto(findEntityById(id));
    }

    public void updateTodoById(TodoDto dto, Long id) {
        validateTitle(dto.getTitle());

        TodoEntity entity = findEntityById(id);

        entity.update(dto.getTitle(), dto.getContent(), dto.isCompleted());
    }

    public void deleteById(Long id) {
        findEntityById(id);
        todoRepository.deleteById(id);
    }

    public List<TodoDto> searchTodos(String keyword) {
        return todoRepository.findByTitleContaining(keyword).stream()
            .map(this::toDto)
            .toList();
    }

    public List<TodoDto> getTodosByCompleted(boolean completed) {
        return todoRepository.findByCompleted(completed).stream()
            .map(this::toDto)
            .toList();
    }

    public void toggleCompleted(Long id) {
        TodoEntity entity = findEntityById(id);
        entity.changeCompleted();
    }

    public long getCompletedCount() {
        return todoRepository.findAll().stream()
            .filter(TodoEntity::isCompleted)
            .count();
    }

    public long getPendingCount() {
        List<TodoEntity> entities = todoRepository.findAll();
        return entities.size() - getCompletedCount();
    }

    public void deleteCompletedTodos() {
        List<TodoEntity> entities = todoRepository.findAll();
        entities.stream()
            .filter(TodoEntity::isCompleted)
            .forEach(todo -> todoRepository.deleteById(todo.getId()));
    }

    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("제목은 필수입니다.");
        }

        if (title.length() > 50) {
            throw new IllegalArgumentException("제목은 50자를 초과할 수 없습니다.");
        }
    }

    private TodoDto toDto(TodoEntity todoEntity) {
        TodoDto dto = new TodoDto();
        dto.setId(todoEntity.getId());
        dto.setTitle(todoEntity.getTitle());
        dto.setContent(todoEntity.getContent());
        dto.setCompleted(todoEntity.isCompleted());
        return dto;
    }

    private TodoEntity findEntityById(Long id) {
        return todoRepository.findById(id)
            .orElseThrow(() -> new NullPointerException("존재하지 않는 todo입니다."));
    }
}
