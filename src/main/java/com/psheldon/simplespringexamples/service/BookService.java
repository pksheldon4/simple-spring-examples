package com.psheldon.simplespringexamples.service;


import com.psheldon.simplespringexamples.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public List<Book> findAll();

    public Optional<Book> findBook(Long id);

    public List<Book> findBookByNameLike(String nameLikeString);

}
