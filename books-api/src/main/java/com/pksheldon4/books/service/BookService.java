package com.pksheldon4.books.service;


import com.pksheldon4.books.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public List<Book> findAll();

    public Optional<Book> findBook(Long id);

    public List<Book> findBookByNameLike(String nameLikeString);

    public Book createBook(Book book);
}
