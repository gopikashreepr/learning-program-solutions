package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired  // 👈 This tells Spring to inject BookRepository automatically
    private BookRepository bookRepository;

    public void printBookTitle(int bookId) {
        String title = bookRepository.findBookTitleById(bookId);
        System.out.println("Book Title: " + title);
    }
}
