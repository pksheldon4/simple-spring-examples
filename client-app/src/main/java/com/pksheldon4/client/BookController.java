package com.pksheldon4.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final RestTemplate restTemplate;

    @Value("${BOOK_SERVER_URL:http://localhost:8080}")
    private String bookServerUrl;

    @GetMapping("/books")
    public String books() {
        return restTemplate.getForObject(bookServerUrl + "/books", String.class);
    }
}
