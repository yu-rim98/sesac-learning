package org.example.todoapp.controller;

import java.util.List;
import org.example.todoapp.dto.TodoDto;
import org.example.todoapp.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String todos(Model model) {

        List<TodoDto> todos = todoService.getAllTodos();
        long completedCount = todoService.getCompletedCount();
        long pendingCount = todoService.getPendingCount();
        model.addAttribute("todos", todos);
        model.addAttribute("completedCount", completedCount);
        model.addAttribute("pendingCount", pendingCount);

        return "todos";
    }

    @GetMapping("/new")
    public String newTodo(Model model) {
        model.addAttribute("todo", new TodoDto());
        return "form";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {

        try {
            TodoDto todo = todoService.getTodoById(id);
            model.addAttribute("todo", todo);

            return "detail";
        } catch (IllegalArgumentException e) {
            return "redirect:/todos";
        }

    }

    @PostMapping
    public String create(@ModelAttribute TodoDto todo,
        RedirectAttributes redirectAttributes) {

        try {
            todoService.createTodo(todo);
            redirectAttributes.addFlashAttribute("message", "Todo를 추가했습니다.");
        } catch (IllegalArgumentException e) {
            return "redirect:/todos";
        }

        return "redirect:/todos";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {

        // try-catch 필요성
        todoService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Todo를 삭제했습니다.");
        redirectAttributes.addFlashAttribute("status", "delete");
        return "redirect:/todos";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Long id, Model model) {

        try {
            TodoDto todo = todoService.getTodoById(id);
            model.addAttribute("todo", todo);

            return "form";
        } catch (IllegalArgumentException e) {
            return "redirect:/todos";
        }
    }

    @PostMapping("/{id}/update")
    public String update(@ModelAttribute TodoDto todoDto, @PathVariable Long id,
        RedirectAttributes redirectAttributes
        ) {

        try {
            todoService.updateTodoById(todoDto, id);
            redirectAttributes.addFlashAttribute("message", "Todo를 수정했습니다.");

            return "redirect:/todos/" + id;
        } catch (IllegalArgumentException | NullPointerException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());

            return "redirect:/todos";
        }
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {

        List<TodoDto> todos = todoService.searchTodos(keyword);
        model.addAttribute("todos", todos);

        return "todos";
    }

    @GetMapping("/active")
    public String getActiveTodo(Model model) {
        List<TodoDto> todos = todoService.getTodosByCompleted(false);

        model.addAttribute("todos", todos);

        return "todos";
    }

    @GetMapping("/completed")
    public String getCompletedTodo(Model model) {
        List<TodoDto> todos = todoService.getTodosByCompleted(true);
        model.addAttribute("todos", todos);

        return "todos";
    }

    @GetMapping("/{id}/toggle")
    public String toggle(@PathVariable Long id) {
        try {
            todoService.toggleCompleted(id);

            return "redirect:/todos/" + id;
        } catch (IllegalArgumentException e) {
            return "redirect:/todos";
        }
    }

    @PostMapping("/completed")
    public String deleteCompletedTodos(RedirectAttributes redirectAttributes) {
        todoService.deleteCompletedTodos();
        redirectAttributes.addFlashAttribute("message", "Todo를 삭제했습니다.");
        redirectAttributes.addFlashAttribute("status", "delete");
        return "redirect:/todos";
    }

}
