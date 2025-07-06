package com.library.repository;

public class BookRepository {
    public String findBookTitleById(int bookId) {
        // Dummy logic for testing
        if (bookId == 1) {
            return "The Great Gatsby";
        } else {
            return "Unknown Book";
        }
    }
}
