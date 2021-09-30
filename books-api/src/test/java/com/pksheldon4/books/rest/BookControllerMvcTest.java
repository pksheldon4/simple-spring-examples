package com.pksheldon4.books.rest;

import com.pksheldon4.books.domain.Book;
import com.pksheldon4.books.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService bookService;


    @Test
    public void testGetListOfBooks() throws Exception {

        Book catcher = setupBooks();

        mvc.perform(get("/books")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].name", is(catcher.getName())));

    }

    private Book setupBooks() {
        List<Book> books = new ArrayList<>();
        Book catcher = new Book("Catcher in the Rye", "A book about Holden.");
        books.add(catcher);

        given(bookService.findAll()).willReturn(books);
        return catcher;
    }
}
