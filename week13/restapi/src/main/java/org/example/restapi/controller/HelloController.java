package org.example.restapi.controller;

import java.util.List;
import org.example.restapi.dto.MessageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/api/message")
    public MessageResponse message() {
        return new MessageResponse("hello", 200);
    }

    @GetMapping("/api/messages")
    public List<MessageResponse> messages() {
        return List.of(
            new MessageResponse("hello1", 200),
            new MessageResponse("hello2", 200),
            new MessageResponse("hello3", 200)
        );
    }

}
