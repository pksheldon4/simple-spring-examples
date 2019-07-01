package com.pksheldon4.books.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testBooksLoaded() throws Exception {
        List<Book> books = bookRepository.findAll();
        Assert.notNull(books,"BookRepository can not return null.");
        Assert.notEmpty(books, "BookRepository should not return an empty List.");
        Assert.isTrue(books.size() == 2, "Should be 2 books returned, but found " + books.size());
    }
}
