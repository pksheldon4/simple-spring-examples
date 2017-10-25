package com.psheldon.simplespringexamples.service;

import com.psheldon.simplespringexamples.domain.Book;
import com.psheldon.simplespringexamples.domain.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void testFindAllReturnsNotNull() throws Exception {

        List<Book> books = bookService.findAll();
        Assert.notNull(books, "Book Service result should not be null.");
    }


    @Test
    public void testFindAllReturnsValidMockedBook() throws Exception {

        Book catcher = setupBooks();
        List<Book> books = bookService.findAll();
        Assert.isTrue(books.size() == 1, "Book Service should return 1 result.");
        Assert.isTrue(books.get(0).getName().equals(catcher.getName()),"Invalid book returned.");
    }

    private Book setupBooks() {

        List<Book> books = new ArrayList<>();
        Book catcher = new Book("Catcher in the Rye", "A book about Holden.");
        books.add(catcher);
        BDDMockito.given(bookRepository.findAll()).willReturn(books);
        return catcher;
    }

    @TestConfiguration
    static class BookServiceTestConfiguration {

        @Bean
        public BookService bookService() {
            return new DefaultBookService();
        }
    }
}
