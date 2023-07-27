package com.example.books.handler;

import com.example.books.entity.Books;
import com.example.books.service.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
@Controller
public class Handler {
    @Autowired
    BookRepository bookRepository;

    public Mono<ServerResponse> findAllBooks(ServerRequest serverRequest){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(bookRepository.findAllBooks(),Books.class);
    }
    public Mono<ServerResponse> findBookByFirstName(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(bookRepository.findByFirstName("chetan"),Books.class);
    }
}
