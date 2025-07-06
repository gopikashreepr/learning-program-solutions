package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public String findBookTitleById(int bookId) {
        if (bookId == 1) {
            return "The Great Gatsby";
        }
        return "Unknown Book";
    }
}
