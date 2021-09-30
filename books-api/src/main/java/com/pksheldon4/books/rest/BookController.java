package com.pksheldon4.books.rest;

import com.pksheldon4.books.config.BookNotFoundException;
import com.pksheldon4.books.domain.Book;
import com.pksheldon4.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
class BookController {


    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> listBooks(@RequestParam(required = false) String name) {

        if (name == null) {
            return bookService.findAll();
        } else {
            return bookService.findBookByNameLike(name);
        }
    }

    @GetMapping("/{bookId}")
    public Book findBook(@PathVariable Long bookId) {
        Optional<Book> maybeBook = bookService.findBook(bookId);
        if (maybeBook.isPresent()) {
            return maybeBook.get();
        } else {
            throw new BookNotFoundException(bookId);
        }
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
}
