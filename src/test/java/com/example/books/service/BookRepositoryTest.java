package com.example.books.service;

import com.example.books.entity.Books;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {

    private BookRepository bookRepository =new BookRepository();
    @Test
    void findAllBooks() {
        Flux<Books> allBooks = bookRepository.findAllBooks();
        StepVerifier.create(allBooks).expectSubscription().expectNextCount(3).verifyComplete();
    }

    @Test
    void findByFirstName() {
       bookRepository.data();
        Flux<Books> byFirstName = bookRepository.findByFirstName("chetan");
        StepVerifier.create(byFirstName)
                .expectSubscription()
                .expectNextMatches(books -> books.getBook_author().equals("chetan bhagath"))
                .expectNextCount(2)
                .verifyComplete();
    }
}