package com.pksheldon4.books.config;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long bookId) {
        super("Book ID: " + bookId);
    }
}
