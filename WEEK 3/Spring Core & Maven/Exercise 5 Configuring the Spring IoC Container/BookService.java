package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Setter for Spring DI
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printBookTitle(int bookId) {
        String title = bookRepository.findBookTitleById(bookId);
        System.out.println("Book Title: " + title);
    }
}
