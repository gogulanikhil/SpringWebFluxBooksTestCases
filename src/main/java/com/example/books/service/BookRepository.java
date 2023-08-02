package com.example.books.service;

import com.example.books.entity.Books;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class BookRepository{
    Map<Integer, Books> map=new LinkedHashMap<>();
    @PostConstruct
      void data(){
        map.put(1,new Books(1,"chetan bhagath","one indian girl"));
        map.put(2,new Books(2,"amith","triology of siva"));
        map.put(3,new Books(3,"chetan bhagath","random name"));
        map.put(4,new Books(4,"chetan bhagath","random name2"));
    }
     public Flux<Books> findAllBooks(){
         data();
         System.out.println(map);
         return Flux.fromStream(map.values().stream());
     }
    public Flux<Books> findByFirstName(String firstName){
        return Flux.fromStream(map.values().stream()
                .filter(book -> book.getBook_author()
                        .startsWith(firstName)));
    }
    public Flux<String> findById(int id){
        return Flux.fromStream(map.values().stream()
                .filter(books -> books.getBook_id()== 1)).map(Books::getBook_name);
    }
}
