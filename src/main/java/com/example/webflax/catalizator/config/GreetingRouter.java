package com.example.webflax.catalizator.config;

import com.example.webflax.catalizator.handlers.GreetingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;


@Configuration
public class GreetingRouter {
    private static final RequestPredicate ROUTE_HELLO = RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN));
    private static final RequestPredicate ROUTE_INDEX = RequestPredicates.GET("/");

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {

        return RouterFunctions
                .route(ROUTE_HELLO, greetingHandler::hello)
                .andRoute(ROUTE_INDEX, greetingHandler::index);
    }
}
