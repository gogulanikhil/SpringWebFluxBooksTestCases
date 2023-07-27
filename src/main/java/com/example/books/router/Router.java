package com.example.books.router;

import com.example.books.handler.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class Router {
    @Autowired
    Handler handler;
    @Bean
    public RouterFunction<ServerResponse> getAllBooks(){
        return RouterFunctions
                .route()
                .GET("/allbooks",handler::findAllBooks)
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> findBookByFirstName(){
        return RouterFunctions
                .route()
                .GET("/byfirstname",handler::findBookByFirstName)
                .build();
    }
}
