package com.example.webflax.catalizator.handlers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class GreetingHandler {

    private final static String USER = "user";
    private final static String GUEST = "Guest";
    private final static String INDEX_TEMP = "index";
    private final static String HELLO_MESSAGE = "Hello, Spring";

    public Mono<ServerResponse> hello(ServerRequest serverRequest) {
        var body = BodyInserters.fromValue(HELLO_MESSAGE);
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(body);
    }

    public Mono<ServerResponse> index(ServerRequest serverRequest) {
        var user = serverRequest.queryParam(USER).orElse(GUEST);
        return ServerResponse.ok().render(INDEX_TEMP, Map.of(USER, user));
    }
}
