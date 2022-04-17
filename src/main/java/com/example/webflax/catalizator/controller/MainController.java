package com.example.webflax.catalizator.controller;

import com.example.webflax.catalizator.domain.Message;
import com.example.webflax.catalizator.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/controller")
@AllArgsConstructor
public class MainController {

    private final MessageService messageService;

    @GetMapping
    public Flux<Message> list(@RequestParam(defaultValue = "0") Long start,
                              @RequestParam(defaultValue = "3") Long count) {
        return messageService.list();
    }

    @PostMapping
    public Mono<Message> add(@RequestBody Message message) {
        return messageService.addOne(message);
    }
}
