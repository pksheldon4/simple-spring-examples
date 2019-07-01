package com.psheldon.simplespringexamples.config;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long bookId) {
        super("Book ID: " + bookId);
    }
}
