package com.example.books.service.handler;

import com.example.books.entity.Books;
import com.example.books.service.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class Handler {

    @Autowired
    BookRepository bookRepository;
    public Mono<ServerResponse> data(ServerRequest serverRequest){
        Flux res=bookRepository.findAllBooks();
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(res,Books.class);
    }
}
