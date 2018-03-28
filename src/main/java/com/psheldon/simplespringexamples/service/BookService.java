package com.psheldon.simplespringexamples.service;


import com.psheldon.simplespringexamples.domain.Book;

import java.util.List;

public interface BookService {

    public List<Book> findAll();

    public Book findBook(Long id);

    public List<Book> findBookByNameLike(String nameLikeString);

}
