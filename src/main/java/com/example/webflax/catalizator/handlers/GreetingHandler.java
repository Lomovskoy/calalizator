package com.example.webflax.catalizator.handlers;

import com.example.webflax.catalizator.domain.Message;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class GreetingHandler {

    private final static String USER = "user";
    private final static String GUEST = "Guest";
    private final static String INDEX_TEMP = "index";

    public Mono<ServerResponse> hello(ServerRequest serverRequest) {
        var start = serverRequest.queryParam("start").map(Long::valueOf).orElse(0L);
        var count = serverRequest.queryParam("count").map(Long::valueOf).orElse(3L);

        var data = Flux.just(
                "Hello reactive!",
                "Mare then one",
                "Third post",
                "Fourth post",
                "Fifth post")
                .skip(start)
                .take(count)
                .map(Message::new);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(data, Message.class);
    }

    public Mono<ServerResponse> index(ServerRequest serverRequest) {
        var user = serverRequest.queryParam(USER).orElse(GUEST);
        return ServerResponse.ok().render(INDEX_TEMP, Map.of(USER, user));
    }
}
