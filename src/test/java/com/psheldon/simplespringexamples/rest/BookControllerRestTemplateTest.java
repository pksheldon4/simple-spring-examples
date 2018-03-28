package com.psheldon.simplespringexamples.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.psheldon.simplespringexamples.domain.Book;
import com.psheldon.simplespringexamples.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerRestTemplateTest {

    @LocalServerPort
    private String port;

    private static RestTemplate restTemplate = new RestTemplate();
    private static ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private BookService bookService;

    @Test
    public void testGetListOfBooks() throws Exception {

        setupBooks();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(getRestUrl("/books"), String.class);
        Assert.notNull(responseEntity, "ResponseEntity should not be null.");
        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
        System.out.println(responseEntity.getBody().toString());
        JsonNode root = mapper.readTree(responseEntity.getBody());
        JsonNode name = root.path("name");


    }

    private String getRestUrl(String uri) {
        Assert.notNull(uri, "URI can not be null.");
        return "http://localhost:" + port + uri;
    }

    private Book setupBooks() {

        List<Book> books = new ArrayList<>();
        books.add(new Book("Catcher in the Rye", "A book about Holden."));
        books.add(new Book("The Firm", "A book about Lawyers."));
        given(bookService.findAll()).willReturn(books);
        return books.get(0);
    }
}
