package org.example.todoapp.controller;

import java.util.List;
import org.example.todoapp.dto.TodoDto;
import org.example.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todos")
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public String todos(Model model) {
        // 생성 시 사용한 TodoRepository와 다른 인스턴스임
//        TodoRepository todoRepository = new TodoRepository();

        List<TodoDto> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);

        return "todos";
    }

    @GetMapping("/new")
    public String newTodo() {
        return "new";
    }

    @GetMapping("/{id}")
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

    @GetMapping("/create")
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

    @GetMapping("/{id}/edit")
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

    @GetMapping("/{id}/update")
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

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {

        List<TodoDto> todos = todoRepository.findByTitleContaining(keyword);

        model.addAttribute("todos", todos);

        return "todos";
    }

    @GetMapping("/active")
    public String getActiveTodo(Model model) {
        List<TodoDto> todos = todoRepository.findByCompleted(false);

        model.addAttribute("todos", todos);

        return "todos";
    }

    @GetMapping("/completed")
    public String getCompletedTodo(Model model) {
        List<TodoDto> todos = todoRepository.findByCompleted(true);

        model.addAttribute("todos", todos);

        return "todos";
    }

    @GetMapping("/{id}/toggle")
    public String toggle(@PathVariable Long id, Model model) {
        try {
            TodoDto todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 todo입니다."));
            todo.setCompleted(!todo.isCompleted());

            todoRepository.save(todo);

            return "redirect:/todos/" + id;

        } catch (IllegalArgumentException e) {
            return "redirect:/todos";
        }
    }

}
