package com.example.webflax.catalizator.service;

import com.example.webflax.catalizator.domain.Message;
import com.example.webflax.catalizator.repo.MessageRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class MessageService {
    private final MessageRepo messageRepo;

    public Flux<Message> list() {
        return messageRepo.findAll();
    }

    public Mono<Message> addOne(Message message) {
        return messageRepo.save(message);
    }
}
