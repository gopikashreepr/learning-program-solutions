package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;
    private int defaultBookId;

    public BookService(int defaultBookId) {
        this.defaultBookId = defaultBookId;
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printDefaultBookTitle() {
        String title = bookRepository.findBookTitleById(defaultBookId);
        System.out.println("Default Book Title: " + title);
    }
}
