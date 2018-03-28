package com.psheldon.simplespringexamples.rest;

import com.psheldon.simplespringexamples.domain.Book;
import com.psheldon.simplespringexamples.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/books")
class BookController {


    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> listBooks(@RequestParam(required = false) String name) {

        if (name == null) {
            return bookService.findAll();
        }
        else {
            return bookService.findBookByNameLike(name);
        }
    }

    @GetMapping("/{bookId}")
    public Book findBook(@PathVariable Long bookId) {
        return bookService.findBook(bookId);
    }

}
