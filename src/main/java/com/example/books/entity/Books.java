package com.example.books.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Books {
    private int book_id;
    private String book_author;
    private String book_name;
}