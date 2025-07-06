package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public String findBookTitleById(int bookId) {
        return bookId == 1 ? "The Great Gatsby" : "Unknown Book";
    }
}
