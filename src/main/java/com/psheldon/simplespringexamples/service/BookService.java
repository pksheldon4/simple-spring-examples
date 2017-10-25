package com.psheldon.simplespringexamples.service;


import com.psheldon.simplespringexamples.domain.Book;

import java.util.List;

public interface BookService {

    public List<Book> findAll();

}
