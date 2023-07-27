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
//    public int getBook_id() {
//        return book_id;
//    }
//
//    public void setBook_id(int book_id) {
//        this.book_id = book_id;
//    }
//
//    public String getBook_author() {
//        return book_author;
//    }
//
//    public void setBook_author(String book_author) {
//        this.book_author = book_author;
//    }
//
//    public String getBook_name() {
//        return book_name;
//    }
//
//    public void setBook_name(String book_name) {
//        this.book_name = book_name;
//    }
}
