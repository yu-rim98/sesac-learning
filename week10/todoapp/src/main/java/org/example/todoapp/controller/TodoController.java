package org.example.todoapp.controller;

import org.example.todoapp.dto.TodoDto;
import org.example.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
    private final TodoRepository todoRepository = new TodoRepository();

    @GetMapping("/todos")
    public String todos(Model model) {
        // 생성 시 사용한 TodoRepository와 다른 인스턴스임
//        TodoRepository todoRepository = new TodoRepository();

        return "todos";
    }

    @GetMapping("/todos/new")
    public String newTodo() {
        return "new";
    }

    @GetMapping("/todos/create")
    public String create(@RequestParam String title, @RequestParam String content,
        Model model) {
        TodoDto todoDto = new TodoDto(null, title, content, false);
//        TodoRepository todoRepository = new TodoRepository();
        TodoDto saveTodo = todoRepository.save(todoDto);

        model.addAttribute("todo", saveTodo);

        return "create";
    }

}
