package org.example.todoapp.controller;

import java.util.List;
import org.example.todoapp.dto.TodoDto;
import org.example.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/todos")
    public String todos(Model model) {
        // 생성 시 사용한 TodoRepository와 다른 인스턴스임
//        TodoRepository todoRepository = new TodoRepository();

        List<TodoDto> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);

        return "todos";
    }

    @GetMapping("/todos/new")
    public String newTodo() {
        return "new";
    }

    @GetMapping("/todos/{id}")
    public String detail(@PathVariable Long id, Model model) {
        //        TodoDto todo = todoRepository.findById(id);

        try {
            TodoDto todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 todo입니다."));

            model.addAttribute("todo", todo);

            return "detail";

        } catch (IllegalArgumentException e) {
            return "redirect:/todos";
        }

    }

    @GetMapping("/todos/create")
    public String create(@RequestParam String title, @RequestParam String content,
        Model model) {
        TodoDto todoDto = new TodoDto(null, title, content, false);
//        TodoRepository todoRepository = new TodoRepository();
        TodoDto saveTodo = todoRepository.save(todoDto);

        model.addAttribute("todo", saveTodo);

        return "redirect:/todos";
    }

    @GetMapping("/todos/{id}/delete")
    public String delete(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return "redirect:/todos";
    }

    @GetMapping("/todos/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {

        try {
            TodoDto todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 todo입니다."));

            model.addAttribute("todo", todo);
            return "edit";

        } catch (IllegalArgumentException e) {
            return "redirect:/todos";
        }
    }

    @GetMapping("/todos/{id}/update")
    public String update(@PathVariable Long id, @RequestParam String title,
        @RequestParam String content, @RequestParam(defaultValue = "false") Boolean completed,
        Model model) {
        
        try {
            TodoDto todo = todoRepository.update(id, title, content, completed);

            model.addAttribute("todo", todo);
            return "redirect:/todos/" + id;

        } catch (IllegalArgumentException e) {
            return "redirect:/todos";
        }
    }

}
