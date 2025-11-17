package org.example.firstapp.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        String name = "yurim";
        model.addAttribute("name", name);

        return "hello";
    }

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("username", "kim");
        model.addAttribute("age", 20);
        model.addAttribute("city", "seoul");
        return "user";
    }

}
