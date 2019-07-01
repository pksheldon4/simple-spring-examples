package com.pksheldon4.books.service;

import com.pksheldon4.books.domain.Book;
import com.pksheldon4.books.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultBookService implements BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> findAll() {

        return repository.findAll();
    }
    public Optional<Book> findBook(Long id) {

        return repository.findById(id);
    }

    public List<Book> findBookByNameLike(String nameLikeString) {

        return repository.findBooksByNameContainingIgnoreCase(nameLikeString);
    }

}
