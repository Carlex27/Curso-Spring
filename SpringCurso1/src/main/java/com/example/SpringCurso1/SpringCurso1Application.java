package com.example.SpringCurso1;

import com.example.SpringCurso1.entities.Book;
import com.example.SpringCurso1.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class SpringCurso1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringCurso1Application.class, args);
		BookRepository bookRepository = context.getBean(BookRepository.class);

		Book book = new Book(null, "Spring Boot", "Rodrigo Turini", 240, 29.90, LocalDate.of(2020,01,10), true);
		Book book2 = new Book(null, "Spring Boot 2", "Rodrigo Turini", 240, 29.90, LocalDate.of(2020,01,10), true);

		bookRepository.save(book);
		bookRepository.save(book2);

		System.out.println("Books saved");
		System.out.println(bookRepository.findAll().size());

		System.out.println(bookRepository.findById(1L).toString());



	}

}
