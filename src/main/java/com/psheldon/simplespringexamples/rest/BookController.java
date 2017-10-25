package com.psheldon.simplespringexamples.rest;

import com.psheldon.simplespringexamples.domain.Book;
import com.psheldon.simplespringexamples.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
class BookController {


    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> listBooks() {

        return bookService.findAll();
    }
}
