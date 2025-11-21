package org.example.todoapp;

import org.example.todoapp.entity.TodoEntity;
import org.example.todoapp.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoappApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoappApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(TodoRepository todoRepository) {
        return args -> {
            todoRepository.save(new TodoEntity(null, "드라마 보기", "갯마을 차차차", false));
            todoRepository.save(new TodoEntity(null, "영화 보기", "이터널선샤인 ", false));
            todoRepository.save(new TodoEntity(null, "운동하기", "헬스", false));
        };
    }
}
