package com.example.books.handler;

import com.example.books.entity.Books;
import com.example.books.service.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Book;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HandlerTest {
    @Autowired
    Handler handler;

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    BookRepository bookRepository;

    Books books1=new Books(1,"chetan bhagath","one indian girl");
    Books books2=new Books(2,"amith","triology of siva");
    Books books3=new Books(3,"chetan bhagath","random name");

//    Flux<Books> expectedResults=Flux.just(books1,books2,books3);
    Flux<Books> expectedResultsbyname=Flux.just(books1,books3);

    @Test
    void findAllBooks() {
        Flux store= bookRepository.findAllBooks();
        webTestClient.get()
                .uri("/allbooks")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectBodyList(Books.class)
                .hasSize(3)
                .equals(store.count());
    }
    @Test
    void findBookByFirstName() {
         webTestClient.get()
                 .uri("/byfirstname")
                 .accept(MediaType.APPLICATION_JSON)
                 .exchange()
                 .expectBodyList(Books.class)
                 .hasSize(2)
                 .isEqualTo(expectedResultsbyname.collectList().block());
    }
}