package com.pksheldon4.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BooksApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApiApplication.class, args);
	}
}
