package com.example.books.service;

import com.example.books.entity.Books;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class BookRepository{
    Map<Integer, Books> map=new LinkedHashMap<Integer, Books>();
    @PostConstruct
      void data(){

        map.put(01,new Books(01,"chetan bhagath","one indian girl"));
        map.put(02,new Books(02,"amith","triology of siva"));
     }
     public Flux<Books> findAllBooks(){
         return Flux.fromStream(map.values().stream());
     }
    public Flux<Books> findByFirstName(String firstName){
        return Flux.fromStream(map.values().stream()
                .filter(book -> book.getBook_author()
                        .startsWith(firstName)));
    }
}
