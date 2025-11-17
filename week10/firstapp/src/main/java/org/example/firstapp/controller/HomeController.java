package org.example.firstapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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

    @GetMapping("/fruits")
    public String fruits(Model model) {
        List<String> fruitList = new ArrayList<>();
        fruitList.add("apple");
        fruitList.add("orange");
        fruitList.add("banana");
        fruitList.add("kiwi");

        model.addAttribute("fruits", fruitList);
        return "fruits";
    }

    @GetMapping("/grade")
    public String grade(Model model) {
        int score = 80;
        model.addAttribute("score", score);

        return "grade";
    }

    @GetMapping("/lunch")
    public String lunch(Model model) {
        List<String> menus = Arrays.asList("김밥", "라면", "돈까스");

        Random random = new Random();

        model.addAttribute("menu", menus.get(random.nextInt(menus.size())));
        return "lunch";
    }
}
